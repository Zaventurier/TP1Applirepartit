import Client.ClientUDP;
import Server.ServerUDP;

public class Main {
    public static void main(String[] args) {
        // Lancer le serveur UDP
        Thread serverThread = new Thread(() -> ServerUDP.main(new String[]{}));
        serverThread.start();

        // Lancer le client UDP
        Thread clientThread = new Thread(() -> ClientUDP.main(new String[]{}));
        clientThread.start();
    }
}
