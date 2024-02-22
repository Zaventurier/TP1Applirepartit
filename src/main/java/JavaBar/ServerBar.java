package JavaBar;

import java.net.*;
import java.util.Random;


public class ServerBar {
        public static void main(String[] args) {
            DatagramSocket socket = null;

            try {
                // Créer un socket UDP à l'écoute sur le port 9876
                socket = new DatagramSocket(9876);

                System.out.println("Serveur du Bar \"5 lettres\" en attente de commandes...");

                while (true) {
                    // Attendre la réception d'une commande du client
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);

                    // Récupérer l'adresse IP et le port du client
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();

                    // Générer une boisson aléatoire
                    String drink = generateRandomDrink();

                    // Envoyer la boisson au client
                    byte[] sendData = drink.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    socket.send(sendPacket);

                    System.out.println("Boisson \"" + drink + "\" envoyée au client.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            }
        }

        private static String generateRandomDrink() {
            // Liste des boissons avec 5 lettres
            String[] drinks = {"sirop", "vodka", "tonic", "cidre", "bière", "punch", "porto"};

            // Générer une boisson aléatoire
            Random random = new Random();
            int index = random.nextInt(drinks.length);

            return drinks[index];
        }
    }
