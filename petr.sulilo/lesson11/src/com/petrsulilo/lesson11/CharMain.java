package com.petrsulilo.lesson11;

import java.io.*;

/**
 * Created by Petr on 18.08.2015.
 */
public class CharMain {

    public static void main(String... args) throws FileNotFoundException {
        Reader reader = new FileReader(new File("str_file"));
        BufferedReader bufferedReader = new BufferedReader(reader);

        try
        {
            String str;
            while ((str = bufferedReader.readLine()) != null)
            {

            }
        }



    }
}
