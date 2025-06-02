package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with recent purchase")
    public void aUserAccountWithRecentPurchase() {
        String userId = testHarness.getData("UserData", "UserId");
        verifyRecentPurchase(userId);
    }

    @Given("valid credentials")
    public void validCredentials() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        enterCredentials(username, password);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        login();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Given("User ID: {string}")
    public void userID(String userId) {
        setUserId(userId);
    }

    @When("the user navigates to the 'Track Order' section")
    public void theUserNavigatesToTheTrackOrderSection() {
        navigateToTrackOrderSection();
    }

    @Then("the Track Order page is displayed")
    public void theTrackOrderPageIsDisplayed() {
        verifyTrackOrderPageDisplayed();
    }

    @Given("Tracking Number: {string}")
    public void trackingNumber(String trackingNumber) {
        setTrackingNumber(trackingNumber);
    }

    @Given("Order Date: {string}")
    public void orderDate(String orderDate) {
        setOrderDate(orderDate);
    }

    @When("the user enters the tracking number in the tracking field")
    public void theUserEntersTheTrackingNumberInTheTrackingField() {
        enterTrackingNumber();
    }

    @Then("the tracking number is accepted")
    public void theTrackingNumberIsAccepted() {
        verifyTrackingNumberAccepted();
    }

    @When("the user submits the tracking request")
    public void theUserSubmitsTheTrackingRequest() {
        submitTrackingRequest();
    }

    @Then("tracking information is retrieved")
    public void trackingInformationIsRetrieved() {
        verifyTrackingInformationRetrieved();
    }

    @When("the user checks the current status of the order")
    public void theUserChecksTheCurrentStatusOfTheOrder() {
        checkOrderStatus();
    }

    @Then("the current order status is displayed correctly")
    public void theCurrentOrderStatusIsDisplayedCorrectly() {
        verifyOrderStatusDisplayedCorrectly();
    }

    @When("the user checks the estimated delivery time provided")
    public void theUserChecksTheEstimatedDeliveryTimeProvided() {
        checkEstimatedDeliveryTime();
    }

    @Then("the estimated delivery time is shown")
    public void theEstimatedDeliveryTimeIsShown() {
        verifyEstimatedDeliveryTimeShown();
    }

    @When("the user verifies the carrier information associated with the order")
    public void theUserVerifiesTheCarrierInformationAssociatedWithTheOrder() {
        verifyCarrierInformation();
    }

    @Then("the carrier information is displayed correctly")
    public void theCarrierInformationIsDisplayedCorrectly() {
        verifyCarrierInformationDisplayedCorrectly();
    }

    @When("the user ensures the tracking information is updated in real-time")
    public void theUserEnsuresTheTrackingInformationIsUpdatedInRealTime() {
        ensureRealTimeTrackingUpdates();
    }

    @Then("tracking information updates reflect real-time changes")
    public void trackingInformationUpdatesReflectRealTimeChanges() {
        verifyRealTimeTrackingUpdates();
    }

    @When("the user checks for any discrepancies in the tracking details provided")
    public void theUserChecksForAnyDiscrepanciesInTheTrackingDetailsProvided() {
        checkTrackingDetailsDiscrepancies();
    }

    @Then("tracking details are accurate and consistent")
    public void trackingDetailsAreAccurateAndConsistent() {
        verifyTrackingDetailsAccuracy();
    }

    @When("the user validates the accuracy of the tracking details displayed")
    public void theUserValidatesTheAccuracyOfTheTrackingDetailsDisplayed() {
        validateTrackingDetailsAccuracy();
    }

    @Then("tracking details are accurate and consistent")
    public void trackingDetailsAreAccurateAndConsistentAgain() {
        verifyTrackingDetailsAccuracy();
    }

    @When("the user verifies the security of tracking information access")
    public void theUserVerifiesTheSecurityOfTrackingInformationAccess() {
        verifyTrackingInformationSecurity();
    }

    @Then("tracking information is secure and requires authentication")
    public void trackingInformationIsSecureAndRequiresAuthentication() {
        verifyTrackingInformationSecurity();
    }

    @When("the user ensures the tracking interface is user-friendly and intuitive")
    public void theUserEnsuresTheTrackingInterfaceIsUserFriendlyAndIntuitive() {
        ensureUserFriendlyInterface();
    }

    @Then("the tracking interface is easy to navigate and understand")
    public void theTrackingInterfaceIsEasyToNavigateAndUnderstand() {
        verifyUserFriendlyInterface();
    }

    @When("the user verifies the responsiveness of the tracking page across devices")
    public void theUserVerifiesTheResponsivenessOfTheTrackingPageAcrossDevices() {
        verifyPageResponsiveness();
    }

    @Then("the tracking page is responsive and loads efficiently on all devices")
    public void theTrackingPageIsResponsiveAndLoadsEfficientlyOnAllDevices() {
        verifyPageResponsiveness();
    }

    @When("the user attempts to track multiple orders simultaneously")
    public void theUserAttemptsToTrackMultipleOrdersSimultaneously() {
        attemptMultipleOrderTracking();
    }

    @Then("the system handles multiple tracking requests without errors")
    public void theSystemHandlesMultipleTrackingRequestsWithoutErrors() {
        verifyMultipleOrderTrackingHandling();
    }

    @When("the user checks if tracking history is available for previous orders")
    public void theUserChecksIfTrackingHistoryIsAvailableForPreviousOrders() {
        checkTrackingHistoryAvailability();
    }

    @Then("tracking history is accessible and displays past tracking information")
    public void trackingHistoryIsAccessibleAndDisplaysPastTrackingInformation() {
        verifyTrackingHistoryAccessibility();
    }
}