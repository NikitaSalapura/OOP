package by.bntu.fitr.poisit.sleepwalkers.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.model.exception.InvalidValueException;


public class Footwear extends WorkingWear {

    public static final String DEFAULT_SOLE = "undefined";

    protected String sole;

    public Footwear() {
        sole = DEFAULT_SOLE;
    }


    public Footwear(double price) throws InvalidValueException {
        super(price);
    }

    public Footwear(String sole) {
        this.sole = sole;
    }

    public Footwear(int size, String color,
                    String brand, String category, String material, String sole) {
        super(size, color, brand, category, material);
        this.sole = sole;
    }

    public Footwear(double price, int size, String color,
                    String brand, String category, String material, String sole)
            throws InvalidValueException {
        super(price, size, color, brand, category, material);
        this.sole = sole;
    }

    public String getSole() {
        return sole;
    }

    public void setSole(String sole) {
        this.sole = sole;
    }

    @Override
    public String toString() {
        return "Footwear{" +
                super.toString() +
                "sole='" + sole + '\'' +
                '}';
    }
}

