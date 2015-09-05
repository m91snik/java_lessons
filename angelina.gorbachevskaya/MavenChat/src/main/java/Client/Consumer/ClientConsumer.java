package Client.Consumer;

import Utils.HistoryWriter;
import Utils.Message;

import java.util.ArrayList;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ClientConsumer implements Consumer<Message> {
    ArrayList<String> listMessages = new ArrayList<>();

    public ClientConsumer() {
    }

    @Override
    public void consume(Message message) {
        System.out.println("Received message: " + message.toString());

        if ("save".equals(message.getText())) {
            HistoryWriter.write(listMessages, message.getSenderID().getName());
        } else {
            listMessages.add(message.toString());
        }
//        System.out.println("In Processor::process "+message.getText());
    }
}
