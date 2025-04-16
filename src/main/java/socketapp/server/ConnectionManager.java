package socketapp.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar as conexões de entrada no servidor via socket.
 * Aceita conexões em uma porta definida e delega o processamento a uma implementação
 * de {@link ConnectionProcessor}, executando cada conexão em uma nova thread.
 *
 * <p>Segue o princípio da Responsabilidade Única (SRP), ao separar a lógica de escuta de conexões
 * da lógica de processamento, e também o princípio da Inversão de Dependência (DIP),
 * ao depender de uma abstração para o processamento.</p>
 *
 * <p>Essa arquitetura favorece extensibilidade, permitindo diversos comportamentos de servidor
 * com mínima alteração de código.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class ConnectionManager {
    private final ServerSocket serverSocket;
    private final ConnectionProcessor processor;

    public ConnectionManager(int port, ConnectionProcessor processor) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.processor = processor;
    }
    /*
     * O método run() não aparece explicitamente no código revisado como aparecia na classe original Servidor,
     * mas sua funcionalidade está presente no método process da classe TextConnectionProcessor, que é executado
     * em uma thread por meio de um Runnable (via lambda ou implementação explícita).
     * A ausência de um método chamado run() é intencional, pois a refatoração priorizou modularidade e desacoplamento.
     */
    public void start() {
        Logger.getLogger(ConnectionManager.class.getName()).info("Servidor iniciado na porta " + serverSocket.getLocalPort());
        while (true) {
            try {
                Logger.getLogger(ConnectionManager.class.getName()).info("Aguardando conexão...");
                Socket connection = serverSocket.accept();
                Thread thread = new Thread(() -> processor.process(connection));
                thread.start();
            } catch (IOException e) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, "Erro ao aceitar conexão", e);
            }
        }
    }
}