package exe02;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class MessageClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Message msg = (Message) registry.lookup("Message");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a mensagem para o servidor: ");
            String message = scanner.nextLine();
            scanner.close();

            msg.sendMessage(message);
            System.out.println("Mensagem enviada ao servidor.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

