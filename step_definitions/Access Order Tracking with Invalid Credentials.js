import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";

Given("the user has an account with invalid credentials", () => {
 // Assuming user data setup here
});

When("the user attempts to log in using the username {string}", (username) => {
 LoginPage.enterUsername(username);
 LoginPage.submit();
});

Then("the error message {string} is displayed", (errorMessage) => {
 cy.contains(errorMessage).should("be.visible");
});

When("the user attempts to log in using the password {string}", (password) => {
 LoginPage.enterPassword(password);
 LoginPage.submit();
});

Then("the error message {string} is displayed in the mobile app", (errorMessage) => {
 cy.contains(errorMessage).should("be.visible");
});

Given("the user attempts to log in multiple times with invalid credentials", () => {
 // Logic for multiple login attempts
});

When("the login attempts exceed the limit", () => {
 // Logic to simulate exceeding login attempts
});

Then("the user is prevented from logging in", () => {
 cy.contains("Login disabled").should("be.visible");
});

Given("the user attempts to log in consecutively with invalid credentials", () => {
 // Logic for consecutive login attempts
});

When("the failed attempts exceed the limit", () => {
 // Logic for exceeding failed attempts
});

Then("the account is temporarily locked", () => {
 cy.contains("Account locked").should("be.visible");
});

Given("the user attempts to reset the password with invalid credentials", () => {
 // Logic for password reset attempt
});

When("the reset attempt is made", () => {
 LoginPage.resetPassword();
});

Then("the error message {string} is displayed", (errorMessage) => {
 cy.contains(errorMessage).should("be.visible");
});

Given("the user receives error messages on both web and mobile platforms", () => {
 // Logic for receiving error messages
});

When("the error messages are displayed", () => {
 // Logic for error message display
});

Then("they are consistent across both platforms", () => {
 cy.contains("Error message").should("be.visible");
});

Given("the user has invalid credentials", () => {
 // Setup invalid credentials
});

When("the user attempts to access order tracking information", () => {
 LoginPage.accessOrderTracking();
});

Then("the information is inaccessible", () => {
 cy.contains("Access denied").should("be.visible");
});

Given("the account is locked due to exceeded invalid login attempts", () => {
 // Logic for locked account
});

When("the user attempts to access order tracking", () => {
 LoginPage.accessOrderTracking();
});

Then("the error message {string} is displayed", (errorMessage) => {
 cy.contains(errorMessage).should("be.visible");
});

Given("multiple invalid login attempts are made", () => {
 // Logic for invalid login attempts
});

When("the system logs are checked", () => {
 // Logic for checking system logs
});

Then("the invalid login attempts are recorded with timestamps", () => {
 cy.contains("Login attempt recorded").should("be.visible");
});

Given("multiple invalid login attempts are made", () => {
 // Logic for invalid login attempts
});

When("the system handles these attempts", () => {
 // Logic for handling login attempts
});

Then("there is no performance degradation", () => {
 cy.contains("Performance stable").should("be.visible");
});

Given("the account lockout period has ended", () => {
 // Logic for lockout period end
});

When("the user logs in using valid credentials", () => {
 LoginPage.enterValidCredentials();
 LoginPage.submit();
});

Then("the login is successful", () => {
 cy.url().should("include", "/dashboard");
});

Given("multiple invalid login attempts are made", () => {
 // Logic for invalid login attempts
});

When("the system checks for security alerts", () => {
 // Logic for checking security alerts
});

Then("alerts are triggered and logged", () => {
 cy.contains("Security alert triggered").should("be.visible");
});

Given("the user has failed login attempts", () => {
 // Logic for failed login attempts
});

When("the user is presented with recovery options", () => {
 LoginPage.showRecoveryOptions();
});

Then("the user is guided to recover their account", () => {
 cy.contains("Recovery guide").should("be.visible");
});

Given("the user is logged in on both platforms", () => {
 // Logic for user login state
});

When("the user logs out", () => {
 LoginPage.logout();
});

Then("the user is successfully logged out from both platforms", () => {
 cy.contains("Logout successful").should("be.visible");
});