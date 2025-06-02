import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the product database is populated", () => {
 // Assume the database is populated
});

Given("I navigate to the product search page", () => {
 SearchPage.visit();
});

When("I enter the invalid keyword {string} in the search bar", (keyword) => {
 SearchPage.enterSearchKeyword(keyword);
});

When("I click on the {string} button", (buttonName) => {
 SearchPage.clickSearchButton(buttonName);
});

Then("the system displays an appropriate message for no results found", () => {
 SearchPage.verifyNoResultsMessage();
});

Then("no search results are displayed", () => {
 SearchPage.verifyNoSearchResults();
});

Given("I have performed a search with the invalid keyword {string}", (keyword) => {
 SearchPage.performInvalidSearch(keyword);
});

When("I attempt to apply a category filter to the invalid search", () => {
 SearchPage.applyCategoryFilter();
});

Then("the filter application does not change the no results message", () => {
 SearchPage.verifyNoResultsMessageUnchanged();
});

When("I attempt to apply a price filter to the invalid search", () => {
 SearchPage.applyPriceFilter();
});

When("I attempt to apply a rating filter to the invalid search", () => {
 SearchPage.applyRatingFilter();
});

When("I check the system logs for any errors during the search", () => {
 SearchPage.checkSystemLogs();
});

Then("no errors are logged for the invalid keyword search", () => {
 SearchPage.verifyNoErrorsLogged();
});

When("I verify that the search bar allows re-entry of valid keywords", () => {
 SearchPage.verifySearchBarAllowsReEntry();
});

Then("the search bar allows new keyword entry", () => {
 SearchPage.verifySearchBarAllowsNewEntry();
});

Given("the search bar allows new keyword entry", () => {
 SearchPage.verifySearchBarAllowsNewEntry();
});

When("I enter a valid keyword and perform the search again", () => {
 SearchPage.enterValidKeywordAndSearch();
});

Then("search results are displayed for the valid keyword", () => {
 SearchPage.verifyValidSearchResultsDisplayed();
});

When("I add a product from the valid search results to the cart", () => {
 SearchPage.addProductToCart();
});

Then("the product is added to the cart", () => {
 SearchPage.verifyProductAddedToCart();
});

When("I check the cart for the added product", () => {
 SearchPage.checkCartForProduct();
});

Then("the cart displays the added product", () => {
 SearchPage.verifyCartDisplaysProduct();
});

Given("I have added a product to the cart", () => {
 SearchPage.verifyProductAddedToCart();
});

When("I log out from the application", () => {
 SearchPage.logOut();
});

Then("the user is logged out successfully", () => {
 SearchPage.verifyUserLoggedOut();
});

When("I ensure system performance is unaffected by invalid searches", () => {
 SearchPage.ensureSystemPerformanceUnaffected();
});

Then("system performance remains stable", () => {
 SearchPage.verifySystemPerformanceStable();
});