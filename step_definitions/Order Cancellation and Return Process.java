package com.cucumber.steps;

import com.page_objects.OrderCancellationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderCancellationSteps extends OrderCancellationPage {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        launchLoginPage();
    }

    @When("the user logs in with valid credentials \"User ID: {string}\"")
    public void theUserLogsInWithValidCredentials(String userId) {
        loginWithCredentials(userId);
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        verifyDashboardPresence();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the 'Order History' section is displayed with a list of past orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplay();
    }

    @Given("the user is in the 'Order History' section")
    public void theUserIsInTheOrderHistorySection() {
        verifyOrderHistoryPresence();
    }

    @When("the user selects an order with Order ID: {string}")
    public void theUserSelectsAnOrderWithOrderID(String orderId) {
        selectOrder(orderId);
    }

    @Then("order details are displayed with options for cancellation or return")
    public void orderDetailsAreDisplayedWithOptionsForCancellationOrReturn() {
        verifyOrderOptionsDisplay();
    }

    @Given("the user has selected an order eligible for cancellation")
    public void theUserHasSelectedAnOrderEligibleForCancellation() {
        verifyOrderEligibilityForCancellation();
    }

    @When("the user attempts to cancel the order by selecting the cancellation option")
    public void theUserAttemptsToCancelTheOrderBySelectingTheCancellationOption() {
        cancelOrder();
    }

    @Then("the cancellation request is processed, and the user receives confirmation")
    public void theCancellationRequestIsProcessedAndTheUserReceivesConfirmation() {
        verifyCancellationConfirmation();
    }

    @Given("the user has cancelled an order")
    public void theUserHasCancelledAnOrder() {
        verifyOrderCancellation();
    }

    @When("the user selects a cancellation reason as \"Changed Mind\"")
    public void theUserSelectsACancellationReasonAsChangedMind() {
        selectCancellationReason("Changed Mind");
    }

    @Then("the cancellation reason matches the user's selection")
    public void theCancellationReasonMatchesTheUsersSelection() {
        verifyCancellationReason("Changed Mind");
    }

    @Then("the order status changes to 'Cancelled' in the order history")
    public void theOrderStatusChangesToCancelledInTheOrderHistory() {
        verifyOrderStatus("Cancelled");
    }

    @Given("the user has selected an order eligible for return")
    public void theUserHasSelectedAnOrderEligibleForReturn() {
        verifyOrderEligibilityForReturn();
    }

    @When("the user selects the return option")
    public void theUserSelectsTheReturnOption() {
        returnOrder();
    }

    @Then("the return request is processed, and the user receives confirmation")
    public void theReturnRequestIsProcessedAndTheUserReceivesConfirmation() {
        verifyReturnConfirmation();
    }

    @Given("the user has returned an order")
    public void theUserHasReturnedAnOrder() {
        verifyOrderReturn();
    }

    @When("the user selects a return reason as \"Defective Item\"")
    public void theUserSelectsAReturnReasonAsDefectiveItem() {
        selectReturnReason("Defective Item");
    }

    @Then("the return reason matches the user's selection")
    public void theReturnReasonMatchesTheUsersSelection() {
        verifyReturnReason("Defective Item");
    }

    @Then("the order status changes to 'Returned' in the order history")
    public void theOrderStatusChangesToReturnedInTheOrderHistory() {
        verifyOrderStatus("Returned");
    }

    @Given("the user has cancelled or returned an order")
    public void theUserHasCancelledOrReturnedAnOrder() {
        verifyOrderCancellationOrReturn();
    }

    @Then("the user receives notifications for any changes in order status")
    public void theUserReceivesNotificationsForAnyChangesInOrderStatus() {
        verifyStatusChangeNotifications();
    }

    @Then("the refund is processed and credited to the user's account or original payment method")
    public void theRefundIsProcessedAndCreditedToTheUsersAccountOrOriginalPaymentMethod() {
        verifyRefundProcessing();
    }

    @Given("the user has received a refund for a cancelled or returned order")
    public void theUserHasReceivedARefundForACancelledOrReturnedOrder() {
        verifyRefundReceipt();
    }

    @Then("refund details are accurately displayed in the order history")
    public void refundDetailsAreAccuratelyDisplayedInTheOrderHistory() {
        verifyRefundDetailsInOrderHistory();
    }

    @Given("the user attempts an invalid cancellation or return request")
    public void theUserAttemptsAnInvalidCancellationOrReturnRequest() {
        attemptInvalidCancellationOrReturn();
    }

    @Then("the system displays appropriate error messages for invalid requests")
    public void theSystemDisplaysAppropriateErrorMessagesForInvalidRequests() {
        verifyErrorMessagesForInvalidRequests();
    }

    @Given("the user is on the cancellation/return page")
    public void theUserIsOnTheCancellationReturnPage() {
        verifyCancellationReturnPagePresence();
    }

    @When("the user navigates back to the dashboard")
    public void theUserNavigatesBackToTheDashboard() {
        navigateBackToDashboard();
    }

    @Then("the user is redirected to the dashboard without any issues")
    public void theUserIsRedirectedToTheDashboardWithoutAnyIssues() {
        verifyDashboardRedirection();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboardAgain() {
        verifyDashboardPresence();
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        logout();
    }

    @Then("the user is successfully logged out and redirected to the login page")
    public void theUserIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutRedirection();
    }
}