package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchTest extends AbstractTest {

    @Test
    public void search() {
        getDriver().get("https://magento.softwaretestingboard.com/");
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).sendKeys("shorts");
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);

        // Assert header
        String headerText = getDriver().findElement(By.className("base")).getText();
        Assertions.assertTrue(headerText.contains("Search results for: 'shorts'"));
    }
}
