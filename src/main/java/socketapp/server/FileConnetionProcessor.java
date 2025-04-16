package socketapp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Implementação de {@link ConnectionProcessor} responsável por processar requisições
 * de arquivos feitas por clientes. Recebe o nome do arquivo via socket, localiza o arquivo
 * no diretório base e envia seu conteúdo em formato binário para o cliente.
 *
 * <p>Aplica os princípios da Responsabilidade Única (SRP), ao isolar a lógica de
 * transferência de arquivos, e da Inversão de Dependência (DIP), ao permitir que o
 * {@link ConnectionManager} delegue o processamento sem conhecer os detalhes da implementação.</p>
 *
 * <p>Indicado para construção de servidores simples de compartilhamento de arquivos.</p>
 *
 * @author Giovanni L. Rozza
 * @version 1.0
 */
public class FileConnetionProcessor implements ConnectionProcessor {

    private final Path baseDirectory;

    public FileConnetionProcessor(Path baseDirectory) {
        this.baseDirectory = baseDirectory;
    }

    @Override
    public void process(Socket connection) {
        try (DataInputStream input = new DataInputStream(connection.getInputStream());
             DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {

            String fileName = input.readUTF();
            Path filePath = baseDirectory.resolve(fileName);

            if (Files.exists(filePath)) {
                byte[] fileBytes = Files.readAllBytes(filePath);
                output.writeInt(fileBytes.length);
                output.write(fileBytes);
            } else {
                output.writeInt(0); // arquivo não encontrado
            }

        } catch (IOException e) {
            Logger.getLogger(FileConnetionProcessor.class.getName()).log(Level.SEVERE, "Erro ao transferir arquivo", e);
        }
    }
}

