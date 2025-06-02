package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user is logged into the application with valid credentials")
    public void theUserIsLoggedIntoTheApplicationWithValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("enters payment details and confirms the payment")
    public void entersPaymentDetailsAndConfirmsThePayment() {
        enterPaymentDetails();
        confirmPayment();
    }

    @Then("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfully() {
        verifyPaymentProcessedSuccessfully();
    }

    @Then("a digital receipt is generated and sent to user@example.com")
    public void aDigitalReceiptIsGeneratedAndSentToUserEmail() {
        verifyDigitalReceiptGeneratedAndSent();
    }

    @Then("an email notification is received with the digital receipt")
    public void anEmailNotificationIsReceivedWithTheDigitalReceipt() {
        verifyEmailNotificationReceived();
    }

    @Then("the transaction details are updated in the order history")
    public void theTransactionDetailsAreUpdatedInTheOrderHistory() {
        verifyTransactionDetailsUpdatedInOrderHistory();
    }

    @Then("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @When("enters payment details using a different payment method and confirms the payment")
    public void entersPaymentDetailsUsingADifferentPaymentMethodAndConfirmsThePayment() {
        enterDifferentPaymentMethodDetails();
        confirmPayment();
    }

    @Then("a digital receipt is generated successfully for the different payment method")
    public void aDigitalReceiptIsGeneratedSuccessfullyForTheDifferentPaymentMethod() {
        verifyDigitalReceiptGeneratedForDifferentMethod();
    }

    @When("enters incorrect payment details and attempts payment")
    public void entersIncorrectPaymentDetailsAndAttemptsPayment() {
        enterIncorrectPaymentDetails();
        attemptPayment();
    }

    @Then("the system displays an error message for invalid payment details")
    public void theSystemDisplaysAnErrorMessageForInvalidPaymentDetails() {
        verifyErrorMessageForInvalidPaymentDetails();
    }

    @When("attempts payment without entering payment details")
    public void attemptsPaymentWithoutEnteringPaymentDetails() {
        attemptPaymentWithoutDetails();
    }

    @Then("the system displays an error message for missing payment details")
    public void theSystemDisplaysAnErrorMessageForMissingPaymentDetails() {
        verifyErrorMessageForMissingPaymentDetails();
    }

    @When("enters payment details and the payment is declined")
    public void entersPaymentDetailsAndThePaymentIsDeclined() {
        enterPaymentDetails();
        declinePayment();
    }

    @Then("the system displays an error message for declined payment")
    public void theSystemDisplaysAnErrorMessageForDeclinedPayment() {
        verifyErrorMessageForDeclinedPayment();
    }

    @When("attempts payment when the payment gateway is unavailable")
    public void attemptsPaymentWhenThePaymentGatewayIsUnavailable() {
        attemptPaymentWithUnavailableGateway();
    }

    @Then("the system displays an error message for unavailable payment gateway")
    public void theSystemDisplaysAnErrorMessageForUnavailablePaymentGateway() {
        verifyErrorMessageForUnavailableGateway();
    }

    @When("attempts payment when the network connection is lost")
    public void attemptsPaymentWhenTheNetworkConnectionIsLost() {
        attemptPaymentWithLostNetworkConnection();
    }

    @Then("the system displays an error message for network connection issues")
    public void theSystemDisplaysAnErrorMessageForNetworkConnectionIssues() {
        verifyErrorMessageForNetworkConnectionIssues();
    }

    @When("enters expired payment method details and attempts payment")
    public void entersExpiredPaymentMethodDetailsAndAttemptsPayment() {
        enterExpiredPaymentMethodDetails();
        attemptPayment();
    }

    @Then("the system displays an error message for expired payment method")
    public void theSystemDisplaysAnErrorMessageForExpiredPaymentMethod() {
        verifyErrorMessageForExpiredPaymentMethod();
    }

    @Then("the system displays an error message for receipt generation failure despite successful payment")
    public void theSystemDisplaysAnErrorMessageForReceiptGenerationFailureDespiteSuccessfulPayment() {
        verifyErrorMessageForReceiptGenerationFailure();
    }
}