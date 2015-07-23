package com.igor2i.calc.scaner;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by igor2i on 17.07.2015.
 */
public class Scaner {
    private static String scan() {
        String s = "";
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            s = sc.nextLine();
        }

        if (s.equals("exit")) {
            return s;
        }

        String pattern1 = "[0-9]|[.|,]|[+|-]|[*|/]|[!|\\^]|[(|)]|(matrix\\[)|(\\])|(;)";

        Pattern p1 = Pattern.compile(pattern1);
        Matcher m1 = p1.matcher(s);
        String out1 = "";
        while (m1.find()) {
            out1 += s.substring(m1.start(), m1.end());
        }

        //out1  -- очищенная строка

        return out1;
    }

    public static String getScan() {
        String outStr = scan();

        if (outStr.equals("")) {
            System.out.println("Введите корректное выражение");
            return "";
        } else {
            return outStr;
        }
    }
}
