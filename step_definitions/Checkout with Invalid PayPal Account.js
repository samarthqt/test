import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in", () => {
 CheckoutPage.login();
});

When("the user navigates to the cart page", () => {
 CheckoutPage.goToCart();
});

Then("the cart page is displayed with selected products", () => {
 CheckoutPage.verifyCartPage();
});

Then("products are available in the cart", () => {
 CheckoutPage.verifyProductsInCart();
});

Given("the user is on the cart page", () => {
 CheckoutPage.verifyCartPage();
});

Then("products in the cart match the selected items", () => {
 CheckoutPage.verifySelectedItemsInCart();
});

When("the user clicks on 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("the user selects 'PayPal' as the payment method", () => {
 CheckoutPage.selectPaypal();
});

Then("the PayPal payment section is displayed", () => {
 CheckoutPage.verifyPaypalSection();
});

Given("the PayPal payment section is displayed", () => {
 CheckoutPage.verifyPaypalSection();
});

When("the user enters an invalid PayPal email", () => {
 CheckoutPage.enterInvalidPaypalEmail();
});

Then("the system displays an error message for invalid PayPal email", () => {
 CheckoutPage.verifyInvalidPaypalEmailError();
});

Given("the user has entered an invalid PayPal email", () => {
 CheckoutPage.enterInvalidPaypalEmail();
});

When("the user attempts to log in to PayPal", () => {
 CheckoutPage.attemptPaypalLogin();
});

Then("PayPal login fails with an error message", () => {
 CheckoutPage.verifyPaypalLoginError();
});

When("the user enters a PayPal account with insufficient funds", () => {
 CheckoutPage.enterPaypalWithInsufficientFunds();
});

Then("the system displays an error message for insufficient funds", () => {
 CheckoutPage.verifyInsufficientFundsError();
});

Given("the user has entered a PayPal account with insufficient funds", () => {
 CheckoutPage.enterPaypalWithInsufficientFunds();
});

When("the user attempts to proceed with payment", () => {
 CheckoutPage.attemptPayment();
});

Then("payment is not processed, and an error message is displayed", () => {
 CheckoutPage.verifyPaymentFailure();
});

Given("the payment was not processed", () => {
 CheckoutPage.verifyPaymentFailure();
});

Then("no order is created in the system", () => {
 CheckoutPage.verifyNoOrderCreated();
});

Given("no order is created in the system", () => {
 CheckoutPage.verifyNoOrderCreated();
});

Then("no order confirmation email is received", () => {
 CheckoutPage.verifyNoConfirmationEmail();
});

Then("products remain in the cart for future checkout attempts", () => {
 CheckoutPage.verifyProductsRemainInCart();
});

Given("the user logs out", () => {
 CheckoutPage.logout();
});

When("the user logs back in", () => {
 CheckoutPage.login();
});

Then("cart contents persist after logging back in", () => {
 CheckoutPage.verifyCartPersistence();
});

When("the user retries checkout with a different payment method", () => {
 CheckoutPage.retryCheckoutWithDifferentMethod();
});

Then("the user is able to retry checkout successfully", () => {
 CheckoutPage.verifySuccessfulRetry();
});

Then("no transaction is recorded in the PayPal account", () => {
 CheckoutPage.verifyNoTransactionInPaypal();
});

Then("the error is logged in the system for auditing", () => {
 CheckoutPage.verifyErrorLogged();
});