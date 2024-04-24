package udp_connection;

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws IOException {
        // Buffer para receber/enviar dados
        byte[] buf = new byte[256];
        // Endereço IP do servidor
        InetAddress address = InetAddress.getByName("localhost");
        // Porta do servidor
        int port = 4445;
        
        // Cria um socket UDP
        try (DatagramSocket socket = new DatagramSocket()) {
            String msg = "Hello, Server!";
            buf = msg.getBytes();
            
            // Cria um pacote para enviar ao servidor
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
            
            // Prepara para receber a resposta
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            // Converte a resposta para String
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("From Server: " + received);
        }
    }
}
