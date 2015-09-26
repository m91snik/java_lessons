package Client.Producer;

import Utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ClientProducer implements Producer<MessageImpl, UserID> {
    private boolean stop = false;
    private boolean generate = false;
    private Message message;

    public ClientProducer(UserID clientID) {
        System.out.println("What would you like to do: login or registration? (l/r)");
        String answer = "r";
        //TODO: вопрос! если раскоментировать код ниже(для выбора режима работы: ввод логина или регистрация) далее при попытке ввода данных в FormFactory вылетает IOException
        //TODO: я так понимаю, что это потому что мы два раза пытаемся использовать один и тот же System.in, как это обойти? или я не права и какой тогда выход?

        //TODO: do not use System.in in try-with-resources. it should not be closed!
//        try (BufferedReader stdIn = new BufferedReader(
//               new InputStreamReader(System.in));) {
//            answer = stdIn.readLine();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        if ("l".equals(answer)) {
            message = FormFactory.createLoginForm();
        } else if ("r".equals(answer)) {
            message = FormFactory.createRegForm();
        } else {
            System.out.println("Invalid answer. Try again.");
        }
        RegisterForm form = (RegisterForm) message;
        clientID.setName(form.getNickName());
        message.setSender(clientID);
    }

    @Override
    public MessageImpl produce() {
        if (generate)
            message.setType(MessageType.MESSAGE);

        if (message.getType() != MessageType.MESSAGE) {
            generate = true;
        } else {
            try {
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in));
                String input = stdIn.readLine();
                if ((input == null) || ("exit".equals(input))) {
                    stop = true;
                    message.setText("exit"); // for ths purpose: work will stop on a server correct
                } else {
                    if (input.indexOf("deleteMe") == 0) {
                        message.setType(MessageType.DELETE);
                        stop = true;
                    } else if (input.indexOf("about") == 0) {
                        message.setType(MessageType.INFO);
                    }
                    message.setText(input);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (MessageImpl) message;
    }

    @Override
    public boolean isStop() {
        return stop;
    }
}
