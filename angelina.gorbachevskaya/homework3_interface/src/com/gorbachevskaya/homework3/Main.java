package com.gorbachevskaya.homework3;

// �������������� ��������� ���������, � ��������� crud ����������,
// ������� 2 ����������( �� ������ ������� � �� ������ ������),
// ������� ������ ��� ������������ ������ � ���� ����� ���������

public class Main {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Array<Integer> arInt = new Array<>(ints);
        String[] strs = {"Hey", "Hello", "Good morning", "Hi"};
        DoubleLinkedList<String> lsStr = new DoubleLinkedList<>(strs);

        printSecondElem(arInt);
        printSecondElem(lsStr);

    }

    public static void printSecondElem(Collecctions<?> collecctions) {
        System.out.print("The second element of collection is ");
        System.out.println(collecctions.read(1));
    }
}
