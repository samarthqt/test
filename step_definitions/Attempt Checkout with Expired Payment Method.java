package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("a user account with items in cart")
    public void aUserAccountWithItemsInCart() {
        addItemsToCart();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("expired payment method details")
    public void expiredPaymentMethodDetails() {
        setExpiredPaymentDetails();
    }

    @When("the user enters expired payment details including card number, expiry date, and CVV")
    public void theUserEntersExpiredPaymentDetailsIncludingCardNumberExpiryDateAndCVV() {
        enterExpiredPaymentDetails();
    }

    @Then("payment details are entered")
    public void paymentDetailsAreEntered() {
        verifyPaymentDetailsEntered();
    }

    @Given("payment method is Credit Card")
    public void paymentMethodIsCreditCard() {
        selectCreditCardPaymentMethod();
    }

    @When("the user attempts to submit the payment information")
    public void theUserAttemptsToSubmitThePaymentInformation() {
        attemptSubmitPaymentInformation();
    }

    @Then("the system prevents submission due to expired payment method")
    public void theSystemPreventsSubmissionDueToExpiredPaymentMethod() {
        verifySubmissionPreventedDueToExpiredMethod();
    }

    @Given("card number is 4111 1111 1111 1111")
    public void cardNumberIs4111111111111111() {
        setCardNumber("4111 1111 1111 1111");
    }

    @When("the system displays an error message")
    public void theSystemDisplaysAnErrorMessage() {
        displayErrorMessage();
    }

    @Then("the error message indicates payment method is expired")
    public void theErrorMessageIndicatesPaymentMethodIsExpired() {
        verifyErrorMessageForExpiredMethod();
    }

    @Given("expiry date is 01/21")
    public void expiryDateIs0121() {
        setExpiryDate("01/21");
    }

    @When("checking for prompts to update payment information")
    public void checkingForPromptsToUpdatePaymentInformation() {
        checkForUpdatePaymentPrompts();
    }

    @Then("the user is prompted to update payment information")
    public void theUserIsPromptedToUpdatePaymentInformation() {
        verifyPromptToUpdatePaymentInformation();
    }

    @Given("CVV is 456")
    public void cvvIs456() {
        setCVV("456");
    }

    @When("the user attempts checkout with updated payment method")
    public void theUserAttemptsCheckoutWithUpdatedPaymentMethod() {
        attemptCheckoutWithUpdatedPaymentMethod();
    }

    @Then("checkout proceeds with valid payment method")
    public void checkoutProceedsWithValidPaymentMethod() {
        verifyCheckoutProceedsWithValidMethod();
    }

    @When("verifying transaction history for failed attempt with expired method")
    public void verifyingTransactionHistoryForFailedAttemptWithExpiredMethod() {
        verifyFailedTransactionHistory();
    }

    @Then("the failed transaction is logged with reason for failure")
    public void theFailedTransactionIsLoggedWithReasonForFailure() {
        verifyFailedTransactionLogged();
    }

    @When("ensuring system does not process transaction with expired method")
    public void ensuringSystemDoesNotProcessTransactionWithExpiredMethod() {
        ensureTransactionNotProcessedWithExpiredMethod();
    }

    @Then("the transaction is not processed")
    public void theTransactionIsNotProcessed() {
        verifyTransactionNotProcessed();
    }

    @When("testing system response with different expired payment methods")
    public void testingSystemResponseWithDifferentExpiredPaymentMethods() {
        testSystemResponseWithExpiredMethods();
    }

    @Then("all expired methods are rejected with appropriate error messages")
    public void allExpiredMethodsAreRejectedWithAppropriateErrorMessages() {
        verifyAllExpiredMethodsRejected();
    }

    @When("simulating network interruption during payment submission")
    public void simulatingNetworkInterruptionDuringPaymentSubmission() {
        simulateNetworkInterruption();
    }

    @Then("the system alerts user and does not process transaction")
    public void theSystemAlertsUserAndDoesNotProcessTransaction() {
        verifySystemAlertsAndNoTransactionProcessed();
    }

    @When("checking system logs for error handling and alerts")
    public void checkingSystemLogsForErrorHandlingAndAlerts() {
        checkSystemLogsForErrorsAndAlerts();
    }

    @Then("logs capture error and user actions accurately")
    public void logsCaptureErrorAndUserActionsAccurately() {
        verifyLogsCaptureErrorsAndActions();
    }

    @When("verifying user receives notification for failed transaction")
    public void verifyingUserReceivesNotificationForFailedTransaction() {
        verifyUserNotificationForFailedTransaction();
    }

    @Then("notification is sent with details of failure")
    public void notificationIsSentWithDetailsOfFailure() {
        verifyNotificationSentWithFailureDetails();
    }

    @When("testing system response to incorrect CVV with expired method")
    public void testingSystemResponseToIncorrectCVVWithExpiredMethod() {
        testSystemResponseToIncorrectCVV();
    }

    @Then("the system alerts user to both expired method and incorrect CVV")
    public void theSystemAlertsUserToBothExpiredMethodAndIncorrectCVV() {
        verifySystemAlertsForExpiredMethodAndIncorrectCVV();
    }

    @When("attempting checkout with expired method from mobile device")
    public void attemptingCheckoutWithExpiredMethodFromMobileDevice() {
        attemptCheckoutFromMobileDevice();
    }

    @Then("same error messages and prompts are displayed on mobile")
    public void sameErrorMessagesAndPromptsAreDisplayedOnMobile() {
        verifyErrorMessagesOnMobile();
    }

    @When("ensuring user can update payment details easily from error prompt")
    public void ensuringUserCanUpdatePaymentDetailsEasilyFromErrorPrompt() {
        ensureUserCanUpdatePaymentDetailsFromPrompt();
    }

    @Then("the user is able to update payment details successfully")
    public void theUserIsAbleToUpdatePaymentDetailsSuccessfully() {
        verifyUserUpdatesPaymentDetailsSuccessfully();
    }
}