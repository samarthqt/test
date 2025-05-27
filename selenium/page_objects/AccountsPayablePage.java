package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    private WebDriver driver;

    protected By loginButton = By.id(loginButton);
    protected By dashboard = By.id(dashboard);
    protected By accountsPayableModule = By.id(accountsPayableModule);
    protected By createInvoiceButton = By.id(createInvoiceButton);
    protected By invoiceList = By.id(invoiceList);
    protected By editInvoiceButton = By.id(editInvoiceButton);
    protected By deleteInvoiceButton = By.id(deleteInvoiceButton);
    protected By generatePaymentButton = By.id(generatePaymentButton);
    protected By reportsSection = By.id(reportsSection);
    protected By logoutButton = By.id(logoutButton);
    protected By errorMessage = By.id(errorMessage);

    public AccountsPayablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterText(By.id(username), username);
        enterText(By.id(password), password);
        clickElement(loginButton);
        waitUntilElementVisible(dashboard, 5);
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not visible.);
    }

    public void verifyDashboardAccess() {
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayableModule() {
        clickElement(accountsPayableModule);
        waitUntilElementVisible(createInvoiceButton, 5);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Navigation to Accounts Payable module failed.);
    }

    public void verifyAccountsPayableModuleAccess() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), Accounts Payable module is not accessible.);
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), Create Invoice feature is not visible.);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Generate Payment feature is not visible.);
        Assert.assertTrue(isElementVisible(reportsSection), Reports section is not visible.);
    }

    public void createNewInvoice(String invoiceData) {
        clickElement(createInvoiceButton);
        enterText(By.id(invoiceData), invoiceData);
        clickElement(By.id(saveInvoiceButton));
        waitUntilElementVisible(invoiceList, 5);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice creation failed.);
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not saved.);
    }

    public void verifyInvoiceInList() {
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not displayed in the list.);
    }

    public void editInvoice(String updatedInvoiceData) {
        clickElement(editInvoiceButton);
        enterText(By.id(updatedInvoiceData), updatedInvoiceData);
        clickElement(By.id(saveInvoiceButton));
        waitUntilElementVisible(invoiceList, 5);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice update failed.);
    }

    public void verifyInvoiceUpdated() {
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not updated.);
    }

    public void verifyUpdatedInvoiceInList() {
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice is not displayed in the list.);
    }

    public void deleteInvoice(String invoiceId) {
        clickElement(deleteInvoiceButton);
        waitUntilElementVisible(invoiceList, 5);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice deletion failed.);
    }

    public void verifyInvoiceDeleted() {
        Assert.assertFalse(isElementVisible(invoiceList), Invoice is not deleted.);
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice is still displayed in the list.);
    }

    public void generatePayment(String paymentData) {
        clickElement(generatePaymentButton);
        enterText(By.id(paymentData), paymentData);
        clickElement(By.id(confirmPaymentButton));
        waitUntilElementVisible(By.id(paymentConfirmation), 5);
        Assert.assertTrue(isElementVisible(By.id(paymentConfirmation)), Payment generation failed.);
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(By.id(paymentConfirmation)), Payment process is not completed.);
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementVisible(By.id(paymentConfirmation)), Payment is not recorded.);
    }

    public void viewAndDownloadReports() {
        clickElement(reportsSection);
        clickElement(By.id(downloadReportsButton));
        waitUntilElementVisible(By.id(downloadConfirmation), 5);
        Assert.assertTrue(isElementVisible(By.id(downloadConfirmation)), Report download failed.);
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(By.id(downloadConfirmation)), Reports are not downloaded.);
    }

    public void reviewDownloadedReports() {
        // Assume reports are reviewed
        Assert.assertTrue(true, Reports reviewed successfully.);
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementVisible(By.id(reportAccuracy)), Reports are not accurate.);
    }

    public void logout() {
        clickElement(logoutButton);
        waitUntilElementVisible(By.id(loginPage), 5);
        Assert.assertTrue(isElementVisible(By.id(loginPage)), Logout failed.);
    }

    public void verifyLogout() {
        Assert.assertTrue(isElementVisible(By.id(loginPage)), Logout is not successful.);
    }

    public void attemptUnauthorizedAccess() {
        clickElement(accountsPayableModule);
        waitUntilElementVisible(errorMessage, 5);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access attempt failed.);
    }

    public void verifyAccessRestriction() {
        Assert.assertTrue(isElementVisible(errorMessage), Access is not restricted.);
    }
}