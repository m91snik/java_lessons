package com.igor2i.lesson10.serilization;

import com.sun.deploy.uitoolkit.impl.awt.AWTPluginEmbeddedFrameWindow;

import java.io.*;

/**
 * Created by igor2i on 18.08.15.
 */
public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {

        File file = new File("123");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        Person person = new Person();

        person.setName("Igor");
        person.setAge(23);
        person.setPasswd("secret");

        objectOutputStream.writeObject(person);

        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

        Person afterSer = (Person)objectInputStream.readObject();

        System.out.println(afterSer.toString());

    }
}
