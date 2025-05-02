package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class GuestCheckoutPage extends WebReusableComponents {

    protected By btnSelectProduct = By.id("selectProduct");
    protected By btnAddToCart = By.id("addToCart");
    protected By cartIcon = By.id("cartIcon");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By orderSummary = By.id("orderSummary");
    protected By btnConfirmPurchase = By.id("confirmPurchase");
    protected By orderConfirmationMessage = By.id("confirmationMessage");
    protected By accountCreationOffer = By.id("accountCreationOffer");

    public void navigateToHomePage() {
        // Implementation to navigate to home page
    }

    public void selectProduct(String productName) {
        waitUntilElementVisible(btnSelectProduct, 3);
        clickElement(btnSelectProduct);
    }

    public void verifyProductInCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
        // Verify product in cart
    }

    public void openCart() {
        waitUntilElementVisible(cartIcon, 3);
        clickElement(cartIcon);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void verifyCheckoutPage() {
        // Verify checkout page is displayed
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void verifyShippingDetailsAccepted() {
        // Verify shipping details are accepted
    }

    public void enterPaymentDetails(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
    }

    public void verifyPaymentDetailsAccepted() {
        // Verify payment details are accepted
    }

    public void reviewOrderSummary() {
        waitUntilElementVisible(orderSummary, 3);
        // Review order summary
    }

    public void verifyOrderSummary() {
        // Verify order summary
    }

    public void confirmPurchase() {
        waitUntilElementVisible(btnConfirmPurchase, 3);
        clickElement(btnConfirmPurchase);
    }

    public void verifyPurchaseCompletion() {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        // Verify purchase completion
    }

    public void verifyOrderConfirmationEmail() {
        // Verify order confirmation email
    }

    public void viewOrderConfirmationPage() {
        // View order confirmation page
    }

    public void verifyAccountCreationOffer() {
        waitUntilElementVisible(accountCreationOffer, 3);
        // Verify account creation offer
    }
}