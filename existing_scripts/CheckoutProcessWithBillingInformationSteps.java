package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutProcessWithBillingInformationSteps extends CheckoutProcessWithBillingInformationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("user logs in to the web application")
    public void userLogsInToTheWebApplication() {
        loginUser();
    }

    @Given("user navigates to the shopping cart page")
    public void userNavigatesToTheShoppingCartPage() {
        navigateToShoppingCart();
    }

    @When("user selects 'Proceed to Checkout'")
    public void userSelectsProceedToCheckout() {
        proceedToCheckout();
    }

    @When("user enters valid shipping information")
    public void userEntersValidShippingInformation() {
        enterShippingInformation();
    }

    @When("user enters valid billing information")
    public void userEntersValidBillingInformation() {
        enterBillingInformation();
    }

    @When("user proceeds to payment")
    public void userProceedsToPayment() {
        proceedToPayment();
    }

    @Then("user is redirected to the payment page")
    public void userIsRedirectedToThePaymentPage() {
        verifyRedirectionToPaymentPage();
    }

    @Then("entered shipping information is correctly displayed")
    public void enteredShippingInformationIsCorrectlyDisplayed() {
        verifyShippingInformation();
    }

    @Then("entered billing information is correctly displayed")
    public void enteredBillingInformationIsCorrectlyDisplayed() {
        verifyBillingInformation();
    }

    @When("user completes the checkout process")
    public void userCompletesTheCheckoutProcess() {
        completeCheckoutProcess();
    }

    @Then("order is successfully placed")
    public void orderIsSuccessfullyPlaced() {
        verifyOrderPlacement();
    }

    @When("user leaves the billing information section {string}")
    public void userLeavesTheBillingInformationSection(String billingStatus) {
        leaveBillingInformationSection(billingStatus);
    }

    @When("user attempts to proceed to payment")
    public void userAttemptsToProceedToPayment() {
        attemptToProceedToPayment();
    }

    @Then("system {string}")
    public void system(String outcome) {
        verifySystemOutcome(outcome);
    }
}
