package com.gorbachevskaya.lesson8hw;

/**
 * Created by Ангелина on 07.08.2015.
 */

public class DoubleLinkedList<T> implements Collections {
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

    // indx должен быть больше единицы
    void createLoopList(T[] ls, int indx) {
        Node<T> root = new Node<T>(ls[0]);
        this.root = root;
        for (int i = 1; i < ls.length; i++) {
            root.next = new Node<T>(ls[i]);
            root.next.prev = root;
            root = root.next;
        }

        root = this.root;
        int i = 0;
        while (i != indx) {
            root = root.next;
            i++;
        }
        root.next = root.prev.prev;

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

    boolean findLoop() {
        boolean flag = true;
        Node<T> tmp, cur;
        cur = root;

        while (flag && (cur.next != null) ) {
            cur = cur.next;

            tmp = cur;
            while (tmp.prev != null) {
                if (tmp.prev == cur.next) {
                    flag = false;
                    break;
                }
                tmp = tmp.prev;
            }

        }
        return !flag;
    }

}






