package com.igor2i.homework.slovar;

import java.util.TreeSet;

/**
 * создание словаря по введенному тексту
 *
 */
class Slovar<E extends String> extends TreeSet<String>{

    private TreeSet<String> slovar = new TreeSet<>();

    @Override
    public boolean add(String str){
        return this.slovar.add(str);
    }

    protected void print(){
        System.out.println("|         Словарь содержит:                           |");

        this.slovar.forEach(System.out::println);

    }


}
