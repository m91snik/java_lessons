package Server;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by root on 8/28/15.
 */
public class SharedQueue<E> {
    private final BlockingQueue<E> queue;

    public SharedQueue() {
        this.queue = new LinkedBlockingQueue<E>();
    }

    public E take() throws InterruptedException {
        return queue.take();
    }

    public void put(E e) throws InterruptedException {
        queue.put(e);
    }

    @Override
    public String toString() {
        return "SharedQueue{" +
                "queue=" + queue +
                '}';
    }
}
