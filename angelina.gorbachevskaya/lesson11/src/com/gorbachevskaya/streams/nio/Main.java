package com.gorbachevskaya.streams.nio;

//import java.nio.file.Files;
//import java.nio.file.Path;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

/**
 * Created by Ангелина on 18.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("str_file.txt");
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.READ, StandardOpenOption.WRITE);
//        SeekableByteChannel seekableByteChannel = Files.newByteChannel(path);
//        ByteBuffer buffer = ByteBuffer.allocate(128);
//        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        fileChannel.lock();
        buffer.put((byte) 'A');


//        int read;
//        while (  (read = seekableByteChannel.read(buffer)) != -1 ) {
//            buffer.rewind();

//            for (int i = 0; i < buffer.limit(); i++) {
//                System.out.print((char)buffer.get(i));
//            }

    }
}
//}
