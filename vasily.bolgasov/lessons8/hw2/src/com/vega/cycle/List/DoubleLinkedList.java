package com.vega.cycle.List;

/**
 * Created by Вася-Вега on 10.08.2015.
 */
public class DoubleLinkedList<T> implements DoubleLinked<T> {

    private int length = 0;
    private Object[] doubleList;
    private int thisIndex = 0;
    private Integer[] nextSrcIndex = {1};

    @Override
    public void addLast(T element) {

        int length = this.length++;
        Object[] newDoubleList = new Object[this.length];
        for (int i = 0; i < length; i++){
            newDoubleList[i] = doubleList[i];
        }
        newDoubleList[length] = element;

        Integer[] newSrc = new Integer[this.length];
        for (int i = 0; i < length; i++){
            newSrc[i] = nextSrcIndex[i];
        }
        newSrc[length] = this.length;

        nextSrcIndex = newSrc;
        doubleList = newDoubleList;

    }

    @Override
    public void addFirst(T element) {

        int length = this.length++;
        Object[] newDoubleList = new Object[this.length];
        newDoubleList[0] = element;
        for (int i=0; i<length; i++){
            newDoubleList[i+1] = doubleList[i];
        }

        Integer[] newSrc = new Integer[this.length];
        newSrc[0] = 1;
        for (int i=0; i<length; i++){
            newSrc[i+1] = nextSrcIndex[i];
        }

        nextSrcIndex = newSrc;
        doubleList = newDoubleList;

    }

    @Override
    public void goToNext() {

        if(thisIndex>=(length-1)){
            thisIndex = 0;
        }else{
            thisIndex=nextSrcIndex[thisIndex];
        }

    }

    @Override
    public void goToPrev() {

        if(thisIndex==0){
            thisIndex = (length==0? 0 : length-1);
        }else{
            thisIndex--;
        }

    }

    @Override
    public int checkLength() {
        return length;
    }

    @Override
    public T showThis() {
        return (T)doubleList[thisIndex];
    }

    @Override
    public void editThis(T element) {
        doubleList[thisIndex] = element;
    }

    @Override
    public void deleteThis() {

        int length = this.length--;
        Object[] newDoubleList = new Object[this.length];
        int j = 0;
        for (int i=0; i<length; i++){
            if(thisIndex==i){
                j--;
                continue;
            }
            newDoubleList[i+j] = doubleList[i];
        }
        doubleList = newDoubleList;

    }

    @Override
    public void goToFirst() {
        thisIndex = 0;
    }

    @Override
    public void goToLast() {
        thisIndex = (length==0? 0 : length-1);
    }

    public void editNextSrc(Integer id){
        nextSrcIndex[thisIndex] = id;
    }
}
