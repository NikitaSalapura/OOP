package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullException;

import java.util.Arrays;
import java.util.Random;


public class MatrixWorker {
    public static final double ROUNDING = 100;

    private static final String NULL_EXCEPTION_MSG = "Null is not allowed!";

    private static void checkForNull(Matrix matrix)
            throws NullException {
        if (matrix == null) {
            throw new NullException(NULL_EXCEPTION_MSG);
        }
    }

    public static Matrix setRandomValues(Matrix matrix, double min, double max)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        Matrix newMatrix = new Matrix(matrix.getRowsCount(), matrix.getColumnsCount());
        Random random = new Random();
        if (min > max) {
            min += max;
            max = min - max;
            min -= max;
        }
        for (int i = 0; i < newMatrix.getRowsCount(); i++) {
            for (int j = 0; j < newMatrix.getColumnsCount(); j++) {
                newMatrix.setElement(i, j, Math.round
                        ((random.nextDouble() * (max - min) + min)
                                * ROUNDING) / ROUNDING);
            }
        }
        return newMatrix;
    }

    private static int[] addElementToArray(int[] array, int element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
        return array;
    }

    private static double[] addElementToArray(double[] array, double element) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = element;
        return array;
    }


    //a19
    private static int[] getIncreasingRowIndex(Matrix matrix)
            throws MatrixDimensionException {
        int[] rowIndex = {};
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            for (int j = 1; j < matrix.getColumnsCount(); j++) {
                if (matrix.getElement(i, j) < matrix.getElement(i, j - 1)) {
                    break;
                }
                if (j == matrix.getColumnsCount() - 1) {
                    rowIndex = addElementToArray(rowIndex, i);
                }
            }
        }
        return rowIndex;
    }

    private static double[] getRowsMaxElement(Matrix matrix, int[] rowIndex)
            throws MatrixDimensionException {
        double[] matrixMax = {};
        double rowMax;
        for (int i : rowIndex) {
            rowMax = matrix.getElement(i, 0);
            for (int j = 1; j < matrix.getColumnsCount(); j++) {
                if (rowMax < matrix.getElement(i, j)) {
                    rowMax = matrix.getElement(i, j);
                }
            }
            matrixMax = addElementToArray(matrixMax, rowMax);
        }
        return matrixMax;
    }

    private static double getMax(double[] array) {
        double max = array[0];
        for (double element : array) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    public static double getMaxFromIncreasingRows(Matrix matrix)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        double max;
        int[] rowIndex = getIncreasingRowIndex(matrix);
        if (rowIndex.length != 0) {
            double[] rowMax = getRowsMaxElement(matrix, rowIndex);
            max = getMax(rowMax);
        } else {
            max = Double.NEGATIVE_INFINITY;
        }
        return max;
    }

    //B2

    public static Matrix sortMatrixRows(Matrix matrix)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        Matrix newMatrix = new Matrix(matrix);
        double storageVariable;
        for (int i = 0; i < newMatrix.getRowsCount() - 1; i++) {
            for (int k = 0; k < newMatrix.getRowsCount() - 1; k++) {
                if (newMatrix.getElement(k, 0) > newMatrix.getElement(k + 1, 0)) {
                    for (int j = 0; j < newMatrix.getColumnsCount(); j++) {
                        storageVariable = newMatrix.getElement(k, j);
                        newMatrix.setElement(k, j, newMatrix.getElement(k + 1, j));
                        newMatrix.setElement(k + 1, j, storageVariable);
                    }
                }
            }
        }
        return newMatrix;
    }

    //a 2 vl

    private static int[] getRowIndexWithNotEvenElements(Matrix matrix)
            throws MatrixDimensionException {
        int[] rowIndex = {};
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            for (int j = 0; j < matrix.getColumnsCount(); j++) {
                if (Math.abs(matrix.getElement(i, j)) % 2 == 0) {
                    break;
                }
                if (j == matrix.getColumnsCount() - 1) {
                    rowIndex = addElementToArray(rowIndex, i);
                }
            }
        }
        return rowIndex;
    }

    private static double[] getRowsElementsSum(Matrix matrix, int[] rowIndex)
            throws MatrixDimensionException {
        double[] sum = {};
        double rowSum;
        for (int i : rowIndex) {
            rowSum = matrix.getElement(i, 0);
            for (int j = 1; j < matrix.getColumnsCount(); j++) {
                rowSum += Math.abs(matrix.getElement(i, j));
            }
            sum = addElementToArray(sum, rowSum);
        }
        return sum;
    }

    public static double getMaxElementsSumOfNotEvenRows(Matrix matrix)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        double max;
        int[] rowIndex = getRowIndexWithNotEvenElements(matrix);
        if (rowIndex.length != 0) {
            double[] rowsElementsSum = getRowsElementsSum(matrix, rowIndex);
            max = getMax(rowsElementsSum);
        } else {
            max = Double.NEGATIVE_INFINITY;
        }
        return max;
    }

    //B7 v
    private static int getUsableNumber(Matrix matrix) {
        int usableNumber = matrix.getColumnsCount();
        if (matrix.getRowsCount() < matrix.getColumnsCount()) {
            usableNumber = matrix.getRowsCount();
        }
        return usableNumber;
    }

    public static boolean isSymmetrical(Matrix matrix)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        boolean answer = true;
        if (matrix.getRowsCount() != matrix.getColumnsCount()) {
            answer = false;
        }
        for (int x = 0; x < getUsableNumber(matrix); x++) {
            for (int y = x + 1; y < getUsableNumber(matrix); y++) {
                if (matrix.getElement(x, y) != matrix.getElement(y, x)) {
                    answer = false;
                }
            }
        }
        return answer;
    }


    private static int[] getPosOfMaxElementOfMainDiagonal(Matrix matrix)
            throws MatrixDimensionException {
        double maxElementOfMainDiagonal = matrix.getElement(0, 0);
        int[] posOfMaxElementOfMainDiagonal = new int[2];
        for (int i = 1; i < getUsableNumber(matrix); i++) {
            if (maxElementOfMainDiagonal < matrix.getElement(i, i)) {
                maxElementOfMainDiagonal = matrix.getElement(i, i);
                posOfMaxElementOfMainDiagonal[0] = i;
                posOfMaxElementOfMainDiagonal[1] = i;
            }
        }
        return posOfMaxElementOfMainDiagonal;
    }

    private static int[] getPosOfMaxElementOfIncidentalDiagonal(Matrix matrix)
            throws MatrixDimensionException {
        double maxElementOfIncidentalDiagonal =
                matrix.getElement(0, getUsableNumber(matrix) - 1);
        int[] posOfMaxElementOfIncidentalDiagonal = new int[2];
        for (int j = getUsableNumber(matrix) - 1, i = 0; i < getUsableNumber(matrix); j--, i++) {
            if (maxElementOfIncidentalDiagonal < matrix.getElement(i, j)) {
                maxElementOfIncidentalDiagonal = matrix.getElement(i, j);
                posOfMaxElementOfIncidentalDiagonal[0] = i;
                posOfMaxElementOfIncidentalDiagonal[1] = j;
            }
        }
        return posOfMaxElementOfIncidentalDiagonal;
    }

    private static int[] getMaxOfDiagonals(Matrix matrix)
            throws MatrixDimensionException {
        int[] posOfMaxElementOfMainDiagonal = getPosOfMaxElementOfMainDiagonal(matrix);
        int[] posOfMaxElementOfIncDiagonal = getPosOfMaxElementOfIncidentalDiagonal(matrix);
        double maxElementOfMainDiagonal = matrix.getElement(posOfMaxElementOfMainDiagonal[0], posOfMaxElementOfMainDiagonal[1]);
        double maxElementOfIncDiagonal = matrix.getElement(posOfMaxElementOfIncDiagonal[0], posOfMaxElementOfIncDiagonal[1]);
        return maxElementOfMainDiagonal > maxElementOfIncDiagonal ? posOfMaxElementOfMainDiagonal : posOfMaxElementOfIncDiagonal;
    }

    private static int[] getPosCentralElement(Matrix matrix) {
        int[] posOfCentralElement = new int[2];
        posOfCentralElement[0] = ((getUsableNumber(matrix) - 1) / 2);
        posOfCentralElement[1] = ((getUsableNumber(matrix) - 1) / 2);
        return posOfCentralElement;
    }

    public static Matrix changePosOfCentralAndMaxElement(Matrix matrix)
            throws MatrixDimensionException, NullException {
        checkForNull(matrix);
        Matrix newMatrix = new Matrix(matrix);
        int[] posOfMaxElement = getMaxOfDiagonals(newMatrix);
        int[] posCentralElement = getPosCentralElement(newMatrix);
        double valueOfMax = newMatrix.getElement(posOfMaxElement[0], posOfMaxElement[1]);
        double valueOfCentral = newMatrix.getElement
                (posCentralElement[0], posCentralElement[1]);
        newMatrix.setElement(posCentralElement[0], posCentralElement[1], valueOfMax);
        newMatrix.setElement(posOfMaxElement[0], posOfMaxElement[1], valueOfCentral);
        return newMatrix;
    }
}
