import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user has a valid account with order history", () => {
 // Assume user is already registered with order history
});

When("the user logs in using User ID {string}", (userId) => {
 OrderHistoryPage.login(userId);
});

Then("the user is successfully logged in", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

Given("the user is logged in", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

When("the user navigates to the 'Order History' section", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the 'Order History' section is displayed", () => {
 OrderHistoryPage.verifyOrderHistoryDisplayed();
});

Given("the user is in the 'Order History' section", () => {
 OrderHistoryPage.verifyOrderHistoryDisplayed();
});

When("the user selects a past order with Order ID {string}", (orderId) => {
 OrderHistoryPage.selectPastOrder(orderId);
});

Then("the details of the selected order are displayed", () => {
 OrderHistoryPage.verifyOrderDetailsDisplayed();
});

Given("the user has selected an order", () => {
 OrderHistoryPage.verifyOrderDetailsDisplayed();
});

When("the user clicks on the 'View Receipt' option", () => {
 OrderHistoryPage.viewReceipt();
});

Then("the receipt for the selected order is displayed", () => {
 OrderHistoryPage.verifyReceiptDisplayed();
});

When("the user checks the receipt details", () => {
 OrderHistoryPage.checkReceiptDetails();
});

Then("the receipt details match the order details", () => {
 OrderHistoryPage.verifyReceiptMatchesOrderDetails();
});

When("the user attempts to download the receipt as a PDF", () => {
 OrderHistoryPage.downloadReceiptAsPDF();
});

Then("the receipt is successfully downloaded as a PDF", () => {
 OrderHistoryPage.verifyPDFDownloadSuccess();
});

Given("the user is not authorized to access the receipt", () => {
 OrderHistoryPage.verifyUnauthorizedAccess();
});

When("the user attempts to access the receipt", () => {
 OrderHistoryPage.attemptAccessReceipt();
});

Then("access to the receipt is denied", () => {
 OrderHistoryPage.verifyAccessDenied();
});

Given("the receipt is stored in the system", () => {
 OrderHistoryPage.verifyReceiptStored();
});

When("the user checks the security of the receipt", () => {
 OrderHistoryPage.checkReceiptSecurity();
});

Then("the receipt is stored securely and is not tampered with", () => {
 OrderHistoryPage.verifyReceiptSecurity();
});

Given("the user is accessing the receipt", () => {
 OrderHistoryPage.accessingReceipt();
});

When("a system failure occurs", () => {
 OrderHistoryPage.simulateSystemFailure();
});

Then("the system handles the failure gracefully and provides an error message", () => {
 OrderHistoryPage.verifySystemFailureHandling();
});

Given("receipts are stored in the system", () => {
 OrderHistoryPage.verifyReceiptsStored();
});

When("the user checks the retention policy", () => {
 OrderHistoryPage.checkRetentionPolicy();
});

Then("receipts are retained according to the policy", () => {
 OrderHistoryPage.verifyRetentionPolicy();
});

Given("the user has orders from the last year", () => {
 OrderHistoryPage.verifyOrdersFromLastYear();
});

When("the user attempts to access receipts for these orders", () => {
 OrderHistoryPage.accessReceiptsFromLastYear();
});

Then("the user can access receipts for orders from the last year", () => {
 OrderHistoryPage.verifyAccessToLastYearReceipts();
});

Given("the user has a cancelled order", () => {
 OrderHistoryPage.verifyCancelledOrderExists();
});

When("the user attempts to access the receipt for the cancelled order", () => {
 OrderHistoryPage.accessCancelledOrderReceipt();
});

Then("the receipt for the cancelled order is available with a cancellation note", () => {
 OrderHistoryPage.verifyCancelledOrderReceipt();
});

When("the user checks for duplicate receipts", () => {
 OrderHistoryPage.checkForDuplicateReceipts();
});

Then("no duplicate receipts are found in the order history", () => {
 OrderHistoryPage.verifyNoDuplicateReceipts();
});

When("the user checks for tax and discount details", () => {
 OrderHistoryPage.checkTaxAndDiscountDetails();
});

Then("the receipt includes accurate tax and discount details", () => {
 OrderHistoryPage.verifyTaxAndDiscountDetails();
});

When("the user attempts to print the receipt", () => {
 OrderHistoryPage.printReceipt();
});

Then("the receipt is printed successfully", () => {
 OrderHistoryPage.verifyReceiptPrinted();
});