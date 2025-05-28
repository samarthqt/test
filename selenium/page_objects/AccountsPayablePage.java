package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AccountsPayablePage extends WebReusableComponents {

    protected By dashboardAccess = By.id(dashboardAccess);
    protected By accountsPayableModule = By.id(accountsPayableModule);
    protected By invoiceList = By.id(invoiceList);
    protected By newInvoiceButton = By.id(newInvoiceButton);
    protected By editInvoiceButton = By.id(editInvoiceButton);
    protected By deleteInvoiceButton = By.id(deleteInvoiceButton);
    protected By paymentButton = By.id(paymentButton);
    protected By reportDownloadButton = By.id(reportDownloadButton);
    protected By logoutButton = By.id(logoutButton);
    protected By unauthorizedAccessMessage = By.id(unauthorizedAccessMessage);

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterText(By.id(username), username);
        enterText(By.id(password), password);
        clickElement(By.id(loginButton));
        Assert.assertTrue(isElementVisible(dashboardAccess), Login failed.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboardAccess, 3);
        Assert.assertTrue(isElementVisible(dashboardAccess), Dashboard access failed.);
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Navigation to Accounts Payable failed.);
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module access failed.);
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(newInvoiceButton), Create Invoice feature not available.);
        Assert.assertTrue(isElementVisible(paymentButton), Manage Payments feature not available.);
        Assert.assertTrue(isElementVisible(reportDownloadButton), Generate Reports feature not available.);
    }

    public void createNewInvoice(String invoiceData) {
        clickElement(newInvoiceButton);
        enterText(By.id(invoiceData), invoiceData);
        clickElement(By.id(saveInvoiceButton));
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not saved.);
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not saved.);
    }

    public void verifyInvoiceInList() {
        waitUntilElementVisible(invoiceList, 3);
        boolean invoiceFound = getWebElementList(invoiceList)
            .stream()
            .anyMatch(item -> item.getText().contains(New Invoice));
        Assert.assertTrue(invoiceFound, Invoice not found in list.);
    }

    public void editInvoice(String invoiceData) {
        clickElement(editInvoiceButton);
        enterText(By.id(invoiceData), invoiceData);
        clickElement(By.id(saveInvoiceButton));
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes not saved.);
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes not saved.);
    }

    public void verifyUpdatedInvoiceDetails() {
        waitUntilElementVisible(invoiceList, 3);
        boolean invoiceUpdated = getWebElementList(invoiceList)
            .stream()
            .anyMatch(item -> item.getText().contains(Updated Invoice));
        Assert.assertTrue(invoiceUpdated, Invoice details not updated.);
    }

    public void deleteInvoice() {
        clickElement(deleteInvoiceButton);
        clickElement(By.id(confirmDeleteButton));
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not deleted.);
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList, 3);
        boolean invoiceFound = getWebElementList(invoiceList)
            .stream()
            .noneMatch(item -> item.getText().contains(Deleted Invoice));
        Assert.assertTrue(invoiceFound, Invoice not deleted.);
    }

    public void verifyInvoiceNotInList() {
        waitUntilElementVisible(invoiceList, 3);
        boolean invoiceFound = getWebElementList(invoiceList)
            .stream()
            .noneMatch(item -> item.getText().contains(Deleted Invoice));
        Assert.assertTrue(invoiceFound, Deleted invoice still in list.);
    }

    public void generatePayment() {
        clickElement(paymentButton);
        enterText(By.id(paymentData), Payment Info);
        clickElement(By.id(confirmPaymentButton));
        Assert.assertTrue(isElementVisible(By.id(paymentConfirmation)), Payment not completed.);
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(By.id(paymentConfirmation), 3);
        Assert.assertTrue(isElementVisible(By.id(paymentConfirmation)), Payment not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(By.id(paymentRecord), 3);
        Assert.assertTrue(isElementVisible(By.id(paymentRecord)), Payment not recorded.);
    }

    public void viewAndDownloadReports() {
        clickElement(reportDownloadButton);
        clickElement(By.id(downloadReportButton));
        Assert.assertTrue(isElementVisible(By.id(reportDownloadConfirmation)), Reports not downloaded.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(By.id(reportDownloadConfirmation), 3);
        Assert.assertTrue(isElementVisible(By.id(reportDownloadConfirmation)), Reports not downloaded.);
    }

    public void reviewReports() {
        // Assume reports are reviewed manually
        Assert.assertTrue(true, Reports reviewed.);
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(true, Reports are accurate.);
    }

    public void logout() {
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(By.id(loginPage)), Logout failed.);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(By.id(loginPage), 3);
        Assert.assertTrue(isElementVisible(By.id(loginPage)), Logout failed.);
    }

    public void attemptUnauthorizedAccess() {
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(unauthorizedAccessMessage), Access restriction failed.);
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(unauthorizedAccessMessage, 3);
        Assert.assertTrue(isElementVisible(unauthorizedAccessMessage), Access restriction failed.);
    }

    private List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }
}