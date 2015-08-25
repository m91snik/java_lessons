package com.lexsus.generics;

import java.util.EmptyStackException;


/**
 * Created by Lexsus on 05.08.2015.
 */

public class MyStackImpl<T> implements MyStack<T> {
    Node first = null;

    private static class Node<E>{
         E item;
        Node next;

        Node(Node next, E element) {
            this.item = element;
            this.next = next;
        }
    }
    @Override
    public void push(T o1) {
        Node<T> node = new Node(first,o1);
        node.next = first;
        first = node;
    }

    @Override
    public T pop() {
        Node<T> node;
        if (first==null)
            throw new EmptyStackException();
        node = first;
        first = first.next;
        return node.item;
    }
}
