import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("the network supports concurrent connections", () => {
 cy.intercept("GET", "**/network/status", { statusCode: 200 });
});

When("Admin1 logs in with email {string} and password {string}", (email, password) => {
 AdminPage.login(email, password);
});

Then("Admin1 is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("Admin2 logs in with email {string} and password {string}", (email, password) => {
 AdminPage.login(email, password);
});

Then("Admin2 is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

When("Admin1 navigates to the catalog management section with Product ID {string}", (productId) => {
 AdminPage.navigateToCatalogManagement(productId);
});

Then("Admin1 accesses the catalog management section", () => {
 cy.url().should("include", "catalog");
});

When("Admin2 navigates to the catalog management section with URL {string}", (url) => {
 AdminPage.navigateToCatalogManagement(url);
});

Then("Admin2 accesses the catalog management section", () => {
 cy.url().should("include", "catalog");
});

When("Admin1 attempts to delete a product", () => {
 AdminPage.deleteProduct();
});

Then("Admin1 sees a confirmation dialog for deletion", () => {
 cy.get(".confirmation-dialog").should("be.visible");
});

When("Admin2 simultaneously attempts to edit the same product", () => {
 AdminPage.editProduct();
});

Then("Admin2 receives a notification of ongoing deletion and cannot edit", () => {
 cy.get(".notification").should("contain", "ongoing deletion");
});

When("Admin1 confirms the deletion", () => {
 AdminPage.confirmDeletion();
});

Then("the product is successfully deleted", () => {
 cy.get(".success-message").should("contain", "deleted");
});

When("Admin2 verifies the product", () => {
 AdminPage.verifyProduct();
});

Then("the product is not found in the catalog", () => {
 cy.get(".empty-state").should("be.visible");
});

When("checking for error messages or alerts during concurrent actions", () => {
 AdminPage.checkForErrorsOrAlerts();
});

Then("no error messages or alerts are displayed", () => {
 cy.get(".error").should("not.exist");
});

When("verifying audit logs for concurrent actions", () => {
 AdminPage.verifyAuditLogs();
});

Then("audit logs show both admin actions with timestamps", () => {
 cy.get(".audit-log").should("contain", "Admin1").and("contain", "Admin2");
});

When("reviewing system performance during concurrent actions", () => {
 AdminPage.reviewSystemPerformance();
});

Then("system performance remains stable and unaffected", () => {
 cy.get(".performance-metrics").should("contain", "stable");
});

When("ensuring data consistency during concurrent actions", () => {
 AdminPage.ensureDataConsistency();
});

Then("data remains consistent and accurate", () => {
 cy.get(".data-consistency").should("contain", "consistent");
});

When("checking for automatic notifications regarding concurrent actions", () => {
 AdminPage.checkForNotifications();
});

Then("notifications are sent to relevant stakeholders if applicable", () => {
 cy.get(".notification").should("contain", "sent");
});

When("verifying system scalability under concurrent admin actions", () => {
 AdminPage.verifySystemScalability();
});

Then("the system handles concurrent actions smoothly without degradation", () => {
 cy.get(".scalability-metrics").should("contain", "smoothly");
});

When("attempting concurrent actions on different products", () => {
 AdminPage.attemptConcurrentActions();
});

Then("both actions succeed without interference", () => {
 cy.get(".success-message").should("contain", "succeed");
});