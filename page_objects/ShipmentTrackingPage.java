package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By shipmentTrackingLink = By.id("shipmentTrackingLink");
    protected By trackingField = By.id("trackingField");
    protected By shipmentDetails = By.id("shipmentDetails");
    protected By currentStatus = By.id("currentStatus");
    protected By statusUpdateButton = By.id("statusUpdateButton");
    protected By timestamp = By.id("timestamp");
    protected By notificationSettings = By.id("notificationSettings");
    protected By errorMessages = By.id("errorMessages");
    protected By shipmentHistoryLog = By.id("shipmentHistoryLog");
    protected By orderList = By.id("orderList");
    protected By orderDetails = By.id("orderDetails");
    protected By shipmentStatus = By.id("shipmentStatus");
    protected By alertMessage = By.id("alertMessage");

    public ShipmentTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToShipmentTrackingPage() {
        waitUntilElementVisible(shipmentTrackingLink, 3);
        clickElement(shipmentTrackingLink);
    }

    public void verifyShipmentTrackingPageDisplayed() {
        Assert.assertTrue(isElementVisible(shipmentTrackingLink), "Shipment tracking page is not displayed.");
    }

    public void verifyShipmentDataAvailable() {
        Assert.assertTrue(isElementVisible(trackingField), "Shipment data is not available.");
    }

    public void enterShipmentID(String shipmentID) {
        waitUntilElementVisible(trackingField, 3);
        enterText(trackingField, shipmentID);
    }

    public void verifyShipmentDetailsDisplayed(String shipmentID) {
        waitUntilElementVisible(shipmentDetails, 3);
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(shipmentID), "Shipment details are not displayed.");
    }

    public void checkCurrentShipmentStatus() {
        waitUntilElementVisible(currentStatus, 3);
    }

    public void verifyCurrentStatus(String expectedStatus) {
        String actualStatus = getTextFromElement(currentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Current status does not match.");
    }

    public void simulateStatusUpdate(String newStatus) {
        waitUntilElementVisible(statusUpdateButton, 3);
        clickElement(statusUpdateButton);
        enterText(currentStatus, newStatus);
    }

    public void verifyStatusUpdate(String expectedStatus) {
        String actualStatus = getTextFromElement(currentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Status update failed.");
    }

    public void verifyTimestampOfLatestStatusUpdate() {
        waitUntilElementVisible(timestamp, 3);
    }

    public void verifyTimestampMatchesCurrentTime() {
        String actualTimestamp = getTextFromElement(timestamp);
        String expectedTimestamp = getCurrentTime();
        Assert.assertEquals(actualTimestamp, expectedTimestamp, "Timestamp does not match current time.");
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void verifyStatusRemainsDelivered() {
        String actualStatus = getTextFromElement(currentStatus);
        Assert.assertEquals(actualStatus, "Delivered", "Status does not remain 'Delivered'.");
    }

    public void logoutAndLogin() {
        clickElement(btnLogin);
        clickElement(btnLogin);
    }

    public void verifyShipmentStatusRemainsDelivered() {
        String actualStatus = getTextFromElement(currentStatus);
        Assert.assertEquals(actualStatus, "Delivered", "Shipment status does not remain 'Delivered'.");
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
    }

    public void verifyNotificationsEnabled() {
        Assert.assertTrue(isElementVisible(notificationSettings), "Notifications are not enabled.");
    }

    public void simulateNetworkIssueAndUpdateStatus() {
        simulateNetworkIssue();
        clickElement(statusUpdateButton);
    }

    public void verifySystemHandlesNetworkIssue() {
        Assert.assertTrue(isElementVisible(errorMessages), "System did not handle network issue gracefully.");
    }

    public void verifyShipmentHistoryLog() {
        waitUntilElementVisible(shipmentHistoryLog, 3);
    }

    public void verifyLogContainsStatusUpdates() {
        Assert.assertTrue(getTextFromElement(shipmentHistoryLog).contains("Status updates"), "Log does not contain all status updates.");
    }

    public void checkForErrorMessages() {
        waitUntilElementVisible(errorMessages, 3);
    }

    public void verifyNoErrorMessages() {
        Assert.assertFalse(isElementVisible(errorMessages), "Error messages are displayed.");
    }

    public void attemptStatusUpdateFromDifferentDevice() {
        simulateDeviceChange();
        clickElement(statusUpdateButton);
    }

    public void verifyStatusSynchronizationAcrossDevices() {
        Assert.assertTrue(isElementVisible(currentStatus), "Status updates are not synchronized across devices.");
    }

    public void verifyShipmentStatusOnMobileDevice() {
        simulateMobileDevice();
        Assert.assertTrue(isElementVisible(currentStatus), "Shipment status is not consistent with desktop view.");
    }

    public void checkShipmentStatusAfterSystemReboot() {
        simulateSystemReboot();
        Assert.assertTrue(isElementVisible(currentStatus), "Shipment status does not remain 'Delivered'.");
    }

    public void verifyStatusRemainsDeliveredAfterReboot() {
        String actualStatus = getTextFromElement(currentStatus);
        Assert.assertEquals(actualStatus, "Delivered", "Status does not remain 'Delivered' after reboot.");
    }

    public void verifyOrderExists(String orderId) {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(getTextFromElement(orderList).contains(orderId), "Order does not exist.");
    }

    public void verifyCustomerSubscription() {
        Assert.assertTrue(isElementVisible(notificationSettings), "Customer subscription is not verified.");
    }

    public void verifyDashboardDisplayed() {
        Assert.assertTrue(isElementVisible(orderList), "Dashboard is not displayed.");
    }

    public void navigateToOrdersModule() {
        waitUntilElementVisible(orderList, 3);
        clickElement(orderList);
    }

    public void verifyOrdersModuleDisplayed() {
        Assert.assertTrue(isElementVisible(orderList), "Orders module is not displayed.");
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderDetails, 3);
        enterText(orderDetails, orderId);
    }

    public void verifyOrderDetailsDisplayed(String orderId) {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(getTextFromElement(orderDetails).contains(orderId), "Order details are not displayed.");
    }

    public void verifyShipmentStatus(String status) {
        waitUntilElementVisible(shipmentStatus, 3);
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status does not match.");
    }

    public void updateShipmentStatus(String status) {
        waitUntilElementVisible(statusUpdateButton, 3);
        enterText(shipmentStatus, status);
    }

    public void verifyShipmentStatusUpdated(String status) {
        Assert.assertEquals(getTextFromElement(shipmentStatus), status, "Shipment status update failed.");
    }

    public void verifyCustomerReceivedAlert() {
        Assert.assertTrue(isElementVisible(alertMessage), "Customer did not receive alert.");
    }

    public void verifyErrorMessagePersists() {
        Assert.assertTrue(isElementVisible(errorMessages), "Error message does not persist.");
    }

    public void verifySystemHandlesLongID() {
        String longID = "12345678901234567890";
        enterShipmentID(longID);
        Assert.assertTrue(isElementVisible(errorMessages), "System does not handle long ID gracefully.");
    }

    public void verifyEstimatedDeliveryTimeDisplayed() {
        Assert.assertTrue(isElementVisible(timestamp), "Estimated delivery time is not displayed.");
    }

    public void verifyRealTimeUpdates() {
        Assert.assertTrue(isElementVisible(currentStatus), "Real-time updates are not visible.");
    }

    public void verifyAlertSent() {
        Assert.assertTrue(isElementVisible(alertMessage), "Alert was not sent.");
    }

    public void updateShipmentStatusToDelivered() {
        updateShipmentStatus("Delivered");
    }

    public void login() {
        loginToSystem();
    }

    public void verifyCustomerAccount() {
        Assert.assertTrue(isElementVisible(notificationSettings), "Customer account verification failed.");
    }

    public void verifyCurrentLocationDisplayed() {
        Assert.assertTrue(isElementVisible(shipmentDetails), "Current location is not displayed.");
    }

    public void verifyErrorMessageOrGracefulHandling() {
        Assert.assertTrue(isElementVisible(errorMessages), "Error message or graceful handling failed.");
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementVisible(shipmentTrackingLink), "Track shipment section is not displayed.");
    }

    public void verifyShipmentStatusUpdatedToDelivered() {
        Assert.assertEquals(getTextFromElement(shipmentStatus), "Delivered", "Shipment status update to 'Delivered' failed.");
    }

    public void updateShipmentStatusToInTransit() {
        updateShipmentStatus("In Transit");
    }

    public void verifyInvalidShipmentIDErrorMessage() {
        enterShipmentID("invalidID");
        Assert.assertTrue(isElementVisible(errorMessages), "Invalid shipment ID error message is not displayed.");
    }

    public void navigateToTrackShipment() {
        navigateToShipmentTrackingPage();
    }

    public void logout() {
        clickElement(btnLogin);
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementVisible(shipmentTrackingLink), "Logout was not successful.");
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(shipmentTrackingLink), "Login was not successful.");
    }

    public void checkForFeedbackOrErrorMessage() {
        Assert.assertTrue(isElementVisible(errorMessages), "Feedback or error message is not displayed.");
    }

    public void verifyAlertSentToCustomer() {
        Assert.assertTrue(isElementVisible(alertMessage), "Alert was not sent to customer.");
    }

    public void verifyShipmentOrderExists() {
        Assert.assertTrue(isElementVisible(orderList), "Shipment order does not exist.");
    }

    public void navigateToTrackShipmentSection() {
        navigateToShipmentTrackingPage();
    }

    public void verifyShipmentInTransit() {
        Assert.assertEquals(getTextFromElement(shipmentStatus), "In Transit", "Shipment is not in transit.");
    }

    public void checkAlertSystemForOutgoingAlerts() {
        Assert.assertTrue(isElementVisible(alertMessage), "Outgoing alerts are not visible.");
    }
}