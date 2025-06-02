import { Given, Then, When } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user logs into the system with valid credentials", () => {
 PaymentPage.login();
});

Then("the user is successfully logged in", () => {
 PaymentPage.verifyLoginSuccess();
});

Given("the user navigates to the checkout page", () => {
 PaymentPage.navigateToCheckout();
});

Then("the checkout page is displayed with payment options", () => {
 PaymentPage.verifyCheckoutPage();
});

Given("the user selects Stripe as the payment method", () => {
 PaymentPage.selectStripe();
});

Then("Stripe payment option is selected successfully", () => {
 PaymentPage.verifyStripeSelected();
});

Given("the user enters payment details for Stripe", () => {
 PaymentPage.enterStripeDetails();
});

Then("payment details are entered correctly", () => {
 PaymentPage.verifyPaymentDetailsEntered();
});

Given("the user confirms the payment using Stripe", () => {
 PaymentPage.confirmStripePayment();
});

Then("payment is processed successfully using Stripe", () => {
 PaymentPage.verifyStripePaymentSuccess();
});

Given("the transaction confirmation for Stripe is verified", () => {
 PaymentPage.verifyStripeTransaction();
});

Then("transaction confirmation is received for Stripe", () => {
 PaymentPage.verifyStripeConfirmationReceived();
});

Given("the user selects PayPal as the payment method", () => {
 PaymentPage.selectPayPal();
});

Then("PayPal payment option is selected successfully", () => {
 PaymentPage.verifyPayPalSelected();
});

When("the user enters payment details for PayPal", () => {
 PaymentPage.enterPayPalDetails();
});

Then("payment is processed successfully using PayPal", () => {
 PaymentPage.verifyPayPalPaymentSuccess();
});

Given("the user checks for alternative payment methods availability", () => {
 PaymentPage.checkAlternativeMethods();
});

Then("alternative payment methods are available and selectable", () => {
 PaymentPage.verifyAlternativeMethods();
});

Given("security measures are ensured during payment processing", () => {
 PaymentPage.ensureSecurityMeasures();
});

Then("security measures like encryption are verified during payment", () => {
 PaymentPage.verifySecurityMeasures();
});

Given("system logs are monitored for payment-related errors", () => {
 PaymentPage.monitorSystemLogs();
});

Then("no critical errors are logged during payment processing", () => {
 PaymentPage.verifyNoCriticalErrors();
});

Given("user notifications for successful payment are verified", () => {
 PaymentPage.verifyUserNotifications();
});

Then("user is notified accurately upon successful payment", () => {
 PaymentPage.verifyNotificationAccuracy();
});

Given("the impact of payment failures on user experience is assessed", () => {
 PaymentPage.assessPaymentFailuresImpact();
});

Then("the system handles payment failures gracefully with user notifications", () => {
 PaymentPage.verifyFailureHandling();
});

Given("system recovery from payment interruptions is tested", () => {
 PaymentPage.testSystemRecovery();
});

Then("the system recovers and resumes payment processing without data loss", () => {
 PaymentPage.verifySystemRecovery();
});

Given("system performance during peak payment times is evaluated", () => {
 PaymentPage.evaluateSystemPerformance();
});

Then("the system performs efficiently during peak payment times", () => {
 PaymentPage.verifyPerformanceEfficiency();
});