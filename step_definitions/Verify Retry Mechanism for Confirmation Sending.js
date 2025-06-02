import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RetryConfirmationPage from "../pages/retryConfirmationPage";

Given("the order confirmation sending feature is enabled", () => {
 RetryConfirmationPage.enableConfirmationFeature();
});

When("an order confirmation sending attempt is made with a network failure", () => {
 RetryConfirmationPage.simulateNetworkFailure();
});

Then("the initial sending attempt fails due to network issues", () => {
 RetryConfirmationPage.verifyInitialFailure();
});

Given("the initial sending attempt fails due to network issues", () => {
 RetryConfirmationPage.verifyInitialFailure();
});

Then("the failure is logged with details of the error", () => {
 RetryConfirmationPage.verifyErrorLogging();
});

When("the system detects the failure", () => {
 RetryConfirmationPage.detectFailure();
});

Then("the system initiates a retry attempt automatically", () => {
 RetryConfirmationPage.initiateRetry();
});

Given("the system initiates a retry attempt automatically", () => {
 RetryConfirmationPage.initiateRetry();
});

When("the network conditions return to normal", () => {
 RetryConfirmationPage.simulateNormalNetworkConditions();
});

Then("the retry attempt succeeds and confirmation is sent", () => {
 RetryConfirmationPage.verifyRetrySuccess();
});

Given("the retry attempt succeeds and confirmation is sent", () => {
 RetryConfirmationPage.verifyRetrySuccess();
});

Then("the customer receives the confirmation email", () => {
 RetryConfirmationPage.verifyEmailReceived();
});

Then("the confirmation email includes order number, shipping address, and items purchased", () => {
 RetryConfirmationPage.verifyEmailContent();
});

Then("the retry attempt is logged with success details", () => {
 RetryConfirmationPage.verifyRetryLogging();
});

Then("only one confirmation email is sent successfully", () => {
 RetryConfirmationPage.verifySingleEmailSent();
});

Then("the user is notified of the retry attempt", () => {
 RetryConfirmationPage.verifyUserNotification();
});

Given("multiple retry scenarios occur", () => {
 RetryConfirmationPage.simulateMultipleRetries();
});

Then("the system performs retries without affecting performance", () => {
 RetryConfirmationPage.verifyPerformance();
});

Then("retries occur within the configured time frame", () => {
 RetryConfirmationPage.verifyRetryTimeFrame();
});

When("retries fail", () => {
 RetryConfirmationPage.simulateRetryFailure();
});

Then("a manual resend option is available if needed", () => {
 RetryConfirmationPage.verifyManualResendOption();
});

Then("users are not negatively impacted by retry attempts", () => {
 RetryConfirmationPage.verifyNoUserImpact();
});

Then("logs are clear and provide details of each retry attempt", () => {
 RetryConfirmationPage.verifyClearLogs();
});

Given("multiple users require retry attempts simultaneously", () => {
 RetryConfirmationPage.simulateSimultaneousRetries();
});

Then("the system handles multiple retries simultaneously without issues", () => {
 RetryConfirmationPage.verifySimultaneousRetryHandling();
});