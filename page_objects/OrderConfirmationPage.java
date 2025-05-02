package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderConfirmationPage extends WebReusableComponents {

    protected By btnCompletePurchase = By.id("completePurchase");
    protected By transactionSuccessMessage = By.id("transactionSuccess");
    protected By emailSentMessage = By.id("emailSent");
    protected By emailDetails = By.id("emailDetails");
    protected By emailReceiptTime = By.id("emailReceiptTime");
    protected By transactionFailMessage = By.id("transactionFail");
    protected By noEmailSentMessage = By.id("noEmailSent");
    protected By orderNumber = By.id("orderNumber");
    protected By itemsPurchased = By.id("itemsPurchased");
    protected By totalAmount = By.id("totalAmount");
    protected By billingInformation = By.id("billingInformation");
    protected By btnRequestEmailResend = By.id("requestEmailResend");
    protected By emailResentMessage = By.id("emailResent");
    protected By invalidEmailError = By.id("invalidEmailError");
    protected By notifyUpdateEmail = By.id("notifyUpdateEmail");

    public void completePurchase() {
        waitUntilElementVisible(btnCompletePurchase, 3);
        clickElement(btnCompletePurchase);
    }

    public void processTransaction() {
        waitUntilElementVisible(transactionSuccessMessage, 3);
        verifyElementVisible(transactionSuccessMessage);
    }

    public void verifyEmailSent() {
        waitUntilElementVisible(emailSentMessage, 3);
        verifyElementVisible(emailSentMessage);
    }

    public void verifyEmailDetails() {
        waitUntilElementVisible(emailDetails, 3);
        verifyElementVisible(emailDetails);
    }

    public void verifyEmailReceiptTime() {
        waitUntilElementVisible(emailReceiptTime, 3);
        verifyElementVisible(emailReceiptTime);
    }

    public void attemptPurchase() {
        waitUntilElementVisible(btnCompletePurchase, 3);
        clickElement(btnCompletePurchase);
    }

    public void failTransaction() {
        waitUntilElementVisible(transactionFailMessage, 3);
        verifyElementVisible(transactionFailMessage);
    }

    public void verifyNoEmailSent() {
        waitUntilElementVisible(noEmailSentMessage, 3);
        verifyElementVisible(noEmailSentMessage);
    }

    public void receiveEmail() {
        waitUntilElementVisible(emailSentMessage, 3);
        verifyElementVisible(emailSentMessage);
    }

    public void verifyOrderNumber() {
        waitUntilElementVisible(orderNumber, 3);
        verifyElementVisible(orderNumber);
    }

    public void verifyItemsPurchased() {
        waitUntilElementVisible(itemsPurchased, 3);
        verifyElementVisible(itemsPurchased);
    }

    public void verifyTotalAmount() {
        waitUntilElementVisible(totalAmount, 3);
        verifyElementVisible(totalAmount);
    }

    public void verifyBillingInformation() {
        waitUntilElementVisible(billingInformation, 3);
        verifyElementVisible(billingInformation);
    }

    public void requestEmailResend() {
        waitUntilElementVisible(btnRequestEmailResend, 3);
        clickElement(btnRequestEmailResend);
    }

    public void processResendRequest() {
        waitUntilElementVisible(emailResentMessage, 3);
        verifyElementVisible(emailResentMessage);
    }

    public void verifyEmailResent() {
        waitUntilElementVisible(emailResentMessage, 3);
        verifyElementVisible(emailResentMessage);
    }

    public void setInvalidEmailAddress() {
        // Logic to set invalid email address
    }

    public void attemptEmailSend() {
        // Logic to attempt sending email
    }

    public void logEmailError() {
        waitUntilElementVisible(invalidEmailError, 3);
        verifyElementVisible(invalidEmailError);
    }

    public void notifyUserToUpdateEmail() {
        waitUntilElementVisible(notifyUpdateEmail, 3);
        verifyElementVisible(notifyUpdateEmail);
    }
}