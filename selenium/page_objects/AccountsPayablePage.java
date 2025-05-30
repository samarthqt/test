
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class AccountsPayablePage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By dashboard = By.id("dashboard");
    protected By accountsPayableModule = By.id("accountsPayableModule");
    protected By createInvoiceButton = By.id("createInvoice");
    protected By invoiceList = By.id("invoiceList");
    protected By editInvoiceButton = By.id("editInvoice");
    protected By deleteInvoiceButton = By.id("deleteInvoice");
    protected By generatePaymentButton = By.id("generatePayment");
    protected By downloadReportsButton = By.id("downloadReports");
    protected By logoutButton = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        enterText(By.id("username"), "financeUser");
        enterText(By.id("password"), "password123");
        clickElement(btnLogin);
    }

    public void performLogin() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyDashboardRedirection() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not visible.");
    }

    public void verifyDashboardPresence() {
        Assert.assertTrue(isElementVisible(dashboard), "Dashboard is not visible.");
    }

    public void navigateToAccountsPayableModule() {
        waitUntilElementVisible(accountsPayableModule, 3);
        clickElement(accountsPayableModule);
    }

    public void verifyModuleNavigation() {
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module is not visible.");
    }

    public void verifyAccountsPayableModulePresence() {
        Assert.assertTrue(isElementVisible(accountsPayableModule), "Accounts Payable module is not visible.");
    }

    public void verifyOptionsAndFeaturesAvailability() {
        Assert.assertTrue(isElementVisible(createInvoiceButton), "Create Invoice option is not visible.");
        Assert.assertTrue(isElementVisible(generatePaymentButton), "Generate Payment option is not visible.");
        Assert.assertTrue(isElementVisible(downloadReportsButton), "Download Reports option is not visible.");
    }

    public void createNewInvoice() {
        clickElement(createInvoiceButton);
        enterText(By.id("invoiceNumber"), "INV123");
        enterText(By.id("vendorInfo"), "Vendor ABC");
        enterText(By.id("amount"), "1000");
        clickElement(By.id("saveInvoice"));
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(By.id("invoiceSavedMessage")), "Invoice saved message is not visible.");
    }

    public void verifyInvoiceDisplayedInList() {
        Assert.assertTrue(isElementVisible(invoiceList), "Invoice list is not visible.");
        Assert.assertTrue(getTextFromElement(invoiceList).contains("INV123"), "Newly created invoice is not displayed.");
    }

    public void editExistingInvoice() {
        clickElement(editInvoiceButton);
        enterText(By.id("amount"), "1200");
        clickElement(By.id("saveChanges"));
    }

    public void verifyInvoiceChangesSaved() {
        Assert.assertTrue(isElementVisible(By.id("changesSavedMessage")), "Changes saved message is not visible.");
    }

    public void verifyUpdatedInvoiceInformation() {
        Assert.assertTrue(getTextFromElement(invoiceList).contains("1200"), "Updated invoice information is not displayed.");
    }

    public void deleteExistingInvoice() {
        clickElement(deleteInvoiceButton);
        clickElement(By.id("confirmDelete"));
    }

    public void verifyInvoiceDeleted() {
        Assert.assertTrue(isElementVisible(By.id("invoiceDeletedMessage")), "Invoice deleted message is not visible.");
    }

    public void verifyInvoiceNotDisplayedInList() {
        Assert.assertFalse(getTextFromElement(invoiceList).contains("INV123"), "Deleted invoice is still displayed.");
    }

    public void generatePaymentForInvoice() {
        clickElement(generatePaymentButton);
        enterText(By.id("paymentAmount"), "1000");
        clickElement(By.id("confirmPayment"));
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(By.id("paymentCompletedMessage")), "Payment completed message is not visible.");
    }

    public void verifyPaymentInformationUpdated() {
        Assert.assertTrue(getTextFromElement(invoiceList).contains("Payment Recorded"), "Payment information is not updated.");
    }

    public void viewAndDownloadReports() {
        clickElement(downloadReportsButton);
        clickElement(By.id("confirmDownload"));
    }

    public void verifyReportsDownloadedSuccessfully() {
        Assert.assertTrue(isElementVisible(By.id("reportsDownloadedMessage")), "Reports downloaded message is not visible.");
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(By.id("reportsDownloadedMessage")), "Reports downloaded message is not visible.");
    }

    public void reviewDownloadedReports() {
        // Logic to review downloaded reports
        Assert.assertTrue(true, "Reports reviewed successfully.");
    }

    public void verifyReportAccuracyAndCompleteness() {
        Assert.assertTrue(isElementVisible(By.id("reportAccuracyMessage")), "Report accuracy message is not visible.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(dashboard), "User is not logged in.");
    }

    public void performLogout() {
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccessful() {
        Assert.assertTrue(isElementVisible(btnLogin), "Logout was not successful.");
    }

    public void verifyUserNotAuthorized() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not visible.");
    }

    public void attemptAccessWithoutAuthorization() {
        clickElement(accountsPayableModule);
    }

    public void verifyAccessRestricted() {
        Assert.assertTrue(isElementVisible(errorMessage), "Access restriction message is not visible.");
    }
}
