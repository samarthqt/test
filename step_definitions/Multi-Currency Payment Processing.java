package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentProcessingPage;

public class PaymentProcessingSteps extends PaymentProcessingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the system with valid credentials")
    public void theUserIsLoggedIntoTheSystemWithValidCredentials() {
        loginWithValidCredentials();
    }

    @Given("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user selects {string} as the currency for payment")
    public void theUserSelectsCurrencyForPayment(String currency) {
        selectCurrency(currency);
    }

    @When("enters payment details for {string} transaction")
    public void entersPaymentDetailsForTransaction(String currency) {
        enterPaymentDetails(currency);
    }

    @When("confirms the payment using {string}")
    public void confirmsThePaymentUsing(String currency) {
        confirmPayment(currency);
    }

    @Then("the payment is processed successfully using {string}")
    public void thePaymentIsProcessedSuccessfullyUsing(String currency) {
        verifyPaymentProcessed(currency);
    }

    @Then("transaction confirmation is received for {string}")
    public void transactionConfirmationIsReceivedFor(String currency) {
        verifyTransactionConfirmation(currency);
    }

    @Given("the user has completed transactions in multiple currencies")
    public void theUserHasCompletedTransactionsInMultipleCurrencies() {
        completeMultipleCurrencyTransactions();
    }

    @Then("currency conversion rates are applied accurately for transactions")
    public void currencyConversionRatesAreAppliedAccuratelyForTransactions() {
        verifyCurrencyConversionRates();
    }
}