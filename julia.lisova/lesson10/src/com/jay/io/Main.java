package com.jay.io;

import java.io.*;

/**
 * Created by User on 13.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
//        if(!file.exists())
//            file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);

        try {
            byte[] buff = new byte[1];
            StringBuilder stringBuilder = new StringBuilder();
            while (fileInputStream.read(buff)>0) {
                fileInputStream.read(buff);
                System.out.println(new String(buff));
            }

        } finally {
            fileInputStream.close();
        }

    }
}
