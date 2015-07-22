package com.igor2i.lesson3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by igor2i on 21.07.15.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)


public @interface MessagInfo {

    LangType lang() default LangType.Fr;

    int maxLanght() default 255;


}
