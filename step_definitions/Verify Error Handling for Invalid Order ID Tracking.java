package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid credentials")
    public void theUserHasValidCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        clickLoginButton();
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndRedirectedToTheDashboard() {
        verifyDashboardDisplayed();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        verifyDashboardDisplayed();
    }

    @When("the user navigates to the 'Order Tracking' section")
    public void theUserNavigatesToTheOrderTrackingSection() {
        navigateToOrderTracking();
    }

    @Then("the 'Order Tracking' section is displayed with a list of orders eligible for tracking")
    public void theOrderTrackingSectionIsDisplayedWithAListOfOrdersEligibleForTracking() {
        verifyOrderTrackingSectionDisplayed();
    }

    @Given("the user is in the 'Order Tracking' section")
    public void theUserIsInTheOrderTrackingSection() {
        verifyOrderTrackingSectionDisplayed();
    }

    @When("the user enters an invalid order ID {string}")
    public void theUserEntersAnInvalidOrderID(String orderID) {
        enterOrderID(orderID);
    }

    @Then("the system displays an error message indicating the order ID is invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingTheOrderIDIsInvalid() {
        verifyInvalidOrderIDErrorMessage();
    }

    @Given("the user has entered an invalid order ID {string}")
    public void theUserHasEnteredAnInvalidOrderID(String orderID) {
        enterOrderID(orderID);
    }

    @When("the user attempts to track the order")
    public void theUserAttemptsToTrackTheOrder() {
        clickTrackOrderButton();
    }

    @Then("the system prevents tracking and displays an error message")
    public void theSystemPreventsTrackingAndDisplaysAnErrorMessage() {
        verifyInvalidOrderIDErrorMessage();
    }

    @Given("the system displays an error message for invalid order ID")
    public void theSystemDisplaysAnErrorMessageForInvalidOrderID() {
        verifyInvalidOrderIDErrorMessage();
    }

    @Then("the error message suggests checking the order ID and trying again")
    public void theErrorMessageSuggestsCheckingTheOrderIDAndTryingAgain() {
        verifyErrorMessageGuidance();
    }

    @Given("the user has entered an invalid order ID previously")
    public void theUserHasEnteredAnInvalidOrderIDPreviously() {
        verifyInvalidOrderIDErrorMessage();
    }

    @When("the user enters a valid order ID")
    public void theUserEntersAValidOrderID() {
        String validOrderID = testHarness.getData("OrderData", "ValidOrderID");
        enterOrderID(validOrderID);
    }

    @Then("the user can successfully track the order")
    public void theUserCanSuccessfullyTrackTheOrder() {
        verifyOrderTrackingSuccess();
    }

    @Given("the user has attempted to track an order with an invalid ID")
    public void theUserHasAttemptedToTrackAnOrderWithAnInvalidID() {
        verifyInvalidOrderIDErrorMessage();
    }

    @Then("the invalid tracking attempt is logged in the system for review")
    public void theInvalidTrackingAttemptIsLoggedInTheSystemForReview() {
        verifyInvalidTrackingLogged();
    }

    @Given("the user attempts to track orders with multiple invalid IDs")
    public void theUserAttemptsToTrackOrdersWithMultipleInvalidIDs() {
        attemptMultipleInvalidTrackings();
    }

    @Then("the system consistently displays error messages for repeated invalid attempts")
    public void theSystemConsistentlyDisplaysErrorMessagesForRepeatedInvalidAttempts() {
        verifyConsistentErrorMessages();
    }

    @Then("the user receives a notification regarding the invalid tracking attempt")
    public void theUserReceivesANotificationRegardingTheInvalidTrackingAttempt() {
        verifyInvalidTrackingNotification();
    }

    @Given("the user is facing issues with order tracking")
    public void theUserIsFacingIssuesWithOrderTracking() {
        verifyOrderTrackingIssues();
    }

    @When("the user seeks help or support")
    public void theUserSeeksHelpOrSupport() {
        accessHelpOrSupport();
    }

    @Then("help or support options are available for tracking issues")
    public void helpOrSupportOptionsAreAvailableForTrackingIssues() {
        verifyHelpOrSupportOptions();
    }

    @When("the user chooses to navigate back to the dashboard")
    public void theUserChoosesToNavigateBackToTheDashboard() {
        navigateBackToDashboard();
    }

    @Then("the user is redirected to the dashboard without any issues")
    public void theUserIsRedirectedToTheDashboardWithoutAnyIssues() {
        verifyDashboardDisplayed();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user logs out from the account")
    public void theUserLogsOutFromTheAccount() {
        logout();
    }

    @Then("the user is successfully logged out and redirected to the login page")
    public void theUserIsSuccessfullyLoggedOutAndRedirectedToTheLoginPage() {
        verifyLogoutSuccess();
    }
}