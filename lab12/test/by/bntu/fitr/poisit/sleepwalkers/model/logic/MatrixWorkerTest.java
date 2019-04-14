package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.MatrixDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MatrixWorkerTest {
    private final Matrix matrix1 = new Matrix(new double[][]{
            {12.2, 23.2, -2},
            {2, 54, 100},
            {2, 2, 50}});

    private final Matrix matrix2 = new Matrix(new double[][]{
            {12.2, 23.2, -11},
            {2, 54, -100},
            {11, 23, -51}});

    MatrixWorkerTest() throws MatrixDimensionException, NullException {
    }
//    static {
//        try {
//            matrix1 = new Matrix(new double[][]{
//                    {12.2, 23.2, -2},
//                    {2, 54, 100},
//                    {2, 2, 50}});
//            matrix2 = new Matrix(new double[][]{
//                    {12.2, 23.2, -11},
//                    {2, 54, -100},
//                    {11, 23, -51}});
//        } catch (MatrixDimensionException ex) {
//            fail();
//        }
//    }

    @Test
    void getMaxFromIncreasingRow0() throws MatrixDimensionException, NullException {
        assertThrows(NullException.class,
                () -> MatrixWorker.getMaxFromIncreasingRows(null));
    }

    @Test
    void getMaxFromIncreasingRow1() throws MatrixDimensionException, NullException {
        double expected = 100;
        double result = MatrixWorker.getMaxFromIncreasingRows(matrix1);
        assertEquals(expected, result);
    }

    @Test
    void getMaxFromIncreasingRow2() throws MatrixDimensionException, NullException {
        double expected = Double.NEGATIVE_INFINITY;
        double result = MatrixWorker.getMaxFromIncreasingRows(matrix2);
        assertEquals(expected, result);
    }

    @Test
    void getMaxSumOfRowElem1() throws MatrixDimensionException, NullException {
        double expected = 85;
        double result = MatrixWorker.getMaxElementsSumOfNotEvenRows(matrix2);
        assertEquals(expected, result);
    }

    @Test
    void getMaxSumOfRowElem2() throws MatrixDimensionException, NullException {
        double expected = Double.NEGATIVE_INFINITY;
        double result = MatrixWorker.getMaxElementsSumOfNotEvenRows(matrix1);
        assertEquals(expected, result);
    }

    @Test
    void testChangePosOfCentralAndMaxElement() throws MatrixDimensionException, NullException {
        Matrix matrix = new Matrix(new double[][]{
                {3, 5, 5},
                {5, 7, 5},
                {8, 5, 7}});
        Matrix expected = new Matrix(new double[][]{
                {3, 5, 5},
                {5, 8, 5},
                {7, 5, 7}});
        Matrix result = MatrixWorker.changePosOfCentralAndMaxElement(matrix);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void isSymmetry1() throws MatrixDimensionException, NullException {
        Matrix matrix = new Matrix(new double[][]{
                {3, 5},
                {5, 7}});
        assertTrue(MatrixWorker.isSymmetrical(matrix));
    }

    @Test
    void isSymmetry2() throws MatrixDimensionException, NullException {
        assertFalse(MatrixWorker.isSymmetrical(matrix1));
    }

    @Test
    void sortMatrixRows() throws MatrixDimensionException, NullException {
        Matrix expected = new Matrix(new double[][]{
                {2, 54, 100},
                {2, 2, 50},
                {12.2, 23.2, -2}});
        Matrix result = MatrixWorker.sortMatrixRows(matrix1);
        assertEquals(expected.toString(), result.toString());
    }
}