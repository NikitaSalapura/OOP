package by.bntu.fitr.poisit.sleepwalkers.controller;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullException;
import by.bntu.fitr.poisit.sleepwalkers.model.logic.MatrixWorker;
import by.bntu.fitr.poisit.sleepwalkers.util.exception.InvalidInputException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.util.UserInput;
import by.bntu.fitr.poisit.sleepwalkers.view.Printer;



public class Lab12 {


    public static void main(String[] args) {
        try {
            int row = UserInput.inputInt("Enter amount of rows: ");
            int column = UserInput.inputInt("Enter amount of columns: ");

            Matrix matrix = new Matrix(row, column);

            int ans = UserInput.inputInt("1 - self input " +
                    "\nnot 1 - random\n");
            if (ans == 1) {
                Printer.println("");
                inputSelf(matrix);
            } else {
                double min = UserInput.inputInt("Enter a minimum value: ");
                double max = UserInput.inputInt("Enter a maximum value: ");
                matrix.setMatrix(MatrixWorker.setRandomValues(matrix, min, max));
            }
            Printer.println("\n" + matrix.toString());

            outputMaxFromIncreasingRows(matrix);
            outputMaxElementsSumOfNotEvenRows(matrix);
            outputIsSymmetrical(matrix);
            outputDiagonalChangedMatrix(matrix);
            outputSortedMatrix(matrix);

        } catch (InvalidInputException | MatrixDimensionException | NullException ex) {
            Printer.println(ex.getMessage());
        }
    }

    private static void inputSelf(Matrix matrix)
            throws MatrixDimensionException, InvalidInputException {
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            for (int j = 0; j < matrix.getColumnsCount(); j++)
                matrix.setElement(i, j, UserInput.inputDouble(""));
        }
    }

    private static void outputMaxFromIncreasingRows(Matrix matrix)
            throws MatrixDimensionException, NullException {
        Printer.println("Max element from increased rows: "
                + MatrixWorker.getMaxFromIncreasingRows(matrix));
    }

    private static void outputMaxElementsSumOfNotEvenRows(Matrix matrix)
            throws MatrixDimensionException, NullException {
        Printer.println("Max sum of rows with not even elements: "
                + MatrixWorker.getMaxElementsSumOfNotEvenRows(matrix));

    }

    private static void outputIsSymmetrical(Matrix matrix)
            throws MatrixDimensionException, NullException {
        Printer.println("Is symmetrical: " + MatrixWorker.isSymmetrical(matrix));
    }

    private static void outputDiagonalChangedMatrix(Matrix matrix)
            throws MatrixDimensionException, NullException {
        Printer.println("Matrix with changed diagonal max elements:\n"
                + MatrixWorker.changePosOfCentralAndMaxElement(matrix).toString());
    }

    private static void outputSortedMatrix(Matrix matrix)
            throws MatrixDimensionException, NullException {
        Printer.println("Matrix, sorted by ascending first elements of rows:\n"
                + MatrixWorker.sortMatrixRows(matrix).toString());
    }
}

