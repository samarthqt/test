package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class TransactionPage extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnInitiateTransaction = By.id("initiateTransaction");
    protected By txtAmount = By.id("amount");
    protected By btnConfirmTransaction = By.id("confirmTransaction");
    protected By lblSuccessMessage = By.id("successMessage");
    protected By lblErrorMessage = By.id("errorMessage");

    public TransactionPage() {
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
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

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void navigateToPaymentMethods() {
        waitUntilElementVisible(paymentMethodsLink, 3);
        clickElement(paymentMethodsLink);
    }

    public void addNewPaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        waitUntilElementVisible(addPaymentMethodButton, 3);
        clickElement(addPaymentMethodButton);
        enterText(txtCardNumber, cardNumber);
        enterText(txtCardHolderName, cardHolderName);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
        clickElement(savePaymentMethodButton);
    }

    public void verifyPaymentMethodSaved() {
        waitUntilElementVisible(savedCards, 3);
        List<WebElement> cards = getWebElementList(savedCards);
        Assert.assertFalse(cards.isEmpty(), "No saved payment methods found.");
    }

    public void removePaymentMethod(String lastFourDigits) {
        By removeButton = removeCardButton(lastFourDigits);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyPaymentMethodRemoved(String lastFourDigits) {
        By cardLocator = removeCardButton(lastFourDigits);
        boolean isCardPresent = elementVisible(cardLocator);
        Assert.assertFalse(isCardPresent, "Card was not removed from saved payment methods.");
    }

    public void enterUsername(String username) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess(String expectedMessage) {
        waitUntilElementVisible(lblSuccessMessage, 3);
        String actualMessage = getTextFromElement(lblSuccessMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Login success message does not match.");
    }

    public void verifyLoginFailure(String expectedMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Login error message does not match.");
    }

    public void initiateTransaction(String amount) {
        waitUntilElementVisible(btnInitiateTransaction, 3);
        enterText(txtAmount, amount);
        clickElement(btnInitiateTransaction);
    }

    public void confirmTransaction() {
        waitUntilElementVisible(btnConfirmTransaction, 3);
        clickElement(btnConfirmTransaction);
    }

    public void verifyTransactionSuccess(String expectedMessage) {
        waitUntilElementVisible(lblSuccessMessage, 3);
        String actualMessage = getTextFromElement(lblSuccessMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Transaction success message does not match.");
    }

    public void verifyTransactionFailure(String expectedMessage) {
        waitUntilElementVisible(lblErrorMessage, 3);
        String actualMessage = getTextFromElement(lblErrorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Transaction error message does not match.");
    }

    private By removeCardButton(String lastFourDigits) {
        return By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
    }
}