package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailNotificationPage extends WebReusableComponents {

    protected By orderStatus = By.id("orderStatus");
    protected By emailSentConfirmation = By.id("emailSentConfirmation");
    protected By emailContent = By.id("emailContent");

    public void verifyOrderPlaced(String orderId) {
        // Logic to verify order placement
    }

    public void updateOrderStatus(String status) {
        waitUntilElementVisible(orderStatus, 3);
        selectByValue(orderStatus, status);
    }

    public void verifyEmailSent(String userEmail) {
        waitUntilElementVisible(emailSentConfirmation, 3);
        String confirmation = getTextFromElement(emailSentConfirmation);
        Assert.assertTrue(confirmation.contains(userEmail), "Email not sent to user.");
    }

    public void verifyEmailContainsOrderDetails(String orderDetails) {
        waitUntilElementVisible(emailContent, 3);
        String content = getTextFromElement(emailContent);
        Assert.assertTrue(content.contains(orderDetails), "Order details not found in email.");
    }

    public void verifyEmailContainsStatus(String status) {
        waitUntilElementVisible(emailContent, 3);
        String content = getTextFromElement(emailContent);
        Assert.assertTrue(content.contains(status), "Order status not found in email.");
    }

    public void verifyNoEmailSent(String userEmail) {
        // Logic to verify no email sent
    }

    public void verifyEmailContainsUserInfo(String userName, String userEmail) {
        waitUntilElementVisible(emailContent, 3);
        String content = getTextFromElement(emailContent);
        Assert.assertTrue(content.contains(userName) && content.contains(userEmail), "User info not found in email.");
    }

    public void optOutOfEmailNotifications() {
        // Logic to opt out of email notifications
    }
}