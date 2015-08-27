package com.lexsus.client;

import com.lexsus.server.Message;
import com.lexsus.server.MessageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by LugovoyAV on 26.08.2015.
 */
public class Client {
    int server_port;
    int client_port;
    String ip_address;
    boolean stop;
    private static final Logger logger = LogManager.getLogger(Client.class);

    public Client(int server_port,int client_port,String ip_address){
        this.server_port = server_port;
        this.client_port = client_port;
        this.ip_address = ip_address;
        stop = true;
    }
    protected String getlogin(Scanner scanner){
        if (scanner.hasNext())
            return scanner.next();
        else return null;
    }

    public  void start() {
        Runnable clientReader = ()->{
            stop = false;
            if (!stop)
                logger.info("Client read start thread!");
            while (!stop) {
                try (ServerSocket serverSocket = new ServerSocket(server_port)){
                    serverSocket.setSoTimeout(20000);
                    Socket client = serverSocket.accept();
                    ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                    Message message = (Message) objectInputStream.readObject();
                    if (message.getType() == MessageType.MESSAGE) {
                        System.out.println(message.getText());
                    }
                } catch (ClassNotFoundException | SocketTimeoutException e ) {
                    if (e instanceof SocketTimeoutException)
                        logger.info("Client close by timeout!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable clientWriter = ()->{
            logger.info("Client write start thread!");
            Scanner scanner = new Scanner(System.in);
            String text = "";
            for (; scanner.hasNext(); text = scanner.next()) {
                if ("exit".equals(text)) {
                    stop();
                    return;
                }
                if ("login".equals(text)) {
                    String login = getlogin(scanner);
                    MessageType.LOGIN.sendMessage(ip_address, client_port, login, new Integer(server_port).toString());
                    continue;
                }
                if ("log_chat_on".equals(text)) {
                    MessageType.LOG_FILE_ON.sendMessage(ip_address, client_port, null, null);
                    continue;
                }
                if ("log_chat_off".equals(text)) {
                    MessageType.LOG_FILE_OFF.sendMessage(ip_address, client_port, null, null);
                    continue;
                }
                if (!text.isEmpty())
                    MessageType.MESSAGE.sendMessage(ip_address, client_port, text, null);
            }
        };
        new Thread(clientWriter).start();
        new Thread(clientReader).start();
    }
    public void stop(){
        stop = true;
    }

}
