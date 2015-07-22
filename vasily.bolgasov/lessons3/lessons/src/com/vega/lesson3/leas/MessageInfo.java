package com.vega.lesson3.leas;

/**
 * Created by Veg'Zul on 21.07.2015.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageInfo {
    LangType lang() default LangType.FR;

    int maxLenght();
}
