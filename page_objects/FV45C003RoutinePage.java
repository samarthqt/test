package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class FV45C003RoutinePage extends WebReusableComponents {

    protected By routineStatus = By.id("routineStatus");
    protected By billingDocumentTypeDropdown = By.id("billingDocumentType");
    protected By partnerDataField = By.id("partnerData");
    protected By btnCreateBillingDocument = By.id("createBillingDocument");
    protected By billingDocumentConfirmation = By.id("billingDocumentConfirmation");
    protected By salesDocumentTypeDropdown = By.id("salesDocumentType");
    protected By btnGenerateSalesDocument = By.id("generateSalesDocument");
    protected By salesDocumentConfirmation = By.id("salesDocumentConfirmation");
    protected By partnerDataVerificationField = By.id("partnerDataVerification");
    protected By documentFlowLinkage = By.id("documentFlowLinkage");
    protected By systemPerformanceMetrics = By.id("systemPerformanceMetrics");
    protected By testResultsField = By.id("testResultsField");
    protected By recommendationsField = By.id("recommendationsField");

    public void verifyRoutineConfiguration() {
        waitUntilElementVisible(routineStatus, 3);
        String status = getTextFromElement(routineStatus);
        Assert.assertEquals(status, "Active", "Routine is not active.");
    }

    public void createBillingDocument(String billingDocumentType, String partnerData) {
        waitUntilElementVisible(billingDocumentTypeDropdown, 3);
        selectByValue(billingDocumentTypeDropdown, billingDocumentType);
        enterText(partnerDataField, partnerData);
        clickElement(btnCreateBillingDocument);
    }

    public void verifyBillingDocumentCreation() {
        waitUntilElementVisible(billingDocumentConfirmation, 3);
        String confirmationMessage = getTextFromElement(billingDocumentConfirmation);
        Assert.assertEquals(confirmationMessage, "Billing document created successfully.", "Billing document creation failed.");
    }

    public void generateSalesDocument(String salesDocumentType) {
        waitUntilElementVisible(salesDocumentTypeDropdown, 3);
        selectByValue(salesDocumentTypeDropdown, salesDocumentType);
        clickElement(btnGenerateSalesDocument);
    }

    public void verifySalesDocumentGeneration() {
        waitUntilElementVisible(salesDocumentConfirmation, 3);
        String confirmationMessage = getTextFromElement(salesDocumentConfirmation);
        Assert.assertEquals(confirmationMessage, "Sales document generated successfully.", "Sales document generation failed.");
    }

    public void verifySalesDocumentGenerated() {
        waitUntilElementVisible(salesDocumentConfirmation, 3);
        String confirmationMessage = getTextFromElement(salesDocumentConfirmation);
        Assert.assertEquals(confirmationMessage, "Sales document generated successfully.", "Sales document generation failed.");
    }

    public void verifyPartnerDataInSalesDocument() {
        waitUntilElementVisible(partnerDataVerificationField, 3);
        String partnerData = getTextFromElement(partnerDataVerificationField);
        Assert.assertNotNull(partnerData, "Partner data is not present in the Sales document.");
    }

    public void verifyPartnerDataAccuracy(String expectedPartnerData) {
        waitUntilElementVisible(partnerDataVerificationField, 3);
        String actualPartnerData = getTextFromElement(partnerDataVerificationField);
        Assert.assertEquals(actualPartnerData, expectedPartnerData, "Partner data is not copied accurately.");
    }

    public void verifyDocumentsCreated() {
        verifyBillingDocumentCreation();
        verifySalesDocumentGeneration();
    }

    public void checkDocumentFlow() {
        waitUntilElementVisible(documentFlowLinkage, 3);
        String linkageStatus = getTextFromElement(documentFlowLinkage);
        Assert.assertEquals(linkageStatus, "Linkage correct", "Document flow linkage is incorrect.");
    }

    public void performDocumentCreationProcess() {
        createBillingDocument("ZL2", "Maximum data volume and special characters");
        generateSalesDocument("ZCR");
    }

    public void validateSystemPerformance() {
        waitUntilElementVisible(systemPerformanceMetrics, 3);
        String performanceStatus = getTextFromElement(systemPerformanceMetrics);
        Assert.assertEquals(performanceStatus, "Performance within limits", "System performance is not acceptable.");
    }

    public void documentTestResults() {
        waitUntilElementVisible(testResultsField, 3);
        enterText(testResultsField, "Test results documented.");
    }

    public void provideRecommendationsForImprovement() {
        waitUntilElementVisible(recommendationsField, 3);
        enterText(recommendationsField, "Recommendations provided to enhance routine robustness.");
    }
}