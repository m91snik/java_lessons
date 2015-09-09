package com.lexsus.chat.producer;

import com.lexsus.chat.SharedQueue;
import com.lexsus.chat.base.LaggedUserService;
import com.lexsus.chat.generator.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lexsus on 30.08.2015.
 */
//@Component
public class ServerProducer<E>  implements Producer<E>{
    @Autowired
    private SharedQueue<E> sharedQueue;

    @Autowired
    MessageGenerator<E> generator;

    public ServerProducer() {
    }

    public ServerProducer(SharedQueue<E> sharedQueue, MessageGenerator<E> generator) {
        this.sharedQueue = sharedQueue;
        this.generator = generator;
    }

    @Override
    public void produce() throws ProducerException {
        try {
            E mes = generator.generate();
            if (mes!=null)
                sharedQueue.put(mes);
        } catch (InterruptedException e) {
            throw new ProducerException(e);
        }
    }
}
