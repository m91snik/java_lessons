package com.stanislav.matrixcalc;

/**
 * Created by stanislav on 22.07.15.
 */

public class Main {

    public static void main(String[] args) throws CalcException{

        Calc calc = new Calc();
        Input input = new Input();

        String exit;

        do {

            calc.getColsRows();
            calc.inputMatrix();
            calc.getOperation();
            calc.showResult();

            System.out.print("Выйти из программы? [y/n] ");
            exit = input.returnString();

        } while (!exit.equals("y"));
    }
}
