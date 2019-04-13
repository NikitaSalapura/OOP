package by.bntu.fitr.poisit.sleepwalkers.model.entity;


import by.bntu.fitr.poisit.sleepwalkers.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullMatrixException;

import java.util.Random;

public class Matrix {
    public static final int DEFAULT_SIZE = 5;
//    public static final double ROUNDING = 100;

    private static final String DIMENSION_EXCEPTION_MSG = "Wrong matrix dimension!";
    private static final String NULL_EXCEPTION_MSG = "Null matrix is not allowed!";
    private double[][] array;

    public Matrix() {
        array = new double[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public Matrix(int row, int column) throws MatrixDimensionException {
        checkForPositive(row, column);
        array = new double[row][column];
    }

    public Matrix(int size) throws MatrixDimensionException {
        this(size, size);
    }

//    public Matrix(int row, int column, double min, double max)
//            throws MatrixDimensionException {
//        this(row, column);
//        if (min < max) {
//            Random random = new Random();
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array[i].length; j++) {
//                    array[i][j] = Math.round
//                            ((random.nextDouble() * (max - min) + min)
//                                    * ROUNDING) / ROUNDING;
//                }
//            }
//        }
//    }


    public Matrix(double[][] array)
            throws MatrixDimensionException, NullMatrixException {
        checkNull(array);
        this.array = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].length >= 0) {
                System.arraycopy
                        (array[i], 0, this.array[i], 0, this.array[i].length);
            }
        }
    }

    public Matrix(Matrix matrix)
            throws MatrixDimensionException, NullMatrixException {
        this(matrix.array);
    }

    public int getRowsCount() {
        return array.length;
    }

    public int getColumnsCount() {
        return array[0].length;
    }

    private void checkForPositive(int i, int j) throws MatrixDimensionException {
        if (i <= 0 || j <= 0) {
            throw new MatrixDimensionException(DIMENSION_EXCEPTION_MSG);
        }
    }

    private void checkNull(double[][] array) throws NullMatrixException {
        if (array == null) {
            throw new NullMatrixException(NULL_EXCEPTION_MSG);
        }
    }

    private String outOfBoundsMsg(int i, int j) {
        return DIMENSION_EXCEPTION_MSG + "\ni = " + i + ", j = " + j
                + "\nSize: [" + getRowsCount() + "][" + getColumnsCount() + "]";
    }

    private void checkRange(int i, int j) throws MatrixDimensionException {
        if (i < 0 || i >= getRowsCount() || j < 0 || j >= getColumnsCount()) {
            throw new MatrixDimensionException(outOfBoundsMsg(i, j));
        }
    }

    public double getElement(int i, int j) throws MatrixDimensionException {
        checkRange(i, j);
        return array[i][j];
    }

    public void setElement(int i, int j, double element) throws MatrixDimensionException {
        checkRange(i, j);
        array[i][j] = element;
    }

    public void setMatrix(Matrix matrix) {
        array = new double[matrix.getRowsCount()][matrix.getColumnsCount()];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy
                    (matrix.array[i], 0, array[i], 0, array[i].length);

        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (double[] row : array) {
            for (double column : row) {
                builder.append(column).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
