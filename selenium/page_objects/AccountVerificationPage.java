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
    protected By lblSuccessMessage = By.id(successMessage);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By lblAccountStatus = By.id(accountStatus);
    protected By btnLogout = By.id(logoutButton);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.get(getAppUrl() + /account-verification);
        driver.manage().window().maximize();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsername));
        WebElement usernameField = driver.findElement(txtUsername);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        WebElement passwordField = driver.findElement(txtPassword);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnVerifyAccount));
        driver.findElement(btnVerifyAccount).click();
    }

    public void verifyAccountVerificationSuccess(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblSuccessMessage));
        String actualMessage = driver.findElement(lblSuccessMessage).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Account verification success message does not match.);
    }

    public void verifyAccountVerificationFailure(String expectedErrorMessage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        String actualErrorMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Account verification error message does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, Customer is not redirected to the account details page.);
    }

    public void verifyErrorMessageDisplayed(String expectedErrorMessage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        String actualErrorMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Error message does not match.);
    }

    public void verifyAccountStatusUpdated(String expectedStatus) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountStatus));
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status is not updated to Verified.);
    }

    public void verifyAccountStatusRemains(String expectedStatus) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountStatus));
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status is not Unverified.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Assert.assertTrue(isElementVisible(By.id(accountFeature)), Account features are not accessible.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Implement logic to verify no access to account details page
        // Example: Assert.assertFalse(isElementVisible(By.id(accountDetails)), Account details page is accessible.);
    }

    public void performLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        driver.findElement(btnLogout).click();
    }
}