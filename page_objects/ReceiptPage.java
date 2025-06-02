package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ReceiptPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By transactionButton = By.id("transactionButton");
    protected By receiptMessage = By.id("receiptMessage");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By smsConfirmation = By.id("smsConfirmation");
    protected By transactionDetails = By.id("transactionDetails");
    protected By duplicateReceiptWarning = By.id("duplicateReceiptWarning");
    protected By receiptFormat = By.id("receiptFormat");
    protected By invalidTransactionAlert = By.id("invalidTransactionAlert");
    protected By deliveryFailureNotification = By.id("deliveryFailureNotification");
    protected By pastReceipts = By.id("pastReceipts");
    protected By highVolumeIndicator = By.id("highVolumeIndicator");
    protected By promptDeliveryIndicator = By.id("promptDeliveryIndicator");
    protected By performanceIndicator = By.id("performanceIndicator");

    public ReceiptPage() {
        PageFactory.initElements(driver, this);
    }

    public void login() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void completeTransaction() {
        waitUntilElementVisible(transactionButton, 3);
        clickElement(transactionButton);
    }

    public void verifyReceiptReceived(String expectedMessage) {
        waitUntilElementVisible(receiptMessage, 3);
        String actualMessage = getTextFromElement(receiptMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Receipt message does not match.");
    }

    public void verifyEmailConfirmation(String expectedEmail) {
        waitUntilElementVisible(emailConfirmation, 3);
        String actualEmail = getTextFromElement(emailConfirmation);
        Assert.assertEquals(actualEmail, expectedEmail, "Email confirmation does not match.");
    }

    public void verifySMSConfirmation(String expectedSMS) {
        waitUntilElementVisible(smsConfirmation, 3);
        String actualSMS = getTextFromElement(smsConfirmation);
        Assert.assertEquals(actualSMS, expectedSMS, "SMS confirmation does not match.");
    }

    public void checkTransactionDetails(String expectedDetails) {
        waitUntilElementVisible(transactionDetails, 3);
        String actualDetails = getTextFromElement(transactionDetails);
        Assert.assertEquals(actualDetails, expectedDetails, "Transaction details do not match.");
    }

    public void preventDuplicateReceipts() {
        waitUntilElementVisible(duplicateReceiptWarning, 3);
        Assert.assertTrue(isElementDisplayed(duplicateReceiptWarning), "Duplicate receipt warning not displayed.");
    }

    public void verifyReceiptFormat() {
        waitUntilElementVisible(receiptFormat, 3);
        Assert.assertTrue(isElementDisplayed(receiptFormat), "Receipt format is incorrect.");
    }

    public void handleInvalidTransaction() {
        waitUntilElementVisible(invalidTransactionAlert, 3);
        Assert.assertTrue(isElementDisplayed(invalidTransactionAlert), "Invalid transaction alert not displayed.");
    }

    public void handleDeliveryFailure() {
        waitUntilElementVisible(deliveryFailureNotification, 3);
        Assert.assertTrue(isElementDisplayed(deliveryFailureNotification), "Delivery failure notification not displayed.");
    }

    public void accessPastReceipts() {
        waitUntilElementVisible(pastReceipts, 3);
        Assert.assertTrue(isElementDisplayed(pastReceipts), "Past receipts not accessible.");
    }

    public void handleHighVolume() {
        waitUntilElementVisible(highVolumeIndicator, 3);
        Assert.assertTrue(isElementDisplayed(highVolumeIndicator), "High volume indicator not displayed.");
    }

    public void verifyPromptDelivery() {
        waitUntilElementVisible(promptDeliveryIndicator, 3);
        Assert.assertTrue(isElementDisplayed(promptDeliveryIndicator), "Prompt delivery indicator not displayed.");
    }

    public void maintainPerformance() {
        waitUntilElementVisible(performanceIndicator, 3);
        Assert.assertTrue(isElementDisplayed(performanceIndicator), "Performance indicator not displayed.");
    }
}