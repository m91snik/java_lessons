package Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class MessageImpl implements Message, Serializable{
    private String text;
    private Date date;
    private UserID senderID;

    public MessageImpl() {
    }

    public MessageImpl(String text) {
        this.text = text;
    }

    @Override
    public void setText(String string) {
        this.text = string;
        date = new Date();
//        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");
//        System.out.println(format1.format(date)); //25.02.2013 09:03

    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", senderID=" + senderID +
                '}';
    }

    @Override
    public UserID getSenderID() {
        return senderID;
    }

    @Override
    public void setSender(UserID userID) {
        this.senderID = userID;
    }
}
