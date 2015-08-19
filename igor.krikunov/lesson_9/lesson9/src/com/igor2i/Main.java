package com.igor2i;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by igor2i on 11.08.15.
 */
public class Main {

    static volatile AtomicLong count = new AtomicLong(0) ;

    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    static Random random = new Random();


//    static boolean flag = false;
//
//    static CountDownLatch countDownLatch = new CountDownLatch(100);
//
//    static CyclicBarrier cyclicBarrier = new CyclicBarrier(100);


    public static void main(String args[]) throws InterruptedException {


        Runnable runnable = new Runnable() {

            @Override
            public void run() {
//
//                for(int i =0;i<10;i++){
//
//
//                    System.out.println(count.incrementAndGet() + "  "+ Thread.currentThread().getName());
//
//                }


                if(random.nextBoolean()){
    //              map.add
                }


//                System.out.println("not equals" + Thread.currentThread().getName());

//
//                try {
//                    cyclicBarrier.await();
//                } catch (InterruptedException | BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//
            }


        };

//        Thread thread = new Thread(runnable);
//        Thread thread1 = new Thread(runnable);
//
//        thread.start();

        for (int i = 0; i < 10; i++) {

            new Thread(runnable).start();

        }

    }


//    static synchronized int incriment() {
//
//
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return ++count;
//    }


}
