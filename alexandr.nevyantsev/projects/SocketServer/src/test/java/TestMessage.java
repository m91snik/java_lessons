import com.makedonsky94.socket.Client;
import com.makedonsky94.socket.Message;
import com.makedonsky94.socket.WorkerReader;
import com.makedonsky94.socket.WorkerWriter;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sasha on 30.08.2015.
 */

public class TestMessage {
    
    @Test
    public void testBlockingQueue() throws IOException, InterruptedException {
        BlockingQueue<Message> messageBlockingQueue = new ArrayBlockingQueue<>(1);
        ConcurrentHashMap<String, Client> clientConcurrentHashMap = new ConcurrentHashMap<>();
        WorkerReader workerReader = new WorkerReader(messageBlockingQueue, clientConcurrentHashMap, 0);
        WorkerWriter workerWriter = new WorkerWriter(messageBlockingQueue, clientConcurrentHashMap);
        Message msg = new Message("messageString");
        workerReader.addMessage(msg);
        Assert.assertEquals(workerWriter.getMessage(), msg);
    }
}
