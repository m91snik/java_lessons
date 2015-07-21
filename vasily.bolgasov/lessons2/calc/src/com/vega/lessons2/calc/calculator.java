package com.vega.lessons2.calc;

/**
 * Created by Veg'Zul on 18.07.2015.
 */
import java.io.*;
import java.util.Scanner;


public class calculator {

    public static void main(String[] args) throws IOException {

        Scanner vvod = new Scanner(System.in);
        System.out.print("Operation: ");
        String doing = vvod.next();
        System.out.print("x: ");
        Integer x = vvod.nextInt();
        System.out.print("y: ");
        Integer y = vvod.nextInt();
        Integer rez = 0;

        switch(doing){
            case "+": rez = x+y; break;
            case "-": rez = x-y; break;
            case "*": rez = x*y; break;
            case "/": rez = x/y; break;
            case "&": rez = x&y; break;
            case "|": rez = x|y; break;
            case ">>": rez = x>>y; break;
            case ">>>": rez = x>>>y; break;
            case "<<": rez = x<<y; break;
            case "&=": rez = x&=y; break;
            case "|=": rez = x|=y; break;
            case "^=": rez = x^=y; break;
            case ">>=": rez = x>>=y; break;
            case ">>>=": rez = x>>>=y; break;
            case "<<=": rez = x<<=y; break;
            default: doing = "bad"; break;
        }

        if(doing!="bad") {
            System.out.println(x +doing + y+"="+rez);
        }else{
            System.out.println("This not operation");
        }

    }

}
