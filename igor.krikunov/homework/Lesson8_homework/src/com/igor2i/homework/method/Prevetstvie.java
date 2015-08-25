package com.igor2i.homework.method;

/**
 * Created by igor2i on 07.08.2015.
 */
public class Prevetstvie {

    private static void prevetstvie(){

        System.out.println("|         Homework 8                                  |");
        System.out.println("|   Для выбора задания введите соответствующую цифру  |");
        System.out.println("|   1 - Словарь                                       |");
        System.out.println("|   2 - Цикл                                          |");
        System.out.println("|   3 - Визуальное TreeMap                            |");
        System.out.println("|   Для справки введите -  help                       |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }
    private static void help(){
        System.out.println("|   Для выбора задания введите соответствующую цифру  |");
        System.out.println("|   1 - Словарь                                       |");
        System.out.println("|   2 - Цикл                                          |");
        System.out.println("|   3 - Визуальное TreeMap                            |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }

    private static void prevetstvieS(){
        System.out.println("|   Словарь                                           |");
        System.out.println("|                                                     |");
        System.out.println("|   Для справки введите -  help                       |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }
    private static void helpS(){
        System.out.println("|  Возможности:                                       |");
        System.out.println("|   ввод слов через пробел                            |");
        System.out.println("|  Пример:                                            |");
        System.out.println("|   Ростов Москва Волгодонск Таганрог                 |");
        System.out.println("|                                                     |");
        System.out.println("|   Для ввыода словаря введите - print                |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }

    private static void prevetstvieLLL(){
        System.out.println("|   Цикл                                              |");
        System.out.println("|                                                     |");
        System.out.println("|   Для справки введите -  help                       |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }
    private static void prevetstvieVTM(){
        System.out.println("|   Визуальное TreeMap                                |");
        System.out.println("|                                                     |");
        System.out.println("|   Для справки введите -  help                       |");
        System.out.println("|   Для выхода введите -  exit                        |");
    }
    public static void getHelp(){
        help();
    }
    public static void getHelpS(){
        helpS();
    }

    public static void getPrevetstvie(){
        prevetstvie();
    }
    public static void getPrevetstvieS(){
        prevetstvieS();
    }
    public static void getPrevetstvieLLL(){
        prevetstvieLLL();
    }
    public static void getPrevetstvieVTM(){
        prevetstvieVTM();
    }

}
