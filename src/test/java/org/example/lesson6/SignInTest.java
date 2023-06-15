package org.example.lesson6;

import org.example.lesson5.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignInTest extends AbstractTest {

    private final String email = "roni_cost@example.com";
    private final String password = "roni_cost3@example.com";
    private final String captchaErrorMsg = "Incorrect CAPTCHA";

    @Test
    public void signIn() {

        MainPage mainPage = new MainPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        mainPage.clickSignIn();
        loginPage
                .typeEmail(email)
                .typePass(password)
                .clickButtonLogin();

        // Yet another way to check the message on the page
        Assertions.assertTrue(getDriver().getPageSource().contains(captchaErrorMsg));
    }
}
