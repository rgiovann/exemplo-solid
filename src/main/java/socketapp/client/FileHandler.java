package socketapp.client;

import socketapp.input.InputReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Implementação de {@link ConnectionHandler} responsável por solicitar a transferência
 * de um arquivo ao servidor e armazená-lo localmente no diretório especificado.
 *
 * <p>Essa classe aplica os princípios da Responsabilidade Única (SRP) e da Inversão de Dependência (DIP)
 * do SOLID, ao encapsular exclusivamente a lógica de download de arquivos e delegar a leitura
 * de entrada ao componente {@link InputReader}.</p>
 *
 * <p>Reutilizável em qualquer cliente que deseje realizar requisições de arquivos via socket.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class FileHandler implements ConnectionHandler {

    private final InputReader inputReader;
    private final Path destinationDir;

    public FileHandler(InputReader inputReader, Path destinationDir) {
        this.inputReader = inputReader;
        this.destinationDir = destinationDir;
    }

    @Override
    public void handle(Socket socket) throws IOException {
        try (DataOutputStream output = new DataOutputStream(socket.getOutputStream());
             DataInputStream input = new DataInputStream(socket.getInputStream())) {

            String fileName = inputReader.readInput("Nome do arquivo para baixar:");
            output.writeUTF(fileName);

            int size = input.readInt();
            if (size <= 0) {
                System.out.println("Arquivo não encontrado.");
                return;
            }

            byte[] fileData = new byte[size];
            input.readFully(fileData);
            Files.write(destinationDir.resolve(fileName), fileData);

            System.out.println("Arquivo salvo em: " + destinationDir.resolve(fileName));
        }
    }
}

