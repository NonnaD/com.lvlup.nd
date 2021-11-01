package tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is up and listening port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " redirected to " + socket.getLocalSocketAddress());

                //Create new thread for each request
                new ServerThread(socket).start();
            }
        }catch (IOException i){
            i.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}