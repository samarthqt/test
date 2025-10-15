package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SMTPConfigurationPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By periodicBillingSection = By.id("periodicBillingSection");
    protected By errorMessage = By.id("errorMessage");

    public void loginToSystem(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        waitUntilElementVisible(By.id("dashboard"), 5);
    }

    public void assertLoginSuccess() {
        Assert.assertTrue(isElementVisible(By.id("dashboard")), "Login was not successful.");
    }

    public void verifyBatchExists(int batchSize) {
        Assert.assertTrue(batchSize > 1000, "Batch size is less than expected.");
    }

    public void navigateToPeriodicBillingSection() {
        clickElement(periodicBillingSection);
    }

    public void assertPeriodicBillingSectionDisplayed() {
        Assert.assertTrue(isElementVisible(periodicBillingSection), "Periodic Billing Section is not displayed.");
    }

    public void selectBatchForProcessing() {
        clickElement(By.id("selectBatch"));
    }

    public void assertBatchSelected() {
        Assert.assertTrue(isElementVisible(By.id("batchSelected")), "Batch was not successfully selected.");
    }

    public void verifyOutputTypeConfigured(String outputType) {
        Assert.assertEquals(outputType, "ZPB1", "Output type is not configured correctly.");
    }

    public void triggerPeriodicBillingWorkflow(String outputType) {
        selectByValue(By.id("outputTypeDropdown"), outputType);
        clickElement(By.id("triggerWorkflow"));
    }

    public void assertWorkflowTriggered(String outputType) {
        Assert.assertTrue(isElementVisible(By.id("workflowTriggered")), "Workflow was not triggered successfully.");
    }

    public void monitorEmailRoutingProcess() {
        waitUntilElementVisible(By.id("emailRouting"), 5);
    }

    public void assertErrorMessageDisplayed(String errorMessageText) {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, errorMessageText, "Error message does not match.");
    }

    public void assertOutputsNotSent() {
        Assert.assertFalse(isElementVisible(By.id("emailSent")), "Outputs were sent via email.");
    }

    public void assertLogsContainErrorDetails() {
        Assert.assertTrue(isElementVisible(By.id("errorLogs")), "Error logs do not contain detailed messages.");
    }

    public void assertNoOutputsGenerated() {
        Assert.assertFalse(isElementVisible(By.id("outputsGenerated")), "Outputs were generated during the failed attempt.");
    }

    public void assertSystemStability() {
        Assert.assertTrue(isElementVisible(By.id("systemStable")), "System is not stable.");
    }

    public void assertErrorMessageContainsInstructions(String instructions) {
        String actualInstructions = getTextFromElement(By.id("errorInstructions"));
        Assert.assertEquals(actualInstructions, instructions, "Error message instructions do not match.");
    }

    public void assertEmailRoutingNotTriggered() {
        Assert.assertFalse(isElementVisible(By.id("emailRoutingTriggered")), "Email routing process was triggered.");
    }

    public void reconfigureSMTPSettings() {
        clickElement(By.id("smtpSettings"));
        enterText(By.id("smtpServer"), "smtp.example.com");
        enterText(By.id("smtpPort"), "25");
        clickElement(By.id("saveSettings"));
    }

    public void retryPeriodicBillingWorkflow() {
        clickElement(By.id("retryWorkflow"));
    }

    public void assertWorkflowSuccess() {
        Assert.assertTrue(isElementVisible(By.id("workflowSuccess")), "Workflow did not proceed successfully.");
    }
}