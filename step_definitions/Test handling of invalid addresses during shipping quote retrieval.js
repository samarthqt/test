import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import ShoppingCartPage from "../pages/shoppingCartPage";
import CheckoutPage from "../pages/checkoutPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("a user account exists", () => {
 // Assume user account setup is done
});

When("the user logs into the application using valid credentials", () => {
 LoginPage.visit();
 LoginPage.enterCredentials();
 LoginPage.submit();
});

Then("the user is successfully logged in and navigated to the homepage", () => {
 cy.url().should("include", "/homepage");
});

Given("the user has added products to the cart", () => {
 // Assume products are added to the cart
});

When("the user navigates to the shopping cart", () => {
 ShoppingCartPage.visit();
});

Then("all items added to the cart are displayed with their respective details", () => {
 ShoppingCartPage.verifyCartItems();
});

Given("the user is on the shopping cart page", () => {
 ShoppingCartPage.visit();
});

When("the user proceeds to checkout", () => {
 ShoppingCartPage.proceedToCheckout();
});

Then("the checkout page is displayed with options to enter shipping information", () => {
 CheckoutPage.verifyCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters invalid shipping address details", () => {
 CheckoutPage.enterInvalidShippingAddress();
});

Then("the system detects the invalid address and displays an error message", () => {
 CheckoutPage.verifyInvalidAddressError();
});

Given("an error message is displayed for the invalid address", () => {
 CheckoutPage.verifyInvalidAddressError();
});

Then("the error message provides guidance on correcting the address", () => {
 CheckoutPage.verifyErrorMessageGuidance();
});

Given("the user has entered an invalid shipping address", () => {
 CheckoutPage.enterInvalidShippingAddress();
});

When("the user attempts to retrieve shipping quotes", () => {
 CheckoutPage.attemptRetrieveShippingQuotes();
});

Then("the system prevents retrieval of shipping quotes due to invalid address", () => {
 CheckoutPage.verifyShippingQuoteFailure();
});

Given("the user has corrected the shipping address", () => {
 CheckoutPage.enterCorrectedShippingAddress();
});

When("the user attempts retrieval again", () => {
 CheckoutPage.attemptRetrieveShippingQuotes();
});

Then("the system accepts the corrected address and successfully retrieves shipping quotes", () => {
 CheckoutPage.verifySuccessfulShippingQuotes();
});

Given("shipping quotes are retrieved successfully", () => {
 CheckoutPage.verifySuccessfulShippingQuotes();
});

When("the user reviews the shipping quotes", () => {
 CheckoutPage.reviewShippingQuotes();
});

Then("the user selects a preferred provider and confirms for checkout", () => {
 CheckoutPage.selectPreferredProvider();
});

Given("an invalid address attempt was made", () => {
 // Assume invalid address attempt is logged
});

Then("the invalid address attempt is logged for auditing purposes", () => {
 CheckoutPage.verifyInvalidAddressLogging();
});

Given("an invalid address entry was made", () => {
 // Assume invalid address entry is made
});

When("the user checks their email", () => {
 // Assume email checking process
});

Then("an email notification is sent with details about the invalid address entry", () => {
 CheckoutPage.verifyEmailNotification();
});

Given("the user is logged into the application", () => {
 LoginPage.verifyLogin();
});

When("the user logs out", () => {
 LoginPage.logout();
});

Then("the user is successfully logged out", () => {
 cy.url().should("include", "/login");
});

Given("the user has logged out of the application", () => {
 LoginPage.verifyLogout();
});

When("the user re-logs into the application", () => {
 LoginPage.visit();
 LoginPage.enterCredentials();
 LoginPage.submit();
});

Then("the user navigates to order history", () => {
 OrderHistoryPage.visit();
});

Given("the user is on the order history page", () => {
 OrderHistoryPage.visit();
});

When("the user selects the order to view", () => {
 OrderHistoryPage.selectOrderToView();
});

Then("detailed shipping information including provider and tracking number is displayed", () => {
 OrderHistoryPage.verifyShippingInformation();
});

Given("the user has detailed shipping information", () => {
 OrderHistoryPage.verifyShippingInformation();
});

When("the user tracks the order using the provided tracking number", () => {
 OrderHistoryPage.trackOrder();
});

Then("tracking information is accessible and updates are displayed in real-time", () => {
 OrderHistoryPage.verifyRealTimeUpdates();
});

Given("shipping quotes were provided during checkout", () => {
 CheckoutPage.verifySuccessfulShippingQuotes();
});

When("the user reviews the estimated delivery date", () => {
 CheckoutPage.reviewEstimatedDeliveryDate();
});

Then("the estimated delivery date matches the shipping provider's quote", () => {
 CheckoutPage.verifyEstimatedDeliveryDate();
});