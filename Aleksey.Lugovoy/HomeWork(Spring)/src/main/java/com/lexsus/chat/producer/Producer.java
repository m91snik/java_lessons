package com.lexsus.chat.producer;

import com.lexsus.chat.base.LaggedUserService;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public interface Producer<E> {

    public void produce(LaggedUserService service) throws ProducerException;
}
