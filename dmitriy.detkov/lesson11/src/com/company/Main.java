package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter(new File("str_file"));
        writer.write("wqeqwe");
        writer.close();

        Reader reader = new FileReader(new File("str_file"));
        System.out.println(reader.toString());
        reader.close();
    }
}
