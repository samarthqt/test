package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountPage extends WebReusableComponents {

    protected By txtEmail = By.id("email");
    protected By txtPassword = By.id("password");
    protected By btnCreateAccount = By.id("createAccount");
    protected By sslIndicator = By.id("sslIndicator");
    protected By errorMessage = By.id("errorMessage");

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAccountCreationPage() {
        launchUrl(getAppUrl() + "/account/create");
        maximizeWindow();
    }

    public void verifySSLTlsEncryption() {
        waitUntilElementVisible(sslIndicator, 3);
        Assert.assertTrue(isElementDisplayed(sslIndicator), "SSL/TLS encryption is not active.");
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(txtEmail, 3);
        enterText(txtEmail, email);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void verifySecureFieldPopulation() {
        Assert.assertTrue(isElementSecure(txtEmail), "Email field is not secure.");
        Assert.assertTrue(isElementSecure(txtPassword), "Password field is not secure.");
    }

    public void enterValidAccountDetails() {
        enterEmail("secureuser@example.com");
        enterPassword("SecurePass123!");
    }

    public void completeAccountCreation() {
        waitUntilElementVisible(btnCreateAccount, 3);
        clickElement(btnCreateAccount);
    }

    public void verifyAccountCreationWithEncryption() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("success"), "Account creation failed.");
        verifySSLTlsEncryption();
    }

    public void enterWeakPassword() {
        enterPassword("weakpass");
    }

    public void verifyPasswordStrengthPrompt() {
        waitUntilElementVisible(errorMessage, 3);
        String message = getTextFromElement(errorMessage);
        Assert.assertTrue(message.contains("stronger password"), "No prompt for stronger password.");
    }

    public void verifyEncryptionCompliance() {
        Assert.assertTrue(checkEncryptionCompliance(), "Encryption does not meet industry standards.");
    }

    public void verifyIndustryStandardEncryption() {
        Assert.assertTrue(checkEncryptionCompliance(), "Encryption does not meet industry standards.");
    }

    public void checkLoginSecurityVulnerabilities() {
        Assert.assertFalse(detectSecurityVulnerabilities(), "Security vulnerabilities detected.");
    }

    public void verifyNoSecurityVulnerabilities() {
        Assert.assertFalse(detectSecurityVulnerabilities(), "Security vulnerabilities detected.");
    }

    public void logOutOfApplication() {
        clickElement(By.id("logout"));
    }

    public void verifySecureLogout() {
        Assert.assertTrue(isSessionTerminated(), "Session not securely terminated.");
    }

    public void navigateToLoginPageOnDifferentDevice() {
        launchUrl(getAppUrl() + "/login");
        maximizeWindow();
    }

    public void verifyLoginWithSecureTransmission() {
        verifySSLTlsEncryption();
    }

    public void checkSecurityAlertsDuringLogin() {
        Assert.assertTrue(checkForSecurityAlerts(), "No security alerts triggered.");
    }

    public void verifySecurityAlerts() {
        Assert.assertTrue(checkForSecurityAlerts(), "No security alerts triggered.");
    }
}