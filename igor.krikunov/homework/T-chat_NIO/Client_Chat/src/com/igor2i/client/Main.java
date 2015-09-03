package com.igor2i.client;

/**
 * Created by igor2i on 13.08.2015.
 */


import com.igor2i.client.Thread.ListenerMes;
import com.igor2i.client.prevetstvie.Prevetstvie;
import com.igor2i.client.scanner.Scanner;

import java.io.*;
import java.net.InetAddress;
public class Main {

    //сервер
    public static String ipAdrrServ = "127.0.0.1";
    public static int port = 5055;

    public static void main(String[] args) throws IOException {

        Prevetstvie.getPrevetstvie(InetAddress.getLocalHost().getHostAddress());

        System.out.println("Введите свой ник:");
        String nick = Scanner.getScan();

        try {
            System.out.println(nick);

            new Thread(new ListenerMes(nick, ipAdrrServ, port)).start();

        //TODO: it makes no sense to catch exception here. just remove try-catch
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
