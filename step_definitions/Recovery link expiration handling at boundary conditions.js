import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import RecoveryPage from "../pages/recoveryPage";

Given("User account with email verification enabled", () => {
 // Setup user account with email verification
});

When("I initiate password recovery process for the user account", () => {
 RecoveryPage.initiateRecovery();
});

Then("A recovery link is sent to the user's email {string}", (email) => {
 cy.get("#emailNotification").should("contain", email);
});

Given("User has received a recovery link via email", () => {
 // Assume user has received the link
});

When("I access the email and click on the recovery link exactly at 24 hours", () => {
 RecoveryPage.clickRecoveryLink();
});

Then("User is directed to the password recovery page successfully", () => {
 cy.url().should("include", "/password-recovery");
});

When("I attempt to use the recovery link one minute after 24 hours", () => {
 RecoveryPage.clickExpiredRecoveryLink();
});

Then("User receives an error message indicating the link has expired", () => {
 cy.get("#errorMessage").should("contain", "link has expired");
});

Given("System logs are accessible", () => {
 // Access system logs
});

When("I check the system logs for link expiration events at boundary conditions", () => {
 RecoveryPage.checkSystemLogs();
});

Then("System logs show accurate handling of boundary expiration", () => {
 cy.get("#logDetails").should("contain", "boundary expiration");
});

Given("User has tested boundary conditions for link expiration", () => {
 // Boundary conditions have been tested
});

When("I request a new recovery link", () => {
 RecoveryPage.requestNewRecoveryLink();
});

Then("A new recovery link is sent to the user's email", () => {
 cy.get("#emailNotification").should("contain", "new recovery link");
});