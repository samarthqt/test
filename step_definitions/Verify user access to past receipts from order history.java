package com.cucumber.steps;

import com.page_objects.OrderHistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderHistorySteps extends OrderHistoryPage {

    @Given("the user has a valid account with order history")
    public void theUserHasAValidAccountWithOrderHistory() {
        verifyUserAccountWithOrderHistory();
    }

    @When("the user logs in using User ID {string}")
    public void theUserLogsInUsingUserID(String userID) {
        loginUser(userID);
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyUserLoggedIn();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the 'Order History' section is displayed")
    public void theOrderHistorySectionIsDisplayed() {
        verifyOrderHistorySectionDisplayed();
    }

    @Given("the user is in the 'Order History' section")
    public void theUserIsInTheOrderHistorySection() {
        verifyOrderHistorySectionDisplayed();
    }

    @When("the user selects a past order with Order ID {string}")
    public void theUserSelectsAPastOrderWithOrderID(String orderID) {
        selectPastOrder(orderID);
    }

    @Then("the details of the selected order are displayed")
    public void theDetailsOfTheSelectedOrderAreDisplayed() {
        verifyOrderDetailsDisplayed();
    }

    @Given("the user has selected an order")
    public void theUserHasSelectedAnOrder() {
        verifyOrderDetailsDisplayed();
    }

    @When("the user clicks on the 'View Receipt' option")
    public void theUserClicksOnTheViewReceiptOption() {
        viewReceipt();
    }

    @Then("the receipt for the selected order is displayed")
    public void theReceiptForTheSelectedOrderIsDisplayed() {
        verifyReceiptDisplayed();
    }

    @Given("the receipt for the selected order is displayed")
    public void theReceiptForTheSelectedOrderIsDisplayedAgain() {
        verifyReceiptDisplayed();
    }

    @When("the user checks the receipt details")
    public void theUserChecksTheReceiptDetails() {
        checkReceiptDetails();
    }

    @Then("the receipt details match the order details")
    public void theReceiptDetailsMatchTheOrderDetails() {
        verifyReceiptDetailsMatchOrderDetails();
    }

    @When("the user attempts to download the receipt as a PDF")
    public void theUserAttemptsToDownloadTheReceiptAsAPDF() {
        downloadReceiptAsPDF();
    }

    @Then("the receipt is successfully downloaded as a PDF")
    public void theReceiptIsSuccessfullyDownloadedAsAPDF() {
        verifyReceiptDownloadedAsPDF();
    }

    @Given("the user is not authorized to access the receipt")
    public void theUserIsNotAuthorizedToAccessTheReceipt() {
        verifyUserNotAuthorized();
    }

    @When("the user attempts to access the receipt")
    public void theUserAttemptsToAccessTheReceipt() {
        attemptAccessReceipt();
    }

    @Then("access to the receipt is denied")
    public void accessToTheReceiptIsDenied() {
        verifyAccessDenied();
    }

    @Given("the receipt is stored in the system")
    public void theReceiptIsStoredInTheSystem() {
        verifyReceiptStoredInSystem();
    }

    @When("the user checks the security of the receipt")
    public void theUserChecksTheSecurityOfTheReceipt() {
        checkReceiptSecurity();
    }

    @Then("the receipt is stored securely and is not tampered with")
    public void theReceiptIsStoredSecurelyAndIsNotTamperedWith() {
        verifyReceiptStoredSecurely();
    }

    @Given("the user is accessing the receipt")
    public void theUserIsAccessingTheReceipt() {
        verifyReceiptAccessed();
    }

    @When("a system failure occurs")
    public void aSystemFailureOccurs() {
        simulateSystemFailure();
    }

    @Then("the system handles the failure gracefully and provides an error message")
    public void theSystemHandlesTheFailureGracefullyAndProvidesAnErrorMessage() {
        verifySystemFailureHandledGracefully();
    }

    @Given("receipts are stored in the system")
    public void receiptsAreStoredInTheSystem() {
        verifyReceiptsStoredInSystem();
    }

    @When("the user checks the retention policy")
    public void theUserChecksTheRetentionPolicy() {
        checkRetentionPolicy();
    }

    @Then("receipts are retained according to the policy")
    public void receiptsAreRetainedAccordingToThePolicy() {
        verifyReceiptsRetainedAccordingToPolicy();
    }

    @Given("the user has orders from the last year")
    public void theUserHasOrdersFromTheLastYear() {
        verifyOrdersFromLastYear();
    }

    @When("the user attempts to access receipts for these orders")
    public void theUserAttemptsToAccessReceiptsForTheseOrders() {
        accessReceiptsForLastYearOrders();
    }

    @Then("the user can access receipts for orders from the last year")
    public void theUserCanAccessReceiptsForOrdersFromTheLastYear() {
        verifyAccessToReceiptsForLastYearOrders();
    }

    @Given("the user has a cancelled order")
    public void theUserHasACancelledOrder() {
        verifyCancelledOrderExists();
    }

    @When("the user attempts to access the receipt for the cancelled order")
    public void theUserAttemptsToAccessTheReceiptForTheCancelledOrder() {
        accessReceiptForCancelledOrder();
    }

    @Then("the receipt for the cancelled order is available with a cancellation note")
    public void theReceiptForTheCancelledOrderIsAvailableWithACancellationNote() {
        verifyReceiptForCancelledOrderWithNote();
    }

    @When("the user checks for duplicate receipts")
    public void theUserChecksForDuplicateReceipts() {
        checkForDuplicateReceipts();
    }

    @Then("no duplicate receipts are found in the order history")
    public void noDuplicateReceiptsAreFoundInTheOrderHistory() {
        verifyNoDuplicateReceipts();
    }

    @When("the user checks for tax and discount details")
    public void theUserChecksForTaxAndDiscountDetails() {
        checkTaxAndDiscountDetails();
    }

    @Then("the receipt includes accurate tax and discount details")
    public void theReceiptIncludesAccurateTaxAndDiscountDetails() {
        verifyTaxAndDiscountDetails();
    }

    @When("the user attempts to print the receipt")
    public void theUserAttemptsToPrintTheReceipt() {
        printReceipt();
    }

    @Then("the receipt is printed successfully")
    public void theReceiptIsPrintedSuccessfully() {
        verifyReceiptPrintedSuccessfully();
    }
}