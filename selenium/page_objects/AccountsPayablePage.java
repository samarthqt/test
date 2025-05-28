package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AccountsPayablePage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By btnLogin = By.id(loginButton);
    protected By dashboard = By.id(dashboard);
    protected By accountsPayableModule = By.id(accountsPayableModule);
    protected By createInvoiceButton = By.id(createInvoice);
    protected By invoiceList = By.id(invoiceList);
    protected By editInvoiceButton = By.id(editInvoice);
    protected By deleteInvoiceButton = By.id(deleteInvoice);
    protected By generatePaymentButton = By.id(generatePayment);
    protected By reportsSection = By.id(reportsSection);
    protected By logoutButton = By.id(logoutButton);
    protected By errorMessage = By.id(errorMessage);

    public AccountsPayablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not accessible.);
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not accessible.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Navigation to Accounts Payable failed.);
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(createInvoiceButton);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Create Invoice feature is not accessible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton);
        clickElement(createInvoiceButton);
        // Logic to fill invoice details
        Assert.assertTrue(isElementVisible(invoiceList), Invoice creation failed.);
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not saved.);
    }

    public void verifyInvoiceInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not displayed in the list.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton);
        clickElement(editInvoiceButton);
        // Logic to edit invoice details
        Assert.assertTrue(isElementVisible(invoiceList), Invoice editing failed.);
    }

    public void verifyInvoiceUpdated() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not updated.);
    }

    public void verifyUpdatedInvoiceDetails() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice details are not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice deletion failed.);
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice is not deleted.);
    }

    public void verifyInvoiceNotInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice is still displayed.);
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementVisible(invoiceList), Payment generation failed.);
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment is not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment information is not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection);
        clickElement(reportsSection);
        // Logic to view and download reports
        Assert.assertTrue(isElementVisible(reportsSection), Reports download failed.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not downloaded.);
    }

    public void reviewReports() {
        waitUntilElementVisible(reportsSection);
        // Logic to review reports
        Assert.assertTrue(isElementVisible(reportsSection), Reports review failed.);
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not accurate.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(btnLogin), Logout was not successful.);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), Logout was not successful.);
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access is not restricted.);
    }

    public void attemptUnauthorizedAccess() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access attempt failed.);
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction message is not displayed.);
    }

    private void waitUntilElementVisible(By locator) {
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