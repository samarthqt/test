import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductManagementPage from "../pages/productManagementPage";

Given("admin access to the product management system", () => {
 ProductManagementPage.visit();
});

When("the admin logs in", () => {
 ProductManagementPage.login();
});

Then("the admin successfully logs into the system", () => {
 ProductManagementPage.verifyLoginSuccess();
});

When("the admin navigates to the product management section", () => {
 ProductManagementPage.navigateToProductManagement();
});

Then("the product management section is displayed", () => {
 ProductManagementPage.verifyProductManagementSection();
});

When("the admin selects the option to add a new product", () => {
 ProductManagementPage.selectAddNewProduct();
});

Then("the add new product form is displayed", () => {
 ProductManagementPage.verifyAddProductForm();
});

When("the admin enters a valid product name", () => {
 ProductManagementPage.enterProductName();
});

Then("the product name is entered successfully", () => {
 ProductManagementPage.verifyProductNameEntered();
});

When("the admin enters a valid product description", () => {
 ProductManagementPage.enterProductDescription();
});

Then("the product description is entered successfully", () => {
 ProductManagementPage.verifyProductDescriptionEntered();
});

When("the admin enters a valid product price", () => {
 ProductManagementPage.enterProductPrice();
});

Then("the product price is entered successfully", () => {
 ProductManagementPage.verifyProductPriceEntered();
});

When("the admin selects a valid product category {string}", (category) => {
 ProductManagementPage.selectProductCategory(category);
});

Then("the product category is selected successfully", () => {
 ProductManagementPage.verifyProductCategorySelected();
});

When("the admin uploads a valid product image", () => {
 ProductManagementPage.uploadProductImage();
});

Then("the product image is uploaded successfully", () => {
 ProductManagementPage.verifyProductImageUploaded();
});

When("the admin submits the new product form", () => {
 ProductManagementPage.submitProductForm();
});

Then("the new product is added successfully", () => {
 ProductManagementPage.verifyProductAdded();
});

Then("the new product appears in the product listing", () => {
 ProductManagementPage.verifyProductInListing();
});

Then("no error messages are displayed during product addition", () => {
 ProductManagementPage.verifyNoErrorMessages();
});

Then("product details are saved accurately", () => {
 ProductManagementPage.verifyProductDetailsSaved();
});

Then("the system logs contain entries for successful product addition", () => {
 ProductManagementPage.verifySystemLogsForProductAddition();
});

Then("product addition behaves consistently on mobile devices", () => {
 ProductManagementPage.verifyMobileDeviceConsistency();
});