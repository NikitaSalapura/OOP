package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;

public class Garland extends Decoration {
    public static final double DEFAULT_LENGTH = 1;

    private double length;

    public Garland() {
        super();
        length = DEFAULT_LENGTH;
    }

    public Garland(double length) {
        this();
        this.length = length;
    }

    public Garland(double price, double length) throws InvalidValueException {
        super(price);
        this.length = length;
    }

    public Garland(double price, double weight, String color, double length)
            throws InvalidValueException {
        super(price, weight, color);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Garland{" + super.toString() +
                ",length='" + length + '\'' +
                '}';
    }
}
