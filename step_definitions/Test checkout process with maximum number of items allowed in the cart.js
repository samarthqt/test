import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import ProductCatalogPage from "../pages/productCatalogPage";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";
import OrderConfirmationPage from "../pages/orderConfirmationPage";
import UserAccountPage from "../pages/userAccountPage";

Given("a user account with User ID {string} and password {string}", (userId, password) => {
 LoginPage.visit();
 LoginPage.enterCredentials(userId, password);
});

When("the user logs in to the e-commerce website", () => {
 LoginPage.submit();
});

Then("the user should be successfully logged in and redirected to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Given("the user is logged in", () => {
 // Assume user is already logged in
});

When("the user navigates to the product catalog", () => {
 ProductCatalogPage.visit();
});

Then("the product catalog should be displayed with various items available for purchase", () => {
 ProductCatalogPage.verifyCatalogDisplayed();
});

Given("the user is viewing the product catalog", () => {
 ProductCatalogPage.verifyCatalogDisplayed();
});

When("the user adds 50 items to the cart", () => {
 ProductCatalogPage.addItemsToCart(50);
});

Then("all selected items should be added to the cart successfully", () => {
 CartPage.verifyItemsInCart(50);
});

Given("the user has added 50 items to the cart", () => {
 CartPage.verifyItemsInCart(50);
});

When("the user views the cart", () => {
 CartPage.visit();
});

Then("the cart should display 50 items with correct details like name, price, and quantity", () => {
 CartPage.verifyCartDetails(50);
});

Given("the cart contains 50 items", () => {
 CartPage.verifyItemsInCart(50);
});

When("the user proceeds to checkout", () => {
 CartPage.proceedToCheckout();
});

Then("the user should be directed to the checkout page with all items listed", () => {
 CheckoutPage.verifyCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("the user enters valid shipping and billing information", () => {
 CheckoutPage.enterShippingAndBillingInfo();
});

Then("the shipping and billing information should be accepted without errors", () => {
 CheckoutPage.verifyShippingAndBillingInfoAccepted();
});

Given("the user has entered shipping and billing information", () => {
 CheckoutPage.verifyShippingAndBillingInfoAccepted();
});

When("the user selects a payment method and enters valid payment details", () => {
 CheckoutPage.enterPaymentDetails();
});

Then("the payment details should be processed successfully", () => {
 CheckoutPage.verifyPaymentProcessed();
});

Given("the payment details are processed successfully", () => {
 CheckoutPage.verifyPaymentProcessed();
});

When("the user confirms the order", () => {
 CheckoutPage.confirmOrder();
});

Then("order confirmation should be displayed with a unique order ID", () => {
 OrderConfirmationPage.verifyOrderConfirmation();
});

Given("the order is confirmed", () => {
 OrderConfirmationPage.verifyOrderConfirmation();
});

When("the user views the order summary in their account", () => {
 UserAccountPage.viewOrderSummary();
});

Then("the order summary should reflect the correct items, quantities, and total amount", () => {
 UserAccountPage.verifyOrderSummary();
});

When("the user checks their email", () => {
 UserAccountPage.checkEmailForOrderConfirmation();
});

Then("the user should receive an email confirmation with order details", () => {
 UserAccountPage.verifyEmailConfirmationReceived();
});

Given("the cart contains the maximum number of items", () => {
 CartPage.verifyItemsInCart(50);
});

When("the user attempts to add one more item to the cart", () => {
 ProductCatalogPage.addOneMoreItemToCart();
});

Then("the system should prevent adding more than the maximum limit and display a relevant error message", () => {
 CartPage.verifyMaxLimitErrorMessage();
});

When("the user logs out from the website", () => {
 UserAccountPage.logout();
});

Then("the user should be logged out successfully", () => {
 LoginPage.verifyLoggedOut();
});

Given("the user has logged out", () => {
 LoginPage.verifyLoggedOut();
});

When("the user logs back in", () => {
 LoginPage.enterCredentials("U12345", "********");
 LoginPage.submit();
});

Then("the cart should retain the items added before logout", () => {
 CartPage.verifyItemsInCart(50);
});

When("the user checks the order history", () => {
 UserAccountPage.checkOrderHistory();
});

Then("the order history should display the recently placed order with correct status", () => {
 UserAccountPage.verifyOrderHistory();
});

Given("the user is interacting with the website", () => {
 // Assume user is interacting
});

When("the user performs actions during the checkout process", () => {
 CheckoutPage.performCheckoutActions();
});

Then("the website should perform efficiently without delays or errors", () => {
 CheckoutPage.verifyPerformance();
});