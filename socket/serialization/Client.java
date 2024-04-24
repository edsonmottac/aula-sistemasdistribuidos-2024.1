package serialization;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 5001;
        try (Socket serverSocket = new Socket(serverName, port);
             ObjectOutputStream objectOutput = new ObjectOutputStream(serverSocket.getOutputStream())) {

            Person person = new Person("Alice", 25);
            objectOutput.writeObject(person);
            System.out.println("Sent to server: " + person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
