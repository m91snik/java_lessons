package com.gorbachevskaya.myGenerics;

/**
 * Created by Ангелина on 09.08.2015.
 */
public class myQueue<T> implements MyDataStruct<T>{
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T element) {
            data = element;
        }
    }

    Node<T> first;
    Node<T> last;

    myQueue() {}

    myQueue(T[] array) {
        first = new Node<>(array[0]);
        last = first;
        for (int i = 1; i < array.length; i++) {
            push(array[i]);
        }
    }

    @Override
    public void push(T element) {
//        Node<T> tmp = new Node<>(element);
        last.next = new Node<>(element);
        last = last.next;
    }

    @Override
    public T pop() {
        T data = first.data;
        first = first.next;
        return data;
    }

    @Override
    public void print() {
        Node<T> tmp = first;
        while (tmp != null) {
            System.out.print(tmp.data+"  ");
            tmp = tmp.next;
        }
    }
}
