import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user is logged into the application", () => {
 // Implement login functionality here
});

When("the user navigates to the shopping cart page", () => {
 CheckoutPage.navigateToCart();
});

Then("the shopping cart page displays items added to the cart", () => {
 CheckoutPage.verifyCartItemsDisplayed();
});

Given("items are added to the shopping cart", () => {
 // Implement adding items to cart functionality here
});

Then("all items in the cart should be listed with correct name, price, quantity, and subtotal", () => {
 CheckoutPage.verifyCartItemsDetails();
});

When("the user clicks on the 'Proceed to Checkout' button", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the user is redirected to the checkout page", () => {
 cy.url().should("include", "/checkout");
});

When("the user enters valid shipping information", () => {
 CheckoutPage.enterShippingInformation();
});

Then("the shipping information is accepted and saved", () => {
 CheckoutPage.verifyShippingInformationSaved();
});

When("the user enters valid billing information", () => {
 CheckoutPage.enterBillingInformation();
});

Then("the billing information is accepted and saved", () => {
 CheckoutPage.verifyBillingInformationSaved();
});

When("the user selects a payment method", () => {
 CheckoutPage.selectPaymentMethod();
});

Then("the payment method is selected and accepted", () => {
 CheckoutPage.verifyPaymentMethodAccepted();
});

When("the user reviews the order summary", () => {
 CheckoutPage.reviewOrderSummary();
});

Then("the order summary displays correct items, quantities, prices, and totals", () => {
 CheckoutPage.verifyOrderSummaryDetails();
});

When("the user clicks on the 'Place Order' button", () => {
 CheckoutPage.placeOrder();
});

Then("the order is successfully placed and a confirmation message is displayed", () => {
 CheckoutPage.verifyOrderConfirmation();
});

Then("a confirmation email is received with order details", () => {
 // Implement email verification here
});

Then("the order appears in the order history with correct details", () => {
 CheckoutPage.verifyOrderInHistory();
});

Then("the order status is visible and can be tracked from the dashboard", () => {
 CheckoutPage.verifyOrderStatusInDashboard();
});

Then("the shopping cart is empty and ready for new items", () => {
 CheckoutPage.verifyCartIsEmpty();
});

When("the user navigates back to the homepage", () => {
 CheckoutPage.navigateToHomepage();
});

Then("the user can return using the home button or logo", () => {
 CheckoutPage.verifyReturnToHomepage();
});

Then("the checkout process is secure and uses encryption protocols", () => {
 CheckoutPage.verifyCheckoutSecurity();
});

When("the user adds new items to the cart", () => {
 CheckoutPage.addNewItemsToCart();
});

Then("the user can add new items without issues", () => {
 CheckoutPage.verifyNewItemsAdded();
});