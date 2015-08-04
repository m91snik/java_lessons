package com.igor2i.calc.methods;

/**
 * Created by igor2i on 17.07.2015.
 */
public class Prevetstvie {

    private static void prevetstvie(){

        System.out.println("|         Console Calc v0.6                         |");
        System.out.println("|   Для справки введите -  help                     |");
        System.out.println("|   Для выхода введите -  exit                      |");
    }
    private static void help(){
        System.out.println("|  Возможности:                                     |");
        System.out.println("|   + , - , * , / , n! , n^a, ( )                   |");
        System.out.println("|  Возможности для матриц:                          |");
        System.out.println("|   + , *, % (транспонирование)                     |");
        System.out.println("|  Пример:                                          |");
        System.out.println("|    -((54-2) - 87) - 28 / (2 * 5)^2 + 5! - (4+2)   |");
        System.out.println("|  или так, для матриц:                             |");
        System.out.println("|      matrix[(32;1)(21;5)] + matrix[(10;5)(20;3)]  |");
        System.out.println("|   Для выхода введите -  exit                      |");
    }
    public static void getHelp(){
        help();
    }
    public static void getPrevetstvie(){
        prevetstvie();
    }



}
