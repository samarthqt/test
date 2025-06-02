import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("Admin is logged in and product management module is accessible", () => {
 ProductPage.loginAndAccessModule();
});

When("Admin selects the product with ID {int} from the list", (productId) => {
 ProductPage.selectProductById(productId);
});

Then("Product details page is displayed", () => {
 ProductPage.verifyProductDetailsPage();
});

When("Admin clicks on the 'Edit' button for the product description field", () => {
 ProductPage.clickEditDescription();
});

Then("Description field becomes editable", () => {
 ProductPage.verifyDescriptionEditable();
});

When("Admin enters a description with the maximum allowed characters", () => {
 ProductPage.enterMaxDescription();
});

Then("Description is entered without any truncation", () => {
 ProductPage.verifyDescriptionNotTruncated();
});

When("Admin saves the changes", () => {
 ProductPage.saveChanges();
});

Then("Changes are saved successfully and confirmation message is displayed", () => {
 ProductPage.verifyChangesSaved();
});

When("Admin refreshes the page", () => {
 ProductPage.refreshPage();
});

Then("Updated description is displayed correctly", () => {
 ProductPage.verifyUpdatedDescription();
});

When("Admin logs out from admin account", () => {
 ProductPage.logout();
});

Then("Admin is logged out successfully", () => {
 ProductPage.verifyLogout();
});

When("Admin logs in again and navigates to the product", () => {
 ProductPage.loginAndNavigateToProduct();
});

Then("Description remains updated", () => {
 ProductPage.verifyDescriptionUpdated();
});

When("Admin attempts to edit description with more than maximum characters", () => {
 ProductPage.enterOverMaxDescription();
});

Then("System prevents saving and displays error message", () => {
 ProductPage.verifyErrorMessage();
});

When("Admin checks the database entry for the product description", () => {
 ProductPage.checkDatabaseEntry();
});

Then("Database reflects the updated description accurately", () => {
 ProductPage.verifyDatabaseEntry();
});

When("Admin attempts to edit description with special characters", () => {
 ProductPage.enterSpecialCharacters();
});

Then("Special characters are accepted and saved correctly", () => {
 ProductPage.verifySpecialCharactersSaved();
});

When("Admin verifies audit logs for the description change", () => {
 ProductPage.verifyAuditLogs();
});

Then("Audit logs show the change made with timestamp and admin ID", () => {
 ProductPage.verifyAuditLogDetails();
});

When("Admin checks if description is correctly displayed on the customer-facing product page", () => {
 ProductPage.checkCustomerFacingPage();
});

Then("Updated description is visible on the product page", () => {
 ProductPage.verifyDescriptionOnCustomerPage();
});

When("Admin attempts to edit description with HTML tags", () => {
 ProductPage.enterHtmlTags();
});

Then("HTML tags are sanitized or displayed as text", () => {
 ProductPage.verifyHtmlTagsSanitized();
});

When("Admin checks if the description update triggers any notification", () => {
 ProductPage.checkNotifications();
});

Then("No unexpected notifications are triggered", () => {
 ProductPage.verifyNoUnexpectedNotifications();
});