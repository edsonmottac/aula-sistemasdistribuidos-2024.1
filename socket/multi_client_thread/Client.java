package multi_client_thread;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 5001;

        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor. Digite suas mensagens:");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Resposta do servidor: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não foi possível obter E/S para a conexão com " +
                    hostName);
            System.exit(1);
        }
    }
}
