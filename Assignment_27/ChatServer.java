import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
 
public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Chat server started on port 5000");
            System.out.println("Waiting for client...");
 
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 Scanner keyboard = new Scanner(System.in)) {
 
                System.out.println("Client connected.");
                String message;
 
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
 
                    if (message.equalsIgnoreCase("bye")) {
                        out.println("Goodbye");
                        break;
                    }
 
                    System.out.print("Server reply: ");
                    String reply = keyboard.nextLine();
                    out.println(reply);
 
                    if (reply.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
                System.out.println("Chat ended.");
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
