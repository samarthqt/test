import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import UserPage from "../pages/userPage";

Given("I am logged in as a regular user with email {string} and password {string}", (email, password) => {
 UserPage.login(email, password);
});

Given("I am logged in as a regular user", () => {
 UserPage.loginAsRegularUser();
});

Given("I am not logged in", () => {
 UserPage.visitHomePage();
});

When("I attempt to access the admin dashboard using the URL {string}", (url) => {
 cy.visit(url);
});

When("I attempt to access admin dashboard features via direct URLs", () => {
 UserPage.attemptDirectAccessToAdminFeatures();
});

When("I attempt unauthorized access to the admin dashboard", () => {
 UserPage.attemptUnauthorizedAccess();
});

When("I log out from the user account", () => {
 UserPage.logout();
});

When("I attempt to log in to the admin dashboard with incorrect credentials", () => {
 UserPage.loginWithIncorrectAdminCredentials();
});

When("I repeatedly attempt unauthorized access to the admin dashboard", () => {
 UserPage.repeatedUnauthorizedAccessAttempts();
});

When("I log in with valid admin credentials", () => {
 UserPage.loginWithValidAdminCredentials();
});

Then("I should see an error message indicating insufficient permissions", () => {
 cy.contains("Insufficient permissions").should("be.visible");
});

Then("I should be redirected to the user dashboard", () => {
 cy.url().should("include", "/user/dashboard");
});

Then("I should see appropriate error messages for each feature", () => {
 UserPage.verifyErrorMessagesForAdminFeatures();
});

Then("the audit logs should reflect denied access attempts with user details", () => {
 UserPage.verifyAuditLogsForDeniedAccess();
});

Then("I should be successfully logged out", () => {
 UserPage.verifySuccessfulLogout();
});

Then("I should see a login prompt", () => {
 cy.contains("Login").should("be.visible");
});

Then("I should see an error message indicating incorrect credentials", () => {
 cy.contains("Incorrect credentials").should("be.visible");
});

Then("the system should block further attempts after a threshold is reached", () => {
 UserPage.verifyBlockAfterThreshold();
});

Then("the system performance should remain stable and unaffected", () => {
 UserPage.verifySystemPerformance();
});

Then("the error messages should provide clear guidance for correction", () => {
 UserPage.verifyClearErrorMessages();
});

Then("notifications should be sent to relevant stakeholders if applicable", () => {
 UserPage.verifyNotificationsSent();
});

Then("security measures should prevent unauthorized access effectively", () => {
 UserPage.verifySecurityMeasures();
});

Then("a security audit should confirm the effectiveness of existing measures", () => {
 UserPage.performSecurityAudit();
});

Then("I should be successfully logged in and redirected to the admin dashboard", () => {
 cy.url().should("include", "/admin/dashboard");
});