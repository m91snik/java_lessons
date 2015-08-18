package com.jay.Serialization;

import java.io.*;

/**
 * Created by User on 18.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("person");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        //"neck"
        Person person = new Person();
        person.setName("NICK");
        person.setAge(11);
        person.setPassword("123");
        objectOutputStream.writeObject(person);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Person afterserialization = (Person)objectInputStream.readObject();

        System.out.println(afterserialization);

        objectOutputStream.close();
    }
}
