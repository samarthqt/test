package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.*;

public class AccountsPayablePage extends WebReusableComponents {

    public AccountsPayablePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsFinanceUser() {
        enterText(By.id("username"), "financeUser");
        enterText(By.id("password"), "password123");
        clickElement(By.id("loginButton"));
    }

    public void performLogin() {
        clickElement(By.id("loginButton"));
    }

    public void verifyDashboardAccess() {
        Assert.assertTrue(isElementVisible(By.id("dashboard")), "Dashboard is not accessible.");
    }

    public void navigateToAccountsPayable() {
        clickElement(By.id("accountsPayableModule"));
    }

    public void verifyAccountsPayableAccess() {
        Assert.assertTrue(isElementVisible(By.id("accountsPayable")), "Accounts Payable module is not accessible.");
    }

    public void verifyAccountsPayableFeatures() {
        Assert.assertTrue(isElementVisible(By.id("createInvoice")), "Create Invoice feature is not available.");
        Assert.assertTrue(isElementVisible(By.id("managePayments")), "Manage Payments feature is not available.");
        Assert.assertTrue(isElementVisible(By.id("generateReports")), "Generate Reports feature is not available.");
    }

    public void createNewInvoice() {
        clickElement(By.id("createInvoice"));
        enterText(By.id("invoiceNumber"), "INV12345");
        enterText(By.id("vendorInfo"), "Vendor ABC");
        enterText(By.id("amount"), "1000");
        clickElement(By.id("saveInvoice"));
    }

    public void verifyInvoiceSaved() {
        Assert.assertTrue(isElementVisible(By.id("invoiceSavedMessage")), "Invoice was not saved.");
    }

    public void verifyInvoiceInList() {
        Assert.assertTrue(isElementVisible(By.xpath("//table[@id='invoiceList']//td[contains(text(),'INV12345')]")), "Invoice is not displayed in the list.");
    }

    public void editInvoice() {
        clickElement(By.xpath("//table[@id='invoiceList']//td[contains(text(),'INV12345')]/following-sibling::td/button[@id='editInvoice']"));
        enterText(By.id("amount"), "1200");
        clickElement(By.id("saveInvoice"));
    }

    public void verifyInvoiceUpdated() {
        Assert.assertTrue(isElementVisible(By.id("invoiceUpdatedMessage")), "Invoice was not updated.");
    }

    public void verifyUpdatedInvoiceInList() {
        Assert.assertTrue(isElementVisible(By.xpath("//table[@id='invoiceList']//td[contains(text(),'1200')]")), "Updated invoice is not displayed in the list.");
    }

    public void deleteInvoice() {
        clickElement(By.xpath("//table[@id='invoiceList']//td[contains(text(),'INV12345')]/following-sibling::td/button[@id='deleteInvoice']"));
    }

    public void verifyInvoiceDeleted() {
        Assert.assertTrue(isElementVisible(By.id("invoiceDeletedMessage")), "Invoice was not deleted.");
    }

    public void verifyInvoiceNotInList() {
        Assert.assertFalse(isElementVisible(By.xpath("//table[@id='invoiceList']//td[contains(text(),'INV12345')]")), "Deleted invoice is still displayed in the list.");
    }

    public void generatePayment() {
        clickElement(By.id("generatePayment"));
    }

    public void verifyPaymentCompleted() {
        Assert.assertTrue(isElementVisible(By.id("paymentCompletedMessage")), "Payment process was not completed.");
    }

    public void verifyPaymentRecorded() {
        Assert.assertTrue(isElementVisible(By.xpath("//table[@id='paymentList']//td[contains(text(),'INV12345')]")), "Payment information is not recorded.");
    }

    public void viewAndDownloadReports() {
        clickElement(By.id("viewReports"));
        clickElement(By.id("downloadReports"));
    }

    public void verifyReportsDownloaded() {
        Assert.assertTrue(isElementVisible(By.id("reportsDownloadedMessage")), "Reports were not downloaded.");
    }

    public void reviewReports() {
        // Logic to review downloaded reports
    }

    public void verifyReportAccuracy() {
        Assert.assertTrue(isElementVisible(By.id("reportAccuracyMessage")), "Reports are not accurate.");
    }

    public void performLogout() {
        clickElement(By.id("logoutButton"));
    }

    public void verifyLogout() {
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    public void verifyUnauthorizedAccess() {
        Assert.assertFalse(isElementVisible(By.id("accountsPayable")), "Unauthorized access is allowed.");
    }

    public void attemptUnauthorizedAccess() {
        clickElement(By.id("accountsPayableModule"));
    }

    public void verifyAccessRestriction() {
        Assert.assertTrue(isElementVisible(By.id("accessRestrictedMessage")), "Access restriction message is not displayed.");
    }
}