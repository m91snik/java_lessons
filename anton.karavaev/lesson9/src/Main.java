//import java.util.concurrent.CountDownLatch;
//
///**
// * Created by HP on 11.08.2015.
// */
//public class Main {
//
//    static long counter = 0;
//    static CountDownLatch countDownLatch
//    public static void main(String[] args) throws InterruptedException {
//
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                                for (int i = 0; i < 10 ; i++) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                       throw new RuntimeException(e);
//                    }
//                    System.out.println(increment() + " " +
//                            Thread.currentThread().getName());
//                }
//            }
//        };
//        Thread thread = new Thread(runnable);
//        long 11 = System.currentTimeMillis();
//        thread.start();
//
//
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println(increment() + " " +
//                    Thread.currentThread().getName());
//        }
//
//        thread.join();
//        long 12 = System.currentTimeMillis();
//        System.out.println();
//    }
//
//
//    static synchronized int increment () {return ++counter;}
//}
//
//
