package socketapp.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Interface que define o contrato para lidar com a comunicação entre o cliente e o servidor,
 * a partir de um socket já conectado. Implementações podem realizar diferentes tipos de
 * comunicação como troca de mensagens, transferência de arquivos, etc.
 *
 * <p>Seguindo os princípios SOLID, essa abstração permite alta coesão, baixo acoplamento e
 * reutilização do código de controle de conexão no cliente.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */

public interface ConnectionHandler {
    void handle(Socket socket) throws IOException;
}