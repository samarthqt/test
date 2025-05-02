package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PaymentInformationPage extends WebReusableComponents {

    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By chkSavePaymentInfo = By.id("savePaymentInfo");
    protected By btnSubmitPayment = By.id("submitPayment");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By errorMessage = By.id("errorMessage");
    protected By savedPaymentInfoSection = By.id("savedPaymentInfoSection");
    protected By btnDeletePaymentInfo = By.id("deletePaymentInfo");

    public void loginToAccount() {
        // Implement login logic
    }

    public void navigateToCheckoutPage() {
        // Implement navigation logic
    }

    public void enterPaymentInformation(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void chooseToSavePaymentInformation(boolean save) {
        if (save) {
            clickElement(chkSavePaymentInfo);
        }
    }

    public void submitPaymentInformation() {
        waitUntilElementVisible(btnSubmitPayment, 3);
        clickElement(btnSubmitPayment);
    }

    public void verifyPaymentInformationSaved() {
        // Implement verification logic
    }

    public void verifyConfirmationMessageDisplayed() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Payment information saved successfully.", "Confirmation message does not match.");
    }

    public void verifyPaymentInformationNotSaved() {
        // Implement verification logic
    }

    public void verifyTransactionCompleted() {
        // Implement verification logic
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid payment information.", "Error message does not match.");
    }

    public void verifySavedPaymentInformationExists() {
        // Implement verification logic
    }

    public void navigateToPaymentInformationSection() {
        // Implement navigation logic
    }

    public void verifySavedPaymentInformationDisplayed() {
        // Implement verification logic
    }

    public void verifyEditOrDeleteOptionsAvailable() {
        // Implement verification logic
    }

    public void deleteSavedPaymentInformation() {
        waitUntilElementVisible(btnDeletePaymentInfo, 3);
        clickElement(btnDeletePaymentInfo);
    }

    public void verifyPaymentInformationRemoved() {
        // Implement verification logic
    }

    public void editPaymentInformation(String newCardNumber, String newExpiryDate, String newCvv) {
        enterPaymentInformation(newCardNumber, newExpiryDate, newCvv);
    }

    public void submitUpdatedPaymentInformation() {
        submitPaymentInformation();
    }

    public void verifyPaymentInformationUpdated() {
        // Implement verification logic
    }
}