package Utils;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface Message {
    public UserID getSenderID();
    public String getText();
    public void setText(String string);
    public String toString();
    public void setSender(UserID userID);
}
