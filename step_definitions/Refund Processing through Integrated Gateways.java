package com.cucumber.steps;

import com.page_objects.RefundPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RefundSteps extends RefundPage {

    @Given("the user is logged into the application with valid credentials")
    public void theUserIsLoggedIntoTheApplicationWithValidCredentials() {
        loginWithValidCredentials();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToTheOrderHistorySection() {
        navigateToOrderHistory();
    }

    @Then("the order history is displayed with past transactions")
    public void theOrderHistoryIsDisplayedWithPastTransactions() {
        verifyOrderHistoryDisplayed();
    }

    @When("the user selects a transaction eligible for refund")
    public void theUserSelectsATransactionEligibleForRefund() {
        selectEligibleTransactionForRefund();
    }

    @Then("the transaction details are displayed")
    public void theTransactionDetailsAreDisplayed() {
        verifyTransactionDetailsDisplayed();
    }

    @When("the user clicks on the 'Request Refund' button")
    public void theUserClicksOnTheRequestRefundButton() {
        clickRequestRefundButton();
    }

    @Then("the refund request form is displayed")
    public void theRefundRequestFormIsDisplayed() {
        verifyRefundRequestFormDisplayed();
    }

    @When("the user enters refund amount and reason for refund")
    public void theUserEntersRefundAmountAndReasonForRefund() {
        enterRefundDetails();
    }

    @Then("the refund details are entered successfully")
    public void theRefundDetailsAreEnteredSuccessfully() {
        verifyRefundDetailsEntered();
    }

    @When("the user selects the payment gateway for processing the refund")
    public void theUserSelectsThePaymentGatewayForProcessingTheRefund() {
        selectPaymentGateway();
    }

    @Then("the payment gateway is selected")
    public void thePaymentGatewayIsSelected() {
        verifyPaymentGatewaySelected();
    }

    @When("the user submits the refund request")
    public void theUserSubmitsTheRefundRequest() {
        submitRefundRequest();
    }

    @Then("the refund request is submitted successfully")
    public void theRefundRequestIsSubmittedSuccessfully() {
        verifyRefundRequestSubmitted();
    }

    @When("the user verifies the refund status in the transaction history")
    public void theUserVerifiesTheRefundStatusInTheTransactionHistory() {
        verifyRefundStatusInTransactionHistory();
    }

    @Then("the refund status is updated in the transaction history")
    public void theRefundStatusIsUpdatedInTheTransactionHistory() {
        verifyRefundStatusUpdated();
    }

    @When("the user checks email notification for refund confirmation")
    public void theUserChecksEmailNotificationForRefundConfirmation() {
        checkEmailNotificationForRefundConfirmation();
    }

    @Then("an email notification is received with refund confirmation")
    public void anEmailNotificationIsReceivedWithRefundConfirmation() {
        verifyEmailNotificationReceived();
    }

    @When("the user verifies the refund amount is credited back to the original payment method")
    public void theUserVerifiesTheRefundAmountIsCreditedBackToTheOriginalPaymentMethod() {
        verifyRefundAmountCreditedBack();
    }

    @Then("the refund amount is credited back to the original payment method")
    public void theRefundAmountIsCreditedBackToTheOriginalPaymentMethod() {
        verifyRefundAmountCreditedBack();
    }

    @When("the user logs out from the application")
    public void theUserLogsOutFromTheApplication() {
        logoutFromApplication();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @Given("the user has completed a refund process using one payment gateway")
    public void theUserHasCompletedARefundProcessUsingOnePaymentGateway() {
        completeRefundProcessUsingOneGateway();
    }

    @When("the user repeats the process using a different payment gateway")
    public void theUserRepeatsTheProcessUsingADifferentPaymentGateway() {
        repeatRefundProcessUsingDifferentGateway();
    }

    @Then("the refund is processed successfully through the different gateway")
    public void theRefundIsProcessedSuccessfullyThroughTheDifferentGateway() {
        verifyRefundProcessedThroughDifferentGateway();
    }

    @Given("the user is on the refund request form")
    public void theUserIsOnTheRefundRequestForm() {
        navigateToRefundRequestForm();
    }

    @When("the user attempts to refund an amount greater than the original transaction")
    public void theUserAttemptsToRefundAnAmountGreaterThanTheOriginalTransaction() {
        attemptRefundWithInvalidAmount();
    }

    @Then("the system displays an error message for invalid refund amount")
    public void theSystemDisplaysAnErrorMessageForInvalidRefundAmount() {
        verifyErrorMessageForInvalidRefundAmount();
    }

    @When("the user attempts refund without selecting a payment gateway")
    public void theUserAttemptsRefundWithoutSelectingAPaymentGateway() {
        attemptRefundWithoutPaymentGateway();
    }

    @Then("the system displays an error message for missing payment gateway selection")
    public void theSystemDisplaysAnErrorMessageForMissingPaymentGatewaySelection() {
        verifyErrorMessageForMissingPaymentGateway();
    }

    @When("the user attempts refund with an invalid transaction ID")
    public void theUserAttemptsRefundWithAnInvalidTransactionID() {
        attemptRefundWithInvalidTransactionID();
    }

    @Then("the system displays an error message for invalid transaction ID")
    public void theSystemDisplaysAnErrorMessageForInvalidTransactionID() {
        verifyErrorMessageForInvalidTransactionID();
    }
}