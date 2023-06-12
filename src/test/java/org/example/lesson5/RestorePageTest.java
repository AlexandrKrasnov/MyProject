package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class RestorePageTest extends AbstractTest {

    @Test
    public void restorepage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().get("https://magento.softwaretestingboard.com/");
        getDriver().findElement(By.xpath("//a[contains(text(),\'Create an Account\')]")).click();
        getDriver().findElement(By.xpath("//input[@id=\'firstname\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'firstname\']")).sendKeys("Diana");
        getDriver().findElement(By.xpath("//input[@id=\'lastname\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'lastname\']")).sendKeys("Tikhomirova");
        getDriver().findElement(By.xpath("//input[@id=\'email_address\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'email_address\']")).sendKeys("dwr@mail.ru");
        getDriver().findElement(By.xpath("//input[@id=\'password\']")).click();
        getDriver().findElement(By.xpath("//input[@id=\'password\']")).sendKeys("qLhUsT@iyqJLK75");
        getDriver().findElement(By.xpath("//input[@id=\'password-confirmation\']")).sendKeys("qLhUsT@iyqJLK75");
        getDriver().findElement(By.xpath("//span[contains(.,\'Create an Account\')]")).click();

        // Assert error message is on the page
        String linkXPath = "//*[@id=\'maincontent\']//div[@role=\'alert\']//a";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkXPath)));
        WebElement msg = getDriver().findElement(By.className("messages"));
        Assertions.assertTrue(msg.isDisplayed());

        // Assert error message content
        String text = "There is already an account with this email address.";
        List<WebElement> list = getDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assertions.assertEquals(list.size(), 1);

        getDriver().findElement(By.xpath(linkXPath)).click();
    }
}
