package com.gorbachevskaya.matrix;

import java.util.Scanner;

/**
 * Created by Angelina on 26.07.2015.
 */
public class MatrixDoubleCalculator {
    private Matrix<Double> first;
    private Matrix<Double> second;
    private Matrix<Double> result;
    private MatrixOperation operation;

    MatrixDoubleCalculator(){
        first = new Matrix();
        second = new Matrix();
        operation = MatrixOperation.plus;
        result = new Matrix();
    }

    void calculateFromConsole() {
        Double[][] ar;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the matrix.");
        System.out.print("Rows quantity = ");
        int n = scanner.nextInt();
        first.setN(n);
        System.out.print("Columns quantity = ");
        int m = scanner.nextInt();
        first.setM(m);
        ar = new Double[n][m];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.format("Enter element in %d row %d colummn = ", i + 1, j + 1);
                ar[i][j] = scanner.nextDouble();
            }
        }
        first.setData(ar);

        first.print();


        Scanner sc = new Scanner(System.in);
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
                result = MatrixCalcEngine.calculate(first, second, operation);
                result.print();
                return;
        }


        System.out.println("Enter the matrix.");
        System.out.print("Rows quantity = ");
        n = scanner.nextInt();
        second.setN(n);
        System.out.print("Columns quantity = ");
        m = scanner.nextInt();
        second.setM(m);

        try {
            if (operation == MatrixOperation.plus || operation == MatrixOperation.minus) {
                if ( (second.getM() != first.getM()) && (first.getN() != second.getN())) {
                    throw new SizeMatrixException();
                }
            }
            else if (operation == MatrixOperation.multiply) {
                if (first.getM() != second.getN()) {
                    throw new MultiplyMatrixException();
                }
            }
        }
        catch (SizeMatrixException e) {
            System.out.println("Second matrix must have size such as first!");
            second.setN(first.getN());
            second.setM(first.getM());
        }
        catch (MultiplyMatrixException e) {
            System.out.println("Numbers of column in first matrix must be equal to row in second matrix");
            second.setN(first.getM());
        }

        ar = new Double[second.getN()][second.getM()];

        System.out.println("Enter second matrix elements:");
        for (int i = 0; i < second.getN(); i++) {
            for (int j = 0; j < second.getM(); j++) {
                System.out.format("Enter element in %d row %d column = ", i + 1, j + 1);
                ar[i][j] = scanner.nextDouble();
            }
        }
        second.setData(ar);
        second.print();


        result = MatrixCalcEngine.calculate(first, second, operation);
        System.out.println("Result:");
        result.print();
    }

}
