package com.vega.lesson5.main;

import com.vega.lesson5.interfaces.BooksSpisok;
import com.vega.lesson5.interfaces.Spisok;

/**
 * Created by Вася-Вега on 02.08.2015.
 */
public class Main {

    public static void main(String[] args) {

        Spisok<String> spisok = new BooksSpisok<>(1);
        spisok.addItem("Looky");
        spisok.addItem("Luky");
        spisok.addItem(null);
        spisok.addItem("Mary");
        spisok.showAll();
        System.out.println("Length Spisok: " + spisok.lengthList());
        spisok.deleteItem(3);
        spisok.updateItem(0, "Luize");
        System.out.println(spisok.showItem(1) + ";");
        spisok.addItemTo(2,"Luizi");
        spisok.showAll();
    }

}
