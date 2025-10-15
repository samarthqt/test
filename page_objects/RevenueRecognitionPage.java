package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RevenueRecognitionPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By billingPlanModule = By.id("billingPlanModule");
    protected By lastBillingPlanStatus = By.id("lastBillingPlanStatus");
    protected By btnCreateBillingDocument = By.id("createBillingDocument");
    protected By billingDocumentStatus = By.id("billingDocumentStatus");
    protected By revenueRecognitionSection = By.id("revenueRecognitionSection");
    protected By readinessStatus = By.id("readinessStatus");
    protected By revenueRecognitionSettings = By.id("revenueRecognitionSettings");
    protected By financialLedgerStatus = By.id("financialLedgerStatus");
    protected By revenueRecognitionReport = By.id("revenueRecognitionReport");
    protected By readinessCheckErrors = By.id("readinessCheckErrors");
    protected By readinessStatusLog = By.id("readinessStatusLog");
    protected By businessRulesValidation = By.id("businessRulesValidation");
    protected By billingDocumentStatuses = By.id("billingDocumentStatuses");

    public RevenueRecognitionPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(billingPlanModule), "Login was not successful.");
    }

    public void navigateToBillingPlanModule() {
        waitUntilElementVisible(billingPlanModule, 3);
        clickElement(billingPlanModule);
    }

    public void verifyLastBillingPlanStatus(String expectedStatus) {
        waitUntilElementVisible(lastBillingPlanStatus, 3);
        String actualStatus = getTextFromElement(lastBillingPlanStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Last billing plan status does not match.");
    }

    public void createBillingDocument() {
        waitUntilElementVisible(btnCreateBillingDocument, 3);
        clickElement(btnCreateBillingDocument);
    }

    public void verifyBillingDocumentCreation() {
        Assert.assertTrue(isElementVisible(billingDocumentStatus), "Billing document creation failed.");
    }

    public void openBillingDocument() {
        waitUntilElementVisible(billingDocumentStatus, 3);
        clickElement(billingDocumentStatus);
    }

    public void navigateToRevenueRecognitionSection() {
        waitUntilElementVisible(revenueRecognitionSection, 3);
        clickElement(revenueRecognitionSection);
    }

    public void verifyRevenueRecognitionSectionAccessibility() {
        Assert.assertTrue(isElementVisible(revenueRecognitionSection), "Revenue recognition section is not accessible.");
    }

    public void verifyReadinessStatus() {
        waitUntilElementVisible(readinessStatus, 3);
        String status = getTextFromElement(readinessStatus);
        Assert.assertEquals(status, "Ready", "Billing document is not ready for revenue recognition.");
    }

    public void verifyBillingDocumentReadyForRevenueRecognition() {
        verifyReadinessStatus();
    }

    public void checkRevenueRecognitionSettings() {
        waitUntilElementVisible(revenueRecognitionSettings, 3);
        clickElement(revenueRecognitionSettings);
    }

    public void verifyRevenueRecognitionSettings() {
        Assert.assertTrue(isElementVisible(revenueRecognitionSettings), "Revenue recognition settings are not correctly applied.");
    }

    public void validateRevenueRecognitionStatusInLedger() {
        waitUntilElementVisible(financialLedgerStatus, 3);
        clickElement(financialLedgerStatus);
    }

    public void verifyRevenueRecognitionStatusInLedger() {
        Assert.assertTrue(isElementVisible(financialLedgerStatus), "Revenue recognition status is not updated in the financial ledger.");
    }

    public void checkRevenueRecognitionReport() {
        waitUntilElementVisible(revenueRecognitionReport, 3);
        clickElement(revenueRecognitionReport);
    }

    public void verifyBillingDocumentInRevenueRecognitionReport() {
        Assert.assertTrue(isElementVisible(revenueRecognitionReport), "Billing document is not included in the revenue recognition report.");
    }

    public void startReadinessCheck() {
        waitUntilElementVisible(readinessCheckErrors, 3);
        clickElement(readinessCheckErrors);
    }

    public void completeReadinessCheck() {
        Assert.assertTrue(isElementVisible(readinessCheckErrors), "Readiness check is not completed.");
    }

    public void verifyNoErrorsOrWarnings() {
        String errors = getTextFromElement(readinessCheckErrors);
        Assert.assertEquals(errors, "", "Errors or warnings were generated during the readiness check.");
    }

    public void logReadinessStatus() {
        waitUntilElementVisible(readinessStatusLog, 3);
        clickElement(readinessStatusLog);
    }

    public void verifyReadinessStatusLogged() {
        Assert.assertTrue(isElementVisible(readinessStatusLog), "Readiness status is not logged in the system.");
    }

    public void validateReadinessStatusAgainstBusinessRules() {
        waitUntilElementVisible(businessRulesValidation, 3);
        clickElement(businessRulesValidation);
    }

    public void verifyAlignmentWithBusinessRules() {
        Assert.assertTrue(isElementVisible(businessRulesValidation), "Readiness status does not align with configured business rules.");
    }

    public void checkBillingDocumentStatuses() {
        waitUntilElementVisible(billingDocumentStatuses, 3);
        clickElement(billingDocumentStatuses);
    }

    public void verifyNoImpactOnOtherStatuses() {
        Assert.assertTrue(isElementVisible(billingDocumentStatuses), "Revenue recognition readiness process impacted other statuses of the billing document.");
    }
}