package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class PaymentOptionsSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user views payment options")
    public void theUserViewsPaymentOptions() {
        displayPaymentOptions();
    }

    @Then("the payment options should include credit/debit cards, PayPal, and other online payment methods")
    public void thePaymentOptionsShouldIncludeVariousMethods() {
        verifyPaymentOptions();
    }

    @When("the user selects a preferred payment method")
    public void theUserSelectsAPreferredPaymentMethod() {
        selectPreferredPaymentMethod();
    }

    @Then("the system should allow easy selection of the payment method")
    public void theSystemShouldAllowEasySelection() {
        verifyEasySelection();
    }

    @Given("the user selects a payment method")
    public void theUserSelectsAPaymentMethod() {
        selectPaymentMethod();
    }

    @When("the transaction is processed")
    public void theTransactionIsProcessed() {
        processTransaction();
    }

    @Then("the system should ensure secure transactions for all payment methods")
    public void theSystemShouldEnsureSecureTransactions() {
        verifySecureTransactions();
    }

    @Then("the payment processing should comply with industry standards")
    public void thePaymentProcessingShouldComplyWithStandards() {
        verifyComplianceWithStandards();
    }

    @Given("the user completes a payment transaction")
    public void theUserCompletesAPaymentTransaction() {
        completePaymentTransaction();
    }

    @When("the payment is successful")
    public void thePaymentIsSuccessful() {
        verifyPaymentSuccess();
    }

    @Then("the user should receive a confirmation of the successful payment")
    public void theUserShouldReceiveConfirmation() {
        verifyPaymentConfirmation();
    }

    @Given("a payment transaction occurs")
    public void aPaymentTransactionOccurs() {
        initiatePaymentTransaction();
    }

    @Then("the system should log the payment transaction for auditing purposes")
    public void theSystemShouldLogTransaction() {
        logTransactionForAuditing();
    }

    @Given("the user attempts a payment")
    public void theUserAttemptsAPayment() {
        attemptPayment();
    }

    @When("an error occurs during the payment process")
    public void anErrorOccursDuringPayment() {
        simulatePaymentError();
    }

    @Then("the system should provide user-friendly error messages")
    public void theSystemShouldProvideErrorMessages() {
        verifyUserFriendlyErrorMessages();
    }
}