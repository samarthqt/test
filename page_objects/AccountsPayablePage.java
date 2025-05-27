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
    protected By btnCreateInvoice = By.id(createInvoice);
    protected By invoiceList = By.id(invoiceList);
    protected By btnEditInvoice = By.id(editInvoice);
    protected By btnDeleteInvoice = By.id(deleteInvoice);
    protected By btnGeneratePayment = By.id(generatePayment);
    protected By btnViewReports = By.id(viewReports);
    protected By btnLogout = By.id(logoutButton);
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
        Assert.assertTrue(isElementVisible(accountsPayableModule), Navigation to Accounts Payable failed.);
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(btnCreateInvoice);
        Assert.assertTrue(isElementVisible(btnCreateInvoice), Create Invoice feature is not accessible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(btnCreateInvoice);
        clickElement(btnCreateInvoice);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice creation failed.);
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
        waitUntilElementVisible(btnEditInvoice);
        clickElement(btnEditInvoice);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice edit failed.);
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Invoice changes are not saved.);
    }

    public void verifyUpdatedInvoiceInformation() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Updated invoice information is not displayed.);
    }

    public void deleteInvoice() {
        waitUntilElementVisible(btnDeleteInvoice);
        clickElement(btnDeleteInvoice);
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
        waitUntilElementVisible(btnGeneratePayment);
        clickElement(btnGeneratePayment);
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
        waitUntilElementVisible(btnViewReports);
        clickElement(btnViewReports);
        Assert.assertTrue(isElementVisible(btnViewReports), Reports view/download failed.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(btnViewReports);
        Assert.assertTrue(isElementVisible(btnViewReports), Reports are not downloaded.);
    }

    public void reviewReports() {
        waitUntilElementVisible(btnViewReports);
        Assert.assertTrue(isElementVisible(btnViewReports), Reports are not reviewed.);
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(btnViewReports);
        Assert.assertTrue(isElementVisible(btnViewReports), Reports are not accurate.);
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout);
        clickElement(btnLogout);
        Assert.assertTrue(isElementVisible(btnLogin), Logout failed.);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), Logout is not successful.);
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access is not restricted.);
    }

    public void attemptAccessAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction is not displayed.);
    }

    public void verifyAccessRestriction() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Access restriction is not displayed.);
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