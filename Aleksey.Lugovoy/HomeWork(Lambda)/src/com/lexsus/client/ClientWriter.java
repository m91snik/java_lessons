package com.lexsus.client;

import com.lexsus.server.Message;
import com.lexsus.server.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

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
        try(Socket socket = new Socket(address,port)) {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message(MessageType.LOGIN, login);
            objectOutputStream.writeObject(message);
        }

    }
    protected void sendMessage(String text) throws IOException {
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message(MessageType.MESSAGE, text);
            objectOutputStream.writeObject(message);
        }
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
        for (; scanner.hasNext(); text = scanner.next()) {
            if (text.equals("exit"))
                break;
            try {
                if (text.equals("login")) {
                    String login = getlogin(scanner);
                    sendLogin(login);
                    continue;
                }
                if (text.equals("save_chat_on")) {
                    String login = getlogin(scanner);
                    sendLogin(login);
                    continue;
                }
                if (text.equals("save_chat_off")) {
                    String login = getlogin(scanner);
                    sendLogin(login);
                    continue;
                }

                if (!text.isEmpty())
                    sendMessage(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


