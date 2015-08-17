package com.igor2i.client;

/**
 * Created by igor2i on 13.08.2015.
 */

import com.igor2i.client.prevetstvie.Prevetstvie;

import java.io.*;
import java.net.*;


public class Main {


    public static void main(String[] args) throws IOException {


        String ipAdrr = "127.0.0.1";
        int port = 5055;


        try {

            Socket connectSocket = new Socket(ipAdrr, port);
            Prevetstvie.getPrevetstvie(connectSocket.getLocalSocketAddress().toString());

            PrintWriter out = new PrintWriter(connectSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));


            new Thread(new ListenerMes(out)).start();
            new Thread(new SendMes(in)).start();


        } catch (UnknownHostException e) {

            System.out.println("Host не найден: " + ipAdrr);

        } catch (IOException e) {

            System.out.println("Не удалось присоединиться: " + ipAdrr);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
