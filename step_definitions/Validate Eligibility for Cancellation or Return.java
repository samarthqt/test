package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.EligibilityPage;

public class EligibilitySteps extends EligibilityPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the account with Order ID {string}")
    public void theUserIsLoggedIntoTheAccountWithOrderID(String orderID) {
        loginToAccount(orderID);
    }

    @When("the user navigates to the order history section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @When("selects the order with Order ID {string}")
    public void selectsTheOrderWithOrderID(String orderID) {
        selectOrder(orderID);
    }

    @When("locates the cancellation and return options on the order details page")
    public void locatesTheCancellationAndReturnOptionsOnTheOrderDetailsPage() {
        locateCancellationAndReturnOptions();
    }

    @When("attempts to initiate a return for the order")
    public void attemptsToInitiateAReturnForTheOrder() {
        initiateReturn();
    }

    @Then("the system checks the merchant's policy for eligibility")
    public void theSystemChecksTheMerchantsPolicyForEligibility() {
        checkMerchantsPolicy();
    }

    @Then("displays the eligibility status")
    public void displaysTheEligibilityStatus() {
        displayEligibilityStatus();
    }

    @Then("allows return if the order is within the eligible period")
    public void allowsReturnIfTheOrderIsWithinTheEligiblePeriod() {
        allowReturnIfEligible();
    }

    @Then("denies return for ineligible orders")
    public void deniesReturnForIneligibleOrders() {
        denyReturnIfIneligible();
    }

    @Then("prompts with the merchant's policy details when denying returns")
    public void promptsWithTheMerchantsPolicyDetailsWhenDenyingReturns() {
        promptPolicyDetails();
    }

    @Then("the system logs the eligibility check for audit purposes")
    public void theSystemLogsTheEligibilityCheckForAuditPurposes() {
        logEligibilityCheck();
    }

    @Then("the user receives notifications for eligibility status")
    public void theUserReceivesNotificationsForEligibilityStatus() {
        notifyUserEligibilityStatus();
    }

    @Then("the system updates the order status based on eligibility")
    public void theSystemUpdatesTheOrderStatusBasedOnEligibility() {
        updateOrderStatus();
    }

    @Then("the eligibility checks are consistent on all devices")
    public void theEligibilityChecksAreConsistentOnAllDevices() {
        verifyConsistencyAcrossDevices();
    }

    @Then("the system allows cancellation for eligible orders")
    public void theSystemAllowsCancellationForEligibleOrders() {
        allowCancellationIfEligible();
    }

    @Then("the options are updated according to policy changes")
    public void theOptionsAreUpdatedAccordingToPolicyChanges() {
        updateOptionsBasedOnPolicyChanges();
    }
}