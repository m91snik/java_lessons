package com.gorbachevskaya.homework3;

/**
 * Created by Ангелина on 30.07.2015.
 */
public class DoubleLinkedList<T> implements Collecctions {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(){}

        Node(T data) {
            this.data = data;
        }

        Node(Node<T> n) {
            data = n.data;
            next = n.next;
            prev = n.prev;
        }
    }

    private Node<T> root;

    DoubleLinkedList(){}

    DoubleLinkedList(T[] ls) {
        Node<T> root = new Node<T>(ls[0]);
        this.root = root;
        for (int i = 1; i < ls.length; i++) {
            root.next = new Node<T>(ls[i]);
            root.next.prev = root;
            root = root.next;
        }
    }

    @Override
    public void create(int size) {
        Node<T> root = new Node<T>();
        this.root = root;
        for (int i = 1; i < size; i++) {
            root.next = new Node<T>();
            root.next.prev = root;
            root = root.next;
        }
    }

    @Override
    public Object read(int index) {
        Node<T> copy = root;
        for (int i = 0; i < index; i++) {
            copy = copy.next;
        }
        return copy.data;
    }

    @Override
    public void update(int index, Object value) {
        Node<T> copy = root;
        for (int i = 0; i < index; i++) {
            copy = copy.next;
        }
        copy.data = (T)value;
    }

    @Override
    public void delete(Object value) {
        Node<T> copy = root;
        while (copy.data != value) {
            copy = copy.next;
        }
        if (copy.prev != null) {
            copy.prev.next = copy.next;
        }
        else {
            copy.next.prev = null;
            root = copy.next;
        }


        // add check if value isn't exist in list
    }

    void print() {
        System.out.println("Double Linked List:");

        Node<T> copy = root;
        while (copy != null) {
            System.out.println(copy.data);
            copy = copy.next;
        }

    }
}
