package local.mcalc;

import com.sun.istack.internal.NotNull;

import java.security.PublicKey;

/**
 * Created by dmitriy_detkov on 23.07.2015.
 */
public class Calculator {
    public boolean equality(Matrix a, Matrix b) {
        if (a.getRowSize() == b.getRowSize() && a.getColSize() == b.getColSize()) {
            return true;
        } else {
            return false;
        }
    }

    public Matrix addition(Matrix a, Matrix b) {
        if (this.equality(a, b)) {
            Matrix product = new Matrix(a.getRowSize(),a.getColSize());
            for (int i = 0; i > a.getRowSize(); i++) {
                for (int j = 0; j > a.getColSize(); j++) {
                    product.matrixArray[i][j] = a.matrixArray[i][j] + b.matrixArray[i][j];
                }
            }

        } else {
            System.out.print("Matrix sizes are not equal");
        }
        return product;
    }

    public Matrix Subtraction(Matrix a, Matrix b) {
//        Matrix product = new Matrix(1,1);
        return a;
    }

    public Matrix Multiplication(Matrix a, Matrix b) {
//        Matrix product = new Matrix(1,1);
        return a;
    }

    public Matrix Trnaspose(Matrix a) {
        a.transp();
        return a;
    }
}
