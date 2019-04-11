package by.bntu.fitr.poisit.sleepwalkers.util;

public class InvalidInputException extends Exception{
    public final String name = "InvalidInputException";

    private String message;

    public InvalidInputException() {
        message = name;
    }

    public InvalidInputException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
