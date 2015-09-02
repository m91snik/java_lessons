package com.makedonsky94.socket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by user on 13.08.2015.
 */
//TODO: use log4j instead of this logger
public class ProjectLogger {
    static int counter = 0;
    public static void logMessage(Message msg) {
        System.out.format("Message #%s: %s \n", ++counter, msg.getMessageString());
    }
    public static void logMessage(String msg) {
        System.out.format("Message #%s: %s \n", ++counter, msg);

    }
    public static void log(String string) {
        try {
            Files.write(Paths.get("./src/main/resources/history"), string.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
