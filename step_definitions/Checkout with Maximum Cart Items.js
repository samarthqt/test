import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged in", () => {
 // Implement login logic here
});

Given("the user navigates to the cart page", () => {
 CartPage.visit();
});

Then("the cart page displays 50 items with IDs ranging from 201 to 250", () => {
 CartPage.verifyItemsInCart(50, 201, 250);
});

Then("the cart contains the maximum allowed number of items", () => {
 CartPage.verifyMaxItemsAllowed();
});

Given("the user is on the cart page", () => {
 CartPage.visit();
});

Then("the cart correctly lists 50 items", () => {
 CartPage.verifyTotalItems(50);
});

Then("the item IDs range from 201 to 250", () => {
 CartPage.verifyItemIDsRange(201, 250);
});

Given("the user is on the cart page with 50 items", () => {
 CartPage.visitWithItems(50);
});

When("the user clicks on the 'Proceed to Checkout' button", () => {
 CartPage.proceedToCheckout();
});

Then("the user is redirected to the checkout page", () => {
 CheckoutPage.verifyOnCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters valid shipping information", () => {
 CheckoutPage.enterShippingInfo();
});

Then("the shipping information is accepted without errors", () => {
 CheckoutPage.verifyShippingInfoAccepted();
});

When("the user enters valid billing information", () => {
 CheckoutPage.enterBillingInfo();
});

Then("the billing information is accepted without errors", () => {
 CheckoutPage.verifyBillingInfoAccepted();
});

Given("the user has entered valid shipping and billing information", () => {
 CheckoutPage.enterShippingAndBillingInfo();
});

When("the user reviews the order summary", () => {
 CheckoutPage.reviewOrderSummary();
});

Then("the order summary displays all 50 items and correct total cost", () => {
 CheckoutPage.verifyOrderSummary(50);
});

Given("the user has reviewed the order summary", () => {
 CheckoutPage.reviewedOrderSummary();
});

When("the user clicks on 'Confirm Order'", () => {
 CheckoutPage.confirmOrder();
});

Then("the order is successfully confirmed", () => {
 CheckoutPage.verifyOrderConfirmed();
});

Given("the order is confirmed", () => {
 CheckoutPage.orderConfirmed();
});

Then("the confirmation message reads: 'Your order has been placed successfully.'", () => {
 CheckoutPage.verifyConfirmationMessage();
});

Then("the user receives an order confirmation email with correct details", () => {
 CheckoutPage.verifyOrderConfirmationEmail();
});

Then("the order is listed in the user's order history with correct details", () => {
 CheckoutPage.verifyOrderInHistory();
});

Then("the payment method is correctly recorded", () => {
 CheckoutPage.verifyPaymentMethod();
});

Then("the cart is empty after successful checkout", () => {
 CartPage.verifyCartIsEmpty();
});

Given("the cart is empty post-checkout", () => {
 CartPage.emptyPostCheckout();
});

When("the user attempts to add more items to the cart", () => {
 CartPage.addItemToCart();
});

Then("items can be added to the cart again", () => {
 CartPage.verifyItemsCanBeAdded();
});

Then("the shipping tracking information is available and accurate", () => {
 CheckoutPage.verifyShippingTrackingInfo();
});

Given("the user is checking out", () => {
 CheckoutPage.userCheckingOut();
});

Then("the system performs efficiently without lag", () => {
 CheckoutPage.verifySystemPerformance();
});