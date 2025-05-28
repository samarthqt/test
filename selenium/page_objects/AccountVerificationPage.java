
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
    protected By btnVerifyAccount = By.id(verifyAccount);
    protected By lblAccountStatus = By.id(accountStatus);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By accountDetailsPage = By.id(accountDetailsPage);
    protected By btnLogout = By.id(logout);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername);
        WebElement usernameField = driver.findElement(txtUsername);
        usernameField.clear();
        usernameField.sendKeys(username);
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
        waitUntilElementVisible(lblAccountStatus);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status verification failed.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage);
        Assert.assertTrue(driver.findElement(accountDetailsPage).isDisplayed(), Redirection to account details page failed.);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage);
        String actualMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertTrue(actualMessage.contains(verification failed), Error message not displayed correctly.);
    }

    public void verifyAccessToAccountFeatures() {
        // Example logic to verify access to account features
        Assert.assertTrue(driver.findElement(accountDetailsPage).isDisplayed(), Access to account features is restricted.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout);
        driver.findElement(btnLogout).click();
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementVisible(accountDetailsPage), Access to account details page should be restricted.);
    }

    public String getVerificationPageUrl() {
        return driver.getCurrentUrl();
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
