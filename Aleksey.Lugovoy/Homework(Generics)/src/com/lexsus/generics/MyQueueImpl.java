package com.lexsus.generics;

import java.util.EmptyStackException;

/**
 * Created by LugovoyAV on 06.08.2015.
 */
public class MyQueueImpl<T> implements MyQueue<T> {
    Node first = null;
    Node last = null;

    private static class Node<T>{
        T item;
        Node next;

        Node(Node next, T element) {
            this.item = element;
            this.next = next;
        }
    }
    @Override
    public void enqueue(T o1) {
        Node<T> node = new Node(first,o1);
        if (first==null)
            last = node;
        first = node;
    }

    @Override
    public T dequeue() {
        if (last==null)
            throw new EmptyStackException();
       Node<T> node = first;
       if(first==last)
       {
           first = null;
           last = null;
           return node.item;
       }
        while(node.next!=last){
            node = node.next;
        }
        last = node;
        T item = (T)node.next.item;
        node.next =null;
        return item;
    }

    @Override
    public T peek() {
        if (last==null)
            throw new EmptyStackException();
        Node<T> node = first;
        if(first==last){
           return node.item;
        }
        return (T)last.item;
    }

    @Override
    public int size() {
        Node<T> node = first;
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }
}
