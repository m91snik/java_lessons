package com.gorbachevskaya.myGenerics;

public class myStack<T> implements MyDataStruct<T>{

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T element) {
            data = element;
        }
    }

    Node<T> head;

    myStack(){}

    myStack(T[] array) {
        Node<T> tmpRoot = new Node<T>(array[array.length - 1]);
        head = tmpRoot;
        for (int i = array.length - 2; i >= 0 ; i--) {
            Node<T> tmp = new Node<>(array[i]);
            tmpRoot.next = tmp;
            tmpRoot = tmp;
        }
    }

    @Override
    public void push(T element) {
        Node<T> newElem = new Node<>(element);
        newElem.next = head;
        head = newElem;
    }

    @Override
    public T pop() {
        T tmp = head.data;
        head = head.next;
        return tmp;
    }

    @Override
    public void print() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data+"  ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
