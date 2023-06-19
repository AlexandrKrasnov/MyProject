package org.example.lesson6;

import org.example.lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AddToBasketTest extends AbstractTest {
    private final String searchText = "shorts";

    @Test
    public void addToBasket() {
        MainPage mainPage = new MainPage(getDriver());
        OrderPage orderPage = new OrderPage(getDriver());

        // Assert basket is empty
        Assertions.assertFalse(orderPage.isProductCounterDisplayed());

        // Add to basket
        mainPage
                .clickSearch()
                .typeSearch(searchText)
                .submitSearch();

        orderPage
                .clickProductSize()
                .clickProductColor()
                .navigateToProduct()
                .clickAddToCart();

        // Assert basket is not empty
        Assertions.assertTrue(orderPage.isProductCounterDisplayed());
    }
}
