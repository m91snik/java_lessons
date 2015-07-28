package com.makedonsky94.matrix;

/**
 * Created by Sasha on 27.07.2015.
 *
 * This class for actions with one matrix
 */
public enum SimpleCalculator {
    TRANSPOSING() {
        /**
         * This method carries out transposing of one Matrix variable
         *
         * @param matrix
         * @return result of transposing
         */
        @Override
        public Matrix executeAction(Matrix matrix) {
            int rows = matrix.getColumnCount();
            int cols = matrix.getRowCount();
            double[][] oldMatrix = matrix.getMatrix();
            double[][] doubleMatrix = new double[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    doubleMatrix[i][j] = oldMatrix[j][i];
                }
            }
            Matrix newMatrix = new Matrix();
            newMatrix.setMatrix(doubleMatrix);
            return newMatrix;
        }
    },
    INVERSE() {
        /**
         * This method carries out inverse matrix
         *
         * @param matrix
         * @return inverse matrix
         */
        @Override
        public Matrix executeAction(Matrix matrix) {
            //TODO: realization of method
            return new Matrix();
        }
    };

    public abstract Matrix executeAction(Matrix matrix);

}
