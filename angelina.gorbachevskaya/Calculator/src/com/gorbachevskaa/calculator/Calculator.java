package com.gorbachevskaa.calculator;

/**
 * Created by Ангелина on 19.07.2015.
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

    /* Выводит состояние калькулятора на консоль*/
    public void printCondition() {
        System.out.print(firstNum);
        System.out.print("  ");
        System.out.print(operation);
        System.out.print("  ");
        System.out.print(secondNum);
        System.out.print("  =  ");
        System.out.format("%.8f%n", result);
    }

    /* принимает строку для вычисления с двумя операндами и знаком операции между ними
     */
    public void setExpression(String str) {
        // проверяем введенное выражение на валидность.(в случчае работы с арифметическими операциями) Допускается такой вид: знаковое число с точкой[ ]операция[ ]знаковое число с точкой
        Pattern p = Pattern.compile("^\\-?\\d+(\\.\\d{0,})?+( )*+([*+-]|/(?!0))+( )*+\\-?\\d+(\\.\\d{0,})?+$");
        Matcher m = p.matcher(str);
        boolean bArithm = m.matches();
        // проверяем введенное выражение на валидность.(в случае работы с битовыми операциями) Допускается такой вид: целое число[ ]битовая операция[ ]целое число
        // замечу, что работа происходит в десятичной СИ
        boolean bBits = str.matches("^\\-?\\d+[\\&\\^\\|]+\\-?\\d+$");
        if (!bArithm & !bBits) {
            System.out.println("Input error.");
            return;
        }

        String[] operands;

        // если арифметические операции с числами с плавающей точкой
        if (bArithm) {
            // разделяем строку на операнды по признаку знака операции: *, /, +.( для - отдельный случай)
            operands = str.split("\\*|\\+|\\/");

            // это проверка разделилась ли строка по заданному выражению, если нет(то есть длина результирующего массива = 1) значит в выражении был знак -
            // для этого случчая другая обработка строки
            if (operands.length == 1) {
                // уже знаем что операция: -
                setOperation('-');

                int i = str.indexOf('-', 0);

                // если заходим в блок, значит первый операнд отрицательное число
                if (i == 0) {
                    // надо разделить по -, который между числами, для этого рассматриваем строку без первого символа
                    String s = str.substring(1);
                    operands = s.split("-");

                    setFirstNum(-Double.parseDouble(operands[0]));
                }
                else {
                    operands = str.split("-");
                    setFirstNum(Double.parseDouble(operands[0]));
                }

                // если второй элемент в массиве пуст, значит выражение вид -a--b или a--b (я делаю возможным такое в своем калькуляторе)
                if (operands[1].isEmpty())
                    setSecondNum(-Double.parseDouble(operands[2]));
                else
                    setSecondNum(Double.parseDouble(operands[1]));

            } else {
                // ищем индекс знака операции по первому вхождению второго операнда
                int j = str.indexOf(operands[1]);
                setOperation(str.charAt(j - 1));

                setFirstNum(Double.parseDouble(operands[0]));
                setSecondNum(Double.parseDouble(operands[1]));
            }
        }

        // если битовая операция
        if (bBits) {
            operands = str.split("\\&|\\^|\\|");
            setFirstNum(Double.parseDouble(operands[0]));
            setSecondNum(Double.parseDouble(operands[1]));
            int j = str.indexOf(operands[1]);
            setOperation(str.charAt(j - 1));
        }
    }

    /* здесь непосредственно вычисления калькулятора*/
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
