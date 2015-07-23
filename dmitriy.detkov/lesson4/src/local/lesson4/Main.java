package local.lesson4;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Dmitry", 29);
        person.Print();

        System.out.print(person.getCounter());
    }
}
