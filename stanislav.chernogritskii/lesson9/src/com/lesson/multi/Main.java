package com.lesson.multi;

/**
 * Created by stanislav on 11.08.15.
 */
public class Main {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(increment() + " " + Thread.currentThread().getName());
                }
            }
        };

        Thread thread = new Thread(runnable);

        long l1 = System.currentTimeMillis();
        thread.start();

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(10);
            System.out.println(increment() + " " + Thread.currentThread().getName());
        }
        thread.join();

        long l2 = System.currentTimeMillis();

        System.out.println(l2 - l1);
    }

    static synchronized int increment () {
        return ++counter;
    }
}
