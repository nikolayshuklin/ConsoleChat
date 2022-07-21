import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {


        Socket socket;

        {
            try {
                socket = new Socket("localhost", 11111);
                DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                while(true){
                    String str = bufferedReader.readLine();
                    os.writeUTF(str);
                    os.flush();
                    if (inputStream != null) System.out.println(inputStream.readUTF());
                }


            } catch (IOException e) {

            }
        }
    }

}
