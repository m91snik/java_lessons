package com.igor2i.homework;

import com.igor2i.homework.cicleLinkedList.MainLLL;
import com.igor2i.homework.method.Prevetstvie;
import com.igor2i.homework.method.logs.Logs;
import com.igor2i.homework.scaner.Scanner;
import com.igor2i.homework.slovar.MainS;
import com.igor2i.homework.treeMap.MainVTM;


/**
 * Created by igor2i on 07.08.2015.
 */
public class Main {

    public static void main(String args[]) {

        Prevetstvie.getPrevetstvie();

        Logs<String> logs = new Logs<>();

        logs.pushLog("Start Main");

        try {

            for (String scan = Scanner.getScan("[0-9]"); !("exit".equals(scan)); scan = Scanner.getScan("[0-9]")) {

                try {

                    switch (scan.toLowerCase()) {
                        case "1":
                            logs.pushLog("Start MainS");
                            logs.allPush(MainS.main());
                            logs.pushLog("Close MainS");
                            break;
                        case "2":
                            logs.pushLog("Start MainLLL");
                            MainLLL.main();
                            logs.pushLog("Close MainLLL");
                            break;
                        case "3":
                            logs.pushLog("Start MainVTM");
                            MainVTM.main();
                            logs.pushLog("Close MainVTM");
                            break;
                        case "help":
                            Prevetstvie.getHelp();
                            break;
                        default:
                            logs.pushLog("get void ");
                            break;

                    }
                } catch (Exception ex) {
                    logs.pushLog(ex.toString());
                }
            }

        } catch (Exception ex) {
            logs.pushLog(ex.toString());
        }


        System.out.println("|--------------------Log Message----------------------|");
        for (int i = 0; logs.lenghtL() > 0; i++) {
            System.out.println(i + "  " + logs.popLog());
        }

    }

}
