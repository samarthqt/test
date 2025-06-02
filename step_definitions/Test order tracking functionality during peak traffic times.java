package com.cucumber.steps;

import com.page_objects.OrderTrackingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTrackingSteps extends OrderTrackingPage {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        launchLoginPage();
    }

    @When("I enter valid user ID {string} and password {string}")
    public void iEnterValidUserIDAndPassword(String userID, String password) {
        enterCredentials(userID, password);
    }

    @Then("I should be successfully logged in and redirected to the homepage")
    public void iShouldBeSuccessfullyLoggedInAndRedirectedToTheHomepage() {
        verifyHomePageRedirection();
    }

    @Given("I am logged in to the e-commerce website")
    public void iAmLoggedInToTheECommerceWebsite() {
        verifyUserLoggedIn();
    }

    @When("I navigate to the 'My Orders' section")
    public void iNavigateToTheMyOrdersSection() {
        navigateToMyOrders();
    }

    @Then("'My Orders' page should display a list of past and current orders")
    public void myOrdersPageShouldDisplayAListOfPastAndCurrentOrders() {
        verifyOrdersListDisplayed();
    }

    @Given("I am on the 'My Orders' page")
    public void iAmOnTheMyOrdersPage() {
        verifyOnMyOrdersPage();
    }

    @When("I select the order with Order ID {string}")
    public void iSelectTheOrderWithOrderID(String orderID) {
        selectOrder(orderID);
    }

    @Then("the order details page should be displayed with tracking options")
    public void theOrderDetailsPageShouldBeDisplayedWithTrackingOptions() {
        verifyOrderDetailsPageDisplayed();
    }

    @Given("I am on the order details page")
    public void iAmOnTheOrderDetailsPage() {
        verifyOnOrderDetailsPage();
    }

    @When("I click on the 'Track Order' button")
    public void iClickOnTheTrackOrderButton() {
        clickTrackOrderButton();
    }

    @Then("I should be redirected to the tracking page with current delivery status")
    public void iShouldBeRedirectedToTheTrackingPageWithCurrentDeliveryStatus() {
        verifyTrackingPageRedirection();
    }

    @Given("I am on the tracking page")
    public void iAmOnTheTrackingPage() {
        verifyOnTrackingPage();
    }

    @When("peak traffic conditions are simulated")
    public void peakTrafficConditionsAreSimulated() {
        simulatePeakTraffic();
    }

    @Then("the system should continue to function efficiently under high load")
    public void theSystemShouldContinueToFunctionEfficientlyUnderHighLoad() {
        verifySystemPerformanceUnderLoad();
    }

    @Given("peak traffic conditions are simulated")
    public void peakTrafficConditionsAreSimulatedAgain() {
        verifyPeakTrafficSimulation();
    }

    @When("I check the tracking information")
    public void iCheckTheTrackingInformation() {
        checkTrackingInformation();
    }

    @Then("tracking details should remain accurate and up-to-date")
    public void trackingDetailsShouldRemainAccurateAndUpToDate() {
        verifyTrackingDetailsAccuracy();
    }

    @When("I monitor the system performance")
    public void iMonitorTheSystemPerformance() {
        monitorSystemPerformance();
    }

    @Then("the system should maintain performance standards without significant delays")
    public void theSystemShouldMaintainPerformanceStandardsWithoutSignificantDelays() {
        verifyPerformanceStandards();
    }

    @When("I log out")
    public void iLogOut() {
        logOut();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() {
        verifySuccessfulLogout();
    }

    @Given("I am logged out from the e-commerce website")
    public void iAmLoggedOutFromTheECommerceWebsite() {
        verifyUserLoggedOut();
    }

    @When("I log back in using valid credentials")
    public void iLogBackInUsingValidCredentials() {
        logBackIn();
    }

    @Then("the tracking status should be consistent and accurate even during peak traffic")
    public void theTrackingStatusShouldBeConsistentAndAccurateEvenDuringPeakTraffic() {
        verifyTrackingStatusConsistency();
    }

    @When("I attempt to track another order")
    public void iAttemptToTrackAnotherOrder() {
        trackAnotherOrder();
    }

    @Then("tracking information should be displayed correctly for the new order")
    public void trackingInformationShouldBeDisplayedCorrectlyForTheNewOrder() {
        verifyNewOrderTrackingInformation();
    }

    @Given("I am tracking an order")
    public void iAmTrackingAnOrder() {
        verifyOrderTracking();
    }

    @When("there are delivery status changes")
    public void thereAreDeliveryStatusChanges() {
        checkDeliveryStatusChanges();
    }

    @Then("I should receive email updates about delivery status changes")
    public void iShouldReceiveEmailUpdatesAboutDeliveryStatusChanges() {
        verifyEmailNotifications();
    }

    @When("I check the integration with the shipping carrier's tracking system")
    public void iCheckTheIntegrationWithTheShippingCarriersTrackingSystem() {
        checkCarrierIntegration();
    }

    @Then("tracking information should be synced accurately with the carrier's system")
    public void trackingInformationShouldBeSyncedAccuratelyWithTheCarriersSystem() {
        verifyCarrierSync();
    }

    @When("tracking fails")
    public void trackingFails() {
        simulateTrackingFailure();
    }

    @Then("relevant error messages should be displayed")
    public void relevantErrorMessagesShouldBeDisplayed() {
        verifyErrorMessages();
    }

    @When("I check the security of tracking information")
    public void iCheckTheSecurityOfTrackingInformation() {
        checkTrackingSecurity();
    }

    @Then("tracking details should be accessible only to authorized users")
    public void trackingDetailsShouldBeAccessibleOnlyToAuthorizedUsers() {
        verifyTrackingSecurity();
    }

    @Given("I am using a mobile device")
    public void iAmUsingAMobileDevice() {
        verifyMobileDeviceUsage();
    }

    @When("I access the tracking functionality")
    public void iAccessTheTrackingFunctionality() {
        accessTrackingFunctionality();
    }

    @Then("tracking functionality should be consistent and efficient on mobile platforms")
    public void trackingFunctionalityShouldBeConsistentAndEfficientOnMobilePlatforms() {
        verifyMobileTrackingEfficiency();
    }
}