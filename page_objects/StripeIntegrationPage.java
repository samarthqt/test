package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class StripeIntegrationPage extends WebReusableComponents {

    protected By paymentPage = By.id("paymentPage");
    protected By stripePaymentMethod = By.id("stripePaymentMethod");
    protected By creditCardDetails = By.id("creditCardDetails");
    protected By billingAddress = By.id("billingAddress");
    protected By emailAddress = By.id("emailAddress");
    protected By productID = By.id("productID");
    protected By amount = By.id("amount");
    protected By submitPaymentButton = By.id("submitPayment");
    protected By transactionConfirmationMessage = By.id("transactionConfirmationMessage");
    protected By stripeDashboard = By.id("stripeDashboard");
    protected By emailNotification = By.id("emailNotification");
    protected By logOutButton = By.id("logOut");
    protected By logInButton = By.id("logIn");
    protected By orderHistory = By.id("orderHistory");
    protected By customerSupport = By.id("customerSupport");
    protected By transactionDetailsLog = By.id("transactionDetailsLog");

    public StripeIntegrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyStripeAccountSetup() {
        // Logic to verify Stripe account setup
        Assert.assertTrue(isElementVisible(stripeDashboard), "Stripe account setup is not verified.");
    }

    public void navigateToPaymentPage() {
        waitUntilElementVisible(paymentPage, 3);
        clickElement(paymentPage);
    }

    public void verifyPaymentPageDisplayed() {
        Assert.assertTrue(isElementVisible(paymentPage), "Payment page is not displayed correctly.");
    }

    public void verifyAPIKeysConfigured() {
        // Logic to verify API keys are configured
        Assert.assertTrue(isElementVisible(stripeDashboard), "API keys are not configured.");
    }

    public void selectStripePaymentMethod() {
        waitUntilElementVisible(stripePaymentMethod, 3);
        clickElement(stripePaymentMethod);
    }

    public void verifyStripePaymentMethodSelected() {
        Assert.assertTrue(isElementVisible(stripePaymentMethod), "Stripe payment method is not selected.");
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(creditCardDetails, 3);
        enterText(creditCardDetails, cardNumber);
        enterText(creditCardDetails, expiryDate);
        enterText(creditCardDetails, cvv);
    }

    public void verifyCreditCardDetailsAccepted() {
        Assert.assertTrue(isElementVisible(creditCardDetails), "Credit card details are not accepted.");
    }

    public void enterBillingAddress(String address) {
        waitUntilElementVisible(billingAddress, 3);
        enterText(billingAddress, address);
    }

    public void verifyBillingAddressAccepted() {
        Assert.assertTrue(isElementVisible(billingAddress), "Billing address is not accepted.");
    }

    public void enterEmailAddress(String email) {
        waitUntilElementVisible(emailAddress, 3);
        enterText(emailAddress, email);
    }

    public void verifyEmailAddressAccepted() {
        Assert.assertTrue(isElementVisible(emailAddress), "Email address is not accepted.");
    }

    public void enterProductIDAndAmount(String productId, String amountValue) {
        waitUntilElementVisible(productID, 3);
        enterText(productID, productId);
        enterText(amount, amountValue);
    }

    public void verifyProductIDAndAmountAccepted() {
        Assert.assertTrue(isElementVisible(productID) && isElementVisible(amount), "Product ID and amount are not accepted.");
    }

    public void submitPayment() {
        waitUntilElementVisible(submitPaymentButton, 3);
        clickElement(submitPaymentButton);
    }

    public void verifyPaymentProcessedSuccessfully() {
        Assert.assertTrue(isElementVisible(transactionConfirmationMessage), "Payment is not processed successfully.");
    }

    public void verifyTransactionConfirmationMessage() {
        waitUntilElementVisible(transactionConfirmationMessage, 3);
        String message = getTextFromElement(transactionConfirmationMessage);
        Assert.assertEquals(message, "Transaction successful", "Transaction confirmation message is incorrect.");
    }

    public void verifyTransactionConfirmationMessageDisplayed() {
        Assert.assertTrue(isElementVisible(transactionConfirmationMessage), "Transaction confirmation message is not displayed.");
    }

    public void checkStripeDashboardForTransactionRecord() {
        waitUntilElementVisible(stripeDashboard, 3);
        // Logic to check Stripe dashboard for transaction record
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction record is not found in Stripe dashboard.");
    }

    public void verifyTransactionRecordInStripeDashboard() {
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction record is not present in Stripe dashboard.");
    }

    public void verifyEmailNotificationForTransaction() {
        waitUntilElementVisible(emailNotification, 3);
        String notification = getTextFromElement(emailNotification);
        Assert.assertEquals(notification, "Transaction notification received", "Email notification for transaction is incorrect.");
    }

    public void verifyEmailNotificationReceived() {
        Assert.assertTrue(isElementVisible(emailNotification), "Email notification is not received.");
    }

    public void logOutFromApplication() {
        waitUntilElementVisible(logOutButton, 3);
        clickElement(logOutButton);
    }

    public void verifyUserLoggedOutSuccessfully() {
        Assert.assertFalse(isElementVisible(logInButton), "User is not logged out successfully.");
    }

    public void logBackIntoApplication() {
        waitUntilElementVisible(logInButton, 3);
        clickElement(logInButton);
    }

    public void verifyUserLoggedInSuccessfully() {
        Assert.assertTrue(isElementVisible(logOutButton), "User is not logged in successfully.");
    }

    public void checkOrderHistoryForTransaction() {
        waitUntilElementVisible(orderHistory, 3);
        // Logic to check order history for transaction
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction is not found in order history.");
    }

    public void verifyTransactionInOrderHistory() {
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction is not present in order history.");
    }

    public void verifyCustomerSupportAvailability() {
        waitUntilElementVisible(customerSupport, 3);
        Assert.assertTrue(isElementVisible(customerSupport), "Customer support is not available for transaction queries.");
    }

    public void verifyCustomerSupportAvailable() {
        Assert.assertTrue(isElementVisible(customerSupport), "Customer support is not available.");
    }

    public void ensureTransactionDetailsLogged() {
        waitUntilElementVisible(transactionDetailsLog, 3);
        // Logic to ensure transaction details are logged for auditing
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction details are not logged.");
    }

    public void verifyTransactionDetailsLogged() {
        Assert.assertTrue(isElementVisible(transactionDetailsLog), "Transaction details are not logged.");
    }
}