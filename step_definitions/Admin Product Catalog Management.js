import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminProductCatalogPage from "../pages/adminProductCatalogPage";

Given("I am logged in as an admin", () => {
 AdminProductCatalogPage.loginAsAdmin();
});

When("I navigate to the product catalog management section", () => {
 AdminProductCatalogPage.navigateToProductCatalogManagement();
});

Then("I should see the admin dashboard and product catalog management section accessible", () => {
 AdminProductCatalogPage.verifyDashboardAndCatalogSection();
});

Given("I am on the product catalog management section", () => {
 AdminProductCatalogPage.ensureOnProductCatalogSection();
});

When("I click 'Add Product' and enter valid product details", () => {
 AdminProductCatalogPage.addNewProduct();
});

Then("the product should be added successfully to the catalog with correct details", () => {
 AdminProductCatalogPage.verifyProductAddedSuccessfully();
});

When("I edit an existing product's details and save changes", () => {
 AdminProductCatalogPage.editProductDetails();
});

Then("the product details should be updated successfully and reflected in the catalog", () => {
 AdminProductCatalogPage.verifyProductDetailsUpdated();
});

When("I delete a product from the catalog", () => {
 AdminProductCatalogPage.deleteProduct();
});

Then("the product should be removed successfully and no longer appear in the catalog", () => {
 AdminProductCatalogPage.verifyProductRemoved();
});

Given("the product catalog has been updated", () => {
 AdminProductCatalogPage.ensureCatalogUpdated();
});

When("I search for products", () => {
 AdminProductCatalogPage.searchProducts();
});

Then("the search results should reflect the updated catalog accurately", () => {
 AdminProductCatalogPage.verifySearchResults();
});

When("I check the database", () => {
 AdminProductCatalogPage.checkDatabaseRecords();
});

Then("the database should accurately reflect all changes made to the product catalog", () => {
 AdminProductCatalogPage.verifyDatabaseRecords();
});

When("notifications are sent", () => {
 AdminProductCatalogPage.sendNotifications();
});

Then("notifications should be sent to relevant stakeholders after catalog changes", () => {
 AdminProductCatalogPage.verifyNotificationsSent();
});

When("users access product information", () => {
 AdminProductCatalogPage.userAccessProductInfo();
});

Then("users should be able to view the updated product details without errors", () => {
 AdminProductCatalogPage.verifyUserAccess();
});

Given("the product catalog management actions are performed", () => {
 AdminProductCatalogPage.performCatalogActions();
});

When("I check the system logs", () => {
 AdminProductCatalogPage.checkSystemLogs();
});

Then("no unexpected errors or warnings should be recorded in the system logs", () => {
 AdminProductCatalogPage.verifySystemLogs();
});

Given("the admin is managing the product catalog", () => {
 AdminProductCatalogPage.adminManagingCatalog();
});

When("navigating and interacting with the system", () => {
 AdminProductCatalogPage.navigateAndInteract();
});

Then("the admin should experience smooth navigation and interaction without delays", () => {
 AdminProductCatalogPage.verifyAdminExperience();
});

Given("the admin is performing catalog management actions", () => {
 AdminProductCatalogPage.performingCatalogActions();
});

When("security protocols are enforced", () => {
 AdminProductCatalogPage.enforceSecurityProtocols();
});

Then("security protocols should be enforced without compromise", () => {
 AdminProductCatalogPage.verifySecurityProtocols();
});

Given("there is an attempt for unauthorized catalog access", () => {
 AdminProductCatalogPage.attemptUnauthorizedAccess();
});

When("alerts are triggered", () => {
 AdminProductCatalogPage.triggerAlerts();
});

Then("alerts should be triggered for any unauthorized access attempts", () => {
 AdminProductCatalogPage.verifyAlertsTriggered();
});

Given("a product is accidentally deleted", () => {
 AdminProductCatalogPage.accidentalDeletion();
});

When("I attempt to restore the product", () => {
 AdminProductCatalogPage.restoreProduct();
});

Then("admins should be able to restore deleted products successfully", () => {
 AdminProductCatalogPage.verifyProductRestoration();
});

When("updates are synchronized with external systems", () => {
 AdminProductCatalogPage.synchronizeUpdates();
});

Then("product updates should be synchronized with external systems accurately", () => {
 AdminProductCatalogPage.verifySynchronization();
});

Given("the admin performs catalog management actions", () => {
 AdminProductCatalogPage.performCatalogActions();
});

When("I check the audit trails", () => {
 AdminProductCatalogPage.checkAuditTrails();
});

Then("audit trails should accurately record all admin actions on the catalog", () => {
 AdminProductCatalogPage.verifyAuditTrails();
});