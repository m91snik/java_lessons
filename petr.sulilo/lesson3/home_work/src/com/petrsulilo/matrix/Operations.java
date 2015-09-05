package com.petrsulilo.matrix;

/**
 * Created by Petr on 23.07.2015.
 */
public enum Operations {
    Multiplication("*"), Division("/"), Addition("+"), Subtraction("-"), Wrong("Wrong");

    private String operation;
    Operations(String name)
    {
        operation = name;
    }
    String getName()
    {
        return operation;
    };
}
