package com.pageobjects;

import org.openqa.selenium.By;
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
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), "Login failed, dashboard not visible.");
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

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Navigation to Accounts Payable failed.");
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), "Create Invoice feature is not visible.");
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Generate Payment feature is not visible.");
        Assert.assertTrue(isElementVisible(reportsSection), "Reports section is not visible.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        // Add logic to fill invoice details
        clickElement(By.id("saveInvoiceButton"));
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice creation failed.");
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not saved.");
    }

    public void verifyInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not displayed.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        // Add logic to edit invoice details
        clickElement(By.id("saveChangesButton"));
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice update failed.");
    }

    public void verifyInvoiceUpdated() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not updated.");
    }

    public void verifyUpdatedInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), "Updated invoice is not displayed.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice deletion failed.");
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), "Deleted invoice is still displayed.");
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementVisible(By.id("paymentConfirmation")), "Payment generation failed.");
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(By.id("paymentConfirmation")), "Payment is not completed.");
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementVisible(By.id("paymentRecord")), "Payment is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection, 3);
        clickElement(By.id("downloadReportsButton"));
        Assert.assertTrue(isElementVisible(By.id("downloadConfirmation")), "Reports download failed.");
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(By.id("downloadConfirmation")), "Reports are not downloaded.");
    }

    public void reviewReports() {
        // Add logic to review reports
        Assert.assertTrue(isElementVisible(By.id("reportAccuracy")), "Reports review failed.");
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementVisible(By.id("reportAccuracy")), "Reports are not accurate.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    public void verifyNoAuthorization() {
        Assert.assertFalse(isElementVisible(accountsPayableModule), "Unauthorized access is possible.");
    }

    public void attemptAccessWithoutAuthorization() {
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(errorMessage), "Access is not restricted.");
    }

    public void verifyAccessRestricted() {
        Assert.assertTrue(isElementVisible(errorMessage), "Access is not restricted.");
    }
}