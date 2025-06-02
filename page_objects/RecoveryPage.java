package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RecoveryPage extends WebReusableComponents {

    protected By errorMessage = By.id("errorMessage");
    protected By loginPageLink = By.id("loginPageLink");

    public RecoveryPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Sets the recovery link in the browser.
     * @param link The recovery link URL.
     */
    public void setRecoveryLink(String link) {
        driver.get(link);
        Assert.assertEquals(driver.getCurrentUrl(), link, "Failed to navigate to the recovery link.");
    }

    /**
     * Accesses the recovery page.
     */
    public void accessRecoveryPage() {
        WebElement recoveryPageElement = driver.findElement(By.id("recoveryPage"));
        recoveryPageElement.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("recovery"), "Failed to access the recovery page.");
    }

    /**
     * Verifies that access is denied.
     */
    public void verifyAccessDenied() {
        WebElement accessDeniedElement = driver.findElement(By.id("accessDenied"));
        Assert.assertTrue(accessDeniedElement.isDisplayed(), "Access is not denied.");
    }

    /**
     * Verifies the invalid link message.
     */
    public void verifyInvalidLinkMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "The recovery link is invalid.", "Error message is incorrect.");
    }

    /**
     * Verifies that the link attempt is logged.
     */
    public void verifyLinkAttemptLogged() {
        WebElement logElement = driver.findElement(By.id("linkAttemptLog"));
        Assert.assertTrue(logElement.isDisplayed(), "Link attempt is not logged.");
    }

    /**
     * Verifies redirection or option availability.
     */
    public void verifyRedirectionOrOption() {
        waitUntilElementVisible(loginPageLink, 3);
        Assert.assertTrue(isElementDisplayed(loginPageLink), "User is not redirected or given an option.");
    }

    /**
     * Verifies that the user is logged out.
     */
    public void verifyUserLoggedOut() {
        WebElement logoutElement = driver.findElement(By.id("logoutConfirmation"));
        Assert.assertTrue(logoutElement.isDisplayed(), "User is not logged out.");
    }
}