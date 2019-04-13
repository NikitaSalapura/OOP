package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.NullException;

import java.util.Arrays;

public class DecorationsContainer {
    public static final int DEFAULT_SIZE = 0;

    private static final String DIMENSION_EXCEPTION_MSG = "Wrong array dimension!";
    private static final String NULL_EXCEPTION_MSG = "Null array is not allowed!";

    private Decoration[] array;

    public DecorationsContainer() {
        array = new Decoration[DEFAULT_SIZE];
    }

    public DecorationsContainer(int size) throws ArrayDimensionException {
        checkForPositive(size);
        array = new Decoration[size];
    }

    public DecorationsContainer(Decoration[] array) throws NullException {
        checkNull(array);
        this.array = Arrays.copyOf(array, array.length);
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public DecorationsContainer(DecorationsContainer decorationsContainer)
            throws NullException {
        this(decorationsContainer.array);
    }

    public int getSize() {
        return array.length;
    }

    public Decoration getElement(int index) throws ArrayDimensionException {
        checkRange(index);
        return array[index];
    }

    public void setElement(int index, Decoration decoration)
            throws ArrayDimensionException {
        checkRange(index);
        array[index] = decoration;
    }

    private void checkForPositive(int size) throws ArrayDimensionException {
        if (size <= 0) {
            throw new ArrayDimensionException(DIMENSION_EXCEPTION_MSG);
        }
    }

    private void checkNull(Decoration[] array) throws NullException {
        if (array == null) {
            throw new NullException(NULL_EXCEPTION_MSG);
        }
    }

    private String outOfBoundsMsg(int index) {
        return DIMENSION_EXCEPTION_MSG + "\ni = " + index
                + "\nSize: [" + getSize() + "]";
    }

    private void checkRange(int index) throws ArrayDimensionException {
        if (index < 0 || index >= getSize()) {
            throw new ArrayDimensionException(outOfBoundsMsg(index));
        }
    }

    public static Decoration[] addElements
            (Decoration[] array, Decoration... listOfElements) {
        array = Arrays.copyOf(array, array.length + listOfElements.length);
        System.arraycopy(listOfElements, 0,
                array, array.length - listOfElements.length, listOfElements.length);
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Decoration decoration : array) {
            builder.append(decoration.toString()).append("\n");
        }
        return builder.toString();
    }
}
