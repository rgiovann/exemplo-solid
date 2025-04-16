package socketapp.server;

import java.net.Socket;
/**
 * Interface que define o contrato para processamento de conexões de entrada em um servidor.
 * Implementações desta interface encapsulam a lógica específica de tratamento de comunicação
 * com o cliente por meio de um {@link Socket} já conectado.
 *
 * <p>Essa abstração permite que diferentes comportamentos de servidor sejam facilmente
 * plugáveis e reutilizáveis, promovendo extensibilidade e baixo acoplamento conforme os
 * princípios da Inversão de Dependência (DIP) e da Responsabilidade Única (SRP) do SOLID.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public interface ConnectionProcessor {
    void process(Socket connection);
}
