import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";
import LoginPage from "../pages/loginPage";
import CartPage from "../pages/cartPage";
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

Given("the user is logged in", () => {
 // Assume user is logged in
});

When("the user adds a product to the cart", () => {
 CartPage.addProductToCart();
});

Then("all items added to the cart are displayed with their respective details", () => {
 CartPage.verifyItemsInCart();
});

Given("the user is on the shopping cart page", () => {
 CartPage.visit();
});

When("the user proceeds to checkout", () => {
 CartPage.proceedToCheckout();
});

Then("the checkout page is displayed with options to enter shipping information", () => {
 CheckoutPage.verifyCheckoutPage();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.visit();
});

When("the user enters valid shipping address details", () => {
 CheckoutPage.enterShippingAddress();
});

Then("the shipping address is accepted and saved", () => {
 CheckoutPage.verifyShippingAddressSaved();
});

Given("the user has entered a valid shipping address", () => {
 // Assume shipping address is entered
});

When("the user selects 'Get Shipping Quotes' option", () => {
 CheckoutPage.getShippingQuotes();
});

Then("real-time shipping quotes are displayed from available providers", () => {
 CheckoutPage.verifyShippingQuotesDisplayed();
});

Given("real-time shipping quotes are displayed", () => {
 // Assume shipping quotes are displayed
});

When("the user reviews the shipping quotes and selects a preferred provider", () => {
 CheckoutPage.selectPreferredShippingProvider();
});

Then("the selected shipping provider is highlighted and confirmed for checkout", () => {
 CheckoutPage.verifySelectedProviderConfirmed();
});

Given("the user has selected a shipping provider", () => {
 // Assume shipping provider is selected
});

When("the user confirms the shipping selection and proceeds to payment", () => {
 CheckoutPage.confirmShippingSelection();
 CheckoutPage.proceedToPayment();
});

Then("the user is navigated to the payment section with selected shipping details", () => {
 CheckoutPage.verifyPaymentSectionNavigation();
});

Given("the user is on the payment section", () => {
 CheckoutPage.visitPaymentSection();
});

When("the user enters payment information and completes the transaction", () => {
 CheckoutPage.enterPaymentInformation();
 CheckoutPage.completeTransaction();
});

Then("the transaction is successful, and order confirmation is displayed", () => {
 CheckoutPage.verifyTransactionSuccess();
});

Given("the transaction is successful", () => {
 // Assume transaction is successful
});

When("the user reviews the order summary", () => {
 CheckoutPage.reviewOrderSummary();
});

Then("the order summary includes the selected shipping provider and cost", () => {
 CheckoutPage.verifyOrderSummaryDetails();
});

Given("the order is confirmed", () => {
 // Assume order is confirmed
});

When("the user checks their email", () => {
 CheckoutPage.checkEmailForConfirmation();
});

Then("the email confirmation includes selected shipping provider and estimated delivery date", () => {
 CheckoutPage.verifyEmailConfirmationDetails();
});

Given("the user is logged in", () => {
 // Assume user is logged in
});

When("the user logs out from the application", () => {
 LoginPage.logout();
});

Then("the user is successfully logged out", () => {
 cy.url().should("include", "/login");
});

Given("the user is logged out", () => {
 // Assume user is logged out
});

When("the user re-logs into the application and navigates to order history", () => {
 LoginPage.reLogin();
 OrderHistoryPage.visit();
});

Then("the order history displays recent order with correct shipping details", () => {
 OrderHistoryPage.verifyRecentOrderDetails();
});

Given("the user is in the order history section", () => {
 OrderHistoryPage.visit();
});

When("the user selects the order to view detailed shipping information", () => {
 OrderHistoryPage.viewOrderDetails();
});

Then("detailed shipping information including provider and tracking number is displayed", () => {
 OrderHistoryPage.verifyShippingInformation();
});

Given("the user has a tracking number", () => {
 // Assume tracking number is available
});

When("the user tracks the order using the provided tracking number", () => {
 OrderHistoryPage.trackOrder();
});

Then("tracking information is accessible and updates are displayed in real-time", () => {
 OrderHistoryPage.verifyTrackingUpdates();
});

Given("the user has tracked the order", () => {
 // Assume order is tracked
});

When("the user verifies the estimated delivery date", () => {
 OrderHistoryPage.verifyEstimatedDeliveryDate();
});

Then("the estimated delivery date matches the shipping provider's quote", () => {
 OrderHistoryPage.verifyDeliveryDateMatchesQuote();
});