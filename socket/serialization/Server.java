package serialization;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5001;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             ObjectInputStream objectInput = new ObjectInputStream(clientSocket.getInputStream())) {

            System.out.println("Server is running on port " + port);

            Person person = (Person) objectInput.readObject();
            System.out.println("Received from client: " + person);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

