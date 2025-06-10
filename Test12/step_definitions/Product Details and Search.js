import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductPage from "../pages/productPage";
import SearchPage from "../pages/searchPage";

Given("the user is on the product page", () => {
 ProductPage.visit();
});

When("the product details are displayed", () => {
 ProductPage.displayDetails();
});

Then("the details should include name, description, price, image, stock, and category", () => {
 ProductPage.verifyDetailsInclude("name", "description", "price", "image", "stock", "category");
});

Given("the user is on the search page", () => {
 SearchPage.visit();
});

When("the user enters a keyword in the search bar", () => {
 SearchPage.enterKeyword("example keyword");
});

Then("the system should return relevant products matching the keyword", () => {
 SearchPage.verifyRelevantProducts();
});

When("the user selects a category filter", () => {
 SearchPage.selectCategoryFilter("example category");
});

Then("the system should display products belonging to the selected category", () => {
 SearchPage.verifyCategoryFilter();
});

When("the user sets a price range filter", () => {
 SearchPage.setPriceRangeFilter(10, 50);
});

Then("the system should display products within the specified price range", () => {
 SearchPage.verifyPriceRangeFilter();
});

When("the user selects a rating filter", () => {
 SearchPage.selectRatingFilter(4);
});

Then("the system should display products with the selected rating or higher", () => {
 SearchPage.verifyRatingFilter();
});

When("the product details are accessed", () => {
 ProductPage.accessDetails();
});

Then("security measures should protect product data", () => {
 ProductPage.verifySecurityMeasures();
});

When("an error occurs during the search process", () => {
 SearchPage.simulateError();
});

Then("appropriate error messages should be displayed to the user", () => {
 SearchPage.verifyErrorMessages();
});

Given("the user performs a search", () => {
 SearchPage.performSearch("example search");
});

When("the search is completed", () => {
 SearchPage.completeSearch();
});

Then("the system should log the search activity", () => {
 SearchPage.verifySearchLog();
});

When("product details are retrieved", () => {
 ProductPage.retrieveDetails();
});

Then("the integration with product databases should be seamless", () => {
 ProductPage.verifyDatabaseIntegration();
});

When("there are changes in search results or filters", () => {
 SearchPage.simulateSearchChanges();
});

Then("notifications should alert users to these changes", () => {
 SearchPage.verifyNotifications();
});

Given("the user is testing the search functionality", () => {
 SearchPage.testFunctionality();
});

When("various search features are used", () => {
 SearchPage.useFeatures();
});

Then("testing should confirm functionality across all product search features", () => {
 SearchPage.verifyFunctionality();
});

Given("the user needs information on product search and display functionalities", () => {
 SearchPage.accessDocumentation();
});

Then("comprehensive documentation should be provided", () => {
 SearchPage.verifyDocumentation();
});