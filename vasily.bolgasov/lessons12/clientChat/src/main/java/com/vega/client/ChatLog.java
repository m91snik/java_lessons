package com.vega.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public class ChatLog {

    private boolean saveChat = false;
    private Path path;
    static Date date = new Date();

    public ChatLog(String path) {
        this.path = Paths.get(path);
    }

    /*
     * Save in file all next message
     */

    public void startSave(String path){
        saveChat = true;
        File file = new File(path);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            Files.write(this.path, (date.toString() + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Stop save message in file
     */

    public void stopSave(){ saveChat = false; }

    public void doChatLog(String message) {
        if (saveChat==true) {
            try {
                Files.write(path, Arrays.asList(message), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
