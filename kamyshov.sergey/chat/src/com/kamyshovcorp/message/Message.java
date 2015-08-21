package com.kamyshovcorp.message;

import java.io.Serializable;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 2L;
    private MessageType messageType;
    private String text;
    private ClientInfo clientInfo;

    public Message(MessageType messageType, String text, ClientInfo clientInfo) {
        this.messageType = messageType;
        this.text = text;
        this.clientInfo = clientInfo;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getText() {
        return text;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }
}
