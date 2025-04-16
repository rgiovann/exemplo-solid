package socketapp.client;

import socketapp.input.ConsoleInputReader;
import socketapp.input.InputReader;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;


/**
 * Classe principal do cliente que estabelece a conexão com o servidor e delega
 * o processamento da comunicação a uma implementação de {@link ConnectionHandler}.
 *
 * <p>Ao seguir o princípio da Inversão de Dependência (DIP) do SOLID, esta classe
 * não conhece os detalhes da comunicação — apenas gerencia o ciclo de vida do socket.
 * Isso permite reutilização e extensão sem necessidade de alteração no código principal.</p>
 *
 * <p>Ideal para aplicações cliente que desejam flexibilidade no protocolo de comunicação.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class ClientMain {

    private final ConnectionHandler handler;

    public ClientMain(ConnectionHandler handler) {
        this.handler = handler;
    }

    public void connect(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            handler.handle(socket);
        } catch (ConnectException e) {
            System.err.println("Não foi possível conectar ao servidor: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro na comunicação: " + e.getMessage());
        }
    }


    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleInputReader();
        //Path destino = Paths.get("downloads");
        //Files.createDirectories(destino);

        // Escolha de implementação conforme necessidade
        //ClientConnectionHandler handler = new FileDownloadHandler(reader, destino);
        ConnectionHandler handler = new TextHandler(reader);

        new ClientMain(handler).connect("localhost", 52000);
    }
}


