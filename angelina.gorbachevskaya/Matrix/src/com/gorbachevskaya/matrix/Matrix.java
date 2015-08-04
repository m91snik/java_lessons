package com.gorbachevskaya.matrix;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Ангелина on 22.07.2015.
 */
public class Matrix {
    private int n; // rows
    private int m; // columns
    private double[][] data;

    Matrix(){};

    Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        data = new double[this.n][this.m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                data[i][j] = 0.0;
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

    public double getData(int i, int j) {
        return data[i][j];
    }

    // try with annotation(i > 0 and j > 0)
    public void setData(int i, int j, double data) {
        if ((i < n) && (j < m)) {
            this.data[i][j] = data;
        }
    }

    public void print() {
        System.out.println( this.getClass().getName() );
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void in(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the matrix.");
        System.out.print("Rows quantity = ");
        n = scanner.nextInt();
        System.out.print("Columns quantity = ");
        m = scanner.nextInt();

        data = new double[n][m];

//        System.out.println("Enter matrix elements:");
//        String str = scanner.nextLine();
//        System.out.print("fgslkjgfksfdjgksjdlkfjgsdg2");
//        String[] elements = str.split(" ");
//        if (elements.length != m*n)
//            return;
//        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++){
                    System.out.format("Enter element in %d row %d colummn = ", i+1, j+1);
                    data[i][j] = scanner.nextDouble();
//                    data[i][j] = Double.valueOf(elements[i*n+j]);
                }
            }



    }
}
