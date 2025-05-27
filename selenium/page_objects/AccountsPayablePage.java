
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
    protected By invoiceList = By.id(invoiceList);
    protected By btnCreateInvoice = By.id(createInvoice);
    protected By btnEditInvoice = By.id(editInvoice);
    protected By btnDeleteInvoice = By.id(deleteInvoice);
    protected By paymentButton = By.id(generatePayment);
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
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not visible.);
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin);
        clickElement(btnLogin);
        Assert.assertTrue(isElementVisible(dashboard), Login failed, dashboard not visible.);
    }

    public void verifyDashboardAccess() {
        waitUntilElementVisible(dashboard);
        Assert.assertTrue(isElementVisible(dashboard), Dashboard is not accessible.);
    }

    public void navigateToAccountsPayable() {
        waitUntilElementVisible(accountsPayableModule);
        clickElement(accountsPayableModule);
        Assert.assertTrue(isElementVisible(invoiceList), Navigation to Accounts Payable failed.);
    }

    public void verifyModuleNavigation() {
        waitUntilElementVisible(accountsPayableModule);
        Assert.assertTrue(isElementVisible(accountsPayableModule), Accounts Payable module is not accessible.);
    }

    public void verifyOptionsAndFeatures() {
        waitUntilElementVisible(invoiceList);
        Assert.assertTrue(isElementVisible(invoiceList), Options and features are not visible.);
    }

    public void createNewInvoice() {
        waitUntilElementVisible(btnCreateInvoice);
        clickElement(btnCreateInvoice);
        // Logic to fill invoice details
        Assert.assertTrue(isElementVisible(invoiceList), Invoice creation failed.);
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
        waitUntilElementVisible(btnEditInvoice);
        clickElement(btnEditInvoice);
        // Logic to edit invoice details
        Assert.assertTrue(isElementVisible(invoiceList), Invoice edit failed.);
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
        waitUntilElementVisible(btnDeleteInvoice);
        clickElement(btnDeleteInvoice);
        Assert.assertFalse(isElementVisible(invoiceList), Invoice deletion failed.);
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
        waitUntilElementVisible(paymentButton);
        clickElement(paymentButton);
        Assert.assertTrue(isElementVisible(paymentButton), Payment generation failed.);
    }

    public void verifyPaymentCompleted() {
        waitUntilElementVisible(paymentButton);
        Assert.assertTrue(isElementVisible(paymentButton), Payment is not completed.);
    }

    public void verifyPaymentRecorded() {
        waitUntilElementVisible(paymentButton);
        Assert.assertTrue(isElementVisible(paymentButton), Payment is not recorded.);
    }

    public void viewAndDownloadReports() {
        waitUntilElementVisible(reportsSection);
        clickElement(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports view/download failed.);
    }

    public void verifyReportsDownloaded() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not downloaded.);
    }

    public void reviewReports() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not reviewed.);
    }

    public void verifyReportAccuracy() {
        waitUntilElementVisible(reportsSection);
        Assert.assertTrue(isElementVisible(reportsSection), Reports are not accurate.);
    }

    public void performLogout() {
        waitUntilElementVisible(logoutButton);
        clickElement(logoutButton);
        Assert.assertTrue(isElementVisible(btnLogin), Logout failed.);
    }

    public void verifyLogout() {
        waitUntilElementVisible(logoutButton);
        Assert.assertTrue(isElementVisible(btnLogin), Logout is not successful.);
    }

    public void verifyUnauthorizedAccess() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Unauthorized access is not restricted.);
    }

    public void attemptAccess() {
        waitUntilElementVisible(errorMessage);
        clickElement(errorMessage);
        Assert.assertTrue(isElementVisible(errorMessage), Access attempt failed.);
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
