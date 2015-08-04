package lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public class MainOuter {

    public static void main(String... args) { // назвается VarArgs
        Outer outer = new Outer();
        Outer.NonStaticInner nonStaticInner = outer.new NonStaticInner(); // синтаксис создания НЕ статичного класса

        List<Objects> objects = Arrays.asList(); // asList без аргументов - бессмысленен, т.к. содержит пустой массив
//        objects.get(0); // получим выход за пределы массива, т.к. asList() вернул пустой массив
//        args.length

        for (String str : args) { // здесь ошибки не будет
            System.out.println(args);
        }
    }

    // Чтобы избавить от передачи пустого VarArgs, можно указать передачу хотябы одного параметра
    public void process(String firstOrder, String... ordersIds) { // VarArgs должен быть последним и один
        // почему последний? Кладется на стек? И что?
    }

}
