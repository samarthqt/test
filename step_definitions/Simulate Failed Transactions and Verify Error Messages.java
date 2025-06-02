package com.cucumber.steps;

import com.page_objects.TransactionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionSteps extends TransactionPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the shopping cart")
    public void theUserNavigatesToTheShoppingCart() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart is displayed with all added items")
    public void theShoppingCartIsDisplayedWithAllAddedItems() {
        verifyShoppingCartItems();
    }

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        verifyItemsInCart();
    }

    @When("the user proceeds to the checkout page")
    public void theUserProceedsToTheCheckoutPage() {
        proceedToCheckoutPage();
    }

    @Then("the checkout page is displayed with the order summary")
    public void theCheckoutPageIsDisplayedWithTheOrderSummary() {
        verifyOrderSummary();
    }

    @Given("the checkout page is displayed with the order summary")
    public void theCheckoutPageIsDisplayedWithTheOrderSummaryAgain() {
        verifyOrderSummary();
    }

    @When("the user selects 'Credit Card' as the payment option")
    public void theUserSelectsCreditCardAsThePaymentOption() {
        selectCreditCardPaymentOption();
    }

    @Then("the credit card payment form is displayed")
    public void theCreditCardPaymentFormIsDisplayed() {
        verifyCreditCardPaymentForm();
    }

    @Given("the credit card payment form is displayed")
    public void theCreditCardPaymentFormIsDisplayedAgain() {
        verifyCreditCardPaymentForm();
    }

    @When("the user enters an invalid credit card number")
    public void theUserEntersAnInvalidCreditCardNumber() {
        enterInvalidCreditCardNumber();
    }

    @Then("the system displays an error message for the invalid card number")
    public void theSystemDisplaysAnErrorMessageForTheInvalidCardNumber() {
        verifyInvalidCardNumberErrorMessage();
    }

    @When("the user enters an expired credit card")
    public void theUserEntersAnExpiredCreditCard() {
        enterExpiredCreditCard();
    }

    @Then("the system displays an error message for the expired card")
    public void theSystemDisplaysAnErrorMessageForTheExpiredCard() {
        verifyExpiredCardErrorMessage();
    }

    @When("the user enters an incorrect CVV")
    public void theUserEntersAnIncorrectCVV() {
        enterIncorrectCVV();
    }

    @Then("the system displays an error message for the incorrect CVV")
    public void theSystemDisplaysAnErrorMessageForTheIncorrectCVV() {
        verifyIncorrectCVVErrorMessage();
    }

    @When("the user attempts to place the order with insufficient funds")
    public void theUserAttemptsToPlaceTheOrderWithInsufficientFunds() {
        attemptOrderWithInsufficientFunds();
    }

    @Then("the system displays an error message for insufficient funds")
    public void theSystemDisplaysAnErrorMessageForInsufficientFunds() {
        verifyInsufficientFundsErrorMessage();
    }

    @Given("the user attempts a transaction")
    public void theUserAttemptsATransaction() {
        attemptTransaction();
    }

    @When("the transaction is declined")
    public void theTransactionIsDeclined() {
        declineTransaction();
    }

    @Then("the system displays a clear error message for the declined transaction")
    public void theSystemDisplaysAClearErrorMessageForTheDeclinedTransaction() {
        verifyDeclinedTransactionErrorMessage();
    }

    @When("there are network issues during payment processing")
    public void thereAreNetworkIssuesDuringPaymentProcessing() {
        simulateNetworkIssues();
    }

    @Then("the system displays a clear error message for network issues")
    public void theSystemDisplaysAClearErrorMessageForNetworkIssues() {
        verifyNetworkIssuesErrorMessage();
    }

    @When("the transaction times out")
    public void theTransactionTimesOut() {
        simulateTransactionTimeout();
    }

    @Then("the system displays a clear error message for the transaction timeout")
    public void theSystemDisplaysAClearErrorMessageForTheTransactionTimeout() {
        verifyTransactionTimeoutErrorMessage();
    }

    @Given("there are failed transactions")
    public void thereAreFailedTransactions() {
        simulateFailedTransactions();
    }

    @When("the user inspects the error logs")
    public void theUserInspectsTheErrorLogs() {
        inspectErrorLogs();
    }

    @Then("all failed transactions are recorded in the error logs")
    public void allFailedTransactionsAreRecordedInTheErrorLogs() {
        verifyErrorLogs();
    }

    @Given("a transaction has failed")
    public void aTransactionHasFailed() {
        simulateFailedTransaction();
    }

    @When("the user views the error message")
    public void theUserViewsTheErrorMessage() {
        viewErrorMessage();
    }

    @Then("the user is provided with guidance on how to proceed after a failed transaction")
    public void theUserIsProvidedWithGuidanceOnHowToProceedAfterAFailedTransaction() {
        verifyGuidanceAfterFailedTransaction();
    }

    @When("the user attempts to retry the transaction")
    public void theUserAttemptsToRetryTheTransaction() {
        retryTransaction();
    }

    @Then("the system allows the user to retry the transaction after a failure")
    public void theSystemAllowsTheUserToRetryTheTransactionAfterAFailure() {
        verifyRetryTransaction();
    }

    @Given("multiple consecutive transactions have failed")
    public void multipleConsecutiveTransactionsHaveFailed() {
        simulateMultipleFailedTransactions();
    }

    @When("the user views the error messages")
    public void theUserViewsTheErrorMessages() {
        viewErrorMessages();
    }

    @Then("the system handles multiple consecutive failed transactions gracefully with appropriate error messages")
    public void theSystemHandlesMultipleConsecutiveFailedTransactionsGracefullyWithAppropriateErrorMessages() {
        verifyMultipleFailedTransactionsHandling();
    }

    @Given("there are failed transaction scenarios")
    public void thereAreFailedTransactionScenarios() {
        simulateFailedTransactionScenarios();
    }

    @When("the user proceeds through the checkout process")
    public void theUserProceedsThroughTheCheckoutProcess() {
        proceedThroughCheckoutProcess();
    }

    @Then("the checkout process remains stable and responsive even during failed transaction scenarios")
    public void theCheckoutProcessRemainsStableAndResponsiveEvenDuringFailedTransactionScenarios() {
        verifyCheckoutProcessStability();
    }
}