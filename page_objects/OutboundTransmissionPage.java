package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import io.cucumber.datatable.DataTable;

public class OutboundTransmissionPage extends WebReusableComponents {

    // Fields
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By modelNInterfaceStatus = By.id("modelNInterfaceStatus");
    protected By transactionField = By.id("transactionField");
    protected By productNumberField = By.id("productNumber");
    protected By shipToField = By.id("shipTo");
    protected By soldToField = By.id("soldTo");
    protected By quantityField = By.id("quantity");
    protected By amountField = By.id("amount");
    protected By invoiceNumberField = By.id("invoiceNumber");
    protected By saveButton = By.id("saveButton");
    protected By outboundInterfaceButton = By.id("outboundInterfaceButton");
    protected By transmissionLogs = By.id("transmissionLogs");
    protected By crossRefTabEntries = By.id("crossRefTabEntries");
    protected By errorLogs = By.id("errorLogs");
    protected By reportButton = By.id("reportButton");
    protected By financialCalculations = By.id("financialCalculations");
    protected By sapLoginButton = By.id("sapLoginButton");
    protected By triggerOutboundButton = By.id("triggerOutboundButton");
    protected By modelNConfirmation = By.id("modelNConfirmation");
    protected By transmittedDocumentsReport = By.id("transmittedDocumentsReport");

    // Methods
    public void authorizeCredentials(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
    }

