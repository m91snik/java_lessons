package com.io.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by stanislav on 13.08.15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");

//        if (!file.exists()) {
//            file.createNewFile();
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
            while(fileInputStream.read(buffer) > 0) {
                System.out.println(new String(buffer));
            }
        } finally {
            fileOutputStream.close();
        }
    }
}
