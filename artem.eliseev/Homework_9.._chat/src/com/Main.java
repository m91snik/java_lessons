package com;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by Anry on 12.08.2015.
 */
public class Main {
    static int counter;
    int portNumber;

    public static void main(String[] args) throws IOException {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                com.Client client = new com.Client("169.254.144.144", "1025");
//        toDo Host name scanner;
        String hostName = "Host name";
        new Server();
        try {
            Client.main("169.254.144.144", Integer.toString(Const.SERVER_IN_PORT_NUMBER));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
//                try {
//                    com.Client.main("169.254.144.144", com.Const.SERVER_IN_PORT_NUMBER.toString());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };


//        oldNotInWork.EchoServer.main("7");
//        oldNotInWork.EchoClient.main("169.254.144.144", "7");
//        testMode();
//    public static void testMode() {
//        oldNotInWork.EchoClient testEchoClient1, testEchoClient2, testEchoClient3 = new oldNotInWork.EchoClient();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(oldNotInWork.EchoServer.counterWithSync() + " " +
//                            Thread.currentThread().getName());
//                }
//            }
//        };
//
//        Thread testThread1 = new Thread(runnable);
//        Thread testThread2 = new Thread(runnable);
//        Thread testThread3 = new Thread(runnable);
//
//
////        Runnable runnable1, runnable2, runnable3 = new Runnable() {
//
//
//    }

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
//                    System.out.println(oldNotInWork.EchoServer.counterWithSync() + " " +
//                            Thread.currentThread().getName());
//                }
//            }
//        };
//        return oldNotInWork.EchoServer.counterWithSync() + " " + Thread.currentThread().getName();
//    }
    }
}
