package com.lexsus.chat.saver;

import com.lexsus.chat.spring.java.Message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Lexsus on 31.08.2015.
 */
public class FileMessageSaver implements MessageSaver<Message> {
    @Override
    public void writeMessage(Message message) {
    final String file_name="history.txt";

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
