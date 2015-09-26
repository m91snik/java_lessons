package com.vega.server.connectionOutput;

import com.vega.server.ChatType;
import com.vega.server.Main;
import com.vega.server.service.UserService;
import com.vega.server.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Вася-Вега on 10.09.2015.
 */
public class ConnectionToOne implements ToOne {

    @Override
    public void aboutUser(String[] user, String message) {
        UserService userService = new UserServiceImpl();
        String[] whoSend = message.split(" .SEARCH");
        List findedUser = userService.findUser(whoSend[0]);
        Socket client = null;
        try {
            client = new Socket(user[0], new Integer(user[1]));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            if(findedUser.isEmpty()==true){
                out.println("Not found this user");
            }else {
                out.println(findedUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void countUser(String[] user) {
        Socket client = null;
        try {
            client = new Socket(user[0], new Integer(user[1]));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            int i = 0;
            String users = "";
            for(ListIterator<String[]> itr = Main.outputUsers.listIterator(); itr.hasNext(); i++){
                String[] usersItr = itr.next();
//                i++;
                users += usersItr[2] + "; ";
            }

            out.println("Users in chanel: " + i + ". " + users);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void whisper(String[] user, String message) {
        Socket client = null;
        PrintWriter out;
        String[] whisperMessage = message.split(" .WHISP ");
        for(ListIterator<String[]> itr = Main.outputUsers.listIterator(); itr.hasNext(); ) {
            String[] users = itr.next();
            if (users[2].equals(whisperMessage[0]) || users[2].equals(user[2])) {
                String address = users[0];
                Integer port = new Integer(users[1]);
                try {
                    client = new Socket(address, port);
                    out = new PrintWriter(client.getOutputStream(), true);
                    out.println(user[2] + " .WHISP " + whisperMessage[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void updateUser(String[] user, String meessage) {
        UserService userService = new UserServiceImpl();
        Socket client = null;
        String[] updateRequery = meessage.split(" ");
        boolean accessUpdate = false;
        if (String.valueOf(ChatType.PASSWORD).equals(updateRequery[0])){
            accessUpdate = userService.changePassword(user[2], user[4], updateRequery[2]);
        } else if(String.valueOf(ChatType.NAME).equals(updateRequery[0])){
            accessUpdate = userService.changeName(user[2],user[4],updateRequery[2]);
        }else if (String.valueOf(ChatType.LASTNAME).equals(updateRequery[0])){
            accessUpdate = userService.changeLastname(user[2], user[4], updateRequery[2]);
        }
        try {
            client = new Socket(user[0], new Integer(user[1]));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            if (accessUpdate == true) {
                out.println("Update success!");
            }else {
                out.println("Update fail!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
