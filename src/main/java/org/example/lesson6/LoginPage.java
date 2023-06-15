package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement pass;

    @FindBy(xpath = "//button[@class=\"action login primary\"]")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeEmail(String value) {
        email.sendKeys(value);
        return this;
    }

    public LoginPage typePass(String value) {
        pass.sendKeys(value);
        return this;
    }

    public LoginPage clickButtonLogin() {
        buttonLogin.click();
        return this;
    }
}
