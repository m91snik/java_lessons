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
     * �������������� ���������
     */
    private String command = "";

    /**
     * ������� �������������� ��������
     */
    private String operationPattern = "\\+\\-\\*\\/";

    /**
     * ������������ ��������
     */
    private String operationPatternFirst = "\\*\\/";

    /**
     * ����� ������������ ��������
     */
    private String operationPatternSecond = "\\+\\-";

    /**
     * ��������� �������������� ��������� �� ������ System.in
     */
    public void readCommand() throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        this.command = buffer.readLine();
        if(!this.getRegex(this.command, "^[0-9"+operationPattern+"\\(\\)]+$")) // ���������, �������� �� ��������� ��������������, ���� ���, �� ������� ����������
            throw new Exception("������� �������� ��������!");
    }

    /**
     * ��������� ��������� ��������� �������������� ���������
     */
    public void executeCommand() {
        while(!this.isNumber(this.command)) {
            List<String> list = this.getRegexResult(this.command, "[-]?\\d+["+operationPatternFirst+"][-]?\\d+");
            if(list.isEmpty())
                list = this.getRegexResult(this.command, "[-]?\\d+["+operationPatternSecond+"][-]?\\d+"); // ���� �� ����� �������� � ������������� ����������, �� ���� � ����������� ����
            this.command = this.command.replace(list.get(0), this.executeCommand(list.get(0))); // ��������� ������ ��������� �� ��������� ����������
            this.command = this.removeBrackets(this.command);
        }
        System.out.println(this.command);
    }


    /**
     * ������������� ��������.
     * ����������� ��������� ��������������� ����������, ���������� �� 2-� ��������� (�����)
     *
     * @param string
     * @return ��������� ����������
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
     * ���������� ��������� ���������� ����������� ���������
     *
     * @param string ������, � ������� ������� �����
     * @param pattern �������, �� �������� ������� �����
     * @return ��������� ���������� ����������� ���������
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
     * ����������, ���������� �� ���������� � ������ string �� ����������� ��������� pattern
     *
     * @param string ������, � ������� ������� �����
     * @param pattern �������, �� �������� ������� �����
     * @return ��������� ��������� ����������� ���������
     */
    private boolean getRegex(String string, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        if(m.find())
            return true;
        return false;
    }

    /**
     * ���������, �������� �� ������ ������
     *
     * @param string ������ ��� ��������
     * @return ��������� ��������
     */
    private boolean isNumber(String string) {
        return this.getRegex(string, "^[-]?\\d+$");
    }

    /**
     * ���� � ������� �������� ���� �����, �� ������ ���������
     *
     * @param string ������, � ������� ������ ����������
     * @return ��������������� ������
     */
    private String removeBrackets(String string) {
        List<String> list = this.getRegexResult(string, "[\\(][-]?\\d+[\\)]");
        if(!list.isEmpty())
            string = string.replace(list.get(0), this.getRegexResult(list.get(0), "(?<=\\()[-]?\\d+(?=\\))").get(0));
        return string;
    }
}
