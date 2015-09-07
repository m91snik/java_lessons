package Client;

import java.net.UnknownHostException;

/**
 * all - all online users
 * about username - info about user with nick username
 * deleteMe username password - delete you from database
 * save - save history
 * exit - exit from chat
 * @username text message - send text message only to user with nick username
 * In my App each user must have original nickname
 */

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        new Client().startSession();
    }
}
