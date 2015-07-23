package local.mcalc;

/**
 * Created by dmitriy_detkov on 22.07.2015.
 */
public class Matrix {
    public double[][] matrixArray;

    public Matrix(int rowSize , int colSize) {
        matrixArray = new double[rowSize][colSize];
    }

    public void setMatrixArray(double[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    public int getRowSize() {
        return matrixArray.length;
    }

    public int getColSize() {
        return matrixArray[0].length;
    }

    public void print() {
        int rowSize = this.getRowSize();
        int colSize = this.getColSize();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(matrixArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void transp() {
        int rowSize = this.getRowSize();
        int colSize = this.getColSize();
        double[][] product = new double[colSize][rowSize];
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                product[i][j] = matrixArray[j][i];
            }
        }
        setMatrixArray(product);
    }
}