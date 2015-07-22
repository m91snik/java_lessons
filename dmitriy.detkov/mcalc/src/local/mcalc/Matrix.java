package local.mcalc;

/**
 * Created by dmitriy_detkov on 22.07.2015.
 */
public class Matrix {
    public double[][] matrixArray;
    public int rowsCount;
    public int colsCount;

    public Matrix(int rowsCount, int colsCount) {
        matrixArray = new double[rowsCount][colsCount];
    }

    public void setMatrixArray(double[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    public void size() {
        rowsCount = matrixArray.length;
        colsCount = matrixArray[0].length;
    }

    public void print() {
        this.size();
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                System.out.print(matrixArray[i][j]);
            }
            System.out.println();
        }
    }

}
