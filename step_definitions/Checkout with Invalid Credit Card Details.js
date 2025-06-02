import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in", () => {
 cy.login();
});

Given("navigates to the cart page", () => {
 cy.visit("/cart");
});

Then("the cart page is displayed with selected products", () => {
 CheckoutPage.verifyCartPageDisplayed();
});

When("the user verifies the products listed in the cart", () => {
 CheckoutPage.verifyProductsInCart();
});

Then("products in the cart match the selected items", () => {
 CheckoutPage.verifyCartItemsMatch();
});

When("the user clicks on 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPageDisplayed();
});

When("the user selects 'Credit Card' as the payment method", () => {
 CheckoutPage.selectPaymentMethod("Credit Card");
});

Then("the Credit Card payment section is displayed", () => {
 CheckoutPage.verifyCreditCardSectionDisplayed();
});

When("the user enters an invalid credit card number", () => {
 CheckoutPage.enterInvalidCreditCardNumber();
});

Then("the system displays an error message for invalid card number", () => {
 CheckoutPage.verifyInvalidCardNumberError();
});

When("the user attempts to proceed with payment", () => {
 CheckoutPage.attemptPayment();
});

Then("payment is not processed, and error message is displayed", () => {
 CheckoutPage.verifyPaymentNotProcessed();
});

Then("no order is created in the system", () => {
 CheckoutPage.verifyNoOrderCreated();
});

Then("no order confirmation email is received", () => {
 CheckoutPage.verifyNoOrderConfirmationEmail();
});

Then("the cart retains the products for future checkout attempts", () => {
 CheckoutPage.verifyCartRetainsProducts();
});

When("the user logs out and logs back in", () => {
 cy.logout();
 cy.login();
});

Then("cart contents persist after logging back in", () => {
 CheckoutPage.verifyCartContentsPersist();
});

When("the user retries with a different payment method", () => {
 CheckoutPage.retryWithDifferentPaymentMethod();
});

Then("the user is able to retry checkout with a different payment method", () => {
 CheckoutPage.verifyRetryWithDifferentPaymentMethod();
});

Then("no transaction is recorded in the payment gateway", () => {
 CheckoutPage.verifyNoTransactionRecorded();
});

Then("the system logs the error for audit purposes", () => {
 CheckoutPage.verifyErrorLoggedForAudit();
});

When("the user enters expired credit card details", () => {
 CheckoutPage.enterExpiredCreditCardDetails();
});

Then("the system displays an error message for expired card", () => {
 CheckoutPage.verifyExpiredCardError();
});

When("the user enters incorrect CVV number", () => {
 CheckoutPage.enterIncorrectCVV();
});

Then("the system displays an error message for incorrect CVV", () => {
 CheckoutPage.verifyIncorrectCVVError();
});