import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5001);
             BufferedReader in = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner keyboard = new Scanner(System.in)) {
 
            System.out.println("Connected to echo server.");
            System.out.print("Enter message: ");
            String message = keyboard.nextLine();
 
            out.println(message);
            String reply = in.readLine();
            System.out.println("Server reply: " + reply);
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
