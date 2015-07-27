package com.makedonsky94.matrix;

/**
 * Created by Sasha on 27.07.2015.
 *
 * This class for actions with two or more matrixes
 */
public enum MultipleCalculator {
    ADDITION {
        @Override
        public Matrix executeMethod(Matrix... matrixes) {
            //TODO: realization of method
            return new Matrix();
        }
    },
    SUBSTRACTION {
        @Override
        public Matrix executeMethod(Matrix... matrixes) {
            //TODO: realization of method
            return new Matrix();
        }
    };

    public abstract Matrix executeMethod(Matrix... matrixes);
}
