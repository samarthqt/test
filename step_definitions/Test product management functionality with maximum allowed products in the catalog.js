import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("I am logged in as an admin", () => {
 ProductCatalogPage.loginAsAdmin();
});

When("I navigate to the product catalog management section", () => {
 ProductCatalogPage.navigateToCatalogManagement();
});

Then("the admin dashboard and product catalog management section should be accessible", () => {
 ProductCatalogPage.verifyAdminDashboardAccessible();
 ProductCatalogPage.verifyCatalogManagementAccessible();
});

Given("I have admin credentials", () => {
 ProductCatalogPage.setAdminCredentials();
});

And("the maximum product limit is defined", () => {
 ProductCatalogPage.defineMaxProductLimit();
});

When("I add products to the catalog", () => {
 ProductCatalogPage.addProductsToCatalog();
});

Then("products should be added successfully until the limit is reached without errors", () => {
 ProductCatalogPage.verifyProductsAddedSuccessfully();
});

Given("the product catalog is at maximum limit", () => {
 ProductCatalogPage.setCatalogToMaxLimit();
});

When("I monitor system performance metrics", () => {
 ProductCatalogPage.monitorSystemPerformance();
});

Then("system performance should remain stable with acceptable response times", () => {
 ProductCatalogPage.verifySystemPerformanceStable();
});

When("I try to add one more product", () => {
 ProductCatalogPage.tryToAddOneMoreProduct();
});

Then("the system should display an error message indicating maximum catalog limit reached", () => {
 ProductCatalogPage.verifyMaxLimitErrorMessage();
});

When("I edit product details", () => {
 ProductCatalogPage.editProductDetails();
});

Then("product details should be updated successfully without errors", () => {
 ProductCatalogPage.verifyProductDetailsUpdated();
});

When("I delete a product and add a new one", () => {
 ProductCatalogPage.deleteProductAndAddNew();
});

Then("the product should be deleted and the new product should be added successfully within the limit", () => {
 ProductCatalogPage.verifyProductDeletionAndAddition();
});

When("I check the database for product records", () => {
 ProductCatalogPage.checkDatabaseForProductRecords();
});

Then("the database should accurately reflect all operations without errors", () => {
 ProductCatalogPage.verifyDatabaseAccuracy();
});

When("catalog changes occur", () => {
 ProductCatalogPage.triggerCatalogChanges();
});

Then("notifications should be sent to relevant stakeholders", () => {
 ProductCatalogPage.verifyNotificationsSent();
});

When("users access product information", () => {
 ProductCatalogPage.accessProductInformation();
});

Then("users should be able to view all product details without errors", () => {
 ProductCatalogPage.verifyUserAccessToProductDetails();
});

When("I check the system logs", () => {
 ProductCatalogPage.checkSystemLogs();
});

Then("no unexpected errors or warnings should be recorded", () => {
 ProductCatalogPage.verifyNoErrorsInLogs();
});

When("admin interacts with the system", () => {
 ProductCatalogPage.adminInteractsWithSystem();
});

Then("admin should experience smooth navigation and interaction without delays", () => {
 ProductCatalogPage.verifyAdminExperience();
});

When("security protocols are enforced", () => {
 ProductCatalogPage.enforceSecurityProtocols();
});

Then("security protocols should be enforced without compromise", () => {
 ProductCatalogPage.verifySecurityProtocolsEnforced();
});

When("unauthorized access attempts occur", () => {
 ProductCatalogPage.simulateUnauthorizedAccessAttempts();
});

Then("alerts should be triggered for any unauthorized access attempts", () => {
 ProductCatalogPage.verifyUnauthorizedAccessAlerts();
});

When("accidental deletions occur", () => {
 ProductCatalogPage.simulateAccidentalDeletions();
});

Then("admins should be able to restore deleted products successfully", () => {
 ProductCatalogPage.verifyRollbackFunctionality();
});

When("admin performs actions on the catalog", () => {
 ProductCatalogPage.performAdminActionsOnCatalog();
});

Then("audit trails should accurately record all admin actions on the catalog", () => {
 ProductCatalogPage.verifyAuditTrails();
});