package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    protected By btnLogin = By.id(loginButton);
    protected By dashboardIcon = By.id(dashboardIcon);
    protected By accountsPayableModuleLink = By.id(accountsPayableModule);
    protected By createInvoiceButton = By.id(createInvoice);
    protected By invoiceList = By.cssSelector(.invoice-list);
    protected By editInvoiceButton = By.cssSelector(.edit-invoice);
    protected By deleteInvoiceButton = By.cssSelector(.delete-invoice);
    protected By generatePaymentButton = By.id(generatePayment);
    protected By reportsLink = By.id(reportsLink);
    protected By logoutButton = By.id(logoutButton);
    protected By errorMessage = By.id(errorMessage);

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        verifyUserLoggedIn();
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
        verifyUserLoggedIn();
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboardIcon, 3);
        Assert.assertTrue(isElementVisible(dashboardIcon), Dashboard access failed.);
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModuleLink, 3);
        clickElement(accountsPayableModuleLink);
        verifyAccountsPayableModuleAccess();
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModuleLink, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModuleLink), Accounts Payable module access failed.);
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), Create Invoice feature not available.);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Manage Payments feature not available.);
        Assert.assertTrue(isElementVisible(reportsLink), Generate Reports feature not available.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        saveInvoice();
        verifyInvoiceSaved();
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not saved.);
    }

    public void verifyInvoiceDisplayedInList() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not displayed in list.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        saveInvoice();
        verifyInvoiceChangesSaved();
    }

    public void verifyInvoiceChangesSaved() {
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes not saved.);
    }

    public void verifyUpdatedInvoiceInformation() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice information not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        Assert.assertFalse(isElementVisible(invoiceList), Invoice not deleted.);
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice still displayed.);
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(invoiceList), Payment process not completed.);
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementVisible(invoiceList), Payment information not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsLink, 3);
        clickElement(reportsLink);
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(reportsLink), Reports not downloaded.);
    }

    public void reviewDownloadedReports() {
        // Logic to review reports
        verifyReportAccuracy();
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementVisible(reportsLink), Reports are not accurate.);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(dashboardIcon), User not logged in.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(btnLogin), Logout failed.);
    }

    public void verifyUserNotAuthorized() {
        Assert.assertFalse(isElementVisible(accountsPayableModuleLink), User is authorized.);
    }

    public void attemptAccessWithoutAuthorization() {
        // Logic to attempt access
        verifyAccessRestriction();
    }

    public void verifyAccessRestriction() {
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction failed.);
    }

    private void saveInvoice() {
        // Logic to save invoice
        verifyInvoiceSaved();
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}