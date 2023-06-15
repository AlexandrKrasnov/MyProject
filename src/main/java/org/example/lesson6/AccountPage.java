package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends AbstractPage {

    private final String existingAccountErrorMsgXpath = "//*[@id='maincontent']//div[@role='alert']//a";

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//span[contains(.,'Create an Account')]")
    private WebElement buttonCreateAccount;

    @FindBy(xpath = existingAccountErrorMsgXpath)
    private WebElement existingAccountErrorMsg;

    @FindBy(xpath = "//*[contains(text(),'There is already an account with this email address.')]")
    private List<WebElement> existingAccountErrorMsgList;

    @FindBy(className = "messages")
    private WebElement message;

    public boolean isMessageDisplayed() {
        return message.isDisplayed();
    }

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickFirstname() {
        firstname.click();
        return this;
    }

    public AccountPage typeFirstname(String value) {
        firstname.sendKeys(value);
        return this;
    }

    public AccountPage clickLastname() {
        lastname.click();
        return this;
    }

    public AccountPage typeLastname(String value) {
        lastname.sendKeys(value);
        return this;
    }

    public AccountPage clickEmailAddress() {
        emailAddress.click();
        return this;
    }

    public AccountPage typeEmailAddress(String value) {
        emailAddress.sendKeys(value);
        return this;
    }

    public AccountPage clickPassword() {
        password.click();
        return this;
    }

    public AccountPage typePassword(String value) {
        password.sendKeys(value);
        return this;
    }

    public AccountPage clickPasswordConfirmation() {
        passwordConfirmation.click();
        return this;
    }

    public AccountPage typePasswordConfirmation(String value) {
        passwordConfirmation.sendKeys(value);
        return this;
    }

    public AccountPage clickButtonCreateAccount() {
        buttonCreateAccount.click();
        return this;
    }

    public String getExistingAccountErrorMsgXpath() {
        return existingAccountErrorMsgXpath;
    }

    public AccountPage clickExistingAccountErrorMsg() {
        existingAccountErrorMsg.click();
        return this;
    }

    public int getExistingAccountErrorNumber() {
        return existingAccountErrorMsgList.size();
    }
}
