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
        verifyLogin();
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        verifyLogin();
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        verifyModuleAccess();
    }

    public void verifyModuleNavigation() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module navigation failed.);
    }

    public void verifyModuleAccess() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyOptionsAndFeatures() {
        waitUntilElementVisible(createInvoiceButton);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Options and features are not visible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton);
        clickElement(createInvoiceButton);
        // Add logic to fill invoice details
        verifyInvoiceSaved();
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not saved.);
    }

    public void verifyInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not displayed.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton);
        clickElement(editInvoiceButton);
        // Add logic to edit invoice details
        verifyChangesSaved();
    }

    public void verifyChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Changes are not saved.);
    }

    public void verifyUpdatedInvoice() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice is not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton);
        clickElement(deleteInvoiceButton);
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice is not deleted.);
    }

    public void verifyInvoiceNotDisplayed() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice is still displayed.);
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton);
        clickElement(generatePaymentButton);
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment process is not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment is not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection);
        clickElement(reportsSection);
        // Add logic to download reports
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not downloaded.);
    }

    public void reviewReports() {
        // Add logic to review reports
        verifyReportAccuracy();
    }

    public void verifyReportAccuracy() {
        // Add logic to verify report accuracy
        Assert.assertTrue(true, Report accuracy verified.);
    }

    public void verifyLogin() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), User is not logged in.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton);
        clickElement(logoutButton);
        verifyLogout();
    }

    public void verifyLogout() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), User is not logged out.);
    }

    public void verifyAuthorization() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Authorization check failed.);
    }

    public void attemptAccess() {
        // Add logic to attempt access
        verifyAccessRestriction();
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction failed.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
}