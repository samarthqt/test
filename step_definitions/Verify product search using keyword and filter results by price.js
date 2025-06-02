import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the product database is populated", () => {
 // Assume database is populated in a before hook
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

When("I enter the keyword {string} in the search bar", (keyword) => {
 ProductSearchPage.enterKeyword(keyword);
});

Then("the keyword is entered successfully", () => {
 ProductSearchPage.verifyKeywordEntered();
});

Given("the keyword {string} is entered", (keyword) => {
 ProductSearchPage.verifyKeywordEntered();
});

When("I apply the price filter for the range {string}", (range) => {
 ProductSearchPage.applyPriceFilter(range);
});

Then("the price filter is applied", () => {
 ProductSearchPage.verifyPriceFilterApplied();
});

Given("the price filter is applied", () => {
 ProductSearchPage.verifyPriceFilterApplied();
});

When("I click on the {string} button", (button) => {
 ProductSearchPage.clickSearchButton();
});

Then("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Given("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Then("the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Given("the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Then("all results are within the specified price range", () => {
 ProductSearchPage.verifyResultsWithinPriceRange();
});

Then("results are relevant to the keyword {string}", (keyword) => {
 ProductSearchPage.verifyResultsRelevance(keyword);
});

When("I sort the search results by category", () => {
 ProductSearchPage.sortResultsByCategory();
});

Then("the search results are sorted by category", () => {
 ProductSearchPage.verifyResultsSortedByCategory();
});

Given("the search results are sorted by category", () => {
 ProductSearchPage.verifyResultsSortedByCategory();
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

Given("the rating filter is applied", () => {
 ProductSearchPage.verifyRatingFilterApplied();
});

Then("results are filtered by rating", () => {
 ProductSearchPage.verifyResultsFilteredByRating();
});

Then("the number of results matches filters", () => {
 ProductSearchPage.verifyResultsCountMatchesFilters();
});

When("I add a product from the search results to the cart", () => {
 ProductSearchPage.addProductToCart();
});

Then("the product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

Given("the product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

When("I check the cart", () => {
 ProductSearchPage.checkCart();
});

Then("the cart displays the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

Given("the cart displays the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

When("I log out from the application", () => {
 ProductSearchPage.logout();
});

Then("the user is logged out successfully", () => {
 ProductSearchPage.verifyUserLoggedOut();
});