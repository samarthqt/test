package com.cucumber.steps;

import com.page_objects.StripeIntegrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StripeIntegrationSteps extends StripeIntegrationPage {

    @Given("Stripe account setup is completed")
    public void stripeAccountSetupIsCompleted() {
        verifyStripeAccountSetup();
    }

    @When("I navigate to the payment page")
    public void iNavigateToThePaymentPage() {
        navigateToPaymentPage();
    }

    @Then("the payment page is displayed correctly")
    public void thePaymentPageIsDisplayedCorrectly() {
        verifyPaymentPageDisplayed();
    }

    @Then("API keys are configured")
    public void apiKeysAreConfigured() {
        verifyAPIKeysConfigured();
    }

    @When("I select Stripe as the payment method")
    public void iSelectStripeAsThePaymentMethod() {
        selectStripePaymentMethod();
    }

    @Then("Stripe payment method is selected")
    public void stripePaymentMethodIsSelected() {
        verifyStripePaymentMethodSelected();
    }

    @When("I enter valid credit card details")
    public void iEnterValidCreditCardDetails() {
        enterCreditCardDetails();
    }

    @Then("credit card details are accepted")
    public void creditCardDetailsAreAccepted() {
        verifyCreditCardDetailsAccepted();
    }

    @When("I enter valid billing address")
    public void iEnterValidBillingAddress() {
        enterBillingAddress();
    }

    @Then("billing address is accepted")
    public void billingAddressIsAccepted() {
        verifyBillingAddressAccepted();
    }

    @When("I enter valid email address")
    public void iEnterValidEmailAddress() {
        enterEmailAddress();
    }

    @Then("email address is accepted")
    public void emailAddressIsAccepted() {
        verifyEmailAddressAccepted();
    }

    @When("I enter product ID and amount to be charged")
    public void iEnterProductIDAndAmountToBeCharged() {
        enterProductIDAndAmount();
    }

    @Then("product ID and amount are accepted")
    public void productIDAndAmountAreAccepted() {
        verifyProductIDAndAmountAccepted();
    }

    @When("I submit the payment")
    public void iSubmitThePayment() {
        submitPayment();
    }

    @Then("payment is processed successfully")
    public void paymentIsProcessedSuccessfully() {
        verifyPaymentProcessedSuccessfully();
    }

    @When("I verify transaction confirmation message")
    public void iVerifyTransactionConfirmationMessage() {
        verifyTransactionConfirmationMessage();
    }

    @Then("transaction confirmation message is displayed")
    public void transactionConfirmationMessageIsDisplayed() {
        verifyTransactionConfirmationMessageDisplayed();
    }

    @When("I check Stripe dashboard for transaction record")
    public void iCheckStripeDashboardForTransactionRecord() {
        checkStripeDashboardForTransactionRecord();
    }

    @Then("transaction record is present in Stripe dashboard")
    public void transactionRecordIsPresentInStripeDashboard() {
        verifyTransactionRecordInStripeDashboard();
    }

    @When("I verify email notification for transaction")
    public void iVerifyEmailNotificationForTransaction() {
        verifyEmailNotificationForTransaction();
    }

    @Then("email notification is received")
    public void emailNotificationIsReceived() {
        verifyEmailNotificationReceived();
    }

    @When("I log out from the application")
    public void iLogOutFromTheApplication() {
        logOutFromApplication();
    }

    @Then("user is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyUserLoggedOutSuccessfully();
    }

    @When("I log back into the application")
    public void iLogBackIntoTheApplication() {
        logBackIntoApplication();
    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        verifyUserLoggedInSuccessfully();
    }

    @When("I check order history for transaction")
    public void iCheckOrderHistoryForTransaction() {
        checkOrderHistoryForTransaction();
    }

    @Then("transaction is present in order history")
    public void transactionIsPresentInOrderHistory() {
        verifyTransactionInOrderHistory();
    }

    @When("I verify customer support is available for transaction queries")
    public void iVerifyCustomerSupportIsAvailableForTransactionQueries() {
        verifyCustomerSupportAvailability();
    }

    @Then("customer support is available")
    public void customerSupportIsAvailable() {
        verifyCustomerSupportAvailable();
    }

    @When("I ensure transaction details are logged for auditing")
    public void iEnsureTransactionDetailsAreLoggedForAuditing() {
        ensureTransactionDetailsLogged();
    }

    @Then("transaction details are logged")
    public void transactionDetailsAreLogged() {
        verifyTransactionDetailsLogged();
    }
}