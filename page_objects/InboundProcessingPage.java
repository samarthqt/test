package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class InboundProcessingPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By inboundFileUploadInterface = By.id("inboundFileUploadInterface");
    protected By btnUploadFile = By.id("uploadFileButton");
    protected By btnTriggerProcessing = By.id("triggerProcessingButton");
    protected By processingLogs = By.id("processingLogs");
    protected By performanceStatus = By.id("performanceStatus");
    protected By complianceStatus = By.id("complianceStatus");

    public void loginToSAP(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void navigateToInboundFileUploadInterface() {
        waitUntilElementVisible(inboundFileUploadInterface, 3);
        clickElement(inboundFileUploadInterface);
    }

    public void uploadInboundFile(String lisbonOrderID) {
        waitUntilElementVisible(btnUploadFile, 3);
        uploadFile(btnUploadFile, "path/to/inbound/file/" + lisbonOrderID + ".txt");
    }

    public void triggerInboundProcessing() {
        waitUntilElementVisible(btnTriggerProcessing, 3);
        clickElement(btnTriggerProcessing);
    }

    public void verifyFileProcessingSuccess() {
        String logs = getTextFromElement(processingLogs);
        Assert.assertTrue(logs.contains("Processing completed successfully"), "File processing was not successful.");
    }

    public void verifyProcessingLogs(String expectedLogStatus) {
        String logs = getTextFromElement(processingLogs);
        Assert.assertTrue(logs.contains(expectedLogStatus), "Processing logs do not match the expected status.");
    }

    public void verifyMappingStatus(String expectedMappingStatus) {
        String mappingStatus = getTextFromElement(By.id("mappingStatus"));
        Assert.assertEquals(mappingStatus, expectedMappingStatus, "Mapping status does not match.");
    }

    public void verifyOrderCreationStatus(String expectedOrderCreationStatus) {
        String orderCreationStatus = getTextFromElement(By.id("orderCreationStatus"));
        Assert.assertEquals(orderCreationStatus, expectedOrderCreationStatus, "Order creation status does not match.");
    }

    public void verifyOrderDetailsAccuracy(String expectedOrderDetailsAccuracy) {
        String orderDetailsAccuracy = getTextFromElement(By.id("orderDetailsAccuracy"));
        Assert.assertEquals(orderDetailsAccuracy, expectedOrderDetailsAccuracy, "Order details accuracy does not match.");
    }

    public void verifyIdentifierHandling(String expectedIdentifierHandling) {
        String identifierHandling = getTextFromElement(By.id("identifierHandling"));
        Assert.assertEquals(identifierHandling, expectedIdentifierHandling, "Identifier handling does not match.");
    }

    public void verifyReportInclusion(String expectedReportInclusion) {
        String reportInclusion = getTextFromElement(By.id("reportInclusion"));
        Assert.assertEquals(reportInclusion, expectedReportInclusion, "Report inclusion does not match.");
    }

    public void verifyPerformanceStatus(String expectedPerformanceStatus) {
        String performance = getTextFromElement(performanceStatus);
        Assert.assertEquals(performance, expectedPerformanceStatus, "Performance status does not match.");
    }

    public void verifyComplianceStatus(String expectedComplianceStatus) {
        String compliance = getTextFromElement(complianceStatus);
        Assert.assertEquals(compliance, expectedComplianceStatus, "Compliance status does not match.");
    }

    public void verifyLoginSuccess() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "User is not logged in successfully.");
    }

    public void verifyInboundFileUploadInterfaceDisplayed() {
        Assert.assertTrue(isElementVisible(inboundFileUploadInterface), "Inbound file upload interface is not displayed.");
    }

    public void verifyEfficientProcessing() {
        String performance = getTextFromElement(performanceStatus);
        Assert.assertTrue(performance.contains("Efficient"), "System performance is degraded during processing.");
    }

    public void verifyDataIntegrityAndCompliance() {
        String compliance = getTextFromElement(complianceStatus);
        Assert.assertTrue(compliance.contains("Maintained"), "Data integrity or business rules compliance is not maintained.");
    }
}