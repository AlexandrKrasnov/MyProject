package org.example.lesson5;

import org.apache.commons.lang3.RandomStringUtils;
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

    private void typeEmail(String email) {
        getDriver().get("https://magento.softwaretestingboard.com/");
        getDriver().findElement(By.xpath("//input[@id=\'newsletter\']")).sendKeys(email);
        getDriver().findElement(By.xpath("//form[@id=\'newsletter-validate-detail\']/div[2]/button/span")).click();
    }

    private void assertMsg(String msg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("messages")));
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + msg + "')]"));
        Assertions.assertEquals(list.size(), 1);
    }

    @Test
    public void subscribeExisting() {
        typeEmail("ifmo33@mail.ru");

        // Assert error message
        assertMsg("This email address is already subscribed.");
    }

    @Test
    public void subscribeNew() {
        String generatedString = RandomStringUtils.randomAlphabetic(15);
        typeEmail(String.format("%s@gmail.com", generatedString));

        // Assert info message
        assertMsg("Thank you for your subscription.");
    }
}
