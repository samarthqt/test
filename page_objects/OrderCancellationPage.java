package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderCancellationPage extends WebReusableComponents {

    protected By txtUserId = By.id("userId");
    protected By btnLogin = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By orderHistorySection = By.id("orderHistorySection");
    protected By orderDetails = By.id("orderDetails");
    protected By cancellationOption = By.id("cancellationOption");
    protected By returnOption = By.id("returnOption");
    protected By cancellationReasonDropdown = By.id("cancellationReason");
    protected By returnReasonDropdown = By.id("returnReason");
    protected By orderStatus = By.id("orderStatus");
    protected By notification = By.id("notification");
    protected By refundDetails = By.id("refundDetails");
    protected By errorMessage = By.id("errorMessage");
    protected By btnLogout = By.id("logoutButton");

    public OrderCancellationPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchLoginPage() {
        driver.get(getAppUrl() + "/login");
        maximizeWindow();
    }

    public void loginWithCredentials(String userId) {
        waitUntilElementVisible(txtUserId, 3);
        enterText(txtUserId, userId);
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyDashboardRedirection() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not displayed.");
    }

    public void verifyDashboardPresence() {
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not present.");
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistorySection, 3);
        clickElement(orderHistorySection);
    }

    public void verifyOrderHistoryDisplay() {
        waitUntilElementVisible(orderHistorySection, 3);
        Assert.assertTrue(isElementDisplayed(orderHistorySection), "Order History section is not displayed.");
    }

    public void verifyOrderHistoryPresence() {
        Assert.assertTrue(isElementDisplayed(orderHistorySection), "Order History section is not present.");
    }

    public void selectOrder(String orderId) {
        By order = By.id(orderId);
        waitUntilElementVisible(order, 3);
        clickElement(order);
    }

    public void verifyOrderOptionsDisplay() {
        waitUntilElementVisible(orderDetails, 3);
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details are not displayed.");
    }

    public void verifyOrderEligibilityForCancellation() {
        Assert.assertTrue(isElementDisplayed(cancellationOption), "Order is not eligible for cancellation.");
    }

    public void cancelOrder() {
        waitUntilElementVisible(cancellationOption, 3);
        clickElement(cancellationOption);
    }

    public void verifyCancellationConfirmation() {
        waitUntilElementVisible(notification, 3);
        Assert.assertTrue(isElementDisplayed(notification), "Cancellation confirmation is not received.");
    }

    public void verifyOrderCancellation() {
        Assert.assertTrue(isElementDisplayed(cancellationOption), "Order is not cancelled.");
    }

    public void selectCancellationReason(String reason) {
        waitUntilElementVisible(cancellationReasonDropdown, 3);
        selectByValue(cancellationReasonDropdown, reason);
    }

    public void verifyCancellationReason(String reason) {
        String selectedReason = getSelectedValue(cancellationReasonDropdown);
        Assert.assertEquals(selectedReason, reason, "Cancellation reason does not match.");
    }

    public void verifyOrderStatus(String status) {
        String currentStatus = getTextFromElement(orderStatus);
        Assert.assertEquals(currentStatus, status, "Order status does not match.");
    }

    public void verifyOrderEligibilityForReturn() {
        Assert.assertTrue(isElementDisplayed(returnOption), "Order is not eligible for return.");
    }

    public void returnOrder() {
        waitUntilElementVisible(returnOption, 3);
        clickElement(returnOption);
    }

    public void verifyReturnConfirmation() {
        waitUntilElementVisible(notification, 3);
        Assert.assertTrue(isElementDisplayed(notification), "Return confirmation is not received.");
    }

    public void verifyOrderReturn() {
        Assert.assertTrue(isElementDisplayed(returnOption), "Order is not returned.");
    }

    public void selectReturnReason(String reason) {
        waitUntilElementVisible(returnReasonDropdown, 3);
        selectByValue(returnReasonDropdown, reason);
    }

    public void verifyReturnReason(String reason) {
        String selectedReason = getSelectedValue(returnReasonDropdown);
        Assert.assertEquals(selectedReason, reason, "Return reason does not match.");
    }

    public void verifyOrderCancellationOrReturn() {
        Assert.assertTrue(isElementDisplayed(notification), "Order is neither cancelled nor returned.");
    }

    public void verifyStatusChangeNotifications() {
        Assert.assertTrue(isElementDisplayed(notification), "Status change notifications are not received.");
    }

    public void verifyRefundProcessing() {
        Assert.assertTrue(isElementDisplayed(refundDetails), "Refund is not processed.");
    }

    public void verifyRefundReceipt() {
        Assert.assertTrue(isElementDisplayed(refundDetails), "Refund is not received.");
    }

    public void verifyRefundDetailsInOrderHistory() {
        String refundInfo = getTextFromElement(refundDetails);
        Assert.assertTrue(refundInfo.contains("Refund"), "Refund details are not displayed.");
    }

    public void attemptInvalidCancellationOrReturn() {
        waitUntilElementVisible(errorMessage, 3);
        clickElement(errorMessage);
    }

    public void verifyErrorMessagesForInvalidRequests() {
        String errorMsg = getTextFromElement(errorMessage);
        Assert.assertTrue(errorMsg.contains("Invalid"), "Error message for invalid request is not displayed.");
    }

    public void verifyCancellationReturnPagePresence() {
        Assert.assertTrue(isElementDisplayed(orderDetails), "Cancellation/Return page is not present.");
    }

    public void navigateBackToDashboard() {
        driver.navigate().back();
    }

    public void logout() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyLogoutRedirection() {
        waitUntilElementVisible(txtUserId, 3);
        Assert.assertTrue(isElementDisplayed(txtUserId), "User is not redirected to the login page.");
    }
}