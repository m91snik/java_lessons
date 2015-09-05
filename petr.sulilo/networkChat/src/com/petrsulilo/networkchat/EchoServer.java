package com.petrsulilo.networkchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Petr on 15.08.2015.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException
    {
        if (args.length !=1)
        {
            System.err.println("Usage: java EchoServer <port number>");
            //TODO: do not use this! throw IllegalArgumeException
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try
        (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()))
        )
        {
          String inputLine;
            while ((inputLine = in.readLine()) != null)
            {

                System.out.println("Received text: " + inputLine);
                out.println(inputLine);
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}
