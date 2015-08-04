package com.igor2i.lesson6.anonyme;

import java.util.*;

/**
 * Created by igor2i on 30.07.15.
 */
public class Main {

    static class Qwen{

        public interface MessageRand{
            boolean isApp(String massage);

            void processMessage(String message);

        }

        private ArrayList<String> message = new ArrayList<>();
        private MessageRand messageRand;

//
//        public int add(String message){
//            message.add(message);
//            if (messageRand.isApp(message)){
//                messageRand.processMessage(message);
//            }
//        }
    }

    static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            return o2 -o1;
        }
    }

    static final IntComparator INT_COMPARATOR =new IntComparator();

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.next().split("|");

        String strToFind= scanner.next();

//        MessageQuere messageQuere = new Qwen(new Qwen.MessageRand()){
//
//        }
//
//
//        int i = Arrays.binarySearch(ints, 2, INT_COMPARATOR);
//
//        System.out.println(i);

    }

}
