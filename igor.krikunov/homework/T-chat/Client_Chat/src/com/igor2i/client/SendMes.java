package com.igor2i.client;

import java.io.BufferedReader;
import java.net.ServerSocket;

/**
 * Created by igor2i on 16.08.2015.
 */
public class SendMes implements Runnable {

    private BufferedReader in;

    public SendMes(BufferedReader in){
        this.in = in;
    }

    private static boolean stoped = false;
    public static void setStop() {
        stoped = true;
    }

    @Override
    public void run() {

        try{

            while (!stoped){
                String str = in.readLine();
                System.out.println(str);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
