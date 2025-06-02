import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";
import ShoppingCartPage from "../pages/shoppingCartPage";

Given("User is logged into the application", () => {
 // Assume user is already logged in
});

Given("User has items in the shopping cart", () => {
 // Assume items are already in the cart
});

When("User navigates to the shopping cart page", () => {
 ShoppingCartPage.visit();
});

Then("Shopping cart page is displayed with items listed", () => {
 ShoppingCartPage.verifyItemsListed();
});

Then("Payment methods available are Credit Card, PayPal, Gift Card", () => {
 ShoppingCartPage.verifyPaymentMethods();
});

Given("User clicks on the 'Proceed to Checkout' button", () => {
 ShoppingCartPage.proceedToCheckout();
});

Then("Checkout page is displayed with payment options", () => {
 CheckoutPage.verifyPaymentOptionsDisplayed();
});

When("User selects {string} as the payment method", (paymentMethod) => {
 CheckoutPage.selectPaymentMethod(paymentMethod);
});

When("User enters valid {string} details", (paymentMethod) => {
 CheckoutPage.enterPaymentDetails(paymentMethod);
});

When("User clicks on 'Pay Now' button", () => {
 CheckoutPage.clickPayNow();
});

Then("Payment is processed successfully using {string}", (paymentMethod) => {
 CheckoutPage.verifyPaymentSuccess(paymentMethod);
});

Then("Confirmation message is displayed", () => {
 CheckoutPage.verifyConfirmationMessage();
});

Given("Payment is processed successfully", () => {
 // Assume payment is processed successfully
});

When("User verifies the order summary and payment details", () => {
 CheckoutPage.verifyOrderSummary();
});

Then("Order summary and payment details are accurate and correspond to the selected payment method", () => {
 CheckoutPage.verifyOrderDetailsAccuracy();
});

Given("User has completed the checkout process", () => {
 // Assume checkout process is completed
});

When("User logs out from the user account", () => {
 CheckoutPage.logout();
});

Then("User is logged out successfully", () => {
 CheckoutPage.verifyLogoutSuccess();
});