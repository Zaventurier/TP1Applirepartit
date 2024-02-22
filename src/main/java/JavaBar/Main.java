package JavaBar;

public class Main {
    public static void main(String[] args) {
        // Lancer le serveurBar
        Thread serverThread = new Thread(() -> ServerBar.main(new String[]{}));
        serverThread.start();

        // Lancer le clientBar
        Thread clientThread = new Thread(() -> ClientBar.main(new String[]{}));
        clientThread.start();

    }
}
