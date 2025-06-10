package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an order has been shipped")
    public void anOrderHasBeenShipped() {
        verifyOrderShipped();
    }

    @When("the user views the order details")
    public void theUserViewsTheOrderDetails() {
        viewOrderDetails();
    }

    @Then("the user should see a tracking number for the order")
    public void theUserShouldSeeATrackingNumberForTheOrder() {
        verifyTrackingNumberDisplayed();
    }

    @Given("an order is in transit")
    public void anOrderIsInTransit() {
        verifyOrderInTransit();
    }

    @When("the order status changes")
    public void theOrderStatusChanges() {
        changeOrderStatus();
    }

    @Then("the system should update the order status in real-time")
    public void theSystemShouldUpdateTheOrderStatusInRealTime() {
        verifyOrderStatusUpdated();
    }

    @Given("an order is eligible for cancellation")
    public void anOrderIsEligibleForCancellation() {
        verifyOrderEligibleForCancellation();
    }

    @When("the user requests to cancel the order")
    public void theUserRequestsToCancelTheOrder() {
        requestOrderCancellation();
    }

    @Then("the order should be canceled according to merchant policy")
    public void theOrderShouldBeCanceledAccordingToMerchantPolicy() {
        verifyOrderCanceled();
    }

    @Given("an order is eligible for return")
    public void anOrderIsEligibleForReturn() {
        verifyOrderEligibleForReturn();
    }

    @When("the user requests to return the order")
    public void theUserRequestsToReturnTheOrder() {
        requestOrderReturn();
    }

    @Then("the order should be returned according to merchant policy")
    public void theOrderShouldBeReturnedAccordingToMerchantPolicy() {
        verifyOrderReturned();
    }

    @Given("an order status has changed")
    public void anOrderStatusHasChanged() {
        verifyOrderStatusChanged();
    }

    @When("the system updates the status")
    public void theSystemUpdatesTheStatus() {
        updateOrderStatus();
    }

    @Then("the user should receive a notification about the status update")
    public void theUserShouldReceiveANotificationAboutTheStatusUpdate() {
        verifyNotificationReceived();
    }

    @Given("there is an error in tracking the order")
    public void thereIsAnErrorInTrackingTheOrder() {
        simulateTrackingError();
    }

    @When("the user attempts to track the order")
    public void theUserAttemptsToTrackTheOrder() {
        attemptToTrackOrder();
    }

    @Then("the system should notify the user about the tracking error")
    public void theSystemShouldNotifyTheUserAboutTheTrackingError() {
        verifyTrackingErrorNotification();
    }
}