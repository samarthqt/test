package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SignConventionPage extends WebReusableComponents {

    protected By programHeader = By.cssSelector(".program-header");
    protected By createOrderButton = By.id("createOrder");
    protected By billingDocumentTypeField = By.id("billingDocumentType");
    protected By processOrderButton = By.id("processOrder");
    protected By errorLog = By.id("errorLog");
    protected By transmitDataButton = By.id("transmitData");

    public void navigateToProgram(String programName) {
        navigateToUrl("https://dummyurl.com/" + programName);
    }

    public void verifyProgramDisplayed(String programName) {
        waitUntilElementVisible(programHeader, 3);
        String headerText = getTextFromElement(programHeader);
        Assert.assertTrue(headerText.contains(programName), "Program not displayed correctly.");
    }

    public void createSalesOrder(String billingDocumentType) {
        waitUntilElementVisible(createOrderButton, 3);
        clickElement(createOrderButton);
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
    }

    public void verifySalesOrderCreated() {
        Assert.assertTrue(isElementPresent(By.id("orderConfirmation")), "Sales order creation failed.");
    }

    public void processSalesOrder() {
        waitUntilElementVisible(processOrderButton, 3);
        clickElement(processOrderButton);
    }

    public void verifyErrorLoggedAndProcessingPrevented() {
        waitUntilElementVisible(errorLog, 3);
        String errorMessage = getTextFromElement(errorLog);
        Assert.assertTrue(errorMessage.contains("misconfigured sign conventions"), "Error not logged correctly.");
    }

    public void processIndirectSalesTransaction(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
        clickElement(processOrderButton);
    }

    public void checkErrorLogs() {
        waitUntilElementVisible(errorLog, 3);
    }

    public void verifyErrorLogDetails() {
        String errorDetails = getTextFromElement(errorLog);
        Assert.assertTrue(errorDetails.contains("S1 invoices"), "Error log details are incorrect.");
    }

    public void attemptDataTransmission() {
        waitUntilElementVisible(transmitDataButton, 3);
        clickElement(transmitDataButton);
    }

    public void verifyDataTransmissionPrevented() {
        String errorMessage = getTextFromElement(errorLog);
        Assert.assertTrue(errorMessage.contains("data transmission prevented"), "Data transmission was not prevented.");
    }
}