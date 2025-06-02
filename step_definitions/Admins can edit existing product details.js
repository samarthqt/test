import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductManagementPage from "../pages/productManagementPage";

Given("Admin access to the product management system", () => {
 ProductManagementPage.visit();
});

When("Admin logs in as an admin", () => {
 ProductManagementPage.loginAsAdmin();
});

Then("Admin successfully logs into the system", () => {
 ProductManagementPage.verifyLoginSuccess();
});

And("Existing products are available in the system", () => {
 ProductManagementPage.verifyExistingProducts();
});

When("Admin navigates to the product management section", () => {
 ProductManagementPage.navigateToProductManagement();
});

Then("Product management section is displayed", () => {
 ProductManagementPage.verifyProductManagementSection();
});

When("Admin selects an existing product to edit", () => {
 ProductManagementPage.selectProductToEdit();
});

Then("Existing product details are displayed", () => {
 ProductManagementPage.verifyProductDetailsDisplay();
});

When("Admin edits the product name", () => {
 ProductManagementPage.editProductName();
});

Then("Product name is updated successfully", () => {
 ProductManagementPage.verifyProductNameUpdate();
});

When("Admin edits the product description", () => {
 ProductManagementPage.editProductDescription();
});

Then("Product description is updated successfully", () => {
 ProductManagementPage.verifyProductDescriptionUpdate();
});

When("Admin edits the product price", () => {
 ProductManagementPage.editProductPrice();
});

Then("Product price is updated successfully", () => {
 ProductManagementPage.verifyProductPriceUpdate();
});

When("Admin edits the product category", () => {
 ProductManagementPage.editProductCategory();
});

Then("Product category is updated successfully", () => {
 ProductManagementPage.verifyProductCategoryUpdate();
});

When("Admin uploads a new product image", () => {
 ProductManagementPage.uploadProductImage();
});

Then("Product image is updated successfully", () => {
 ProductManagementPage.verifyProductImageUpdate();
});

When("Admin submits the updated product details", () => {
 ProductManagementPage.submitUpdatedProductDetails();
});

Then("Product details are updated successfully", () => {
 ProductManagementPage.verifyProductDetailsUpdate();
});

Then("Verify the updated product appears in the product listing", () => {
 ProductManagementPage.verifyUpdatedProductInListing();
});

And("Updated product details are visible in the product listing", () => {
 ProductManagementPage.verifyUpdatedProductDetailsInListing();
});

Then("Check for any error messages during product editing", () => {
 ProductManagementPage.checkErrorMessagesDuringEditing();
});

And("No error messages are displayed during product editing", () => {
 ProductManagementPage.verifyNoErrorMessagesDuringEditing();
});

Then("Verify updated product details are saved correctly", () => {
 ProductManagementPage.verifyProductDetailsSavedCorrectly();
});

And("Updated product details are saved accurately", () => {
 ProductManagementPage.verifyProductDetailsSavedAccurately();
});

Then("Test product editing with different categories", () => {
 ProductManagementPage.testEditingWithDifferentCategories();
});

And("Product details can be edited under different categories", () => {
 ProductManagementPage.verifyEditingUnderDifferentCategories();
});

Then("Check system logs for product editing events", () => {
 ProductManagementPage.checkSystemLogsForEditingEvents();
});

And("Logs contain entries for successful product editing", () => {
 ProductManagementPage.verifyLogsForSuccessfulEditing();
});

Then("Verify product editing handling on mobile devices", () => {
 ProductManagementPage.verifyEditingOnMobileDevices();
});

And("Product editing behaves consistently on mobile devices", () => {
 ProductManagementPage.verifyConsistencyOnMobileDevices();
});