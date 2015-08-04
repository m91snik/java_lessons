package com.gorbachevskaya.matrix;

import java.util.Scanner;

/**
 * Created by Ангелина on 26.07.2015.
 */
public class MatrixCalculator {
    private Matrix first;
    private Matrix second;
    private Matrix result;
    private MatrixOperation operation;

    MatrixCalculator(){
        first = new Matrix();
        second = new Matrix();
        operation = MatrixOperation.plus;
        result = new Matrix();
    }

    MatrixCalculator(Matrix m1, Matrix m2) {
        first = m1;
        second = m2;
        operation = MatrixOperation.plus;
        result = new Matrix();
    }

    void calculateFromConsole()
    {
        first.in();

        Scanner sc = new Scanner(System.in);
        first.print();
        System.out.print("Enter operation: ");
        String str = sc.next();

        switch (str) {
            case "+":
                operation = MatrixOperation.plus;
                break;
            case "-":
                operation = MatrixOperation.minus;
                break;
            case "*":
                operation = MatrixOperation.multiply;
                break;
            case "~":
                operation = MatrixOperation.transpose;
                break;
        }

        second.in();
        second.print();

        result = MatrixCalcEngine.calculate(first, second, operation);
        result.print();
    }

    void calculate(){
        result = MatrixCalcEngine.calculate(first, second, operation);
    }

    public Matrix getResult() {
        return result;
    }

    public void setFirst(Matrix first) {
        this.first = first;
    }

    public void setSecond(Matrix second) {
        this.second = second;
    }

    public void setOperation(MatrixOperation operation) {
        this.operation = operation;
    }
}
