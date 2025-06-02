import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the product database is populated", () => {
 // Assume database is populated
});

When("I navigate to the product search page", () => {
 ProductSearchPage.visit();
});

Then("the product search page should be displayed", () => {
 ProductSearchPage.verifyPageDisplayed();
});

Given("I am on the product search page", () => {
 ProductSearchPage.verifyPageDisplayed();
});

When("I enter the keyword {string} in the search bar", (keyword) => {
 ProductSearchPage.enterKeyword(keyword);
});

Then("the keyword should be entered successfully", () => {
 ProductSearchPage.verifyKeywordEntered();
});

When("I apply the rating filter for {string}", (rating) => {
 ProductSearchPage.applyRatingFilter(rating);
});

Then("the rating filter should be applied", () => {
 ProductSearchPage.verifyRatingFilterApplied();
});

Given("the keyword and rating filter are applied", () => {
 ProductSearchPage.verifyFiltersApplied();
});

When("I click on the {string} button", (button) => {
 ProductSearchPage.clickButton(button);
});

Then("the search process should be initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Then("the search results should be displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Given("the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Then("all search results should have a rating of {string}", (rating) => {
 ProductSearchPage.verifyResultsRating(rating);
});

Then("the results should be relevant to the keyword {string}", (keyword) => {
 ProductSearchPage.verifyResultsRelevance(keyword);
});

When("I sort the search results by price", () => {
 ProductSearchPage.sortByPrice();
});

Then("the search results should be sorted by price", () => {
 ProductSearchPage.verifySortedByPrice();
});

Then("the sorting order should be correct", () => {
 ProductSearchPage.verifySortingOrder();
});

When("I filter the search results by category", () => {
 ProductSearchPage.filterByCategory();
});

Then("the category filter should be applied", () => {
 ProductSearchPage.verifyCategoryFilterApplied();
});

Then("the results should be filtered by category", () => {
 ProductSearchPage.verifyResultsFilteredByCategory();
});

Given("the search results are filtered by category", () => {
 ProductSearchPage.verifyResultsFilteredByCategory();
});

Then("the number of results should match the applied filters", () => {
 ProductSearchPage.verifyNumberOfResults();
});

When("I add a product from the search results to the cart", () => {
 ProductSearchPage.addProductToCart();
});

Then("the product should be added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

Given("a product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

When("I check the cart for the added product", () => {
 ProductSearchPage.checkCartForProduct();
});

Then("the cart should display the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

When("I log out from the application", () => {
 ProductSearchPage.logout();
});

Then("the user should be logged out successfully", () => {
 ProductSearchPage.verifyLoggedOutSuccessfully();
});