package com.lexsus.server;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Created by Lexsus on 19.08.2015.
 */
public enum MessageType {
    LOGIN{
        @Override
        public void sendMessage(String address, int port,String text,String additional) {
            internalSendMessage(MessageType.LOGIN, address, port, text, additional);
        }
    }, MESSAGE,
    LOG_FILE_ON{
        @Override
        public void sendMessage(String address, int port,String text,String additional) {
            internalSendMessage(MessageType.LOG_FILE_ON, address, port, text,additional);
        }
    },
    LOG_FILE_OFF{
        @Override
        public void sendMessage(String address, int port,String text,String additional) {
            internalSendMessage(MessageType.LOG_FILE_OFF, address, port, text,additional);
        }
    };

    public void sendMessage(String address, int port,String text,String additional) {
        internalSendMessage(MessageType.MESSAGE,address,port,text,additional);
    }

    private static void internalSendMessage(MessageType type, String address, int port,String text,String additional){
        try (Socket socket = new Socket(address, port)) {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message(type, text,additional);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
};
