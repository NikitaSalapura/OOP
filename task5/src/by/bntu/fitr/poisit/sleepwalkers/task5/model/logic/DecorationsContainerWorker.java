package by.bntu.fitr.poisit.sleepwalkers.task5.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.task5.model.entity.DecorationsContainer;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.entity.Decoration;
import by.bntu.fitr.poisit.sleepwalkers.task5.model.exception.ArrayDimensionException;

public class DecorationsContainerWorker {
    public static double getTotalPrice(DecorationsContainer decorationsContainer)
            throws ArrayDimensionException {
        double totalPrice = 0;
        for (int i = 0; i < decorationsContainer.getSize(); i++) {
            totalPrice += decorationsContainer.getElement(i).getPrice();
        }
        return totalPrice;
    }

    public static Decoration getRichestDecoration
            (DecorationsContainer decorationsContainer)
            throws ArrayDimensionException {
        double maxPrice = decorationsContainer.getElement(0).getPrice();
        int indexOfRichest = 0;
        for (int i = 0; i < decorationsContainer.getSize(); i++) {
            if (maxPrice < decorationsContainer.getElement(i).getPrice()) {
                indexOfRichest = i;
            }
        }
        return decorationsContainer.getElement(indexOfRichest);
    }

    public static double getTotalWeight(DecorationsContainer decorationsContainer)
            throws ArrayDimensionException {
        double totalWeight = 0;
        for (int i = 0; i < decorationsContainer.getSize(); i++) {
            totalWeight += decorationsContainer.getElement(i).getWeight();
        }
        return totalWeight;
    }

}
