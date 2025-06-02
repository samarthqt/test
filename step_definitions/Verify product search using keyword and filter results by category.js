import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the product database is populated", () => {
 // Assume the database is already populated
});

When("I navigate to the product search page", () => {
 ProductSearchPage.visit();
});

Then("the product search page is displayed", () => {
 ProductSearchPage.verifyPageDisplayed();
});

And("I understand category filters available", () => {
 ProductSearchPage.verifyCategoryFilters();
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

Given("I have entered a keyword in the search bar", () => {
 ProductSearchPage.verifyKeywordEntered();
});

When("I select {string} from the category filter", (category) => {
 ProductSearchPage.selectCategoryFilter(category);
});

Then("the category filter is applied", () => {
 ProductSearchPage.verifyCategoryFilterApplied();
});

Given("I have selected a category filter", () => {
 ProductSearchPage.verifyCategoryFilterApplied();
});

When("I click on the {string} button", (button) => {
 ProductSearchPage.clickButton(button);
});

Then("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Given("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

When("I check if the search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Then("search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

Given("search results are displayed", () => {
 ProductSearchPage.verifySearchResultsDisplayed();
});

When("I verify that all search results belong to the {string} category", (category) => {
 ProductSearchPage.verifyResultsCategory(category);
});

Then("all results are from the {string} category", (category) => {
 ProductSearchPage.verifyResultsCategory(category);
});

When("I check the relevance of search results to the keyword {string}", (keyword) => {
 ProductSearchPage.verifyResultsRelevance(keyword);
});

Then("results are relevant to the keyword {string}", (keyword) => {
 ProductSearchPage.verifyResultsRelevance(keyword);
});

When("I sort the search results by price", () => {
 ProductSearchPage.sortResultsByPrice();
});

Then("search results are sorted by price", () => {
 ProductSearchPage.verifyResultsSortedByPrice();
});

Given("search results are sorted by price", () => {
 ProductSearchPage.verifyResultsSortedByPrice();
});

When("I verify the sorting order is correct", () => {
 ProductSearchPage.verifySortingOrder();
});

Then("sorting order is correct", () => {
 ProductSearchPage.verifySortingOrder();
});

When("I filter the search results by rating", () => {
 ProductSearchPage.filterResultsByRating();
});

Then("rating filter is applied", () => {
 ProductSearchPage.verifyRatingFilterApplied();
});

Given("rating filter is applied", () => {
 ProductSearchPage.verifyRatingFilterApplied();
});

When("I check if the search results are filtered by rating", () => {
 ProductSearchPage.verifyResultsFilteredByRating();
});

Then("results are filtered by rating", () => {
 ProductSearchPage.verifyResultsFilteredByRating();
});

Given("search results are filtered", () => {
 ProductSearchPage.verifyResultsFiltered();
});

When("I verify the number of results matches the applied filters", () => {
 ProductSearchPage.verifyResultsCountMatchesFilters();
});

Then("number of results matches filters", () => {
 ProductSearchPage.verifyResultsCountMatchesFilters();
});

When("I add a product from the search results to the cart", () => {
 ProductSearchPage.addProductToCart();
});

Then("product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

Given("product is added to the cart", () => {
 ProductSearchPage.verifyProductAddedToCart();
});

When("I check the cart for the added product", () => {
 ProductSearchPage.checkCartForProduct();
});

Then("cart displays the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

Given("I have checked the cart for the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

When("I log out from the application", () => {
 ProductSearchPage.logout();
});

Then("user is logged out successfully", () => {
 ProductSearchPage.verifyUserLoggedOut();
});