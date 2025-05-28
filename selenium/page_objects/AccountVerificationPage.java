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

    protected By txtUserName = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnVerifyAccount = By.id(verifyAccountButton);
    protected By accountStatusMessage = By.id(accountStatusMessage);
    protected By accountDetailsPage = By.id(accountDetailsPage);
    protected By logoutButton = By.id(logoutButton);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.get(getAppUrl() + /accountVerification);
        driver.manage().window().maximize();
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        WebElement userNameField = driver.findElement(txtUserName);
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount);
        driver.findElement(btnVerifyAccount).click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(accountStatusMessage);
        String actualStatus = driver.findElement(accountStatusMessage).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage);
        Assert.assertTrue(driver.findElement(accountDetailsPage).isDisplayed(), Customer is not redirected to account details page.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or enabled
        WebElement featureElement = driver.findElement(By.id(featureElement));
        Assert.assertTrue(featureElement.isDisplayed(), Account feature is not accessible.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(logoutButton);
        driver.findElement(logoutButton).click();
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(accountStatusMessage);
        String actualMessage = driver.findElement(accountStatusMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Error message does not match.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(driver.findElement(accountDetailsPage).isDisplayed(), Customer should not have access to account details page.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}