import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the user is on the product search page", () => {
  ProductSearchPage.visit();
});

When("the user selects a price range filter", () => {
  ProductSearchPage.selectPriceRangeFilter();
});

Then("the search results should display products within the selected price range", () => {
  ProductSearchPage.verifyProductsInPriceRange();
});

When("the user selects a rating filter", () => {
  ProductSearchPage.selectRatingFilter();
});

Then("the search results should display products with the selected rating or higher", () => {
  ProductSearchPage.verifyProductsWithRatingOrHigher();
});

When("the user selects both price range and rating filters", () => {
  ProductSearchPage.selectMultipleFilters();
});

Then("the search results should display products that meet both criteria", () => {
  ProductSearchPage.verifyProductsMeetingBothCriteria();
});

Given("the user has applied multiple filters", () => {
  ProductSearchPage.applyMultipleFilters();
});

When("the user clears all filters", () => {
  ProductSearchPage.clearAllFilters();
});

Then("the search results should display all products without any filters applied", () => {
  ProductSearchPage.verifyAllProductsDisplayed();
});

When("the user applies filters that match no products", () => {
  ProductSearchPage.applyNoMatchingFilters();
});

Then("the search results should display a message indicating no products were found", () => {
  ProductSearchPage.verifyNoProductsMessage();
});

Given("the user has applied filters", () => {
  ProductSearchPage.applyFilters();
});

When("the user refreshes the page", () => {
  ProductSearchPage.refreshPage();
});

Then("the previously selected filters should remain applied", () => {
  ProductSearchPage.verifyFiltersPersisted();
});