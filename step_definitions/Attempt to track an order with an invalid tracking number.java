package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a valid user account with User ID {string} and password {string}")
    public void aValidUserAccountWithUserIDAndPassword(String userId, String password) {
        login(userId, password);
    }

    @When("the user logs in to the e-commerce website")
    public void theUserLogsInToTheECommerceWebsite() {
        verifyHomePageRedirection();
    }

    @Then("the user should be successfully logged in and redirected to the homepage")
    public void theUserShouldBeSuccessfullyLoggedInAndRedirectedToTheHomepage() {
        verifyHomePageRedirection();
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

    @Given("the user is on 'My Orders' page")
    public void theUserIsOnMyOrdersPage() {
        verifyOnMyOrdersPage();
    }

    @When("the user selects the order with Order ID {string}")
    public void theUserSelectsTheOrderWithOrderID(String orderId) {
        selectOrder(orderId);
    }

    @Then("the order details page should be displayed with tracking options")
    public void theOrderDetailsPageShouldBeDisplayedWithTrackingOptions() {
        verifyOrderDetailsPage();
    }

    @Given("the user is on the order details page")
    public void theUserIsOnTheOrderDetailsPage() {
        verifyOnOrderDetailsPage();
    }

    @When("the user clicks on the 'Track Order' button with invalid tracking number {string}")
    public void theUserClicksOnTheTrackOrderButtonWithInvalidTrackingNumber(String trackingNumber) {
        trackOrder(trackingNumber);
    }

    @Then("the system should attempt to retrieve tracking information")
    public void theSystemShouldAttemptToRetrieveTrackingInformation() {
        verifyTrackingAttempt();
    }

    @Then("an error message should be displayed indicating the tracking number is invalid")
    public void anErrorMessageShouldBeDisplayedIndicatingTheTrackingNumberIsInvalid() {
        verifyInvalidTrackingErrorMessage();
    }

    @Given("an error message is displayed for an invalid tracking number")
    public void anErrorMessageIsDisplayedForAnInvalidTrackingNumber() {
        verifyInvalidTrackingErrorMessage();
    }

    @When("the user views the error message")
    public void theUserViewsTheErrorMessage() {
        viewErrorMessage();
    }

    @Then("the system should offer suggestions or links to customer support for assistance")
    public void theSystemShouldOfferSuggestionsOrLinksToCustomerSupportForAssistance() {
        verifySupportSuggestions();
    }

    @When("the user views the error message on different browsers")
    public void theUserViewsTheErrorMessageOnDifferentBrowsers() {
        viewErrorMessageOnBrowsers();
    }

    @Then("the error message should be consistent and clear on all supported browsers")
    public void theErrorMessageShouldBeConsistentAndClearOnAllSupportedBrowsers() {
        verifyErrorMessageConsistency();
    }

    @When("the user logs out from the website")
    public void theUserLogsOutFromTheWebsite() {
        logout();
    }

    @Then("the user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @Given("the user is logged out")
    public void theUserIsLoggedOut() {
        verifyUserLoggedOut();
    }

    @When("the user logs back in and attempts to track the order with invalid tracking number {string}")
    public void theUserLogsBackInAndAttemptsToTrackTheOrderWithInvalidTrackingNumber(String trackingNumber) {
        loginAndTrackOrder(trackingNumber);
    }

    @Then("the system should consistently display the error message for the invalid tracking number")
    public void theSystemShouldConsistentlyDisplayTheErrorMessageForTheInvalidTrackingNumber() {
        verifyConsistentErrorMessage();
    }

    @When("the user attempts to track the order with a different invalid tracking number")
    public void theUserAttemptsToTrackTheOrderWithADifferentInvalidTrackingNumber() {
        trackOrderWithDifferentInvalidNumber();
    }

    @Then("an error message should be displayed for any invalid tracking number")
    public void anErrorMessageShouldBeDisplayedForAnyInvalidTrackingNumber() {
        verifyInvalidTrackingErrorMessage();
    }

    @When("the system logs the error event")
    public void theSystemLogsTheErrorEvent() {
        logErrorEvent();
    }

    @Then("the error should be logged for further analysis")
    public void theErrorShouldBeLoggedForFurtherAnalysis() {
        verifyErrorLogged();
    }

    @When("the system processes the tracking request")
    public void theSystemProcessesTheTrackingRequest() {
        processTrackingRequest();
    }

    @Then("the system should ensure tracking details are secure and inaccessible to unauthorized users")
    public void theSystemShouldEnsureTrackingDetailsAreSecureAndInaccessibleToUnauthorizedUsers() {
        verifyTrackingSecurity();
    }

    @When("the system handles the tracking request")
    public void theSystemHandlesTheTrackingRequest() {
        handleTrackingRequest();
    }

    @Then("error handling should be consistent and efficient on mobile platforms")
    public void errorHandlingShouldBeConsistentAndEfficientOnMobilePlatforms() {
        verifyMobileErrorHandling();
    }

    @When("the user attempts to track an order with a valid tracking number")
    public void theUserAttemptsToTrackAnOrderWithAValidTrackingNumber() {
        trackOrderWithValidNumber();
    }

    @Then("the system should display correct tracking information for valid numbers")
    public void theSystemShouldDisplayCorrectTrackingInformationForValidNumbers() {
        verifyValidTrackingInformation();
    }

    @When("the system sends notifications")
    public void theSystemSendsNotifications() {
        sendNotifications();
    }

    @Then("the user should receive email notifications if tracking fails due to invalid numbers")
    public void theUserShouldReceiveEmailNotificationsIfTrackingFailsDueToInvalidNumbers() {
        verifyEmailNotifications();
    }
}