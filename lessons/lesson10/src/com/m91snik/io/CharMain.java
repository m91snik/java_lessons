package com.m91snik.io;

import java.io.*;

/**
 * Created by Valentin on 18.08.2015.
 */
public class CharMain {

    public static void main(String[] args) throws IOException {
        File file = new File("str_file");
        Writer writer = new FileWriter(file);
        try {
            writer.write("new java lessons!\nand much more!");
        } finally {
            writer.close();
        }

        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        }

//        try {
//            char[] buffer = new char[128];
//            int cnt;
//            while ((cnt = reader.read(buffer)) != -1) {
//                System.out.print(new String(buffer));
//            }
//        } finally {
//            reader.close();
//        }
    }
}
