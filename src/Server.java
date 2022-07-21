import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) throws Exception{
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(11111);
                Socket socket = serverSocket.accept();
                new SocketThread(socket).run();
            }
        } catch (Exception e){

        }
    }
}
