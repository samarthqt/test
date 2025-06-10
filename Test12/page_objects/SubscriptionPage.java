package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class SubscriptionPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By subscriptionServicesLink = By.id("subscriptionServicesLink");
    protected By productSelection = By.id("productSelection");
    protected By deliveryFrequencyDropdown = By.id("deliveryFrequencyDropdown");
    protected By subscribeButton = By.id("subscribeButton");
    protected By subscriptionSuccessMessage = By.id("subscriptionSuccessMessage");
    protected By notificationMessage = By.id("notificationMessage");
    protected By subscriptionManagementLink = By.id("subscriptionManagementLink");
    protected By subscriptionList = By.cssSelector(".subscription-list");
    protected By cancelSubscriptionButton = By.cssSelector(".cancel-subscription");
    protected By modifySubscriptionButton = By.cssSelector(".modify-subscription");
    protected By updateSuccessMessage = By.id("updateSuccessMessage");

    public SubscriptionPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToAccount() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void navigateToSubscriptionServices() {
        waitUntilElementVisible(subscriptionServicesLink, 3);
        clickElement(subscriptionServicesLink);
    }

    public void selectProductForSubscription() {
        waitUntilElementVisible(productSelection, 3);
        clickElement(productSelection);
    }

    public void chooseDeliveryFrequency() {
        waitUntilElementVisible(deliveryFrequencyDropdown, 3);
        selectByValue(deliveryFrequencyDropdown, "weekly");
    }

    public void verifySubscriptionSuccess() {
        waitUntilElementVisible(subscriptionSuccessMessage, 3);
        String actualMessage = getTextFromElement(subscriptionSuccessMessage);
        Assert.assertEquals(actualMessage, "Subscription successful.", "Subscription failed.");
    }

    public void verifyUserSubscription() {
        waitUntilElementVisible(subscriptionList, 3);
        boolean subscriptionFound = getWebElementList(subscriptionList)
            .stream()
            .anyMatch(item -> item.getText().contains("Active"));
        Assert.assertTrue(subscriptionFound, "User is not subscribed.");
    }

    public void checkUpcomingDeliveryDate() {
        // Logic to check upcoming delivery date
        // Example: Assert.assertTrue(condition, "Upcoming delivery date not found.");
    }

    public void verifyNotificationReceived() {
        waitUntilElementVisible(notificationMessage, 3);
        String actualMessage = getTextFromElement(notificationMessage);
        Assert.assertEquals(actualMessage, "Upcoming delivery notification.", "Notification not received.");
    }

    public void navigateToSubscriptionManagement() {
        waitUntilElementVisible(subscriptionManagementLink, 3);
        clickElement(subscriptionManagementLink);
    }

    public void verifySubscriptionManagementAccess() {
        waitUntilElementVisible(subscriptionList, 3);
        Assert.assertTrue(isElementVisible(subscriptionList), "Cannot access subscription management.");
    }

    public void selectSubscriptionToCancel() {
        waitUntilElementVisible(cancelSubscriptionButton, 3);
        clickElement(cancelSubscriptionButton);
    }

    public void verifySubscriptionCancellation() {
        waitUntilElementVisible(subscriptionSuccessMessage, 3);
        String actualMessage = getTextFromElement(subscriptionSuccessMessage);
        Assert.assertEquals(actualMessage, "Subscription canceled.", "Cancellation failed.");
    }

    public void selectSubscriptionToModify() {
        waitUntilElementVisible(modifySubscriptionButton, 3);
        clickElement(modifySubscriptionButton);
    }

    public void modifySubscriptionDetails() {
        waitUntilElementVisible(deliveryFrequencyDropdown, 3);
        selectByValue(deliveryFrequencyDropdown, "monthly");
    }

    public void verifySubscriptionUpdate() {
        waitUntilElementVisible(updateSuccessMessage, 3);
        String actualMessage = getTextFromElement(updateSuccessMessage);
        Assert.assertEquals(actualMessage, "Subscription updated.", "Update failed.");
    }
}