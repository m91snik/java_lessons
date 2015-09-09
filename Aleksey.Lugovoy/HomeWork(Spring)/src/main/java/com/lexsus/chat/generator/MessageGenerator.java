package com.lexsus.chat.generator;

import com.lexsus.chat.base.LaggedUserService;

/**
 * Created by nikolay.garbuzov on 27.08.15.
 */
public interface MessageGenerator<E> {
    E generate();
}
