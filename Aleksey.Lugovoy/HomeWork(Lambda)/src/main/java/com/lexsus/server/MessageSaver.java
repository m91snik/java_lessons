package com.lexsus.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Created by LugovoyAV on 27.08.2015.
 */
public class MessageSaver {
    final static String file_name="history.txt";
    public static void writeMessage(/*String login,*/Message message){
        Path src = Paths.get(file_name);
        try {
            //Files.write(src, String.format("_____%s______\n", login).getBytes(), StandardOpenOption.APPEND);
            if (!Files.exists(src))
                Files.createFile(src);
            Files.write(src,message.toString().getBytes() , StandardOpenOption.APPEND);
            Files.write(src,"\n".getBytes() , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
