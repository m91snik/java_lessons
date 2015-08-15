import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Anry on 12.08.2015.
 */
public class Main {
    static int counter;


    public static void main(String[] args) throws IOException {
//        EchoServer.main("7");
        EchoClient.main("169.254.144.144", "7");
//        testMode();
    }

    public static void testMode() {
        EchoClient testEchoClient1, testEchoClient2, testEchoClient3 = new EchoClient();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(EchoServer.counterWithSync() + " " +
                            Thread.currentThread().getName());
                }
            }
        };

        Thread testThread1 = new Thread(runnable);
        Thread testThread2 = new Thread(runnable);
        Thread testThread3 = new Thread(runnable);


//        Runnable runnable1, runnable2, runnable3 = new Runnable() {


    }

//    public String testModeRunable() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(EchoServer.counterWithSync() + " " +
//                            Thread.currentThread().getName());
//                }
//            }
//        };
//        return EchoServer.counterWithSync() + " " + Thread.currentThread().getName();
//    }
}
