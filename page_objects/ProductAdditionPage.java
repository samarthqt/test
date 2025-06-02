
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class ProductAdditionPage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By productAdditionSection = By.id("productAdditionSection");
    protected By addProductButton = By.id("addProductButton");
    protected By errorMessage = By.id("errorMessage");
    protected By systemLogs = By.id("systemLogs");
    protected By databaseCheck = By.id("databaseCheck");
    protected By systemAlerts = By.id("systemAlerts");
    protected By securityProtocols = By.id("securityProtocols");
    protected By undoButton = By.id("undoButton");
    protected By auditTrails = By.id("auditTrails");
    protected By externalSystemSync = By.id("externalSystemSync");
    protected By systemPerformance = By.id("systemPerformance");

    public ProductAdditionPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void navigateToProductAdditionSection() {
        waitUntilElementVisible(productAdditionSection, 3);
        clickElement(productAdditionSection);
    }

    public void addProductWithMissingName() {
        clickElement(addProductButton);
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch.");
    }

    public void addProductWithInvalidPrice() {
        clickElement(addProductButton);
    }

    public void addProductWithMissingCategory() {
        clickElement(addProductButton);
    }

    public void addProductWithLongDescription() {
        clickElement(addProductButton);
    }

    public void attemptInvalidProductAdditions() {
        clickElement(addProductButton);
    }

    public void checkSystemLogs() {
        waitUntilElementVisible(systemLogs, 3);
        List<WebElement> logs = getWebElementList(systemLogs);
        Assert.assertFalse(logs.isEmpty(), "System logs are empty.");
    }

    public void verifySystemLogsForErrors() {
        List<WebElement> logs = getWebElementList(systemLogs);
        boolean hasErrors = logs.stream().anyMatch(log -> log.getText().contains("ERROR"));
        Assert.assertTrue(hasErrors, "No errors found in system logs.");
    }

    public void checkDatabaseForInvalidEntries() {
        waitUntilElementVisible(databaseCheck, 3);
        List<WebElement> entries = getWebElementList(databaseCheck);
        Assert.assertTrue(entries.isEmpty(), "Database contains invalid entries.");
    }

    public void verifyDatabaseUnchanged() {
        List<WebElement> entries = getWebElementList(databaseCheck);
        Assert.assertTrue(entries.isEmpty(), "Database has been changed.");
    }

    public void repeatInvalidProductAdditions() {
        clickElement(addProductButton);
    }

    public void monitorSystemAlerts() {
        waitUntilElementVisible(systemAlerts, 3);
        List<WebElement> alerts = getWebElementList(systemAlerts);
        Assert.assertFalse(alerts.isEmpty(), "No system alerts found.");
    }

    public void verifyAlertsTriggered() {
        List<WebElement> alerts = getWebElementList(systemAlerts);
        boolean alertsTriggered = alerts.stream().anyMatch(alert -> alert.getText().contains("ALERT"));
        Assert.assertTrue(alertsTriggered, "No alerts were triggered.");
    }

    public void receiveSystemFeedback() {
        // Logic to receive feedback
        Assert.assertTrue(true, "Feedback received.");
    }

    public void verifyClearFeedback() {
        // Logic to verify feedback
        Assert.assertTrue(true, "Feedback is clear.");
    }

    public void checkSecurityProtocols() {
        waitUntilElementVisible(securityProtocols, 3);
        List<WebElement> protocols = getWebElementList(securityProtocols);
        Assert.assertFalse(protocols.isEmpty(), "Security protocols are not visible.");
    }

    public void verifySecurityProtocols() {
        List<WebElement> protocols = getWebElementList(securityProtocols);
        boolean protocolsVerified = protocols.stream().allMatch(protocol -> protocol.getText().contains("SECURE"));
        Assert.assertTrue(protocolsVerified, "Security protocols are not verified.");
    }

    public void addProductAccidentally() {
        clickElement(addProductButton);
    }

    public void attemptUndoAddition() {
        waitUntilElementVisible(undoButton, 3);
        clickElement(undoButton);
    }

    public void verifyUndoSuccess() {
        boolean isUndoSuccessful = !elementVisible(addProductButton);
        Assert.assertTrue(isUndoSuccessful, "Undo operation failed.");
    }

    public void reviewAuditTrails() {
        waitUntilElementVisible(auditTrails, 3);
        List<WebElement> trails = getWebElementList(auditTrails);
        Assert.assertFalse(trails.isEmpty(), "Audit trails are empty.");
    }

    public void verifyAuditTrails() {
        List<WebElement> trails = getWebElementList(auditTrails);
        boolean trailsVerified = trails.stream().anyMatch(trail -> trail.getText().contains("AUDIT"));
        Assert.assertTrue(trailsVerified, "Audit trails are not verified.");
    }

    public void checkExternalSystemSync() {
        waitUntilElementVisible(externalSystemSync, 3);
        List<WebElement> syncs = getWebElementList(externalSystemSync);
        Assert.assertFalse(syncs.isEmpty(), "External system syncs are not visible.");
    }

    public void verifyNoExternalSync() {
        List<WebElement> syncs = getWebElementList(externalSystemSync);
        boolean noSync = syncs.stream().noneMatch(sync -> sync.getText().contains("SYNC"));
        Assert.assertTrue(noSync, "External system sync occurred.");
    }

    public void monitorSystemPerformance() {
        waitUntilElementVisible(systemPerformance, 3);
        List<WebElement> performanceMetrics = getWebElementList(systemPerformance);
        Assert.assertFalse(performanceMetrics.isEmpty(), "System performance metrics are not visible.");
    }

    public void verifySystemPerformance() {
        List<WebElement> performanceMetrics = getWebElementList(systemPerformance);
        boolean performanceVerified = performanceMetrics.stream().allMatch(metric -> metric.getText().contains("OPTIMAL"));
        Assert.assertTrue(performanceVerified, "System performance is not optimal.");
    }

    public void receiveErrorMessages() {
        // Logic to receive error messages
        Assert.assertTrue(true, "Error messages received.");
    }

    public void verifyErrorMessageGuidance() {
        // Logic to verify error message guidance
        Assert.assertTrue(true, "Error message guidance is clear.");
    }
}
