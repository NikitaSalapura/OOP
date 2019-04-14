package by.bntu.fitr.poisit.sleepwalkers.model.entity;

import by.bntu.fitr.poisit.sleepwalkers.model.exception.InvalidValueException;

public class WorkingWear extends Good {
    public static final int DEFAULT_SIZE = 5;
    public static final String DEFAULT_COLOR = "black";
    public static final String DEFAULT_BRAND = "ANSELL";
    public static final String DEFAULT_CATEGORY = "ANSELL";
    public static final String DEFAULT_MATERIAL = "undefined";

    private static final String INVALID_SIZE_MSG = "Invalid size";

    protected int size;
    protected String color;
    protected String brand;
    protected String category;
    protected String material;

    public WorkingWear() {
        super();
        size = DEFAULT_SIZE;
        color = DEFAULT_COLOR;
        brand = DEFAULT_BRAND;
        category = DEFAULT_CATEGORY;
        material = DEFAULT_MATERIAL;
    }

    public WorkingWear(double price) throws InvalidValueException {
        super(price);
    }

    public WorkingWear(int size, String color,
                       String brand, String category, String material) {
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.category = category;
        this.material = material;
    }

    public WorkingWear(double price, int size, String color,
                       String brand, String category, String material)
            throws InvalidValueException {
        super(price);
        checkSize(size);
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.category = category;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) throws InvalidValueException {
        checkSize(size);
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    private void checkSize(int size) throws InvalidValueException {
        if (size < 20) {
            throw new InvalidValueException(INVALID_SIZE_MSG);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "size=" + size +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + "\', ";
    }
}
