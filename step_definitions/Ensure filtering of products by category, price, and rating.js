import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("the user is logged into the application", () => {
 cy.login();
});

Given("the user is on the product catalog page", () => {
 ProductCatalogPage.visit();
});

When("the user navigates to the product catalog", () => {
 ProductCatalogPage.navigateToCatalog();
});

Then("the product catalog is displayed with filter options", () => {
 ProductCatalogPage.verifyCatalogDisplay();
});

When("the user selects the {string} category filter", (category) => {
 ProductCatalogPage.selectCategoryFilter(category);
});

Then("products related to the {string} category are displayed", (category) => {
 ProductCatalogPage.verifyCategoryProductsDisplay(category);
});

And("all displayed products belong to the {string} category", (category) => {
 ProductCatalogPage.verifyProductsBelongToCategory(category);
});

When("the user applies a price filter of {string} - {string}", (minPrice, maxPrice) => {
 ProductCatalogPage.applyPriceFilter(minPrice, maxPrice);
});

Then("products within the price range of {string} - {string} are displayed", (minPrice, maxPrice) => {
 ProductCatalogPage.verifyPriceRangeProductsDisplay(minPrice, maxPrice);
});

And("all displayed products are within the specified price range", (minPrice, maxPrice) => {
 ProductCatalogPage.verifyProductsWithinPriceRange(minPrice, maxPrice);
});

When("the user applies a rating filter of {string} stars and above", (rating) => {
 ProductCatalogPage.applyRatingFilter(rating);
});

Then("products with a rating of {string} stars and above are displayed", (rating) => {
 ProductCatalogPage.verifyRatingProductsDisplay(rating);
});

And("all displayed products have a rating of {string} stars and above", (rating) => {
 ProductCatalogPage.verifyProductsHaveRating(rating);
});

When("the user combines category, price, and rating filters", () => {
 ProductCatalogPage.combineFilters();
});

Then("products satisfying all selected filters are displayed", () => {
 ProductCatalogPage.verifyCombinedFilterProductsDisplay();
});

When("the user applies filters and then resets them", () => {
 ProductCatalogPage.applyAndResetFilters();
});

Then("the filter reset functionality is available and works correctly", () => {
 ProductCatalogPage.verifyFilterResetFunctionality();
});

When("the user applies filters with no products meeting the criteria", () => {
 ProductCatalogPage.applyFiltersWithNoResults();
});

Then("an appropriate message is displayed when no products meet the filter criteria", () => {
 ProductCatalogPage.verifyNoProductsMessage();
});

When("the user applies any filter", () => {
 ProductCatalogPage.applyAnyFilter();
});

Then("filters are applied promptly without delay", () => {
 ProductCatalogPage.verifyFilterPerformance();
});

Given("the user accesses the product catalog page on different devices", () => {
 cy.viewport("iphone-x");
 ProductCatalogPage.visit();
});

Then("filter functionality is consistent across various devices and screen sizes", () => {
 ProductCatalogPage.verifyFilterConsistencyAcrossDevices();
});

Given("the user applies filters on the product catalog page", () => {
 ProductCatalogPage.applyFilters();
});

When("the user navigates away and returns to the catalog", () => {
 cy.go("back");
 ProductCatalogPage.visit();
});

Then("selected filters persist after navigation", () => {
 ProductCatalogPage.verifyFilterPersistence();
});

Then("the product count accurately reflects the number of filtered products", () => {
 ProductCatalogPage.verifyProductCountAccuracy();
});

When("the user applies multiple filters simultaneously", () => {
 ProductCatalogPage.applyMultipleFiltersSimultaneously();
});

Then("multiple filters can be applied simultaneously without issue", () => {
 ProductCatalogPage.verifyMultipleFiltersApplication();
});