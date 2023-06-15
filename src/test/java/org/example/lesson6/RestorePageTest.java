package org.example.lesson6;

import org.example.lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RestorePageTest extends AbstractTest {

    private final String firstName = "Diana";
    private final String lastName = "Tikhomirova";
    private final String email = "dwr@mail.ru";
    private final String password = "qLhUsT@iyqJLK75";

    @Test
    public void restorePage() {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        MainPage mainPage = new MainPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());
        mainPage.clickCreateAccount();
        accountPage
                .clickFirstname()
                .typeFirstname(firstName)
                .clickLastname()
                .typeLastname(lastName)
                .clickEmailAddress()
                .typeEmailAddress(email)
                .clickPassword()
                .typePassword(password)
                .clickPasswordConfirmation()
                .typePasswordConfirmation(password)
                .clickButtonCreateAccount();

        // Assert error message is on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accountPage.getExistingAccountErrorMsgXpath())));
        Assertions.assertTrue(accountPage.isMessageDisplayed());

        // Assert error message content
        Assertions.assertEquals(accountPage.getExistingAccountErrorNumber(), 1);

        accountPage.clickExistingAccountErrorMsg();
    }
}
