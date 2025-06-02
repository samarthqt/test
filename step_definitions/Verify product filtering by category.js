import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("the product listing page is displayed", () => {
 ProductListingPage.visit();
});

When("I select the category {string} from the filter options", (category) => {
 ProductListingPage.selectCategory(category);
});

When("I apply the filter", () => {
 ProductListingPage.applyFilter();
});

Then("the system displays products under {string} category", (category) => {
 ProductListingPage.verifyCategoryDisplayed(category);
});

Then("the filtered results include only {string} products", (category) => {
 ProductListingPage.verifyFilteredResults(category);
});

When("I apply any category filter", () => {
 ProductListingPage.applyAnyFilter();
});

Then("the filtered results are displayed within acceptable time", () => {
 ProductListingPage.verifyPerformance();
});

Then("logs reflect all filtering actions and outcomes", () => {
 ProductListingPage.checkLogsForFilteringActions();
});

When("I attempt to filter by a non-existent category", () => {
 ProductListingPage.filterNonExistentCategory();
});

Then("the system displays no results found message", () => {
 ProductListingPage.verifyNoResultsMessage();
});

When("I apply category and price filters", () => {
 ProductListingPage.applyCategoryAndPriceFilters();
});

Then("the system allows combination of filters and displays accurate results", () => {
 ProductListingPage.verifyCombinedFiltersResults();
});

Given("the product listing page is displayed on different devices", () => {
 ProductListingPage.visitOnDifferentDevices();
});

Then("filtering works consistently across devices", () => {
 ProductListingPage.verifyFilteringAcrossDevices();
});

When("I reset the filters", () => {
 ProductListingPage.resetFilters();
});

Then("the system resets filters and displays all products", () => {
 ProductListingPage.verifyResetFilters();
});

When("I navigate to filter options", () => {
 ProductListingPage.navigateToFilterOptions();
});

Then("filter options are accessible and easy to navigate", () => {
 ProductListingPage.verifyFilterOptionsAccessibility();
});