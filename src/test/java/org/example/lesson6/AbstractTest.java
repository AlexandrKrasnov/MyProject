package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {
    private static WebDriver driver;

    private final static Long time = 10L;

    @BeforeAll
    static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://magento.softwaretestingboard.com/"),
                "The page you requested was not found");
    }

    @AfterAll
    static void close() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
