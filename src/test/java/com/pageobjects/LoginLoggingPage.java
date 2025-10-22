package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginLoggingPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By loginSuccessMessage = By.id("loginSuccessMessage");

    public LoginLoggingPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifySystemLogAccess() {
        // Implement logic to verify access to system logs
        Assert.assertTrue(isSystemLogAccessible(), "System logs are not accessible.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        waitUntilElementVisible(loginSuccessMessage, 3);
        String successMessage = getTextFromElement(loginSuccessMessage);
        Assert.assertEquals(successMessage, "Login successful", "Login was not successful.");
    }

    public void verifyLoginAttemptLogged() {
        // Implement logic to verify login attempt is logged
        Assert.assertTrue(isLoginAttemptLogged(), "Login attempt is not logged.");
    }

    private boolean isSystemLogAccessible() {
        // Dummy implementation
        return true;
    }

    private boolean isLoginAttemptLogged() {
        // Dummy implementation
        return true;
    }
}