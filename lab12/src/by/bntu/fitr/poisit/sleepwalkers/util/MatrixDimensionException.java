package by.bntu.fitr.poisit.sleepwalkers.util;

public class MatrixDimensionException extends Exception {
    public final String name = "MatrixDimensionException";

    private String message;

    public MatrixDimensionException() {
        message = name;
    }

    public MatrixDimensionException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
