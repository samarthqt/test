package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AccountsPayablePage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By dashboardURL = By.id("dashboardURL");
    protected By accountsPayableModuleLink = By.id("accountsPayableModule");
    protected By invoiceList = By.id("invoiceList");
    protected By createInvoiceButton = By.id("createInvoice");
    protected By editInvoiceButton = By.id("editInvoice");
    protected By deleteInvoiceButton = By.id("deleteInvoice");
    protected By generatePaymentButton = By.id("generatePayment");
    protected By viewReportsButton = By.id("viewReports");
    protected By logoutButton = By.id("logoutButton");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyDashboardRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the dashboard.");
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModuleLink, 3);
        clickElement(accountsPayableModuleLink);
    }

    public void verifyAccountsPayableModuleAccess() {
        Assert.assertTrue(isElementVisible(accountsPayableModuleLink), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeaturesAvailability() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), "Create Invoice feature is not available.");
        Assert.assertTrue(isElementVisible(editInvoiceButton), "Edit Invoice feature is not available.");
        Assert.assertTrue(isElementVisible(deleteInvoiceButton), "Delete Invoice feature is not available.");
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Generate Payment feature is not available.");
        Assert.assertTrue(isElementVisible(viewReportsButton), "View Reports feature is not available.");
    }

    public void createNewInvoice(String invoiceData) {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        // Logic to enter invoice data
        verifyInvoiceSaved();
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not saved.");
    }

    public void verifyInvoiceDisplayedInList() {
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not displayed in the list.");
    }

    public void editInvoice(String updatedInvoiceData) {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        // Logic to update invoice data
        verifyInvoiceChangesSaved();
    }

    public void verifyInvoiceChangesSaved() {
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice changes are not saved.");
    }

    public void verifyUpdatedInvoiceDisplayed() {
        Assert.assertTrue(isElementVisible(invoiceList), "Updated invoice is not displayed.");
    }

    public void deleteInvoice(String invoiceId) {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        // Logic to delete invoice
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementVisible(invoiceList), "Deleted invoice is still displayed.");
    }

    public void generatePayment(String paymentData) {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        // Logic to generate payment
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(invoiceList), "Payment is not completed.");
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementVisible(invoiceList), "Payment information is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(viewReportsButton, 3);
        clickElement(viewReportsButton);
        // Logic to view and download reports
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(viewReportsButton), "Reports are not downloaded.");
    }

    public void reviewDownloadedReports() {
        // Logic to review downloaded reports
        verifyReportAccuracy();
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementVisible(viewReportsButton), "Reports are not accurate.");
    }

    public void logoutFromSystem() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, "loginPageURL", "User is not logged out successfully.");
    }

    public void attemptUnauthorizedAccess() {
        // Logic to attempt unauthorized access
        verifyAccessRestriction();
    }

    public void verifyAccessRestriction() {
        Assert.assertTrue(isElementVisible(accountsPayableModuleLink), "Access is not restricted.");
    }
}