package simple_connection;
import java.io.*;
import java.net.*;

public class SimpleSocketClientExample {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);
            
            OutputStream os = socket.getOutputStream();
            String mensagem = "Olá, Servidor\n";
            os.write(mensagem.getBytes());

            InputStream is = socket.getInputStream();
            byte[] bs = new byte[13];
            is.read(bs);
            String txt = new String(bs);
            System.out.println("Recebido a mensagem: " + txt);

            is.close();
            os.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}





// import java.io.*;
// import java.net.*;
// import java.util.Scanner;

// public class SimpleSocketClientExample {
//     public static void main(String[] args) {
//         try {
//             Socket socket = new Socket("localhost", 5001);

//             OutputStream os = socket.getOutputStream();
//             String mensagem = "Olá, Servidor\n";

//             PrintWriter writer = new PrintWriter(os, true);
//             Scanner scanner = new Scanner(System.in);
//             System.out.println("Conectado ao servidor. Digite suas mensagens:");
//             while (scanner.hasNextLine()) {
//                 String messageToSend = scanner.nextLine();
               
//                 if (messageToSend.equals("sair")) {
//                     break;
//                 } else {
//                     os.write((messageToSend + "\n").getBytes());
//                 }
//             } 
//             System.out.println("\nFinalziado: Aguardando retorno do servidor\n");
            

//             InputStream is = socket.getInputStream();
//             byte[] bs = new byte[13];
//             is.read(bs);
//             String txt = new String(bs);
//             System.out.println("Recebido a mensagem: " + txt);

//             is.close();
//             os.close();
//             socket.close();
//         } catch (UnknownHostException e) {
//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }}



