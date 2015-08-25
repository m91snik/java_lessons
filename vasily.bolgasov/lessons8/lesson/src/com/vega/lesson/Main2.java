package com.vega.lesson;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Veg'Zul on 06.08.2015.
 */
public class Main2 {

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);

//        for(Integer i : lst){
//            System.out.println(lst);
//            if(i==20){
//                lst.remove(new Integer(20));
//            }
//        }

//        for(Iterator<Integer> iter = lst.iterator(); iter.hasNext();){
//            Integer next = iter.next();
//            if(next == 10){
//                iter.remove();
//                continue;
//            }
//            System.out.println(next);
//        }

//        Spliterator<Integer> spliterator = lst.spliterator();
//        while (spliterator.tryAdvance(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        })){
//
//        }

//        int i = Collections.binarySearch(lst, 20, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1,o2);
//            }
//        });
//        System.out.println(i);

        Collections.sort(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });

        System.out.println(lst);

    }

}
