package ad;

import java.io.*;

/**
 * Created by HP on 18.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        File file = new File("person");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(file));

        Person person = new Person();
        person.setName("Nick");
        person.setAge(27);
        person.setPassword("qwerty");

        objectOutputStream.writeObject(person);
        objectOutputStream.close();

    }
}
