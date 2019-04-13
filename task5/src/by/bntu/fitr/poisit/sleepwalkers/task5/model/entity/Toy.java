package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;

public class Toy extends Decoration {
    public static final String DEFAULT_SHAPE = "undefined";

    private String shape;

    public Toy() {
        super();
        shape = DEFAULT_SHAPE;
    }

    public Toy(String shape) {
        this();
        this.shape = shape;
    }

    public Toy(double price, String shape) throws InvalidValueException {
        super(price);
        this.shape = shape;
    }

    public Toy(double price, double weight, String color, String shape)
            throws InvalidValueException {
        super(price, weight, color);
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Toy{" + super.toString() +
                ",shape='" + shape + '\'' +
                '}';
    }
}
