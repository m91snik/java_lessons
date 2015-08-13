


import com.lucass.misc.MyLinkedList;

import java.util.*;


/**
 * Created by Lexsus on 05.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Double> list = new MyLinkedList<>();

        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        list.add(6.0);
        list.addwithcycle(7.0);
        boolean ok = list.havecycle();

        Scanner scanner = new Scanner(System.in);
        String text = "";
        HashSet <String> set = new HashSet<>();
        for (;scanner.hasNext();text = scanner.next()) {
            if (text.equals("exit"))
                break;
            if (!text.isEmpty() && !set.contains(text))
                set.add(text);

        }

        for (String elem:set){
            System.out.println(elem);
        }

    }


}

