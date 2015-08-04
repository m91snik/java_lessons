package lesson4;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public class Outer {

    private int privateOuterCounter;
    public static int outerStaticCounter;
    public int outerCounter;

    public static void main(String[] args) {

    }

    static class StaticInner {
        static String version = "1.0"; // может иметь static поля
        //        int staticCounter = outerCounter; // не имеет доступа к внешнему классу. Кроме static полей или методов
        int staticCounter = outerStaticCounter;

        static {
            // может иметь static блоки
        }
        enum Alphabet {
            A, B, C // можно иметь enum
        }
    }

    // создает файла типа .class для каждого внутреннего НЕстатического класса. Ссылка типа Outer$Inner.class
    class NonStaticInner {
        int counter = privateOuterCounter; // имеет доступ даже к приватным полям

//        static {} // не может иметь static блока или static переменных

//        enum Alphabet {} // не может содержать enum

//        static String version; // не может имень static поля
    }

}
