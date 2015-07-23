package com.stanislav.matrixcalc;

/**
 * Created by stanislav on 22.07.15.
 */
public enum Operations {
    PLUS("+") {

        @Override
        public String toString() {
            return "Операция сложения. С чем складываем? ";
        }
    },
    MINUS("-") {

        @Override
        public String toString() {
            return "Операция вычитания. Что вычитаем? ";
        }
    },
    MULTI("*") {

        @Override
        public String toString() {
            return "Операция умножения. С чем умножаем? ";
        }
    },
    TRANSP("T") {

        @Override
        public String toString() {
            return "[--------- Транспонирование матрицы ---------]";
        }
    };

    String type;

    Operations(String type) {
        this.type = type;
    }
}
