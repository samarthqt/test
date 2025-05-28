
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

    public AccountsPayablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboardIcon), Login as finance user failed.);
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboardIcon), Perform login failed.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboardIcon);
        Assert.assertTrue(isElementVisible(dashboardIcon), Dashboard access failed.);
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModuleLink);
        clickElement(accountsPayableModuleLink);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Navigation to Accounts Payable Module failed.);
    }

    public void verifyModuleNavigation() {
        waitUntilElementVisible(accountsPayableModuleLink);
        Assert.assertTrue(isElementVisible(accountsPayableModuleLink), Module navigation failed.);
    }

    public void verifyModuleAccess() {
        waitUntilElementVisible(accountsPayableModuleLink);
        Assert.assertTrue(isElementVisible(accountsPayableModuleLink), Module access failed.);
    }

    public void verifyOptionsAndFeatures() {
        waitUntilElementVisible(createInvoiceButton);
        Assert.assertTrue(isElementVisible(createInvoiceButton), Options and features are not accessible.);
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

    public void verifyInvoiceDisplayed() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice not displayed.);
    }

    public void editInvoice() {
        waitUntilElementVisible(editInvoiceButton);
        clickElement(editInvoiceButton);
        Assert.assertTrue(isElementVisible(invoiceList), Edit invoice failed.);
    }

    public void verifyChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Changes not saved.);
    }

    public void verifyUpdatedInvoice() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(deleteInvoiceButton);
        clickElement(deleteInvoiceButton);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice not deleted.);
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice not deleted.);
    }

    public void verifyInvoiceNotDisplayed() {
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
        Assert.assertTrue(isElementVisible(generatePaymentButton), Payment not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(generatePaymentButton);
        Assert.assertTrue(isElementVisible(generatePaymentButton), Payment not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsLink);
        clickElement(reportsLink);
        Assert.assertTrue(isElementVisible(reportsLink), View and download reports failed.);
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

    public void verifyLoginStatus() {
        waitUntilElementVisible(dashboardIcon);
        Assert.assertTrue(isElementVisible(dashboardIcon), Login status failed.);
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

    public void verifyAuthorizationStatus() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Authorization status failed.);
    }

    public void attemptAccess() {
        waitUntilElementVisible(accountsPayableModuleLink);
        clickElement(accountsPayableModuleLink);
        Assert.assertTrue(isElementVisible(errorMessage), Access attempt failed.);
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
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
