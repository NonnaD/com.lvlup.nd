import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            while (true) {
                System.out.println("Server is listening at port 9999");
                Socket inputsocket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputsocket.getInputStream()));

                System.out.println("Accepted connection form " + inputsocket.getRemoteSocketAddress());

                int rByte;
                while ((rByte = reader.read()) != -1) {
                    System.out.print((char) rByte);
                }

            }
        } catch (IOException ioException) {

        }

    }
}
