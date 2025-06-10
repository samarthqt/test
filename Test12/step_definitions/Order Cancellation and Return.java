package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class OrderCancellationSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an authenticated user is viewing the order details page")
    public void authenticatedUserViewingOrderDetails() {
        authenticateUser();
        navigateToOrderDetailsPage();
    }

    @When("the user sees the cancellation and return options")
    public void userSeesCancellationAndReturnOptions() {
        verifyCancellationAndReturnOptionsVisible();
    }

    @Then("the user should be able to cancel or request a return for their order")
    public void userCanCancelOrRequestReturn() {
        performCancelOrReturnAction();
    }

    @Given("an authenticated user requests a return for an order")
    public void authenticatedUserRequestsReturn() {
        authenticateUser();
        requestReturnForOrder();
    }

    @When("the system checks the merchant's return policy")
    public void systemChecksMerchantReturnPolicy() {
        checkMerchantReturnPolicy();
    }

    @Then("the system should validate the return request")
    public void systemValidatesReturnRequest() {
        validateReturnRequest();
    }

    @Given("an authenticated user cancels or requests a return for an order")
    public void authenticatedUserCancelsOrRequestsReturn() {
        authenticateUser();
        cancelOrRequestReturn();
    }

    @When("the cancellation or return is processed successfully")
    public void cancellationOrReturnProcessedSuccessfully() {
        processCancellationOrReturn();
    }

    @Then("the user should receive a confirmation notification")
    public void userReceivesConfirmationNotification() {
        verifyConfirmationNotification();
    }

    @Given("an authenticated user attempts to cancel or return an order")
    public void authenticatedUserAttemptsCancelOrReturn() {
        authenticateUser();
        attemptCancelOrReturn();
    }

    @When("an error occurs during the process")
    public void errorOccursDuringProcess() {
        simulateErrorDuringProcess();
    }

    @Then("the system should handle the error gracefully and inform the user of the issue")
    public void systemHandlesErrorGracefully() {
        handleAndInformError();
    }

    @Given("a user is not authenticated")
    public void userNotAuthenticated() {
        ensureUserNotAuthenticated();
    }

    @When("the user attempts to cancel or return an order")
    public void userAttemptsCancelOrReturn() {
        attemptCancelOrReturn();
    }

    @Then("the system should restrict the action and inform the user to authenticate")
    public void systemRestrictsActionAndInformsUser() {
        restrictActionAndInformAuthentication();
    }

    @Given("an authenticated user cancels or requests a return for an order")
    public void authenticatedUserCancelsOrRequestsReturnForAudit() {
        authenticateUser();
        cancelOrRequestReturn();
    }

    @When("the action is completed")
    public void actionIsCompleted() {
        completeAction();
    }

    @Then("the system should log the cancellation or return action for auditing purposes")
    public void systemLogsActionForAudit() {
        logActionForAudit();
    }

    @Given("an authenticated user requests a return for an order")
    public void authenticatedUserRequestsReturnForIntegration() {
        authenticateUser();
        requestReturnForOrder();
    }

    @When("the system integrates with merchant systems to check policies")
    public void systemIntegratesWithMerchantSystems() {
        integrateWithMerchantSystems();
    }

    @Then("the integration should be reliable and accurate")
    public void integrationIsReliableAndAccurate() {
        verifyIntegrationReliabilityAndAccuracy();
    }

    @Given("an authenticated user requests a return for an order")
    public void authenticatedUserRequestsReturnForFees() {
        authenticateUser();
        requestReturnForOrder();
    }

    @When("there are fees associated with the return")
    public void feesAssociatedWithReturn() {
        checkFeesAssociatedWithReturn();
    }

    @Then("the user should be informed of any fees before proceeding with the return request")
    public void userInformedOfFees() {
        informUserOfFees();
    }
}