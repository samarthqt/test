import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PaymentPage from "../pages/paymentPage";

Given("the user is logged into the application", () => {
 PaymentPage.login();
});

When("the user navigates to the payment section", () => {
 PaymentPage.navigateToPaymentSection();
});

Then("the user should be able to access the payment section without any errors", () => {
 PaymentPage.verifyPaymentSectionAccess();
});

Given("the user is in the payment section", () => {
 PaymentPage.verifyInPaymentSection();
});

When("the user selects a payment method from the available options", () => {
 PaymentPage.selectPaymentMethod();
});

Then("the selected payment method should be highlighted and ready for input", () => {
 PaymentPage.verifyMethodHighlighted();
});

Given("the user has selected a payment method", () => {
 PaymentPage.verifyMethodSelected();
});

When("the user enters valid payment details for the selected method", () => {
 PaymentPage.enterPaymentDetails();
});

Then("the payment details should be accepted without errors", () => {
 PaymentPage.verifyDetailsAccepted();
});

Given("the user has entered valid payment details", () => {
 PaymentPage.verifyDetailsEntered();
});

When("the user initiates the payment process", () => {
 PaymentPage.initiatePaymentProcess();
});

Then("the payment should be processed securely", () => {
 PaymentPage.verifyPaymentProcessedSecurely();
});

Then("a confirmation message should be displayed", () => {
 PaymentPage.verifyConfirmationMessage();
});

Given("the user has initiated the payment process", () => {
 PaymentPage.verifyPaymentInitiated();
});

Then("payment details should be encrypted using SSL/TLS", () => {
 PaymentPage.verifyEncryptionSSL();
});

Then("no security warnings should be displayed in the browser console", () => {
 PaymentPage.verifyNoSecurityWarnings();
});

Given("the user is not authorized", () => {
 PaymentPage.verifyUserNotAuthorized();
});

When("the user attempts to access payment details", () => {
 PaymentPage.attemptAccessPaymentDetails();
});

Then("access should be denied", () => {
 PaymentPage.verifyAccessDenied();
});

Then("an error message should be displayed", () => {
 PaymentPage.verifyErrorMessage();
});

Given("the payment methods are configured", () => {
 PaymentPage.verifyMethodsConfigured();
});

When("the user accesses the payment section on different devices and browsers", () => {
 PaymentPage.accessPaymentSectionDevices();
});

Then("payment methods should be accessible on all supported devices and browsers", () => {
 PaymentPage.verifyMethodsAccessibleDevices();
});

When("a network interruption occurs", () => {
 PaymentPage.simulateNetworkInterruption();
});

Then("the system should handle the interruption gracefully", () => {
 PaymentPage.verifyInterruptionHandled();
});

Then("provide options to retry or cancel", () => {
 PaymentPage.verifyRetryCancelOptions();
});

Given("the user has initiated multiple payment processes", () => {
 PaymentPage.verifyMultiplePaymentsInitiated();
});

Then("logs should accurately reflect the status and details of each transaction", () => {
 PaymentPage.verifyTransactionLogs();
});

Given("the payment processing system is in place", () => {
 PaymentPage.verifyProcessingSystem();
});

Then("the system should meet all PCI DSS compliance requirements", () => {
 PaymentPage.verifyPCIDSSCompliance();
});

Given("the security logs are available", () => {
 PaymentPage.verifySecurityLogsAvailable();
});

Then("no unauthorized access attempts should be recorded", () => {
 PaymentPage.verifyNoUnauthorizedAttempts();
});

Then("the UI should be clear", () => {
 PaymentPage.verifyUIClear();
});

Then("options for different payment methods should be easily accessible", () => {
 PaymentPage.verifyOptionsAccessible();
});

Given("the user is using assistive technologies", () => {
 PaymentPage.verifyUsingAssistiveTechnologies();
});

When("the user selects a payment method", () => {
 PaymentPage.selectPaymentMethodAssistive();
});

Then("payment methods should be selectable using screen readers and other assistive technologies", () => {
 PaymentPage.verifySelectableAssistiveTechnologies();
});

Given("the user has completed a payment", () => {
 PaymentPage.verifyPaymentCompleted();
});

Then("confirmation notifications should be received promptly via email/SMS after successful payment", () => {
 PaymentPage.verifyConfirmationNotifications();
});