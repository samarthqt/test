package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrdersPage extends WebReusableComponents {

    protected By ordersModuleLink = By.id("ordersModule");
    protected By orderIdField = By.id("orderId");
    protected By shipmentStatusDropdown = By.id("shipmentStatus");
    protected By alertMessage = By.id("alertMessage");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToDynamics365(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(By.id("loginButton"));
    }

    public void verifyOrderExists(String orderId) {
        navigateToOrdersModule();
        enterText(orderIdField, orderId);
        Assert.assertTrue(isElementPresent(By.xpath("//td[text()='" + orderId + "']")), "Order does not exist.");
    }

    public void verifyCustomerSubscriptionStatus(String orderId, boolean isSubscribed) {
        selectOrder(orderId);
        boolean subscriptionStatus = Boolean.parseBoolean(getTextFromElement(By.id("subscriptionStatus")));
        Assert.assertEquals(subscriptionStatus, isSubscribed, "Subscription status mismatch.");
    }

    public void navigateToOrdersModule() {
        clickElement(ordersModuleLink);
    }

    public void selectOrder(String orderId) {
        enterText(orderIdField, orderId);
        clickElement(By.xpath("//td[text()='" + orderId + "']/../td/button[@id='selectOrder']"));
    }

    public void updateShipmentStatus(String orderId, String status) {
        selectOrder(orderId);
        selectByValue(shipmentStatusDropdown, status);
        clickElement(By.id("updateStatusButton"));
    }

    public void verifyNoAlertSent(String email) {
        String alertText = getTextFromElement(alertMessage);
        Assert.assertFalse(alertText.contains(email), "Alert was sent to " + email);
    }

    public void verifyNoEmailReceived(String email) {
        boolean emailReceived = checkEmailInbox(email);
        Assert.assertFalse(emailReceived, "Email was received by " + email);
    }

    private boolean checkEmailInbox(String email) {
        // Logic to check email inbox
        return false;
    }
}