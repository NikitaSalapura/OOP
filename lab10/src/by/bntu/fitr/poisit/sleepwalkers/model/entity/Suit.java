package by.bntu.fitr.poisit.sleepwalkers.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.model.exception.InvalidValueException;

public class Suit extends WorkingWear {

    public static final int DEFAULT_HEIGHT = 170;

    private static final String INVALID_HEIGHT_MSG = "Invalid height";

    protected int height;

    public Suit() {
        super();
        height = DEFAULT_HEIGHT;
    }

    public Suit(double price)
            throws InvalidValueException {
        super(price);
    }

    public Suit(int height) throws InvalidValueException {
        checkHeight(height);
        this.height = height;
    }

    public Suit(double price, int size, String color,
                String brand, String category, String material, int height)
            throws InvalidValueException {
        super(price, size, color, brand, category, material);
        checkHeight(height);
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
        if (height < 120) {
            throw new InvalidValueException(INVALID_HEIGHT_MSG);
        }
    }

    @Override
    public String toString() {
        return "Suit{" +
                super.toString() +
                "height=" + height +
                '}';
    }
}

