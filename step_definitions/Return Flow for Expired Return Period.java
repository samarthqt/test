package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class ReturnFlowSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the customer has purchased an Achieve access code")
    public void theCustomerHasPurchasedAnAchieveAccessCode() {
        verifyPurchaseExists("Achieve");
    }

    @Given("the purchase was made more than 14 days ago")
    public void thePurchaseWasMadeMoreThan14DaysAgo() {
        verifyPurchaseDateExceedsLimit(14);
    }

    @Given("the customer is logged in to the BFW store with their account")
    public void theCustomerIsLoggedInToTheBFWStoreWithTheirAccount() {
        loginToBFWStore(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @When("the customer navigates to the 'Order Details' section")
    public void theCustomerNavigatesToTheOrderDetailsSection() {
        navigateToOrderDetails();
    }

    @When("selects the order with ID 87654")
    public void selectsTheOrderWithID87654() {
        selectOrderById("87654");
    }

    @Then("the order details for order ID 87654 are displayed")
    public void theOrderDetailsForOrderID87654AreDisplayed() {
        verifyOrderDetailsDisplayed("87654");
    }

    @Then("the access code is ACH54321")
    public void theAccessCodeIsACH54321() {
        verifyAccessCode("ACH54321");
    }

    @When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code")
    public void theCustomerAttemptsToClickOnTheInitiateReturnButtonForTheAchieveAccessCode() {
        attemptInitiateReturn();
    }

    @Then("the 'Initiate Return' button is disabled or not present")
    public void theInitiateReturnButtonIsDisabledOrNotPresent() {
        verifyInitiateReturnButtonDisabledOrNotPresent();
    }

    @Then("the customer is notified that the return period has expired")
    public void theCustomerIsNotifiedThatTheReturnPeriodHasExpired() {
        verifyReturnPeriodExpiredNotification();
    }
}