package com.kamyshovcorp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.kamyshovcorp.Operation.valueOf;

/**
 * Created by kamyshov.sergey on 22.07.15.
 */
public class Main {
    List<String> supportedOperations = Arrays.asList("ADD", "SUBTRACT", "MULTIPLY", "DIVIDE");

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("Hello, you have 2 matrices:");

        MatrixInfo matrixOne = new MatrixInfo();
        MatrixInfo matrixTwo = new MatrixInfo();

        MatrixHandler.print(matrixOne);
        System.out.println("and");
        MatrixHandler.print(matrixTwo);

        System.out.println("What do you want to do with them? Please type one of them: ADD, SUBTRACT, MULTIPLY, DIVIDE?");
        System.out.print("Enter operation sign here: ");
        Scanner scanner = new Scanner(System.in);
        String inputOperation = scanner.nextLine().toUpperCase();

        MatrixInfo resultMatrix = null;
        if (supportedOperations.contains(inputOperation)) {
            Operation operation = valueOf(inputOperation);
            switch (operation) {
                case ADD:
                    resultMatrix = MatrixHandler.add(matrixOne, matrixTwo);
                    break;
                case SUBTRACT:
                    resultMatrix = MatrixHandler.subtract(matrixOne, matrixTwo);
                    break;
                case MULTIPLY:
                    resultMatrix = MatrixHandler.multiply(matrixOne, matrixTwo);
                    break;
                case DIVIDE:
                    resultMatrix = MatrixHandler.divide(matrixOne, matrixTwo);
                    break;
            }
        } else {
            System.out.println(String.format("Sorry, but operarion %s is not supported.", inputOperation));
        }

        if (resultMatrix != null) {
            System.out.println("The result:");
            MatrixHandler.print(resultMatrix);
        }
        System.out.println("The end.");
    }
}
