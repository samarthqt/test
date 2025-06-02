import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";

Given("I have access to the product page", () => {
 ProductPage.visit();
});

When("I navigate to the product page with ID 67890", () => {
 ProductPage.visitProduct(67890);
});

Then("the product page loads successfully", () => {
 ProductPage.verifyPageLoad();
});

Given("I am on the product page with ID 67890", () => {
 ProductPage.visitProduct(67890);
});

When("I check the product name", () => {
 ProductPage.checkProductName();
});

Then("the product name 'Example Product' is displayed correctly", () => {
 ProductPage.verifyProductName('Example Product');
});

When("I check the product description", () => {
 ProductPage.checkProductDescription();
});

Then("the description 'Sample description' is displayed correctly", () => {
 ProductPage.verifyProductDescription('Sample description');
});

When("I check the product price", () => {
 ProductPage.checkProductPrice();
});

Then("the price '$99.99' is displayed correctly", () => {
 ProductPage.verifyProductPrice('$99.99');
});

When("I check the product image", () => {
 ProductPage.checkProductImage();
});

Then("the image is displayed without distortion", () => {
 ProductPage.verifyProductImage();
});

When("I check the stock availability", () => {
 ProductPage.checkStockAvailability();
});

Then("the stock status 'Available' is displayed correctly", () => {
 ProductPage.verifyStockStatus('Available');
});

When("I check the product category", () => {
 ProductPage.checkProductCategory();
});

Then("the category 'Electronics' is displayed correctly", () => {
 ProductPage.verifyProductCategory('Electronics');
});

When("I refresh the product page", () => {
 ProductPage.refreshPage();
});

Then("the product details remain unchanged", () => {
 ProductPage.verifyProductDetailsUnchanged();
});

Given("I have access to the backend database", () => {
 ProductPage.accessDatabase();
});

When("I check the product details for ID 67890", () => {
 ProductPage.checkDatabaseDetails(67890);
});

Then("the database entries match the displayed data", () => {
 ProductPage.verifyDatabaseEntries();
});

When("I view the product page on different browsers", () => {
 ProductPage.viewOnDifferentBrowsers();
});

Then("the product details display consistently across all browsers", () => {
 ProductPage.verifyConsistencyAcrossBrowsers();
});

When("I view the product page on mobile devices", () => {
 ProductPage.viewOnMobileDevices();
});

Then("the product details are displayed correctly on mobile", () => {
 ProductPage.verifyMobileDisplay();
});

When("I edit the product details", () => {
 ProductPage.editProductDetails();
});

Then("updates reflect immediately on the product page", () => {
 ProductPage.verifyImmediateUpdates();
});

When("I check the accessibility features", () => {
 ProductPage.checkAccessibilityFeatures();
});

Then("the product details are accessible to screen readers", () => {
 ProductPage.verifyAccessibility();
});

When("I check for notifications triggered by product details", () => {
 ProductPage.checkNotifications();
});

Then("no unexpected notifications are triggered", () => {
 ProductPage.verifyNoUnexpectedNotifications();
});

Given("I have access to the search functionality", () => {
 ProductPage.accessSearchFunctionality();
});

When("I search for the product with ID 67890", () => {
 ProductPage.searchProduct(67890);
});

Then("the search results display correct product details", () => {
 ProductPage.verifySearchResults();
});