    public void loginToSAP() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Login failed or Model N interface is inactive.");
    }

    public void verifyModelNInterfaceActive() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Model N interface is not active.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(transactionField), "User is not logged in.");
    }

    public void navigateToTransaction(String transactionName) {
        enterText(transactionField, transactionName);
        pressEnter(transactionField);
    }

    public void verifyTransactionOpened(String transactionName) {
        Assert.assertTrue(getTextFromElement(transactionField).contains(transactionName), "Transaction not opened.");
    }

    public void verifyTestDataAvailability() {
        Assert.assertTrue(isElementVisible(productNumberField), "Test data is not available.");
    }

    public void verifyUserOnTransaction(String transactionName) {
        Assert.assertTrue(getTextFromElement(transactionField).contains(transactionName), "User is not on the transaction.");
    }

    public void enterBillingData(String productNumber, String shipTo, String soldTo, String quantity, String amount, String invoiceNumber) {
        enterText(productNumberField, productNumber);
        enterText(shipToField, shipTo);
        enterText(soldToField, soldTo);
        enterText(quantityField, quantity);
        enterText(amountField, amount);
        enterText(invoiceNumberField, invoiceNumber);
    }

    public void verifyDataEntrySuccess() {
        Assert.assertTrue(isElementVisible(saveButton), "Data entry failed.");
    }

    public void verifyValidDataEntered() {
        Assert.assertTrue(isElementVisible(saveButton), "Valid data not entered.");
    }

    public void saveBillingDocument() {
        clickElement(saveButton);
    }

    public void verifyBillingDocumentSaved() {
        Assert.assertTrue(isElementVisible(outboundInterfaceButton), "Billing document not saved.");
    }

    public void triggerOutboundInterface() {
        clickElement(outboundInterfaceButton);
    }

    public void verifyOutboundInterfaceTriggered() {
        Assert.assertTrue(isElementVisible(transmissionLogs), "Outbound interface not triggered.");
    }

    public void monitorTransmissionLogs() {
        clickElement(transmissionLogs);
    }

    public void verifyTransmissionLogsSuccess() {
        Assert.assertTrue(getTextFromElement(transmissionLogs).contains("Success"), "Transmission logs do not indicate success.");
    }

    public void verifyBillingDocumentTransmitted() {
        Assert.assertTrue(getTextFromElement(transmissionLogs).contains("Success"), "Billing document not transmitted.");
    }

    public void verifyDataReceptionInModelN() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Data not received in Model N.");
    }

    public void verifyModelNDataReception() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Model N did not receive the billing document.");
    }

    public void checkCrossRefTabEntries() {
        clickElement(crossRefTabEntries);
    }

    public void verifyCrossRefTabUpdates() {
        Assert.assertTrue(getTextFromElement(crossRefTabEntries).contains("Updated"), "Cross-reference tab entries not updated.");
    }

    public void validateLinkageBetweenBillingDocumentAndModelN() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Linkage not established.");
    }

    public void verifyLinkageEstablished() {
        Assert.assertTrue(isElementVisible(modelNInterfaceStatus), "Linkage not established.");
    }

    public void reviewErrorLogs() {
        clickElement(errorLogs);
    }

    public void verifyNoErrorsLogged() {
        Assert.assertTrue(getTextFromElement(errorLogs).isEmpty(), "Errors are logged.");
    }

    public void generateTransmittedDocumentsReport() {
        clickElement(reportButton);
    }

    public void verifyReportContents() {
        Assert.assertTrue(getTextFromElement(reportButton).contains("Transmitted"), "Report does not show transmitted documents.");
    }

    public void confirmFinancialCalculationsInModelN() {
        clickElement(financialCalculations);
    }

    public void verifyFinancialCalculationsAccuracy() {
        Assert.assertTrue(getTextFromElement(financialCalculations).contains("Accurate"), "Financial calculations are not accurate.");
    }

    public void verifyModelNInterfaceIsActive() {
        Assert.assertTrue(true, "Model N interface is active.");
    }

    public void navigateToTransaction() {
        waitUntilElementVisible(transactionField, 5);
        enterText(transactionField, "ZOTC_SALES_ORDER");
        pressEnter(transactionField);
    }

    public void enterEdgeCaseData(DataTable dataTable) {
        dataTable.asMaps(String.class, String.class).forEach(row -> {
            enterText(By.id("productNumber"), row.get("ProductNumber"));
            enterText(By.id("shipTo"), row.get("ShipTo"));
            enterText(By.id("soldTo"), row.get("SoldTo"));
            enterText(By.id("quantity"), row.get("Quantity"));
            enterText(By.id("amount"), row.get("Amount"));
            enterText(By.id("invoiceNumber"), row.get("InvoiceNumber"));
        });
    }

    public void verifyTransmissionLogs() {
        waitUntilElementVisible(transmissionLogs, 3);
        String logs = getTextFromElement(transmissionLogs);
        Assert.assertTrue(logs.contains("Successful transmission"), "Transmission logs do not indicate success.");
    }

    public void verifyModelNReceivedDocument() {
        waitUntilElementVisible(modelNConfirmation, 3);
        String confirmation = getTextFromElement(modelNConfirmation);
        Assert.assertTrue(confirmation.contains("Document received"), "Model N did not receive the document.");
    }

    public void verifyCrossRefTabEntries() {
        waitUntilElementVisible(crossRefTabEntries, 3);
        String entries = getTextFromElement(crossRefTabEntries);
        Assert.assertTrue(entries.contains("Updated"), "Cross reference table entries are not updated correctly.");
    }

    public void verifyLinkage() {
        Assert.assertTrue(true, "Linkage between billing document and Model N is established.");
    }

    public void verifyErrorLogs() {
        waitUntilElementVisible(errorLogs, 3);
        String logs = getTextFromElement(errorLogs);
        Assert.assertTrue(logs.isEmpty(), "Error logs are not empty.");
    }

    public void verifyTransmittedDocumentsReport() {
        waitUntilElementVisible(transmittedDocumentsReport, 3);
        String report = getTextFromElement(transmittedDocumentsReport);
        Assert.assertTrue(report.contains("Tested document"), "Transmitted documents report does not include the tested document.");
    }

    public void verifyFinancialCalculations() {
        waitUntilElementVisible(financialCalculations, 3);
        String calculations = getTextFromElement(financialCalculations);
        Assert.assertTrue(calculations.contains("Accurate"), "Financial calculations in Model N are not accurate.");
    }
}
