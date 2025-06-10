import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("a user navigates to the product search page", () => {
 ProductSearchPage.visit();
});

When("the user enters a keyword in the search bar", () => {
 ProductSearchPage.enterKeyword('sample keyword');
});

When("the user selects a category filter", () => {
 ProductSearchPage.selectCategoryFilter('sample category');
});

When("the user selects a price range filter", () => {
 ProductSearchPage.selectPriceFilter('sample price range');
});

When("the user selects a rating filter", () => {
 ProductSearchPage.selectRatingFilter('sample rating');
});

When("the user attempts to search", () => {
 ProductSearchPage.clickSearchButton();
});

When("the search options are displayed", () => {
 ProductSearchPage.verifySearchOptions();
});

When("a user performs a search", () => {
 ProductSearchPage.performSearch();
});

When("interacting with search functionality", () => {
 ProductSearchPage.interactWithSearchFunctionality();
});

Then("the user should see a list of products matching the keyword", () => {
 ProductSearchPage.verifyMatchingProducts();
});

Then("the search results should be updated to display products within the selected category", () => {
 ProductSearchPage.verifyCategoryFilteredResults();
});

Then("the search results should be updated to display products within the selected price range", () => {
 ProductSearchPage.verifyPriceFilteredResults();
});

Then("the search results should be updated to display products within the selected rating", () => {
 ProductSearchPage.verifyRatingFilteredResults();
});

Then("the results should accurately reflect products related to the keyword", () => {
 ProductSearchPage.verifyAccurateResults();
});

Then("the search results should be displayed promptly without performance degradation", () => {
 ProductSearchPage.verifyPerformance();
});

Then("an error message should be displayed indicating the query is invalid", () => {
 ProductSearchPage.verifyErrorMessage();
});

Then("the options should be clearly visible and easy to use", () => {
 ProductSearchPage.verifyOptionsVisibility();
});

Then("search results should be displayed in a clear and organized manner", () => {
 ProductSearchPage.verifyResultsOrganization();
});

Then("the search activity should be logged for analysis", () => {
 ProductSearchPage.verifyLogging();
});

Then("the search results should accurately reflect the current product catalog", () => {
 ProductSearchPage.verifyCatalogIntegration();
});

Then("the experience should comply with established user experience standards", () => {
 ProductSearchPage.verifyUserExperienceCompliance();
});