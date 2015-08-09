package com.gorbachevskaya.matrix;

/**
 * Created by Ангелина on 22.07.2015.
 */
public class MatrixCalcEngine {
    public static Matrix<Double> calculate (Matrix<Double> firstOperand, Matrix<Double> secondOperand, MatrixOperation op) { //throws SizeMatrixException, MultiplyMatrixException
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

    private static Matrix<Double> plus (Matrix<Double> m1, Matrix<Double> m2) {
        Double [][]ar = new Double[m1.getN()][m1.getM()];
        if ((m1.getN() == m2.getN()) && (m1.getM() == m2.getM())) {
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m1.getM(); j++) {
                    ar[i][j] = m1.getData(i, j) + m2.getData(i, j);
                }
            }
        }
        m1.setData(ar);
        return m1;
    }

    private static Matrix<Double> minus(Matrix<Double> m1, Matrix<Double> m2){
        Double [][]ar = new Double[m1.getN()][m1.getM()];
        if ((m1.getN() == m2.getN()) && (m1.getM() == m2.getM())) {
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m1.getM(); j++) {
                    ar[i][j] = m1.getData(i, j) - m2.getData(i, j);
                }
            }
        }
        m1.setData(ar);
        return m1;
    }

    private static Matrix transpose(Matrix<Double> m) {
        Matrix res = new Matrix();
        Double [][]ar = new Double[m.getM()][m.getN()];
        res.setN(m.getM());
        res.setM(m.getN());
        for (int i = 0; i < m.getM(); i++) {
            for (int j = 0; j < m.getN(); j++) {
                ar[i][j] = m.getData(j, i);
            }
        }
        res.setData(ar);
        return res;
    }

    private static Matrix<Double> multiply(Matrix<Double> m1, Matrix<Double> m2) {
        Double [][]ar = new Double[m1.getN()][m2.getM()];
        Matrix<Double> res = new Matrix();
        res.setN(m1.getN());
        res.setM(m2.getM());

        if ( m1.getM() == m2.getN()) {
            for (int i = 0; i < m1.getN(); i++) {
                for (int j = 0; j < m2.getM(); j++) {
                    ar[i][j] = 0.0;
                    for (int k = 0; k < m1.getM(); k++) {
                        ar[i][j] += m1.getData(i,k)*m2.getData(k,j);
                    }
                }
            }
        }
        res.setData(ar);
        return res;
    }
}
