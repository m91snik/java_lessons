package com.lexsus.chat;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Lexsus on 28.08.2015.
 */
@Component
public class SharedMap<T,E> {
    private final ConcurrentHashMap<T,E> map;

    public SharedMap() {
        this.map = new ConcurrentHashMap<T,E>();
    }

    public Set<Map.Entry<T,E>> entrySet(){
        return map.entrySet();
    }
    public E put(T key, E value){ return map.put(key, value);}
}
