package com.vega.lesson5.interfaces;

/**
 * Created by Вася-Вега on 02.08.2015.
 */
public class BooksSpisok<E> implements Spisok<E> {

    private int length = 0;
    Object[] elementList;

    public BooksSpisok(int length) {
        elementList = new Object[length];
        this.length = length;
    }

    @Override
    public void addItem(E Item) {
        int length = this.length++;
        Object[] newElementList = new Object[this.length];
        for(int i=0;i<length;i++){
            newElementList[i]=elementList[i];
        }
            newElementList[length] = Item;
            elementList = newElementList;
    }

    @Override
    public void deleteItem(int Num) {
        int lenght = this.length--;
        int j=0;
        Object[] newElementList = new Object[this.length];
        for(int i=0;i<lenght; i++){
            if(i!=Num){
                newElementList[j++] = elementList[i];
            }
        }
        elementList = newElementList;
    }

    @Override
    public void updateItem(int Num, E Item) {
        int length = this.length;
        for (int i=0;i<length;i++){
            if(i==Num){
                elementList[i] = Item;
                break;
            }
        }
    }

    @Override
    public E showItem(int Num) {
        return (E)elementList[Num];
    }

    @Override
    public int lengthList() {
        return length;
    }

    @Override
    public void showAll() {
        for(int i=0;i<this.length;i++){
            System.out.println(i+" : "+elementList[i]);
        }
    }

    @Override
    public void addItemTo(int Num, E Item){
        int length = this.length++;
        int j =0;
        Object[] newElementList = new Object[this.length];
        for(int i=0;i<length;i++){
            if(i==Num){
                j=1;
                newElementList[Num] = Item;
            }
            newElementList[i+j] = elementList[i];
        }
        elementList = newElementList;
    }
}
