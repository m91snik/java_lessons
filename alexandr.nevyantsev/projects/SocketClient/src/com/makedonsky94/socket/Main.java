package com.makedonsky94.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        echoSocket = new Socket("localhost", 4444);
        InputStream in = echoSocket.getInputStream();
        OutputStream out = echoSocket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufOut = new BufferedWriter( new OutputStreamWriter( out ) );
        while ( true ) {
            try {
                String msg = scanner.next();
                System.out.println( "Received: " + msg );
                bufOut.write( msg );
                bufOut.newLine();
                bufOut.flush();
            } catch ( IOException e ) {
                e.printStackTrace();
            }

        }
    }
}
