package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.PaymentProcessingPage;

public class PaymentProcessingSteps extends PaymentProcessingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to the payment processing system")
    public void iHaveAccessToThePaymentProcessingSystem() {
        accessPaymentProcessingSystem();
    }

    @When("I log in to the system using User123 credentials")
    public void iLogInToTheSystemUsingUser123Credentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @Then("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        verifyLoginSuccess();
    }

    @Given("User account with sufficient funds")
    public void userAccountWithSufficientFunds() {
        verifySufficientFunds();
    }

    @Given("19 currencies set up in the system")
    public void currenciesSetUpInTheSystem() {
        verifyCurrenciesSetup();
    }

    @When("I navigate to the payment processing section")
    public void iNavigateToThePaymentProcessingSection() {
        navigateToPaymentProcessingSection();
    }

    @Then("Payment processing section is displayed")
    public void paymentProcessingSectionIsDisplayed() {
        verifyPaymentProcessingSectionDisplayed();
    }

    @When("I select the option to make a payment")
    public void iSelectTheOptionToMakeAPayment() {
        selectMakePaymentOption();
    }

    @Then("Payment options are displayed")
    public void paymentOptionsAreDisplayed() {
        verifyPaymentOptionsDisplayed();
    }

    @When("I enter the payment amount as 100 USD")
    public void iEnterThePaymentAmountAs100USD() {
        enterPaymentAmount("100", "USD");
    }

    @Then("Payment amount is accepted")
    public void paymentAmountIsAccepted() {
        verifyPaymentAmountAccepted();
    }

    @When("I select EUR as the target currency")
    public void iSelectEURAsTheTargetCurrency() {
        selectTargetCurrency("EUR");
    }

    @Then("Target currency is selected")
    public void targetCurrencyIsSelected() {
        verifyTargetCurrencySelected();
    }

    @When("I verify the displayed exchange rate of 0.85")
    public void iVerifyTheDisplayedExchangeRateOf085() {
        verifyExchangeRate("0.85");
    }

    @Then("Exchange rate is correctly displayed")
    public void exchangeRateIsCorrectlyDisplayed() {
        verifyExchangeRateDisplayed();
    }

    @When("I proceed to confirm the payment")
    public void iProceedToConfirmThePayment() {
        proceedToConfirmPayment();
    }

    @Then("Confirmation screen is displayed")
    public void confirmationScreenIsDisplayed() {
        verifyConfirmationScreenDisplayed();
    }

    @When("I confirm the payment transaction")
    public void iConfirmThePaymentTransaction() {
        confirmPaymentTransaction();
    }

    @Then("Payment is processed successfully")
    public void paymentIsProcessedSuccessfully() {
        verifyPaymentProcessedSuccessfully();
    }

    @When("I check the transaction details for currency conversion accuracy")
    public void iCheckTheTransactionDetailsForCurrencyConversionAccuracy() {
        checkTransactionDetailsForCurrencyConversion();
    }

    @Then("Currency conversion is accurate as per the exchange rate")
    public void currencyConversionIsAccurateAsPerTheExchangeRate() {
        verifyCurrencyConversionAccuracy();
    }

    @When("I verify the updated account balance in EUR")
    public void iVerifyTheUpdatedAccountBalanceInEUR() {
        verifyUpdatedAccountBalance("EUR");
    }

    @Then("Account balance reflects the conversion")
    public void accountBalanceReflectsTheConversion() {
        verifyAccountBalanceConversion();
    }

    @When("I log out of the system")
    public void iLogOutOfTheSystem() {
        logout();
    }

    @Then("User is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }
}