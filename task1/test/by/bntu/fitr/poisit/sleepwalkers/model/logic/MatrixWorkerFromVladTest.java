package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixWorkerFromVladTest {
    @Test
    public void testGetAnswerIsSymmetry() {
        System.out.println("get  Answer Is Symmetry");
        Matrix matrix = new Matrix(new double[][]{{5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}});

        boolean expResult = true;
        boolean result = MatrixWorkerFromVlad.getAnswerIsSymmetry(matrix);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUsableNumber() {
        System.out.println("Usable number : ");
        Matrix matrix = new Matrix(new double[][]{{5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}});
        int expResult = 3;
        int result = MatrixWorkerFromVlad.getUsableNumber(matrix);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetAnswerCentralElementExists() {
        System.out.println("get Answer Central Element Exists");
        Matrix matrix = new Matrix(new double[][]{{5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}});
        boolean expResult = false;
        boolean result = MatrixWorkerFromVlad.getAnswerCentralElementExists(matrix);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPosOfMaxElementOfMainDiagonal() {
        System.out.println("Get pos of max element of main diagonal:: ");
        Matrix matrix = new Matrix(new double[][]{{3, 5, 5},
                {5, 5, 5},
                {5, 5, 7}});
        int[] expResult = {2, 2};
        int[] result = MatrixWorkerFromVlad.getPosOfMaxElementOfMainDiagonal(matrix);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetPosOfMaxElementOfIncDiagonal() {
        System.out.println("Get pos of max element of incidental diagonal:: ");
        Matrix matrix = new Matrix(new double[][]{{3, 5, 5},
                {5, 7, 5},
                {5, 5, 7}});
        int[] expResult = {1, 1};
        int[] result = MatrixWorkerFromVlad.getPosOfMaxElementOfIncidentalDiagonal(matrix);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetMaxOfDiagonals() {
        System.out.println("Get max of diagonals: ");
        Matrix matrix = new Matrix(new double[][]{{3, 5, 5},
                {5, 7, 5},
                {8, 5, 7}});
        int[] expResult = {2, 0};
        int[] result = MatrixWorkerFromVlad.getMaxOfDiagonals(matrix);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetPosCentralElement() {
        System.out.println("Get max of diagonals: ");
        Matrix matrix = new Matrix(new double[][]{{3, 5, 5},
                {5, 7, 5},
                {8, 5, 7}});
        int[] expResult = {1, 1};
        int[] result = MatrixWorkerFromVlad.getPosCentralElement(matrix);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testChangePosOfCentralAndMaxElement() {
        System.out.println("Change Pos of cetnral and max element: ");
        Matrix matrix = new Matrix(new double[][]{{3, 5, 5},
                {5, 7, 5},
                {8, 5, 7}});
        Matrix expResult = new Matrix(new double[][]{{3, 5, 5},
                {5, 8, 5},
                {7, 5, 7}});
        Matrix result = MatrixWorkerFromVlad.changePosOfCentralAndMaxElement(matrix);
        assertEquals(expResult.toString(), result.toString());
    }
}