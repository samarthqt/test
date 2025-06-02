package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderDetailsPage;

public class ReturnFlowSteps extends OrderDetailsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a customer has purchased an Achieve access code")
    public void aCustomerHasPurchasedAnAchieveAccessCode() {
        // Logic to verify purchase of Achieve access code
    }

    @Given("the purchase was made more than 14 days ago")
    public void thePurchaseWasMadeMoreThan14DaysAgo() {
        // Logic to verify purchase date is more than 14 days ago
    }

    @When("the customer logs in to the BFW store with their account")
    public void theCustomerLogsInToTheBFWStoreWithTheirAccount() {
        loginToStore(testHarness.getData("LoginData", "UserName"), testHarness.getData("LoginData", "Password"));
    }

    @Then("the customer's account dashboard is displayed")
    public void theCustomersAccountDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Then("the order ID is 87654")
    public void theOrderIDIs87654() {
        verifyOrderID("87654");
    }

    @When("the customer navigates to the 'Order Details' section")
    public void theCustomerNavigatesToTheOrderDetailsSection() {
        navigateToOrderDetails();
    }

    @Then("order details are displayed with a list of recent purchases")
    public void orderDetailsAreDisplayedWithAListOfRecentPurchases() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the customer's email is customer@example.com")
    public void theCustomersEmailIsCustomerExampleCom() {
        verifyCustomerEmail("customer@example.com");
    }

    @When("the customer selects the order with ID 87654")
    public void theCustomerSelectsTheOrderWithID87654() {
        selectOrderByID("87654");
    }

    @Then("order details for order ID 87654 are displayed")
    public void orderDetailsForOrderID87654AreDisplayed() {
        verifyOrderDetailsForID("87654");
    }

    @Then("the access code is ACH54321")
    public void theAccessCodeIsACH54321() {
        verifyAccessCode("ACH54321");
    }

    @When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code")
    public void theCustomerAttemptsToClickOnTheInitiateReturnButtonForTheAchieveAccessCode() {
        attemptToClickInitiateReturn();
    }

    @Then("the 'Initiate Return' button is disabled or not present")
    public void theInitiateReturnButtonIsDisabledOrNotPresent() {
        verifyInitiateReturnButtonDisabled();
    }

    @Then("the purchase date is 20 days ago")
    public void thePurchaseDateIs20DaysAgo() {
        verifyPurchaseDate(20);
    }

    @Then("verify that the system does not allow return initiation")
    public void verifyThatTheSystemDoesNotAllowReturnInitiation() {
        verifyReturnNotAllowed();
    }

    @Then("the customer is notified that the return period has expired")
    public void theCustomerIsNotifiedThatTheReturnPeriodHasExpired() {
        verifyReturnPeriodExpiredNotification();
    }
}