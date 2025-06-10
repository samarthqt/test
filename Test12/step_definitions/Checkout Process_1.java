package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("payment methods are displayed")
    public void paymentMethodsAreDisplayed() {
        displayPaymentMethods();
    }

    @Then("the user should be able to select a payment method")
    public void theUserShouldBeAbleToSelectAPaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @Given("the user has selected a payment method")
    public void theUserHasSelectedAPaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("the payment is processed")
    public void thePaymentIsProcessed() {
        processPayment();
    }

    @Then("an order confirmation should be generated")
    public void anOrderConfirmationShouldBeGenerated() {
        verifyOrderConfirmation("Your order has been confirmed.");
    }

    @When("the user completes the checkout process for {string}")
    public void theUserCompletesTheCheckoutProcessForScenario(String scenario) {
        completeCheckoutProcess(scenario);
    }

    @Then("the checkout should be successful")
    public void theCheckoutShouldBeSuccessful() {
        verifyCheckoutSuccess();
    }

    @When("the payment attempt fails")
    public void thePaymentAttemptFails() {
        simulatePaymentFailure();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        verifyErrorMessage("Payment failed. Please try again.");
    }

    @Then("the user should be able to retry the payment")
    public void theUserShouldBeAbleToRetryThePayment() {
        retryPayment();
    }

    @Then("the user interface should display all checkout steps clearly")
    public void theUserInterfaceShouldDisplayAllCheckoutStepsClearly() {
        verifyCheckoutStepsDisplay();
    }

    @When("the user completes the checkout process")
    public void theUserCompletesTheCheckoutProcess() {
        completeCheckoutProcess("default");
    }

    @Then("all checkout activities should be logged for auditing")
    public void allCheckoutActivitiesShouldBeLoggedForAuditing() {
        verifyCheckoutLogging();
    }

    @Given("the user has completed the checkout process")
    public void theUserHasCompletedTheCheckoutProcess() {
        completeCheckoutProcess("default");
    }

    @Then("the order should be integrated with the order management system")
    public void theOrderShouldBeIntegratedWithTheOrderManagementSystem() {
        verifyOrderIntegration();
    }

    @Then("the checkout process should comply with payment and security standards")
    public void theCheckoutProcessShouldComplyWithPaymentAndSecurityStandards() {
        verifyComplianceWithStandards();
    }
}