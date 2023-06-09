package org.example.lesson3;

// Generated by Selenium IDE

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscribeTest {
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
    public void subscribe() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//a[contains(text(),\'Sign In\')]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ifmo33@mail.ru");
        driver.findElement(By.xpath("//input[@id=\'pass\']")).sendKeys("qLhUsT@iyqJLK75");
        driver.findElement(By.xpath("//a[contains(text(),\'Sign In\')]")).click();
        driver.findElement(By.xpath("//span[contains(.,\'Sign In\')]")).click();
        driver.findElement(By.xpath("//input[@id=\'newsletter\']")).click();
        driver.findElement(By.xpath("//input[@id=\'newsletter\']")).sendKeys("ifmo33@mail.ru");
        driver.findElement(By.xpath("//form[@id=\'newsletter-validate-detail\']/div[2]/button/span")).click();
    }
}

