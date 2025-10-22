package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CheckoutPage extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("confirmationMessage");

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

    public void selectPaymentMethod(String paymentMethod) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, paymentMethod);
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

    // New methods appended
    public void verifyStockStatus(String expectedStatus) {
        // Implement stock status verification logic here
    }

    public void verifyCartDetails(int expectedQuantity, double expectedPrice) {
        // Implement cart details verification logic here
    }

    public void verifyOrderDetailsOnCheckout() {
        // Implement order details verification logic here
    }

    public void verifyPaymentDetailsAccepted() {
        // Implement payment details acceptance verification logic here
    }

    public void verifyOrderConfirmationPage() {
        // Implement order confirmation page verification logic here
    }

    public void verifyEmailReceipt(String expectedOrderSummary) {
        // Implement email receipt verification logic here
    }

    public void verifyInventoryReduction(int productId, int expectedReduction) {
        // Implement inventory reduction verification logic here
    }

    public void verifyOrderStatus(String expectedStatus) {
        // Implement order status verification logic here
    }

    public void verifySMSNotification(String expectedMessage) {
        // Implement SMS notification verification logic here
    }
}