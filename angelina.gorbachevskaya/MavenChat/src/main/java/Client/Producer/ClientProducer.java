package Client.Producer;

import Utils.Message;
import Utils.MessageImpl;
import Utils.UserID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ClientProducer implements Producer<MessageImpl, UserID> {
    private boolean stop = false;
    private Message message = new MessageImpl();;

    @Override
    public MessageImpl produce() {
        try {
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
//            System.out.println("Введите сообщение:");
            String input = stdIn.readLine();
            if (input == null) {
                stop = true;
                message.setText("exit"); // for ths purpose: work will stop on a server correct
            } else {
                if ("exit".equals(input)) {
                    stop = true;
                    stdIn.close();
                }
                message.setText(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (MessageImpl)message;
    }

    @Override
    public void setSender(UserID userID) {
        message.setSender(userID);
    }

    @Override
    public boolean isStop() {
        return stop;
    }
}
