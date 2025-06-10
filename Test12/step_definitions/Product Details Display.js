import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("the product page is loaded", () => {
 ProductPage.visit();
});

When("the product details are fetched from the database", () => {
 ProductPage.fetchProductDetails();
});

Then("the product name, description, price, image, stock availability, and category should be visible", () => {
 ProductPage.verifyProductDetailsVisibility();
});

Then("all fields should be correctly populated and updated in real-time", () => {
 ProductPage.verifyRealTimeUpdates();
});

When("the user clicks on the product image", () => {
 ProductPage.clickProductImage();
});

Then("the product image should be displayed in high resolution", () => {
 ProductPage.verifyHighResolutionImage();
});

When("there is an error in loading product details", () => {
 ProductPage.simulateErrorLoadingDetails();
});

Then("the system should display an error message gracefully", () => {
 ProductPage.verifyErrorMessage();
});

When("the user views the product details", () => {
 ProductPage.viewProductDetails();
});

Then("security measures should ensure product details are not tampered with", () => {
 ProductPage.verifySecurityMeasures();
});

When("the user accesses the product details", () => {
 ProductPage.accessProductDetails();
});

Then("accessibility standards must be met for all product details", () => {
 ProductPage.verifyAccessibilityStandards();
});

Given("the product page is loaded on a device", () => {
 ProductPage.visitOnDevice();
});

When("the user views the product details", () => {
 ProductPage.viewProductDetailsOnDevice();
});

Then("product details must be available on both desktop and mobile platforms", () => {
 ProductPage.verifyPlatformAvailability();
});

When("an issue is encountered during the display of product details", () => {
 ProductPage.simulateIssueDuringDisplay();
});

Then("the system should log the issue", () => {
 ProductPage.verifyIssueLogging();
});

When("the product details are updated in the database", () => {
 ProductPage.updateProductDetailsInDatabase();
});

Then("the product page should reflect accurate and timely updates", () => {
 ProductPage.verifyDatabaseUpdates();
});

When("the product is out of stock", () => {
 ProductPage.simulateOutOfStock();
});

Then("the system should notify users that the product is out of stock", () => {
 ProductPage.verifyOutOfStockNotification();
});