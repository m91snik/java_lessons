package com.example.io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by stanislav on 18.08.15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("str_file");
        FileChannel fileChannel = FileChannel.open(path);
//        SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
//        ByteBuffer buffer = ByteBuffer.allocate(128);
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        //int read;
        //while ((read = seekableByteChannel.read(buffer)) != -1) {
        //    buffer.rewind();
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.print((char) buffer.get(i));
            }
       // }
    }
}
