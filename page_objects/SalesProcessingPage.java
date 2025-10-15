package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SalesProcessingPage extends WebReusableComponents {

    protected By homePageHeader = By.id("homePageHeader");
    protected By directSalesProgramLink = By.id("directSalesProgram");
    protected By indirectSalesProgramLink = By.id("indirectSalesProgram");
    protected By salesOrderForm = By.id("salesOrderForm");
    protected By billingDocumentTypeField = By.id("billingDocumentType");
    protected By createOrderButton = By.id("createOrder");
    protected By processOrderButton = By.id("processOrder");
    protected By errorLog = By.id("errorLog");
    protected By transmissionButton = By.id("transmitData");

    public void navigateToHomePage() {
        waitUntilElementVisible(homePageHeader, 3);
        Assert.assertTrue(isElementDisplayed(homePageHeader), "Home page is not displayed.");
    }

    public void navigateToDirectSalesProgram(String programName) {
        waitUntilElementVisible(directSalesProgramLink, 3);
        clickElement(directSalesProgramLink);
    }

    public void verifyDirectSalesProgramDisplayed() {
        waitUntilElementVisible(salesOrderForm, 3);
        Assert.assertTrue(isElementDisplayed(salesOrderForm), "Direct Sales processing program is not displayed.");
    }

    public void createSalesOrder(String billingDocumentType) {
        waitUntilElementVisible(billingDocumentTypeField, 3);
        enterText(billingDocumentTypeField, billingDocumentType);
        clickElement(createOrderButton);
    }

    public void verifySalesOrderCreated() {
        Assert.assertTrue(isElementDisplayed(processOrderButton), "Sales order creation failed.");
    }

    public void processSalesOrder() {
        waitUntilElementVisible(processOrderButton, 3);
        clickElement(processOrderButton);
    }

    public void verifyErrorLoggedForMissingEntries() {
        waitUntilElementVisible(errorLog, 3);
        String errorMessage = getTextFromElement(errorLog);
        Assert.assertTrue(errorMessage.contains("missing ZOTC_CROSSREFTAB entries"), "Error log does not indicate missing entries.");
    }

    public void verifyProcessingPrevented() {
        Assert.assertFalse(isElementEnabled(processOrderButton), "Processing was not prevented.");
    }

    public void navigateToIndirectSalesProgram(String programName) {
        waitUntilElementVisible(indirectSalesProgramLink, 3);
        clickElement(indirectSalesProgramLink);
    }

    public void verifyIndirectSalesProgramDisplayed() {
        waitUntilElementVisible(salesOrderForm, 3);
        Assert.assertTrue(isElementDisplayed(salesOrderForm), "Indirect Sales processing program is not displayed.");
    }

    public void processIndirectSalesTransaction(String billingDocumentType) {
        createSalesOrder(billingDocumentType);
        processSalesOrder();
    }

    public void attemptToProcessTransaction(String billingDocumentType) {
        createSalesOrder(billingDocumentType);
        processSalesOrder();
    }

    public void checkErrorLogs() {
        waitUntilElementVisible(errorLog, 3);
    }

    public void verifyErrorLogDetails() {
        String errorMessage = getTextFromElement(errorLog);
        Assert.assertTrue(errorMessage.contains("missing ZOTC_CROSSREFTAB entries"), "Error log details are incorrect.");
    }

    public void attemptDataTransmission() {
        waitUntilElementVisible(transmissionButton, 3);
        clickElement(transmissionButton);
    }

    public void verifyDataTransmissionPrevented() {
        Assert.assertFalse(isElementEnabled(transmissionButton), "Data transmission was not prevented.");
    }
}