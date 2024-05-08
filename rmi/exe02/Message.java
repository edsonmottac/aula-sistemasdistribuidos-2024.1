package exe02;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote {
    void sendMessage(String message) throws RemoteException;
}


