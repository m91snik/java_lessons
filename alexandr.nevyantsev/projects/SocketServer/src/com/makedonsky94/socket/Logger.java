package com.makedonsky94.socket;

/**
 * Created by user on 13.08.2015.
 */
public class Logger {
    static int counter = 0;
    public static void log(Message msg) {
        System.out.format("Message #%s: %s \n", ++counter, msg.getMessageString());
    }
    public static void log(String msg) {
        System.out.format("Message #%s: %s \n", ++counter, msg);
    }
}
