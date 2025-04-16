package socketapp.processing;

/**
 * Classe que implementa o processamento de texto invertendo a sequência de caracteres.
 * <p>
 * Esta classe implementa a interface {@link TextProcessor} e define o método
 * {@link #process(String)} que recebe uma string de entrada e retorna a versão
 * dessa string com os caracteres invertidos, precedida por uma mensagem indicando
 * a operação realizada.
 * </p>
 *
 * @author Giovanni Leopoldo Rozza
 * @version 1.0
 */
public class ReverseTextProcessor implements TextProcessor {
    public String process(String input) {
        return "operação: [REVERSE] : " + new StringBuilder(input).reverse();
    }
}
