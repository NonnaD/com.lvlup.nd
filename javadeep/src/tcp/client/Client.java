package tcp.client;


import java.io.*;
import java.net.Socket;

public class Client {

    public Client(String ip, int port) {

        try (Socket socket = new Socket(ip, port)) {
            System.out.println("Client connected");

            try (//create reader to read request from console
                 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 //create writer to write into socket output stream
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                System.out.println("Please provide request");
                String request = "";
                while (!(request = reader.readLine()).equals("")) {
                    writer.write(request);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }


}
