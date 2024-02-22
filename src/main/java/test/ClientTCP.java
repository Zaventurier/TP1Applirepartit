package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;


        public class ClientTCP {
            public static void main(String[] args) {
                Socket socket = null;

                try {
                    // Créer un socket TCP pour se connecter au serveur
                    socket = new Socket("localhost", 9876);

                    // Lire la réponse du serveur
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String responseMessage = in.readLine();

                    // Afficher la réponse du serveur
                    System.out.println("Réponse du serveur : " + responseMessage);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (socket != null && !socket.isClosed()) {
                            socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
