package com.vega.hw7;

import com.vega.hw7.interfaces.OneList;
import com.vega.hw7.interfaces.OneListRelease;
import com.vega.hw7.interfaces.Stek;
import com.vega.hw7.interfaces.StekList;

/**
 * Created by Вася-Вега on 05.08.2015.
 */
public class Main {

    public static void main(String[] args) {

        tryToStek();
        tryToList();

    }

    private static void tryToList() {
        OneList<String> oneList = new OneListRelease<>();
        System.out.println(oneList.checkLength());
        oneList.addFirst("im First!");
        oneList.addFirst("You lie, im First!");
        oneList.addLast("Im Last!");
        oneList.addTo("Just", 2);
        System.out.println(oneList.showThisElemnt());
        oneList.toNext();
        System.out.println(oneList.showThisElemnt());
        oneList.toNext();
        System.out.println(oneList.showThisElemnt());
        oneList.toNext();
        System.out.println(oneList.showThisElemnt());
        oneList.toNext();
        oneList.deleteThisElement();
        oneList.editThisElement("Now IM First again!");
        System.out.println(oneList.showThisElemnt());
        oneList.toNext();
        oneList.toNext();
        oneList.toTop();
        System.out.println(oneList.showThisElemnt());
    }

    private static void tryToStek() {
        Stek<String> stek = new StekList<>();

        stek.addStack("Yuriy");
        stek.addStack("Garzi");
        stek.addStack("Muyri");

        System.out.println(stek.searchElement("Garzi"));

        System.out.println(stek.showStack());
        System.out.println(stek.checkLength());

        System.out.println(stek.getStack());
        System.out.println(stek.checkLength());
        System.out.println(stek.showStack());
    }

}
