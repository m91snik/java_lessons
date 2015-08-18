package com.m91snik.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Valentin on 13.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
//        if(!file.exists()){
//            file.createNewFile();
//        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream =
                new DataOutputStream(bufferedOutputStream);
        try {
            dataOutputStream.writeBoolean(false);
            dataOutputStream.writeFloat(10.0F);
            dataOutputStream.writeUTF("HELLO");
        } finally {
            bufferedOutputStream.close();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        try {
//            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readFloat());
            System.out.println(dataInputStream.readBoolean());



        } finally {
            fileOutputStream.close();
        }
    }
}
