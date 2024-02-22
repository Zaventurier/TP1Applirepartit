package Client;

import java.io.*;
import java.net.*;

public class ClientTCP {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 9876);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = "Hello from TCP client";
            out.println(message);

            String responseMessage = in.readLine();
            System.out.println("Message reçu du serveur : " + responseMessage);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
