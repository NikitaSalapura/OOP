package by.bntu.fitr.poisit.sleepwalkers.task5.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.entity.*;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.NullArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecorationsContainerWorkerTest {

    private final DecorationsContainer decorationsContainer
            = new DecorationsContainer(new Decoration[]{
            new ChristmasTree(10.21, 100, "green", 200),
            new Garland(3.21, 100, "blue", 5),
            new Toy(2, 50, "red", "star"),
            new Torch(3, 60, "white", "small"),
            new Toy()});

    DecorationsContainerWorkerTest()
            throws InvalidValueException, NullArrayException {
    }

    @Test
    void getTotalPrice() throws ArrayDimensionException {
        double expected = 19.42;
        double result = DecorationsContainerWorker
                .getTotalPrice(decorationsContainer);
        assertEquals(expected, result);
    }

    @Test
    void getRichestDecoration() throws ArrayDimensionException {
        Decoration expected = decorationsContainer.getElement(0);
        Decoration result = DecorationsContainerWorker
                .getRichestDecoration(decorationsContainer);
        assertEquals(expected, result);
    }

    @Test
    void getTotalWeight() throws ArrayDimensionException {
        double expected = 320;
        double result = DecorationsContainerWorker
                .getTotalWeight(decorationsContainer);
        assertEquals(expected, result);
    }
}