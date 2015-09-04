package om.petrsulilo.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petr on 23.07.2015.
 */
public class Person {
    String name;
    int age;

    private List validNames = new ArrayList();
    {
        validNames.add("Alice");
        validNames.add("Bob");
        //...
    }

    {
        validNames.add("Alice");
        validNames.add("Bob");
        //...
    }
    public Person()
    {
        super();
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age  = age;
    }

    public  static void main(String[] args)
    {
        Person person = new Person("new name",0);
        System.out.println(person.age);
    }
}
