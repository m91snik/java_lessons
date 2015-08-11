package com.m91snik.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Valentin on 11.08.2015.
 */
public class Main {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        boolean flag = false;
        Object o = new Object();
        synchronized (o) {
            while (!flag) {
                try {
                    o.wait();
                }catch (InterruptedException e){

                }
            }
        }

        synchronized (o) {
            flag = true;
            o.notify();
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    System.out.println(incrementWithSync() + " " +
                            Thread.currentThread().getName());
                }
            }
        };

        Thread thread = new Thread(runnable);

        long l1 = System.currentTimeMillis();
        thread.start();

        for (int i = 0; i < 100; i++) {
//            Thread.sleep(10);
            System.out.println(incrementWithSync() + " " +
                    Thread.currentThread().getName());
        }
        thread.join();

        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

    static int incrementWithSync() {
        synchronized (Main.class) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ++counter;
        }
    }

    private Object nonStaticLock1 = new Object();
    private Object nonStaticLock2 = new Object();

    ReentrantLock reentrantLock = new ReentrantLock();

    int y;

    int x;

    int nonStatic1() throws InterruptedException {


        try {
            reentrantLock.lock();
//        reentrantLock.tryLock(10, TimeUnit.SECONDS);
        } finally {
            reentrantLock.unlock();
        }

        synchronized (nonStaticLock1) {
            synchronized (nonStaticLock2) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return ++counter;
            }
        }
    }

    int nonStatic2() {
        synchronized (nonStaticLock2) {
            synchronized (nonStaticLock1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return ++counter;
            }
        }
    }

    static int increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ++counter;
    }
}
