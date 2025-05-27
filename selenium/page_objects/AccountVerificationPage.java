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
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(btnVerifyAccount));
        verifyButton.click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        WebElement accountStatusLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountStatus));
        String actualStatus = accountStatusLabel.getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        WebElement accountDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDetailsPage));
        Assert.assertTrue(accountDetails.isDisplayed(), Redirection to account details page failed.);
    }

    public void verifyErrorMessageDisplayed() {
        WebElement errorMessageLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        Assert.assertTrue(errorMessageLabel.isDisplayed(), Error message not displayed.);
    }

    public void verifyAccessToAccountFeatures() {
        WebElement accountDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(accountDetailsPage));
        Assert.assertTrue(accountDetails.isDisplayed(), Access to account features is not verified.);
    }

    public void logoutFromAccount() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        logoutButton.click();
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), Logout failed, account details page is still accessible.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        Assert.assertFalse(isElementDisplayed(accountDetailsPage), Access to account details page should not be allowed.);
    }

    private boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}