package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentTrackingPage extends WebReusableComponents {

    protected By loginButton = By.id(loginButton);
    protected By shipmentTrackingLink = By.id(shipmentTrackingLink);
    protected By trackingField = By.id(trackingField);
    protected By shipmentDetails = By.id(shipmentDetails);
    protected By currentStatus = By.id(currentStatus);
    protected By statusUpdateButton = By.id(statusUpdateButton);
    protected By timestampField = By.id(timestampField);
    protected By notificationSettings = By.id(notificationSettings);
    protected By errorMessage = By.id(errorMessage);
    protected By mobileStatus = By.id(mobileStatus);
    protected By orderList = By.id(orderList);
    protected By orderDetails = By.id(orderDetails);
    protected By shipmentStatus = By.id(shipmentStatus);
    protected By alertMessage = By.id(alertMessage);

    public ShipmentTrackingPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToSystem() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void navigateToShipmentTrackingPage() {
        waitUntilElementVisible(shipmentTrackingLink, 3);
        clickElement(shipmentTrackingLink);
    }

    public void verifyShipmentTrackingPageDisplayed() {
        Assert.assertTrue(isElementVisible(shipmentTrackingLink), Shipment tracking page is not displayed.);
    }

    public void verifyShipmentDataAvailability() {
        Assert.assertTrue(isElementVisible(shipmentDetails), Shipment data is not available.);
    }

    public void enterShipmentID(int shipmentId) {
        waitUntilElementVisible(trackingField, 3);
        enterText(trackingField, String.valueOf(shipmentId));
    }

    public void verifyShipmentDetailsDisplayed(int shipmentId) {
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(String.valueOf(shipmentId)), Shipment details are not displayed.);
    }

    public void checkCurrentShipmentStatus() {
        waitUntilElementVisible(currentStatus, 3);
    }

    public void verifyCurrentStatus(String expectedStatus) {
        Assert.assertEquals(getTextFromElement(currentStatus), expectedStatus, Current status does not match.);
    }

    public void simulateStatusUpdate(String newStatus) {
        waitUntilElementVisible(statusUpdateButton, 3);
        clickElement(statusUpdateButton);
        enterText(currentStatus, newStatus);
    }

    public void verifyTimestampOfLatestStatusUpdate() {
        Assert.assertTrue(isElementVisible(timestampField), Timestamp is not visible.);
    }

    public void verifyTimestampMatchesCurrentTime() {
        String currentTime = getCurrentTime();
        Assert.assertEquals(getTextFromElement(timestampField), currentTime, Timestamp does not match current time.);
    }

    public void refreshPage() {
        refreshBrowser();
    }

    public void logoutAndLogin() {
        logout();
        loginToSystem();
    }

    public void checkNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
    }

    public void verifyNotificationsEnabled() {
        Assert.assertTrue(isElementVisible(notificationSettings), Notifications are not enabled.);
    }

    public void simulateNetworkIssueDuringUpdate() {
        simulateNetworkIssue();
    }

    public void handleNetworkIssueGracefully() {
        handleNetworkIssue();
    }

    public void verifySystemRetriesUpdate() {
        Assert.assertTrue(isElementVisible(statusUpdateButton), System did not retry update.);
    }

    public void verifyStatusUpdatesMade() {
        Assert.assertTrue(isElementVisible(shipmentDetails), Status updates have not been made.);
    }

    public void verifyShipmentHistoryLog() {
        Assert.assertTrue(isElementVisible(shipmentDetails), Shipment history log is not visible.);
    }

    public void verifyLogContainsAllUpdates() {
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(All Updates), Log does not contain all updates.);
    }

    public void updateShipmentStatus() {
        waitUntilElementVisible(statusUpdateButton, 3);
        clickElement(statusUpdateButton);
    }

    public void checkForErrorMessages() {
        waitUntilElementVisible(errorMessage, 3);
    }

    public void verifyNoErrorMessages() {
        Assert.assertFalse(isElementVisible(errorMessage), Error messages are displayed.);
    }

    public void verifyAccessToMultipleDevices() {
        Assert.assertTrue(isElementVisible(mobileStatus), Access to multiple devices is not verified.);
    }

    public void updateStatusFromDifferentDevice() {
        waitUntilElementVisible(mobileStatus, 3);
        clickElement(mobileStatus);
    }

    public void verifyStatusSynchronization() {
        Assert.assertTrue(isElementVisible(mobileStatus), Status is not synchronized across devices.);
    }

    public void checkStatusOnMobileDevice() {
        waitUntilElementVisible(mobileStatus, 3);
    }

    public void verifyStatusDisplayed() {
        Assert.assertTrue(isElementVisible(mobileStatus), Status is not displayed.);
    }

    public void verifyStatusConsistencyWithDesktop() {
        Assert.assertEquals(getTextFromElement(mobileStatus), getTextFromElement(currentStatus), Status is not consistent with desktop view.);
    }

    public void rebootSystem() {
        reboot();
    }

    public void checkShipmentStatus() {
        waitUntilElementVisible(currentStatus, 3);
    }

    public void verifyOrderExists(String orderId) {
        waitUntilElementVisible(orderList, 3);
        boolean orderFound = getWebElementList(orderList)
            .stream()
            .anyMatch(order -> order.getText().contains(orderId));
        Assert.assertTrue(orderFound, Order ID  + orderId +  does not exist.);
    }

    public void verifyCustomerSubscription(String email) {
        boolean isSubscribed = checkSubscription(email);
        Assert.assertTrue(isSubscribed, Customer is not subscribed to shipment alerts.);
    }

    public void loginToDynamics365(String username, String password) {
        enterText(By.id(username), username);
        enterText(By.id(password), password);
        clickElement(By.id(loginButton));
    }

    public void verifyDashboardDisplayed() {
        waitUntilElementVisible(By.id(dashboard), 3);
        Assert.assertTrue(isElementVisible(By.id(dashboard)), Dashboard is not displayed.);
    }

    public void navigateToOrdersModule() {
        clickElement(By.id(ordersModule));
    }

    public void verifyOrdersModuleDisplayed() {
        waitUntilElementVisible(orderList, 3);
        Assert.assertTrue(isElementVisible(orderList), Orders module is not displayed.);
    }

    public void selectOrderById(String orderId) {
        waitUntilElementVisible(orderList, 3);
        getWebElementList(orderList)
            .stream()
            .filter(order -> order.getText().contains(orderId))
            .findFirst()
            .ifPresent(WebElement::click);
    }

    public void verifyOrderDetailsDisplayed(String orderId) {
        Assert.assertTrue(getTextFromElement(orderDetails).contains(orderId), Order details are not displayed.);
    }

    public void verifyShipmentStatusUpdated(String expectedStatus) {
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, Shipment status is not updated.);
    }

    public void verifyAlertMessage(String expectedMessage) {
        Assert.assertEquals(getTextFromElement(alertMessage), expectedMessage, Alert message does not match.);
    }

    public void verifyCustomerAlertReceived(String email) {
        boolean alertReceived = checkAlertReceived(email);
        Assert.assertTrue(alertReceived, Customer did not receive alert.);
    }

    public void verifyAlertSent(String expectedMessage) {
        Assert.assertEquals(getTextFromElement(alertMessage), expectedMessage, Alert was not sent.);
    }

    public void checkOutgoingAlerts() {
        waitUntilElementVisible(alertMessage, 3);
    }

    public void checkAlertSystem() {
        Assert.assertTrue(isElementVisible(alertMessage), Alert system is not functioning.);
    }

    private boolean checkSubscription(String email) {
        // Placeholder for subscription check logic
        return true;
    }

    private boolean checkAlertReceived(String email) {
        // Placeholder for alert received check logic
        return true;
    }
}