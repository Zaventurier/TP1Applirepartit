package TCP_UDP.Server;

import java.io.*;
import java.net.*;

public class ServerTCP {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);

            System.out.println("Serveur TCP en attente...");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message = in.readLine();
                System.out.println("Message reçu du client : " + message);

                String responseMessage = "Hello World";
                out.println(responseMessage);

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}