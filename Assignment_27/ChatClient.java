import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner keyboard = new Scanner(System.in)) {
 
            System.out.println("Connected to chat server.");
            System.out.println("Type 'bye' to end chat.");
 
            while (true) {
                System.out.print("You: ");
                String message = keyboard.nextLine();
                out.println(message);
 
                String reply = in.readLine();
                if (reply == null) {
                    break;
                }
                System.out.println("Server: " + reply);
 
                if (message.equalsIgnoreCase("bye")
                        || reply.equalsIgnoreCase("bye")
                        || reply.equalsIgnoreCase("Goodbye")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
