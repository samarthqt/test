package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RegistrationPageWithCaptcha extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnRegister = By.id("registerButton");
    protected By captchaPrompt = By.id("captchaPrompt");

    public void navigateToRegistrationPage() {
        launchUrl(getAppUrl() + "/register");
        waitUntilElementVisible(txtEmail, 5);
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void leaveCaptchaFieldIncomplete() {
        // Intentionally leave CAPTCHA field incomplete
    }

    public void clickRegisterButton() {
        waitUntilElementVisible(btnRegister, 3);
        clickElement(btnRegister);
    }

    public void verifyCaptchaPrompt() {
        waitUntilElementVisible(captchaPrompt, 3);
        String actualPrompt = getTextFromElement(captchaPrompt);
        Assert.assertEquals(actualPrompt, "Please complete the CAPTCHA", "CAPTCHA prompt message does not match.");
    }
}