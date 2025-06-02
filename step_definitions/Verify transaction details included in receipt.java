package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application with valid credentials")
    public void theUserIsLoggedIntoTheApplicationWithValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user enters payment details and confirms the payment")
    public void theUserEntersPaymentDetailsAndConfirmsThePayment() {
        enterPaymentDetails();
        confirmPayment();
    }

    @Then("the payment is processed successfully")
    public void thePaymentIsProcessedSuccessfully() {
        verifyPaymentSuccess();
    }

    @Then("a receipt is generated with transaction details")
    public void aReceiptIsGeneratedWithTransactionDetails() {
        verifyReceiptGeneration();
    }

    @Then("an email notification is received with the receipt including transaction details")
    public void anEmailNotificationIsReceivedWithTheReceiptIncludingTransactionDetails() {
        verifyEmailNotification();
    }

    @Then("the transaction details are updated in the order history")
    public void theTransactionDetailsAreUpdatedInTheOrderHistory() {
        verifyOrderHistoryUpdate();
    }

    @Then("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logout();
    }

    @When("the user repeats the payment process using a different payment method")
    public void theUserRepeatsThePaymentProcessUsingADifferentPaymentMethod() {
        repeatPaymentWithDifferentMethod();
    }

    @Then("a receipt with transaction details is generated successfully for the different payment method")
    public void aReceiptWithTransactionDetailsIsGeneratedSuccessfullyForTheDifferentPaymentMethod() {
        verifyReceiptForDifferentMethod();
    }

    @When("the user attempts payment with incorrect payment details")
    public void theUserAttemptsPaymentWithIncorrectPaymentDetails() {
        attemptPaymentWithIncorrectDetails();
    }

    @Then("the system displays an error message for invalid payment details")
    public void theSystemDisplaysAnErrorMessageForInvalidPaymentDetails() {
        verifyErrorMessageForInvalidDetails();
    }

    @When("the user attempts payment without entering payment details")
    public void theUserAttemptsPaymentWithoutEnteringPaymentDetails() {
        attemptPaymentWithoutDetails();
    }

    @Then("the system displays an error message for missing payment details")
    public void theSystemDisplaysAnErrorMessageForMissingPaymentDetails() {
        verifyErrorMessageForMissingDetails();
    }

    @When("the user attempts a payment that is declined")
    public void theUserAttemptsAPaymentThatIsDeclined() {
        attemptDeclinedPayment();
    }

    @Then("the system displays an error message for declined payment")
    public void theSystemDisplaysAnErrorMessageForDeclinedPayment() {
        verifyErrorMessageForDeclinedPayment();
    }

    @When("the payment gateway is unavailable")
    public void thePaymentGatewayIsUnavailable() {
        simulatePaymentGatewayUnavailable();
    }

    @Then("the system displays an error message for unavailable payment gateway")
    public void theSystemDisplaysAnErrorMessageForUnavailablePaymentGateway() {
        verifyErrorMessageForUnavailableGateway();
    }

    @When("the network connection is lost during payment")
    public void theNetworkConnectionIsLostDuringPayment() {
        simulateNetworkConnectionLost();
    }

    @Then("the system displays an error message for network connection issues")
    public void theSystemDisplaysAnErrorMessageForNetworkConnectionIssues() {
        verifyErrorMessageForNetworkIssues();
    }

    @When("the user attempts payment with an expired payment method")
    public void theUserAttemptsPaymentWithAnExpiredPaymentMethod() {
        attemptPaymentWithExpiredMethod();
    }

    @Then("the system displays an error message for expired payment method")
    public void theSystemDisplaysAnErrorMessageForExpiredPaymentMethod() {
        verifyErrorMessageForExpiredMethod();
    }

    @When("the user completes a payment successfully")
    public void theUserCompletesAPaymentSuccessfully() {
        completeSuccessfulPayment();
    }

    @Then("the system displays an error message for missing transaction details in receipt")
    public void theSystemDisplaysAnErrorMessageForMissingTransactionDetailsInReceipt() {
        verifyErrorMessageForMissingTransactionDetails();
    }
}