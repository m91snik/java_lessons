package com.gorbachevskaya.streams.serialization;

import java.io.*;
import java.util.zip.DeflaterOutputStream;

/**
 * Created by Ангелина on 18.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("person");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file));

        Person person = new Person("Alex", 12, "qwerty");
//        person.setAge(13);
//        person.setName("Alex");
//        person.setPassword("qwerty");
        objectOutputStream.writeObject(person);


        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(file));
        Person personAfterSerialization = (Person)objectInputStream.readObject();
        System.out.println(person);
    }
}
