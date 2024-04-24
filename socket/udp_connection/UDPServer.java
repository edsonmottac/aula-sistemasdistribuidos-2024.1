package udp_connection;

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws IOException {
        // Buffer para receber/enviar dados
        byte[] buf = new byte[256];
        
        // Cria um socket UDP e se liga a uma porta
        try (DatagramSocket socket = new DatagramSocket(4445)) {
            System.out.println("Server is running on port 4445");
            
            // Sempre ativo para ouvir mensagens
            while (true) {
                // Prepara para receber dados
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                
                // Converte a mensagem para String
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("From Client: " + received);
                
                // Envie a resposta
                String msg = "Received";
                buf = msg.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
            }
        }
    }
}
