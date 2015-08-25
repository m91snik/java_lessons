package com.igor2i.lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by igor2i on 20.08.15.
 */
public class MainFiller {

    private static class Person {

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        private String name;
    }

    public static interface Creater<T> {
        T create(String str);
    }

    private static <T> void fill(List<T> list, int count, Creater<T> creater) {
        for (int i = 0; i < count; i++) {
            list.add(creater.create(UUID.randomUUID().toString()));
        }
    }


    public static void main(String args[]) {

        List<Person> list = new ArrayList<>(10);
        fill(list, 10, Person::new);
        System.out.println(list);


    }

}
