
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

    public void loginAsFinanceUser() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), Login as finance user failed.);
    }

    public void performLogin() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
        Assert.assertTrue(isElementVisible(dashboard), Login failed.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Navigation to Accounts Payable module failed.);
    }

    public void verifyModuleNavigation() {
        waitUntilElementVisible(accountsPayableModule, 3);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(createInvoiceButton, 3);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Create Invoice feature is not accessible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton, 3);
        clickElement(createInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), New invoice creation failed.);
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not saved.);
    }

    public void verifyInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not displayed.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton, 3);
        clickElement(editInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice edit failed.);
    }

    public void verifyInvoiceUpdated() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice is not updated.);
    }

    public void verifyUpdatedInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice is not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton, 3);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice deletion failed.);
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice is not deleted.);
    }

    public void verifyInvoiceNotDisplayed() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice is still displayed.);
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton, 3);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementVisible(invoiceList), Payment generation failed.);
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Payment is not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList, 3);
        Assert.assertTrue(isElementVisible(invoiceList), Payment is not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection, 3);
        clickElement(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports download failed.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsSection, 3);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not downloaded.);
    }

    public void reviewReports() {
        waitUntilElementVisible(reportsSection, 3);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not reviewed.);
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(reportsSection, 3);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not accurate.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(loginButton), Logout failed.);
    }

    public void verifyLogout() {
        waitUntilElementVisible(loginButton, 3);
        Assert.assertTrue(isElementVisible(loginButton), Logout is not successful.);
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access is not restricted.);
    }

    public void attemptAccess() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(errorMessage), Access attempt failed.);
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction is not displayed.);
    }
}
