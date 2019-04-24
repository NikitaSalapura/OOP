package by.bntu.fitr.poisit.sleepwalkers.task5.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.InvalidValueException;


public class Decoration {

    public static final double DEFAULT_PRICE = 1;
    public static final String DEFAULT_COLOR = "undefined";
    public static final double DEFAULT_WEIGHT = 10;

    private static final String INVALID_PRICE_MSG = "Invalid price";
    private static final String INVALID_WEIGHT_MSG = "Invalid weight";

    private double price;
    private String color;
    private double weight;

    public Decoration() {
        price = DEFAULT_PRICE;
        color = DEFAULT_COLOR;
        weight = DEFAULT_WEIGHT;
    }

    public Decoration(double price) throws InvalidValueException {
        checkForPositive(price);
        this.price = price;
    }

    public Decoration(double price, double weight, String color)
            throws InvalidValueException {
        this(price);
        checkForPositive(weight);
        this.weight = weight;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidValueException {
        checkForPositive(weight);
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidValueException {
        checkForPositive(weight);
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void checkForPositive(double value) throws InvalidValueException {
        if (value <= 0) {
            throw new InvalidValueException();
        }
    }

    @Override
    public String toString() {
        return "price = " + price
                + ", weight = " + weight
                + ", color = " + color;
    }
}

