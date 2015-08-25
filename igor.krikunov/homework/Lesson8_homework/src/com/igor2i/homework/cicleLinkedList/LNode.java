package com.igor2i.homework.cicleLinkedList;

import java.util.Objects;

/**
 * Created by igor2i on 09.08.2015.
 */
class LNode {

    protected Object data;
    protected LNode nextNode;

    protected LNode(Object data,LNode nextNode) {
        this.nextNode = nextNode;
        this.data = data;
    }



}
