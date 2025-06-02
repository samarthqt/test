import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("the user is logged into the application", () => {
 cy.login();
});

Given("the user has items in the shopping cart", () => {
 ShoppingCartPage.addItemsToCart();
});

When("the user navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Then("the shopping cart page is displayed with items listed", () => {
 ShoppingCartPage.verifyItemsListed();
});

When("the user clicks on the 'Proceed to Checkout' button", () => {
 ShoppingCartPage.proceedToCheckout();
});

Then("the checkout page is displayed with payment options", () => {
 CheckoutPage.verifyPaymentOptionsDisplayed();
});

Then("additional payment methods (Apple Pay, Google Pay) are displayed as options", () => {
 CheckoutPage.verifyAdditionalPaymentMethods();
});

Given("the user is on the checkout page with payment options", () => {
 CheckoutPage.visit();
});

When("the user selects 'Apple Pay' as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Apple Pay');
});

Then("'Apple Pay' option is selected", () => {
 CheckoutPage.verifyPaymentMethodSelected('Apple Pay');
});

When("the user completes the payment using Apple Pay", () => {
 CheckoutPage.completePayment('Apple Pay');
});

Then("the payment is processed successfully using Apple Pay", () => {
 CheckoutPage.verifyPaymentProcessed('Apple Pay');
});

And("a confirmation message is displayed", () => {
 CheckoutPage.verifyConfirmationMessage();
});

When("the user selects 'Google Pay' as the payment method", () => {
 CheckoutPage.selectPaymentMethod('Google Pay');
});

Then("'Google Pay' option is selected", () => {
 CheckoutPage.verifyPaymentMethodSelected('Google Pay');
});

When("the user completes the payment using Google Pay", () => {
 CheckoutPage.completePayment('Google Pay');
});

Then("the payment is processed successfully using Google Pay", () => {
 CheckoutPage.verifyPaymentProcessed('Google Pay');
});

Given("the user has completed a payment", () => {
 cy.paymentCompleted();
});

When("the user verifies the order summary and payment details", () => {
 CheckoutPage.verifyOrderSummaryAndPaymentDetails();
});

Then("the order summary and payment details are accurate and correspond to the selected payment method", () => {
 CheckoutPage.verifyOrderSummaryAccuracy();
});

Given("the user has completed their activities", () => {
 cy.activitiesCompleted();
});

When("the user logs out from the user account", () => {
 cy.logout();
});

Then("the user is logged out successfully", () => {
 cy.verifyLogout();
});