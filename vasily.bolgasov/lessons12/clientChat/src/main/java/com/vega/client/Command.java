package com.vega.client;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public enum Command {
    CHATLOG("chatlog.txt"),COMMANDCHATSAVE(".savechat"),COMMANDCHATUNSAVE(".stopsavechat"),
    EXIT("exit"),CLOSE("close");

    String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() { return command; }
}
