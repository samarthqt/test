package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentGatewayPage;

public class PaymentGatewaySteps extends PaymentGatewayPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the application is configured with Stripe API keys")
    public void theApplicationIsConfiguredWithStripeAPIKeys() {
        configureStripeAPIKeys();
    }

    @When("the application attempts to connect to Stripe")
    public void theApplicationAttemptsToConnectToStripe() {
        connectToStripe();
    }

    @Then("the connection to Stripe should be successful")
    public void theConnectionToStripeShouldBeSuccessful() {
        verifyStripeConnection();
    }

    @Given("the application is configured with PayPal API credentials")
    public void theApplicationIsConfiguredWithPayPalAPICredentials() {
        configurePayPalAPICredentials();
    }

    @When("the application attempts to connect to PayPal")
    public void theApplicationAttemptsToConnectToPayPal() {
        connectToPayPal();
    }

    @Then("the connection to PayPal should be successful")
    public void theConnectionToPayPalShouldBeSuccessful() {
        verifyPayPalConnection();
    }

    @Given("the application is configured with credit/debit card processor API keys")
    public void theApplicationIsConfiguredWithCreditDebitCardProcessorAPIKeys() {
        configureCardProcessorAPIKeys();
    }

    @When("the application attempts to connect to the credit/debit card processor")
    public void theApplicationAttemptsToConnectToTheCreditDebitCardProcessor() {
        connectToCardProcessor();
    }

    @Then("the connection to the credit/debit card processor should be successful")
    public void theConnectionToTheCreditDebitCardProcessorShouldBeSuccessful() {
        verifyCardProcessorConnection();
    }

    @Given("the user has selected Stripe as the payment method")
    public void theUserHasSelectedStripeAsThePaymentMethod() {
        selectStripePaymentMethod();
    }

    @When("the user completes the payment process")
    public void theUserCompletesThePaymentProcess() {
        completePaymentProcess();
    }

    @Then("the transaction should be completed without errors")
    public void theTransactionShouldBeCompletedWithoutErrors() {
        verifyTransactionCompletion();
    }

    @Given("the user has selected PayPal as the payment method")
    public void theUserHasSelectedPayPalAsThePaymentMethod() {
        selectPayPalPaymentMethod();
    }

    @Given("the user has selected credit/debit card as the payment method")
    public void theUserHasSelectedCreditDebitCardAsThePaymentMethod() {
        selectCardPaymentMethod();
    }

    @Given("the user is proceeding with a payment")
    public void theUserIsProceedingWithAPayment() {
        proceedWithPayment();
    }

    @When("the transaction is being processed")
    public void theTransactionIsBeingProcessed() {
        processTransaction();
    }

    @Then("sensitive data should be encrypted")
    public void sensitiveDataShouldBeEncrypted() {
        verifyDataEncryption();
    }

    @Given("the transaction fails during processing")
    public void theTransactionFailsDuringProcessing() {
        simulateTransactionFailure();
    }

    @When("the failure is detected")
    public void theFailureIsDetected() {
        detectTransactionFailure();
    }

    @Then("the system should handle the failure gracefully")
    public void theSystemShouldHandleTheFailureGracefully() {
        handleTransactionFailureGracefully();
    }

    @Then("the user should be notified of the transaction failure")
    public void theUserShouldBeNotifiedOfTheTransactionFailure() {
        notifyUserOfFailure();
    }

    @Given("the application is processing a payment")
    public void theApplicationIsProcessingAPayment() {
        initiatePaymentProcessing();
    }

    @When("the transaction is initiated")
    public void theTransactionIsInitiated() {
        initiateTransaction();
    }

    @Then("the integration should comply with PCI DSS standards")
    public void theIntegrationShouldComplyWithPCIDSSStandards() {
        verifyPCIDSSCompliance();
    }
}