package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has completed a purchase")
    public void aUserHasCompletedAPurchase() {
        completePurchase();
    }

    @When("the user navigates to the order tracking page")
    public void theUserNavigatesToTheOrderTrackingPage() {
        navigateToOrderTrackingPage();
    }

    @Then("the user should see the real-time status of their order")
    public void theUserShouldSeeTheRealTimeStatusOfTheirOrder() {
        verifyRealTimeOrderStatus();
    }

    @Given("a user has an active order")
    public void aUserHasAnActiveOrder() {
        verifyActiveOrder();
    }

    @When("the order status changes")
    public void theOrderStatusChanges() {
        simulateOrderStatusChange();
    }

    @Then("the user should receive a notification about the status change")
    public void theUserShouldReceiveANotificationAboutTheStatusChange() {
        verifyNotificationReceived();
    }

    @Given("a user is viewing their order tracking information")
    public void aUserIsViewingTheirOrderTrackingInformation() {
        viewOrderTrackingInformation();
    }

    @When("the user looks at the estimated delivery date")
    public void theUserLooksAtTheEstimatedDeliveryDate() {
        checkEstimatedDeliveryDate();
    }

    @Then("the user should see an accurate estimated delivery date based on current order status")
    public void theUserShouldSeeAnAccurateEstimatedDeliveryDateBasedOnCurrentOrderStatus() {
        verifyEstimatedDeliveryDate();
    }

    @Given("a user is on the order tracking page")
    public void aUserIsOnTheOrderTrackingPage() {
        navigateToOrderTrackingPage();
    }

    @When("the user selects the option to view tracking history")
    public void theUserSelectsTheOptionToViewTrackingHistory() {
        selectViewTrackingHistory();
    }

    @Then("the user should see a detailed history of all status updates for their order")
    public void theUserShouldSeeADetailedHistoryOfAllStatusUpdatesForTheirOrder() {
        verifyTrackingHistory();
    }

    @Given("a user is trying to access the order tracking page")
    public void aUserIsTryingToAccessTheOrderTrackingPage() {
        attemptAccessOrderTrackingPage();
    }

    @When("there is a system error or outage")
    public void thereIsASystemErrorOrOutage() {
        simulateSystemError();
    }

    @Then("the user should see an appropriate error message indicating the issue")
    public void theUserShouldSeeAnAppropriateErrorMessageIndicatingTheIssue() {
        verifyErrorMessage();
    }

    @Given("a user is viewing their order tracking information")
    public void aUserIsViewingTheirOrderTrackingInformation() {
        viewOrderTrackingInformation();
    }

    @When("the user checks the delivery address")
    public void theUserChecksTheDeliveryAddress() {
        checkDeliveryAddress();
    }

    @Then("the user should see the correct delivery address associated with their order")
    public void theUserShouldSeeTheCorrectDeliveryAddressAssociatedWithTheirOrder() {
        verifyDeliveryAddress();
    }

    @Given("a user wants to update their contact information for order notifications")
    public void aUserWantsToUpdateTheirContactInformationForOrderNotifications() {
        navigateToContactInformationSettings();
    }

    @When("the user navigates to the contact information settings")
    public void theUserNavigatesToTheContactInformationSettings() {
        openContactInformationSettings();
    }

    @Then("the user should be able to update their contact information successfully")
    public void theUserShouldBeAbleToUpdateTheirContactInformationSuccessfully() {
        updateContactInformation();
    }

    @Given("a user is using a mobile device")
    public void aUserIsUsingAMobileDevice() {
        verifyMobileDeviceUsage();
    }

    @When("the user accesses the order tracking feature")
    public void theUserAccessesTheOrderTrackingFeature() {
        accessOrderTrackingFeature();
    }

    @Then("the user should have a mobile-friendly experience with all functionalities available")
    public void theUserShouldHaveAMobileFriendlyExperienceWithAllFunctionalitiesAvailable() {
        verifyMobileFriendlyExperience();
    }

    @Given("a user prefers to view order tracking in a different language")
    public void aUserPrefersToViewOrderTrackingInADifferentLanguage() {
        navigateToLanguageSettings();
    }

    @When("the user changes the language settings")
    public void theUserChangesTheLanguageSettings() {
        changeLanguageSettings();
    }

    @Then("the order tracking information should be displayed in the selected language")
    public void theOrderTrackingInformationShouldBeDisplayedInTheSelectedLanguage() {
        verifyLanguageChange();
    }
}