package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnVerifyAccount = By.id("verifyAccountButton");
    protected By lblAccountStatus = By.id("accountStatus");
    protected By lblErrorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logoutButton");

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.get(getAppUrl() + "/account-verification");
        driver.manage().window().maximize();
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername);
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount);
        driver.findElement(btnVerifyAccount).click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = getAppUrl() + "/account-details";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, "Customer is not redirected to account details page.");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage);
        String actualMessage = driver.findElement(lblErrorMessage).getText();
        Assert.assertTrue(actualMessage.contains("verification failed"), "Error message is not displayed correctly.");
    }

    public void verifyAccountStatusUpdated(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, "Account status is not updated.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedURL = getAppUrl() + "/account-details";
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(currentURL, expectedURL, "Customer should not have access to account details page.");
    }

    public void verifyAccountStatusRemainsUnverified() {
        waitUntilElementVisible(lblAccountStatus);
        String actualStatus = driver.findElement(lblAccountStatus).getText();
        Assert.assertEquals(actualStatus, "Unverified", "Account status should remain unverified.");
    }

    public void verifyAccessToAccountFeatures() {
        // Example logic to verify access to account features
        WebElement accountFeature = driver.findElement(By.id("accountFeature"));
        Assert.assertTrue(accountFeature.isDisplayed(), "Account features are not accessible.");
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout);
        driver.findElement(btnLogout).click();
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private String getAppUrl() {
        // Implement logic to retrieve the application URL
        return "http://example.com";
    }
}