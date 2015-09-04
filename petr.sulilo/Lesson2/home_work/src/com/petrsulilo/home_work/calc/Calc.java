package com.petrsulilo.home_work.calc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Petr on 20.07.2015.
 */
public class Calc {
    //�������� ������ � ����������
    //T
    //E
    private Stack T; //���� �����������
    private Stack E; //���� ��������������
    private static String validValues = "123456890()+-*/^";// ���������� ��������
    private char[][] transitionTable =
            {
                    {'X','$','(', '+', '-', '*', '/',  ')'},
                    {'$',  6,  1,   1,   1,   1,   1,   5 },
                    {'(',  5,  1,   1,   1,   1,   1,   3 },
                    {'+',  4,  1,   2,   2,   1,   1,   4 },
                    {'-',  4,  1,   2,   2,   1,   1,   4 },
                    {'*',  4,  1,   4,   4,   2,   2,   4 },
                    {'/',  4,  1,   4,   4,   2,   2,   4 },
            };//������� ���������
    private static String operands = "()+-*/^";
    public static void main(String... args) throws IOException {
        String str = null;
        /*byte[] lByte = new byte[100];
        System.out.println(operands.indexOf('X'));
        System.in.read(lByte);
        str = new String(lByte);*/
        str = "22+33-55*60=";
        System.out.println("Start");
        String[] inputStr = parser(str);
        System.out.println("text");
        System.out.println(inputStr[2]);
        System.out.println("END");
    }
    public int start(char inChar)
    {
        return 0;
    }
    public static String[] parser(String str)
    {

        //�������� ��� ��� ������� �����

        //������ ������������ �������
        for (int i = 0; i < str.length(); i++) {
            if (validValues.indexOf(str.toCharArray()[i]) == -1) {
                str = str.replaceAll(str.substring(i,i), "");
            }
        }
        //������ ������������� �����
        for (int i = 1; i < str.length(); i++) {
            // ���� ������ - ����
            if ( operands.indexOf(str.toCharArray()[i-1]) != -1 &&
                 operands.indexOf(str.toCharArray()[1])   != -1) {
                if (str.toCharArray()[i - 1] == str.toCharArray()[i]) {
                    str.replaceAll(str.substring(i - 1, i), str.substring(1));
                    i--;
                }
            }
        }
        //return str.split("[0-9]+|[\\-\\+\\*\\^]");
        return str.split("[\\-\\+\\*\\^]");
    }
}
