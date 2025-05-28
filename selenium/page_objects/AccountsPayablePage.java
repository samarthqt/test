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
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(loginButton);
        clickElement(loginButton);
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton);
        clickElement(loginButton);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), Create Invoice feature is not visible.);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Generate Payment feature is not visible.);
        Assert.assertTrue(isElementVisible(reportsSection), Reports section is not visible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton);
        clickElement(createInvoiceButton);
        // Add logic to fill invoice details
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not saved.);
    }

    public void verifyInvoiceDisplayedInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not displayed in the list.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton);
        clickElement(editInvoiceButton);
        // Add logic to edit invoice details
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes are not saved.);
    }

    public void verifyUpdatedInvoiceDetails() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice details are not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton);
        clickElement(deleteInvoiceButton);
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
        // Add logic to generate payment
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment process is not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Payment information is not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection);
        clickElement(reportsSection);
        // Add logic to view and download reports
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not downloaded.);
    }

    public void reviewReports() {
        // Add logic to review downloaded reports
    }

    public void verifyReportAccuracy() {
        // Add logic to verify report accuracy
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(loginButton);
        Assert.assertTrue(isElementVisible(loginButton), Logout was not successful.);
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access is not restricted.);
    }

    public void attemptUnauthorizedAccess() {
        // Add logic to attempt unauthorized access
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction message is not displayed.);
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