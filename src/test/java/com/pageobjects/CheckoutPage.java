package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CheckoutPage extends WebReusableComponents {

    protected By checkoutPageIdentifier = By.id("checkoutPage");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("loginToPayPal");
    protected By btnConfirmPayPalPayment = By.id("confirmPayPalPayment");
    protected By orderConfirmationMessage = By.id("confirmationMessage");
    protected By btnCompletePayment = By.id("completePayment");
    protected By errorMessage = By.id("errorMessage");

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCheckoutPageDisplayed() {
        waitUntilElementVisible(checkoutPageIdentifier, 3);
        Assert.assertTrue(isElementDisplayed(checkoutPageIdentifier), "Checkout page is not displayed.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
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
        // Implementation to verify order confirmation
    }

    public void addProductToCart(String productName, String quantity) {
        // Implementation to add product to cart
    }

    public void navigateToShoppingCart() {
        // Implementation to navigate to shopping cart
    }

    public void verifyProductInCart(String productName) {
        // Implementation to verify product in cart
    }

    public void verifyPayPalLoginPageDisplayed() {
        // Implementation to verify PayPal login page is displayed
    }

    public void loginToPayPal(String email, String password) {
        waitUntilElementVisible(btnLoginToPayPal, 3);
        clickElement(btnLoginToPayPal);
        // Additional steps to enter email and password
    }

    public void verifyPayPalLoginSuccess() {
        // Implementation to verify PayPal login success
    }

    public void authorizePayPalPayment() {
        waitUntilElementVisible(btnConfirmPayPalPayment, 3);
        clickElement(btnConfirmPayPalPayment);
    }

    public void verifyPaymentProcessed() {
        // Implementation to verify payment is processed
    }

    public void verifyOrderConfirmationPageDisplayed() {
        // Implementation to verify order confirmation page is displayed
    }

    public void verifyOrderDetails() {
        // Implementation to verify order details
    }

    public void checkEmailForConfirmation() {
        // Implementation to check email for confirmation
    }

    public void verifyConfirmationEmailReceived() {
        // Implementation to verify confirmation email is received
    }

    public void navigateToShoppingCartPage() {
        // Logic to navigate to the shopping cart page
    }

    public void verifyShoppingCartPageDisplayed() {
        // Logic to verify the shopping cart page is displayed
    }

    public void verifyCreditCardFormDisplayed() {
        // Logic to verify the credit card form is displayed
    }

    public void attemptToCompletePayment() {
        waitUntilElementVisible(btnCompletePayment, 3);
        clickElement(btnCompletePayment);
    }

    public void verifyInvalidCreditCardErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid credit card information.", "Error message does not match.");
    }
}
