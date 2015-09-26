package com.vega.client;

/**
 * Created by Вася-Вега on 06.09.2015.
 */
public enum Command {
    CHATLOG("chatlog.txt"),COMMANDCHATSAVE(".savechat"),COMMANDCHATUNSAVE(".stopsavechat"),
    EXIT("exit"),CLOSE("close"),HELP(".help"),
    HELPINFO(" All command in chat: \r\n" +
            "` .ONLINE` - check users online;\r\n" +
            "`exit`/`close` - close program;\r\n" +
            "`.savechat` - save all next message in file;\r\n" +
            "`.stopsavechat` - stop save message in file;\r\n" +
            "`<userlogin> .WHISP <message>` - send message user;\r\n" +
            "`<userlogin> .SEARCH` - chheck data this user;\r\n" +
            "`PASSWORD/NAME/LASTNAME .UPDATE` - update your data;\r\n" +
            "`.help` - show this message."
    );

    String command;

    Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() { return command; }
}
