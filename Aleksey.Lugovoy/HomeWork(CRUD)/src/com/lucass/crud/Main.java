package com.lucass.crud;

/**
 * Created by Lexsus on 29.07.2015.
 */
public class Main {
    public static void main(String[] args)
    {
        CollectionList list = new CollectionList();
        for (int i = 0; i < 10; i++) {
            list.Add(i);
        }

        double x = list.GetAt(3);
        list.SetAt(300,3);
        list.Delete(2);
        for (int i = 0; i < list.GetSize(); i++) {
            System.out.println(list.GetAt(i));
        }

        CollectionList list2 = new CollectionList();
        for (int i = 0; i < 20; i++) {
            list2.Add(i);
        }

        for (int i = 0; i < list2.GetSize(); i++) {
            System.out.println(list2.GetAt(i));
        }

        for (int i = 0; i < list.GetSize(); i++) {
            System.out.println(list.GetAt(i));
        }

        list2.Insert(100,0);
        for (int i = 0; i < list2.GetSize(); i++) {
            System.out.println(list2.GetAt(i));
        }

        list.Insert(200,0);

        for (int i = 0; i < list.GetSize(); i++) {
            System.out.println(list.GetAt(i));
        }
    }
}
