package com.gorbachevskaya.matrix;

/**
 * Created by Ангелина on 22.07.2015.
 */
public class MatrixCalcEngine {
    public static Matrix calculate(Matrix firstOperand, Matrix secondOperand, MatrixOperation op){
        switch (op) {
            case plus:
                return plus(firstOperand, secondOperand);
            case minus:
                return minus(firstOperand, secondOperand);
            case multiply:
                return multiply(firstOperand, secondOperand);
            case transpose:
                return transpose(firstOperand);
        }
        return firstOperand;
    }

    private static Matrix plus(Matrix m1, Matrix m2) {
        if ((m1.getN() == m2.getN()) && (m1.getM() == m2.getM())) {
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m1.getM(); j++) {
                    double d = m1.getData(i, j) + m2.getData(i, j);
                    m1.setData(i, j, d);
                }
            }
        }
        else {
            System.out.println("Matrices with different size. Opertion impossible.");
        }

        return m1;
    }

    private static Matrix minus(Matrix m1, Matrix m2) {
        if ((m1.getN() == m2.getN()) && (m1.getM() == m2.getM())) {
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m1.getM(); j++) {
                    double d = m1.getData(i, j) - m2.getData(i, j);
                    m1.setData(i, j, d);
                }
            }
        }
        else {
            System.out.println("Matrices with different size. Opertion impossible.");
        }

        return m1;
    }

    private static Matrix transpose(Matrix m) {
        Matrix res = new Matrix(m.getM(), m.getN());
        for (int i = 0; i < res.getN(); i++) {
            for (int j = 0; j < res.getM(); j++) {
                res.setData(i, j, m.getData(j, i));
            }
        }
        return res;
    }

    private static Matrix multiply(Matrix m1, Matrix m2) {
        if ( m1.getM() == m2.getN()) {
            Matrix res = new Matrix(m1.getN(), m2.getM());
            for (int i = 0; i < res.getN(); i++) {
                for (int j = 0; j < res.getM(); j++) {
                    res.setData(i, j, 0.0);
                    for (int k = 0; k < m1.getM(); k++) {
                        double d = res.getData(i,j) + m1.getData(i,k)*m2.getData(k,j);
                        res.setData(i, j, d);
                    }
                }
            }
            return res;
        }
        else {
            System.out.println("Operation impossible. The matrix product is defined only if the number of columns in first matrix is equal to the number of rows in second.");
            return m1;
        }
    }
}
