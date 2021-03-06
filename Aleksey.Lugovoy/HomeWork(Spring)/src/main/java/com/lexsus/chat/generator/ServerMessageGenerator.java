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
                        if (authorizationUser(laggedUserService, message.getText(), message.getAdditional()))
                        {
                            sharedMap.put(message.getText(), new ClientInfo(address.toString().substring(1), port));
                            logger.info(String.format("Client login address:%s port:%d", address.toString().substring(1), port));
                        }
                        break;
                    case REGISTER:
                        address = client.getInetAddress();
                        port = message.getSenderPort();
                        String addText = message.getAdditional();
                        saveUser(laggedUserService,message.getText(),getPassword(addText), getSurname(addText), getAge(addText));
                        logger.info(String.format("Client register: login:%s password:%d", address.toString().substring(1), port));
                        break;
                    case MESSAGE:
                        retMessage = message;
                        saver.writeMessage(message);
                        break;
                    case DELETE_USER:
                        deleteUser(laggedUserService, message.getText(), message.getAdditional());
                        break;
                }
            }
            finally{
                client.close();
            }

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
    public static void saveUser(LaggedUserService laggedUserService,String name,String password,String surname,int age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setSurname(surname);
        userEntity.setAge(age);
        UserEntity saveUser = laggedUserService.save(userEntity);
    }

    @Transactional
    public static boolean authorizationUser(LaggedUserService laggedUserService, String name, String password) {

        UserEntity user = laggedUserService.findUser(name);
        if (user!=null) {
            if (user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Transactional
    public static void deleteUser(LaggedUserService laggedUserService,String name,String password) {
        laggedUserService.remove(name,password);
    }

    protected String getPassword(String additionalText){
        int index = additionalText.indexOf(";");
        return additionalText.substring(0,index);
    }

    protected String getSurname(String additionalText){
        int index = additionalText.indexOf(";");
        int indexLast = additionalText.indexOf(";",index+1);
        return additionalText.substring(index+1,indexLast);
    }

    protected int getAge(String additionalText){

        int indexLast = additionalText.lastIndexOf(";");

        return Integer.parseInt(additionalText.substring(indexLast+1,additionalText.length()));
    }
}

