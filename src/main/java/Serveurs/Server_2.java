package Serveurs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);

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
