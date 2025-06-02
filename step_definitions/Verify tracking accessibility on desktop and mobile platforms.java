package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.TrackingPage;

public class TrackingSteps extends TrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has a valid order with tracking information available")
    public void theUserHasAValidOrderWithTrackingInformationAvailable() {
        // Assume order is already available in the system
    }

    @When("the user logs into the application using a desktop browser")
    public void theUserLogsIntoTheApplicationUsingADesktopBrowser() {
        loginToApplication("desktop");
    }

    @Then("the user is successfully logged into the application on a desktop browser")
    public void theUserIsSuccessfullyLoggedIntoTheApplicationOnADesktopBrowser() {
        verifyLoginSuccess("desktop");
    }

    @Given("the user is logged into the application on a desktop browser")
    public void theUserIsLoggedIntoTheApplicationOnADesktopBrowser() {
        verifyLoginSuccess("desktop");
    }

    @When("the user navigates to the 'Order History' section from the dashboard")
    public void theUserNavigatesToTheOrderHistorySectionFromTheDashboard() {
        navigateToOrderHistory();
    }

    @Then("the Order History section is displayed with a list of past orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @Given("the Order History section is displayed with a list of past orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects an order with tracking information available")
    public void theUserSelectsAnOrderWithTrackingInformationAvailable() {
        selectOrderWithTracking();
    }

    @Then("the order details page is displayed with tracking information visible")
    public void theOrderDetailsPageIsDisplayedWithTrackingInformationVisible() {
        verifyOrderDetailsWithTracking();
    }

    @Given("the order details page is displayed with tracking information visible")
    public void theOrderDetailsPageIsDisplayedWithTrackingInformationVisible() {
        verifyOrderDetailsWithTracking();
    }

    @When("the user accesses the tracking information link from the order details page")
    public void theUserAccessesTheTrackingInformationLinkFromTheOrderDetailsPage() {
        accessTrackingInformationLink();
    }

    @Then("the tracking information is displayed correctly on the desktop browser")
    public void theTrackingInformationIsDisplayedCorrectlyOnTheDesktopBrowser() {
        verifyTrackingInformationDisplayed("desktop");
    }

    @When("the user logs into the application using a mobile device")
    public void theUserLogsIntoTheApplicationUsingAMobileDevice() {
        loginToApplication("mobile");
    }

    @Then("the user is successfully logged into the application on a mobile device")
    public void theUserIsSuccessfullyLoggedIntoTheApplicationOnAMobileDevice() {
        verifyLoginSuccess("mobile");
    }

    @Given("the user is logged into the application on a mobile device")
    public void theUserIsLoggedIntoTheApplicationOnAMobileDevice() {
        verifyLoginSuccess("mobile");
    }

    @When("the user navigates to the 'Order History' section from the mobile dashboard")
    public void theUserNavigatesToTheOrderHistorySectionFromTheMobileDashboard() {
        navigateToOrderHistory();
    }

    @Then("the Order History section is displayed with a list of past orders")
    public void theOrderHistorySectionIsDisplayedWithAListOfPastOrders() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects the same order with tracking information available")
    public void theUserSelectsTheSameOrderWithTrackingInformationAvailable() {
        selectOrderWithTracking();
    }

    @Then("the order details page is displayed with tracking information visible on mobile")
    public void theOrderDetailsPageIsDisplayedWithTrackingInformationVisibleOnMobile() {
        verifyOrderDetailsWithTracking();
    }

    @When("the user accesses the tracking information link from the order details page on mobile")
    public void theUserAccessesTheTrackingInformationLinkFromTheOrderDetailsPageOnMobile() {
        accessTrackingInformationLink();
    }

    @Then("the tracking information is displayed correctly on the mobile device")
    public void theTrackingInformationIsDisplayedCorrectlyOnTheMobileDevice() {
        verifyTrackingInformationDisplayed("mobile");
    }

    @Given("the tracking information is displayed correctly on both desktop and mobile platforms")
    public void theTrackingInformationIsDisplayedCorrectlyOnBothDesktopAndMobilePlatforms() {
        verifyTrackingInformationDisplayed("desktop");
        verifyTrackingInformationDisplayed("mobile");
    }

    @When("the user switches between desktop and mobile platforms")
    public void theUserSwitchesBetweenDesktopAndMobilePlatforms() {
        switchPlatforms();
    }

    @Then("the tracking information remains consistent across both platforms")
    public void theTrackingInformationRemainsConsistentAcrossBothPlatforms() {
        verifyTrackingConsistency();
    }

    @When("the user views the tracking information on different screen sizes")
    public void theUserViewsTheTrackingInformationOnDifferentScreenSizes() {
        viewOnDifferentScreenSizes();
    }

    @Then("the tracking information layout adjusts correctly to different screen sizes")
    public void theTrackingInformationLayoutAdjustsCorrectlyToDifferentScreenSizes() {
        verifyLayoutAdjustment();
    }

    @When("the user accesses the tracking information")
    public void theUserAccessesTheTrackingInformation() {
        accessTrackingInformation();
    }

    @Then("the tracking information loads within acceptable time limits on both platforms")
    public void theTrackingInformationLoadsWithinAcceptableTimeLimitsOnBothPlatforms() {
        verifyLoadingTime();
    }

    @When("there are updates to the tracking information")
    public void thereAreUpdatesToTheTrackingInformation() {
        updateTrackingInformation();
    }

    @Then("the tracking information updates are reflected in real-time on both platforms")
    public void theTrackingInformationUpdatesAreReflectedInRealTimeOnBothPlatforms() {
        verifyRealTimeUpdates();
    }

    @Then("no errors occur when accessing tracking information on either platform")
    public void noErrorsOccurWhenAccessingTrackingInformationOnEitherPlatform() {
        verifyNoErrors();
    }

    @When("the user interacts with the tracking information interface")
    public void theUserInteractsWithTheTrackingInformationInterface() {
        interactWithInterface();
    }

    @Then("the user interface for tracking information is intuitive and easy to navigate on both platforms")
    public void theUserInterfaceForTrackingInformationIsIntuitiveAndEasyToNavigateOnBothPlatforms() {
        verifyUserInterface();
    }

    @Then("tracking information access is secure and requires valid user authentication on both platforms")
    public void trackingInformationAccessIsSecureAndRequiresValidUserAuthenticationOnBothPlatforms() {
        verifySecurity();
    }
}