package com.lexsus.chat.generator;

import com.lexsus.chat.SharedMap;
import com.lexsus.chat.saver.MessageSaver;
import com.lexsus.chat.spring.java.ClientInfo;
import com.lexsus.chat.spring.java.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ServerMessageGenerator implements MessageGenerator<Message> {

    private static final Logger logger = LogManager.getLogger(ServerMessageGenerator.class);
    MessageSaver<Message> saver;

    public ServerMessageGenerator(MessageSaver<Message> saver) {
        this.saver = saver;
    }

    @Autowired
    private SharedMap<String, ClientInfo> sharedMap;

    @Override
    public Message generate() {
        try (ServerSocket serverSocket = new ServerSocket(11005/*server_port*/)) {
            serverSocket.setSoTimeout(20000);
            Socket client = serverSocket.accept();
            Message retMessage = null;
            try (ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream())) {
                Message message = (Message) objectInputStream.readObject();
                switch (message.getType()) {
                    case LOGIN:
                        InetAddress address = client.getInetAddress();
                        int port = Integer.parseInt(message.getAdditional());
                        sharedMap.put(message.getText(), new ClientInfo(address.toString().substring(1), port));
                        logger.info(String.format("Client login address:%s port:%d", address.toString().substring(1), port));
                        break;
                    case MESSAGE:
                        retMessage = message;
                        saver.writeMessage(message);
                        break;
                }
            }
            client.close();
            return retMessage;
        } catch (ClassNotFoundException | SocketTimeoutException e) {
            if (e instanceof SocketTimeoutException)
                logger.info("ServerChat close by timeout!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

