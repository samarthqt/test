package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderConfirmationPage extends WebReusableComponents {

    protected By emailConfirmation = By.id("emailConfirmation");
    protected By smsConfirmation = By.id("smsConfirmation");
    protected By orderNumber = By.id("orderNumber");
    protected By shippingAddress = By.id("shippingAddress");
    protected By itemsPurchased = By.id("itemsPurchased");
    protected By estimatedDeliveryDate = By.id("estimatedDeliveryDate");
    protected By confirmationMessage = By.id("confirmationMessage");

    public OrderConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public void completeCheckoutProcess() {
        proceedToCheckout();
        enterShippingDetails("John Doe", "123 Main St", "Anytown", "12345", "1234567890");
        selectPaymentMethod("Credit Card");
        enterCreditCardDetails("4111111111111111", "12/23", "123");
        placeOrder();
    }

    public void placeOrderSuccessfully() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
        verifyOrderConfirmation("Your order has been placed successfully!");
    }

    public void verifyEmailConfirmationReceived() {
        waitUntilElementVisible(emailConfirmation, 3);
        Assert.assertTrue(isElementDisplayed(emailConfirmation), "Email confirmation not received.");
    }

    public void verifySMSConfirmationReceived() {
        waitUntilElementVisible(smsConfirmation, 3);
        Assert.assertTrue(isElementDisplayed(smsConfirmation), "SMS confirmation not received.");
    }

    public void receiveOrderConfirmation() {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, "Your order has been confirmed!", "Order confirmation message does not match.");
    }

    public void verifyOrderNumberIncluded() {
        waitUntilElementVisible(orderNumber, 3);
        Assert.assertTrue(isElementDisplayed(orderNumber), "Order number not included in confirmation.");
    }

    public void verifyShippingAddressIncluded() {
        waitUntilElementVisible(shippingAddress, 3);
        Assert.assertTrue(isElementDisplayed(shippingAddress), "Shipping address not included in confirmation.");
    }

    public void verifyItemsPurchasedIncluded() {
        waitUntilElementVisible(itemsPurchased, 3);
        Assert.assertTrue(isElementDisplayed(itemsPurchased), "Items purchased not included in confirmation.");
    }

    public void verifyEstimatedDeliveryDateIncluded() {
        waitUntilElementVisible(estimatedDeliveryDate, 3);
        Assert.assertTrue(isElementDisplayed(estimatedDeliveryDate), "Estimated delivery date not included in confirmation.");
    }

    public void ensureTimelyDeliveryOfMessages() {
        waitUntilElementVisible(emailConfirmation, 3);
        waitUntilElementVisible(smsConfirmation, 3);
        Assert.assertTrue(isElementDisplayed(emailConfirmation) && isElementDisplayed(smsConfirmation), "Confirmation messages not delivered timely.");
    }

    public void verifyMessageFormatting() {
        waitUntilElementVisible(confirmationMessage, 3);
        WebElement messageElement = driver.findElement(confirmationMessage);
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains("Order Confirmation"), "Confirmation message not formatted correctly.");
    }

    public void accessOrderDetailsFromMessage() {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String orderDetails = getTextFromElement(orderConfirmationMessage);
        Assert.assertNotNull(orderDetails, "Order details not accessible from confirmation message.");
    }

    public void logConfirmationMessage() {
        waitUntilElementVisible(confirmationMessage, 3);
        String message = getTextFromElement(confirmationMessage);
        System.out.println("Confirmation Message: " + message);
    }
}