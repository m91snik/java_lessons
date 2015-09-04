package com.petrsulilo.networkchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Petr on 15.08.2015.
 */
public class EchoClient {
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2)
        {
            System.err.println(
                    "Usage: java EchoClient <hostName> <portNumber>");
            System.exit(1);// Убить поток
        }

        String hostName = args[0];
        int portNumber  = Integer.parseInt(args[1]);

        try
            (
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));)
            //========= ========= ========= ========= ========= ========= ========= =========
        {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                out.println(userInput);// отправить в сокет
                System.out.print("echo: ");
                while (in.ready())
                {
                    System.out.println(in.readLine());
                }
                echoSocket.close();
            }
        }

        catch (UnknownHostException e)
        {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
        finally {
            System.out.println("============== finally ===============");
        }
        System.out.println("============== Выход ===============");
    }
}
