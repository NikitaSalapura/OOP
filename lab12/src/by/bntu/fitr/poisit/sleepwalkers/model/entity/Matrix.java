package by.bntu.fitr.poisit.sleepwalkers.model.entity;


import by.bntu.fitr.poisit.sleepwalkers.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullValueException;

public class Matrix {
    public static final int DEFAULT_SIZE = 5;

    private static final String DIMENSION_EXCEPTION_MSG = "Wrong matrix dimension!";
    private static final String NULL_EXCEPTION_MSG = "Null matrix is not allowed!";

    private double[][] array;

    public Matrix() {
        initDefault();
    }

    public Matrix(int row, int column) {
        if (checkForPositive(row, column)) {
            array = new double[row][column];
        } else {
            initDefault();
        }
    }

    public Matrix(int size) {
        this(size, size);
    }

    public Matrix(double[][] array) {
        if (!checkForNull(array)) {
            copyArray(array);
        } else {
            initDefault();
        }
    }

    public Matrix(Matrix matrix) {
        if (!checkForNull(matrix)) {
            copyArray(matrix.array);
        } else {
            initDefault();
        }
    }

    public int getRowsCount() {
        return array.length;
    }

    public int getColumnsCount() {
        return array[0].length;
    }

    private boolean checkForPositive(int i, int j) {
        return i > 0 && j > 0;
    }

    private boolean checkForNull(double[][] array) {
        return array == null;
    }

    private boolean checkForNull(Matrix matrix) {
        return matrix == null;
    }

    private void checkForNullWithException(Matrix matrix) throws NullValueException {
        if (checkForNull(matrix)) {
            throw new NullValueException(NULL_EXCEPTION_MSG);
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

    public void setElement(int i, int j, double element)
            throws MatrixDimensionException {
        checkRange(i, j);
        array[i][j] = element;
    }

    private void copyArray(double[][] array) {
        this.array = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy
                    (array[i], 0, this.array[i], 0, this.array[i].length);
        }
    }

    private void initDefault() {
        this.array = new double[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public void setMatrix(Matrix matrix) throws NullValueException {
        checkForNullWithException(matrix);
        copyArray(matrix.array);
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
