package com.igor2i.lesson10;

import java.io.*;

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
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        DataOutputStream dataOutputStream =new DataOutputStream(bufferedOutputStream);



        try {

            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeDouble(10.2);
            dataOutputStream.writeUTF("Hellpqw qwdqw");

        }finally {

            dataOutputStream.close();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        try {

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readUTF());

        }finally {

            dataInputStream.close();
        }


    }

}
