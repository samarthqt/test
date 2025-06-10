package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentPage;

public class PaymentSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user has successfully made a payment")
    public void aUserHasSuccessfullyMadeAPayment() {
        initiatePayment();
    }

    @When("the payment is processed")
    public void thePaymentIsProcessed() {
        processPayment();
    }

    @Then("the user should receive a payment confirmation message immediately")
    public void theUserShouldReceiveAPaymentConfirmationMessageImmediately() {
        verifyPaymentConfirmationMessage();
    }

    @Then("a receipt should be generated")
    public void aReceiptShouldBeGenerated() {
        verifyReceiptGeneration();
    }

    @Then("the receipt should be sent to the user's email")
    public void theReceiptShouldBeSentToTheUsersEmail() {
        verifyReceiptEmailDelivery();
    }

    @Then("the receipt should be sent as an SMS to the user's phone")
    public void theReceiptShouldBeSentAsAnSMSToTheUsersPhone() {
        verifyReceiptSMSDelivery();
    }

    @When("a receipt is generated")
    public void aReceiptIsGenerated() {
        generateReceipt();
    }

    @Then("the receipt should include the transaction amount")
    public void theReceiptShouldIncludeTheTransactionAmount() {
        verifyTransactionAmountInReceipt();
    }

    @Then("the receipt should include the payment method")
    public void theReceiptShouldIncludeThePaymentMethod() {
        verifyPaymentMethodInReceipt();
    }

    @Then("the receipt should include the transaction date")
    public void theReceiptShouldIncludeTheTransactionDate() {
        verifyTransactionDateInReceipt();
    }

    @Given("a receipt has been generated")
    public void aReceiptHasBeenGenerated() {
        generateReceipt();
    }

    @When("the user navigates to their account history")
    public void theUserNavigatesToTheirAccountHistory() {
        navigateToAccountHistory();
    }

    @Then("the user should be able to view the receipt")
    public void theUserShouldBeAbleToViewTheReceipt() {
        verifyReceiptInAccountHistory();
    }

    @When("the payment confirmation is sent")
    public void thePaymentConfirmationIsSent() {
        sendPaymentConfirmation();
    }

    @Then("the system should log the payment confirmation for audit purposes")
    public void theSystemShouldLogThePaymentConfirmationForAuditPurposes() {
        verifyPaymentConfirmationLogging();
    }
}