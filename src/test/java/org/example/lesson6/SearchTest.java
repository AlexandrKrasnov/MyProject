package org.example.lesson6;

import org.example.lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest extends AbstractTest {

    private final String searchText = "shorts";

    @Test
    public void search() {
        MainPage mainPage = new MainPage(getDriver());
        OrderPage orderPage = new OrderPage(getDriver());
        mainPage
                .clickSearch()
                .typeSearch(searchText)
                .submitSearch();

        // Assert header
        Assertions.assertTrue(orderPage.isBaseTextPresent(String.format("Search results for: '%s'", searchText)));
    }
}
