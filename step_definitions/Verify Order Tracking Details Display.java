package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with a recent purchase")
    public void aUserAccountWithARecentPurchase() {
        verifyRecentPurchase();
    }

    @Given("the user is logged in using valid credentials")
    public void theUserIsLoggedInUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the 'Track Order' section")
    public void theUserNavigatesToTheTrackOrderSection() {
        navigateToTrackOrderSection();
    }

    @When("enters the tracking number {string} in the tracking field")
    public void entersTheTrackingNumberInTheTrackingField(String trackingNumber) {
        enterTrackingNumber(trackingNumber);
    }

    @When("submits the tracking request")
    public void submitsTheTrackingRequest() {
        submitTrackingRequest();
    }

    @Then("the current status of the order is displayed correctly")
    public void theCurrentStatusOfTheOrderIsDisplayedCorrectly() {
        verifyCurrentStatusDisplayed();
    }

    @Then("the estimated delivery time is shown")
    public void theEstimatedDeliveryTimeIsShown() {
        verifyEstimatedDeliveryTime();
    }

    @Then("the carrier information is displayed correctly")
    public void theCarrierInformationIsDisplayedCorrectly() {
        verifyCarrierInformationDisplayed();
    }

    @Then("the tracking details are accurate and consistent")
    public void theTrackingDetailsAreAccurateAndConsistent() {
        verifyTrackingDetailsAccuracy();
    }

    @Then("the tracking information updates reflect real-time changes")
    public void theTrackingInformationUpdatesReflectRealTimeChanges() {
        verifyRealTimeUpdates();
    }

    @Then("tracking information is secure and requires authentication")
    public void trackingInformationIsSecureAndRequiresAuthentication() {
        verifyTrackingInformationSecurity();
    }

    @Then("the tracking interface is easy to navigate and understand")
    public void theTrackingInterfaceIsEasyToNavigateAndUnderstand() {
        verifyInterfaceEaseOfUse();
    }

    @Then("the tracking page is responsive and loads efficiently on all devices")
    public void theTrackingPageIsResponsiveAndLoadsEfficientlyOnAllDevices() {
        verifyPageResponsiveness();
    }

    @Then("the system handles multiple tracking requests without errors")
    public void theSystemHandlesMultipleTrackingRequestsWithoutErrors() {
        verifyMultipleRequestsHandling();
    }

    @Then("tracking history is accessible and displays past tracking information")
    public void trackingHistoryIsAccessibleAndDisplaysPastTrackingInformation() {
        verifyTrackingHistoryAccessibility();
    }

    @Given("a valid tracking number is provided post-purchase")
    public void aValidTrackingNumberIsProvidedPostPurchase() {
        verifyTrackingNumberPostPurchase();
    }

    @When("the tracking request is submitted")
    public void theTrackingRequestIsSubmitted() {
        submitTrackingRequest();
    }

    @Then("tracking details are accurate and consistent")
    public void trackingDetailsAreAccurateAndConsistent() {
        verifyTrackingDetailsAccuracy();
    }

    @Given("a user is logged in using valid credentials")
    public void aUserIsLoggedInUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user accesses tracking information")
    public void theUserAccessesTrackingInformation() {
        accessTrackingInformation();
    }

    @Then("tracking information is secure and requires authentication")
    public void trackingInformationIsSecureAndRequiresAuthentication() {
        verifyTrackingInformationSecurity();
    }

    @Given("a user is on the 'Track Order' page")
    public void aUserIsOnTheTrackOrderPage() {
        navigateToTrackOrderPage();
    }

    @When("the user interacts with the tracking interface")
    public void theUserInteractsWithTheTrackingInterface() {
        interactWithTrackingInterface();
    }

    @Then("the interface is easy to navigate and understand")
    public void theInterfaceIsEasyToNavigateAndUnderstand() {
        verifyInterfaceEaseOfUse();
    }

    @Given("a user accesses the tracking page on different devices")
    public void aUserAccessesTheTrackingPageOnDifferentDevices() {
        accessTrackingPageOnDevices();
    }

    @When("the page loads")
    public void thePageLoads() {
        verifyPageLoad();
    }

    @Then("the tracking page is responsive and loads efficiently on all devices")
    public void theTrackingPageIsResponsiveAndLoadsEfficientlyOnAllDevices() {
        verifyPageResponsiveness();
    }

    @Given("a user has multiple orders to track")
    public void aUserHasMultipleOrdersToTrack() {
        verifyMultipleOrders();
    }

    @When("the user submits multiple tracking requests")
    public void theUserSubmitsMultipleTrackingRequests() {
        submitMultipleTrackingRequests();
    }

    @Then("the system handles multiple tracking requests without errors")
    public void theSystemHandlesMultipleTrackingRequestsWithoutErrors() {
        verifyMultipleRequestsHandling();
    }

    @Given("a user has previous orders")
    public void aUserHasPreviousOrders() {
        verifyPreviousOrders();
    }

    @When("the user accesses tracking history")
    public void theUserAccessesTrackingHistory() {
        accessTrackingHistory();
    }

    @Then("tracking history is accessible and displays past tracking information")
    public void trackingHistoryIsAccessibleAndDisplaysPastTrackingInformation() {
        verifyTrackingHistoryAccessibility();
    }
}