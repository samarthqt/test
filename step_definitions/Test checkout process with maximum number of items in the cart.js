import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the user has access to the account", () => {
 CheckoutPage.verifyAccountAccess();
});

When("the user logs into the account", () => {
 CheckoutPage.login();
});

Then("the user is logged into the account", () => {
 CheckoutPage.verifyLogin();
});

When("the user adds the maximum number of items allowed to the shopping cart", () => {
 CheckoutPage.addMaxItemsToCart();
});

Then("the maximum number of items are added to the cart", () => {
 CheckoutPage.verifyMaxItemsInCart();
});

When("the user navigates to the shopping cart", () => {
 CheckoutPage.navigateToCart();
});

Then("the shopping cart is displayed with maximum items", () => {
 CheckoutPage.verifyCartDisplay();
});

When("the user proceeds to checkout", () => {
 CheckoutPage.proceedToCheckout();
});

Then("the checkout page is displayed", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("the user enters valid shipping address details", () => {
 CheckoutPage.enterShippingDetails();
});

Then("the shipping address details are entered correctly", () => {
 CheckoutPage.verifyShippingDetails();
});

When("the user enters valid billing information", () => {
 CheckoutPage.enterBillingInformation();
});

Then("the billing information is entered correctly", () => {
 CheckoutPage.verifyBillingInformation();
});

When("the user selects payment method and enters payment details", () => {
 CheckoutPage.selectPaymentMethodAndEnterDetails();
});

Then("the payment method and details are entered correctly", () => {
 CheckoutPage.verifyPaymentDetails();
});

When("the user reviews order summary and verifies total price", () => {
 CheckoutPage.reviewOrderSummary();
});

Then("the order summary and total price are displayed correctly", () => {
 CheckoutPage.verifyOrderSummary();
});

When("the user agrees to terms and conditions", () => {
 CheckoutPage.agreeToTerms();
});

Then("the terms and conditions are agreed to", () => {
 CheckoutPage.verifyTermsAgreement();
});

When("the user clicks 'Place Order' button", () => {
 CheckoutPage.placeOrder();
});

Then("the order is placed successfully", () => {
 CheckoutPage.verifyOrderPlacement();
});

When("the user verifies order confirmation", () => {
 CheckoutPage.verifyOrderConfirmation();
});

Then("the order confirmation is displayed with order details", () => {
 CheckoutPage.verifyOrderDetailsInConfirmation();
});

When("the user checks email for order confirmation receipt", () => {
 CheckoutPage.checkEmailForConfirmation();
});

Then("the order confirmation receipt is received via email", () => {
 CheckoutPage.verifyEmailReceipt();
});

When("the user verifies order details in the user account order history", () => {
 CheckoutPage.verifyOrderInHistory();
});

Then("the order details are correctly displayed in order history", () => {
 CheckoutPage.verifyOrderDetailsInHistory();
});

When("the user checks if the cart is empty after checkout", () => {
 CheckoutPage.checkCartEmptyAfterCheckout();
});

Then("the shopping cart is empty after successful checkout", () => {
 CheckoutPage.verifyCartEmpty();
});

When("the user attempts to add more items to the cart after checkout", () => {
 CheckoutPage.addItemsPostCheckout();
});

Then("items can be added to the cart after checkout", () => {
 CheckoutPage.verifyItemsAddedPostCheckout();
});