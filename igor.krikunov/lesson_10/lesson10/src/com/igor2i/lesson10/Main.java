package com.igor2i.lesson10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by igor2i on 13.08.15.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        File file = new File("test.txt");

//        if(!file.exists()){
//            file.createNewFile();
//        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write("Hello".getBytes());
        }finally {

            fileOutputStream.close();
        }

    }

}
