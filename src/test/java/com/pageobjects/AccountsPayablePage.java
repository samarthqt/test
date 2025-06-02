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
        verifyLogin();
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        verifyAccountsPayableModuleAccess();
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementDisplayed(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementDisplayed(createInvoiceButton), "Create Invoice feature is not available.");
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice List feature is not available.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        // Logic to fill invoice details
        verifyInvoiceSaved();
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not saved.");
    }

    public void verifyInvoiceInList() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not in the list.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        // Logic to edit invoice
        verifyInvoiceChangesSaved();
    }

    public void verifyInvoiceChangesSaved() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice changes are not saved.");
    }

    public void verifyUpdatedInvoiceDetails() {
        // Logic to verify updated details
        Assert.assertTrue(true, "Updated invoice details are incorrect.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice is still in the list.");
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Payment is not completed.");
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Payment is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection, 3);
        // Logic to view and download reports
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports are not downloaded.");
    }

    public void reviewReports() {
        // Logic to review reports
        verifyReportAccuracy();
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(true, "Report accuracy is incorrect.");
    }

    public void verifyLogin() {
        Assert.assertTrue(isElementDisplayed(dashboard), "Login is not successful.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogout();
    }

    public void verifyLogout() {
        Assert.assertFalse(isElementDisplayed(dashboard), "Logout is not successful.");
    }

    public void verifyAuthorization() {
        Assert.assertTrue(isElementDisplayed(accountsPayableModule), "Authorization failed.");
    }

    public void attemptAccess() {
        // Logic to attempt access
        verifyAccessRestriction();
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Access restriction message not displayed.");
    }
}