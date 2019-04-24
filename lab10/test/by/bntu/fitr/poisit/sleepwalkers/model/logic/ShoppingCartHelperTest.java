package by.bntu.fitr.poisit.sleepwalkers.model.logic;

import by.bntu.fitr.poisit.sleepwalkers.model.entity.Footwear;
import by.bntu.fitr.poisit.sleepwalkers.model.entity.Good;
import by.bntu.fitr.poisit.sleepwalkers.model.entity.ShoppingCart;
import by.bntu.fitr.poisit.sleepwalkers.model.entity.Suit;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.ArrayDimensionException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.InvalidValueException;
import by.bntu.fitr.poisit.sleepwalkers.model.exception.NullValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartHelperTest {

    private final ShoppingCart shoppingCart
            = new ShoppingCart(
            new Suit(),
            new Footwear(),
            new Suit(22.3),
            new Suit(12.3, 21, "yellow", "HB",
                    "signal", "knitwear", 170));

    ShoppingCartHelperTest() throws NullValueException, InvalidValueException {
    }

    @Test
    void getTotalPrice0() {
        assertThrows(NullValueException.class,
                () -> ShoppingCartHelper.getTotalPrice(null));
    }

    @Test
    void getTotalPrice() throws NullValueException, ArrayDimensionException {
        double expected = 36.6;
        double result = ShoppingCartHelper
                .getTotalPrice(shoppingCart);
        assertEquals(expected, result);
    }

    @Test
    void getMaxPrice() throws NullValueException, ArrayDimensionException {
        double expected = 22.3;
        double result = ShoppingCartHelper
                .getMaxPrice(shoppingCart);
        assertEquals(expected, result);
    }

    @Test
    void getMinPrice() throws NullValueException, ArrayDimensionException {
        double expected = 1;
        double result = ShoppingCartHelper
                .getMinPrice(shoppingCart);
        assertEquals(expected, result);
    }

    @Test
    void getRichestGood() throws NullValueException, ArrayDimensionException {
        Good expected = shoppingCart.getElement(2);
        Good result = ShoppingCartHelper
                .getRichestGood(shoppingCart);
        assertEquals(expected, result);
    }
}