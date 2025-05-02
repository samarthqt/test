package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user selects credit card as the payment method")
    public void theUserSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("enters valid credit card details")
    public void entersValidCreditCardDetails() {
        enterCreditCardDetails(testHarness.getData("PaymentData", "ValidCardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @Then("the payment should be processed successfully")
    public void thePaymentShouldBeProcessedSuccessfully() {
        verifyPaymentProcessed();
    }

    @Then("the user should receive a payment confirmation")
    public void theUserShouldReceiveAPaymentConfirmation() {
        verifyPaymentConfirmation();
    }

    @When("the user selects debit card as the payment method")
    public void theUserSelectsDebitCardAsThePaymentMethod() {
        selectPaymentMethod("Debit Card");
    }

    @When("enters valid debit card details")
    public void entersValidDebitCardDetails() {
        enterDebitCardDetails(testHarness.getData("PaymentData", "ValidDebitCardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @When("the user selects PayPal as the payment method")
    public void theUserSelectsPayPalAsThePaymentMethod() {
        selectPaymentMethod("PayPal");
    }

    @When("logs into their PayPal account")
    public void logsIntoTheirPayPalAccount() {
        loginToPayPal(testHarness.getData("PayPalData", "Username"), testHarness.getData("PayPalData", "Password"));
    }

    @When("enters invalid credit card details")
    public void entersInvalidCreditCardDetails() {
        enterCreditCardDetails(testHarness.getData("PaymentData", "InvalidCardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @Then("the payment should be declined")
    public void thePaymentShouldBeDeclined() {
        verifyPaymentDeclined();
    }

    @Then("the user should receive an error message")
    public void theUserShouldReceiveAnErrorMessage() {
        verifyErrorMessage();
    }

    @When("enters invalid debit card details")
    public void entersInvalidDebitCardDetails() {
        enterDebitCardDetails(testHarness.getData("PaymentData", "InvalidDebitCardNumber"), testHarness.getData("PaymentData", "ExpiryDate"), testHarness.getData("PaymentData", "CVV"));
    }

    @When("fails to log into their PayPal account")
    public void failsToLogIntoTheirPayPalAccount() {
        loginToPayPal(testHarness.getData("PayPalData", "InvalidUsername"), testHarness.getData("PayPalData", "InvalidPassword"));
    }

    @Then("the payment should not be processed")
    public void thePaymentShouldNotBeProcessed() {
        verifyPaymentNotProcessed();
    }
}