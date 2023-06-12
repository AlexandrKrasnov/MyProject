package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AddToBasketTest extends AbstractTest {

    @Test
    public void addToBasket() {
        getDriver().get("https://magento.softwaretestingboard.com/");

        // Assert basket is empty
        WebElement counter = getDriver().findElement(By.className("counter-number"));
        Assertions.assertFalse(counter.isDisplayed());

        // Add to basket
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).sendKeys("shorts");
        getDriver().findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
        getDriver().findElement(By.xpath("//div[@id=\'option-label-size-143-item-176\']")).click();
        getDriver().findElement(By.xpath("//div[@id=\'option-label-color-93-item-52\']")).click();
        {
            WebElement element = getDriver().findElement(By.xpath("//*[@id=\"maincontent\"]//ol/li[1]"));
            Actions builder = new Actions(getDriver());
            builder.moveToElement(element).perform();
        }
        getDriver().findElement(By.xpath("//*[@id=\"maincontent\"]//form/button/span")).click();

        // Assert basket is not empty
        counter = getDriver().findElement(By.className("counter-number"));
        Assertions.assertTrue(counter.isDisplayed());
    }
}
