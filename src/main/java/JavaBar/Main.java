package JavaBar;

public class Main {
    public static void main(String[] args) {
        // Lancer le serveur UDP
        Thread serverThread = new Thread(() -> ServerBar.main(new String[]{}));
        serverThread.start();

        // Lancer le client UDP
        Thread clientThread = new Thread(() -> ClientBar.main(new String[]{}));
        clientThread.start();

    }
}
