package serialization;

import java.io.*;

/**
 * Created by stanislav on 18.08.15.
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("person");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));

        Person person = new Person("Nick", 25, "qwerty");
        person.setName("Nick");
        person.setAge(25);
        person.setPassword("qwerty");
        objectOutputStream.writeObject(person);

        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));

        Person afterSerialization = (Person)objectInputStream.readObject();

        System.out.println(afterSerialization);
    }
}
