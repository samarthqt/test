package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentOptionsSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the payment page")
    public void theUserIsOnThePaymentPage() {
        navigateToPaymentPage();
    }

    @When("the user selects credit card as the payment method")
    public void theUserSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("enters valid credit card details")
    public void entersValidCreditCardDetails() {
        enterCreditCardDetails(testHarness.getData("PaymentData", "ValidCardNumber"), testHarness.getData("PaymentData", "ValidExpiryDate"), testHarness.getData("PaymentData", "ValidCVV"));
    }

    @Then("the payment should be processed successfully")
    public void thePaymentShouldBeProcessedSuccessfully() {
        verifyPaymentProcessedSuccessfully();
    }

    @Then("the user should receive a confirmation message")
    public void theUserShouldReceiveAConfirmationMessage() {
        verifyConfirmationMessageReceived();
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
        enterCreditCardDetails(testHarness.getData("PaymentData", "InvalidCardNumber"), testHarness.getData("PaymentData", "InvalidExpiryDate"), testHarness.getData("PaymentData", "InvalidCVV"));
    }

    @Then("the payment should not be processed")
    public void thePaymentShouldNotBeProcessed() {
        verifyPaymentNotProcessed();
    }

    @Then("the user should receive an error message indicating invalid payment details")
    public void theUserShouldReceiveAnErrorMessageIndicatingInvalidPaymentDetails() {
        verifyErrorMessageReceived("Invalid payment details");
    }

    @When("fails to log into their PayPal account")
    public void failsToLogIntoTheirPayPalAccount() {
        loginToPayPal(testHarness.getData("PayPalData", "InvalidUsername"), testHarness.getData("PayPalData", "InvalidPassword"));
    }

    @Then("the user should receive an error message indicating login failure")
    public void theUserShouldReceiveAnErrorMessageIndicatingLoginFailure() {
        verifyErrorMessageReceived("Login failure");
    }
}