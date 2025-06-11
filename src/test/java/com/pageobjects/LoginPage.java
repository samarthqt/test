package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class LoginPage extends WebReusableComponents {

    private final By txtUserName = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("loginButton");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the username into the username field.
     * @param username the username to enter
     */
    public void enterUserName(final String username) {
        WebElement userNameElement = waitUntilElementVisible(txtUserName, 3);
        enterText(userNameElement, username);
    }

    /**
     * Enters the password into the password field.
     * @param password the password to enter
     */
    public void enterPassword(final String password) {
        WebElement passwordElement = waitUntilElementVisible(txtPassword, 3);
        enterText(passwordElement, password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        WebElement loginButtonElement = waitUntilElementVisible(btnLogin, 3);
        clickElement(loginButtonElement);
    }

    /**
     * Verifies that the user is redirected to the homepage.
     * @param expectedURL the expected URL of the homepage
     */
    public void verifyHomePageRedirection(final String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    /**
     * Waits until the specified element is visible.
     * @param locator the locator of the element
     * @param timeout the timeout in seconds
     * @return the visible WebElement
     */
    private WebElement waitUntilElementVisible(By locator, int timeout) {
        return waitUntilVisible(locator, timeout);
    }

    /**
     * Enters text into the specified WebElement.
     * @param element the WebElement to enter text into
     * @param text the text to enter
     */
    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks the specified WebElement.
     * @param element the WebElement to click
     */
    private void clickElement(WebElement element) {
        element.click();
    }
}