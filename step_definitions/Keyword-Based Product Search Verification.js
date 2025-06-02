import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import SearchPage from "../pages/searchPage";

Given("the retail application is open", () => {
 SearchPage.visit();
});

When("the user navigates to the search bar", () => {
 SearchPage.navigateToSearchBar();
});

Then("the search bar should be accessible and ready for input", () => {
 SearchPage.verifySearchBarAccessible();
});

Given("the product catalog is populated with searchable products", () => {
 SearchPage.verifyProductCatalogPopulated();
});

When("the user enters the keyword {string} in the search bar", (keyword) => {
 SearchPage.enterKeyword(keyword);
});

And("submits the search query", () => {
 SearchPage.submitSearchQuery();
});

Then("relevant product results should be displayed based on the keyword {string}", (keyword) => {
 SearchPage.verifyRelevantResults(keyword);
});

Given("the search results are displayed", () => {
 SearchPage.verifySearchResultsDisplayed();
});

Then("the search results should be relevant and accurately match the keyword {string}", (keyword) => {
 SearchPage.verifyResultsRelevance(keyword);
});

Then("search results should be displayed quickly, within acceptable time limits", () => {
 SearchPage.verifyResultsSpeed();
});

Given("search results for {string} and {string} are displayed", (keyword1, keyword2) => {
 SearchPage.verifyMultipleKeywordsResults(keyword1, keyword2);
});

Then("the search results should be consistent and accurately match different keywords", () => {
 SearchPage.verifyResultsConsistency();
});

Given("the retail application is open on a mobile device", () => {
 SearchPage.visitMobile();
});

Then("search functionality should work well on mobile, displaying relevant results quickly", () => {
 SearchPage.verifyMobileSearchFunctionality();
});

Given("search results are displayed on both desktop and mobile", () => {
 SearchPage.verifyResultsOnBothPlatforms();
});

Then("no discrepancies should be found; search results should be consistent across platforms", () => {
 SearchPage.verifyNoDiscrepanciesAcrossPlatforms();
});

Then("search results should include product details such as name, price, and image", () => {
 SearchPage.verifyProductDetailsInResults();
});

Then("'Add to Cart' button should function correctly in search results", () => {
 SearchPage.verifyAddToCartFunctionality();
});

When("the user enters a complex search query with multiple keywords", () => {
 SearchPage.enterComplexSearchQuery();
});

Then("the system should handle complex search queries well, displaying relevant results", () => {
 SearchPage.verifyComplexQueryHandling();
});

Then("no error messages or broken links should be present in search results", () => {
 SearchPage.verifyNoErrorsOrBrokenLinks();
});

When("the user applies filters by categories or price ranges", () => {
 SearchPage.applyFilters();
});

Then("search results should be filtered successfully", () => {
 SearchPage.verifyFilteredResults();
});

Given("the retail application has a large dataset", () => {
 SearchPage.verifyLargeDatasetPresence();
});

Then("the system should handle large datasets efficiently, maintaining performance during searches", () => {
 SearchPage.verifyLargeDatasetHandling();
});