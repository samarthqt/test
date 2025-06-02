import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("User is logged in", () => {
 // Implement login functionality here
});

Given("User has items in the cart", () => {
 // Ensure items are added to cart
});

When("User navigates to the checkout page", () => {
 CheckoutPage.visit();
});

Then("User is directed to the checkout page", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("User selects {string} as the payment method", (method) => {
 CheckoutPage.selectPaymentMethod(method);
});

Then("{string} option is selected", (method) => {
 CheckoutPage.verifyPaymentMethodSelected(method);
});

When("User enters credit card details", () => {
 CheckoutPage.enterCreditCardDetails("4111111111111111");
});

Then("Credit card details are entered successfully", () => {
 CheckoutPage.verifyCreditCardDetailsEntered();
});

When("User proceeds to payment", () => {
 CheckoutPage.proceedToPayment();
});

Then("Payment process initiates with {string}", (method) => {
 CheckoutPage.verifyPaymentInitiation(method);
});

Then("Payment is confirmed and receipt is generated", () => {
 CheckoutPage.verifyPaymentConfirmation();
});

Then("Billing Address is {string}", (address) => {
 CheckoutPage.verifyBillingAddress(address);
});

Given("User logs out and logs back in", () => {
 // Implement logout and login functionality
});

When("User navigates to the checkout page again", () => {
 CheckoutPage.visit();
});

When("User enters PayPal account details", () => {
 CheckoutPage.enterPayPalDetails("user@example.com");
});

Then("PayPal account details are entered successfully", () => {
 CheckoutPage.verifyPayPalDetailsEntered();
});

Given("User switches browser", () => {
 // Implement browser switch functionality
});

When("User repeats the test", () => {
 // Repeat test steps
});

Then("Payment method selection should work across different browsers", () => {
 // Verify functionality across browsers
});

When("User checks for any discrepancies in transaction details", () => {
 // Check transaction details
});

Then("Transaction details should be accurate and consistent", () => {
 // Verify transaction accuracy
});

When("User attempts to checkout using guest account", () => {
 // Attempt checkout with guest account
});

Then("Guest account should be able to select payment method", () => {
 // Verify guest account payment method selection
});

When("User performs payment selection", () => {
 // Perform payment selection
});

Then("No console errors should appear during the test execution", () => {
 cy.window().then((win) => {
 cy.wrap(win.console.error).should('not.be.called');
 });
});