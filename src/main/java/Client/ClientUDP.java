package Client;

import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            //Partie envoie du message au serveur
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            String message = "Hello from UDP client";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            clientSocket.send(sendPacket);

            //Partie reception du serveur

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);
            String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Message reçu du serveur : " + responseMessage);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
