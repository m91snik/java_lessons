import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Anry on 11.08.2015.
 */
public class Main {
    static long counter = 0;
    Object o = new Object();
    boolean flag = false;


    public static void main(String[] args) throws InterruptedException {

        Object o = new Object();
        boolean flag = false;
//        static
        CyclicBarrier cyclicBarrie= new CyclicBarrier(100);

        ConcurrentLinkedQueue <Integer> queue= new ConcurrentLinkedQueue<>();
        Random random=new Random();


        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Runnable runnable = new Runnable() {
            @Override
            public void  run() {
                for (int i = 0; i < 100; i++) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException();
//                    }

                    System.out.println(counter + " " + Thread.currentThread().getName() + increment());
                }
                if(random.nextBoolean()){

                }

            }

        };
        synchronized (o) {
            flag = true;
            o.notify();
        }


        Thread thread = new Thread(runnable);
//        System.out.println(thread.getState());
//        System.out.println(counter++ + " " + Thread.currentThread().getName() + thread.getState());
//        thread.setDaemon(true);
        thread.start();
//        System.out.println(counter++ + " " + Thread.currentThread().getName() + thread.getState());

        for (int i = 0; i < 100; i++) {
//            System.out.println(counter++ + " " + Thread.currentThread().getName() + thread.getState());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
//            thread.join();
            System.out.println(i + " " + Thread.currentThread().getName() + increment());
//            thread.start();

        }

        synchronized (o) {
            while (!flag) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                }

            }
        }
    }


    static synchronized long increment() {
//        synchronized (Main.class) {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        return counter++;

    }
}


