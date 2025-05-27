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
    protected By accountStatusMessage = By.id(accountStatus);
    protected By errorMessage = By.id(errorMessage);
    protected By accountDetailsPage = By.id(accountDetailsPage);
    protected By accountFeatures = By.id(accountFeatures);
    protected By btnLogout = By.id(logout);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername);
        enterText(txtUsername, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(accountStatusMessage);
        String actualStatus = getTextFromElement(accountStatusMessage);
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, Error message does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage);
        Assert.assertTrue(isElementVisible(accountDetailsPage), Redirection to account details page failed.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementVisible(accountDetailsPage), Access to account details page should not be possible.);
    }

    public void verifyAccessToAccountFeatures() {
        waitUntilElementVisible(accountFeatures);
        Assert.assertTrue(isElementVisible(accountFeatures), Access to account features failed.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout);
        clickElement(btnLogout);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private boolean isElementVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}