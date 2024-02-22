package Serveurs;
import java.io.*;
import java.net.*;

public class Server_2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1111);
            System.out.println("Server_2 waiting for client on port 1111...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected to Server_2");

                // Gérer la connexion avec le client
                Server_2Handler handler = new Server_2Handler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Server_2Handler implements Runnable {
    private Socket socket;

    public Server_2Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Recevoir la chaîne du client
            String clientInput = reader.readLine();

            // Supprimer les ';' de la chaîne
            String result = deletePunct(clientInput);

            // Envoyer la chaîne modifiée au client
            writer.println(result);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String deletePunct(String str) {
        return str.replace(";", "");
    }
}
