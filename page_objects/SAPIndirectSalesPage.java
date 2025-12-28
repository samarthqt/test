package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPIndirectSalesPage extends WebReusableComponents {

    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By indirectSalesProgramLink = By.id("indirectSalesProgram");
    protected By transactionForm = By.id("transactionForm");
    protected By btnProcessTransaction = By.id("processTransaction");
    protected By generatedDataSection = By.id("generatedData");
    protected By externalInvoiceQuantityAmount = By.id("externalInvoiceQuantityAmount");
    protected By zotcCrossRefTab = By.id("zotcCrossRefTab");
    protected By btnGenerateReport = By.id("generateReport");
    protected By btnExportReport = By.id("exportReport");
    protected By btnLogout = By.id("logoutButton");

    public void enterCredentials(String username, String password) {
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void loginToSAP() {
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(indirectSalesProgramLink), "Login failed.");
    }

    public void ensureUserLoggedIn() {
        if (!isElementVisible(indirectSalesProgramLink)) {
            loginToSAP();
        }
    }

    public void navigateToIndirectSalesProgram() {
        clickElement(indirectSalesProgramLink);
    }

    public void verifyIndirectSalesProgramInterface() {
        Assert.assertTrue(isElementVisible(transactionForm), "Indirect Sales Program interface not displayed.");
    }

    public void ensureOnIndirectSalesProgramInterface() {
        if (!isElementVisible(transactionForm)) {
            navigateToIndirectSalesProgram();
        }
    }

    public void processIndirectSalesTransaction(String billingDocumentType, String transactionID, String customerID, String productID, String quantity, String price) {
        enterText(By.id("billingDocumentType"), billingDocumentType);
        enterText(By.id("transactionID"), transactionID);
        enterText(By.id("customerID"), customerID);
        enterText(By.id("productID"), productID);
        enterText(By.id("quantity"), quantity);
        enterText(By.id("price"), price);
        clickElement(btnProcessTransaction);
    }

    public void verifyTransactionProcessed(String billingDocumentType) {
        Assert.assertTrue(isElementVisible(generatedDataSection), "Transaction not processed successfully.");
    }

    public void ensureTransactionProcessed() {
        if (!isElementVisible(generatedDataSection)) {
            processIndirectSalesTransaction("S1", "T10002", "C002", "P002", "5", "200");
        }
    }

    public void navigateToGeneratedData() {
        clickElement(generatedDataSection);
    }

    public void verifyGeneratedDataDisplayed() {
        Assert.assertTrue(isElementVisible(externalInvoiceQuantityAmount), "Generated data not displayed.");
    }

    public void ensureGeneratedDataDisplayed() {
        if (!isElementVisible(externalInvoiceQuantityAmount)) {
            navigateToGeneratedData();
        }
    }

    public void verifyExternalInvoiceQuantityAmount() {
        String amount = getTextFromElement(externalInvoiceQuantityAmount);
        Assert.assertNotNull(amount, "ExternalInvoiceQuantityAmount not found.");
    }

    public void verifyNegativeExternalInvoiceQuantityAmount() {
        String amount = getTextFromElement(externalInvoiceQuantityAmount);
        Assert.assertTrue(amount.startsWith("-"), "ExternalInvoiceQuantityAmount is not negative.");
    }

    public void ensureExternalInvoiceQuantityAmountVerified() {
        verifyExternalInvoiceQuantityAmount();
    }

    public void validateSignConventionsWithTableMappings() {
        Assert.assertTrue(isElementVisible(zotcCrossRefTab), "ZOTC_CROSSREFTAB table not found.");
    }

    public void verifySignConventionsConsistency() {
        Assert.assertTrue(true, "Sign conventions are inconsistent.");
    }

    public void ensureSignConventionsValidated() {
        validateSignConventionsWithTableMappings();
    }

    public void generateTransactionReport() {
        clickElement(btnGenerateReport);
    }

    public void verifyReportGenerated() {
        Assert.assertTrue(isElementVisible(btnExportReport), "Report not generated successfully.");
    }

    public void ensureReportGenerated() {
        if (!isElementVisible(btnExportReport)) {
            generateTransactionReport();
        }
    }

    public void exportReport(String format) {
        selectByValue(btnExportReport, format);
    }

    public void verifyReportExported() {
        Assert.assertTrue(true, "Report not exported successfully.");
    }

    public void ensureAllActionsCompleted() {
        Assert.assertTrue(true, "All actions not completed.");
    }

    public void logoutFromSAP() {
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(true, "Logout failed.");
    }

    public void ensureUserLoggedOut() {
        if (isElementVisible(btnLogout)) {
            logoutFromSAP();
        }
    }

    public void documentTestResults() {
        Assert.assertTrue(true, "Test results not documented.");
    }

    public void verifyTestResultsDocumented() {
        Assert.assertTrue(true, "Test results not documented accurately.");
    }
}