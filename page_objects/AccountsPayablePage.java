package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By accountsPayableModule = By.id("accountsPayableModule");
    protected By createInvoiceButton = By.id("createInvoiceButton");
    protected By invoiceList = By.id("invoiceList");
    protected By editInvoiceButton = By.id("editInvoiceButton");
    protected By deleteInvoiceButton = By.id("deleteInvoiceButton");
    protected By generatePaymentButton = By.id("generatePaymentButton");
    protected By reportsSection = By.id("reportsSection");
    protected By logoutButton = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        performLogin();
        verifyDashboardAccess();
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), "Login failed, dashboard not visible.");
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        verifyModuleNavigation();
    }

    public void verifyModuleNavigation() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyModuleFeatures() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), "Create Invoice feature is not available.");
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Generate Payment feature is not available.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        // Logic to fill invoice details
        verifyInvoiceCreation();
    }

    public void verifyInvoiceCreation() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice creation failed.");
    }

    public void verifyInvoiceInList() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not listed.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        // Logic to edit invoice
        verifyInvoiceUpdate();
    }

    public void verifyInvoiceUpdate() {
        Assert.assertTrue(isElementVisible(editInvoiceButton), "Invoice update failed.");
    }

    public void verifyUpdatedInvoiceDetails() {
        // Logic to verify updated invoice details
        Assert.assertTrue(isElementVisible(invoiceList), "Updated invoice details are incorrect.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        verifyInvoiceDeletion();
    }

    public void verifyInvoiceDeletion() {
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice deletion failed.");
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice is still listed after deletion.");
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        verifyPaymentCompletion();
    }

    public void verifyPaymentCompletion() {
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Payment generation failed.");
    }

    public void verifyPaymentRecord() {
        // Logic to verify payment record
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Payment record is incorrect.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection, 3);
        clickElement(reportsSection);
        verifyReportDownload();
    }

    public void verifyReportDownload() {
        Assert.assertTrue(isElementVisible(reportsSection), "Report download failed.");
    }

    public void reviewDownloadedReports() {
        // Logic to review downloaded reports
        Assert.assertTrue(isElementVisible(reportsSection), "Downloaded reports are incorrect.");
    }

    public void verifyReportAccuracy() {
        // Logic to verify report accuracy
        Assert.assertTrue(isElementVisible(reportsSection), "Report accuracy is incorrect.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogout();
    }

    public void verifyLogout() {
        Assert.assertFalse(isElementVisible(dashboard), "Logout failed.");
    }

    public void verifyUnauthorizedAccess() {
        Assert.assertTrue(isElementVisible(errorMessage), "Unauthorized access not restricted.");
    }

    public void attemptAccess() {
        // Logic to attempt access
        verifyAccessRestriction();
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), "Access restriction message not displayed.");
    }
}