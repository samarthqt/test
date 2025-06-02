package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CancellationPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By orderHistoryLink = By.id("orderHistoryLink");
    protected By orderDetailsSection = By.id("orderDetailsSection");
    protected By cancelOrderButton = By.id("cancelOrderButton");
    protected By cancellationDialog = By.id("cancellationDialog");
    protected By confirmCancellationButton = By.id("confirmCancellationButton");
    protected By refundStatusSection = By.id("refundStatusSection");
    protected By logoutButton = By.id("logoutButton");

    public CancellationPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginWithValidCredentials() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyOrderReadyForShipping(String orderID) {
        WebElement orderElement = driver.findElement(By.xpath("//div[@data-order-id='" + orderID + "']"));
        Assert.assertTrue(orderElement.isDisplayed(), "Order is not ready for shipping.");
    }

    public void loginToSystem() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifySuccessfulLogin() {
        boolean isLoggedIn = elementVisible(By.id("userDashboard"));
        Assert.assertTrue(isLoggedIn, "User login failed.");
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistoryLink, 3);
        clickElement(orderHistoryLink);
    }

    public void verifyOrderHistoryDisplayed() {
        waitUntilElementVisible(By.cssSelector(".order-item"), 3);
        Assert.assertFalse(getWebElementList(By.cssSelector(".order-item")).isEmpty(), "No past orders are displayed.");
    }

    public void selectOrder(String orderID) {
        By orderLocator = By.xpath("//div[@data-order-id='" + orderID + "']");
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void verifyOrderDetailsDisplayed(String orderID) {
        WebElement orderDetails = driver.findElement(By.xpath("//div[@data-order-id='" + orderID + "']"));
        Assert.assertTrue(orderDetails.isDisplayed(), "Order details are not displayed.");
    }

    public void verifyShippingStatus(String expectedStatus) {
        String actualStatus = getTextFromElement(By.id("shippingStatus"));
        Assert.assertEquals(actualStatus, expectedStatus, "Shipping status does not match.");
    }

    public void clickCancelOrderButton() {
        waitUntilElementVisible(cancelOrderButton, 3);
        clickElement(cancelOrderButton);
    }

    public void verifyCancellationDialogAppears() {
        waitUntilElementVisible(cancellationDialog, 3);
        Assert.assertTrue(elementVisible(cancellationDialog), "Cancellation dialog did not appear.");
    }

    public void confirmCancellation() {
        waitUntilElementVisible(confirmCancellationButton, 3);
        clickElement(confirmCancellationButton);
    }

    public void verifyOrderStatusChangedToCancelled() {
        String status = getTextFromElement(By.id("orderStatus"));
        Assert.assertEquals(status, "Cancelled", "Order status did not change to Cancelled.");
    }

    public void verifyCancellationEmailReceived() {
        boolean emailReceived = checkEmailReceived("Cancellation Notification");
        Assert.assertTrue(emailReceived, "Cancellation email not received.");
    }

    public void checkRefundInitiationStatus() {
        navigateToRefundStatus();
    }

    public void verifyRefundProcessInitiated() {
        String refundStatus = getTextFromElement(By.id("refundStatus"));
        Assert.assertEquals(refundStatus, "Initiated", "Refund process not initiated.");
    }

    public void navigateToRefundStatus() {
        waitUntilElementVisible(refundStatusSection, 3);
        clickElement(refundStatusSection);
    }

    public void verifyRefundStatusDisplayed(String expectedStatus) {
        String actualStatus = getTextFromElement(By.id("refundStatus"));
        Assert.assertEquals(actualStatus, expectedStatus, "Refund status does not match.");
    }

    public void logoutFromUserAccount() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifySuccessfulLogout() {
        boolean isLoggedOut = elementVisible(By.id("loginPage"));
        Assert.assertTrue(isLoggedOut, "User logout failed.");
    }

    public void attemptToTrackCancelledOrder() {
        navigateToOrderTracking();
    }

    public void verifyNoTrackingAvailableForCancelledOrder() {
        String trackingMessage = getTextFromElement(By.id("trackingMessage"));
        Assert.assertEquals(trackingMessage, "Order Cancelled, no tracking available", "Tracking message does not match.");
    }

    public void checkOrderStatusInDatabase() {
        String dbStatus = getOrderStatusFromDatabase("12345");
        Assert.assertEquals(dbStatus, "Cancelled", "Database order status does not match.");
    }

    public void verifyDatabaseOrderStatusCancelled() {
        String dbStatus = getOrderStatusFromDatabase("12345");
        Assert.assertEquals(dbStatus, "Cancelled", "Database order status does not match.");
    }

    public void verifySystemLogsForCancellationRequest() {
        boolean logEntryExists = checkLogEntry("Cancellation Request");
        Assert.assertTrue(logEntryExists, "Log entry for cancellation request not found.");
    }

    public void verifyLogsContainCancellationEntry() {
        boolean logEntryExists = checkLogEntry("Cancellation Request");
        Assert.assertTrue(logEntryExists, "Log entry for cancellation request not found.");
    }

    public void checkSystemPerformanceUnderCancellationLoad() {
        boolean performanceOptimal = checkSystemPerformance("Cancellation Load");
        Assert.assertTrue(performanceOptimal, "System performance not optimal.");
    }

    public void verifyOptimalSystemPerformance() {
        boolean performanceOptimal = checkSystemPerformance("Cancellation Load");
        Assert.assertTrue(performanceOptimal, "System performance not optimal.");
    }

    public void reviewUserInterfaceForCancellation() {
        boolean uiUserFriendly = checkUserInterface("Cancellation Process");
        Assert.assertTrue(uiUserFriendly, "UI is not user-friendly.");
    }

    public void verifyUserFriendlyUI() {
        boolean uiUserFriendly = checkUserInterface("Cancellation Process");
        Assert.assertTrue(uiUserFriendly, "UI is not user-friendly.");
    }

    public void ensureCustomerSupportAvailability() {
        boolean supportAvailable = checkCustomerSupportAvailability();
        Assert.assertTrue(supportAvailable, "Customer support not available.");
    }

    public void verifyCustomerSupportResponsiveness() {
        boolean supportResponsive = checkCustomerSupportResponsiveness();
        Assert.assertTrue(supportResponsive, "Customer support not responsive.");
    }
}