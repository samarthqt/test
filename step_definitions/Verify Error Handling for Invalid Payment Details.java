package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged into my user account")
    public void iAmLoggedIntoMyUserAccount() {
        loginToAccount();
    }

    @Given("I navigate to the checkout page")
    public void iNavigateToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("I select Credit Card as the payment method")
    public void iSelectCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("I enter expired Credit Card details")
    public void iEnterExpiredCreditCardDetails() {
        enterCreditCardDetails("4111111111111111", "01/21", "123");
    }

    @Then("the system displays an error message for expired Credit Card")
    public void theSystemDisplaysAnErrorMessageForExpiredCreditCard() {
        verifyErrorMessage("Your credit card is expired.");
    }

    @When("I enter an incorrect CVV number")
    public void iEnterAnIncorrectCVVNumber() {
        enterCreditCardDetails("4111111111111111", "12/23", "000");
    }

    @Then("the system displays an error message for incorrect CVV")
    public void theSystemDisplaysAnErrorMessageForIncorrectCVV() {
        verifyErrorMessage("Incorrect CVV number.");
    }

    @When("I attempt a transaction with invalid PayPal account details")
    public void iAttemptATransactionWithInvalidPayPalAccountDetails() {
        selectPaymentMethod("PayPal");
        enterPayPalDetails("invalid@paypal.com", "wrongpassword");
    }

    @Then("the system displays an error message for invalid PayPal account")
    public void theSystemDisplaysAnErrorMessageForInvalidPayPalAccount() {
        verifyErrorMessage("Invalid PayPal account details.");
    }

    @When("I proceed with empty payment details")
    public void iProceedWithEmptyPaymentDetails() {
        proceedWithEmptyPaymentDetails();
    }

    @Then("the system prompts me to enter payment details")
    public void theSystemPromptsMeToEnterPaymentDetails() {
        verifyErrorMessage("Please enter payment details.");
    }

    @When("I select an unsupported payment method")
    public void iSelectAnUnsupportedPaymentMethod() {
        selectPaymentMethod("Unsupported Method");
    }

    @Then("the system displays an error message for unsupported payment method")
    public void theSystemDisplaysAnErrorMessageForUnsupportedPaymentMethod() {
        verifyErrorMessage("Unsupported payment method.");
    }

    @When("there is a network interruption during payment processing")
    public void thereIsANetworkInterruptionDuringPaymentProcessing() {
        simulateNetworkInterruption();
    }

    @Then("the system handles the interruption gracefully with an error message")
    public void theSystemHandlesTheInterruptionGracefullyWithAnErrorMessage() {
        verifyErrorMessage("Network interruption occurred. Please try again.");
    }

    @When("I select an incorrect currency for the transaction")
    public void iSelectAnIncorrectCurrencyForTheTransaction() {
        selectCurrency("Invalid Currency");
    }

    @Then("the system displays an error message for incorrect currency")
    public void theSystemDisplaysAnErrorMessageForIncorrectCurrency() {
        verifyErrorMessage("Incorrect currency selected.");
    }

    @When("I attempt a transaction with an amount exceeding the limit")
    public void iAttemptATransactionWithAnAmountExceedingTheLimit() {
        enterTransactionAmount("1000000");
    }

    @Then("the system displays an error message for exceeding transaction limit")
    public void theSystemDisplaysAnErrorMessageForExceedingTransactionLimit() {
        verifyErrorMessage("Transaction amount exceeds the limit.");
    }

    @When("I enter an invalid billing address")
    public void iEnterAnInvalidBillingAddress() {
        enterBillingAddress("Invalid Address");
    }

    @Then("the system displays an error message for invalid billing address")
    public void theSystemDisplaysAnErrorMessageForInvalidBillingAddress() {
        verifyErrorMessage("Invalid billing address.");
    }

    @When("I enter an invalid shipping address")
    public void iEnterAnInvalidShippingAddress() {
        enterShippingAddress("Invalid Address");
    }

    @Then("the system displays an error message for invalid shipping address")
    public void theSystemDisplaysAnErrorMessageForInvalidShippingAddress() {
        verifyErrorMessage("Invalid shipping address.");
    }

    @When("I attempt a transaction with an expired promotional code")
    public void iAttemptATransactionWithAnExpiredPromotionalCode() {
        enterPromotionalCode("EXPIRED2021");
    }

    @Then("the system displays an error message for expired promotional code")
    public void theSystemDisplaysAnErrorMessageForExpiredPromotionalCode() {
        verifyErrorMessage("Promotional code is expired.");
    }

    @When("I attempt duplicate payment transactions")
    public void iAttemptDuplicatePaymentTransactions() {
        attemptDuplicatePayments();
    }

    @Then("the system displays an error message for duplicate payment attempts")
    public void theSystemDisplaysAnErrorMessageForDuplicatePaymentAttempts() {
        verifyErrorMessage("Duplicate payment attempt detected.");
    }

    @When("I proceed with incomplete payment details")
    public void iProceedWithIncompletePaymentDetails() {
        proceedWithIncompletePaymentDetails();
    }

    @Then("the system prompts me to complete payment details")
    public void theSystemPromptsMeToCompletePaymentDetails() {
        verifyErrorMessage("Please complete payment details.");
    }
}