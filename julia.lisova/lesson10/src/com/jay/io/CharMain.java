package com.jay.io;

import java.io.*;

/**
 * Created by User on 18.08.2015.
 */
public class CharMain {

    public static void main(String[] args) throws IOException {

        File file = new File("str.file");
        Writer writer = new FileWriter(file);
        writer.write("New java lessons");
        writer.close();

        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.readLine();
        try {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);

            }
        } finally {
            bufferedReader.close();
        }
        //        try {
//            char[] buffer = new char[128];
//            int cat;
//            while ((cat = reader.read(buffer)) != -1) {
//                System.out.println(new String(buffer));
//
//            }
//        } finally {
//            reader.close();
//        }
    }
}
