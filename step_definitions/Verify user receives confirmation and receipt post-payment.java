package com.cucumber.steps;

import com.page_objects.PaymentConfirmationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentConfirmationSteps extends PaymentConfirmationPage {

    @Given("the user has completed a purchase transaction with User ID {int}")
    public void theUserHasCompletedAPurchaseTransactionWithUserID(int userId) {
        completePurchaseTransaction(userId);
    }

    @When("the user navigates to the payment confirmation page")
    public void theUserNavigatesToThePaymentConfirmationPage() {
        navigateToPaymentConfirmationPage();
    }

    @Then("the user is redirected to the payment confirmation page")
    public void theUserIsRedirectedToThePaymentConfirmationPage() {
        verifyRedirectionToConfirmationPage();
    }

    @Given("the user is on the payment confirmation page")
    public void theUserIsOnThePaymentConfirmationPage() {
        verifyUserOnConfirmationPage();
    }

    @Then("a confirmation message is displayed with transaction details")
    public void aConfirmationMessageIsDisplayedWithTransactionDetails() {
        verifyConfirmationMessageWithTransactionDetails();
    }

    @Then("the payment method used is Credit Card")
    public void thePaymentMethodUsedIsCreditCard() {
        verifyPaymentMethodIsCreditCard();
    }

    @Given("the user has completed a payment transaction of ${int}")
    public void theUserHasCompletedAPaymentTransactionOf(int amount) {
        completePaymentTransaction(amount);
    }

    @When("the transaction is successful")
    public void theTransactionIsSuccessful() {
        verifyTransactionSuccess();
    }

    @Then("an email receipt is sent to the user's registered email address")
    public void anEmailReceiptIsSentToTheUsersRegisteredEmailAddress() {
        verifyEmailReceiptSent();
    }

    @Given("the user receives an email receipt")
    public void theUserReceivesAnEmailReceipt() {
        verifyEmailReceiptReceived();
    }

    @Then("the email receipt includes transaction amount, payment method, and date")
    public void theEmailReceiptIncludesTransactionAmountPaymentMethodAndDate() {
        verifyEmailReceiptDetails();
    }

    @Then("the email is sent to user@example.com")
    public void theEmailIsSentToUserExampleCom() {
        verifyEmailSentToCorrectAddress();
    }

    @Given("the user has a completed transaction")
    public void theUserHasACompletedTransaction() {
        verifyCompletedTransaction();
    }

    @Then("the receipt is available in the user's account under transaction history")
    public void theReceiptIsAvailableInTheUsersAccountUnderTransactionHistory() {
        verifyReceiptInTransactionHistory();
    }

    @Then("the confirmation message is clear and correctly formatted")
    public void theConfirmationMessageIsClearAndCorrectlyFormatted() {
        verifyConfirmationMessageFormat();
    }

    @Given("a transaction has been completed")
    public void aTransactionHasBeenCompleted() {
        verifyTransactionCompletion();
    }

    @Then("the transaction details are accurately logged in the system")
    public void theTransactionDetailsAreAccuratelyLoggedInTheSystem() {
        verifyTransactionLogging();
    }

    @Then("the receipt can be downloaded as a PDF from the email")
    public void theReceiptCanBeDownloadedAsAPDFFromTheEmail() {
        verifyReceiptDownloadableAsPDF();
    }

    @Given("the user accesses the receipt from the account page")
    public void theUserAccessesTheReceiptFromTheAccountPage() {
        accessReceiptFromAccountPage();
    }

    @Then("a print option is available for the receipt on the account page")
    public void aPrintOptionIsAvailableForTheReceiptOnTheAccountPage() {
        verifyPrintOptionAvailable();
    }

    @Given("the user accesses the receipt")
    public void theUserAccessesTheReceipt() {
        accessReceipt();
    }

    @Then("the receipt details match the transaction details in the system")
    public void theReceiptDetailsMatchTheTransactionDetailsInTheSystem() {
        verifyReceiptDetailsMatchTransaction();
    }

    @Given("the user completes a transaction")
    public void theUserCompletesATransaction() {
        completeTransaction();
    }

    @Then("receipt generation is instantaneous and does not affect transaction speed")
    public void receiptGenerationIsInstantaneousAndDoesNotAffectTransactionSpeed() {
        verifyInstantaneousReceiptGeneration();
    }

    @Given("the user has access to the receipt")
    public void theUserHasAccessToTheReceipt() {
        verifyReceiptAccess();
    }

    @Then("the receipt is accessible and viewable on various devices")
    public void theReceiptIsAccessibleAndViewableOnVariousDevices() {
        verifyReceiptAccessibilityOnDevices();
    }

    @Given("the user has completed a transaction")
    public void theUserHasCompletedATransaction() {
        verifyTransactionCompletion();
    }

    @Then("the receipt is stored securely with proper access controls")
    public void theReceiptIsStoredSecurelyWithProperAccessControls() {
        verifyReceiptSecurity();
    }

    @Then("no duplicate receipts are generated for the same transaction")
    public void noDuplicateReceiptsAreGeneratedForTheSameTransaction() {
        verifyNoDuplicateReceipts();
    }

    @Given("the user receives a receipt")
    public void theUserReceivesAReceipt() {
        verifyReceiptReceived();
    }

    @Then("the receipt complies with legal and regulatory standards")
    public void theReceiptCompliesWithLegalAndRegulatoryStandards() {
        verifyReceiptCompliance();
    }
}