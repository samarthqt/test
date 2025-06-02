import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AccountDashboardPage from "../pages/accountDashboardPage";

Given("the user has valid login credentials", () => {
 // Assume user credentials are stored in environment variables
 cy.visit("/login");
 cy.get("#username").type(Cypress.env("username"));
 cy.get("#password").type(Cypress.env("password"));
});

When("the user logs into the application", () => {
 cy.get("#loginButton").click();
});

Then("the user is successfully logged into the application", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged into the application", () => {
 cy.url().should("include", "/dashboard");
});

When("the user navigates to the account dashboard", () => {
 AccountDashboardPage.visit();
});

Then("the account dashboard is displayed with user information", () => {
 cy.get("#userInfo").should("be.visible");
});

Given("the user is on the account dashboard", () => {
 AccountDashboardPage.visit();
});

When("the user locates the 'Order Tracking' feature on the dashboard", () => {
 AccountDashboardPage.locateOrderTrackingFeature();
});

Then("'Order Tracking' feature is visible on the dashboard", () => {
 cy.get("#orderTracking").should("be.visible");
});

Given("the 'Order Tracking' feature is visible on the dashboard", () => {
 cy.get("#orderTracking").should("be.visible");
});

When("the user clicks on the 'Order Tracking' feature", () => {
 cy.get("#orderTracking").click();
});

Then("the user is directed to the tracking information page", () => {
 cy.url().should("include", "/tracking-info");
});

Given("the user is on the tracking information page", () => {
 cy.url().should("include", "/tracking-info");
});

When("the user views the tracking information", () => {
 cy.get("#trackingDetails").should("be.visible");
});

Then("tracking information is displayed accurately from the dashboard", () => {
 cy.get("#trackingDetails").should("contain", "Expected Information");
});