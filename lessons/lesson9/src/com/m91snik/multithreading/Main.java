package com.m91snik.multithreading;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.UnaryOperator;

/**
 * Created by Valentin on 11.08.2015.
 */
public class Main {

    static AtomicLong counter = new AtomicLong();

    static Object o = new Object();
    static boolean flag = false;

    static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(100);

    static Random random = new Random();

    static AtomicReference<TempStat> reference = new AtomicReference<>(new TempStat(0, 0, 0, 0));

    public static void main(String[] args) throws InterruptedException {
        int currentTemp = 10;

        reference.getAndUpdate(new UnaryOperator<TempStat>() {
            @Override
            public TempStat apply(TempStat tempStat) {
                int maxTemp = Math.max(tempStat.getMaxTemp(), currentTemp);
                //....
                return new TempStat(maxTemp, 0, currentTemp, 0);
            }
        });


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                while (counter == counter) {
//                    counter++;
//                }
//                System.out.println("Not equals " + counter);

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                if (random.nextBoolean()) {
                    queue.add(random.nextInt());
                } else {
                    queue.poll();
                }

                int result = 0;
                for (Iterator<Integer> iterator = queue.iterator(); iterator.hasNext(); ) {
                    result += iterator.next();
                }
                System.out.println(result);

//                for (int i = 0; i < 10; i++) {
//
//                    System.out.println(counter++ + " " +
//                            Thread.currentThread().getName());
//                }

//                synchronized (o) {
//                    flag = true;
//                    o.notify();
//                }
                //terminating
            }
        };

        for (int i = 0; i < 1000; i++) {
            new Thread(runnable).start();
        }


//        for (int i = 0; i < 100; i++) {
//            System.out.println(increment() + " " +
//                    Thread.currentThread().getName());
//        }


//        synchronized (o) {
//            while (!flag) {
//                try {
//                    o.wait();
//                }catch (InterruptedException e){
//
//                }
//            }
//        }

        //System.out.println(thread.getState());

//        long l2 = System.currentTimeMillis();
//        System.out.println(l2 - l1);
    }

    static long incrementWithSync() {
        synchronized (Main.class) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return counter.incrementAndGet();
        }
    }

    private Object nonStaticLock1 = new Object();
    private Object nonStaticLock2 = new Object();

    ReentrantLock reentrantLock = new ReentrantLock();

    int y;

    int x;

//    long nonStatic1() throws InterruptedException {
//
//
//        try {
//            reentrantLock.lock();
////        reentrantLock.tryLock(10, TimeUnit.SECONDS);
//        } finally {
//            reentrantLock.unlock();
//        }
//
//        synchronized (nonStaticLock1) {
//            synchronized (nonStaticLock2) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return ++counter;
//            }
//        }
//    }

//    long nonStatic2() {
//        synchronized (nonStaticLock2) {
//            synchronized (nonStaticLock1) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return ++counter;
//            }
//        }
//    }
//
//    static long increment() {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return ++counter;
//    }
}
