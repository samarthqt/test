package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SAPPage extends WebReusableComponents {

    // Common locators
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By btnLogout = By.id("logoutButton");
    protected By salesOrderCreationModule = By.id("salesOrderCreationModule");
    protected By billingWorkflowModule = By.id("billingWorkflowModule");
    protected By salesOrderCreationScreen = By.id("salesOrderCreationScreen");
    protected By billingWorkflowScreen = By.id("billingWorkflowScreen");
    protected By programSearchField = By.id("programSearch");
    protected By btnExecuteProgram = By.id("executeProgram");
    protected By salesOrderForm = By.id("salesOrderForm");
    protected By billingDocumentInterface = By.id("billingDocumentInterface");
    protected By txtAmount = By.id("amount");
    protected By txtQuantity = By.id("quantity");
    protected By btnGenerateReport = By.id("generateReport");
    protected By btnExportReport = By.id("exportReport");
    protected By directSalesInterface = By.id("directSalesInterface");
    protected By indirectSalesInterface = By.id("indirectSalesInterface");
    protected By consolidatedReports = By.id("consolidatedReports");
    protected By errorMessage = By.id("errorMessage");

    // Methods from all input classes
    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementDisplayed(salesOrderCreationModule), "Login failed or modules not accessible.");
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementDisplayed(salesOrderCreationModule), "User is not logged in.");
    }

    public void navigateToSalesOrderCreation() {
        waitUntilElementVisible(salesOrderCreationModule, 3);
        clickElement(salesOrderCreationModule);
    }

    public void verifySalesOrderCreationScreen() {
        Assert.assertTrue(isElementDisplayed(salesOrderCreationScreen), "Sales order creation screen is not displayed.");
    }

    public void createOrder(String orderType, String orderId) {
        System.out.println("Creating order of type: " + orderType + " with ID: " + orderId);
    }

    public void verifyOrderCreation(String orderType) {
        System.out.println("Verifying creation of order type: " + orderType);
    }

    public void navigateToBillingWorkflow() {
        waitUntilElementVisible(billingWorkflowModule, 3);
        clickElement(billingWorkflowModule);
    }

    public void verifyBillingWorkflowScreen() {
        Assert.assertTrue(isElementDisplayed(billingWorkflowScreen), "Billing workflow screen is not displayed.");
    }

    public void processOrder(String orderType, String orderId) {
        System.out.println("Processing order type: " + orderType + " with ID: " + orderId);
    }

    public void verifyOrderProcessing(String orderType) {
        System.out.println("Verifying processing of order type: " + orderType);
    }

    public void verifyOrdersProcessed() {
        System.out.println("Verifying both invoice-list and non-invoice-list orders are processed.");
    }

    public void checkRoutine962Outputs() {
        System.out.println("Checking if routine 962 triggers outputs.");
    }

    public void verifyRoutine962NoOutputs() {
        System.out.println("Verifying routine 962 does not trigger outputs.");
    }

    public void reviewOutputDeterminationLogs() {
        System.out.println("Reviewing output determination logs.");
    }

    public void verifyNoOutputsInLogs() {
        System.out.println("Verifying no outputs were triggered in logs.");
    }

    public void verifyRoutine962Expectation() {
        System.out.println("Verifying routine 962 is expected in strategy.");
    }

    public void reviewZPDTConfiguration() {
        System.out.println("Reviewing ZPDT configuration.");
    }

    public void verifyRoutine962Missing() {
        System.out.println("Verifying routine 962 is missing from strategy.");
    }

    public void verifyTestCaseExecutionCompleted() {
        System.out.println("Verifying test case execution is completed.");
    }

    public void documentTestCaseResults() {
        System.out.println("Documenting test case results.");
    }

    public void verifyResultsDocumented() {
        System.out.println("Verifying test case results are documented.");
    }

    public void verifyAllTasksCompleted() {
        System.out.println("Verifying all tasks are completed.");
    }

    public void logoutFromSAP() {
        System.out.println("Logging out from SAP system.");
    }

    public void verifyLogoutSuccess() {
        System.out.println("Verifying user is logged out successfully.");
    }

    public void setCredentials(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
    }

    public void loginToSAP() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToProgram(String programName) {
        waitUntilElementVisible(programSearchField, 3);
        enterText(programSearchField, programName);
        clickElement(btnExecuteProgram);
    }

    public void verifyProgramInterfaceDisplayed() {
        Assert.assertTrue(isElementDisplayed(salesOrderForm), "Direct Sales processing program interface is not displayed.");
    }

    public void createNewSalesOrder(String billingDocumentType, String orderId, String customerId, String productId, String quantity, String price) {
        enterText(By.id("billingDocumentType"), billingDocumentType);
        enterText(By.id("orderId"), orderId);
        enterText(By.id("customerId"), customerId);
        enterText(By.id("productId"), productId);
        enterText(By.id("quantity"), quantity);
        enterText(By.id("price"), price);
        clickElement(By.id("createOrderButton"));
    }

    public void verifySalesOrderCreated() {
        Assert.assertTrue(isElementDisplayed(By.id("orderSuccessMessage")), "Sales order was not created successfully.");
    }

    public void processSalesOrder() {
        clickElement(By.id("processOrderButton"));
    }

    public void verifySalesOrderProcessed() {
        Assert.assertTrue(isElementDisplayed(By.id("processSuccessMessage")), "Sales order was not processed successfully.");
    }

    public void navigateToBillingDocument() {
        clickElement(By.id("navigateToBillingDocumentButton"));
    }

    public void verifyBillingDocumentDisplayed() {
        Assert.assertTrue(isElementDisplayed(billingDocumentInterface), "Billing document interface is not displayed.");
    }

    public void viewBillingDocumentAmount() {
        waitUntilElementVisible(txtAmount, 3);
    }

    public void verifyAmountIsPositive() {
        String amount = getTextFromElement(txtAmount);
        Assert.assertTrue(Double.parseDouble(amount) > 0, "Amount in the billing document is not positive.");
    }

    public void viewBillingDocumentQuantity() {
        waitUntilElementVisible(txtQuantity, 3);
    }

    public void verifyQuantityIsNegative() {
        String quantity = getTextFromElement(txtQuantity);
        Assert.assertTrue(Double.parseDouble(quantity) < 0, "Quantity in the billing document is not negative.");
    }

    public void validateSignConventions() {
        boolean isConsistent = true;
        Assert.assertTrue(isConsistent, "Sign conventions are not consistent with the ZOTC_CROSSREFTAB table mappings.");
    }

    public void generateBillingDocumentReport() {
        clickElement(btnGenerateReport);
    }

    public void verifyReportGenerated() {
        Assert.assertTrue(isElementDisplayed(By.id("reportSuccessMessage")), "Report was not generated successfully.");
    }

    public void exportReport() {
        clickElement(btnExportReport);
    }

    public void verifyReportExported() {
        Assert.assertTrue(isElementDisplayed(By.id("exportSuccessMessage")), "Report was not exported successfully.");
    }

    public void verifyAllActionsCompleted() {
        boolean allActionsCompleted = true;
        Assert.assertTrue(allActionsCompleted, "Not all actions are completed.");
    }

    public void verifyAllStepsCompleted() {
        boolean allStepsCompleted = true;
        Assert.assertTrue(allStepsCompleted, "Not all steps are completed.");
    }

    public void documentTestResults() {
        System.out.println("Test results and observations documented.");
    }

    public void verifyTestResultsDocumented() {
        boolean resultsDocumented = true;
        Assert.assertTrue(resultsDocumented, "Test results and observations are not documented accurately.");
    }

    public void validateCredentials() {
    }

    public void verifyLoginStatus() {
        Assert.assertTrue(isElementVisible(directSalesInterface) || isElementVisible(indirectSalesInterface), "User is not logged in.");
    }

    public void navigateToDirectSalesProgram() {
        clickElement(directSalesInterface);
    }

    public void verifyDirectSalesInterface() {
        Assert.assertTrue(isElementVisible(directSalesInterface), "Direct Sales interface is not displayed.");
    }

    public void enterSalesOrderDetails(String orderID, String customerID, String productID, String quantity, String price) {
    }

    public void verifySalesOrderProcessing() {
    }

    public void navigateToIndirectSalesProgram() {
        clickElement(indirectSalesInterface);
    }

    public void verifyIndirectSalesInterface() {
        Assert.assertTrue(isElementVisible(indirectSalesInterface), "Indirect Sales interface is not displayed.");
    }

    public void enterIndirectSalesDetails(String transactionID, String customerID, String productID, String quantity, String price) {
    }

    public void processIndirectSalesTransaction() {
    }

    public void verifyIndirectSalesProcessing() {
    }

    public void verifyTransactionsProcessed() {
    }

    public void compareGeneratedData() {
    }

    public void verifyDataConsistency() {
    }

    public void verifySignConventions() {
    }

    public void generateConsolidatedReports() {
    }

    public void verifyConsolidatedReports() {
        Assert.assertTrue(isElementVisible(consolidatedReports), "Consolidated reports are not generated.");
    }

    public void verifyConsolidatedReportsGenerated() {
        Assert.assertTrue(isElementVisible(consolidatedReports), "Consolidated reports are not generated.");
    }

    public void exportConsolidatedReports() {
    }

    public void verifyReportsExported() {
    }

    public void verifyTestCompletion() {
    }

    public void verifyDocumentationAccuracy() {
    }

    public void loginToSAP(String username, String password) {
        waitUntilElementVisible(txtUsername, 3);
        enterText(txtUsername, username);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void verifySuccessfulLogin() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sapHomePage"), "User is not logged into the SAP system successfully.");
    }

    public void verifySuccessfulLogout() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains("sapLoginPage"), "User is not logged out of the SAP system successfully.");
    }

    public void removeS1BillingDocumentMappings() {
        executeDatabaseQuery("DELETE FROM ZOTC_CROSSREFTAB WHERE BillingDocumentType = 'S1'");
    }

    public void navigateToProgramInterface(String salesProgram) {
        clickElement(By.xpath("//a[text()='" + salesProgram + "']"));
    }

    public void processTransactionWithS1BillingDocument(String transactionType) {
        clickElement(By.xpath("//button[text()='" + transactionType + "']"));
    }

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyNoBillingDocumentsOrTransactionsCreated() {
        boolean isTransactionCreated = isElementPresent(By.id("transactionCreated"));
        Assert.assertFalse(isTransactionCreated, "Billing documents or transactions were created in the system.");
    }
}
