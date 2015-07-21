package com.m91snik.arrayetc;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Valentin on 21.07.2015.
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
        Message message = new Message();
        Field[] fields = message.getClass().getDeclaredFields();

        System.out.println(Arrays.toString(fields));

        MaxLengh maxLengh = message.getClass().getDeclaredField("text").getAnnotation(MaxLengh.class);
        if (maxLengh.value() < message.getText().length()) {
            message.setText(message.getText().substring(0, maxLengh.value()));
        }
    }

}
