package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentFailurePage;

public class PaymentFailureSteps extends PaymentFailurePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user selects a product or service to purchase")
    public void theUserSelectsAProductOrServiceToPurchase() {
        selectProductOrService();
    }

    @When("proceeds to the checkout page")
    public void proceedsToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("enters invalid payment details")
    public void entersInvalidPaymentDetails() {
        enterInvalidPaymentDetails();
    }

    @When("attempts to complete the transaction")
    public void attemptsToCompleteTheTransaction() {
        attemptTransaction();
    }

    @Then("the transaction fails due to invalid payment details")
    public void theTransactionFailsDueToInvalidPaymentDetails() {
        verifyTransactionFailure();
    }

    @Then("the user receives a clear error message explaining the payment failure")
    public void theUserReceivesAClearErrorMessageExplainingThePaymentFailure() {
        verifyErrorMessage();
    }

    @When("the user checks the system suggestions")
    public void theUserChecksTheSystemSuggestions() {
        checkSystemSuggestions();
    }

    @Then("the system suggests checking payment details or using a different payment method")
    public void theSystemSuggestsCheckingPaymentDetailsOrUsingADifferentPaymentMethod() {
        verifySystemSuggestions();
    }

    @Then("no confirmation message is received for the failed transaction")
    public void noConfirmationMessageIsReceivedForTheFailedTransaction() {
        verifyNoConfirmationMessage();
    }

    @When("the user attempts the transaction again with corrected payment details")
    public void theUserAttemptsTheTransactionAgainWithCorrectedPaymentDetails() {
        attemptTransactionWithCorrectedDetails();
    }

    @Then("the transaction is successful with valid payment details")
    public void theTransactionIsSuccessfulWithValidPaymentDetails() {
        verifySuccessfulTransaction();
    }

    @Then("a confirmation message is received for the successful transaction")
    public void aConfirmationMessageIsReceivedForTheSuccessfulTransaction() {
        verifyConfirmationMessage();
    }

    @When("the user checks the transaction history")
    public void theUserChecksTheTransactionHistory() {
        checkTransactionHistory();
    }

    @Then("the transaction history logs the failed attempt without confirmation")
    public void theTransactionHistoryLogsTheFailedAttemptWithoutConfirmation() {
        verifyTransactionHistoryLogs();
    }

    @When("the user logs out from their account")
    public void theUserLogsOutFromTheirAccount() {
        logoutFromAccount();
    }

    @When("logs back in")
    public void logsBackIn() {
        loginToAccount();
    }

    @Then("the account balance or credit remains unchanged after the failed transaction")
    public void theAccountBalanceOrCreditRemainsUnchangedAfterTheFailedTransaction() {
        verifyAccountBalanceUnchanged();
    }

    @Then("system logs include details of the payment failure for auditing purposes")
    public void systemLogsIncludeDetailsOfThePaymentFailureForAuditingPurposes() {
        verifySystemLogs();
    }

    @Given("the user attempts multiple consecutive transactions with invalid payment details")
    public void theUserAttemptsMultipleConsecutiveTransactionsWithInvalidPaymentDetails() {
        attemptMultipleInvalidTransactions();
    }

    @Then("the system consistently handles payment failures and informs the user appropriately")
    public void theSystemConsistentlyHandlesPaymentFailuresAndInformsTheUserAppropriately() {
        verifyConsistentFailureHandling();
    }
}