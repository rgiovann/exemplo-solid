package socketapp.processing;

/**
 * Classe que implementa o processamento de texto convertendo-o para maiúsculas.
 * <p>
 * Esta classe implementa a interface {@link TextProcessor} e define o método
 * {@link #process(String)} que recebe uma string de entrada e retorna a versão
 * dessa string em maiúsculas, precedida por uma mensagem indicando a operação
 * realizada.
 * </p>
 *
 * @author Giovanni Leopoldo Rozza
 * @version 1.0
 */
public class UpperCaseProcessor implements TextProcessor {

    @Override
    public String process(String input) {

        return "operação: [UPPERCASE] : " + input.toUpperCase();
    }

}

