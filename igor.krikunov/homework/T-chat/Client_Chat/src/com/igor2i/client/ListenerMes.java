package com.igor2i.client;

import java.io.PrintWriter;


/**
 * Created by igor2i on 16.08.2015.
 */
public class ListenerMes implements Runnable {

    private PrintWriter out;

    public ListenerMes(PrintWriter out) {
        this.out = out;
    }


    @Override
    public void run() {

        //SendMes.setStop();
        try {
            System.out.println("Введите свой ник:");
            String nick = Scanner.getScan();
            out.println(nick);

            System.out.println("Добро пожаловать в чат " + nick);
            String str = "";
            do {
                str = Scanner.getScan();
                out.println(str);
            }while (!str.equals("exit"));

            out.close();
            SendMes.setStop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
