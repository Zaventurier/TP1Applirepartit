package Serveurs;

public class main {
    public static void main(String[] args) {
        // Lancer le serveur_1
        Thread serverThread = new Thread(() -> Server_1.main(new String[]{}));
        serverThread.start();

        // Lancer le serveur_2
        Thread serverThread2 = new Thread(() -> Server_2.main(new String[]{}));
        serverThread2.start();

        // Lancer le serveur_3
        Thread serverThread3 = new Thread(() -> Server_3.main(new String[]{}));
        serverThread3.start();

        // Lancer le clientBar
        Thread clientThread = new Thread(() -> Client.main(new String[]{}));
        clientThread.start();

    }
}
