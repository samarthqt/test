import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import HomePage from "../pages/homePage";
import CartPage from "../pages/cartPage";
import CheckoutPage from "../pages/checkoutPage";
import ErrorPage from "../pages/errorPage";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("User account exists", () => {
 // Assume user account exists
});

When("User logs into the application using valid credentials", () => {
 LoginPage.visit();
 LoginPage.enterCredentials('validUser', 'validPassword');
 LoginPage.submit();
});

Then("User is successfully logged in and navigated to the homepage", () => {
 HomePage.verifyHomePage();
});

Given("User is on the homepage", () => {
 HomePage.verifyHomePage();
});

When("User navigates to the shopping cart", () => {
 HomePage.goToCart();
});

Then("All items added to the cart are displayed with their respective details", () => {
 CartPage.verifyItemsInCart();
});

Given("User is on the shopping cart page", () => {
 CartPage.verifyCartPage();
});

When("User proceeds to checkout", () => {
 CartPage.proceedToCheckout();
});

Then("Checkout page is displayed with options to enter shipping information", () => {
 CheckoutPage.verifyCheckoutPage();
});

Given("User is on the checkout page", () => {
 CheckoutPage.verifyCheckoutPage();
});

When("User enters valid shipping address details", () => {
 CheckoutPage.enterShippingDetails('John Doe', '123 Elm St', 'New York', 'NY', '10001');
});

Then("Shipping address is accepted and saved", () => {
 CheckoutPage.verifyShippingDetailsSaved();
});

Given("User has entered shipping address details", () => {
 CheckoutPage.verifyShippingDetailsSaved();
});

When("User selects 'Get Shipping Quotes' option", () => {
 CheckoutPage.getShippingQuotes();
});

Then("System attempts to retrieve shipping quotes", () => {
 CheckoutPage.verifyQuotesRetrievalAttempt();
});

Given("System is attempting to retrieve shipping quotes", () => {
 CheckoutPage.verifyQuotesRetrievalAttempt();
});

When("Network failure or service outage is simulated", () => {
 cy.intercept('GET', '/api/shipping-quotes', { forceNetworkError: true }).as('getQuotes');
 cy.wait('@getQuotes');
});

Then("System displays an error message indicating failure to retrieve shipping quotes", () => {
 ErrorPage.verifyErrorMessageDisplayed();
});

Given("Error message is displayed", () => {
 ErrorPage.verifyErrorMessageDisplayed();
});

Then("Error message includes options to retry or contact support", () => {
 ErrorPage.verifyRetryOrContactOptions();
});

Given("Error message includes retry option", () => {
 ErrorPage.verifyRetryOrContactOptions();
});

When("User attempts to retrieve shipping quotes again using retry option", () => {
 ErrorPage.retryGettingQuotes();
});

Then("System attempts to retrieve quotes again and either succeeds or displays error message", () => {
 CheckoutPage.verifyQuotesRetrievalAttempt();
});

Given("System has displayed an error message", () => {
 ErrorPage.verifyErrorMessageDisplayed();
});

Then("Error details are logged in the system for troubleshooting", () => {
 // Assume error details are logged
});

Given("Error details are logged in the system", () => {
 // Assume error details are logged
});

When("User checks email for notification", () => {
 // Assume user checks email
});

Then("Email notification is sent with details about the issue and possible resolutions", () => {
 // Assume email notification is sent
});

Given("User is on any page of the application", () => {
 // Assume user is on any page
});

When("User logs out from the application", () => {
 HomePage.logout();
});

Then("User is successfully logged out", () => {
 LoginPage.verifyLoggedOut();
});

Given("User is logged out", () => {
 LoginPage.verifyLoggedOut();
});

When("User logs into the application again", () => {
 LoginPage.enterCredentials('validUser', 'validPassword');
 LoginPage.submit();
});

And("User navigates to order history", () => {
 HomePage.goToOrderHistory();
});

Then("Order history displays recent order with an indication of shipping quote retrieval issue", () => {
 OrderHistoryPage.verifyOrderWithQuoteIssue();
});

Given("User is on the order history page", () => {
 OrderHistoryPage.verifyOrderHistoryPage();
});

When("User attempts to edit shipping details", () => {
 OrderHistoryPage.editShippingDetails();
});

And("User attempts to retrieve quotes again", () => {
 OrderHistoryPage.retryGettingQuotes();
});

Then("System allows editing of shipping details and attempts to retrieve quotes", () => {
 CheckoutPage.verifyQuotesRetrievalAttempt();
});

Given("User has edited shipping details", () => {
 // Assume user has edited shipping details
});

When("System successfully retrieves shipping quotes", () => {
 // Assume quotes are successfully retrieved
});

Then("System allows selection of preferred provider", () => {
 CheckoutPage.selectPreferredProvider();
});

Given("User has selected preferred shipping provider", () => {
 // Assume user has selected a provider
});

When("User confirms the shipping selection", () => {
 CheckoutPage.confirmShippingSelection();
});

Then("User is navigated to the payment section with selected shipping details", () => {
 CheckoutPage.verifyNavigationToPayment();
});