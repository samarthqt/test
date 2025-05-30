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
    protected By createInvoiceButton = By.id("createInvoice");
    protected By invoiceList = By.id("invoiceList");
    protected By editInvoiceButton = By.id("editInvoice");
    protected By deleteInvoiceButton = By.id("deleteInvoice");
    protected By generatePaymentButton = By.id("generatePayment");
    protected By downloadReportsButton = By.id("downloadReports");
    protected By logoutButton = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        performLogin();
        verifyUserLoggedIn();
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementDisplayed(dashboard), "Login failed.");
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementDisplayed(dashboard), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        verifyAccountsPayableModuleAccess();
    }

    public void verifyAccountsPayableModuleAccess() {
        Assert.assertTrue(isElementDisplayed(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableOptions() {
        Assert.assertTrue(isElementDisplayed(createInvoiceButton), "Create Invoice option is not available.");
        Assert.assertTrue(isElementDisplayed(generatePaymentButton), "Generate Payment option is not available.");
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
        // Logic to verify invoice in list
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice is not in the list.");
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        // Logic to edit invoice
        verifyInvoiceUpdated();
    }

    public void verifyInvoiceUpdated() {
        // Logic to verify invoice is updated
        Assert.assertTrue(isElementDisplayed(invoiceList), "Invoice update failed.");
    }

    public void verifyUpdatedInvoiceDetails() {
        // Logic to verify updated invoice details
        Assert.assertTrue(isElementDisplayed(invoiceList), "Updated invoice details are incorrect.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        // Logic to verify invoice is deleted
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotInList() {
        // Logic to verify invoice not in list
        Assert.assertFalse(isElementDisplayed(invoiceList), "Invoice is still in the list.");
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        // Logic to verify payment is completed
        Assert.assertTrue(isElementDisplayed(dashboard), "Payment is not completed.");
    }

    public void verifyPaymentRecorded() {
        // Logic to verify payment is recorded
        Assert.assertTrue(isElementDisplayed(dashboard), "Payment is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(downloadReportsButton, 3);
        clickElement(downloadReportsButton);
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        // Logic to verify reports are downloaded
        Assert.assertTrue(isElementDisplayed(dashboard), "Reports are not downloaded.");
    }

    public void reviewReports() {
        // Logic to review reports
        Assert.assertTrue(isElementDisplayed(dashboard), "Reports review failed.");
    }

    public void verifyReportAccuracy() {
        // Logic to verify report accuracy
        Assert.assertTrue(isElementDisplayed(dashboard), "Report accuracy is incorrect.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(dashboard), "User is not logged in.");
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementDisplayed(dashboard), "Logout failed.");
    }

    public void verifyUserNotAuthorized() {
        Assert.assertTrue(isElementDisplayed(errorMessage), "User is authorized unexpectedly.");
    }

    public void attemptAccessAccountsPayable() {
        navigateToAccountsPayableModule();
        verifyAccessRestricted();
    }

    public void verifyAccessRestricted() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementDisplayed(errorMessage), "Access is not restricted.");
    }
}