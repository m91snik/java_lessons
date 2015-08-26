package ChatUtils;

import Client.ClientID;
import Client.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ангелина on 22.08.2015.
 */
//TODO: it should not be in client. move to some utils package
public class Sender {
    public static void send(Message mes, ClientID toClientID) throws IOException {
        try (Socket socket = new Socket(toClientID.getIp(), Integer.valueOf(toClientID.getPort()));
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ) {
            out.writeObject(mes);
        } catch (UnknownHostException e) {
            System.out.println("Ошибка при передачи сообщения. Неизвестный хост");
        }
    }
}
