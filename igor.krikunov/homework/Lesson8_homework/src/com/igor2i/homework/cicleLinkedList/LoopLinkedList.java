package com.igor2i.homework.cicleLinkedList;


/**
 * LoopLinkedList
 */

class LoopLinkedList {

    private LNode head = null;
    private int numberOfElements = 0;
    private LNode actualElement = null;
    private int index = 0;

    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void insertFirst(Object data) {
        if (!(isEmpty())) {
            index++;
        }
        LNode lNode = new LNode(data, head);
        head = lNode;
        numberOfElements++;
    }

    public void insertAfterActual(Object data) {
        LNode lNode = new LNode(data, actualElement.nextNode);
        actualElement.nextNode = lNode;
        numberOfElements++;
    }

    public boolean deleteFirst() {
        if (isEmpty())
            return false;
        if (index > 0)
            index--;
        head = head.nextNode;
        numberOfElements--;
        return true;
    }

    public boolean deleteActualElement() {
        if (index > 0) {
            numberOfElements--;
            index--;
            LNode listNode = head;
            while (!listNode.nextNode.equals(actualElement))
                listNode = listNode.nextNode;
            listNode.nextNode = actualElement.nextNode;
            actualElement = listNode;
            return true;
        }
        else {
            actualElement = head.nextNode;
            index = 0;
            return deleteFirst();
        }
    }

    public boolean goToNextElement() {
        if (isEmpty())
            return false;
        index = (index + 1) % numberOfElements;
        if (index == 0)
            actualElement = head;
        else
            actualElement = actualElement.nextNode;
        return true;
    }

    public Object getActualElementData() {
        return actualElement.data;
    }

    public void setActualElementData(Object data) {
        actualElement.data = data;
    }

}