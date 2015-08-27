package com.vega.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ListIterator;

/**
 * Created by Вася-Вега on 17.08.2015.
 */
public class NewConnectionInput implements Runnable {

    Socket client;
    int numberUser = ++Main.countUser;
    private static BufferedReader input;
    String inputMessage;
    String[] whoSend;

    public NewConnectionInput(Socket socket) {

        this.client = socket;
    }

    @Override
    public void run() {

        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            whoSend = input.readLine().split("-");
            checkUser(whoSend);

            /*
             * Get message user and save it in buffer
             * Open new Socket for read message and close it
             */

            inputMessage = input.readLine();

            if (inputMessage.equalsIgnoreCase("exit") || inputMessage.equalsIgnoreCase("close")){
                    Main.outputUsers.remove(whoSend);
            }else{
                Main.blockingQueue.put(whoSend[2] + ": " + inputMessage);
                System.out.println("We get: '" + inputMessage + "' from " + whoSend[2]);
                Main.whoSend = numberUser;
            }
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*
     * Check it is new user or not
     */

    private void checkUser(String[] dataUser){
        ListIterator<String[]> itr = Main.outputUsers.listIterator();
        String[] user;
        boolean newUser = true;
        while (itr.hasNext()) {
            user = itr.next();
            if(user[0].equals(dataUser[0]) && user[1].equals(dataUser[1])
                    && user[2].equals(dataUser[2])){
                newUser = false;
            }
        }

        if (newUser == true){
            System.out.println("New connection");
            Main.outputUsers.add(dataUser);
        }

    }

}
