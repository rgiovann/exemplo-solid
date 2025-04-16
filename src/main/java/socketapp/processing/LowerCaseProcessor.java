package socketapp.processing;

/**
 * Classe que implementa o processamento de texto convertendo-o para minúsculas.
 * <p>
 * Esta classe implementa a interface {@link TextProcessor} e define o método
 * {@link #process(String)} que recebe uma string de entrada e retorna a versão
 * dessa string em minúsculas, precedida por uma mensagem indicando a operação
 * realizada.
 * </p>
 *
 * @author Giovanni Leopoldo Rozza
 * @version 1.0
 */
public class LowerCaseProcessor implements TextProcessor {

    @Override
    public String process(String input) {

        return "operação: [UPPERCASE] : " + input.toLowerCase();
    }

}
