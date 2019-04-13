package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;

public class Torch extends Decoration {
    public final String DEFAULT_SIZE = "normal";

    private String size;

    public Torch() {
        super();
        size = DEFAULT_SIZE;
    }

    public Torch(String size) {
        this.size = size;
    }

    public Torch(double price, String size) throws InvalidValueException {
        super(price);
        this.size = size;
    }

    public Torch(double price, double weight, String color, String size)
            throws InvalidValueException {
        super(price, weight, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Torch{" + super.toString() +
                ",size='" + size + '\'' +
                '}';
    }
}
