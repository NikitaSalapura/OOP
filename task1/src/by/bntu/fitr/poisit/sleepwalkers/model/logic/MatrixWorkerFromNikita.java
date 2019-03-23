package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;

public class MatrixWorkerFromNikita {
    private static boolean checkRow(Matrix matrix, int i, int j, int i_offset) {
        return j > 0 && matrix.getElement(i + i_offset, j - 1)
                < matrix.getElement(i, j)
                || matrix.getElement(i + i_offset, j) < matrix.getElement(i, j)
                || j < matrix.getCountColumns() - 1
                && matrix.getElement(i + i_offset, j + 1)
                < matrix.getElement(i, j);
    }

    private static boolean IsLocalMin(Matrix matrix, int i, int j) {
        return !(i > 0 && checkRow(matrix, i, j, -1)
                || checkRow(matrix, i, j, 0)
                || i < matrix.getCountRows() - 1 && checkRow(matrix, i, j, 1));
    }

    public static int getAmountOfLocalMins(Matrix matrix) {
        int amountOfLocalMins = 0;
        for (int i = 0; i < matrix.getCountRows(); ++i)
            for (int j = 0; j < matrix.getCountColumns(); ++j)
                if (IsLocalMin(matrix, i, j)) {
                    amountOfLocalMins++;
                }
        return amountOfLocalMins;
    }

}
