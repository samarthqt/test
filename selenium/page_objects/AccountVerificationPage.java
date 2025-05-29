package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnVerifyAccount = By.id("verifyAccount");
    private final By lblAccountStatus = By.id("accountStatus");
    private final By lblErrorMessage = By.id("errorMessage");
    private final By btnLogout = By.id("logout");

    public AccountVerificationPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername, 3);
        WebElement usernameField = driver.findElement(txtUsername);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        driver.findElement(btnVerifyAccount).click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedUrl = testHarness.getData("AccountData", "AccountDetailsPageURL");
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Redirection to account details page failed.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if a specific feature element is visible
        boolean featureVisible = driver.findElement(By.id("featureElement")).isDisplayed();
        Assert.assertTrue(featureVisible, "Access to account features is not available.");
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        driver.findElement(btnLogout).click();
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Implement logic to verify no access to account details page
        // Example: Check if the URL is not the account details page URL
        String restrictedUrl = testHarness.getData("AccountData", "RestrictedPageURL");
        Assert.assertNotEquals(driver.getCurrentUrl(), restrictedUrl, "Access to account details page is incorrectly granted.");
    }
}