package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;

public class ChristmasTree extends Decoration {
    public static final int DEFAULT_HEIGHT = 50;

    private static final String INVALID_HEIGHT_MSG
            = "Invalid christmas tree height";

    private int height;

    private ChristmasTree() {
        super();
        height = DEFAULT_HEIGHT;
    }

    public ChristmasTree(double price, int height) throws InvalidValueException {
        super(price);
        this.height = height;
    }

    public ChristmasTree(double price, double weight, String color, int height)
            throws InvalidValueException {
        super(price, weight, color);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws InvalidValueException {
        checkHeight(height);
        this.height = height;
    }

    private void checkHeight(int height) throws InvalidValueException {
        if (height < 20) {
            throw new InvalidValueException(INVALID_HEIGHT_MSG);
        }
    }

    @Override
    public String toString() {
        return "ChristmasTree{" + super.toString() +
                ", height = " + height +
                '}';
    }
}
