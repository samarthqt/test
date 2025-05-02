package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PaymentPage extends WebReusableComponents {

    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By paymentConfirmationMessage = By.id("paymentConfirmationMessage");
    protected By paymentErrorMessage = By.id("paymentErrorMessage");

    public void navigateToPaymentPage() {
        // Implementation to navigate to payment page
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void loginToPayPal(String username, String password) {
        waitUntilElementVisible(btnLoginToPayPal, 3);
        enterText(btnLoginToPayPal, username);
        enterText(btnLoginToPayPal, password);
        clickElement(btnConfirmPayPalPayment);
    }

    public void verifyPaymentProcessedSuccessfully() {
        waitUntilElementVisible(paymentConfirmationMessage, 3);
        String actualMessage = getTextFromElement(paymentConfirmationMessage);
        Assert.assertEquals(actualMessage, "Payment processed successfully", "Payment confirmation message does not match.");
    }

    public void verifyConfirmationMessageReceived() {
        waitUntilElementVisible(paymentConfirmationMessage, 3);
        String actualMessage = getTextFromElement(paymentConfirmationMessage);
        Assert.assertEquals(actualMessage, "Confirmation message received", "Confirmation message does not match.");
    }

    public void verifyPaymentNotProcessed() {
        waitUntilElementVisible(paymentErrorMessage, 3);
        String actualMessage = getTextFromElement(paymentErrorMessage);
        Assert.assertEquals(actualMessage, "Payment not processed", "Payment error message does not match.");
    }

    public void verifyErrorMessageReceived(String expectedMessage) {
        waitUntilElementVisible(paymentErrorMessage, 3);
        String actualMessage = getTextFromElement(paymentErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }
}