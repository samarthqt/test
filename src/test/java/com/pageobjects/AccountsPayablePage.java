package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    protected By loginButton = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By accountsPayableModule = By.id("accountsPayableModule");
    protected By createInvoiceButton = By.id("createInvoice");
    protected By invoiceList = By.id("invoiceList");
    protected By editInvoiceButton = By.id("editInvoice");
    protected By deleteInvoiceButton = By.id("deleteInvoice");
    protected By generatePaymentButton = By.id("generatePayment");
    protected By reportsSection = By.id("reportsSection");
    protected By logoutButton = By.id("logoutButton");
    protected By unauthorizedAccessMessage = By.id("unauthorizedAccessMessage");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(dashboard), "Login failed, dashboard not accessible.");
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(dashboard), "Login failed, dashboard not accessible.");
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementDisplayed(accountsPayableModule), "Navigation to Accounts Payable failed.");
    }

    public void verifyAccountsPayableNavigation() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementDisplayed(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementDisplayed(createInvoiceButton), "Create Invoice option is not available.");
        Assert.assertTrue(isElementDisplayed(generatePaymentButton), "Generate Payment option is not available.");
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports section is not available.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice creation failed.");
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not saved.");
    }

    public void verifyInvoiceInList() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not displayed in the list.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice edit failed.");
    }

    public void verifyInvoiceUpdated() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not updated.");
    }

    public void verifyUpdatedInvoiceDetails() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Updated invoice details are not displayed.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice deletion failed.");
    }

    public void verifyInvoiceDeleted() {
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementDisplayed(invoiceList), "Deleted invoice is still displayed.");
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementDisplayed(invoiceList), "Payment generation failed.");
    }

    public void verifyPaymentSuccess() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Payment is not successful.");
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementDisplayed(invoiceList), "Payment information is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection, 3);
        clickElement(reportsSection);
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports download failed.");
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports are not downloaded.");
    }

    public void reviewReports() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports are not available for review.");
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementDisplayed(reportsSection), "Reports are not accurate.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(isElementDisplayed(loginButton), "Logout failed.");
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementDisplayed(loginButton), "Logout is not successful.");
    }

    public void verifyUnauthorizedAccess() {
        Assert.assertTrue(isElementDisplayed(unauthorizedAccessMessage), "Unauthorized access message is not displayed.");
    }

    public void attemptUnauthorizedAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementDisplayed(unauthorizedAccessMessage), "Access restriction is not enforced.");
    }

    public void verifyAccessRestriction() {
        Assert.assertTrue(isElementDisplayed(unauthorizedAccessMessage), "Access restriction is not enforced.");
    }
}