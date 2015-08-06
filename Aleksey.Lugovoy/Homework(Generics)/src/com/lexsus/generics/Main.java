package com.lexsus.generics;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Lexsus on 05.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        MyStackImpl<Integer> stack = new MyStackImpl<Integer>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int f = stack.pop();
        f = stack.pop();
        f = stack.pop();
        f = stack.pop();

        MyQueueImpl<Integer> queue = new MyQueueImpl<>();
        int size = queue.size();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        size = queue.size();

        int z = queue.dequeue();
        z = queue.dequeue();
        z = queue.peek();
        z = queue.dequeue();
        z = queue.dequeue();
        z = queue.dequeue();
        }
}
