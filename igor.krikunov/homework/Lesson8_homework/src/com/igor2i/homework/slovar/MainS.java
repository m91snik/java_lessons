package com.igor2i.homework.slovar;

import com.igor2i.homework.method.Prevetstvie;
import com.igor2i.homework.method.logs.Logs;
import com.igor2i.homework.scaner.Scanner;

import java.util.Collection;
import java.util.Collections;

/**
 * создание словаря по введенному тексту
 */
public class MainS {

    public static Collection<String> main() {

        Prevetstvie.getPrevetstvieS();

        Logs<String> logs = new Logs<>();

        Slovar<String> slovar = new Slovar<>();

        try {

            for (String scan = Scanner.getScan(""); !("exit".equals(scan)); scan = Scanner.getScan("")) {

                try {
                    if ("reScan".equals(scan)) {
                        continue;
                    } else if ("help".equals(scan)) {
                        Prevetstvie.getHelpS();
                        continue;
                    } else if ("print".equals(scan)) {
                        slovar.print();
                        continue;
                    } else if ("err".equals(scan)) {
                        throw new ArithmeticException();
                    }

                    Collections.addAll(slovar, scan.split(" "));

                    slovar.print();

                } catch (Exception ex) {
                    System.out.println("Error " + ex.toString());
                    logs.pushLog("MainS  " + ex.toString());
                }
            }

            return logs.allPop();

        } catch (Exception ex) {
            System.out.println("Fatal error " + ex.toString());
            logs.pushLog("MainS  fatal error" + ex.toString());
            return logs.allPop();

        } finally {
            System.out.println("Выход из Программы Словаря");
        }
    }
}
