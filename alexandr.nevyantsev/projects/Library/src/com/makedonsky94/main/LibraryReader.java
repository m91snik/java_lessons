package com.makedonsky94.main;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sasha on 09.08.2015.
 */
public class LibraryReader {
    public LibraryReader(InputStream inputStream) {
        this.inputStream = inputStream;
        scanner = new Scanner(inputStream);
    }

    private InputStream inputStream;
    private Scanner scanner;

    public boolean hasData() {
        return scanner.hasNext();
    }

    public String[] readData() {
        if(scanner.hasNext()) {
            String inputData = scanner.next();
            return readData(inputData);
        }
        return new String[] {};
    }

    public String[] readData(String inputData) {
        Pattern pattern = Pattern.compile("[-]?[А-Яа-яA-Za-z]+");
        Matcher matcher = pattern.matcher(inputData);
        ArrayList<String> listArray = new ArrayList<>();
        while(matcher.find()) {
            listArray.add(matcher.group().toLowerCase());
        }
        Object[] objects = listArray.toArray();
        String[] data = Arrays.copyOf(objects, objects.length, String[].class);
        if(data != null && data.length > 0)
            return data;
        return new String[] {};
    }
}
