package com.vega.dictionary;

import com.vega.dictionary.Interface.Dictionary;
import com.vega.dictionary.Interface.DictionaryHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 09.08.2015.
 */
public class Main {

    public static void main(String[] args) {

        Dictionary dictionary = new DictionaryHandler();
        dictionary.greetings();
        dictionary.decision();

    }

}
