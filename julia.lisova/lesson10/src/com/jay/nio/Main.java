package com.jay.nio;

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
 * Created by User on 18.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("str.file");
        FileChannel fileChannel = FileChannel.open(path);
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, 10);


//        SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
//
//        ByteBuffer buffer = ByteBuffer.allocate(2);
//        int read = seekableByteChannel.read(buffer);
       // while ((read = buffer.limit()) != -1) {
            for (int i = 0; i < buffer.limit(); i++) {
                System.out.println((char) buffer.get(i));
            }
            buffer.rewind();
      //  }
    }
}
