package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an active account")
    public void theUserHasAnActiveAccount() {
        verifyUserAccountActive();
    }

    @Given("the user logs in to the system using valid user credentials")
    public void theUserLogsInToTheSystemUsingValidUserCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        loginUser(username, password);
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyUserRedirectedToDashboard();
    }

    @Given("the user has placed orders with tracking information available")
    public void theUserHasPlacedOrdersWithTrackingInformationAvailable() {
        verifyOrdersWithTrackingInfo();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        verifyUserOnDashboard();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the user is presented with a list of past orders")
    public void theUserIsPresentedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the user is on the 'Order History' section")
    public void theUserIsOnTheOrderHistorySection() {
        verifyUserOnOrderHistorySection();
    }

    @When("the user selects an order with ID 54321 to view its details")
    public void theUserSelectsAnOrderWithIDToViewItsDetails() {
        selectOrderById("54321");
    }

    @Then("the order details are displayed, including tracking information")
    public void theOrderDetailsAreDisplayedIncludingTrackingInformation() {
        verifyOrderDetailsWithTrackingInfo();
    }

    @Given("the user is viewing the order details")
    public void theUserIsViewingTheOrderDetails() {
        verifyViewingOrderDetails();
    }

    @Then("the tracking number TRACK12345 is visible in the order details")
    public void theTrackingNumberIsVisibleInTheOrderDetails() {
        verifyTrackingNumberVisible("TRACK12345");
    }

    @Given("the tracking number TRACK12345 is visible")
    public void theTrackingNumberIsVisible() {
        verifyTrackingNumberVisible("TRACK12345");
    }

    @When("the user clicks on the tracking number")
    public void theUserClicksOnTheTrackingNumber() {
        clickOnTrackingNumber();
    }

    @Then("the system redirects to the carrier's website showing detailed tracking information")
    public void theSystemRedirectsToTheCarriersWebsiteShowingDetailedTrackingInformation() {
        verifyRedirectToCarrierWebsite();
    }

    @Given("the user is on the carrier's website")
    public void theUserIsOnTheCarriersWebsite() {
        verifyUserOnCarrierWebsite();
    }

    @Then("the tracking information matches the data provided by the carrier")
    public void theTrackingInformationMatchesTheDataProvidedByTheCarrier() {
        verifyTrackingInfoMatchesCarrierData();
    }

    @Given("the user enters an invalid tracking number")
    public void theUserEntersAnInvalidTrackingNumber() {
        enterInvalidTrackingNumber();
    }

    @Then("the system displays a user-friendly error message for invalid tracking numbers")
    public void theSystemDisplaysAUserFriendlyErrorMessageForInvalidTrackingNumbers() {
        verifyErrorMessageForInvalidTrackingNumber();
    }

    @Given("the carrier updates tracking information")
    public void theCarrierUpdatesTrackingInformation() {
        simulateCarrierTrackingUpdate();
    }

    @Then("the system updates the tracking information in real-time")
    public void theSystemUpdatesTheTrackingInformationInRealTime() {
        verifyRealTimeTrackingUpdate();
    }

    @Given("tracking information is temporarily unavailable")
    public void trackingInformationIsTemporarilyUnavailable() {
        simulateTrackingInfoUnavailability();
    }

    @Then("the system informs the user that tracking information is temporarily unavailable")
    public void theSystemInformsTheUserThatTrackingInformationIsTemporarilyUnavailable() {
        verifyMessageForTrackingInfoUnavailability();
    }

    @Given("the user accesses the tracking information page on a mobile device")
    public void theUserAccessesTheTrackingInformationPageOnAMobileDevice() {
        accessTrackingInfoOnMobile();
    }

    @Then("the tracking information page is fully responsive and displays correctly")
    public void theTrackingInformationPageIsFullyResponsiveAndDisplaysCorrectly() {
        verifyResponsiveTrackingInfoPage();
    }

    @Given("the order status changes")
    public void theOrderStatusChanges() {
        simulateOrderStatusChange();
    }

    @Then("tracking information remains visible regardless of order status changes")
    public void trackingInformationRemainsVisibleRegardlessOfOrderStatusChanges() {
        verifyTrackingInfoVisibilityOnStatusChange();
    }

    @Given("the user's session has expired")
    public void theUsersSessionHasExpired() {
        simulateSessionExpiry();
    }

    @When("the user attempts to access tracking information")
    public void theUserAttemptsToAccessTrackingInformation() {
        attemptAccessWithExpiredSession();
    }

    @Then("the system prompts the user to log in again to access tracking information")
    public void theSystemPromptsTheUserToLogInAgainToAccessTrackingInformation() {
        verifyLoginPromptOnSessionExpiry();
    }

    @Given("the user is viewing tracking information")
    public void theUserIsViewingTrackingInformation() {
        verifyViewingTrackingInformation();
    }

    @Then("a help link is available, directing users to support for tracking issues")
    public void aHelpLinkIsAvailableDirectingUsersToSupportForTrackingIssues() {
        verifyHelpLinkForTrackingIssues();
    }

    @Given("multiple tracking requests are made simultaneously")
    public void multipleTrackingRequestsAreMadeSimultaneously() {
        simulateMultipleTrackingRequests();
    }

    @Then("the system efficiently handles multiple tracking requests without performance degradation")
    public void theSystemEfficientlyHandlesMultipleTrackingRequestsWithoutPerformanceDegradation() {
        verifyHandlingOfMultipleTrackingRequests();
    }

    @Given("a network failure occurs")
    public void aNetworkFailureOccurs() {
        simulateNetworkFailure();
    }

    @When("the user attempts to fetch tracking information")
    public void theUserAttemptsToFetchTrackingInformation() {
        attemptFetchDuringNetworkFailure();
    }

    @Then("the system provides an error message and retries fetching tracking information after network restoration")
    public void theSystemProvidesAnErrorMessageAndRetriesFetchingTrackingInformationAfterNetworkRestoration() {
        verifyErrorMessageAndRetryOnNetworkRestoration();
    }
}