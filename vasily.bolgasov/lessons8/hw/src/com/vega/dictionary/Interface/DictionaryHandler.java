package com.vega.dictionary.Interface;

import com.vega.dictionary.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 09.08.2015.
 */
public class DictionaryHandler implements Dictionary {

    String userName;
    Scanner inputMessage = new Scanner(System.in);
    List<String> inputText = new ArrayList<>();

    @Override
    public void greetings() {

        System.out.print("Hellow, what your name? ");
        userName = inputMessage.next();

    }

    @Override
    public void decision() {

        String decisionAboutMessage;

        for(;;){
            System.out.println("What we need do, "+userName+": WRITE your text, VIEW our dictionary or just EXIT?");
            decisionAboutMessage = inputMessage.next();
            decisionAboutMessage = decisionAboutMessage.toUpperCase();
            if (checkMessage(decisionAboutMessage)) break;
        }

    }

    private boolean checkMessage(String decisionAboutMessage) {
        if(Operation.EXIT.name().equals(decisionAboutMessage)) {
            System.out.println("Goodbay, "+userName+", come again!");
            return true;
        }else if(Operation.WRITE.name().equals(decisionAboutMessage)){
            inputDictionary();
        }else if(Operation.VIEW.name().equals(decisionAboutMessage)){
            outDictionary();
        }
        return false;
    }

    @Override
    public void inputDictionary() {

        Scanner inputMessage = new Scanner(System.in);
        System.out.println("Pleas " + userName + " write your text:");
        String[] textWrite = inputMessage.nextLine().split(" ");
        for(int i=0;i<textWrite.length;i++){
            boolean checkThis = true;
            for(String j : inputText){
                if(textWrite[i].equals(j)){
                    checkThis = false;
                }
            }

            if (checkThis==true) {
                inputText.add(textWrite[i]);
            }

        }

    }

    @Override
    public void outDictionary() {
        System.out.println("Our words: "+inputText);
    }
}
