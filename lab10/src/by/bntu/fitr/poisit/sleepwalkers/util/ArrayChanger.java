package by.bntu.fitr.poisit.sleepwalkers.util;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Good;

import java.util.Arrays;


public class ArrayChanger {
    public static Good[] addElements(Good[] array, Good... listOfElements) {
        array = Arrays.copyOf(array, array.length + listOfElements.length);
        System.arraycopy(listOfElements, 0,
                array, array.length - listOfElements.length, listOfElements.length);
        return array;
    }

    public static Good[] removeElement(Good[] array, int element) {
        Good[] newArray = new Good[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, element);
        System.arraycopy
                (array, element + 1, newArray, element, array.length - element - 1);
        return newArray;
    }
}
