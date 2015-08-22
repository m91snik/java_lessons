package Client;

import java.io.Serializable;

/**
 * Created by Ангелина on 22.08.2015.
 */
public class Message implements Serializable{
    private static final long serialVersionUID = 4L;
    private String text;
    private ClientID clientID;

    public Message(String text, ClientID clientID) {
        this.clientID = clientID;
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
