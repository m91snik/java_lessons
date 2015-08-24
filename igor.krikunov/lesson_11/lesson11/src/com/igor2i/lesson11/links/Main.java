package com.igor2i.lesson11.links;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by igor2i on 20.08.15.
 */
public class Main {

    private static Integer incriment(Integer i){
        return ++i;
    }

    private static <T> void appyOper(List<T> list, UnariOper<T> oper){
        for(int i = 0; i < list.size(); i++){
            list.set(i, oper.doOper(list.get(i)));
        };
    }

    public static void main(String args[]){

        List<Integer> integers = Arrays.asList(new Integer[]{1,2,3});
        //Main::incriment
        System.out.println(integers);
        appyOper(integers, Main::incriment);
        System.out.println(integers);


    }
}
