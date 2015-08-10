package com.vega.hw7.interfaces;

/**
 * Created by Вася-Вега on 06.08.2015.
 */
public class OneListRelease<T> implements OneList<T> {

    private int length = 0;
    Object[] listElements = new Object[0];
    private int thisIndex = 0;

    @Override
    public void addLast(T element) {

        int length = this.length++;
        Object[] newListElements = new Object[this.length];
        for (int i=0; i<length; i++){
            newListElements[i] = listElements[i];
        }
        newListElements[length] = element;
        listElements = newListElements;
    }

    @Override
    public void addFirst(T element) {

        int length = this.length++;
        Object[] newListElements = new Object[this.length];
        newListElements[0] = element;
        for (int i=0; i<length; i++){
            newListElements[i+1] = listElements[i];
        }
        listElements = newListElements;

    }

    @Override
    public void addTo(T element, int id) {

        int length = this.length++;
        Object[] newListElements = new Object[this.length];
        int j = 0;
        for (int i=0; i<length; i++){
            if(i==id){
                j++;
                newListElements[i] = element;
            }
            newListElements[i+j] = listElements[i];
        }
        listElements = newListElements;

    }

    @Override
    public void toTop() {
        thisIndex = 0;
    }

    /**
     * It goes to the top if you exceeded the size
     */

    @Override
    public void toNext() {
        thisIndex++;
        if(thisIndex==length){
            thisIndex = 0;
        }
    }

    @Override
    public T showThisElemnt() {
        return (T)listElements[thisIndex];
    }

    @Override
    public void deleteThisElement() {
        if (this.length>0){
            length = this.length--;
            Object[] newListElements = new Object[this.length];
            int j=0;
            for (int i=0;i<length; i++){
                if(i == thisIndex){
                    j--;
                    continue;
                }
                newListElements[i+j] = listElements[i];
            }
            listElements = newListElements;
        }
    }

    @Override
    public void editThisElement(T element) {
        listElements[thisIndex] = element;
    }

    @Override
    public int checkLength() {
        return length;
    }
}
