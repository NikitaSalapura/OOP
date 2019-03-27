package by.bntu.fitr.poisit.sleepwalkers.model.entity;

public class Matrix {
    public static final int DEFAULT_SIZE = 5;

    private double[][] array;

    public Matrix() {
        array = new double[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    public Matrix(double[][] array) {
        this.array = array;
    }

    public Matrix(int row, int column) {
        array = new double[row][column];
    }

    public Matrix(int size) {
        this(size, size);
    }

    public Matrix(Matrix matrix) {
        this(matrix.array.length, matrix.array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = matrix.array[i][j];
            }
        }
    }

    public int getCountRows() {
        return array.length;
    }

    public int getCountColumns() {
        return array[0].length;
    }

    public double getElement(int i, int j) {
        return array[i][j];
    }

    public void setElement(int i, int j, double element) {
        array[i][j] = element;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                builder.append(array[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
