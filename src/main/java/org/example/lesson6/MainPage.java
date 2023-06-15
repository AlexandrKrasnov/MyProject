package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='search']")
    private WebElement search;

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signIn;

    @FindBy(xpath = "//a[contains(text(),'Create an Account')]")
    private WebElement createAccount;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement subscribeEmail;

    @FindBy(xpath = "//form[@id='newsletter-validate-detail']/div[2]/button/span")
    private WebElement buttonSubscribe;

    @FindBy(className = "messages")
    private WebElement message;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickSearch() {
        search.click();
        return this;
    }

    public MainPage typeSearch(String value) {
        search.sendKeys(value);
        return this;
    }

    public MainPage submitSearch() {
        search.submit();
        return this;
    }

    public MainPage clickSignIn() {
        signIn.click();
        return this;
    }

    public MainPage clickCreateAccount() {
        createAccount.click();
        return this;
    }

    public MainPage typeSubscribeEmail(String value) {
        subscribeEmail.sendKeys(value);
        return this;
    }

    public MainPage submitSubscribeEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        subscribeEmail.submit();
        return this;
    }

    public MainPage clickButtonSubscribe() {
        buttonSubscribe.click();
        return this;
    }
}
