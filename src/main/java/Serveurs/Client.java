package Serveurs;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Connexion au Server_1
            Socket socket1 = new Socket("localhost", 1111);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            PrintWriter writer1 = new PrintWriter(socket1.getOutputStream(), true);

            // Appel au service de Server_1
            int n = 5; // Exemple : demander une chaîne de 5 chiffres
            writer1.println(n);

            // Récupérer la chaîne générée par Server_1
            String randomString = reader1.readLine();
            System.out.println("Random String from Server_1: " + randomString);

            // Fermer la connexion avec Server_1
            socket1.close();

            // Connexion au Server_2
            Socket socket2 = new Socket("localhost", 2222);
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            PrintWriter writer2 = new PrintWriter(socket2.getOutputStream(), true);

            // Appel au service de Server_2
            writer2.println(randomString);

            // Récupérer la chaîne modifiée par Server_2
            String stringWithoutPunct = reader2.readLine();
            System.out.println("String without Punctuation from Server_2: " + stringWithoutPunct);

            // Fermer la connexion avec Server_2
            socket2.close();

            // Connexion au Server_3
            Socket socket3 = new Socket("localhost", 3333);
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(socket3.getInputStream()));
            PrintWriter writer3 = new PrintWriter(socket3.getOutputStream(), true);

            // Appel au service de Server_3
            writer3.println(stringWithoutPunct);

            // Récupérer la moyenne calculée par Server_3
            int mean = Integer.parseInt(reader3.readLine());
            System.out.println("Mean from Server_3: " + mean);

            // Fermer la connexion avec Server_3
            socket3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
