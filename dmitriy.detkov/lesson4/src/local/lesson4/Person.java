package local.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static final String constant = "abc";
    static int counter = 0;

    static {
        counter++;
    }

    final String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void Print() {
        System.out.println(this.name + "\t" + this.age + "\t" + "Constant :" + this.constant );
    }

    protected int getCounter(){
        return counter;
    }
}
