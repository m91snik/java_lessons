package com.lexsus.chat.consumer;

import com.lexsus.chat.processor.MessageProcessor;
import com.lexsus.chat.spring.java.Message;
import com.lexsus.chat.spring.java.MessageType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Lexsus on 30.08.2015.
 */

public class ClientConsumer  implements Consumer<Message>{
    private static final Logger logger = LogManager.getLogger(ClientConsumer.class);
    final int server_port = 11007;
    @Autowired
    protected MessageProcessor messageProcessor;
    @Override
    public void consume() throws ConsumerException {
        try (ServerSocket serverSocket = new ServerSocket(server_port)) {
            serverSocket.setSoTimeout(20000);
            Socket client = serverSocket.accept();
            try (ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream())) {
                Message message = (Message) objectInputStream.readObject();

                if (message.getType() == MessageType.MESSAGE) {
                    messageProcessor.process(message);
                }
            }
        } catch (ClassNotFoundException | SocketTimeoutException e ) {
            if (e instanceof SocketTimeoutException)
                logger.info("Client close by timeout!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ClientConsumer(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

}
