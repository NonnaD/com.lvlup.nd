import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try(Socket socket = new Socket("localhost", 9999)){

            System.out.println("Please provide request");
            //read from cmd
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
           String httpRequest;
            while (!(httpRequest = reader.readLine()).equals("")){
                bufferedWriter.write(httpRequest);
            }
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
