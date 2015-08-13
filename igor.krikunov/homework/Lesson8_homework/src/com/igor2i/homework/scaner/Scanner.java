package com.igor2i.homework.scaner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by igor2i on 07.08.2015.
 */
public class Scanner {

    private static String scan(String filter) {
        try {
            String s = "";
            java.util.Scanner sc = new java.util.Scanner(System.in);
            if (sc.hasNextLine()) {
                s = sc.nextLine();
            }

            if ("exit".equals(s)) {
                return s;
            } else if ("help".equals(s)) {
                return s;
            }

            String out1 = "";

            if (!"".equals(filter)) {

                Pattern p1 = Pattern.compile(filter);
                Matcher m1 = p1.matcher(s);

                while (m1.find()) {
                    out1 += s.substring(m1.start(), m1.end());
                }
            } else {
                out1 = s;
            }

            //out1  -- очищенная строка

            return out1;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static String getScan(String filter) {
        String outStr = scan(filter);

        if (outStr.equals("")) {
            System.out.println("Введите корректное выражение");
            return "reScan";
        } else {
            return outStr;
        }
    }

}
