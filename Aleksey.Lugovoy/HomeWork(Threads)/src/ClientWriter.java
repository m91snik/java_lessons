import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class ClientWriter implements Runnable{
    private String address;
    private int port ;
    protected String getlogin(Scanner scanner){
        if (scanner.hasNext())
            return scanner.next();
        else return null;
    }
    protected void sendLogin(String login) throws IOException {
        Socket socket = new Socket(address,port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(socket.getOutputStream());
        Message message = new Message(MessageType.LOGIN, login);
        objectOutputStream.writeObject(message);

    }
    protected void sendMessage(String text) throws IOException {
        Socket socket = new Socket(address,port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(socket.getOutputStream());
        Message message = new Message(MessageType.MESSAGE, text);
        objectOutputStream.writeObject(message);
    }
   public ClientWriter(String address,int port) throws IOException {
       super();
       this.address = address;
       this.port = port;


   }
    @Override

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        for (;scanner.hasNext();text = scanner.next()) {

            if (text.equals("exit"))
                break;
            if (text.equals("login")) {
                String login = getlogin(scanner);
                try {
                    sendLogin(login);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    if (!text.isEmpty())
                       sendMessage(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
