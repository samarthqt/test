package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class StandardOrderPage extends WebReusableComponents {

    protected By inboundInterfaceTrigger = By.id("triggerInboundInterface");
    protected By mandatoryFields = By.id("mandatoryFields");
    protected By payloadProcessing = By.id("processPayload");
    protected By orderCreation = By.id("orderCreation");
    protected By salesAreaAssignment = By.id("salesAreaAssignment");
    protected By orderDetails = By.id("orderDetails");
    protected By uniqueOrderNumber = By.id("uniqueOrderNumber");
    protected By orderLogging = By.id("orderLogging");
    protected By interfaceLogs = By.id("interfaceLogs");
    protected By integrationStatus = By.id("integrationStatus");
    protected By orderFormat = By.id("orderFormat");
    protected By acknowledgment = By.id("acknowledgment");

    public void triggerInboundInterface(String uniqueOrderID) {
        waitUntilElementVisible(inboundInterfaceTrigger, 3);
        enterText(inboundInterfaceTrigger, uniqueOrderID);
        clickElement(inboundInterfaceTrigger);
    }

    public void verifyMandatoryFields(String salesArea) {
        waitUntilElementVisible(mandatoryFields, 3);
        String actualSalesArea = getTextFromElement(mandatoryFields);
        Assert.assertEquals(actualSalesArea, salesArea, "Sales Area does not match.");
    }

    public void processPayload() {
        waitUntilElementVisible(payloadProcessing, 3);
        clickElement(payloadProcessing);
    }

    public void verifyOrderCreation() {
        waitUntilElementVisible(orderCreation, 3);
        boolean isCreated = elementVisible(orderCreation);
        Assert.assertTrue(isCreated, "Order creation failed.");
    }

    public void verifySalesAreaAssignment(String salesArea) {
        waitUntilElementVisible(salesAreaAssignment, 3);
        String actualSalesArea = getTextFromElement(salesAreaAssignment);
        Assert.assertEquals(actualSalesArea, salesArea, "Sales Area assignment is incorrect.");
    }

    public void verifyOrderDetails() {
        waitUntilElementVisible(orderDetails, 3);
        boolean detailsMatch = elementVisible(orderDetails);
        Assert.assertTrue(detailsMatch, "Order details do not match the payload.");
    }

    public void verifyUniqueOrderNumber() {
        waitUntilElementVisible(uniqueOrderNumber, 3);
        boolean isUnique = elementVisible(uniqueOrderNumber);
        Assert.assertTrue(isUnique, "Unique order number generation failed.");
    }

    public void verifyOrderLogging() {
        waitUntilElementVisible(orderLogging, 3);
        boolean isLogged = elementVisible(orderLogging);
        Assert.assertTrue(isLogged, "Order creation logging failed.");
    }

    public void verifyInterfaceLogs() {
        waitUntilElementVisible(interfaceLogs, 3);
        boolean logsSuccess = elementVisible(interfaceLogs);
        Assert.assertTrue(logsSuccess, "Interface logs indicate critical warnings.");
    }

    public void verifyIntegration() {
        waitUntilElementVisible(integrationStatus, 3);
        boolean isSeamless = elementVisible(integrationStatus);
        Assert.assertTrue(isSeamless, "Integration between Lisbon and S/4HANA is not seamless.");
    }

    public void verifyOrderFormat() {
        waitUntilElementVisible(orderFormat, 3);
        boolean isStandardFormat = elementVisible(orderFormat);
        Assert.assertTrue(isStandardFormat, "Order does not adhere to standard format (ZOR).");
    }

    public void verifyAcknowledgment() {
        waitUntilElementVisible(acknowledgment, 3);
        boolean isAcknowledged = elementVisible(acknowledgment);
        Assert.assertTrue(isAcknowledged, "Acknowledgment to Lisbon failed.");
    }
}