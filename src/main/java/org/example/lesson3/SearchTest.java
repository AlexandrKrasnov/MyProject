package org.example.lesson3;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//input[@id=\'search\']")).click();
        driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys("shorts");
        driver.findElement(By.xpath("//input[@id=\'search\']")).click();
        driver.findElement(By.xpath("//input[@id=\'search\']")).sendKeys(Keys.ENTER);
    }
}
