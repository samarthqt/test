package page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderProcessingPage extends WebReusableComponents {

    // Fields
    protected By usernameField = By.id("username");
    protected By passwordField = By.id("password");
    protected By loginButton = By.id("loginButton");
    protected By salesOrderScreen = By.id("salesOrderScreen");
    protected By searchField = By.id("searchField");
    protected By searchButton = By.id("searchButton");
    protected By orderDetails = By.id("orderDetails");
    protected By quantityField = By.id("quantityField");
    protected By deliveryDateField = By.id("deliveryDateField");
    protected By saveButton = By.id("saveButton");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By orderHistory = By.id("orderHistory");
    protected By databaseCheck = By.id("databaseCheck");
    protected By generateDocumentButton = By.id("generateDocumentButton");
    protected By systemLogs = By.id("systemLogs");
    protected By searchResults = By.id("searchResults");
    protected By logoutButton = By.id("logoutButton");
    protected By salesOrderProcessingScreen = By.id("salesOrderProcessingScreen");
    protected By uniqueOrderIdField = By.id("uniqueOrderId");
    protected By modifyOrderButton = By.id("modifyOrderButton");
    protected By systemResponseMessage = By.id("systemResponseMessage");
    protected By saveChangesButton = By.id("saveChangesButton");
    protected By logoutSuccessMessage = By.id("logoutSuccessMessage");
    protected By txtUsername = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By salesOrderScreenLink = By.id("salesOrderScreen");
    protected By txtSearchOrderID = By.id("searchOrderID");
    protected By btnSearchOrder = By.id("searchOrderButton");
    protected By orderDetailsSection = By.id("orderDetails");
    protected By txtUpdatedQuantity = By.id("updatedQuantity");
    protected By txtUpdatedDeliveryDate = By.id("updatedDeliveryDate");
    protected By btnSaveChanges = By.id("saveChangesButton");
    protected By orderHistorySection = By.id("orderHistory");
    protected By systemLogsSection = By.id("systemLogs");
    protected By btnGenerateOrderConfirmation = By.id("generateOrderConfirmationButton");
    protected By orderConfirmationDocument = By.id("orderConfirmationDocument");
    protected By btnLogout = By.id("logoutButton");
    protected By txtOrderDetails = By.id("orderDetailsInput");
    protected By updatedOrderDetails = By.id("updatedOrderDetails");
    protected By inboundInterfaceTrigger = By.id("inboundInterfaceTrigger");
    protected By payloadProcessingStatus = By.id("payloadProcessingStatus");
    protected By orderNumber = By.id("orderNumber");
    protected By interfaceLogs = By.id("interfaceLogs");
    protected By acknowledgmentMessage = By.id("acknowledgmentMessage");

    // Methods
    public void enterCredentials(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifySuccessfulLogin() {
        waitUntilElementVisible(salesOrderScreen, 3);
        Assert.assertTrue(isElementDisplayed(salesOrderScreen), "Login failed.");
    }

    public void navigateToSalesOrderScreen() {
        clickElement(salesOrderScreen);
    }

    public void verifySalesOrderScreenDisplayed() {
        Assert.assertTrue(isElementDisplayed(salesOrderScreen), "Sales Order screen not displayed.");
    }

    public void searchOrderByID(String uniqueOrderID) {
        enterText(searchField, uniqueOrderID);
        clickElement(searchButton);
    }

    public void verifyOrderDetailsDisplayed() {
        Assert.assertTrue(isElementDisplayed(orderDetails), "Order details not displayed.");
    }

    public void updateOrderDetails(String quantity, String deliveryDate) {
        enterText(quantityField, quantity);
        enterText(deliveryDateField, deliveryDate);
    }

    public void verifyOrderDetailsUpdated() {
        Assert.assertTrue(isElementDisplayed(saveButton), "Order details not updated.");
    }

    public void saveOrderChanges() {
        clickElement(saveButton);
    }

    public void verifyChangesSaved() {
        Assert.assertTrue(isElementDisplayed(confirmationMessage), "Changes not saved.");
    }

    public void verifyConfirmationMessage() {
        String message = getTextFromElement(confirmationMessage);
        Assert.assertEquals(message, "Changes saved successfully.", "Confirmation message mismatch.");
    }

    public void viewOrderDetailsScreen() {
        clickElement(orderDetails);
    }

    public void verifyUpdatedDetailsDisplayed() {
        Assert.assertTrue(isElementDisplayed(orderDetails), "Updated details not displayed.");
    }

    public void checkOrderHistory() {
        clickElement(orderHistory);
    }

    public void verifyOrderHistoryDetails() {
        Assert.assertTrue(isElementDisplayed(orderHistory), "Order history not updated.");
    }

    public void checkDatabaseForUpdates() {
        clickElement(databaseCheck);
    }

    public void verifyDatabaseUpdates() {
        Assert.assertTrue(isElementDisplayed(databaseCheck), "Database not updated.");
    }

    public void generateOrderConfirmationDocument() {
        clickElement(generateDocumentButton);
    }

    public void verifyOrderConfirmationDocument() {
        Assert.assertTrue(isElementDisplayed(generateDocumentButton), "Order confirmation document not generated.");
    }

    public void validateSystemLogs() {
        clickElement(systemLogs);
    }

    public void verifyNoErrorsInLogs() {
        Assert.assertTrue(isElementDisplayed(systemLogs), "Errors found in logs.");
    }

    public void performSystemWideSearch() {
        clickElement(searchResults);
    }

    public void verifySearchResults() {
        Assert.assertTrue(isElementDisplayed(searchResults), "Search results not displayed.");
    }

    public void verifyAllTasksCompleted() {
        Assert.assertTrue(isElementDisplayed(saveButton), "Tasks not completed.");
    }

    public void logout() {
        clickElement(logoutButton);
    }

    public void verifyLogout() {
        Assert.assertTrue(isElementDisplayed(loginButton), "Logout failed.");
    }

    public void loginToSAPSystem(String username, String password) {
        waitUntilElementVisible(usernameField, 3);
        enterText(usernameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }

    public void navigateToSalesOrderProcessingScreen() {
        waitUntilElementVisible(salesOrderProcessingScreen, 3);
        clickElement(salesOrderProcessingScreen);
    }

    public void attemptToModifyOrder(String uniqueOrderId) {
        waitUntilElementVisible(uniqueOrderIdField, 3);
        enterText(uniqueOrderIdField, uniqueOrderId);
        clickElement(modifyOrderButton);
    }

    public void verifySystemResponse(String expectedResponse) {
        waitUntilElementVisible(systemResponseMessage, 3);
        String actualResponse = getTextFromElement(systemResponseMessage);
        Assert.assertEquals(actualResponse, expectedResponse, "System response does not match.");
    }

    public void checkSystemLogs() {
        waitUntilElementVisible(systemLogs, 3);
    }

    public void verifyLogResponse(String expectedLogResponse) {
        String actualLogResponse = getTextFromElement(systemLogs);
        Assert.assertEquals(actualLogResponse, expectedLogResponse, "Log response does not match.");
    }

    public void attemptToSaveChanges() {
        waitUntilElementVisible(saveChangesButton, 3);
        clickElement(saveChangesButton);
    }

    public void verifySaveResponse(String expectedSaveResponse) {
        waitUntilElementVisible(systemResponseMessage, 3);
        String actualSaveResponse = getTextFromElement(systemResponseMessage);
        Assert.assertEquals(actualSaveResponse, expectedSaveResponse, "Save response does not match.");
    }

    public void logoutOfSAPSystem() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(logoutSuccessMessage, 3);
        String actualMessage = getTextFromElement(logoutSuccessMessage);
        Assert.assertEquals(actualMessage, "You have been logged out successfully.", "Logout success message does not match.");
    }

    public void searchOrderByUniqueID(String uniqueOrderID) {
        enterText(txtSearchOrderID, uniqueOrderID);
        clickElement(btnSearch);
    }

    public void modifyOrderDetails(String updatedDetails) {
        enterText(txtOrderDetails, updatedDetails);
    }

    public void verifyOrderSaveConfirmation() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Changes saved successfully.", "Order save confirmation message mismatch.");
    }

    public void verifyUpdatedOrderDetails() {
        waitUntilElementVisible(updatedOrderDetails, 3);
        Assert.assertTrue(isElementVisible(updatedOrderDetails), "Updated order details are not displayed.");
    }

    public void validateUpdatedDetails() {
        String actualDetails = getTextFromElement(updatedOrderDetails);
        Assert.assertNotNull(actualDetails, "Updated details are not displayed correctly.");
    }

    public void verifyOrderHistoryWithTimestamp() {
        String historyDetails = getTextFromElement(orderHistorySection);
        Assert.assertTrue(historyDetails.contains("Modification"), "Order history does not show modification details.");
    }

    public void validateSystemLogsForErrorsOrWarnings() {
        waitUntilElementVisible(systemLogsSection, 3);
        Assert.assertFalse(isElementVisible(systemLogsSection), "Errors or warnings are logged in system logs.");
    }

    public void verifyNoErrorsOrWarningsInLogs() {
        Assert.assertTrue(isElementVisible(systemLogsSection), "No errors or warnings are logged.");
    }

    public void validateOrderConfirmationDocument(String quantity, String deliveryDate) {
        waitUntilElementVisible(orderConfirmationDocument, 3);
        String actualDocumentContent = getTextFromElement(orderConfirmationDocument);
        Assert.assertTrue(actualDocumentContent.contains(quantity), "Order confirmation document does not reflect updated quantity.");
        Assert.assertTrue(actualDocumentContent.contains(deliveryDate), "Order confirmation document does not reflect updated delivery date.");
    }

    public void triggerInboundInterface(String orderId, String salesArea) {
        waitUntilElementVisible(inboundInterfaceTrigger, 3);
        enterText(inboundInterfaceTrigger, "Order ID: " + orderId + ", Sales Area: " + salesArea);
        clickElement(inboundInterfaceTrigger);
    }

    public void sendPayloadForProcessing() {
        waitUntilElementVisible(payloadProcessingStatus, 3);
        clickElement(payloadProcessingStatus);
    }

    public void verifyPayloadProcessing() {
        String status = getTextFromElement(payloadProcessingStatus);
        Assert.assertEquals(status, "Processed Successfully", "Payload processing failed.");
    }

    public void verifyOrderCreation() {
        String orderType = getTextFromElement(orderDetails);
        Assert.assertTrue(orderType.contains("ZOR"), "Order creation failed or incorrect order type.");
    }

    public void verifyOrderSalesArea(String salesArea) {
        String actualSalesArea = getTextFromElement(orderDetails);
        Assert.assertTrue(actualSalesArea.contains(salesArea), "Sales Area mismatch.");
    }

    public void verifyOrderDetails() {
        String details = getTextFromElement(orderDetails);
        Assert.assertNotNull(details, "Order details are missing.");
    }

    public void verifyUniqueOrderNumber() {
        String orderNum = getTextFromElement(orderNumber);
        Assert.assertNotNull(orderNum, "Order number is not generated.");
    }

    public void verifyOrderLogging() {
        String logs = getTextFromElement(interfaceLogs);
        Assert.assertTrue(logs.contains("Order Logged"), "Order logging failed.");
    }

    public void verifyInterfaceLogs() {
        String logs = getTextFromElement(interfaceLogs);
        Assert.assertTrue(logs.contains("Success"), "Interface logs indicate issues.");
    }

    public void verifyOrderFormat() {
        String orderType = getTextFromElement(orderDetails);
        Assert.assertTrue(orderType.contains("ZOR"), "Order format is incorrect.");
    }

    public void verifyAcknowledgment() {
        String acknowledgment = getTextFromElement(acknowledgmentMessage);
        Assert.assertEquals(acknowledgment, "Acknowledgment Sent", "Acknowledgment not sent.");
    }

    public void sendMinimalPayload() {
        waitUntilElementVisible(inboundInterfaceTrigger, 3);
        enterText(inboundInterfaceTrigger, "Minimal Payload");
        clickElement(inboundInterfaceTrigger);
    }

    public void processMinimalPayload() {
        waitUntilElementVisible(payloadProcessingStatus, 3);
        clickElement(payloadProcessingStatus);
    }

    public void verifyMinimalOrderCreation() {
        String status = getTextFromElement(payloadProcessingStatus);
        Assert.assertEquals(status, "Processed Successfully", "Minimal payload order creation failed.");
    }

    public void verifyMinimalPayloadEfficiency() {
        String logs = getTextFromElement(interfaceLogs);
        Assert.assertTrue(logs.contains("Efficient"), "Minimal payload processing was not efficient.");
    }
}
