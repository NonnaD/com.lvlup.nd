package tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class ServerThread extends Thread{
    Socket socket;

    ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Process the request...");
            int rByte;
            while ((rByte = reader.read()) != -1) {
                System.out.print((char) rByte);
            }
            socket.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}