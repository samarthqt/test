package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class EmailAttachmentDispatchPage extends WebReusableComponents {

    protected By billingDocumentModule = By.id("billingDocumentModule");
    protected By emailCommunicationModule = By.id("emailCommunicationModule");
    protected By searchBillingDocumentField = By.id("searchBillingDocument");
    protected By billingDocumentDetails = By.id("billingDocumentDetails");
    protected By documentTypeField = By.id("documentType");
    protected By searchEmailField = By.id("searchEmail");
    protected By emailRecord = By.id("emailRecord");
    protected By attachment = By.id("attachment");
    protected By emailLogs = By.id("emailLogs");

    public void loginToSAPSystem() {
        // Logic to log into the SAP S/4HANA Cloud system
    }

    public void navigateToBillingDocumentModule() {
        clickElement(billingDocumentModule);
    }

    public void searchBillingDocument(String billingDocumentID) {
        enterText(searchBillingDocumentField, billingDocumentID);
        pressEnter(searchBillingDocumentField);
    }

    public void verifyBillingDocumentDetailsDisplayed() {
        Assert.assertTrue(isElementVisible(billingDocumentDetails), "Billing document details are not displayed.");
    }

    public void verifyDocumentType(String documentType) {
        String actualDocumentType = getTextFromElement(documentTypeField);
        Assert.assertEquals(actualDocumentType, documentType, "Document type does not match.");
    }

    public void navigateToEmailCommunicationModule() {
        clickElement(emailCommunicationModule);
    }

    public void searchEmailByCustomer(String customerEmail) {
        enterText(searchEmailField, customerEmail);
        pressEnter(searchEmailField);
    }

    public void verifyEmailRecordStatus(String emailStatus) {
        String actualStatus = getTextFromElement(emailRecord);
        Assert.assertTrue(actualStatus.contains(emailStatus), "Email status does not match.");
    }

    public void openEmailRecord() {
        clickElement(emailRecord);
    }

    public void verifyAttachmentPresenceAndAccessibility() {
        Assert.assertTrue(isElementVisible(attachment), "Attachment is not present or accessible.");
    }

    public void downloadAttachment() {
        clickElement(attachment);
    }

    public void verifyAttachmentFormat(String attachmentFormat) {
        String actualFormat = getFileExtensionFromAttachment(attachment);
        Assert.assertEquals(actualFormat, attachmentFormat, "Attachment format does not match.");
    }

    public void verifyAttachmentOpensWithoutErrors() {
        Assert.assertTrue(isAttachmentOpenable(attachment), "Attachment does not open without errors.");
    }

    public void compareAttachmentContentWithBillingDocument(String billingDocumentID) {
        String attachmentContent = getAttachmentContent(attachment);
        String billingDocumentContent = getBillingDocumentContent(billingDocumentID);
        Assert.assertEquals(attachmentContent, billingDocumentContent, "Attachment content does not match the Billing document.");
    }

    public void verifyAttachmentContentMatchesBillingDocument() {
        // Logic to verify attachment content matches Billing document
    }

    public void checkEmailLogs() {
        clickElement(emailLogs);
    }

    public void verifyEmailLogsForSuccessfulDispatch() {
        String logs = getTextFromElement(emailLogs);
        Assert.assertTrue(logs.contains("successfully sent"), "Email logs do not confirm successful dispatch.");
    }

    public void validateBillingDocumentEmailLinkage() {
        // Logic to validate linkage between Billing document and email
    }

    public void verifyCorrectLinkageBetweenEmailAndBillingDocument() {
        // Logic to verify correct linkage between email and Billing document
    }

    public void verifyOverallWorkflow() {
        // Logic to verify overall workflow for email attachment dispatch
    }

    public void verifyWorkflowFunctionality() {
        // Logic to verify workflow functionality
    }
}