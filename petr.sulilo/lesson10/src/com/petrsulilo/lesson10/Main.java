package com.petrsulilo.lesson10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Petr on 13.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException
    {
        File file = new File("Test.txt");
        if (!file.exists())
        {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write("Hello".getBytes());
        }
        finally {
            fileOutputStream.close();
        }

        FileInputStream fileInputStream = new fileInputStream(file);
        try {
            byte[] buffer = new byte[10];
            while (fileInputStream.read(buffer) > 0)
            {
                System.out.println(new String(buffer));
            }
        }
        finally {
            fileInputStream.close();
        }

    }
}
