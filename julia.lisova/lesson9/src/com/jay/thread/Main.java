package com.jay.thread;

/**
 * Created by User on 11.08.2015.
 */
public class Main {

    static int counter = 0;


    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(increment() + " " + Thread.currentThread().getName());
                }
                //throw new RuntimeException("sd");
            }
        };
        Thread thread = new Thread(runnable);
        //System.out.println(thread.getState());

        long l1 = System.currentTimeMillis();
        thread.start();

        //System.out.println(thread.getName() + " " + thread.getState());

        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            System.out.println(increment() + " " + Thread.currentThread().getName());
        }
        thread.join();
        long l2 = System.currentTimeMillis();
    }



//        thread.join();
//
//        System.out.println(thread.getState());
//
//        thread.start();

    static synchronized int increment() {
        return ++counter;

    }
}

