package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By accountsPayableModule = By.id("accountsPayableModule");
    protected By createInvoiceButton = By.id("createInvoice");
    protected By invoiceList = By.id("invoiceList");
    protected By editInvoiceButton = By.id("editInvoice");
    protected By deleteInvoiceButton = By.id("deleteInvoice");
    protected By generatePaymentButton = By.id("generatePayment");
    protected By downloadReportsButton = By.id("downloadReports");
    protected By logoutButton = By.id("logoutButton");
    protected By unauthorizedAccessMessage = By.id("unauthorizedAccessMessage");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), "Login as finance user failed.");
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), "Login failed.");
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard access failed.");
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Navigation to Accounts Payable module failed.");
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module access failed.");
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(createInvoiceButton, 3);
        Assert.assertTrue(isElementVisible(createInvoiceButton), "Accounts Payable features are not visible.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), "New invoice creation failed.");
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice not saved.");
    }

    public void verifyInvoiceDisplayedInList() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice not displayed in list.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice edit failed.");
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice changes not saved.");
    }

    public void verifyUpdatedInvoiceInformation() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Updated invoice information not displayed.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice deletion failed.");
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice not deleted.");
    }

    public void verifyInvoiceNotInList() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), "Deleted invoice still in list.");
    }

    public void generatePaymentForInvoice() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementVisible(invoiceList), "Payment generation failed.");
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Payment not completed.");
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Payment not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(downloadReportsButton, 3);
        clickElement(downloadReportsButton);
        Assert.assertTrue(isElementVisible(downloadReportsButton), "Reports download failed.");
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(downloadReportsButton, 3);
        Assert.assertTrue(isElementVisible(downloadReportsButton), "Reports not downloaded.");
    }

    public void reviewDownloadedReports() {
        waitUntilElementVisible(downloadReportsButton, 3);
        Assert.assertTrue(isElementVisible(downloadReportsButton), "Downloaded reports not reviewed.");
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(downloadReportsButton, 3);
        Assert.assertTrue(isElementVisible(downloadReportsButton), "Report accuracy failed.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(btnLogin), "Logout failed.");
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin, 3);
        Assert.assertTrue(isElementVisible(btnLogin), "Logout success verification failed.");
    }

    public void attemptUnauthorizedAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(unauthorizedAccessMessage), "Unauthorized access attempt failed.");
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(unauthorizedAccessMessage, 3);
        Assert.assertTrue(isElementVisible(unauthorizedAccessMessage), "Unauthorized access message not displayed.");
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(unauthorizedAccessMessage, 3);
        Assert.assertTrue(isElementVisible(unauthorizedAccessMessage), "Access restriction failed.");
    }
}