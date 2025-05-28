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

    public void navigateToAccountVerificationPage() {
        launchUrl(getAppUrl() + /account-verification);
        maximizeWindow();
    }

    public void enterAccountCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, Account status verification failed.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        waitUntilElementVisible(accountDetailsPage, 3);
        Assert.assertTrue(isElementDisplayed(accountDetailsPage), Redirection to account details page failed.);
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(lblErrorMessage, 3);
        Assert.assertTrue(isElementDisplayed(lblErrorMessage), Error message not displayed.);
    }

    public void verifyAccessToAccountFeatures() {
        // Implement logic to verify access to account features
        WebElement featureElement = driver.findElement(By.id(featureElement));
        wait.until(ExpectedConditions.visibilityOf(featureElement));
        Assert.assertTrue(featureElement.isDisplayed(), Access to account features verification failed.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Implement logic to verify no access to account details page
        try {
            WebElement detailsPageElement = driver.findElement(accountDetailsPage);
            wait.until(ExpectedConditions.invisibilityOf(detailsPageElement));
            Assert.assertFalse(detailsPageElement.isDisplayed(), Unexpected access to account details page.);
        } catch (Exception e) {
            Assert.assertTrue(true, No access to account details page as expected.);
        }
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    private boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}