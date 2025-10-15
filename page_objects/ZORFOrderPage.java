package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ZORFOrderPage extends WebReusableComponents {

    protected By payloadStatusField = By.id("payloadStatus");
    protected By interfaceProcessingMonitor = By.id("interfaceMonitor");
    protected By zorOrderReference = By.id("zorOrderReference");
    protected By salesAreaField = By.id("salesArea");
    protected By zorOrderStatus = By.id("zorOrderStatus");
    protected By systemLogs = By.id("systemLogs");
    protected By mandatoryFields = By.id("mandatoryFields");
    protected By integrationStatus = By.id("integrationStatus");
    protected By orderManagementReports = By.id("orderReports");
    protected By financialPostings = By.id("financialPostings");
    protected By auditLogs = By.id("auditLogs");

    public void sendPayloadToS4HANA(String payloadStatus) {
        waitUntilElementVisible(payloadStatusField, 3);
        enterText(payloadStatusField, payloadStatus);
        clickElement(By.id("sendPayload"));
    }

    public void monitorInterfaceProcessing() {
        waitUntilElementVisible(interfaceProcessingMonitor, 3);
        clickElement(interfaceProcessingMonitor);
    }

    public void verifyInterfaceProcessingSuccess() {
        String status = getTextFromElement(By.id("interfaceStatus"));
        Assert.assertEquals(status, "Success", "Interface processing failed.");
    }

    public void verifyZORFOrderCreation() {
        boolean isOrderCreated = isElementVisible(By.id("zorfOrder"));
        Assert.assertTrue(isOrderCreated, "ZORF order was not created.");
    }

    public void verifyZORFOrderReferencesOriginalZOROrder() {
        String reference = getTextFromElement(zorOrderReference);
        Assert.assertNotNull(reference, "ZORF order does not reference the original ZOR order.");
    }

    public void verifyZORFOrderSalesArea(String salesArea) {
        String actualSalesArea = getTextFromElement(salesAreaField);
        Assert.assertEquals(actualSalesArea, salesArea, "Sales Area does not match.");
    }

    public void verifyOriginalZOROrderStatusUpdate() {
        String status = getTextFromElement(zorOrderStatus);
        Assert.assertEquals(status, "Cancelled", "Original ZOR order status was not updated.");
    }

    public void verifySystemLogs() {
        String logs = getTextFromElement(systemLogs);
        Assert.assertFalse(logs.contains("Error"), "System logs contain errors.");
        Assert.assertFalse(logs.contains("Warning"), "System logs contain warnings.");
    }

    public void verifyMandatoryFieldsInZORFOrder() {
        boolean areFieldsPresent = isElementVisible(mandatoryFields);
        Assert.assertTrue(areFieldsPresent, "Mandatory fields are missing in ZORF order.");
    }

    public void verifyIntegrationBetweenLisbonAndS4HANA() {
        String integrationStatus = getTextFromElement(this.integrationStatus);
        Assert.assertEquals(integrationStatus, "Functional", "Integration between Lisbon and S/4HANA failed.");
    }

    public void verifyZORFOrderVisibilityInReports() {
        boolean isVisible = isElementVisible(orderManagementReports);
        Assert.assertTrue(isVisible, "ZORF order is not visible in reports.");
    }

    public void verifyFinancialPostingsForZORFOrder() {
        String postingsStatus = getTextFromElement(financialPostings);
        Assert.assertEquals(postingsStatus, "Accurate", "Financial postings are not accurate.");
    }

    public void verifyAuditLogsForOrderCreation() {
        boolean isTraceable = isElementVisible(auditLogs);
        Assert.assertTrue(isTraceable, "Audit logs do not provide complete traceability.");
    }
}