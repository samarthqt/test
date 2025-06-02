import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import CheckoutPage from "../pages/checkoutPage";

Given("the application is under simulated high traffic conditions", () => {
 cy.simulateHighTraffic();
});

Given("a user account with items added to the cart", () => {
 CheckoutPage.accessUserAccountWithCart();
});

Given("a user is logged in with items in the cart", () => {
 CheckoutPage.ensureUserLoggedInWithCart();
});

Given("a user is on the cart page with the maximum allowed items", () => {
 CheckoutPage.navigateToCartPageWithMaxItems();
});

Given("the user has proceeded to the checkout", () => {
 CheckoutPage.proceedToCheckout();
});

Given("the user is on the checkout page", () => {
 CheckoutPage.verifyCheckoutPageLoaded();
});

Given("the payment is processed successfully", () => {
 CheckoutPage.processPaymentSuccessfully();
});

Given("the checkout process is ongoing", () => {
 CheckoutPage.verifyCheckoutOngoing();
});

Given("the application is accessed via mobile devices under high load", () => {
 cy.accessViaMobileUnderHighLoad();
});

Given("the application is accessed via different browsers under high load", () => {
 cy.accessViaDifferentBrowsersUnderHighLoad();
});

Given("the application is under peak checkout times", () => {
 cy.simulatePeakCheckoutTimes();
});

Given("the checkout process is completed", () => {
 CheckoutPage.completeCheckoutProcess();
});

When("a user account with items added to the cart is accessed", () => {
 CheckoutPage.accessUserAccountWithCart();
});

When("the user attempts to log in", () => {
 CheckoutPage.attemptLoginUnderHighLoad();
});

When("the user navigates to the cart page", () => {
 CheckoutPage.navigateToCartPage();
});

When("the user clicks 'Proceed to Checkout'", () => {
 CheckoutPage.clickProceedToCheckout();
});

When("the checkout page loads", () => {
 CheckoutPage.verifyCheckoutPageLoading();
});

When("the page is loading", () => {
 CheckoutPage.checkPageLoadingResponseTime();
});

When("the user attempts payment processing", () => {
 CheckoutPage.attemptPaymentProcessing();
});

When("the order confirmation is generated", () => {
 CheckoutPage.generateOrderConfirmation();
});

When("the user performs steps 1 to 8 with a cart containing {string} items", (cart_size) => {
 CheckoutPage.repeatCheckoutProcess(cart_size);
});

When("server resource utilization is monitored", () => {
 cy.monitorServerResourceUtilization();
});

When("the system is monitored for errors", () => {
 cy.monitorSystemForErrors();
});

When("the user attempts checkout", () => {
 CheckoutPage.attemptMobileCheckout();
});

When("system stability is monitored", () => {
 cy.monitorSystemStability();
});

When("order details are reviewed", () => {
 CheckoutPage.reviewOrderDetails();
});

Then("the application handles increased load without crashing", () => {
 cy.verifyApplicationStabilityUnderLoad();
});

Then("the user successfully logs in under high load", () => {
 CheckoutPage.verifySuccessfulLoginUnderHighLoad();
});

Then("the cart page loads within acceptable time limits", () => {
 CheckoutPage.verifyCartPageLoadingTime();
});

Then("the system processes the checkout request without delay", () => {
 CheckoutPage.verifyCheckoutProcessingWithoutDelay();
});

Then("the checkout page displays all items and details correctly", () => {
 CheckoutPage.verifyCheckoutPageDetails();
});

Then("the response time remains within acceptable limits", () => {
 CheckoutPage.verifyResponseTimeLimits();
});

Then("payment is processed successfully despite high load", () => {
 CheckoutPage.verifyPaymentProcessingSuccess();
});

Then("the user receives confirmation without delay", () => {
 CheckoutPage.verifyOrderConfirmationReceived();
});

Then("the performance remains consistent across different cart sizes", () => {
 CheckoutPage.verifyPerformanceConsistency();
});

Then("resource usage remains within expected thresholds", () => {
 cy.verifyResourceUsageThresholds();
});

Then("no errors or system crashes occur", () => {
 cy.verifyNoErrorsOrCrashes();
});

Then("the mobile checkout process functions properly", () => {
 CheckoutPage.verifyMobileCheckoutFunctionality();
});

Then("the checkout process functions properly across all tested browsers", () => {
 CheckoutPage.verifyBrowserCheckoutFunctionality();
});

Then("the system remains stable without performance degradation", () => {
 cy.verifySystemStability();
});

Then("order details match the items selected during checkout", () => {
 CheckoutPage.verifyOrderDetailsAccuracy();
});