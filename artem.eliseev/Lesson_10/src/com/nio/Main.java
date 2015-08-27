package com.nio;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Anry on 18.08.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("str_file");
        SeekableByteChannel seekableByteChannel=Files.newByteChannel(path);
        ByteBuffer buffer = ByteBuffer.allocate(128);

        int read ;
        while ((read=seekableByteChannel.read(buffer))!=1){
            buffer.rewind();
            for (int i=1; i<buffer.limit();i++){
                System.out.print((char)buffer.get(i));
            }
        }
    }

}
