package test;

import java.net.*;
import java.io.*;

public class ServerTCP {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // Créer un socket TCP à l'écoute sur le port 9876
            serverSocket = new ServerSocket(9876);

            // Attendre la connexion d'un client
            Socket clientSocket = serverSocket.accept();

            // Envoyer le message "Hello World" au client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello World");

            System.out.println("Message envoyé au client.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
