package com.server.util;

import com.server.Server;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * Created by Anry on 05.09.2015.
 */
@Component
public class NewUserCheckUtil {
    public static boolean newUserCheck(com.server.Connection connection) {
        Iterator<com.server.Connection> iter = com.server.Server.connections.iterator();
        while (iter.hasNext()) {
            com.server.Connection next = iter.next();
            if ((next.clientIp.equals(connection.clientIp)) &
                    ((next.clientInputPort) == (connection.clientInputPort))) {
                return false;
            }
        }
        return true;
    }
}
