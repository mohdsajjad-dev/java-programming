import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Echo server started on port 5001");
            System.out.println("Waiting for client...");
 
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
 
                System.out.println("Client connected.");
                String message = in.readLine();
 
                if (message != null) {
                    System.out.println("Received message: " + message);
                    out.println(message);
                    System.out.println("Echo sent: " + message);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
