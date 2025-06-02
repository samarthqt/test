package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderHistoryPage;

public class OrderHistorySteps extends OrderHistoryPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Then("the user is redirected to the dashboard")
    public void theUserIsRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @Then("39 orders have been placed with tracking information")
    public void ordersHaveBeenPlacedWithTrackingInformation() {
        verifyOrdersWithTrackingInformation(39);
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the user sees a list of past orders")
    public void theUserSeesAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user selects an order with ID {int}")
    public void theUserSelectsAnOrderWithID(int orderID) {
        selectOrder(String.valueOf(orderID));
    }

    @Then("the order details are displayed with tracking information")
    public void theOrderDetailsAreDisplayedWithTrackingInformation() {
        verifyOrderDetailsDisplayed();
    }

    @Given("the user manually enters an invalid tracking number {string} for the order")
    public void theUserManuallyEntersAnInvalidTrackingNumberForTheOrder(String trackingNumber) {
        enterInvalidTrackingNumber(trackingNumber);
    }

    @When("the system attempts to fetch tracking information")
    public void theSystemAttemptsToFetchTrackingInformation() {
        attemptToFetchTrackingInformation();
    }

    @Then("the system displays a user-friendly error message indicating the tracking number is invalid")
    public void theSystemDisplaysAUserFriendlyErrorMessageIndicatingTheTrackingNumberIsInvalid() {
        verifyInvalidTrackingNumberErrorMessage();
    }

    @Given("a network failure occurs during tracking information retrieval")
    public void aNetworkFailureOccursDuringTrackingInformationRetrieval() {
        simulateNetworkFailure();
    }

    @Then("the system provides an error message indicating a network issue and suggests retrying")
    public void theSystemProvidesAnErrorMessageIndicatingANetworkIssueAndSuggestsRetrying() {
        verifyNetworkIssueErrorMessage();
    }

    @Given("the carrier's API is down")
    public void theCarriersAPIIsDown() {
        simulateCarrierAPIDown();
    }

    @Then("the system informs the user that the carrier's service is temporarily unavailable")
    public void theSystemInformsTheUserThatTheCarriersServiceIsTemporarilyUnavailable() {
        verifyCarrierServiceUnavailableMessage();
    }

    @Given("the carrier's API response is delayed")
    public void theCarriersAPIResponseIsDelayed() {
        simulateCarrierAPIDelay();
    }

    @Then("the system displays a message indicating a delay in fetching tracking information")
    public void theSystemDisplaysAMessageIndicatingADelayInFetchingTrackingInformation() {
        verifyDelayInFetchingTrackingInformationMessage();
    }

    @Given("a 404 error is received from the carrier's API")
    public void a404ErrorIsReceivedFromTheCarriersAPI() {
        simulate404ErrorFromCarrierAPI();
    }

    @Then("the system provides a message indicating the tracking information could not be found")
    public void theSystemProvidesAMessageIndicatingTheTrackingInformationCouldNotBeFound() {
        verifyTrackingInformationNotFoundMessage();
    }

    @Given("a 500 error is received from the carrier's API")
    public void a500ErrorIsReceivedFromTheCarriersAPI() {
        simulate500ErrorFromCarrierAPI();
    }

    @Then("the system informs the user of a server error and suggests trying again later")
    public void theSystemInformsTheUserOfAServerErrorAndSuggestsTryingAgainLater() {
        verifyServerErrorAndRetrySuggestion();
    }

    @Given("the tracking information is incomplete")
    public void theTrackingInformationIsIncomplete() {
        simulateIncompleteTrackingInformation();
    }

    @Then("the system displays a message indicating incomplete tracking information and suggests contacting support")
    public void theSystemDisplaysAMessageIndicatingIncompleteTrackingInformationAndSuggestsContactingSupport() {
        verifyIncompleteTrackingInformationMessage();
    }

    @Given("tracking errors occur")
    public void trackingErrorsOccur() {
        simulateTrackingErrors();
    }

    @Then("tracking errors are logged accurately for auditing and troubleshooting purposes")
    public void trackingErrorsAreLoggedAccuratelyForAuditingAndTroubleshootingPurposes() {
        verifyTrackingErrorsLogging();
    }

    @Given("the user switches carriers for tracking an order")
    public void theUserSwitchesCarriersForTrackingAnOrder() {
        switchCarriersForTracking();
    }

    @Then("the system updates the carrier information and attempts to fetch new tracking data")
    public void theSystemUpdatesTheCarrierInformationAndAttemptsToFetchNewTrackingData() {
        verifyCarrierInformationUpdateAndFetch();
    }

    @Given("the user attempts to retry fetching tracking information")
    public void theUserAttemptsToRetryFetchingTrackingInformation() {
        attemptRetryFetchingTrackingInformation();
    }

    @Then("the system allows retry attempts and provides feedback on the status of each attempt")
    public void theSystemAllowsRetryAttemptsAndProvidesFeedbackOnTheStatusOfEachAttempt() {
        verifyRetryAttemptsAndFeedback();
    }

    @Given("the user encounters tracking issues")
    public void theUserEncountersTrackingIssues() {
        encounterTrackingIssues();
    }

    @Then("a help link is available, directing users to support for tracking issues")
    public void aHelpLinkIsAvailableDirectingUsersToSupportForTrackingIssues() {
        verifyHelpLinkForTrackingIssues();
    }
}