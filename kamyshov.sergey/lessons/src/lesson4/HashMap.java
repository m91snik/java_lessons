package lesson4;

/**
 * Created by kamyshov.sergey on 23.07.15.
 */
public class HashMap {
    private int size;

    // один для всех объектов класса HashMap
    // не имеет доступ к полям внешнего (кроме static, т.к. они тоже находятся на уровне класса)
    static class Entry {
        String hash;
        Object data;
    }

    public static void main(String[] args) {
        // static класс можно вызвать так
        HashMap.Entry entry = new HashMap.Entry();
    }
}

// может быть только один public
class B {

}