package com.gorbachevskaya.streams;

import java.io.*;

/**
 * Created by Ангелина on 18.08.2015.
 */
public class CharMain {
    public static void main(String[] args) throws IOException {
        File file = new File("str_file.txt");
        Writer writer = new FileWriter(file);
        try {
            writer.write("new java lesson!\nand much more!");
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
//            int cnt = 0;
//            while ( (cnt = reader.read(buffer)) != -1 ) {
//                System.out.print(new String(buffer));
//            }
//        } finally {
//            reader.close();
//        }



    }
}
