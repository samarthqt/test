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

    protected By txtUserName = By.id("username");
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

    public void enterUserName(String username) {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
        userNameElement.clear();
        userNameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickVerifyAccountButton() {
        WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(btnVerifyAccount));
        verifyButton.click();
    }

    public void verifyAccountStatus(String expectedStatus) {
        WebElement accountStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lblAccountStatus));
        String actualStatus = accountStatusElement.getText();
        Assert.assertEquals(actualStatus, expectedStatus, "Account status does not match.");
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = getAppUrl() + "/accountDetails";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the account details page.");
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        // Example: Check if certain elements are visible or clickable
        WebElement featureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("featureElement")));
        Assert.assertTrue(featureElement.isDisplayed(), "Account features are not accessible.");
    }

    public void logoutFromAccount() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        logoutButton.click();
        // Verify logout by checking redirection or visibility of login page elements
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPageElement")));
        Assert.assertTrue(loginPageElement.isDisplayed(), "Logout was not successful.");
    }

    public void verifyErrorMessageDisplayed() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        String errorMessage = errorMessageElement.getText();
        Assert.assertTrue(errorMessage.contains("verification failed"), "Error message not displayed as expected.");
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Implement logic to verify no access to account details page
        // Example: Check if redirection to account details page fails
        String currentURL = driver.getCurrentUrl();
        Assert.assertFalse(currentURL.contains("/accountDetails"), "Access to account details page should not be allowed.");
    }
}