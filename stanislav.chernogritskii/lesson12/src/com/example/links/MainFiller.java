package com.example.links;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by stanislav on 20.08.15.
 */
public class MainFiller {

    public static interface Creator<T> {
        T create(String str);
    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static <T> void fill(List<T> list, int count, Creator<T> creator) {
        for (int i = 0; i < count; i++) {
            list.add(creator.create(UUID.randomUUID().toString()));
        }
    }

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(10);
        fill(persons, 10, Person::new);
        System.out.println(persons);
    }
}
