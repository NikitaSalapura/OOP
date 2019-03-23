package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixWorkerFromNikitaTest {

    @Test
    void testGetAmountOfLocalMins() {
        Matrix matrix = new Matrix(new double[][]{
                {12.2, 23.2, 1},
                {2, 233, 100},
                {123, 3, -2}});
        int expected = 3;
        int result = MatrixWorkerFromNikita.getAmountOfLocalMins(matrix);
        assertEquals(expected, result);
    }
}