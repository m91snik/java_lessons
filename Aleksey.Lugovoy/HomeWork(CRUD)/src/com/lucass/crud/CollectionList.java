package com.lucass.crud;

import java.util.LinkedList;

/**
 * Created by LugovoyAV on 30.07.2015.
 * use linked list
 */
public class CollectionList implements IOperations {
    Node first = null;
    Node last = null;
    int size = 0;
    private class Node{
        double item;
        Node next;
        Node prev;

        Node(Node prev, double element, Node next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void Add(double Value) {
        Node node;
        if (last==null)
        {
            node = new Node(null,Value,null);
            first = node;
            last = node;
        }
        else
        {
            node = new Node(last,Value,null);
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public void Insert(double Value, int Position) {
        if (Position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node node = GetNode(Position);
        Node new_node = new Node(node.prev,Value,node);
        node.prev = new_node;
        if (node==first){
            first = new_node;
        }
        size++;
    }

    @Override
    public double GetAt(int Position) {
        if (Position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node node = GetNode(Position);
        return node.item;
    }

    @Override
    public void SetAt(double Value, int Position) {
        if (Position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node node = GetNode(Position);
        node.item = Value;
    }

    @Override
    public void Delete(int Position) {
        if (Position>=size){
            throw new IllegalArgumentException("error argument");
        }
        Node node = GetNode(Position);
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
    public int GetSize() {
        return size;
    }

    private Node GetNode(int index){
        Node x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

}
