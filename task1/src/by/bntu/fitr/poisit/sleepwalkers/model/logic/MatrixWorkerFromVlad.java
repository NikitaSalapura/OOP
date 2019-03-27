package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;

public class MatrixWorkerFromVlad {
    public static int getUsableNumber(Matrix matrix) {
        int usableNumber = matrix.getCountColumns();
        if (matrix.getCountRows() < matrix.getCountColumns()) {
            usableNumber = matrix.getCountRows();
        }
        return usableNumber;
    }

    public static boolean getAnswerIsSymmetry(Matrix matrix) {
        boolean answer = true;
        if (matrix.getCountRows() != matrix.getCountColumns()) {
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

    public static boolean getAnswerCentralElementExists(Matrix matrix) {
        return getUsableNumber(matrix) % 2 == 0;
    }


    public static int[] getPosOfMaxElementOfMainDiagonal(Matrix matrix) {
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

    public static int[] getPosOfMaxElementOfIncidentalDiagonal(Matrix matrix) {
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

    public static int[] getMaxOfDiagonals(Matrix matrix) {
        int[] posOfMaxElementOfMainDiagonal = getPosOfMaxElementOfMainDiagonal(matrix);
        int[] posOfMaxElementOfIncDiagonal = getPosOfMaxElementOfIncidentalDiagonal(matrix);
        double maxElementOfMainDiagonal = matrix.getElement(posOfMaxElementOfMainDiagonal[0], posOfMaxElementOfMainDiagonal[1]);
        double maxElementOfIncDiagonal = matrix.getElement(posOfMaxElementOfIncDiagonal[0], posOfMaxElementOfIncDiagonal[1]);
        return maxElementOfMainDiagonal > maxElementOfIncDiagonal ? posOfMaxElementOfMainDiagonal : posOfMaxElementOfIncDiagonal;
    }

    public static int[] getPosCentralElement(Matrix matrix) {
        int[] posOfCentralElement = new int[2];
        posOfCentralElement[0] = ((getUsableNumber(matrix) - 1) / 2);
        posOfCentralElement[1] = ((getUsableNumber(matrix) - 1) / 2);
        return posOfCentralElement;
    }

    public static void changePosOfCentralAndMaxElement(Matrix matrix) {
        Matrix newMatrix = matrix;
        int[] posOfMaxElement = getMaxOfDiagonals(matrix);
        int[] posCentralElement = getPosCentralElement(matrix);
        double valueOfMax = matrix.getElement(posOfMaxElement[0], posOfMaxElement[1]);
        double valueOfCentral = matrix.getElement(posCentralElement[0], posCentralElement[1]);
        matrix.setElement(posCentralElement[0], posCentralElement[1], valueOfMax);
        matrix.setElement(posOfMaxElement[0], posOfMaxElement[1], valueOfCentral);
//        return newMatrix;
    }
}
