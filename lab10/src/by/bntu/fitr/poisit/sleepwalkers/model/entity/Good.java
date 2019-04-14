package by.bntu.fitr.poisit.sleepwalkers.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullException;

public class Good {

    public static final double DEFAULT_PRICE = 1;

    private static final String INVALID_PRICE_MSG = "Invalid price";
    private static final String NULL_ELEMENT_MSG = "Null is not allowed";

    protected double price;

    public Good() {
        price = DEFAULT_PRICE;
    }

    public Good(double price) throws InvalidValueException {
        checkPrice(price);
        this.price = price;
    }

    public Good(Good good) throws NullException {
        checkForNonNull(good);
        price = good.price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidValueException {
        checkPrice(price);
        this.price = price;
    }

    private void checkPrice(double price) throws InvalidValueException {
        if (price <= 0) {
            throw new InvalidValueException(INVALID_PRICE_MSG);
        }
    }

    private void checkForNonNull(Good good) throws NullException {
        if (good == null) {
            throw new NullException(NULL_ELEMENT_MSG);
        }
    }

    @Override
    public String toString() {
        return "price=" + price + ", ";
    }
}
