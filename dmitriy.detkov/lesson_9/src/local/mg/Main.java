package local.mg;

import java.io.InterruptedIOException;

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
                    System.out.println(incriment() + " " + Thread.currentThread().getName());
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(thread.getState() + " " + Thread.currentThread().getName());


        for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
            System.out.println(incriment() + " " + Thread.currentThread().getName());
        }

    }

    static synchronized int incriment() {
        return ++counter;
    }
}
