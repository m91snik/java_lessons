package com.gorbachevskaya.lesson8hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Ангелина on 07.08.2015.
 */
public class Vocabulary {
    Map<String, String> vocabulary;

    Vocabulary(){
        vocabulary = new HashMap<>();
    }

    void create(String str) {
        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (!vocabulary.containsKey(strings[i].toLowerCase())) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter translation for "+strings[i]);
                String translation = scanner.next();
                vocabulary.put(strings[i].toLowerCase(), translation);
            }
        }
    }
}
