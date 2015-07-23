package local.mcalc;

/**
 * Created by dmitriy_detkov on 23.07.2015.
 */
public enum MatrixOperations {
    ADDITION {
        Matrix Addition(Matrix a, Matrix b) {
            return a.matrixArray * b.matrixArray;
        }
    }, SUBTRACTION, MULTIPLICATION;
}
