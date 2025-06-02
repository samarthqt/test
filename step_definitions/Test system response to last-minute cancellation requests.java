package com.cucumber.steps;

import com.page_objects.CancellationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CancellationSteps extends CancellationPage {

    @Given("a user account with valid credentials")
    public void aUserAccountWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Given("an order with ID 12345 is placed and ready for shipping")
    public void anOrderWithIDIsPlacedAndReadyForShipping() {
        verifyOrderReadyForShipping("12345");
    }

    @When("the user logs into the system")
    public void theUserLogsIntoTheSystem() {
        loginToSystem();
    }

    @Then("the user successfully logs into the system")
    public void theUserSuccessfullyLogsIntoTheSystem() {
        verifySuccessfulLogin();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the Order History page displays all past orders")
    public void theOrderHistoryPageDisplaysAllPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the order with ID 12345")
    public void theUserSelectsTheOrderWithID() {
        selectOrder("12345");
    }

    @Then("the order details for ID 12345 are displayed")
    public void theOrderDetailsForIDAreDisplayed() {
        verifyOrderDetailsDisplayed("12345");
    }

    @Then("the shipping status is 'Ready for dispatch'")
    public void theShippingStatusIsReadyForDispatch() {
        verifyShippingStatus("Ready for dispatch");
    }

    @When("the user clicks on 'Cancel Order' button")
    public void theUserClicksOnCancelOrderButton() {
        clickCancelOrderButton();
    }

    @Then("a cancellation confirmation dialog appears")
    public void aCancellationConfirmationDialogAppears() {
        verifyCancellationDialogAppears();
    }

    @When("the user confirms cancellation by clicking 'Yes'")
    public void theUserConfirmsCancellationByClickingYes() {
        confirmCancellation();
    }

    @Then("the order status changes to 'Cancelled'")
    public void theOrderStatusChangesToCancelled() {
        verifyOrderStatusChangedToCancelled();
    }

    @Then("a notification email for cancellation is received")
    public void aNotificationEmailForCancellationIsReceived() {
        verifyCancellationEmailReceived();
    }

    @When("the user checks refund initiation status")
    public void theUserChecksRefundInitiationStatus() {
        checkRefundInitiationStatus();
    }

    @Then("the refund process is initiated for the cancelled order")
    public void theRefundProcessIsInitiatedForTheCancelledOrder() {
        verifyRefundProcessInitiated();
    }

    @When("the user navigates to the 'Refund Status' section")
    public void theUserNavigatesToTheRefundStatusSection() {
        navigateToRefundStatus();
    }

    @Then("the refund status is displayed as 'Processing'")
    public void theRefundStatusIsDisplayedAsProcessing() {
        verifyRefundStatusDisplayed("Processing");
    }

    @When("the user logs out from the user account")
    public void theUserLogsOutFromTheUserAccount() {
        logoutFromUserAccount();
    }

    @Then("the user successfully logs out from the system")
    public void theUserSuccessfullyLogsOutFromTheSystem() {
        verifySuccessfulLogout();
    }

    @When("the user attempts to track the cancelled order")
    public void theUserAttemptsToTrackTheCancelledOrder() {
        attemptToTrackCancelledOrder();
    }

    @Then("the system displays 'Order Cancelled, no tracking available'")
    public void theSystemDisplaysOrderCancelledNoTrackingAvailable() {
        verifyNoTrackingAvailableForCancelledOrder();
    }

    @When("the user checks the order status in the database")
    public void theUserChecksTheOrderStatusInTheDatabase() {
        checkOrderStatusInDatabase();
    }

    @Then("the database reflects order status as 'Cancelled'")
    public void theDatabaseReflectsOrderStatusAsCancelled() {
        verifyDatabaseOrderStatusCancelled();
    }

    @When("the user verifies system logs for cancellation request")
    public void theUserVerifiesSystemLogsForCancellationRequest() {
        verifySystemLogsForCancellationRequest();
    }

    @Then("logs contain entry for cancellation request and status update")
    public void logsContainEntryForCancellationRequestAndStatusUpdate() {
        verifyLogsContainCancellationEntry();
    }

    @When("the system performance is checked under cancellation load")
    public void theSystemPerformanceIsCheckedUnderCancellationLoad() {
        checkSystemPerformanceUnderCancellationLoad();
    }

    @Then("the system performance remains optimal with no delays")
    public void theSystemPerformanceRemainsOptimalWithNoDelays() {
        verifyOptimalSystemPerformance();
    }

    @When("the user reviews the user interface for cancellation process")
    public void theUserReviewsTheUserInterfaceForCancellationProcess() {
        reviewUserInterfaceForCancellation();
    }

    @Then("the UI is user-friendly and intuitive for cancellation requests")
    public void theUIIsUserFriendlyAndIntuitiveForCancellationRequests() {
        verifyUserFriendlyUI();
    }

    @When("customer support availability for cancellation queries is ensured")
    public void customerSupportAvailabilityForCancellationQueriesIsEnsured() {
        ensureCustomerSupportAvailability();
    }

    @Then("customer support is available and responsive to queries")
    public void customerSupportIsAvailableAndResponsiveToQueries() {
        verifyCustomerSupportResponsiveness();
    }
}