package com.m91snik.lesson5.anonym;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Valentin on 30.07.2015.
 */
public class Main {

    static class MessagesQueue {

        public interface MessageHandler {
            boolean isApplicable(String message);

            void processMessage(String message);
        }

        private List<String> messages = new ArrayList<>();
        private MessageHandler messageHandler;

        public MessagesQueue(MessageHandler messageHandler) {
            this.messageHandler = messageHandler;
        }

        public void add(String message) {
            messages.add(message);
            if (messageHandler.isApplicable(message)) {
                messageHandler.processMessage(message);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String messagePrefix = scanner.next();
        MessagesQueue.MessageHandler messageHandler = new MessagesQueue.MessageHandler() {
            @Override
            public boolean isApplicable(String message) {
                return message != null
                        && message.startsWith(messagePrefix);
            }

            @Override
            public void processMessage(String message) {
                System.out.println("Processed message " + message);
            }
        };

        MessagesQueue messagesQueue = new MessagesQueue(messageHandler);
        String str=null;
        while((str=scanner.next())!=null){
            messagesQueue.add(str);
        }

//        for (String message = scanner.next(); scanner.hasNext(); ) {
//
//        }
    }
}
