package local.mcalc;

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

    public boolean consistency(Matrix a, Matrix b) {
        if (a.getColSize() ==  b.getRowSize()) {
            return true;
        } else {
            return false;
        }
    }

    public Matrix addition(Matrix a, Matrix b) {
        if (this.equality(a, b)) {
            Matrix product = new Matrix(a.getRowSize(), a.getColSize());
            for (int i = 0; i < a.getRowSize(); i++) {
                for (int j = 0; j < a.getColSize(); j++) {
                    product.matrixArray[i][j] = a.matrixArray[i][j] + b.matrixArray[i][j];
                }
            }
            return product;
        } else {
            System.out.print("Matrix sizes are not equal");
            return new Matrix(1, 1);
        }
    }

    public Matrix subtraction(Matrix a, Matrix b) {
        if (this.equality(a, b)) {
            Matrix product = new Matrix(a.getRowSize(), a.getColSize());
            for (int i = 0; i < a.getRowSize(); i++) {
                for (int j = 0; j < a.getColSize(); j++) {
                    product.matrixArray[i][j] = a.matrixArray[i][j] - b.matrixArray[i][j];
                }
            }
            return product;
        } else {
            System.out.println("Matrix sizes are not equal");
            return new Matrix(1, 1);
        }
    }

    public Matrix multiplication(Matrix a, Matrix b) {
        if (this.consistency(a, b)) {
            Matrix product = new Matrix(a.getRowSize(), b.getColSize());
            for (int i = 0; i < a.getRowSize(); i++) {
                for (int j = 0; j < b.getColSize(); j++) {
                    for (int k = 0; k < b.getRowSize();k++) {
                        product.matrixArray[i][j] += a.matrixArray[i][k] * b.matrixArray[k][j];

                    }
                }
            }
            return product;
        } else {
            System.out.println("Matrix sizes are not equal");
            return new Matrix(1, 1);
        }
    }
}
