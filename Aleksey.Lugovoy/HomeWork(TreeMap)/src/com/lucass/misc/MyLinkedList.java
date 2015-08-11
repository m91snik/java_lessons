package com.lucass.misc;

import com.lucass.misc.MyList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by LugovoyAV on 06.08.2015.
 */
public class MyLinkedList<T> implements MyList<T> {
    Node first = null;
    Node last = null;
    int size = 0;



    private class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void add(T value) {
        Node<T> node;
        if (last==null)
        {
            node = new Node<T>(null,value,null);
            first = node;
            last = node;
        }
        else
        {
            node = new Node<T>(last,value,null);
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addwithcycle(T value) {
        Node<T> node;
        if (last==null)
        {
            node = new Node<T>(null,value,null);
            first = node;
            last = node;
        }
        else
        {
            node = new Node<T>(last,value,first.next);
            last.next = first.next;
            last = node;

        }
        size++;
    }
    public boolean havecycle() {
        Node<T> node = first;
        HashSet<Node<T>> set = new HashSet<>();
        while(node!=null) {
            if (set.contains(node))
                return true;
            set.add(node);
            node=node.next;
       }
        return false;
    }

    @Override
    public void insert(T value, int position) {
        if (position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node<T> node = GetNode(position);
        Node<T> new_node = new Node<T>(node.prev,value,node);
        node.prev = new_node;
        if (node==first){
            first = new_node;
        }
        size++;
    }

    @Override
    public T get(int position) {
        if (position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node<T> node = GetNode(position);
        return node.item;
    }

    @Override
    public void set(T value, int position) {
        if (position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node<T> node = GetNode(position);
        node.item = value;
    }

    @Override
    public void remove(int position) {
        if (position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node<T> node = GetNode(position);
        if (node.prev!=null)
            node.prev.next = node.next;
        else
            first = node.next;
        if (node.next!=null)
            node.next.prev = node.prev;
        else
            last = node.prev;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> GetNode(int index){
        Node<T> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

}