package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class LogoutPage extends WebReusableComponents {

    protected By btnLogout = By.id("logoutButton");
    protected By loginPageIdentifier = By.id("loginPage");

    public LogoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLogout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyRedirectionToLoginPage() {
        waitUntilElementVisible(loginPageIdentifier, 3);
        Assert.assertTrue(isElementDisplayed(loginPageIdentifier), "User is not redirected to the login page.");
    }

    public void verifySessionTermination() {
        Assert.assertFalse(isSessionActive(), "User session is not terminated.");
    }

    public void attemptAccessSecuredPage() {
        navigateToSecuredPage();
    }

    public void verifyNoAuthenticationForFurtherRequests() {
        Assert.assertFalse(isAuthenticated(), "Further requests are still authenticated.");
    }

    public boolean isSessionActive() {
        // Implement logic to check if session is active
        return driver.manage().getCookies().size() > 0;
    }

    public void navigateToSecuredPage() {
        // Implement logic to navigate to a secured page
        driver.navigate().to("https://example.com/securedPage");
    }

    public boolean isAuthenticated() {
        // Implement logic to check if user is authenticated
        return driver.getCurrentUrl().contains("securedPage");
    }
}