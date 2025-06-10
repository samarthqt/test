import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import PurchasePage from "../pages/purchasePage";
import PaymentPage from "../pages/paymentPage";
import ConfirmationPage from "../pages/confirmationPage";
import ErrorHandlingPage from "../pages/errorHandlingPage";
import SessionSyncPage from "../pages/sessionSyncPage";
import HistoryPage from "../pages/historyPage";
import SecurityPage from "../pages/securityPage";
import IntegrationPage from "../pages/integrationPage";
import FeedbackPage from "../pages/feedbackPage";

Given("a user is on the purchase page on desktop", () => {
 PurchasePage.visitDesktop();
});

When("the user completes the purchase process", () => {
 PurchasePage.completePurchase();
});

Then("the purchase flow should be identical on mobile", () => {
 PurchasePage.verifyMobileFlow();
});

Given("a user is on the payment page on desktop", () => {
 PaymentPage.visitDesktop();
});

When("the user selects a payment method and completes the transaction", () => {
 PaymentPage.selectPaymentMethod();
 PaymentPage.completeTransaction();
});

Then("the payment gateway should function consistently across platforms", () => {
 PaymentPage.verifyGatewayConsistency();
});

Given("a user completes a purchase on desktop", () => {
 ConfirmationPage.completePurchaseDesktop();
});

When("the transaction is successful", () => {
 ConfirmationPage.verifyTransactionSuccess();
});

Then("the user should receive instant confirmation on their purchase", () => {
 ConfirmationPage.verifyInstantConfirmation();
});

Given("a user is on the payment page", () => {
 PaymentPage.visit();
});

When("the user chooses a payment method", () => {
 PaymentPage.choosePaymentMethod();
});

Then("multiple payment methods should be supported", () => {
 PaymentPage.verifyMultipleMethodsSupport();
});

Given("a user encounters an error during purchase on desktop", () => {
 ErrorHandlingPage.encounterErrorDesktop();
});

When("the same error occurs on mobile", () => {
 ErrorHandlingPage.encounterErrorMobile();
});

Then("error handling should be consistent across devices", () => {
 ErrorHandlingPage.verifyErrorConsistency();
});

Given("a user is logged in on desktop", () => {
 SessionSyncPage.loginDesktop();
});

When("the user switches to mobile", () => {
 SessionSyncPage.switchToMobile();
});

Then("the user session should sync between desktop and mobile", () => {
 SessionSyncPage.verifySessionSync();
});

Given("a user completes a purchase", () => {
 HistoryPage.completePurchase();
});

When("the user checks their purchase history on any device", () => {
 HistoryPage.checkPurchaseHistory();
});

Then("the purchase history should be accessible on all devices", () => {
 HistoryPage.verifyHistoryAccessibility();
});

Given("a user is making a purchase", () => {
 SecurityPage.initiatePurchase();
});

When("security protocols are applied", () => {
 SecurityPage.applySecurityProtocols();
});

Then("security protocols must be consistent across platforms", () => {
 SecurityPage.verifySecurityConsistency();
});

Given("a user uses a third-party service during purchase", () => {
 IntegrationPage.useThirdPartyService();
});

When("the integration is initiated", () => {
 IntegrationPage.initiateIntegration();
});

Then("the integration with third-party services must be seamless", () => {
 IntegrationPage.verifyIntegrationSeamlessness();
});

Given("user feedback is collected", () => {
 FeedbackPage.collectFeedback();
});

When("analyzing feedback for improvements", () => {
 FeedbackPage.analyzeFeedback();
});

Then("user feedback should guide improvements in purchase flow", () => {
 FeedbackPage.verifyGuidedImprovements();
});