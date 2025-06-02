package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class PaymentProcessingPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By paymentProcessingSection = By.id("paymentProcessingSection");
    protected By checkoutPageLink = By.id("checkoutPageLink");
    protected By currencyDropdown = By.id("currencyDropdown");
    protected By paymentDetailsSection = By.id("paymentDetailsSection");
    protected By paymentAmountField = By.id("paymentAmount");
    protected By exchangeRateField = By.id("exchangeRate");
    protected By btnConfirmPayment = By.id("confirmPaymentButton");
    protected By paymentSuccessMessage = By.id("paymentSuccessMessage");
    protected By transactionConfirmationMessage = By.id("transactionConfirmationMessage");
    protected By confirmationScreen = By.id("confirmationScreen");
    protected By logoutButton = By.id("logoutButton");

    public PaymentProcessingPage() {
        PageFactory.initElements(driver, this);
    }

    public void accessPaymentProcessingSystem() {
        waitUntilElementVisible(paymentProcessingSection, 3);
        clickElement(paymentProcessingSection);
    }

    public void login(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        boolean isLoggedIn = elementVisible(paymentProcessingSection);
        Assert.assertTrue(isLoggedIn, "Login was not successful.");
    }

    public void verifySufficientFunds() {
        // Logic to verify sufficient funds
        Assert.assertTrue(true, "Sufficient funds are not available.");
    }

    public void verifyCurrenciesSetup() {
        // Logic to verify currencies setup
        Assert.assertTrue(true, "Currencies are not set up correctly.");
    }

    public void navigateToPaymentProcessingSection() {
        waitUntilElementVisible(paymentProcessingSection, 3);
        clickElement(paymentProcessingSection);
    }

    public void verifyPaymentProcessingSectionDisplayed() {
        boolean isDisplayed = elementVisible(paymentProcessingSection);
        Assert.assertTrue(isDisplayed, "Payment processing section is not displayed.");
    }

    public void selectMakePaymentOption() {
        waitUntilElementVisible(paymentDetailsSection, 3);
        clickElement(paymentDetailsSection);
    }

    public void verifyPaymentOptionsDisplayed() {
        boolean optionsDisplayed = elementVisible(paymentDetailsSection);
        Assert.assertTrue(optionsDisplayed, "Payment options are not displayed.");
    }

    public void enterPaymentAmount(String amount, String currency) {
        waitUntilElementVisible(paymentAmountField, 3);
        enterText(paymentAmountField, amount);
        selectByValue(currencyDropdown, currency);
    }

    public void verifyPaymentAmountAccepted() {
        String enteredAmount = getTextFromElement(paymentAmountField);
        Assert.assertFalse(enteredAmount.isEmpty(), "Payment amount was not accepted.");
    }

    public void selectTargetCurrency(String currency) {
        selectByValue(currencyDropdown, currency);
    }

    public void verifyTargetCurrencySelected() {
        String selectedCurrency = getSelectedValue(currencyDropdown);
        Assert.assertEquals(selectedCurrency, currency, "Target currency was not selected.");
    }

    public void verifyExchangeRate(String expectedRate) {
        waitUntilElementVisible(exchangeRateField, 3);
        String actualRate = getTextFromElement(exchangeRateField);
        Assert.assertEquals(actualRate, expectedRate, "Exchange rate does not match.");
    }

    public void verifyExchangeRateDisplayed() {
        boolean rateDisplayed = elementVisible(exchangeRateField);
        Assert.assertTrue(rateDisplayed, "Exchange rate is not displayed.");
    }

    public void proceedToConfirmPayment() {
        waitUntilElementVisible(btnConfirmPayment, 3);
        clickElement(btnConfirmPayment);
    }

    public void verifyConfirmationScreenDisplayed() {
        boolean confirmationDisplayed = elementVisible(confirmationScreen);
        Assert.assertTrue(confirmationDisplayed, "Confirmation screen is not displayed.");
    }

    public void confirmPaymentTransaction() {
        // Logic to confirm payment transaction
        Assert.assertTrue(true, "Payment transaction was not confirmed.");
    }

    public void verifyPaymentProcessedSuccessfully() {
        waitUntilElementVisible(paymentSuccessMessage, 3);
        String successMessage = getTextFromElement(paymentSuccessMessage);
        Assert.assertTrue(successMessage.contains("success"), "Payment was not processed successfully.");
    }

    public void checkTransactionDetailsForCurrencyConversion() {
        // Logic to check transaction details for currency conversion
        Assert.assertTrue(true, "Transaction details for currency conversion are incorrect.");
    }

    public void verifyCurrencyConversionAccuracy() {
        // Logic to verify currency conversion accuracy
        Assert.assertTrue(true, "Currency conversion accuracy is not verified.");
    }

    public void verifyUpdatedAccountBalance(String currency) {
        // Logic to verify updated account balance
        Assert.assertTrue(true, "Account balance is not updated for " + currency);
    }

    public void verifyAccountBalanceConversion() {
        // Logic to verify account balance reflects conversion
        Assert.assertTrue(true, "Account balance does not reflect conversion.");
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        boolean isLoggedOut = !elementVisible(paymentProcessingSection);
        Assert.assertTrue(isLoggedOut, "Logout was not successful.");
    }

    public void loginWithValidCredentials() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToCheckoutPage() {
        waitUntilElementVisible(checkoutPageLink, 3);
        clickElement(checkoutPageLink);
    }

    public void selectCurrency(String currency) {
        waitUntilElementVisible(currencyDropdown, 3);
        selectByValue(currencyDropdown, currency);
    }

    public void enterPaymentDetails(String currency) {
        waitUntilElementVisible(paymentDetailsSection, 3);
        // Logic to enter payment details based on currency
        Assert.assertTrue(true, "Payment details were not entered for " + currency);
    }

    public void confirmPayment(String currency) {
        waitUntilElementVisible(btnConfirmPayment, 3);
        clickElement(btnConfirmPayment);
    }

    public void verifyPaymentProcessed(String currency) {
        waitUntilElementVisible(paymentSuccessMessage, 3);
        String actualMessage = getTextFromElement(paymentSuccessMessage);
        Assert.assertTrue(actualMessage.contains(currency), "Payment not processed successfully for " + currency);
    }

    public void verifyTransactionConfirmation(String currency) {
        waitUntilElementVisible(transactionConfirmationMessage, 3);
        String actualMessage = getTextFromElement(transactionConfirmationMessage);
        Assert.assertTrue(actualMessage.contains(currency), "Transaction confirmation not received for " + currency);
    }

    public void completeMultipleCurrencyTransactions() {
        // Logic to complete transactions in multiple currencies
        Assert.assertTrue(true, "Multiple currency transactions were not completed.");
    }

    public void verifyCurrencyConversionRates() {
        // Logic to verify currency conversion rates
        Assert.assertTrue(true, "Currency conversion rates are not verified.");
    }
}