package socketapp.server;

import socketapp.processing.HashCodeProcessor;
import socketapp.processing.TextProcessor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServerMain {
    public static void main(String[] args) {
        try {
            //TextProcessor processor = new UpperCaseProcessor();
            TextProcessor processor = new HashCodeProcessor();
            ConnectionProcessor connectionProcessor = new TextConnectionProcessor(processor);
            ConnectionManager manager = new ConnectionManager(52000, connectionProcessor);
            manager.start();
        } catch (IOException e) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, "Erro ao iniciar servidor", e);
        }
    }
}

