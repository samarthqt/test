package com.pageobjects;
import org.testng.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class CheckoutPage extends WebReusableComponents {

    protected By checkoutPage = By.id("checkoutPage");
    protected By guestCheckoutOption = By.id("guestCheckoutOption");
    protected By guestCheckoutForm = By.id("guestCheckoutForm");
    protected By shippingAddressField = By.id("shippingAddress");
    protected By shippingMethod = By.id("shippingMethod");
    protected By paymentDetailsField = By.id("paymentDetails");
    protected By orderSummary = By.id("orderSummary");
    protected By placeOrderButton = By.id("placeOrderButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By emailConfirmation = By.id("emailConfirmation");

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCheckoutPage() {
        driver.get("http://dummyurl.com/checkout");
    }

    public void verifyCheckoutPageDisplayed() {
        waitUntilElementVisible(checkoutPage, 3);
    }

    public void assertCheckoutPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(checkoutPage), "Checkout page is not displayed.");
    }

    public void verifyItemsInCart() {
        // Logic to verify items in cart
    }

    public void selectGuestCheckoutOption() {
        waitUntilElementVisible(guestCheckoutOption, 3);
        clickElement(guestCheckoutOption);
    }

    public void assertGuestCheckoutFormDisplayed() {
        Assert.assertTrue(isElementDisplayed(guestCheckoutForm), "Guest checkout form is not displayed.");
    }

    public void enterShippingAddressDetails(String address) {
        waitUntilElementVisible(shippingAddressField, 3);
        enterText(shippingAddressField, address);
    }

    public void assertShippingAddressValidated() {
        // Logic to assert shipping address validation
    }

    public void selectShippingMethod() {
        waitUntilElementVisible(shippingMethod, 3);
        clickElement(shippingMethod);
    }

    public void assertShippingMethodSelected() {
        // Logic to assert shipping method selection
    }

    public void enterPaymentDetails() {
        waitUntilElementVisible(paymentDetailsField, 3);
        enterText(paymentDetailsField, "4111111111111111"); // Dummy credit card number
    }

    public void assertPaymentDetailsValidated() {
        // Logic to assert payment details validation
    }

    public void reviewOrderSummary() {
        waitUntilElementVisible(orderSummary, 3);
    }

    public void assertOrderSummaryCorrect() {
        // Logic to assert order summary correctness
    }

    public void placeOrder() {
        waitUntilElementVisible(placeOrderButton, 3);
        clickElement(placeOrderButton);
    }

    public void assertOrderPlacedSuccessfully() {
        Assert.assertTrue(isElementDisplayed(confirmationMessage), "Order was not placed successfully.");
    }

    public void checkEmailForConfirmation() {
        // Logic to check email for confirmation
    }

    public void assertOrderConfirmationEmailReceived() {
        Assert.assertTrue(isElementDisplayed(emailConfirmation), "Order confirmation email was not received.");
    }
}