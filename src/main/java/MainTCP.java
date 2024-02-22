import Client.ClientTCP;
import Server.ServerTCP;

public class MainTCP {
    public static void main(String[] args) {
        // Lancer le serveur UDP
        Thread serverThread = new Thread(() -> ServerTCP.main(new String[]{}));
        serverThread.start();

        // Lancer le client UDP
        Thread clientThread = new Thread(() -> ClientTCP.main(new String[]{}));
        clientThread.start();
    }
}
