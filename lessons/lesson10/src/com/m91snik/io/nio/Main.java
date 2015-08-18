package com.m91snik.io.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Valentin on 18.08.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("str_file");
        FileChannel fileChannel = FileChannel.open(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE,
                StandardOpenOption.READ);
//        SeekableByteChannel seekableByteChannel =
//                Files.newByteChannel(path);
//        ByteBuffer buffer = ByteBuffer.allocate(10);
        MappedByteBuffer buffer =
                fileChannel.map(FileChannel.MapMode.READ_WRITE, 0,
                        1);

        buffer.put((byte)'A');

//        int read;
//        while ((read = seekableByteChannel.read(buffer)) != -1) {
//            for (int i = 0; i < buffer.limit(); i++) {
//                System.out.print((char) buffer.get(i));
//            }
//            buffer.rewind();
//        }
    }
}
