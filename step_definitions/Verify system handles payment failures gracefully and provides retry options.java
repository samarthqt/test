package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentPage;

public class PaymentSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user with User ID {string} attempts a payment transaction of $100 using a Credit Card")
    public void userAttemptsPaymentTransaction(String userId) {
        initiatePaymentTransaction(userId, 100, "Credit Card");
    }

    @When("the payment fails due to insufficient funds")
    public void paymentFailsDueToInsufficientFunds() {
        simulatePaymentFailure("Insufficient Funds");
    }

    @Then("the user receives a clear error message indicating payment failure")
    public void userReceivesErrorMessage() {
        verifyErrorMessage("Payment failed due to insufficient funds.");
    }

    @Given("the user encounters a payment failure due to insufficient funds")
    public void userEncountersPaymentFailure() {
        simulatePaymentFailure("Insufficient Funds");
    }

    @When("the error page is displayed")
    public void errorPageIsDisplayed() {
        verifyErrorPageDisplayed();
    }

    @Then("a retry option is available for the user to attempt the payment again")
    public void retryOptionIsAvailable() {
        verifyRetryOptionAvailable();
    }

    @Given("a payment failure with Error Code {string} (Insufficient Funds) using a Credit Card")
    public void paymentFailureWithErrorCode(String errorCode) {
        simulatePaymentFailure(errorCode);
    }

    @When("the user selects the retry option")
    public void userSelectsRetryOption() {
        selectRetryOption();
    }

    @Then("the user can retry the payment with the same method")
    public void userCanRetryPaymentWithSameMethod() {
        verifyRetryWithSameMethod();
    }

    @Given("a failed payment transaction attempt")
    public void failedPaymentTransactionAttempt() {
        simulatePaymentFailure("Transaction Failed");
    }

    @Then("the failed transaction is logged in the system with error details")
    public void failedTransactionIsLogged() {
        verifyTransactionLogged();
    }

    @Given("a user encounters a payment failure")
    public void userEncountersPaymentFailureGeneric() {
        simulatePaymentFailure("Generic Failure");
    }

    @When("the user chooses to retry the payment")
    public void userChoosesToRetryPayment() {
        selectRetryOption();
    }

    @Then("the user can select a different payment method and retry the transaction")
    public void userCanSelectDifferentPaymentMethod() {
        verifyDifferentPaymentMethodSelection();
    }

    @Given("a user retries a payment transaction")
    public void userRetriesPaymentTransaction() {
        selectRetryOption();
    }

    @Then("the system response time is quick and efficient during the retry")
    public void systemResponseTimeIsEfficient() {
        verifySystemResponseTime();
    }

    @When("the user accesses the retry option on various devices")
    public void userAccessesRetryOptionOnVariousDevices() {
        verifyRetryOptionOnDevices();
    }

    @Then("the retry option is functional and accessible on all devices")
    public void retryOptionIsFunctionalOnAllDevices() {
        verifyRetryOptionAccessibility();
    }

    @Given("a user retries payment transactions multiple times")
    public void userRetriesPaymentTransactionsMultipleTimes() {
        retryPaymentMultipleTimes();
    }

    @Then("no duplicate transaction entries are created during retries")
    public void noDuplicateTransactionEntries() {
        verifyNoDuplicateTransactions();
    }

    @Given("a user encounters repeated payment failures")
    public void userEncountersRepeatedPaymentFailures() {
        simulateRepeatedPaymentFailures();
    }

    @Then("the retry option is persistent until a successful transaction is completed")
    public void retryOptionIsPersistent() {
        verifyRetryOptionPersistence();
    }

    @Then("no additional fees are incurred during payment retries")
    public void noAdditionalFeesDuringRetries() {
        verifyNoAdditionalFees();
    }

    @Then("the user receives guidance on resolving payment issues from the system")
    public void userReceivesGuidanceOnPaymentIssues() {
        verifyGuidanceProvided();
    }

    @When("the user accesses the retry option")
    public void userAccessesRetryOption() {
        accessRetryOption();
    }

    @Then("the retry option is intuitive and easy for users to navigate")
    public void retryOptionIsUserFriendly() {
        verifyRetryOptionUserFriendly();
    }

    @Then("the retry attempts are secure and user data is protected")
    public void retryAttemptsAreSecure() {
        verifyRetrySecurity();
    }

    @Given("a payment transaction fails due to a network error")
    public void paymentTransactionFailsDueToNetworkError() {
        simulateNetworkError();
    }

    @Then("the retry option is available for network-related payment failures")
    public void retryOptionAvailableForNetworkFailures() {
        verifyRetryOptionForNetworkFailures();
    }
}