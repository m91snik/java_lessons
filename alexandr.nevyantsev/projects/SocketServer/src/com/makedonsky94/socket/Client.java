package com.makedonsky94.socket;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Sasha on 18.08.2015.
 */
public class Client {

    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLACK = "\u001B[30m";
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_GREEN = "\u001B[32m";
//    public static final String ANSI_YELLOW = "\u001B[33m";
//    public static final String ANSI_BLUE = "\u001B[34m";
//    public static final String ANSI_PURPLE = "\u001B[35m";
//    public static final String ANSI_CYAN = "\u001B[36m";
//    public static final String ANSI_WHITE = "\u001B[37m";

    public Client(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
        this.nick = "unknown";
        this.color = "\u001B[3" + (this.hashCode() % 7 + 1) + "m";
    }

    private final BufferedWriter bufferedWriter;

    private String nick;
    private String color;

    public void write(Message message) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message.getColor());
        stringBuilder.append(message.getNick());
        stringBuilder.append(": ");
        stringBuilder.append(ANSI_RESET);
        stringBuilder.append(message.getMessageString());
        String writeMessage = stringBuilder.toString();
        bufferedWriter.write(writeMessage);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getColor() {
        return color;
    }
}
