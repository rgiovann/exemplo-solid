package socketapp.processing;

/**
 * Interface para processamento de texto.
 * Implementações dessa interface devem fornecer um método que recebe uma string de entrada
 * e retorna uma string processada de acordo com a lógica de processamento especificada.
 *
 * <p>Essa abstração favorece testes automatizados, reutilização e desacoplamento de código,
 * em conformidade com os princípios da Inversão de Dependência (DIP) e da Responsabilidade Única (SRP).</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public interface TextProcessor {
    String process(String input);
}
