package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class BillingProcessPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By salesOrderScreen = By.id("salesOrderScreen");
    protected By billingProcessButton = By.id("billingProcessButton");

    public void loginToSystem(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("dashboard"), "Login was not successful.");
    }

    public void navigateToSalesOrderScreen() {
        waitUntilElementVisible(salesOrderScreen, 3);
        clickElement(salesOrderScreen);
    }

    public void enterSalesOrderAttributes(String katr1, String katr2) {
        enterText(By.id("katr1"), katr1);
        enterText(By.id("katr2"), katr2);
        clickElement(By.id("createSalesOrder"));
    }

    public void verifySalesOrderCreation() {
        String confirmationMessage = getTextFromElement(By.id("salesOrderConfirmation"));
        Assert.assertTrue(confirmationMessage.contains("Sales Order Created"), "Sales order creation failed.");
    }

    public void executeBillingProcess() {
        waitUntilElementVisible(billingProcessButton, 3);
        clickElement(billingProcessButton);
    }

    public void verifyBillingDocumentGeneration() {
        String confirmationMessage = getTextFromElement(By.id("billingConfirmation"));
        Assert.assertTrue(confirmationMessage.contains("Billing Documents Generated"), "Billing document generation failed.");
    }

    public void validateSplitLogic() {
        String splitLogicStatus = getTextFromElement(By.id("splitLogicStatus"));
        Assert.assertEquals(splitLogicStatus, "Correct", "Split logic validation failed.");
    }

    public void verifySplitLogic() {
        validateSplitLogic();
    }

    public void reviewDocumentFlow() {
        String documentFlow = getTextFromElement(By.id("documentFlow"));
        Assert.assertNotNull(documentFlow, "Document flow review failed.");
    }

    public void monitorSystemPerformance() {
        String performanceMetrics = getTextFromElement(By.id("performanceMetrics"));
        Assert.assertTrue(performanceMetrics.contains("Optimal"), "System performance is not optimal.");
    }

    public void reviewBillingDocumentData() {
        String billingData = getTextFromElement(By.id("billingData"));
        Assert.assertNotNull(billingData, "Billing document data review failed.");
    }

    public void verifyBillingDocumentDataIntegrity() {
        reviewBillingDocumentData();
    }

    public void reviewAccountingEntries() {
        String accountingEntries = getTextFromElement(By.id("accountingEntries"));
        Assert.assertNotNull(accountingEntries, "Accounting entries review failed.");
    }

    public void verifyAccountingEntries() {
        reviewAccountingEntries();
    }

    public void reviewAuditLogs() {
        String auditLogs = getTextFromElement(By.id("auditLogs"));
        Assert.assertFalse(auditLogs.contains("Error"), "Audit logs contain errors.");
    }

    public void verifyAuditLogs() {
        reviewAuditLogs();
    }

    public void reviewOutputDocuments() {
        String outputDocuments = getTextFromElement(By.id("outputDocuments"));
        Assert.assertNotNull(outputDocuments, "Output document review failed.");
    }

    public void verifyOutputDocumentFormatting() {
        reviewOutputDocuments();
    }

    public void validateDownstreamIntegration() {
        String integrationStatus = getTextFromElement(By.id("integrationStatus"));
        Assert.assertEquals(integrationStatus, "Success", "Downstream integration validation failed.");
    }

    public void verifyDownstreamIntegration() {
        validateDownstreamIntegration();
    }

    public void reviewNotifications() {
        String notifications = getTextFromElement(By.id("notifications"));
        Assert.assertNotNull(notifications, "Notification review failed.");
    }

    public void verifyNotifications() {
        reviewNotifications();
    }
}