package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a valid user account with login credentials")
    public void aValidUserAccountWithLoginCredentials() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        login(username, password);
    }

    @When("the user logs in to the e-commerce website")
    public void theUserLogsInToTheECommerceWebsite() {
        verifyLoginSuccessful();
    }

    @Then("the user should be successfully logged in and redirected to the homepage")
    public void theUserShouldBeSuccessfullyLoggedInAndRedirectedToTheHomepage() {
        verifyHomePageDisplayed();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the 'My Orders' section")
    public void theUserNavigatesToTheMyOrdersSection() {
        navigateToMyOrders();
    }

    @Then("'My Orders' page should display a list of past and current orders")
    public void myOrdersPageShouldDisplayAListOfPastAndCurrentOrders() {
        verifyOrdersListDisplayed();
    }

    @Given("the user is on the 'My Orders' page")
    public void theUserIsOnTheMyOrdersPage() {
        verifyOnMyOrdersPage();
    }

    @When("the user selects the order to be tracked")
    public void theUserSelectsTheOrderToBeTracked() {
        selectOrderToTrack();
    }

    @Then("the order details page should be displayed with tracking options")
    public void theOrderDetailsPageShouldBeDisplayedWithTrackingOptions() {
        verifyOrderDetailsPageDisplayed();
    }

    @Given("the user is on the order details page")
    public void theUserIsOnTheOrderDetailsPage() {
        verifyOnOrderDetailsPage();
    }

    @When("the user clicks on the 'Track Order' button")
    public void theUserClicksOnTheTrackOrderButton() {
        clickTrackOrderButton();
    }

    @Then("the user should be redirected to the tracking page with current delivery status")
    public void theUserShouldBeRedirectedToTheTrackingPageWithCurrentDeliveryStatus() {
        verifyTrackingPageDisplayed();
    }

    @Given("the user is on the tracking page")
    public void theUserIsOnTheTrackingPage() {
        verifyOnTrackingPage();
    }

    @When("the tracking information is displayed")
    public void theTrackingInformationIsDisplayed() {
        verifyTrackingInformationDisplayed();
    }

    @Then("the tracking details should include current status, estimated delivery time, and location")
    public void theTrackingDetailsShouldIncludeCurrentStatusEstimatedDeliveryTimeAndLocation() {
        verifyTrackingDetails();
    }

    @When("there are changes in delivery status")
    public void thereAreChangesInDeliveryStatus() {
        checkForDeliveryStatusChanges();
    }

    @Then("notifications should be displayed")
    public void notificationsShouldBeDisplayed() {
        verifyNotificationsDisplayed();
    }

    @When("the page loads")
    public void thePageLoads() {
        verifyPageLoad();
    }

    @Then("the tracking page should load efficiently without delays")
    public void theTrackingPageShouldLoadEfficientlyWithoutDelays() {
        verifyPageLoadEfficiency();
    }

    @When("the user logs out from the website")
    public void theUserLogsOutFromTheWebsite() {
        logout();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        verifyLogoutSuccessful();
    }

    @Given("the user has logged out")
    public void theUserHasLoggedOut() {
        verifyUserLoggedOut();
    }

    @When("the user logs back in")
    public void theUserLogsBackIn() {
        reLogin();
    }

    @Then("the tracking status should be consistent and accurate")
    public void theTrackingStatusShouldBeConsistentAndAccurate() {
        verifyTrackingStatusConsistency();
    }

    @When("the user attempts to track another order")
    public void theUserAttemptsToTrackAnotherOrder() {
        trackAnotherOrder();
    }

    @Then("tracking information should be displayed correctly for the new order")
    public void trackingInformationShouldBeDisplayedCorrectlyForTheNewOrder() {
        verifyNewOrderTrackingInformation();
    }

    @Given("the user is tracking an order")
    public void theUserIsTrackingAnOrder() {
        verifyUserTrackingOrder();
    }

    @Then("the user should receive email updates about delivery status changes")
    public void theUserShouldReceiveEmailUpdatesAboutDeliveryStatusChanges() {
        verifyEmailUpdatesReceived();
    }

    @When("tracking information is updated")
    public void trackingInformationIsUpdated() {
        updateTrackingInformation();
    }

    @Then("tracking information should be synced accurately with the carrier's system")
    public void trackingInformationShouldBeSyncedAccuratelyWithTheCarriersSystem() {
        verifyCarrierSystemSync();
    }

    @When("tracking fails")
    public void trackingFails() {
        simulateTrackingFailure();
    }

    @Then("relevant error messages should be displayed")
    public void relevantErrorMessagesShouldBeDisplayed() {
        verifyErrorMessagesDisplayed();
    }

    @When("accessing tracking details")
    public void accessingTrackingDetails() {
        accessTrackingDetails();
    }

    @Then("tracking details should be accessible only to authorized users")
    public void trackingDetailsShouldBeAccessibleOnlyToAuthorizedUsers() {
        verifyTrackingDetailsSecurity();
    }

    @Given("the user is accessing the website on a mobile device")
    public void theUserIsAccessingTheWebsiteOnAMobileDevice() {
        verifyMobileAccess();
    }

    @When("the user tracks an order")
    public void theUserTracksAnOrder() {
        trackOrderOnMobile();
    }

    @Then("tracking functionality should be consistent and efficient on mobile platforms")
    public void trackingFunctionalityShouldBeConsistentAndEfficientOnMobilePlatforms() {
        verifyMobileTrackingFunctionality();
    }
}