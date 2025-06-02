import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AdminPage from "../pages/adminPage";

Given("an admin account exists", () => {
 // Precondition to ensure admin account exists
});

Given("the admin has necessary permissions to add products", () => {
 // Precondition to ensure admin has permissions
});

When("the admin logs in using valid credentials", () => {
 AdminPage.login();
});

Then("the admin successfully logs into the account", () => {
 cy.url().should("include", "/admin/dashboard");
});

When("the admin navigates to the 'Product Management' section in the admin dashboard", () => {
 AdminPage.navigateToProductManagement();
});

Then("the admin is directed to the 'Product Management' page", () => {
 cy.url().should("include", "/product-management");
});

When("the admin clicks on the 'Add New Product' button", () => {
 AdminPage.clickAddNewProduct();
});

Then("the admin is redirected to the 'Add New Product' form", () => {
 cy.url().should("include", "/add-new-product");
});

When("the admin leaves the 'Product Name' field empty", () => {
 AdminPage.leaveProductNameEmpty();
});

When("the admin selects the appropriate category {string} from the 'Category' dropdown", (category) => {
 AdminPage.selectCategory(category);
});

When("the admin leaves the 'Price' field empty", () => {
 AdminPage.leavePriceEmpty();
});

When("the admin enters the stock quantity {string} in the 'Stock Quantity' field", (quantity) => {
 AdminPage.enterStockQuantity(quantity);
});

When("the admin leaves the 'Description' field empty", () => {
 AdminPage.leaveDescriptionEmpty();
});

When("the admin leaves the image field empty", () => {
 AdminPage.leaveImageFieldEmpty();
});

When("the admin attempts to save the product with missing mandatory fields", () => {
 AdminPage.saveProduct();
});

Then("the system displays validation errors for missing mandatory fields", () => {
 AdminPage.verifyValidationErrors();
});

When("the admin checks for specific error messages for each missing field", () => {
 AdminPage.checkErrorMessages();
});

Then("specific error messages are displayed for each missing field", () => {
 AdminPage.verifySpecificErrorMessages();
});

When("the admin attempts to navigate away from the form without saving", () => {
 AdminPage.attemptNavigationAway();
});

Then("the system prompts to confirm navigation, warning about unsaved changes", () => {
 AdminPage.verifyUnsavedChangesWarning();
});

When("the admin fills in all mandatory fields and saves the product", () => {
 AdminPage.fillMandatoryFieldsAndSave();
});

Then("the product is saved successfully once all mandatory fields are filled", () => {
 AdminPage.verifyProductSaved();
});

When("the admin verifies that the product does not appear in the product list when mandatory fields are missing", () => {
 AdminPage.verifyProductNotInList();
});

Then("the product is not listed when mandatory fields are missing", () => {
 AdminPage.verifyProductNotListed();
});

When("the admin logs out of the admin account", () => {
 AdminPage.logout();
});

Then("the admin is successfully logged out and redirected to the login page", () => {
 cy.url().should("include", "/login");
});