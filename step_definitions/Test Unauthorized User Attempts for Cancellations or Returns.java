package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class UnauthorizedUserSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user logs into the account with User ID {string}")
    public void theUserLogsIntoTheAccountWithUserID(String userID) {
        loginUser(userID);
    }

    @Given("navigates to the order history section")
    public void navigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Given("selects the order with Order ID {string}")
    public void selectsTheOrderWithOrderID(String orderID) {
        selectOrder(orderID);
    }

    @Given("the order details page is displayed with status {string}")
    public void theOrderDetailsPageIsDisplayedWithStatus(String status) {
        verifyOrderStatus(status);
    }

    @Given("cancellation and return options are visible on the page")
    public void cancellationAndReturnOptionsAreVisibleOnThePage() {
        verifyCancellationAndReturnOptionsVisible();
    }

    @When("the user attempts to initiate a cancellation for the order")
    public void theUserAttemptsToInitiateACancellationForTheOrder() {
        attemptCancellation();
    }

    @When("the user attempts to initiate a return for the order")
    public void theUserAttemptsToInitiateAReturnForTheOrder() {
        attemptReturn();
    }

    @Then("the system restricts unauthorized users from proceeding")
    public void theSystemRestrictsUnauthorizedUsersFromProceeding() {
        verifyUnauthorizedRestriction();
    }

    @Then("an error message is displayed for unauthorized attempts")
    public void anErrorMessageIsDisplayedForUnauthorizedAttempts() {
        verifyErrorMessageDisplayed();
    }

    @Then("unauthorized access attempts are logged")
    public void unauthorizedAccessAttemptsAreLogged() {
        verifyAccessAttemptsLogged();
    }

    @Then("the user receives notifications for unauthorized attempts")
    public void theUserReceivesNotificationsForUnauthorizedAttempts() {
        verifyNotificationsReceived();
    }

    @Then("the order status remains unchanged after unauthorized attempts")
    public void theOrderStatusRemainsUnchangedAfterUnauthorizedAttempts() {
        verifyOrderStatusUnchanged();
    }

    @Then("restrictions are consistent on all devices")
    public void restrictionsAreConsistentOnAllDevices() {
        verifyRestrictionsConsistency();
    }

    @Then("an authentication prompt is displayed for unauthorized users")
    public void anAuthenticationPromptIsDisplayedForUnauthorizedUsers() {
        verifyAuthenticationPromptDisplayed();
    }
}