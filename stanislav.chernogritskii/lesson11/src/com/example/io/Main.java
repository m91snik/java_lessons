package com.example.io;

import java.io.*;

/**
 * Created by stanislav on 18.08.15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //System.out.printf("%+d %.2f",10,10.22842F);

        File file = new File("str_file");

        Writer writer = new FileWriter(file);
        try {
            writer.write("new java lessons\nand much more!");
        } finally {
            writer.close();
        }

        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
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
//            int cnt;
//            while ((cnt = reader.read(buffer)) != -1) {
//                System.out.println(new String(buffer));
//            }
//        } finally {
//            reader.close();
//        }
    }
}
