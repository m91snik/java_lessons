package com.makedonsky94.main;

import com.makedonsky94.main.impl.CustomListImpl;
import com.makedonsky94.main.impl.CustomStackImpl;

/**
 * Created by Sasha on 06.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        CustomListImpl<String> list = new CustomListImpl<>();
        list.add("Bob");
        list.add("George");
        list.add("Melissa");
        list.add("John");
        System.out.println(list.toString());

        CustomStackImpl<Integer> stack = new CustomStackImpl<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.format("%s %s %s", stack.pop(), stack.pop(), stack.pop());
        try {
            stack.pop();
        } catch(StackSizeException ex) {
            ex.printStackTrace();
        }
    }
}
