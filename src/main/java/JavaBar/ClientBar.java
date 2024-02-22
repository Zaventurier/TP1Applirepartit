package JavaBar;
import java.io.IOException;
import java.net.*;

public class ClientBar {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAdress = InetAddress.getByName("localhost");
            int serverPort = 1234;

            //Envoie requête au serveur

            byte[] requestData = new byte[1];
            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAdress, serverPort);
            socket.send(requestPacket);

            //Reception de la boisson du serveur
            byte [] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
            socket.receive(responsePacket);

            String drink = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Boisson servie : " + drink);

            socket.close();



        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
