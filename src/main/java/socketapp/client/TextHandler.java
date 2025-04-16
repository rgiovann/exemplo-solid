package socketapp.client;

import socketapp.input.InputReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Implementação de {@link ConnectionHandler} responsável por realizar uma troca
 * de mensagens de texto com o servidor. Envia uma mensagem digitada pelo usuário e
 * exibe a resposta recebida.
 *
 * <p>Aplica os princípios da Responsabilidade Única (SRP) e da Inversão de Dependência (DIP)
 * ao isolar a lógica de comunicação textual e delegar a entrada ao componente {@link InputReader}.</p>
 *
 * <p>Indicada para cenários de eco de mensagens ou transformação de texto pelo servidor.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class TextHandler implements ConnectionHandler {

    private final InputReader inputReader;

    public TextHandler(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public void handle(Socket socket) throws IOException {
        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            String message = inputReader.readInput("Digite uma mensagem:");
            output.writeUTF(message);
            String response = input.readUTF();
            System.out.println("Resposta do servidor: " + response);
        }
    }
}
