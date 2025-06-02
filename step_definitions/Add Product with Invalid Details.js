import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("the admin is logged in using valid credentials {string} and {string}", (email, password) => {
 AdminPage.login(email, password);
});

When("the admin navigates to the catalog management section", () => {
 AdminPage.goToCatalogManagement();
});

When("the admin clicks on the 'Add Product' button", () => {
 AdminPage.clickAddProduct();
});

Then("the admin is directed to the product addition form at {string}", (url) => {
 cy.url().should("include", url);
});

When("the admin enters invalid product details: Name: {string}, Price: {string}, SKU: {string}", (name, price, sku) => {
 AdminPage.enterProductDetails(name, price, sku);
});

When("the admin attempts to submit the form", () => {
 AdminPage.submitProductForm();
});

Then("error messages are displayed for invalid inputs", () => {
 AdminPage.verifyErrorMessages();
});

Then("detailed error messages are shown for empty name, non-numeric price, etc.", () => {
 AdminPage.verifyDetailedErrorMessages();
});

When("the admin attempts to correct one field at a time and resubmits", () => {
 AdminPage.correctAndResubmitFields();
});

Then("error messages update to reflect remaining invalid fields", () => {
 AdminPage.verifyUpdatedErrorMessages();
});

Then("no product is added to the catalog", () => {
 AdminPage.verifyNoProductAdded();
});

Then("the database contains no new entries", () => {
 AdminPage.verifyDatabaseNoNewEntries();
});

Then("audit logs reflect failed attempts with error details", () => {
 AdminPage.verifyAuditLogs();
});

When("the admin attempts to add a product with valid details", () => {
 AdminPage.addValidProductDetails();
});

Then("the product is successfully added without errors", () => {
 AdminPage.verifyProductAddedSuccessfully();
});

When("the admin logs out from the admin account", () => {
 AdminPage.logout();
});

Then("the admin is successfully logged out", () => {
 cy.url().should("include", "/login");
});

Then("system performance remains stable and unaffected during invalid submissions", () => {
 AdminPage.verifySystemPerformance();
});

Then("error messages provide clear guidance for correction", () => {
 AdminPage.verifyClearGuidanceInErrorMessages();
});

Then("no notifications are sent for invalid submissions", () => {
 AdminPage.verifyNoNotificationsSent();
});