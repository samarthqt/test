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
    protected By lblAccountStatus = By.id(accountStatus);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By btnLogout = By.id(logoutButton);
    protected By accountFeaturesSection = By.id(accountFeatures);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        driver.get(getAppUrl() + /account-verification);
        driver.manage().window().maximize();
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
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage() {
        String expectedURL = getAppUrl() + /account-details;
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, Customer is not redirected to account details page.);
    }

    public void verifyAccessToAccountFeatures() {
        WebElement featuresSection = wait.until(ExpectedConditions.visibilityOfElementLocated(accountFeaturesSection));
        Assert.assertTrue(featuresSection.isDisplayed(), Account features are not accessible.);
    }

    public void logoutFromAccount() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
        logoutButton.click();
        wait.until(ExpectedConditions.urlToBe(getAppUrl() + /login));
    }

    public void verifyErrorMessage(String expectedMessage) {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lblErrorMessage));
        String actualMessage = errorMessageElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage, Error message does not match.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        String expectedURL = getAppUrl() + /account-details;
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedURL)));
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(currentURL, expectedURL, Unexpected access to account details page.);
    }
}