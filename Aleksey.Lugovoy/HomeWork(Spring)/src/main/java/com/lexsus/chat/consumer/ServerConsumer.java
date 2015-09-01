package com.lexsus.chat.consumer;

import com.lexsus.chat.SharedQueue;
import com.lexsus.chat.processor.MessageProcessor;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ServerConsumer<E> extends BaseConsumer{
    public ServerConsumer(SharedQueue sharedQueue, MessageProcessor messageProcessor) {
        super(sharedQueue, messageProcessor);
    }
}
