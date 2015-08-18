package com.example.my;

import java.util.concurrent.CountDownLatch;

/**
 * Created by stanislav on 13.08.15.
 */
public class Main {

    static long counter = 0;

    static Object o = new Object();
    static boolean flag = false;

    static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException{


        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println(counter++ + " " + Thread.currentThread().getName());
                }
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 10; i < 10; i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(runnable).start();
        }
    }
}
