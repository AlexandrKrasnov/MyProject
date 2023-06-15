package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='option-label-size-143-item-176']")
    private WebElement productSize;

    @FindBy(xpath = "//div[@id='option-label-color-93-item-52']")
    private WebElement productColor;

    @FindBy(xpath = "//*[@id='maincontent']//ol/li[1]")
    private WebElement product;

    @FindBy(xpath = "//*[@id='maincontent']//form/button/span")
    private WebElement addToCart;

    @FindBy(className = "counter-number")
    private WebElement productCounter;

    @FindBy(className = "base")
    private WebElement base;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage clickProductSize() {
        productSize.click();
        return this;
    }

    public OrderPage clickProductColor() {
        productColor.click();
        return this;
    }

    public OrderPage navigateToProduct() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(product).perform();
        return this;
    }

    public OrderPage clickAddToCart() {
        addToCart.click();
        return this;
    }

    public boolean isBaseTextPresent(String value) {
        return base.getText().contains(value);
    }

    public boolean isProductCounterDisplayed() {
        return productCounter.isDisplayed();
    }
}
