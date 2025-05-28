package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By txtUsername = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnVerifyAccount = By.id(verifyAccountButton);
    protected By lblAccountStatus = By.id(accountStatus);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By btnLogout = By.id(logoutButton);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.navigate().to(getAppUrl() + /account-verification);
        Assert.assertEquals(driver.getCurrentUrl(), getAppUrl() + /account-verification, Navigation to account verification page failed.);
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername);
        WebElement usernameField = driver.findElement(txtUsername);
        usernameField.clear();
        usernameField.sendKeys(username);
        Assert.assertEquals(usernameField.getAttribute(value), username, Username entry failed.);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
        Assert.assertEquals(passwordField.getAttribute(value), password, Password entry failed.);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount);
        driver.findElement(btnVerifyAccount).click();
        Assert.assertTrue(driver.findElement(lblAccountStatus).isDisplayed(), Account verification button click failed.);
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedUrl = getAppUrl() + /account-details;
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, Redirection to account details page failed.);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage);
        String errorMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertTrue(errorMessage.contains(verification failed), Error message not displayed as expected.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or enabled
        Assert.assertTrue(driver.findElement(By.id(featureElement)).isDisplayed(), Access to account features is not verified.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout);
        driver.findElement(btnLogout).click();
        Assert.assertTrue(driver.findElement(txtUsername).isDisplayed(), Logout failed.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedUrl = getAppUrl() + /account-verification;
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, Customer should not have access to account details page.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}