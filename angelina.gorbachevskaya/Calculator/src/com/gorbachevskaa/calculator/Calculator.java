package com.gorbachevskaa.calculator;

/**
 * Created by �������� on 19.07.2015.
 */
import java.util.regex.*;

public class Calculator {
    double firstNum;
    double secondNum;
    double result;
    char operation;

    public void Calculator() {
        firstNum = 0.0;
        secondNum = 0.0;
        result = 0.0;
        operation = ' ';
    }

    public void setFirstNum(double d) {
        firstNum = d;
    }

    public void setSecondNum(double d) {
        secondNum = d;
    }

    public void setOperation(char c) {
        operation = c;
    }

    public double getResult() {
        System.out.print("Result = ");
        System.out.println(result);
        return result;
    }

    /* ������� ��������� ������������ �� �������*/
    public void printCondition() {
        System.out.print(firstNum);
        System.out.print("  ");
        System.out.print(operation);
        System.out.print("  ");
        System.out.print(secondNum);
        System.out.print("  =  ");
        System.out.format("%.8f%n", result);
    }

    /* ��������� ������ ��� ���������� � ����� ���������� � ������ �������� ����� ����
     */
    public void setExpression(String str) {
        // ��������� ��������� ��������� �� ����������.(� ������� ������ � ��������������� ����������) ����������� ����� ���: �������� ����� � ������[ ]��������[ ]�������� ����� � ������
        Pattern p = Pattern.compile("^\\-?\\d+(\\.\\d{0,})?+( )*+([*+-]|/(?!0))+( )*+\\-?\\d+(\\.\\d{0,})?+$");
        Matcher m = p.matcher(str);
        boolean bArithm = m.matches();
        // ��������� ��������� ��������� �� ����������.(� ������ ������ � �������� ����������) ����������� ����� ���: ����� �����[ ]������� ��������[ ]����� �����
        // ������, ��� ������ ���������� � ���������� ��
        boolean bBits = str.matches("^\\-?\\d+[\\&\\^\\|]+\\-?\\d+$");
        if (!bArithm & !bBits) {
            System.out.println("Input error.");
            return;
        }

        String[] operands;

        // ���� �������������� �������� � ������� � ��������� ������
        if (bArithm) {
            // ��������� ������ �� �������� �� �������� ����� ��������: *, /, +.( ��� - ��������� ������)
            operands = str.split("\\*|\\+|\\/");

            // ��� �������� ����������� �� ������ �� ��������� ���������, ���� ���(�� ���� ����� ��������������� ������� = 1) ������ � ��������� ��� ���� -
            // ��� ����� ������� ������ ��������� ������
            if (operands.length == 1) {
                // ��� ����� ��� ��������: -
                setOperation('-');

                int i = str.indexOf('-', 0);

                // ���� ������� � ����, ������ ������ ������� ������������� �����
                if (i == 0) {
                    // ���� ��������� �� -, ������� ����� �������, ��� ����� ������������� ������ ��� ������� �������
                    String s = str.substring(1);
                    operands = s.split("-");

                    setFirstNum(-Double.parseDouble(operands[0]));
                }
                else {
                    operands = str.split("-");
                    setFirstNum(Double.parseDouble(operands[0]));
                }

                // ���� ������ ������� � ������� ����, ������ ��������� ��� -a--b ��� a--b (� ����� ��������� ����� � ����� ������������)
                if (operands[1].isEmpty())
                    setSecondNum(-Double.parseDouble(operands[2]));
                else
                    setSecondNum(Double.parseDouble(operands[1]));

            } else {
                // ���� ������ ����� �������� �� ������� ��������� ������� ��������
                int j = str.indexOf(operands[1]);
                setOperation(str.charAt(j - 1));

                setFirstNum(Double.parseDouble(operands[0]));
                setSecondNum(Double.parseDouble(operands[1]));
            }
        }

        // ���� ������� ��������
        if (bBits) {
            operands = str.split("\\&|\\^|\\|");
            setFirstNum(Double.parseDouble(operands[0]));
            setSecondNum(Double.parseDouble(operands[1]));
            int j = str.indexOf(operands[1]);
            setOperation(str.charAt(j - 1));
        }
    }

    /* ����� ��������������� ���������� ������������*/
    public void calculate() {
        switch (operation) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                result = firstNum / secondNum;
                break;
            case '&':
                result = ((int) secondNum) & ((int) firstNum);
                break;
            case '|':
                result = ((int) secondNum) | ((int) firstNum);
                break;
            case '^':
                result = ((int) secondNum) ^ ((int) firstNum);
                break;
            default:
                //;
                break;
        }
    }
}
