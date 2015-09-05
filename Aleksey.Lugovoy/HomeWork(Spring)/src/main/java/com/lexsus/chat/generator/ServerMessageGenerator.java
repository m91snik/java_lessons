package com.lexsus.chat.generator;

import com.lexsus.chat.SharedMap;
import com.lexsus.chat.base.LaggedUserService;
import com.lexsus.chat.entity.UserEntity;
import com.lexsus.chat.saver.MessageSaver;
import com.lexsus.chat.spring.java.ClientInfo;
import com.lexsus.chat.spring.java.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ServerMessageGenerator implements MessageGenerator<Message> {

    private static final Logger logger = LogManager.getLogger(ServerMessageGenerator.class);
    @Autowired
    MessageSaver<Message> saver;

    @Autowired
    private SharedMap<String, ClientInfo> sharedMap;
    @Autowired
    LaggedUserService laggedUserService ;

    @Override
    public Message generate() {
        try (ServerSocket serverSocket = new ServerSocket(11005/*server_port*/)) {
            serverSocket.setSoTimeout(20000);
            Socket client = serverSocket.accept();
            Message retMessage = null;
            try (ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream())) {
                Message message = (Message) objectInputStream.readObject();
                InetAddress address;
                int port;
                switch (message.getType()) {
                    case LOGIN:
                        address = client.getInetAddress();
                        port = message.getSenderPort();
                        sharedMap.put(message.getText(), new ClientInfo(address.toString().substring(1), port));
                        logger.info(String.format("Client login address:%s port:%d", address.toString().substring(1), port));
                        break;
                    case REGISTER:
                        address = client.getInetAddress();
                        port = message.getSenderPort();
                        //sharedMap.put(message.getText(), new ClientInfo(address.toString().substring(1), port));
                        saveUser(laggedUserService,message.getText(),message.getAdditional());
                        logger.info(String.format("Client register: login:%s password:%d", address.toString().substring(1), port));

                        break;
                    case MESSAGE:
                        retMessage = message;
                        saver.writeMessage(message);
                        break;
                }
            }
            //TOD: move it to finally
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

    @Transactional
    public static void saveUser(LaggedUserService laggedUserService,String name,String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);

        UserEntity saveUser = laggedUserService.save(userEntity);
    }
}

