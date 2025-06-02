package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("I am logged into the user account")
    public void iAmLoggedIntoTheUserAccount() {
        loginToUserAccount();
    }

    @When("I select a product or service to purchase")
    public void iSelectAProductOrServiceToPurchase() {
        selectProductOrService();
    }

    @When("I proceed to the checkout page")
    public void iProceedToTheCheckoutPage() {
        proceedToCheckout();
    }

    @When("I enter valid payment details")
    public void iEnterValidPaymentDetails() {
        enterValidPaymentDetails();
    }

    @When("I complete the transaction")
    public void iCompleteTheTransaction() {
        completeTransaction();
    }

    @Then("I should receive a confirmation message for the successful transaction")
    public void iShouldReceiveAConfirmationMessageForTheSuccessfulTransaction() {
        verifyConfirmationMessageReceived();
    }

    @When("I perform a transaction with invalid payment details")
    public void iPerformATransactionWithInvalidPaymentDetails() {
        performTransactionWithInvalidPaymentDetails();
    }

    @Then("the transaction should fail")
    public void theTransactionShouldFail() {
        verifyTransactionFailure();
    }

    @Then("I should not receive a confirmation message for the failed transaction")
    public void iShouldNotReceiveAConfirmationMessageForTheFailedTransaction() {
        verifyNoConfirmationMessageReceived();
    }

    @When("I select different products or services to purchase")
    public void iSelectDifferentProductsOrServicesToPurchase() {
        selectDifferentProductsOrServices();
    }

    @When("I complete each transaction")
    public void iCompleteEachTransaction() {
        completeEachTransaction();
    }

    @Then("I should receive confirmation messages only for successful transactions")
    public void iShouldReceiveConfirmationMessagesOnlyForSuccessfulTransactions() {
        verifyConfirmationMessagesForSuccessfulTransactions();
    }

    @When("I attempt a purchase with insufficient funds")
    public void iAttemptAPurchaseWithInsufficientFunds() {
        attemptPurchaseWithInsufficientFunds();
    }

    @Then("the transaction should fail")
    public void theTransactionShouldFailInsufficientFunds() {
        verifyTransactionFailureInsufficientFunds();
    }

    @Then("I should not receive a confirmation message for the failed transaction")
    public void iShouldNotReceiveAConfirmationMessageForTheFailedTransactionInsufficientFunds() {
        verifyNoConfirmationMessageReceivedInsufficientFunds();
    }

    @Given("I have completed a successful transaction")
    public void iHaveCompletedASuccessfulTransaction() {
        completeSuccessfulTransaction();
    }

    @Then("the confirmation message should contain the transaction ID, amount, and product/service details")
    public void theConfirmationMessageShouldContainTransactionDetails() {
        verifyConfirmationMessageContainsTransactionDetails();
    }

    @Then("the timestamp on the confirmation message should match the time of successful transaction completion")
    public void theTimestampOnTheConfirmationMessageShouldMatch() {
        verifyConfirmationMessageTimestamp();
    }

    @When("I check the transaction history")
    public void iCheckTheTransactionHistory() {
        checkTransactionHistory();
    }

    @Then("the transaction history should reflect only successful transactions with received confirmations")
    public void theTransactionHistoryShouldReflectSuccessfulTransactions() {
        verifyTransactionHistoryReflectsSuccessfulTransactions();
    }

    @When("I perform a failed transaction")
    public void iPerformAFailedTransaction() {
        performFailedTransaction();
    }

    @Then("the failed transaction should be logged")
    public void theFailedTransactionShouldBeLogged() {
        verifyFailedTransactionLogged();
    }

    @Then("no confirmation should be sent to the user")
    public void noConfirmationShouldBeSentToTheUser() {
        verifyNoConfirmationSentForFailedTransaction();
    }
}