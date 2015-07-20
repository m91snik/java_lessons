package com.lessons.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sasha on 20.07.2015.
 */
public class Calculator {
    public Calculator() {

    }

    /**
     * Арифметическое выражение
     */
    private String command = "";


    private String printCommand = "";

    /**
     * Паттерн арифметических операций
     */
    private String operationPattern = "\\+\\-\\*\\/";

    /**
     * Приоритетные операции
     */
    private String operationPatternFirst = "\\*\\/";

    /**
     * Менее приоритетные операции
     */
    private String operationPatternSecond = "\\+\\-";

    /**
     * Считывает арифметическое выражение из потока System.in
     */
    public void readCommand() throws Exception {
        System.out.println("Введите арифметическое выражение, например (5+(3*(3-2)))/2");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        this.command = buffer.readLine();
        if(!this.getRegex(this.command, "^[0-9"+operationPattern+"\\(\\)]+$")) // Проверяем, является ли выражение арифметическим, если нет, то бросаем исключение
            throw new Exception("Введена неверная комманда!");
    }

    /**
     * Выполняет последнее считанное арифметическое выражение
     */
    public void executeCommand() {
        printCommand = command;
        while(!this.isNumber(this.command)) {
            List<String> list = this.getRegexResult(this.command, "[-]?\\d+["+operationPatternFirst+"][-]?\\d+");
            if(list.isEmpty())
                list = this.getRegexResult(this.command, "[-]?\\d+["+operationPatternSecond+"][-]?\\d+"); // Если не нашли операции с приоритетными операндами, то ищем с приоритетом ниже
            this.command = this.command.replace(list.get(0), this.executeCommand(list.get(0))); // Выполняем замену выражения на результат вычисления
            this.command = this.removeBrackets(this.command);
        }
        System.out.printf("Результат выражения %s=%s \n", this.printCommand, this.command);
    }


    /**
     * Перегруженный оператор.
     * Высчитывает результат арифметического вывражения, состоящего из 2-х элементов (чисел)
     *
     * @param string
     * @return Результат вычисления
     */
    private String executeCommand(String string) {
        int number1 = Integer.parseInt(this.getRegexResult(string, "^[-]?\\d+").get(0));
        String operations = "\\d+$";
        if(this.getRegex(string, "\\D{2}"))
            operations = "[-]?" + operations;
        int number2 = Integer.parseInt(this.getRegexResult(string, operations).get(0));
        String operation = this.getRegexResult(string, "["+operationPattern+"]").get(0);
        switch (operation) {
            case "+":
                return ((Integer)(number1 + number2)).toString();
            case "-":
                return ((Integer)(number1 - number2)).toString();
            case "*":
                return ((Integer)(number1 * number2)).toString();
            case "/":
                return ((Integer)(number1 / number2)).toString();
        }
        return "0";
    }

    /**
     * Возвращает результат выполнения регулярного выражения
     *
     * @param string Строка, в которой ведется поиск
     * @param pattern Паттерн, по которому ведется поиск
     * @return Результат выполнения регулярного выражения
     */
    private List<String> getRegexResult(String string, String pattern) {
        List<String> regexResult = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        while(m.find()) {
            regexResult.add(m.group());
        }
        return regexResult;
    }

    /**
     * Определяет, существуют ли совпадения в строке string по регулярному выражению pattern
     *
     * @param string Строка, в которой ведется поиск
     * @param pattern Паттерн, по которому ведется поиск
     * @return Результат выполения регулярного выражения
     */
    private boolean getRegex(String string, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        if(m.find())
            return true;
        return false;
    }

    /**
     * Проверяет, является ли строка числом
     *
     * @param string Строка для проверки
     * @return Результат проверки
     */
    private boolean isNumber(String string) {
        return this.getRegex(string, "^[-]?\\d+$");
    }

    /**
     * Если в скобках остается одно число, то скобки убираются
     *
     * @param string Строка, в которой ищутся совпадения
     * @return Форматированная строка
     */
    private String removeBrackets(String string) {
        List<String> list = this.getRegexResult(string, "[\\(][-]?\\d+[\\)]");
        if(!list.isEmpty())
            string = string.replace(list.get(0), this.getRegexResult(list.get(0), "(?<=\\()[-]?\\d+(?=\\))").get(0));
        return string;
    }
}
