package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SignInTest extends AbstractTest {

    @Test
    public void signIn() {
        getDriver().get("https://magento.softwaretestingboard.com/");
        getDriver().findElement(By.xpath("//a[contains(text(),\'Sign In\')]")).click();
        getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("roni_cost@example.com");
        getDriver().findElement(By.xpath("//input[@id=\'pass\']")).sendKeys("roni_cost3@example.com");
        getDriver().findElement(By.xpath("//button[@class=\"action login primary\"]")).click();

        // Yet another way to check the message on the page
        Assertions.assertTrue(getDriver().getPageSource().contains("Incorrect CAPTCHA"));
    }
}
