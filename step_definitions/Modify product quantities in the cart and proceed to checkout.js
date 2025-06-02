import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("the user is logged into the shopping platform", () => {
  cy.login();
});

Given("products are added to the cart", () => {
  cy.addProductsToCart();
});

When("the user navigates to the cart page", () => {
  CartPage.visit();
});

Then("the cart page is displayed with all added products", () => {
  CartPage.verifyProductsInCart();
});

Given("{string} is in the cart with quantity {string}", (product, quantity) => {
  CartPage.verifyProductQuantity(product, quantity);
});

When("the user modifies the quantity of {string} to {string}", (product, quantity) => {
  CartPage.modifyProductQuantity(product, quantity);
});

Then("the quantity for {string} is updated to {string}", (product, quantity) => {
  CartPage.verifyProductQuantity(product, quantity);
});

Then("the subtotal reflects the change", () => {
  CartPage.verifySubtotal();
});

When("the user reviews the cart", () => {
  CartPage.reviewCart();
});

Then("the total amount reflects the updated quantities and subtotals", () => {
  CartPage.verifyTotalAmount();
});

When("the user clicks on the 'Proceed to Checkout' button", () => {
  CartPage.proceedToCheckout();
});

Then("the user is directed to the checkout page successfully", () => {
  CheckoutPage.verifyCheckoutPage();
});

When("the user is on the checkout page", () => {
  CheckoutPage.visit();
});

Then("all cart items and their quantities are displayed correctly", () => {
  CheckoutPage.verifyCartItems();
});

When("the user enters valid shipping information on the checkout page", () => {
  CheckoutPage.enterShippingInformation();
});

Then("the shipping information is accepted and saved successfully", () => {
  CheckoutPage.verifyShippingInformationSaved();
});

When("the user selects a payment method and enters valid payment details", () => {
  CheckoutPage.enterPaymentDetails();
});

Then("the payment details are accepted and ready for processing", () => {
  CheckoutPage.verifyPaymentDetailsAccepted();
});

When("the user clicks on the 'Confirm Purchase' button", () => {
  CheckoutPage.confirmPurchase();
});

Then("the purchase is confirmed and an order confirmation message is displayed", () => {
  CheckoutPage.verifyOrderConfirmationMessage();
});

When("the purchase is confirmed", () => {
  CheckoutPage.verifyPurchaseConfirmed();
});

Then("the order confirmation email is received with all order details", () => {
  cy.verifyOrderConfirmationEmail();
});

When("the user checks the order history", () => {
  OrderHistoryPage.visit();
});

Then("the order appears in the order history with correct details", () => {
  OrderHistoryPage.verifyOrderInHistory();
});

When("the user logs out and logs back in", () => {
  cy.logout();
  cy.login();
});

Then("the order is still present in the order history", () => {
  OrderHistoryPage.verifyOrderInHistory();
});

When("the user attempts to modify the order after checkout", () => {
  OrderHistoryPage.attemptModifyOrder();
});

Then("the system does not allow modifications and prompts a message", () => {
  OrderHistoryPage.verifyModificationNotAllowed();
});

When("the user proceeds through the checkout process", () => {
  CheckoutPage.proceedThroughCheckout();
});

Then("the system responds quickly and efficiently", () => {
  cy.verifySystemResponseTime();
});