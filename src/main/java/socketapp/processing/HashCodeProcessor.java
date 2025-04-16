package socketapp.processing;

/**
 * Classe que implementa o processamento de texto calculando o código hash da string de entrada.
 * <p>
 * Esta classe implementa a interface {@link TextProcessor} e define o método
 * {@link #process(String)} que recebe uma string de entrada e retorna a mesma
 * string com seu código hash calculado, precedida por uma mensagem indicando
 * a operação realizada.
 * </p>
 *
 * @author Giovanni Leopoldo Rozza
 * @version 1.0
 */
public class HashCodeProcessor implements TextProcessor {

    @Override
    public String process(String input) {

        return "operação: [HASCHODE] : " +   input + " [" + String.valueOf(input.hashCode())+"]";
    }

}
