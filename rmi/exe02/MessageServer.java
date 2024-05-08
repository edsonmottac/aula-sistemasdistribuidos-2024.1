package exe02;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MessageServer implements Message {
    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println("Mensagem recebida do cliente: " + message);
    }

    public static void main(String[] args) {
        try {
            MessageServer server = new MessageServer();
            Message stub = (Message) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Message", stub);
            System.out.println("Servidor pronto para receber mensagens.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
