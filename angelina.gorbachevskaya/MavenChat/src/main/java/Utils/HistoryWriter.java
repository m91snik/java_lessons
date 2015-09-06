package Utils;

import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


/**
 * Created by Ангелина on 05.09.2015.
 */
public class HistoryWriter {
    public static void write(ArrayList<String> lst, String userName) {

        Path path = Paths.get("history".concat(userName).concat(".txt"));
        FileChannel fileChannel = null;
        try {
            fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE,
                    StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < lst.size(); i++) {
            String tmp = lst.get(i).concat("\n");
            ByteBuffer buffer = ByteBuffer.allocate(tmp.length());
            for (int j = 0; j < tmp.length(); j++) {
                buffer.put((byte) tmp.charAt(j));
            }
            buffer.rewind();
            try {
                fileChannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.rewind();
        }
        System.out.println("History saved!");

    }

}

