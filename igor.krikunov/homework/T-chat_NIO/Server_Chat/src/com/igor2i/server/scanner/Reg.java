package com.igor2i.server.scanner;

import java.util.regex.*;

/**
 * Created by igor2i on 22.08.2015.
 */
public class Reg {

    public static boolean regServSocket(String str) {
        Pattern p = Pattern.compile("(ServerSocket\\[).+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * strOut[0] - ServerSocket[addr=/IP,localport=PORT]
     * strOut[1] - nick
     * strOut[2] - ip
     * strOut[3] - port
     *
     * @param str
     * @return strOut[]
     */
    public static String[] splitServSocket(String str) {
        String[] strOut = new String[4];
        String[] splitOut;
        int firsSimbInd;
        int lastSimbInd;

        splitOut = str.split("\\*\\*\\*\\*");

        strOut[0] = splitOut[0];
        strOut[1] = splitOut[1];

        firsSimbInd = splitOut[0].lastIndexOf("/");
        lastSimbInd = splitOut[0].lastIndexOf(",");
        strOut[2] = splitOut[0].substring(firsSimbInd + 1, lastSimbInd);

        firsSimbInd = splitOut[0].lastIndexOf("=");
        lastSimbInd = splitOut[0].lastIndexOf("]");
        strOut[3] = splitOut[0].substring(firsSimbInd + 1, lastSimbInd);


        return strOut;
    }

    public static boolean regPM(String str) {

        Pattern p = Pattern.compile(".+(: /pm ).+");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    /**
     * strOut[0] - nickSource
     * strOut[1] - nickDestination
     * strOut[2] - message
     *
     * @param str
     * @return outStr[]
     */
    public static String[] getPM(String str) {
        String[] outStr = {""};

        try {
            outStr = str.split("(: /pm)");


            outStr = (outStr[0] + outStr[1]).split(" ");

            for (int i = 3; i < outStr.length; i++) {
                outStr[2] += " " + outStr[i];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            outStr[0] = "Error: ArrayIndexOutOfBoundsException";
        }
        return outStr;
    }

    public static boolean regWho(String str) {

        Pattern p = Pattern.compile(".+(: /who)");
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static String getNick(String str) {
        String[] outStr;

        outStr = str.split(":");

        return outStr[0];
    }


}
