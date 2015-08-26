package com;

import java.io.*;

/**
 * Created by Anry on 18.08.2015.
 */
public class CharMain {
    public static void main(String[] args) throws IOException {
        File file = new File("str_file");
        Writer writer = new FileWriter(file);
        try {
            writer.write("new jav les!\nand");
        } finally {
            writer.close();
        }


        Reader reader = new FileReader(new File("str_file"));
        BufferedReader bufferedReader = new BufferedReader(reader);

        try {

            String str;
            while ((str = bufferedReader.readLine()) != null)){
System.out.println(str);

//        } catch(IOException){
//
//        }

//        try {
//            char[] buffer = new char[128];
//            int cnt;
//            while ((cnt = new reader.read(buffer)) != -1)
    }