package com.igor2i.client.prevetstvie;

/**
 * Created by igor2i on 17.08.2015.
 */
public class Prevetstvie {

    private static void prevetstvie(String port){

        System.out.println("|         T-chat client v0.6               |");
        System.out.println("|         "+ port + "                      |");
        System.out.println("|   Команды:                               |");
        System.out.println("|     /pm ник сообщение - personal message |");
        System.out.println("|     /who - список пользователей чата     |");
        System.out.println("|   Для выхода введите -  exit             |");


    }
    public static void getPrevetstvie(String port){
        prevetstvie(port);
    }

}
