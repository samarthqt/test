
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
    protected By dashboardLink = By.id(dashboardLink);
    protected By accountsPayableLink = By.id(accountsPayableLink);
    protected By createInvoiceButton = By.id(createInvoiceButton);
    protected By invoiceList = By.id(invoiceList);
    protected By editInvoiceButton = By.id(editInvoiceButton);
    protected By deleteInvoiceButton = By.id(deleteInvoiceButton);
    protected By generatePaymentButton = By.id(generatePaymentButton);
    protected By reportsLink = By.id(reportsLink);
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
        Assert.assertTrue(isElementVisible(dashboardLink), Login as finance user failed.);
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboardLink), Login failed.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboardLink);
        Assert.assertTrue(isElementVisible(dashboardLink), Dashboard access failed.);
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableLink);
        clickElement(accountsPayableLink);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Navigation to Accounts Payable failed.);
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableLink);
        Assert.assertTrue(isElementVisible(accountsPayableLink), Accounts Payable module access failed.);
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(createInvoiceButton);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Accounts Payable features not accessible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(createInvoiceButton);
        clickElement(createInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), New invoice creation failed.);
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not saved.);
    }

    public void verifyInvoiceInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not displayed in list.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton);
        clickElement(editInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice edit failed.);
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes not saved.);
    }

    public void verifyUpdatedInvoiceDetails() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice details not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice deletion failed.);
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice not deleted.);
    }

    public void verifyInvoiceNotInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Deleted invoice still displayed.);
    }

    public void generatePayment() {
        waitUntilElementVisible(generatePaymentButton);
        clickElement(generatePaymentButton);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Payment generation failed.);
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(generatePaymentButton);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Payment process not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(generatePaymentButton);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Payment not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsLink);
        clickElement(reportsLink);
        Assert.assertTrue(isElementVisible(reportsLink), Reports download failed.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsLink);
        Assert.assertTrue(isElementVisible(reportsLink), Reports not downloaded.);
    }

    public void reviewReports() {
        waitUntilElementVisible(reportsLink);
        Assert.assertTrue(isElementVisible(reportsLink), Reports review failed.);
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(reportsLink);
        Assert.assertTrue(isElementVisible(reportsLink), Report accuracy failed.);
    }

    public void verifyUserLoggedIn() {
        waitUntilElementVisible(logoutButton);
        Assert.assertTrue(isElementVisible(logoutButton), User not logged in.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(btnLogin), Logout failed.);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), Logout success verification failed.);
    }

    public void verifyUserNotAuthorized() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), User authorization check failed.);
    }

    public void attemptUnauthorizedAccess() {
        waitUntilElementVisible(accountsPayableLink);
        clickElement(accountsPayableLink);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access attempt failed.);
    }

    public void verifyAccessRestricted() {
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
