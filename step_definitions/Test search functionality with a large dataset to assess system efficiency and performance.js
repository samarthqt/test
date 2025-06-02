import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the product database is populated with a large dataset", () => {
 // Assume the database is already populated for testing
});

When("I navigate to the product search page", () => {
 ProductSearchPage.visit();
});

Then("the product search page is displayed", () => {
 ProductSearchPage.verifyPageDisplayed();
});

Given("I am on the product search page", () => {
 ProductSearchPage.verifyPageDisplayed();
});

When("I enter the keyword 'electronics' in the search bar", () => {
 ProductSearchPage.enterKeyword('electronics');
});

Then("the keyword is entered successfully", () => {
 ProductSearchPage.verifyKeywordEntered('electronics');
});

Given("I have entered the keyword 'electronics'", () => {
 ProductSearchPage.verifyKeywordEntered('electronics');
});

When("I select 'All Categories' from the category filter", () => {
 ProductSearchPage.selectCategoryFilter('All Categories');
});

Then("the category filter is applied", () => {
 ProductSearchPage.verifyCategoryFilterApplied('All Categories');
});

When("I apply the price filter for 'All Prices'", () => {
 ProductSearchPage.applyPriceFilter('All Prices');
});

Then("the price filter is applied", () => {
 ProductSearchPage.verifyPriceFilterApplied('All Prices');
});

When("I apply the rating filter for 'All Ratings'", () => {
 ProductSearchPage.applyRatingFilter('All Ratings');
});

Then("the rating filter is applied", () => {
 ProductSearchPage.verifyRatingFilterApplied('All Ratings');
});

Given("I have applied all necessary filters", () => {
 ProductSearchPage.verifyAllFiltersApplied();
});

When("I click on the 'Search' button", () => {
 ProductSearchPage.clickSearchButton();
});

Then("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Then("the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Given("the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

When("I measure the time taken to display search results", () => {
 ProductSearchPage.measureSearchResultTime();
});

Then("the search results are displayed within acceptable time limits", () => {
 ProductSearchPage.verifySearchResultTime();
});

When("I verify the relevance of search results to the keyword 'electronics'", () => {
 ProductSearchPage.verifyRelevanceToKeyword('electronics');
});

Then("the results are relevant to the keyword 'electronics'", () => {
 ProductSearchPage.verifyRelevanceToKeyword('electronics');
});

When("I sort the search results by price", () => {
 ProductSearchPage.sortResultsByPrice();
});

Then("the search results are sorted by price", () => {
 ProductSearchPage.verifyResultsSortedByPrice();
});

Then("the sorting order is correct", () => {
 ProductSearchPage.verifySortingOrder();
});

When("I filter the search results by rating", () => {
 ProductSearchPage.filterResultsByRating();
});

Then("the rating filter is applied", () => {
 ProductSearchPage.verifyRatingFilterApplied();
});

Then("the results are filtered by rating", () => {
 ProductSearchPage.verifyResultsFilteredByRating();
});

Given("the search results are filtered by rating", () => {
 ProductSearchPage.verifyResultsFilteredByRating();
});

When("I verify the number of results matches the applied filters", () => {
 ProductSearchPage.verifyNumberOfResultsMatchesFilters();
});

Then("the number of results matches filters", () => {
 ProductSearchPage.verifyNumberOfResultsMatchesFilters();
});

Given("I have search results displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

When("I add a product from the search results to the cart", () => {
 ProductSearchPage.addProductToCart();
});

Then("the product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

Then("the cart displays the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

Given("I have added a product to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

When("I log out from the application", () => {
 ProductSearchPage.logout();
});

Then("the user is logged out successfully", () => {
 ProductSearchPage.verifyUserLoggedOut();
});

Given("I am using the search functionality", () => {
 ProductSearchPage.verifyUsingSearchFunctionality();
});

When("I perform multiple search operations", () => {
 ProductSearchPage.performMultipleSearchOperations();
});

Then("the system performance remains stable", () => {
 ProductSearchPage.verifySystemPerformanceStable();
});