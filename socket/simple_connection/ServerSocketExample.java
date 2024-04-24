package simple_connection;
import java.io.*;
import java.net.*;

public class ServerSocketExample {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5001);
            System.out.println("Servidor rodando...");
            Socket s = ss.accept();
            InputStream is = s.getInputStream();
            byte[] bs = new byte[14];
            is.read(bs);
            String txt = new String(bs);
            System.out.println("Recebido a mensagem: " + txt + " de " 
                + s.getInetAddress().getHostAddress());
            
            OutputStream os = s.getOutputStream();
            String mensagem = "Olá, Cliente";
            os.write(mensagem.getBytes());
            System.out.println("Enviado a mensagem: " + mensagem + " para " 
                + s.getInetAddress().getHostAddress());
            os.close();
            is.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }}}
