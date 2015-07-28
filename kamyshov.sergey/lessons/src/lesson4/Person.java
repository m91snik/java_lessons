package lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamyshov.sergey on 23.07.15.
 */
public class Person {
    String name;
    int age;

    private List validNames = new ArrayList();

    // вызывается перед конструктором
    // лучше инициализировать в static блоке, потому что конструкторов может быть несколько
    {
//        validNames.add("Alice");
//        validNames.add("Bob");
        // можем обращаться даже к private методам
        // можно вызывать циклы for(;;)
    }

    // можеть быть несколько static блоков
    {
        //...
    }

    // static - один для всех классов
    // будет вызван при первой загрузке класса (один раз)
    static {
        //...
    }

    public Person() {
        // можем вызвать другой конструктор
//        this("Name");
    }

    public Person(String name) {
        this.name = name;
    }

    // Создания конструктора НЕ АТОМАРНАЯ операция
    // 1. выделяется память
    // 2. вызывается коструктор
    // Проблема: может быть использован без инициализации при многопоточности
    public Person(String name, int age) {
        super(); // по-умолчанию уже есть. вызывает конструктор родителя
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("Bob", 20);
        System.out.println(person.age);
    }

}
