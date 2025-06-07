package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ShipmentPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By myShipmentsSection = By.id("myShipments");
    protected By activeShipment = By.cssSelector(".active-shipment");
    protected By shipmentTimeline = By.id("shipmentTimeline");
    protected By pushNotificationToggle = By.id("pushNotificationToggle");
    protected By shipmentMap = By.id("shipmentMap");
    protected By awaitingUpdateMessage = By.id("awaitingUpdateMessage");
    protected By orderList = By.id("orderList");
    protected By orderDetails = By.id("orderDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By alertSystem = By.id("alertSystem");
    protected By dashboard = By.id("dashboard");
    protected By ordersModule = By.id("ordersModule");
    protected By alertMessage = By.id("alertMessage");

    public ShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), "Login failed, dashboard not displayed.");
    }

    public void navigateToMyShipments() {
        waitUntilElementVisible(myShipmentsSection, 3);
        clickElement(myShipmentsSection);
    }

    public void selectActiveShipment() {
        waitUntilElementVisible(activeShipment, 3);
        clickElement(activeShipment);
    }

    public void verifyShipmentTimelineDisplayed() {
        waitUntilElementVisible(shipmentTimeline, 3);
        Assert.assertTrue(isElementDisplayed(shipmentTimeline), "Shipment timeline is not displayed.");
    }

    public void verifyInMyShipmentsSection() {
        Assert.assertTrue(isElementDisplayed(myShipmentsSection), "Not in My Shipments section.");
    }

    public void enablePushNotifications() {
        waitUntilElementVisible(pushNotificationToggle, 3);
        clickElement(pushNotificationToggle);
    }

    public void verifyPushNotificationsEnabled() {
        Assert.assertTrue(isElementSelected(pushNotificationToggle), "Push notifications are not enabled.");
    }

    public void viewActiveShipment() {
        waitUntilElementVisible(activeShipment, 3);
        clickElement(activeShipment);
    }

    public void simulateBackendStatusUpdate(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        enterText(shipmentStatus, status);
    }

    public void verifyStatusUpdateOnUI(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Status update on UI does not match.");
    }

    public void verifyPushNotificationTriggered() {
        waitUntilElementVisible(alertMessage, 3);
        String message = getTextFromElement(alertMessage);
        Assert.assertTrue(message.contains("Notification"), "Push notification not triggered.");
    }

    public void viewShipmentMap() {
        waitUntilElementVisible(shipmentMap, 3);
        clickElement(shipmentMap);
        Assert.assertTrue(isElementVisible(shipmentMap), "Shipment map is not visible.");
    }

    public void verifyShipmentLocation() {
        waitUntilElementVisible(shipmentMap, 3);
        Assert.assertTrue(isElementVisible(shipmentMap), "Shipment location is not verified.");
    }

    public void viewShipmentStatus() {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertTrue(isElementVisible(shipmentStatus), "Shipment status is not visible.");
    }

    public void simulateStatusUpdateDelay() {
        waitUntilElementVisible(awaitingUpdateMessage, 3);
        String actualMessage = getTextFromElement(awaitingUpdateMessage);
        Assert.assertEquals(actualMessage, "Awaiting latest update…", "Status update delay message is not displayed.");
    }

    public void verifyAwaitingUpdateMessage() {
        waitUntilElementVisible(awaitingUpdateMessage, 3);
        String actualMessage = getTextFromElement(awaitingUpdateMessage);
        Assert.assertEquals(actualMessage, "Awaiting latest update…", "Awaiting update message is not displayed.");
    }

    public void verifyOrderExists(int orderId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        boolean orderFound = orders.stream().anyMatch(order -> order.getText().contains(String.valueOf(orderId)));
        Assert.assertTrue(orderFound, "Order does not exist.");
    }

    public void verifyCustomerSubscription() {
        boolean isSubscribed = checkSubscriptionStatus();
        Assert.assertTrue(isSubscribed, "Customer is not subscribed.");
    }

    public void verifyCustomerEmail(String email) {
        String actualEmail = getCustomerEmail();
        Assert.assertEquals(actualEmail, email, "Customer email does not match.");
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not displayed.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(ordersModule, 3);
        clickElement(ordersModule);
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(ordersModule, 3);
        Assert.assertTrue(isElementVisible(ordersModule), "Orders module is not displayed.");
    }

    public void selectOrderById(int orderId) {
        waitUntilElementVisible(orderList, 3);
        List<WebElement> orders = getWebElementList(orderList);
        orders.stream().filter(order -> order.getText().contains(String.valueOf(orderId)))
              .findFirst().ifPresent(WebElement::click);
    }

    public void verifyOrderDetailsDisplayed(int orderId) {
        waitUntilElementVisible(orderDetails, 3);
        String detailsText = getTextFromElement(orderDetails);
        Assert.assertTrue(detailsText.contains(String.valueOf(orderId)), "Order details are not displayed.");
    }

    public void verifyShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, status, "Shipment status does not match.");
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        enterText(shipmentStatus, status);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status update failed.");
    }

    public void verifyShipmentStatusUpdated(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, status, "Shipment status is not updated.");
    }

    public void checkAlertSystem() {
        waitUntilElementVisible(alertSystem, 3);
        Assert.assertTrue(isElementVisible(alertSystem), "Alert system is not active.");
    }

    public void verifyAlertSent(String email) {
        waitUntilElementVisible(alertMessage, 3);
        String message = getTextFromElement(alertMessage);
        Assert.assertTrue(message.contains(email), "Alert not sent to the specified email.");
    }

    public void verifyAlertMessage(String message) {
        waitUntilElementVisible(alertMessage, 3);
        String actualMessage = getTextFromElement(alertMessage);
        Assert.assertEquals(actualMessage, message, "Alert message does not match.");
    }
}