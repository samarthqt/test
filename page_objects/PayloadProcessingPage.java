package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PayloadProcessingPage extends WebReusableComponents {

    // Fields from both classes
    protected By lisbonSystemStatus = By.id("lisbonSystemStatus");
    protected By inboundInterfaceTrigger = By.id("triggerInboundInterface");
    protected By s4hanaStatus = By.id("s4hanaStatus");
    protected By interfaceProcessingStatus = By.id("interfaceProcessingStatus");
    protected By orderStatus = By.id("orderStatus");
    protected By warningsOrErrors = By.id("warningsOrErrors");
    protected By dataFieldValidation = By.id("dataFieldValidation");
    protected By lineItemsStatus = By.id("lineItemsStatus");
    protected By systemPerformance = By.id("systemPerformance");
    protected By duplicateRecords = By.id("duplicateRecords");
    protected By payloadSchemaValidation = By.id("payloadSchemaValidation");
    protected By systemScalability = By.id("systemScalability");
    protected By auditLogs = By.id("auditLogs");
    protected By systemRecovery = By.id("systemRecovery");
    protected By inboundInterfaceStatus = By.id("inboundInterfaceStatus");
    protected By payloadTriggerButton = By.id("triggerPayload");
    protected By processingStatus = By.id("processingStatus");
    protected By performanceMetrics = By.id("performanceMetrics");
    protected By orderData = By.id("orderData");
    protected By logMessages = By.id("logMessages");

    // Methods from both classes
    public void verifyLisbonSystemIsActive() {
        waitUntilElementVisible(lisbonSystemStatus, 5);
        String status = getTextFromElement(lisbonSystemStatus);
        Assert.assertEquals(status, "Active", "Lisbon system is not active.");
    }

    public void triggerInboundInterface(String fieldLengths, String dataVolume) {
        waitUntilElementVisible(inboundInterfaceTrigger, 5);
        clickElement(inboundInterfaceTrigger);
        sendPayload(fieldLengths, dataVolume);
    }

    public void verifyPayloadSentToS4HANA() {
        waitUntilElementVisible(s4hanaStatus, 5);
        String status = getTextFromElement(s4hanaStatus);
        Assert.assertEquals(status, "Payload Sent", "Payload was not successfully sent to S/4HANA.");
    }

    public void verifyInterfaceProcessing() {
        waitUntilElementVisible(interfaceProcessingStatus, 5);
        String status = getTextFromElement(interfaceProcessingStatus);
        Assert.assertEquals(status, "Processed Successfully", "Interface did not process the payload successfully.");
    }

    public void verifyOrderCreatedOrUpdated() {
        waitUntilElementVisible(orderStatus, 5);
        String status = getTextFromElement(orderStatus);
        Assert.assertTrue(status.contains("Order Created") || status.contains("Order Updated"), "Order was not created or updated in S/4HANA.");
    }

    public void verifyNoWarningsOrErrorsLogged() {
        waitUntilElementVisible(warningsOrErrors, 5);
        String status = getTextFromElement(warningsOrErrors);
        Assert.assertEquals(status, "No Warnings or Errors", "Warnings or errors were logged during payload processing.");
    }

    public void verifyDataFieldsMatchPayload() {
        waitUntilElementVisible(dataFieldValidation, 5);
        String status = getTextFromElement(dataFieldValidation);
        Assert.assertEquals(status, "All Fields Match", "Data fields in the order do not match the payload values.");
    }

    public void verifyLineItemsProcessed() {
        waitUntilElementVisible(lineItemsStatus, 5);
        String status = getTextFromElement(lineItemsStatus);
        Assert.assertEquals(status, "All Line Items Processed", "Not all line items were processed successfully.");
    }

    public void verifySystemPerformance() {
        waitUntilElementVisible(systemPerformance, 5);
        String status = getTextFromElement(systemPerformance);
        Assert.assertEquals(status, "Performance Within Threshold", "System performance is not within acceptable thresholds.");
    }

    public void verifyNoDuplicateOrMissingRecords() {
        waitUntilElementVisible(duplicateRecords, 5);
        String status = getTextFromElement(duplicateRecords);
        Assert.assertEquals(status, "No Duplicates or Missing Records", "Duplicate or missing records were created during payload processing.");
    }

    public void verifyPayloadSchemaAndFormat() {
        waitUntilElementVisible(payloadSchemaValidation, 5);
        String status = getTextFromElement(payloadSchemaValidation);
        Assert.assertEquals(status, "Schema Valid", "Payload does not adhere to the defined schema and format.");
    }

    public void verifySystemScalability() {
        waitUntilElementVisible(systemScalability, 5);
        String status = getTextFromElement(systemScalability);
        Assert.assertEquals(status, "Scalable", "System did not demonstrate scalability.");
    }

    public void verifyAuditLogsGenerated() {
        waitUntilElementVisible(auditLogs, 5);
        String status = getTextFromElement(auditLogs);
        Assert.assertEquals(status, "Audit Logs Generated", "Audit logs were not generated with detailed information.");
    }

    public void verifySystemRecovery() {
        waitUntilElementVisible(systemRecovery, 5);
        String status = getTextFromElement(systemRecovery);
        Assert.assertEquals(status, "Recovered Successfully", "System did not recover seamlessly from transient errors.");
    }

    public void verifyInboundInterfaceOperational() {
        waitUntilElementVisible(inboundInterfaceStatus, 5);
        String status = getTextFromElement(inboundInterfaceStatus);
        Assert.assertEquals(status, "Operational", "Inbound interface is not operational.");
    }

    public void verifyLisbonSystemActive() {
        waitUntilElementVisible(lisbonSystemStatus, 5);
        String status = getTextFromElement(lisbonSystemStatus);
        Assert.assertEquals(status, "Active", "Lisbon system is not active.");
    }

    public void triggerInboundInterfaceWithPayload(String fieldLength, String lineItems) {
        waitUntilElementVisible(payloadTriggerButton, 5);
        clickElement(payloadTriggerButton);
        sendPayload(fieldLength, lineItems);
    }

    public void verifyPayloadProcessedWithoutErrors() {
        waitUntilElementVisible(processingStatus, 5);
        String status = getTextFromElement(processingStatus);
        Assert.assertEquals(status, "Processed Successfully", "Payload was not processed successfully.");
    }

    public void verifyInterfacePerformance() {
        waitUntilElementVisible(performanceMetrics, 5);
        String performance = getTextFromElement(performanceMetrics);
        Assert.assertTrue(performance.contains("Within Threshold"), "Interface performance degraded.");
    }

    public void verifyOrderCreatedOrUpdated() {
        waitUntilElementVisible(orderData, 5);
        String orderStatus = getTextFromElement(orderData);
        Assert.assertTrue(orderStatus.contains("Order Created") || orderStatus.contains("Order Updated"), "Order was not created or updated correctly.");
    }

    public void verifyNoWarningsOrErrorsLogged() {
        waitUntilElementVisible(logMessages, 5);
        String logs = getTextFromElement(logMessages);
        Assert.assertFalse(logs.contains("Error") || logs.contains("Warning"), "Warnings or errors were logged during processing.");
    }

    public void verifyOrderDataMatchesPayload() {
        waitUntilElementVisible(orderData, 5);
        String orderDetails = getTextFromElement(orderData);
        Assert.assertTrue(orderDetails.contains("Data Matched"), "Order data does not match payload values.");
    }

    public void verifyLineItemsProcessedWithoutSplitting() {
        waitUntilElementVisible(lineItemsStatus, 5);
        String lineItems = getTextFromElement(lineItemsStatus);
        Assert.assertEquals(lineItems, "All Line Items Processed", "Line items were split or truncated.");
    }

    public void verifySystemPerformanceThresholds() {
        waitUntilElementVisible(performanceMetrics, 5);
        String performance = getTextFromElement(performanceMetrics);
        Assert.assertTrue(performance.contains("Acceptable"), "System performance is not within acceptable thresholds.");
    }

    private void sendPayload(String fieldLengths, String dataVolume) {
        System.out.println("Payload sent with field lengths: " + fieldLengths + " and data volume: " + dataVolume);
    }

    private void sendPayload(String fieldLength, String lineItems) {
        System.out.println("Payload triggered with field length: " + fieldLength + " and line items: " + lineItems);
    }
}
