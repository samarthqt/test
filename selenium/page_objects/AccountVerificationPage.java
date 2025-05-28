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
    protected By accountStatus = By.id(accountStatus);
    protected By errorMessage = By.id(errorMessage);
    protected By btnLogout = By.id(logoutButton);

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
        driver.findElement(txtUserName).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount);
        driver.findElement(btnVerifyAccount).click();
    }

    public void verifyAccountSuccess(String expectedMessage) {
        waitUntilElementVisible(accountStatus);
        String actualMessage = driver.findElement(accountStatus).getText();
        Assert.assertEquals(actualMessage, expectedMessage, Account verification success message does not match.);
    }

    public void verifyAccountFailure(String expectedErrorMessage) {
        waitUntilElementVisible(errorMessage);
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Account verification error message does not match.);
    }

    public void verifyAccountDetailsPageRedirection(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, Customer is not redirected to account details page.);
    }

    public void verifyErrorMessageDisplayed(String expectedErrorMessage) {
        waitUntilElementVisible(errorMessage);
        String actualErrorMessage = driver.findElement(errorMessage).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Error message does not match.);
    }

    public void verifyAccountStatusUpdated(String expectedStatus) {
        waitUntilElementVisible(accountStatus);
        String actualStatus = driver.findElement(accountStatus).getText();
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or enabled
        WebElement featureElement = driver.findElement(By.id(featureElement));
        Assert.assertTrue(featureElement.isDisplayed(), Account feature is not accessible.);
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout);
        driver.findElement(btnLogout).click();
        Assert.assertTrue(driver.findElement(By.id(loginPage)).isDisplayed(), Logout was not successful.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        driver.get(getAppUrl() + /accountDetails);
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(currentURL, getAppUrl() + /accountDetails, Access to account details page should be restricted.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}