package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream =new FileOutputStream(file, true);
        try {

            fileOutputStream.write("Hello".getBytes());
        } finally {
            fileOutputStream.close();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] buffer = new byte[10];
            StringBuilder fileContent = new StringBuilder();
            while (fileInputStream.read(buffer) > 0){
                fileContent.append(new String(buffer));
            }
            System.out.print(fileContent);
//            fileInputStream.read(buffer);

        } finally {
            fileInputStream.close();
        }


    }
}
