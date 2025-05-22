package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReturnFlowSteps extends ReturnPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a customer has purchased an Achieve access code")
    public void aCustomerHasPurchasedAnAchieveAccessCode() {
        String accessCode = testHarness.getData("PurchaseData", "AccessCode");
        verifyAccessCodePurchased(accessCode);
    }

    @Given("the purchase was made more than 14 days ago")
    public void thePurchaseWasMadeMoreThan14DaysAgo() {
        String purchaseDate = testHarness.getData("PurchaseData", "PurchaseDate");
        verifyPurchaseDate(purchaseDate);
    }

    @When("the customer logs in to the BFW store with their account")
    public void theCustomerLogsInToTheBFWStoreWithTheirAccount() {
        String email = testHarness.getData("LoginData", "Email");
        String password = testHarness.getData("LoginData", "Password");
        loginToStore(email, password);
    }

    @Then("the customer's account dashboard is displayed")
    public void theCustomersAccountDashboardIsDisplayed() {
        verifyDashboardDisplayed();
    }

    @Then("the Order ID is 87654")
    public void theOrderIDIs87654() {
        String orderId = testHarness.getData("OrderData", "OrderID");
        verifyOrderID(orderId);
    }

    @When("the customer navigates to the 'Order Details' section")
    public void theCustomerNavigatesToTheOrderDetailsSection() {
        navigateToOrderDetails();
    }

    @Then("order details are displayed with a list of recent purchases")
    public void orderDetailsAreDisplayedWithAListOfRecentPurchases() {
        verifyOrderDetailsDisplayed();
    }

    @Then("the Customer Email is customer@example.com")
    public void theCustomerEmailIsCustomerExampleCom() {
        String email = testHarness.getData("OrderData", "CustomerEmail");
        verifyCustomerEmail(email);
    }

    @When("the customer selects the order with ID 87654")
    public void theCustomerSelectsTheOrderWithID87654() {
        selectOrderById("87654");
    }

    @Then("order details for order ID 87654 are displayed")
    public void orderDetailsForOrderID87654AreDisplayed() {
        verifyOrderDetailsForId("87654");
    }

    @Then("the Access Code is ACH54321")
    public void theAccessCodeIsACH54321() {
        String accessCode = testHarness.getData("OrderData", "AccessCode");
        verifyAccessCode(accessCode);
    }

    @When("the customer attempts to click on the 'Initiate Return' button for the Achieve access code")
    public void theCustomerAttemptsToClickOnTheInitiateReturnButtonForTheAchieveAccessCode() {
        attemptToInitiateReturn();
    }

    @Then("the 'Initiate Return' button is disabled or not present")
    public void theInitiateReturnButtonIsDisabledOrNotPresent() {
        verifyReturnButtonDisabled();
    }

    @Then("the Purchase Date is 20 days ago")
    public void thePurchaseDateIs20DaysAgo() {
        String purchaseDate = testHarness.getData("OrderData", "PurchaseDate");
        verifyPurchaseDate(purchaseDate);
    }

    @Then("the system does not allow return initiation")
    public void theSystemDoesNotAllowReturnInitiation() {
        verifyReturnNotAllowed();
    }

    @Then("the customer is notified that the return period has expired")
    public void theCustomerIsNotifiedThatTheReturnPeriodHasExpired() {
        verifyReturnPeriodExpiredNotification();
    }
}