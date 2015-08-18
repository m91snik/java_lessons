package com.igor2i.server.scanner;

/**
 * Created by igor2i on 16.08.2015.
 */
public class Scanner {

    private static String scan() {

        String s = "";
        java.util.Scanner sc = new java.util.Scanner(System.in);
        if (sc.hasNextLine()) {
            s = sc.nextLine();
        }

        return s;

    }

    public static String getScan() {
        String outStr = scan();

        if (outStr.equals("")) {
            //System.out.println("Введите корректное выражение");
            return "reScan";
        } else {
            return outStr;
        }
    }
}

