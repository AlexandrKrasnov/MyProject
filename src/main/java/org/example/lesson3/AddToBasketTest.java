package org.example.lesson3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToBasketTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void addToBasket() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//input[@id=\'search\']")).click();
        driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys("shorts");
        driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[@id=\'option-label-size-143-item-176\']")).click();
        driver.findElement(By.xpath("//div[@id=\'option-label-color-93-item-52\']")).click();
        {
            WebElement element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]//ol/li[1]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]//form/button/span")).click();
    }
}

