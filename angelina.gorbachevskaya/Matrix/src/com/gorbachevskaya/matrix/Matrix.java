package com.gorbachevskaya.matrix;

import java.util.Arrays;

/**
 * Created by Ангелина on 22.07.2015.
 */
public class Matrix<T> {
    private int n; // rows
    private int m; // columns
    private T[][] data;

    Matrix(){};

    Matrix(int n, int m, T[][] ar) {
        this.n = n;
        this.m = m;
        data = (T[][])new Object[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = ar[i][j];
            }
        }
    };

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public T getData(int i, int j) {
        return data[i][j];
    }

    public void setData(T[][] data) {
        this.data = (T[][]) new Object[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
