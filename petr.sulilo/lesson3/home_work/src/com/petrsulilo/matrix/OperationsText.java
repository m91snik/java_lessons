package com.petrsulilo.matrix;

/**
 * Created by Petr on 23.07.2015.
 */
public enum OperationsText {
    Multiplication("Умножить"), Division("Разделить"), Addition("Сложить"), Subtraction("Вычесть");

    private String operation;
    OperationsText(String name)
    {
        operation = name;
    }
    String getName()
    {
        return operation;
    };

}
