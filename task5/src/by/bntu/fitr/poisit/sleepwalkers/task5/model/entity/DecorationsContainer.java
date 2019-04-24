package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.NullValueException;

import java.util.Arrays;

public class DecorationsContainer {
    public static final int DEFAULT_SIZE = 0;

    private static final String DIMENSION_EXCEPTION_MSG = "Wrong listOfDecorations dimension!";
    private static final String NULL_EXCEPTION_MSG = "Null listOfDecorations is not allowed!";

    private Decoration[] listOfDecorations;

    public DecorationsContainer() {
        listOfDecorations = new Decoration[DEFAULT_SIZE];
    }

    public DecorationsContainer(int size) throws ArrayDimensionException {
        checkForPositive(size);
        listOfDecorations = new Decoration[size];
    }

    public DecorationsContainer(Decoration... listOfDecorations) throws NullValueException {
        checkForNonNull(listOfDecorations);
        initArray(listOfDecorations);
    }

    public DecorationsContainer(DecorationsContainer decorationsContainer)
            throws NullValueException {
        this(decorationsContainer.listOfDecorations);
    }

    public int getSize() {
        return listOfDecorations.length;
    }

    public Decoration getElement(int index) throws ArrayDimensionException {
        checkRange(index);
        return listOfDecorations[index];
    }

    public void changeElement(int index, Decoration decoration)
            throws ArrayDimensionException {
        checkRange(index);
        listOfDecorations[index] = decoration;
    }

    private void checkForPositive(int size) throws ArrayDimensionException {
        if (size <= 0) {
            throw new ArrayDimensionException(DIMENSION_EXCEPTION_MSG);
        }
    }

    private void checkForNonNull(Decoration[] array) throws NullValueException {
        if (array == null) {
            throw new NullValueException(NULL_EXCEPTION_MSG);
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

    private void add
            (Decoration... listOfElements) {
        listOfDecorations = Arrays.copyOf(listOfDecorations,
                getSize() + listOfElements.length);
        System.arraycopy(listOfElements, 0, listOfDecorations,
                getSize() - listOfElements.length, listOfElements.length);
    }

    private void initArray
            (Decoration... listOfDecorations) {
        this.listOfDecorations = Arrays.copyOf(listOfDecorations, listOfDecorations.length);
        System.arraycopy(listOfDecorations, 0,
                this.listOfDecorations, 0, listOfDecorations.length);
    }

    public void addElements
            (Decoration... listOfElements) throws NullValueException {
        checkForNonNull(listOfElements);
        add(listOfElements);
    }

    public void removeElement(int index) throws ArrayDimensionException {
        checkRange(index);

        Decoration[] newArray = new Decoration[getSize() - 1];
        System.arraycopy(listOfDecorations, 0, newArray, 0, index);
        System.arraycopy
                (listOfDecorations, index + 1,
                        newArray, index, getSize() - index - 1);
        listOfDecorations = new Decoration[newArray.length];
        add(newArray);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Decoration decoration : listOfDecorations) {
            builder.append(decoration.toString()).append("\n");
        }
        return builder.toString();
    }
}
