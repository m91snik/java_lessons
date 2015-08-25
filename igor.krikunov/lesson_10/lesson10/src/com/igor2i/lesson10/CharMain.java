package com.igor2i.lesson10;

import java.io.*;

/**
 * Created by igor2i on 18.08.15.
 */
public class CharMain {

    public static void main(String args[]) throws IOException {


        Writer writer = new FileWriter(new File("wirt"));
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        try{
            bufferedWriter.write("Hello Java lesson");
        }finally {
            bufferedWriter.close();
        }



        Reader reader = new FileReader(new File("str"));

        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } finally {
            bufferedReader.close();
        }
//
//        char[] buffer = new char[128];
//
//        int cht;
//        while ((cht = reader.read(buffer)) != -1){
//            System.out.print(new String(buffer));
//        }
//        reader.close();


    }

}
