package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountVerificationPage extends WebReusableComponents {

    private final WebDriver driver;

    protected By txtUserName = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnVerifyAccount = By.id(verifyAccountButton);
    protected By lblSuccessMessage = By.id(successMessage);
    protected By lblErrorMessage = By.id(errorMessage);
    protected By lblAccountStatus = By.id(accountStatus);
    protected By btnLogout = By.id(logoutButton);

    public AccountVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountVerificationPage() {
        launchUrl(getAppUrl() + /account-verification);
        maximizeWindow();
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickVerifyAccountButton() {
        waitUntilElementVisible(btnVerifyAccount, 3);
        clickElement(btnVerifyAccount);
    }

    public void verifyAccountSuccess(String expectedMessage) {
        waitUntilElementVisible(lblSuccessMessage, 3);
        String actualMessage = getTextFromElement(lblSuccessMessage);
        Assert.assertEquals(actualMessage, expectedMessage, Account verification success message does not match.);
    }

    public void verifyAccountFailure(String expectedMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, Account verification failure message does not match.);
    }

    public void verifyRedirectionToAccountDetailsPage(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, Customer is not redirected to the account details page.);
    }

    public void verifyErrorMessage(String expectedErrorMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualErrorMessage = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, Error message does not match.);
    }

    public void verifyAccountStatus(String expectedStatus) {
        waitUntilElementVisible(lblAccountStatus, 3);
        String actualStatus = getTextFromElement(lblAccountStatus);
        Assert.assertEquals(actualStatus, expectedStatus, Account status does not match.);
    }

    public void verifyAccessToAccountFeatures() {
        // Example logic to verify access to account features
        WebElement featureElement = driver.findElement(By.id(featureElement));
        Assert.assertTrue(featureElement.isDisplayed(), Account features are not accessible.);
    }

    public void verifyNoAccessToAccountDetailsPage() {
        // Example logic to verify no access to account details page
        boolean isAccountDetailsVisible = isElementVisible(By.id(accountDetails));
        Assert.assertFalse(isAccountDetailsVisible, Account details page is accessible.);
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }
}