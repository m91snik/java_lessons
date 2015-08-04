package anonym;


/**
 * Created by Anry on 30.07.2015.
 */

import java.util.*;

public class Main {
    static class MessageQueue {
        public interface MessageHandler {
            boolean isApplicable ()
        }

        private List<String> message = new ArrayList<>();

        public void add(String message) {
            message.add(message);
            if (messageHandler.is)
        }
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] strs = scanner.next().split(" ");
//        String strToFind = scanner.next();
//
//        Integer[] ints = {-1, 10, 20, 1, 2, 3, 4, 5};
//        int i = Arrays.binarySearch(ints, -1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });
//        System.out.println(i);
    }


}
