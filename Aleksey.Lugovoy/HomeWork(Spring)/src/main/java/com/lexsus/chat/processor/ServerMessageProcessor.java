package com.lexsus.chat.processor;

import com.lexsus.chat.SharedMap;
import com.lexsus.chat.spring.java.Message;
import com.lexsus.chat.spring.java.ClientInfo;
import com.lexsus.chat.spring.java.MessageType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ServerMessageProcessor implements MessageProcessor<Message> {
    @Autowired
    private SharedMap<String,ClientInfo> sharedMap;

    public ServerMessageProcessor(SharedMap<String,ClientInfo> sharedMap) {
        this.sharedMap = sharedMap;
    }
    @Override
    public void process(Message message) {
        Set<Map.Entry<String, ClientInfo>> set = sharedMap.entrySet();
        for (Map.Entry<String, ClientInfo> entry : set) {
            {
                String login = entry.getKey();
                ClientInfo clientInfo = entry.getValue();
                MessageType.MESSAGE.sendMessage(clientInfo.getIp_address(), clientInfo.getPort(), message.getText());
            }
        }
    }
}