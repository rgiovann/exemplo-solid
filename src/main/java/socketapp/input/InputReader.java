package socketapp.input;

/**
 * Interface que define o contrato para leitura de entrada textual de um usuário ou sistema.
 * Permite abstrair a origem dos dados, viabilizando diferentes estratégias de entrada
 * como console, arquivos, valores fixos, interfaces gráficas, entre outros.
 *
 * <p>Essa abstração favorece testes automatizados, reutilização e desacoplamento de código,
 * em conformidade com os princípios da Inversão de Dependência (DIP) e da Responsabilidade Única (SRP).</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public interface InputReader {
    String readInput(String prompt);
}

