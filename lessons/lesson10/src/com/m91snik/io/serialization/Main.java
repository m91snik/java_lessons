package com.m91snik.io.serialization;

import java.io.*;

/**
 * Created by Valentin on 18.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        File file = new File("person");
//        ObjectOutputStream objectOutputStream =
//                new ObjectOutputStream(new FileOutputStream(file));
//
//        Person person = new Person("Nick", 27, "qwerty");
//        person.setName("Nick");
//        person.setAge(27);
//        person.setPassword("qwerty");
//        objectOutputStream.writeObject(person);
//        objectOutputStream.close();

        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file));
        Person afterSerialization =
                (Person) objectInputStream.readObject();
        System.out.println(afterSerialization);

        System.out.println(afterSerialization.getCounter());

    }
}
