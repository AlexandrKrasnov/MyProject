package org.example.lesson3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RestorePageTest {
    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void restorepage() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//a[contains(text(),\'Create an Account\')]")).click();
        driver.findElement(By.xpath("//input[@id=\'firstname\']")).click();
        driver.findElement(By.xpath("//input[@id=\'firstname\']")).sendKeys("Diana");
        driver.findElement(By.xpath("//input[@id=\'lastname\']")).click();
        driver.findElement(By.xpath("//input[@id=\'lastname\']")).sendKeys("Tikhomirova");
        driver.findElement(By.xpath("//input[@id=\'email_address\']")).click();
        driver.findElement(By.xpath("//input[@id=\'email_address\']")).sendKeys("dwr@mail.ru");
        driver.findElement(By.xpath("//input[@id=\'password\']")).click();
        driver.findElement(By.xpath("//input[@id=\'password\']")).sendKeys("qLhUsT@iyqJLK75");
        driver.findElement(By.xpath("//input[@id=\'password-confirmation\']")).sendKeys("qLhUsT@iyqJLK75");
        driver.findElement(By.xpath("//span[contains(.,\'Create an Account\')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'maincontent\']//div[@role=\'alert\']//a")));
        driver.findElement(By.xpath("//*[@id=\'maincontent\']//div[@role=\'alert\']//a")).click();
    }
}
