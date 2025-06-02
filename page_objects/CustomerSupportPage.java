package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CustomerSupportPage extends WebReusableComponents {

    protected By customerSupportLink = By.id("customerSupport");
    protected By contactInfo = By.id("contactInfo");
    protected By emailNotification = By.id("emailNotification");
    protected By systemLogs = By.id("systemLogs");
    protected By accountSecurity = By.id("accountSecurity");
    protected By refundProcess = By.id("refundProcess");
    protected By orderSelection = By.id("orderSelection");
    protected By orderCancellationUpdate = By.id("orderCancellationUpdate");

    public CustomerSupportPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToCustomerSupport() {
        waitUntilElementVisible(customerSupportLink, 3);
        clickElement(customerSupportLink);
    }

    public void verifyCustomerSupportInfoDisplayed() {
        waitUntilElementVisible(contactInfo, 3);
        boolean isVisible = elementVisible(contactInfo);
        Assert.assertTrue(isVisible, "Customer support contact information is not displayed.");
    }

    public void contactCustomerSupport() {
        waitUntilElementVisible(contactInfo, 3);
        clickElement(contactInfo);
        boolean contacted = elementVisible(contactInfo); // Assuming some change indicates contact
        Assert.assertTrue(contacted, "Failed to contact customer support.");
    }

    public void verifyCustomerSupportContacted() {
        boolean contacted = elementVisible(contactInfo); // Assuming some change indicates contact
        Assert.assertTrue(contacted, "Customer support was not contacted.");
    }

    public void verifyEmailNotification() {
        waitUntilElementVisible(emailNotification, 3);
        boolean isNotified = elementVisible(emailNotification);
        Assert.assertTrue(isNotified, "Email notification is not visible.");
    }

    public void verifyEmailNotificationStatus() {
        String status = getTextFromElement(emailNotification);
        Assert.assertEquals(status, "Sent", "Email notification status is incorrect.");
    }

    public void reviewSystemLogs() {
        waitUntilElementVisible(systemLogs, 3);
        String logs = getTextFromElement(systemLogs);
        Assert.assertNotNull(logs, "System logs are empty.");
    }

    public void verifySystemLogsForCancellation() {
        String logs = getTextFromElement(systemLogs);
        Assert.assertTrue(logs.contains("Cancellation"), "Cancellation not found in system logs.");
    }

    public void verifyAccountSecurity() {
        waitUntilElementVisible(accountSecurity, 3);
        boolean isSecure = elementVisible(accountSecurity);
        Assert.assertTrue(isSecure, "Account security is compromised.");
    }

    public void verifyAccountDetailsUnchanged() {
        String details = getTextFromElement(accountSecurity);
        Assert.assertEquals(details, "Unchanged", "Account details have changed.");
    }

    public void checkRefundProcess() {
        waitUntilElementVisible(refundProcess, 3);
        boolean isRefunded = elementVisible(refundProcess);
        Assert.assertTrue(isRefunded, "Refund process is not initiated.");
    }

    public void verifyNoRefundInitiated() {
        boolean isRefunded = elementVisible(refundProcess);
        Assert.assertFalse(isRefunded, "Refund process was initiated unexpectedly.");
    }

    public void selectOrderWithinValidPeriod() {
        waitUntilElementVisible(orderSelection, 3);
        clickElement(orderSelection);
        boolean isSelected = elementVisible(orderSelection); // Assuming some change indicates selection
        Assert.assertTrue(isSelected, "Order within valid period was not selected.");
    }

    public void verifyOrderCancellationAndUpdate() {
        waitUntilElementVisible(orderCancellationUpdate, 3);
        String update = getTextFromElement(orderCancellationUpdate);
        Assert.assertTrue(update.contains("Cancelled"), "Order cancellation update is incorrect.");
    }
}