package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderCreationPage extends WebReusableComponents {

    protected By inboundInterfaceTrigger = By.id("triggerInboundInterface");
    protected By payloadValidation = By.id("validatePayloadFields");
    protected By payloadProcessing = By.id("processPayload");
    protected By orderCreationVerification = By.id("verifyOrderCreation");
    protected By salesAreaAssignmentVerification = By.id("verifySalesAreaAssignment");
    protected By orderDetailsVerification = By.id("verifyOrderDetails");
    protected By uniqueOrderNumberVerification = By.id("verifyUniqueOrderNumber");
    protected By orderEventLogVerification = By.id("verifyOrderCreationEventLog");
    protected By interfaceLogsVerification = By.id("verifyInterfaceLogs");
    protected By orderFormatVerification = By.id("verifyOrderFormat");
    protected By acknowledgmentVerification = By.id("verifyAcknowledgmentSent");
    protected By performanceEfficiencyVerification = By.id("verifyPerformanceEfficiency");

    public void triggerInboundInterface(String payloadSize, String orderId) {
        waitUntilElementVisible(inboundInterfaceTrigger, 3);
        clickElement(inboundInterfaceTrigger);
        Assert.assertTrue(payloadSize.equals("Maximum allowable size"), "Payload size is not maximum allowable.");
        Assert.assertTrue(orderId.matches("[a-f0-9\-]{36}"), "Order ID format is invalid.");
    }

    public void validatePayloadFields(String salesArea) {
        waitUntilElementVisible(payloadValidation, 3);
        clickElement(payloadValidation);
        Assert.assertTrue(salesArea.matches("\d{4}/\d{2}/\d{2}"), "Sales Area format is invalid.");
    }

    public void processPayload() {
        waitUntilElementVisible(payloadProcessing, 3);
        clickElement(payloadProcessing);
    }

    public void verifyOrderCreation() {
        waitUntilElementVisible(orderCreationVerification, 3);
        Assert.assertTrue(getTextFromElement(orderCreationVerification).contains("Order Created"), "Order creation failed.");
    }

    public void verifySalesAreaAssignment(String salesArea) {
        waitUntilElementVisible(salesAreaAssignmentVerification, 3);
        Assert.assertEquals(getTextFromElement(salesAreaAssignmentVerification), salesArea, "Sales Area assignment is incorrect.");
    }

    public void verifyOrderDetails() {
        waitUntilElementVisible(orderDetailsVerification, 3);
        Assert.assertTrue(getTextFromElement(orderDetailsVerification).contains("Order Details Verified"), "Order details do not match payload.");
    }

    public void verifyUniqueOrderNumber() {
        waitUntilElementVisible(uniqueOrderNumberVerification, 3);
        Assert.assertTrue(getTextFromElement(uniqueOrderNumberVerification).matches("\d+"), "Unique order number generation failed.");
    }

    public void verifyOrderCreationEventLog() {
        waitUntilElementVisible(orderEventLogVerification, 3);
        Assert.assertTrue(getTextFromElement(orderEventLogVerification).contains("Event Logged"), "Order creation event logging failed.");
    }

    public void verifyInterfaceLogs() {
        waitUntilElementVisible(interfaceLogsVerification, 3);
        Assert.assertTrue(getTextFromElement(interfaceLogsVerification).contains("Processing Successful"), "Interface logs show critical warnings.");
    }

    public void verifyOrderFormat() {
        waitUntilElementVisible(orderFormatVerification, 3);
        Assert.assertTrue(getTextFromElement(orderFormatVerification).contains("ZOR"), "Order format does not adhere to standard ZOR format.");
    }

    public void verifyAcknowledgmentSent() {
        waitUntilElementVisible(acknowledgmentVerification, 3);
        Assert.assertTrue(getTextFromElement(acknowledgmentVerification).contains("Acknowledgment Sent"), "Acknowledgment to Lisbon failed.");
    }

    public void verifyPerformanceEfficiency() {
        waitUntilElementVisible(performanceEfficiencyVerification, 3);
        Assert.assertTrue(getTextFromElement(performanceEfficiencyVerification).contains("Efficient Processing"), "Payload processing caused performance degradation.");
    }
}