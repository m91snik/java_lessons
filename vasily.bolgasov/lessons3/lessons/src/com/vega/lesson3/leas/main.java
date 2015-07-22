package com.vega.lesson3.leas;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Veg'Zul on 21.07.2015.
 */
public class main {

    /*private static class CardType{
        private String name;

        public CardType(String name){
            this.name = name;
        }
    }*/

    public static void main(String[] args) throws NoSuchFieldException {

        for(int i = 0, j = 5; i<6 && j>0; i++, j--){
            //System.out.println("i="+i+", j="+j);
        }

        int[][] mas = new int[10][5];

        mainFor:
        for(int i=0; i < mas.length; i++){
            for(int j=0; j<mas[i].length; j++){

                if((i+j)<3){
                    continue mainFor;
                }

                mas[i][j] = i+j;
                /*
                 *if((i+j) % 2 == 0){
                 *   break;
                 *}
                 */

                if((i+j)==10){
                    break mainFor;
                }

            }
        }

        /*
         *System.out.println(mas);
         *System.out.println(Arrays.toString(mas));
         */
         //System.out.println(Arrays.deepToString(mas));

        System.out.println(CardType.DP.calculateTaxAmount(100.0));
        //System.out.println(new main.CardType("DP"));

        // equals

/*
        Message message = new Message();
        Field[] fields = message.getClass().getDeclaredFields();

        Annotation[] annotations = message.getClass().getField("text").getAnnotations();

        //System.out.print(Arrays.toSring(annotations));

        MessageInfo messageInfo = message.getClass().getDeclaredField("text").getAnnotations(MessageInfo.class);
        if(messageInfo.maxLenght()){

        }
*/
    }

}
