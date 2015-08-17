package com.igor2i.server.prevetstvie;

/**
 * Created by igor2i on 16.08.2015.
 */
public class Prevetstvie {

    private static void prevetstvie(String port){

        System.out.println("|         T-chat server v0.1         |");
        System.out.println("|         "+ port + "            |");
        System.out.println("|   Для выхода введите -  shutdown   |");


    }
    public static void getPrevetstvie(String port){
        prevetstvie(port);
    }

}
