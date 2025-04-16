package socketapp.server;

import socketapp.processing.TextProcessor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Implementação de {@link ConnectionProcessor} responsável por processar conexões
 * baseadas em troca de mensagens de texto. Recebe um texto do cliente, aplica uma transformação
 * definida por um {@link TextConnectionProcessor}, e envia o resultado de volta ao cliente.
 *
 * <p>Segue os princípios da Responsabilidade Única (SRP), ao isolar a lógica de
 * transformação textual, e da Inversão de Dependência (DIP), ao depender de uma abstração
 * para o processamento do texto.</p>
 *
 * <p>É uma solução reutilizável para servidores que oferecem serviços de modificação textual,
 * como conversão para maiúsculas, inversão, remoção de acentos, etc.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class TextConnectionProcessor implements ConnectionProcessor {
    private final TextProcessor textProcessor;

    public TextConnectionProcessor(TextProcessor textProcessor) {
        this.textProcessor = textProcessor;
    }

    @Override
    public void process(Socket connection) {
        try (DataInputStream input = new DataInputStream(connection.getInputStream());
             DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {
            String inputText = input.readUTF();
            String processedText = textProcessor.process(inputText);
            output.writeUTF(processedText);
        } catch (IOException e) {
            Logger.getLogger(TextConnectionProcessor.class.getName()).log(Level.SEVERE, "Erro ao processar conexão", e);
        }
    }


}
