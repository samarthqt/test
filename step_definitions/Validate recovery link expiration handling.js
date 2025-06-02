import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecoveryPage from "../pages/recoveryPage";

Given("a user account with email verification enabled", () => {
 RecoveryPage.verifyEmailEnabled();
});

When("the user initiates the password recovery process", () => {
 RecoveryPage.initiateRecoveryProcess();
});

Then("a recovery link is sent to the user's email {string}", (email) => {
 RecoveryPage.verifyRecoveryLinkSent(email);
});

Given("a recovery link sent to the user's email", () => {
 RecoveryPage.verifyRecoveryLinkSentToEmail();
});

When("the user accesses the email and clicks on the recovery link within 24 hours", () => {
 RecoveryPage.accessRecoveryLinkWithinTime();
});

Then("the user is directed to the password recovery page successfully", () => {
 RecoveryPage.verifyDirectedToRecoveryPage();
});

When("the user attempts to use the recovery link after 24 hours", () => {
 RecoveryPage.attemptUseRecoveryLinkAfterExpiration();
});

Then("the user receives an error message indicating the link has expired", () => {
 RecoveryPage.verifyLinkExpiredErrorMessage();
});

When("the recovery link expires", () => {
 RecoveryPage.simulateLinkExpiration();
});

Then("the system logs show the link expiration timestamp", () => {
 RecoveryPage.verifySystemLogsForExpiration();
});

Given("a recovery link has expired", () => {
 RecoveryPage.verifyLinkExpired();
});

When("the user requests a new recovery link", () => {
 RecoveryPage.requestNewRecoveryLink();
});

Then("a new recovery link is sent to the user's email", () => {
 RecoveryPage.verifyNewRecoveryLinkSent();
});