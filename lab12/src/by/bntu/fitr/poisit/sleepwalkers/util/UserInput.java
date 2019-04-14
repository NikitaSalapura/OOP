package by.bntu.fitr.poisit.sleepwalkers.util;

import by.bntu.fitr.poisit.sleepwalkers.util.exception.InvalidInputException;

import java.util.Scanner;

public class UserInput {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int inputInt(String msg) throws InvalidInputException {
        System.out.print(msg);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InvalidInputException("Wrong input: an integer was needed!");
        }
    }

    public static double inputDouble(String msg) throws InvalidInputException {
        System.out.print(msg);
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            throw new InvalidInputException("Wrong input: a real number was needed!");
        }
    }
}
