import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged into the system with valid credentials", () => {
 // Assume user is already logged in via precondition or session setup
});

Given("the user navigates to the checkout page", () => {
 CheckoutPage.visit();
});

When("the user selects {string} as the currency for payment", (currency) => {
 CheckoutPage.selectCurrency(currency);
});

When("enters payment details for {string} transaction", (currency) => {
 CheckoutPage.enterPaymentDetails(currency);
});

When("confirms the payment using {string}", (currency) => {
 CheckoutPage.confirmPayment(currency);
});

Then("the payment is processed successfully using {string}", (currency) => {
 CheckoutPage.verifyPaymentSuccess(currency);
});

Then("transaction confirmation is received for {string}", (currency) => {
 CheckoutPage.verifyTransactionConfirmation(currency);
});

Given("the user has completed transactions in multiple currencies", () => {
 // Assume transactions are completed via precondition
});

Then("currency conversion rates are applied accurately for transactions", () => {
 CheckoutPage.verifyCurrencyConversionRates();
});