import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the user is logged into the application", () => {
 SearchPage.login();
});

When("the user navigates to the search bar", () => {
 SearchPage.navigateToSearchBar();
});

When("the search bar is accessible and ready for input", () => {
 SearchPage.verifySearchBarAccessibility();
});

When("the user enters the keyword {string} into the search bar", (keyword) => {
 SearchPage.enterKeyword(keyword);
});

When("initiates the search", () => {
 SearchPage.initiateSearch();
});

Then("search results relevant to {string} are displayed", (keyword) => {
 SearchPage.verifySearchResults(keyword);
});

Then("all search results contain products related to {string}", (keyword) => {
 SearchPage.verifyProductsRelatedToKeyword(keyword);
});

When("the user performs a search", () => {
 SearchPage.performSearch();
});

Then("search results are ranked accurately based on relevance", () => {
 SearchPage.verifySearchResultsRanking();
});

When("the user enters a partial keyword into the search bar", () => {
 SearchPage.enterPartialKeyword();
});

Then("relevant suggestions and results are displayed for partial keywords", () => {
 SearchPage.verifySuggestionsForPartialKeywords();
});

When("the user enters a keyword synonym into the search bar", () => {
 SearchPage.enterKeywordSynonym();
});

Then("search results include products related to synonyms of the keyword", () => {
 SearchPage.verifyResultsForKeywordSynonyms();
});

When("the user enters a misspelled keyword into the search bar", () => {
 SearchPage.enterMisspelledKeyword();
});

Then("search results include suggestions or corrections for misspelled keywords", () => {
 SearchPage.verifySuggestionsForMisspelledKeywords();
});

Then("search results are displayed promptly without delay", () => {
 SearchPage.verifySearchPerformance();
});

When("the user navigates through search results", () => {
 SearchPage.navigateThroughSearchResults();
});

Then("pagination and navigation through search results function correctly", () => {
 SearchPage.verifyPaginationAndNavigation();
});

When("the user performs a search on different devices and screen sizes", () => {
 SearchPage.performSearchOnDifferentDevices();
});

Then("search results are consistent across various devices and screen sizes", () => {
 SearchPage.verifyConsistencyAcrossDevices();
});

When("the user enters multiple keywords and applies filters", () => {
 SearchPage.enterMultipleKeywordsAndFilters();
});

Then("search results accurately reflect the combination of keywords and filters", () => {
 SearchPage.verifyResultsForKeywordsAndFilters();
});