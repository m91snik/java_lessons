import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anry on 23.07.2015.
 */
public class Person {
    String name;
    int age;
    // о умолчанию
    // public Person () {
    // super ();
    // }
    static int counter = 0;
    private List validNames = new ArrayList();
    {
        validNames.add("alice");
        validNames.add("bob");
    }

    public Person(String name, int age) {
        counter++;

        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) {
        Person person = new Person("jhvbjv", 0);
        System.out.println(person.age);
        System.out.println(counter);
    }
}

