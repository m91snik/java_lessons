package com.igor2i.homework.method.logs;

import java.util.*;

/**
 * Created by igor2i on 07.08.2015.
 */
public class Logs<E extends String> extends ArrayDeque<String> {

    private Deque<E> stackLog = new ArrayDeque<>();

    public void pushLog(E strErr){
        this.stackLog.push(strErr);
    }

    public void allPush(Collection<String> collection){
        if(collection != null) {
            collection.forEach(value -> this.stackLog.push((E) value));
        }
    }

    public E popLog(){
        return this.stackLog.pop();
    }

    public Collection<String> allPop(){
        Collection<String> collection = new ArrayDeque<>();
        this.stackLog.forEach(collection::add);
        return collection;
    }


    public int lenghtL(){
        return this.stackLog.size();
    }

}
