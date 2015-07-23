package com.gorbachevskaya.matrix;

/**
 * Created by Ангелина on 22.07.2015.
 */
public class MatrxCalc {
    private Operation op;
    private Matrix firstOperand;
    private Matrix secondOperand;
    private Matrix result;

    MatrxCalc() {
        this(new Matrix(), new Matrix(), "+");
    }

    MatrxCalc(Matrix m1, Matrix m2, String op) {
        firstOperand = m1;
        secondOperand = m2;

        if ( op.matches("[\\+|\\-|\\*|\\-~]") ) {
            switch (op) {
                case "+":
                    this.op = Operation.plus;
                    break;
                case "-":
                    this.op = Operation.minus;
                    break;
                case "*":
                    this.op = Operation.multiply;
                    break;
                case "~":
                    this.op = Operation.transpose;
                    break;
            }
        }

    }

    public Matrix getResult() {
        return result;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public Matrix calculate(){
        switch (op) {
            case plus:
                result = plus(firstOperand, secondOperand);
                break;
            case minus:
                result = minus(firstOperand, secondOperand);
                break;
            case multiply:
                result = multiply(firstOperand, secondOperand);
                break;
            case transpose:
                result = transpose(firstOperand);
                break;
        }
        return result;
    }

    private Matrix plus(Matrix m1, Matrix m2) {
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

    private Matrix minus(Matrix m1, Matrix m2) {
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

    private Matrix transpose(Matrix m) {
        Matrix res = new Matrix(m.getM(), m.getN());
        for (int i = 0; i < res.getN(); i++) {
            for (int j = 0; j < res.getM(); j++) {
                res.setData(i, j, m.getData(j, i));
            }
        }
        return res;
    }

    private Matrix multiply(Matrix m1, Matrix m2) {
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
