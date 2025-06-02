import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("the admin is logged in with valid credentials {string} and {string}", (email, password) => {
 AdminPage.login(email, password);
});

Given("the product with ID {string} exists in the catalog", (productId) => {
 AdminPage.verifyProductExists(productId);
});

When("the admin navigates to the catalog management section at {string}", (url) => {
 AdminPage.visitCatalog(url);
});

When("the admin searches for the product using the product ID {string}", (productId) => {
 AdminPage.searchProduct(productId);
});

Then("the product details are displayed correctly", () => {
 AdminPage.verifyProductDetails();
});

When("the admin selects the product to be deleted", () => {
 AdminPage.selectProductForDeletion();
});

Then("the delete option is visible", () => {
 AdminPage.verifyDeleteOptionVisible();
});

When("the admin clicks on the delete button", () => {
 AdminPage.clickDeleteButton();
});

Then("a confirmation dialog appears asking for confirmation to delete the product", () => {
 AdminPage.verifyConfirmationDialog();
});

When("the admin confirms the deletion in the dialog", () => {
 AdminPage.confirmDeletion();
});

Then("the product is successfully deleted from the catalog", () => {
 AdminPage.verifyProductDeletion();
});

Then("the product is no longer listed in the catalog", () => {
 AdminPage.verifyProductNotListed();
});

Then("no error messages or alerts are displayed", () => {
 AdminPage.verifyNoErrorsOrAlerts();
});

When("the admin logs out from the admin account", () => {
 AdminPage.logout();
});

Then("the admin is successfully logged out", () => {
 AdminPage.verifyLogoutSuccess();
});

When("the admin attempts to access the deleted product via direct URL", () => {
 AdminPage.accessDeletedProduct();
});

Then("an error message indicating the product does not exist is displayed", () => {
 AdminPage.verifyProductNotExistError();
});

When("the admin checks the database for the product entry", () => {
 AdminPage.checkDatabaseForProduct();
});

Then("the product entry is removed from the database", () => {
 AdminPage.verifyProductEntryRemoved();
});

When("the admin verifies audit logs for the deletion action", () => {
 AdminPage.verifyAuditLogs();
});

Then("audit logs show the product deletion action with admin details", () => {
 AdminPage.verifyAuditLogsDetails();
});

When("the admin checks for any automatic notifications sent regarding the deletion", () => {
 AdminPage.checkAutomaticNotifications();
});

Then("notifications are sent to relevant stakeholders if applicable", () => {
 AdminPage.verifyNotificationsSent();
});

When("the admin reviews system performance post-deletion", () => {
 AdminPage.reviewSystemPerformance();
});

Then("system performance remains stable and unaffected", () => {
 AdminPage.verifySystemPerformanceStable();
});

Then("no dependent products or categories are affected by the deletion", () => {
 AdminPage.verifyNoDependenciesAffected();
});