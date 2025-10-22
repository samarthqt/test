package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LogoutPage extends WebReusableComponents {

    protected By logoutOption = By.id("logoutOption");
    protected By loginPageIdentifier = By.id("loginPage");
    protected By dashboardAccessDeniedMessage = By.id("accessDenied");

    public void verifyUserLoggedIn() {
        // Logic to verify user is logged in
    }

    public void clickLogoutOption() {
        waitUntilElementVisible(logoutOption, 3);
        clickElement(logoutOption);
    }

    public void verifyUserLoggedOut() {
        // Logic to verify user is logged out
    }

    public void verifyRedirectionToLoginPage() {
        waitUntilElementVisible(loginPageIdentifier, 3);
        Assert.assertTrue(isElementDisplayed(loginPageIdentifier), "User is not redirected to the login page.");
    }

    public void ensureUserIsLoggedOut() {
        // Logic to ensure user is logged out
    }

    public void attemptAccessDashboard() {
        // Logic to attempt access to the dashboard
    }

    public void verifyAccessDenied() {
        waitUntilElementVisible(dashboardAccessDeniedMessage, 3);
        Assert.assertTrue(isElementDisplayed(dashboardAccessDeniedMessage), "Access is not denied.");
    }

    public void verifyLoginPagePrompted() {
        waitUntilElementVisible(loginPageIdentifier, 3);
        Assert.assertTrue(isElementDisplayed(loginPageIdentifier), "Login page is not prompted.");
    }
}