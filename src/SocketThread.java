import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SocketThread extends Thread {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputStream = new DataInputStream(this.socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(this.socket.getOutputStream());
            while (true) {
                String string = inputStream.readUTF();
                if (string == "Пока")
                System.out.println("Клиент покинул чат... " + string);
                        else System.out.println("Клиент: " + string);
                outputStream.writeUTF("Сервер получил Ваше сообщение :" + string);
                outputStream.flush();
            }


        } catch (Exception e) {

        }
    }
}
