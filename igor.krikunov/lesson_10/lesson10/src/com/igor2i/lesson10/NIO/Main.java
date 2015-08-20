package com.igor2i.lesson10.NIO;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by igor2i on 18.08.15.
 */
public class Main {
    public static void main(String args[]) throws IOException {

        Path path = Paths.get("str");

        FileChannel fileChannel = FileChannel.open(path);

        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());


//        SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
//
//        ByteBuffer buffer = ByteBuffer.allocate(2);

//        int read;
//        while((read = seekableByteChannel.read(buffer)) != -1){
//            buffer.rewind();
            for(int i =0; i < mappedByteBuffer.limit(); i++){
                System.out.print((char) mappedByteBuffer.get(i));
            }
//        }

    }

}
