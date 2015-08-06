package com.stanislav.matrixcalc;

/**
 * Created by stanislav on 27.07.15.
 */
public class Calc {
    private int cols;
    private int rows;
    private double[][] matrix;
    private double[][] result;

    Matrix matrixClass = new Matrix();
    Input input = new Input();

    public void getColsRows() {
        System.out.print("Количество строк в матрице: ");
        rows = input.returnInt();

        System.out.print("Количество столбцов в матрице: ");
        cols = input.returnInt();
    }

    public void inputMatrix() {

        matrix = matrixClass.fillMatrix(cols, rows);
        matrixClass.formattedOutput(matrix);
    }

    public void getOperation() throws CalcException {

        Operation operation = new Operation();
        System.out.println(
                "Введите операцию:\n + - сложение,\n - - вычитание,\n * - умножение,\n Т - транспонирование"
        );
        String type = input.returnString();

        if (Operations.TRANSP.type.equals(type)) {
            System.out.println(Operations.TRANSP.toString());

            result = operation.transparency(matrix);
        } else if (type.matches("[\\+|\\-|\\*|T]")) {

            switch (type) {
                case "+":
                    Operations.PLUS.toString();
                    break;
                case "-":
                    Operations.MINUS.toString();
                    break;
                case "*":
                    Operations.MULTI.toString();
                    break;
            }

            System.out.println("[1 - другая матрица, 2 - число]");

            String action = input.returnString();

            if (Choise.MATRIX.choise.equals(action)) {
                double[][] newMatrix = matrixClass.fillMatrix(cols, rows);

                result = operation.twoMatrixOperations(type, matrix, newMatrix);
            } else if (Choise.DIGIT.choise.equals(action)) {
                result = operation.matrixAndDigitOperations(type, matrix);
            } else {
                throw new CalcException("Unknown type!");
            }
        } else {
            throw new CalcException("Unknown operation!");
        }
    }

    public void showResult() {
        System.out.println("Результат: ");
        matrixClass.formattedOutput(result);
    }
}
