package socketapp.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Implementação de {@link InputReader} que realiza a leitura de dados
 * a partir do console padrão (System.in).
 *
 * <p>Aplica o princípio da Responsabilidade Única (SRP), ao encapsular exclusivamente
 * a lógica de entrada do usuário, e permite substituição por outras fontes de entrada
 * (ex: valores fixos, arquivos, interface gráfica) sem modificar o restante do sistema.</p>
 *
 * <p>Ideal para aplicações interativas em modo texto.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class ConsoleInputReader implements InputReader {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readInput(String prompt) {
        System.out.println(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            Logger.getLogger(ConsoleInputReader.class.getName()).log(Level.SEVERE, "Erro ao ler entrada", e);
            return "";
        }
    }
}
