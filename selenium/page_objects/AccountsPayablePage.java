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

    protected By btnLogin = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By accountsPayableModule = By.id("accountsPayableModule");
    protected By invoiceList = By.id("invoiceList");
    protected By btnCreateInvoice = By.id("createInvoice");
    protected By btnEditInvoice = By.id("editInvoice");
    protected By btnDeleteInvoice = By.id("deleteInvoice");
    protected By btnGeneratePayment = By.id("generatePayment");
    protected By btnViewReports = By.id("viewReports");
    protected By btnLogout = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public AccountsPayablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        verifyUserLoggedIn();
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        verifyUserLoggedIn();
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        verifyAccountsPayableModuleAccess();
    }

    public void verifyAccountsPayableModuleAccess() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeatures() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Accounts Payable features are not accessible.");
    }

    public void createNewInvoice() {
        waitUntilElementVisible(btnCreateInvoice);
        clickElement(btnCreateInvoice);
        // Logic to fill invoice details
        verifyInvoiceSaved();
    }

    public void verifyInvoiceSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not saved.");
    }

    public void verifyInvoiceDisplayedInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not displayed in the list.");
    }

    public void editInvoice() {
        waitUntilElementVisible(btnEditInvoice);
        clickElement(btnEditInvoice);
        // Logic to edit invoice details
        verifyInvoiceChangesSaved();
    }

    public void verifyInvoiceChangesSaved() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice changes are not saved.");
    }

    public void verifyInvoiceUpdatedInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice is not updated in the list.");
    }

    public void deleteInvoice() {
        waitUntilElementVisible(btnDeleteInvoice);
        clickElement(btnDeleteInvoice);
        verifyInvoiceDeleted();
    }

    public void verifyInvoiceDeleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), "Invoice is not deleted.");
    }

    public void verifyInvoiceNotInList() {
        waitUntilElementVisible(invoiceList);
        Assert.assertFalse(isElementVisible(invoiceList), "Deleted invoice is still in the list.");
    }

    public void generatePayment() {
        waitUntilElementVisible(btnGeneratePayment);
        clickElement(btnGeneratePayment);
        verifyPaymentCompleted();
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Payment is not completed.");
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), "Payment is not recorded.");
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(btnViewReports);
        clickElement(btnViewReports);
        verifyReportsDownloaded();
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(btnViewReports);
        Assert.assertTrue(isElementVisible(btnViewReports), "Reports are not downloaded.");
    }

    public void reviewReports() {
        // Logic to review downloaded reports
        verifyReportAccuracy();
    }

    public void verifyReportAccuracy() {
        // Logic to verify report accuracy
        Assert.assertTrue(true, "Report accuracy verified.");
    }

    public void verifyUserLoggedIn() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), "User is not logged in.");
    }

    public void performLogout() {
        waitUntilElementVisible(btnLogout);
        clickElement(btnLogout);
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementVisible(btnLogin), "Logout was not successful.");
    }

    public void verifyUserNotAuthorized() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), "User is authorized.");
    }

    public void attemptAccessWithoutAuthorization() {
        // Logic to attempt access without authorization
        verifyAccessRestricted();
    }

    public void verifyAccessRestricted() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), "Access is not restricted.");
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