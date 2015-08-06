package com.vega.lesson5.main.anonym;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Veg'Zul on 30.07.2015.
 */
public class Main {

    static class MessageQueque{

        public interface MessageHandler{

            boolean isApplicable(String message);

            void processMessage(String message);

        }

        private List<String> messages = new ArrayList<>();
        private MessageHandler messageHandler;

        public MessageQueque(MessageHandler messageHandler){
            this.messageHandler = messageHandler;
        }

        public void add(String message){
            messages.add(message);
            if(messageHandler.isApplicable(message)){
                messageHandler.processMessage(message);
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] ints = {-1,1,2,3,4,5,10,20,31,51};
//        Integer[] ints = {51,31,20,10,5,4,3,2,1,-1};
//        int i = Arrays.binarySearch(ints, 3, new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2){
//                return o2-o1;
//            }
//
//        });
//        System.out.println(i);

        Scanner scanner = new Scanner(System.in);
        final String messagePrifex = scanner.next();

        MessageQueque messageQueque = new MessageQueque(new MessageQueque.MessageHandler(){
            @Override
            public boolean isApplicable(String message){
                return message != null && message.startsWith(messagePrifex);
            }

            @Override
            public void processMessage(String message){
                System.out.println("Processed message"+message);
            }
        });

        String str = null;
        while((str=scanner.next())!= null){
            messageQueque.add(str);
        }

//        for(String message = scanner.next();scanner.hasNext(); ){
//
//        }


    }

}
