package org.example.lesson6;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SubscribeTest extends AbstractTest {

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    private void typeEmail(String email) throws InterruptedException {

        MainPage mainPage = new MainPage(getDriver());
        mainPage
                .typeSubscribeEmail(email)
                .submitSubscribeEmail();
    }

    private void assertMsg(String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("messages")));
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + msg + "')]"));
        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    public void subscribeExisting() throws InterruptedException {
        typeEmail("ifmo33@mail.ru");

        // Assert error message
        assertMsg("This email address is already subscribed.");
    }

    @Test
    public void subscribeNew() throws InterruptedException {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        typeEmail(String.format("%s@gmail.com", generatedString));

        // Assert info message
        assertMsg("Thank you for your subscription.");
    }
}
