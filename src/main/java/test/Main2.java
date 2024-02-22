package test;

public class Main2 {
    public static void main(String[] args) {
        // Démarrer le serveur TCP dans un thread séparé
        Thread serverThread = new Thread(() -> {
            System.out.println("Démarrage du serveur TCP...");
            ServerTCP.main(null);
        });
        serverThread.start();

        // Attendre un court instant pour que le serveur démarre
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Démarrer le client TCP
        System.out.println("Démarrage du client TCP...");
        ClientTCP.main(null);
    }
}
