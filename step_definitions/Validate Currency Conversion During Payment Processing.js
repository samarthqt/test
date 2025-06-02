import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("I have access to the payment processing system", () => {
 PaymentPage.visit();
});

When("I log in to the system using User123 credentials", () => {
 PaymentPage.login('User123');
});

Then("User is successfully logged in", () => {
 PaymentPage.verifyLogin();
});

Given("User account with sufficient funds", () => {
 PaymentPage.verifyFunds();
});

And("19 currencies set up in the system", () => {
 PaymentPage.verifyCurrenciesSetup(19);
});

When("I navigate to the payment processing section", () => {
 PaymentPage.goToPaymentSection();
});

Then("Payment processing section is displayed", () => {
 PaymentPage.verifyPaymentSectionDisplayed();
});

When("I select the option to make a payment", () => {
 PaymentPage.selectMakePaymentOption();
});

Then("Payment options are displayed", () => {
 PaymentPage.verifyPaymentOptionsDisplayed();
});

When("I enter the payment amount as 100 USD", () => {
 PaymentPage.enterPaymentAmount(100);
});

Then("Payment amount is accepted", () => {
 PaymentPage.verifyPaymentAmountAccepted();
});

When("I select EUR as the target currency", () => {
 PaymentPage.selectTargetCurrency('EUR');
});

Then("Target currency is selected", () => {
 PaymentPage.verifyTargetCurrencySelected('EUR');
});

When("I verify the displayed exchange rate of 0.85", () => {
 PaymentPage.verifyExchangeRate(0.85);
});

Then("Exchange rate is correctly displayed", () => {
 PaymentPage.verifyExchangeRateDisplayed();
});

When("I proceed to confirm the payment", () => {
 PaymentPage.proceedToConfirmPayment();
});

Then("Confirmation screen is displayed", () => {
 PaymentPage.verifyConfirmationScreenDisplayed();
});

When("I confirm the payment transaction", () => {
 PaymentPage.confirmPaymentTransaction();
});

Then("Payment is processed successfully", () => {
 PaymentPage.verifyPaymentProcessed();
});

When("I check the transaction details for currency conversion accuracy", () => {
 PaymentPage.checkTransactionDetails();
});

Then("Currency conversion is accurate as per the exchange rate", () => {
 PaymentPage.verifyCurrencyConversionAccuracy();
});

When("I verify the updated account balance in EUR", () => {
 PaymentPage.verifyUpdatedAccountBalance('EUR');
});

Then("Account balance reflects the conversion", () => {
 PaymentPage.verifyAccountBalanceReflectsConversion();
});

When("I log out of the system", () => {
 PaymentPage.logout();
});

Then("User is logged out successfully", () => {
 PaymentPage.verifyLogout();
});