package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EligibilityPage extends WebReusableComponents {

    protected By orderHistoryLink = By.id("orderHistory");
    protected By orderList = By.cssSelector(".order-item");
    protected By orderDetailsSection = By.id("orderDetails");
    protected By cancellationReturnOptions = By.id("cancellationReturnOptions");
    protected By returnButton = By.id("initiateReturn");
    protected By eligibilityStatus = By.id("eligibilityStatus");
    protected By policyDetails = By.id("policyDetails");

    public EligibilityPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToAccount(String orderID) {
        // Logic to log into the account using the order ID
        // Example: Navigate to login page, enter credentials, submit form
        // Assert login success
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistoryLink, 3);
        clickElement(orderHistoryLink);
    }

    public void selectOrder(String orderID) {
        By orderLocator = By.xpath("//div[@data-order-id='" + orderID + "']");
        waitUntilElementVisible(orderLocator, 3);
        clickElement(orderLocator);
    }

    public void locateCancellationAndReturnOptions() {
        waitUntilElementVisible(cancellationReturnOptions, 3);
        WebElement options = driver.findElement(cancellationReturnOptions);
        Assert.assertTrue(options.isDisplayed(), "Cancellation and return options are not visible.");
    }

    public void initiateReturn() {
        waitUntilElementVisible(returnButton, 3);
        clickElement(returnButton);
    }

    public void checkMerchantsPolicy() {
        waitUntilElementVisible(policyDetails, 3);
        String policy = getTextFromElement(policyDetails);
        Assert.assertNotNull(policy, "Merchant's policy details are not displayed.");
    }

    public void displayEligibilityStatus() {
        waitUntilElementVisible(eligibilityStatus, 3);
        String status = getTextFromElement(eligibilityStatus);
        Assert.assertNotNull(status, "Eligibility status is not displayed.");
    }

    public void allowReturnIfEligible() {
        displayEligibilityStatus();
        String status = getTextFromElement(eligibilityStatus);
        if ("Eligible".equalsIgnoreCase(status)) {
            initiateReturn();
        } else {
            denyReturnIfIneligible();
        }
    }

    public void denyReturnIfIneligible() {
        String status = getTextFromElement(eligibilityStatus);
        Assert.assertFalse("Eligible".equalsIgnoreCase(status), "Return should be denied as the status is not eligible.");
    }

    public void promptPolicyDetails() {
        waitUntilElementVisible(policyDetails, 3);
        String details = getTextFromElement(policyDetails);
        Assert.assertNotNull(details, "Policy details are not displayed.");
    }

    public void logEligibilityCheck() {
        // Logic to log eligibility check
        // Example: Write to a log file or database
    }

    public void notifyUserEligibilityStatus() {
        displayEligibilityStatus();
        String status = getTextFromElement(eligibilityStatus);
        // Logic to notify user, e.g., send an email or display a message
    }

    public void updateOrderStatus() {
        // Logic to update order status based on eligibility
        // Example: Change status in database or application
    }

    public void verifyConsistencyAcrossDevices() {
        // Logic to verify consistency across devices
        // Example: Check UI elements on different screen sizes
    }

    public void allowCancellationIfEligible() {
        displayEligibilityStatus();
        String status = getTextFromElement(eligibilityStatus);
        if ("Eligible".equalsIgnoreCase(status)) {
            // Logic to allow cancellation
        } else {
            // Logic to deny cancellation
        }
    }

    public void updateOptionsBasedOnPolicyChanges() {
        checkMerchantsPolicy();
        // Logic to update options based on policy changes
        // Example: Refresh UI elements or update database records
    }
}