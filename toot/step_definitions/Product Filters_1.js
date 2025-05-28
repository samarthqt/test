import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the user is on the product search results page", () => {
 ProductSearchPage.visit();
});

When("the user selects a price range filter", () => {
 ProductSearchPage.selectPriceRangeFilter();
});

Then("the search results should only display products within the selected price range", () => {
 ProductSearchPage.verifyProductsInPriceRange();
});

When("the user selects a rating filter", () => {
 ProductSearchPage.selectRatingFilter();
});

Then("the search results should only display products with the selected rating or higher", () => {
 ProductSearchPage.verifyProductsInRatingRange();
});

When("the user selects both price and rating filters", () => {
 ProductSearchPage.selectPriceAndRatingFilters();
});

Then("the search results should only display products that meet both the selected price range and rating criteria", () => {
 ProductSearchPage.verifyProductsInPriceAndRatingRange();
});

Given("the user has applied one or more filters", () => {
 ProductSearchPage.applyFilters();
});

When("the user clears all filters", () => {
 ProductSearchPage.clearAllFilters();
});

Then("the search results should display all products without any applied filters", () => {
 ProductSearchPage.verifyAllProductsDisplayed();
});

Given("the user has applied a price filter", () => {
 ProductSearchPage.applyPriceFilter();
});

When("the user modifies the price filter to a different range", () => {
 ProductSearchPage.modifyPriceFilter();
});

Then("the search results should update to display products within the new price range", () => {
 ProductSearchPage.verifyProductsInNewPriceRange();
});