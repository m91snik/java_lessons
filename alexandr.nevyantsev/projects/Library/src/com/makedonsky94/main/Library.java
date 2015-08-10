package com.makedonsky94.main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sasha on 09.08.2015.
 */
public class Library {
    public Library() {
        stringList = new ArrayList<>();
        stringCommands = new HashMap<>();
        initialize();
    }

    ArrayList<String> stringList;

    private HashMap<String, Callback> stringCommands;

    private void initialize() {
        stringCommands.put("-showlib", () -> {
            System.out.format("Содержимое словаря %s\n", stringList.toString());
        });
    }

    public void addWord(String element, LibraryCallback callback) {
        if(stringList.indexOf(element) >= 0) {
            return;
        }

        Callback call = stringCommands.get(element);
        if(call != null) {
            call.call();
            return;
        }
        element = element.replace("-", "");

        stringList.add(element);
        callback.call(element);
    }

}
