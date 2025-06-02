import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the product catalog is populated with sample products", () => {
  // Assume the catalog is already populated for testing purposes
});

When("I open the search page", () => {
  SearchPage.visit();
});

Then("the search page is displayed", () => {
  SearchPage.verifySearchPageIsDisplayed();
});

When("I enter the keyword {string} in the search bar", (keyword) => {
  SearchPage.enterKeywordInSearchBar(keyword);
});

Then("the search bar is populated with {string}", (keyword) => {
  SearchPage.verifySearchBarIsPopulated(keyword);
});

When("I click the {string} button", (button) => {
  SearchPage.clickButton(button);
});

Then("the system displays search results for {string}", (keyword) => {
  SearchPage.verifySearchResultsDisplayed(keyword);
});

Then("the search results include products related to {string}", (keyword) => {
  SearchPage.verifyProductsRelatedToKeyword(keyword);
});

When("I perform a search using any keyword", () => {
  SearchPage.performSearchWithAnyKeyword();
});

Then("the search results are accurate and relevant", () => {
  SearchPage.verifySearchResultsAccuracy();
});

Then("the search results are displayed within acceptable time", () => {
  SearchPage.verifySearchPerformanceAndSpeed();
});

Then("the logs reflect all search queries and outcomes", () => {
  SearchPage.verifySystemLogsForSearchQueries();
});

When("I enter a keyword not present in the catalog", () => {
  SearchPage.enterNonExistentKeyword();
});

Then("the system displays no results found message", () => {
  SearchPage.verifyNoResultsFoundMessage();
});

Then("the search results are paginated correctly", () => {
  SearchPage.verifySearchResultsPagination();
});

When("I perform a search using any keyword on different devices", () => {
  SearchPage.performSearchOnDifferentDevices();
});

Then("the search works consistently across devices", () => {
  SearchPage.verifySearchConsistencyAcrossDevices();
});

Then("the search results can be sorted by relevance, price, etc.", () => {
  SearchPage.verifySearchResultsSortingOptions();
});