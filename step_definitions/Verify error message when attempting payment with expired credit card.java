package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentPage;

public class PaymentSteps extends PaymentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has an expired credit card linked to their account")
    public void theUserHasAnExpiredCreditCardLinkedToTheirAccount() {
        verifyExpiredCardLinked();
    }

    @When("the user attempts to initiate a payment using the expired credit card")
    public void theUserAttemptsToInitiateAPaymentUsingTheExpiredCreditCard() {
        attemptPaymentWithExpiredCard();
    }

    @Then("the payment attempt fails due to the expired credit card")
    public void thePaymentAttemptFailsDueToTheExpiredCreditCard() {
        verifyPaymentFailureDueToExpiredCard();
    }

    @Then("the user receives an error message indicating the card is expired")
    public void theUserReceivesAnErrorMessageIndicatingTheCardIsExpired() {
        verifyErrorMessageForExpiredCard();
    }

    @Given("the user has received an error message indicating the card is expired")
    public void theUserHasReceivedAnErrorMessageIndicatingTheCardIsExpired() {
        verifyErrorMessageReceived();
    }

    @When("the user checks the error message")
    public void theUserChecksTheErrorMessage() {
        checkErrorMessage();
    }

    @Then("the error message is clear, accurate, and helpful")
    public void theErrorMessageIsClearAccurateAndHelpful() {
        verifyErrorMessageClarity();
    }

    @Given("the user has attempted a payment with an expired credit card")
    public void theUserHasAttemptedAPaymentWithAnExpiredCreditCard() {
        logFailedTransactionAttempt();
    }

    @When("the transaction fails")
    public void theTransactionFails() {
        verifyTransactionFailure();
    }

    @Then("the failed transaction is logged in the system with error details")
    public void theFailedTransactionIsLoggedInTheSystemWithErrorDetails() {
        verifyTransactionLogged();
    }

    @When("the user updates their payment method to a valid card")
    public void theUserUpdatesTheirPaymentMethodToAValidCard() {
        updatePaymentMethodToValidCard();
    }

    @Then("the user can update their payment method successfully")
    public void theUserCanUpdateTheirPaymentMethodSuccessfully() {
        verifyPaymentMethodUpdateSuccess();
    }

    @Given("the user is updating their payment method")
    public void theUserIsUpdatingTheirPaymentMethod() {
        initiatePaymentMethodUpdate();
    }

    @When("the user submits the update")
    public void theUserSubmitsTheUpdate() {
        submitPaymentMethodUpdate();
    }

    @Then("the system response time is quick and efficient during updates")
    public void theSystemResponseTimeIsQuickAndEfficientDuringUpdates() {
        verifySystemResponseTime();
    }

    @When("the error message is displayed")
    public void theErrorMessageIsDisplayed() {
        displayErrorMessage();
    }

    @Then("the error message is visible and consistent on various devices")
    public void theErrorMessageIsVisibleAndConsistentOnVariousDevices() {
        verifyErrorMessageConsistency();
    }

    @When("the error message is generated")
    public void theErrorMessageIsGenerated() {
        generateErrorMessage();
    }

    @Then("no duplicate error messages are displayed")
    public void noDuplicateErrorMessagesAreDisplayed() {
        verifyNoDuplicateErrorMessages();
    }

    @Then("the user receives guidance on updating expired card information")
    public void theUserReceivesGuidanceOnUpdatingExpiredCardInformation() {
        provideGuidanceOnExpiredCard();
    }

    @When("the user attempts a payment again")
    public void theUserAttemptsAPaymentAgain() {
        retryPaymentAttempt();
    }

    @Then("a retry option is available once the payment method is updated")
    public void aRetryOptionIsAvailableOnceThePaymentMethodIsUpdated() {
        verifyRetryOptionAvailability();
    }

    @When("the user reads the error message")
    public void theUserReadsTheErrorMessage() {
        readErrorMessage();
    }

    @Then("the error message is intuitive and easy for users to understand")
    public void theErrorMessageIsIntuitiveAndEasyForUsersToUnderstand() {
        verifyUserFriendlyErrorMessage();
    }

    @Then("user data is protected during error handling processes")
    public void userDataIsProtectedDuringErrorHandlingProcesses() {
        verifyUserDataProtection();
    }

    @Then("no additional fees are incurred due to the expired card")
    public void noAdditionalFeesAreIncurredDueToTheExpiredCard() {
        verifyNoAdditionalFees();
    }

    @Then("the error message complies with all applicable standards")
    public void theErrorMessageCompliesWithAllApplicableStandards() {
        verifyErrorMessageCompliance();
    }

    @Then("the error message is accessible and inclusive for all users")
    public void theErrorMessageIsAccessibleAndInclusiveForAllUsers() {
        verifyErrorMessageAccessibility();
    }
}