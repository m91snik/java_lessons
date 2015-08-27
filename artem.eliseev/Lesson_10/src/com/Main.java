package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Anry on 13.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//
//        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write("Hello".getBytes());
        } finally {
            fileOutputStream.close();
        }
        FileInputStream fileInputStream = new FileInputStream(file);



        try {
            byte[] buffer = new byte[10];
            StringBuilder fileContent = new StringBuilder();
            while (fileInputStream.read(buffer) > 0) {
                fileContent.append(new String(buffer));
            }
            System.out.println(new String(buffer));
        } finally {
            fileOutputStream.close();
        }


    }
}
