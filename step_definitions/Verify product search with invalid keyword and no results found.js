import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductSearchPage from "../pages/productSearchPage";

Given("the product database is populated", () => {
 // Assume database is already populated
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

When("I enter the invalid keyword {string} in the search bar", (keyword) => {
 ProductSearchPage.enterKeyword(keyword);
});

Then("the keyword is entered successfully", () => {
 ProductSearchPage.verifyKeywordEntered();
});

Given("the invalid keyword {string} is entered in the search bar", (keyword) => {
 ProductSearchPage.enterKeyword(keyword);
 ProductSearchPage.verifyKeywordEntered();
});

When("I click on the {string} button", (button) => {
 ProductSearchPage.clickButton(button);
});

Then("the search process is initiated", () => {
 ProductSearchPage.verifySearchInitiated();
});

Given("the search process is initiated with an invalid keyword", () => {
 ProductSearchPage.verifySearchInitiated();
});

Then("an appropriate message for no results found is displayed", () => {
 ProductSearchPage.verifyNoResultsMessage();
});

Given("the message for no results found is displayed", () => {
 ProductSearchPage.verifyNoResultsMessage();
});

Then("no search results are displayed", () => {
 ProductSearchPage.verifyNoSearchResults();
});

Given("no search results are displayed", () => {
 ProductSearchPage.verifyNoSearchResults();
});

When("I attempt to apply category filter to the invalid search", () => {
 ProductSearchPage.applyCategoryFilter();
});

Then("filter application does not change the no results message", () => {
 ProductSearchPage.verifyNoResultsMessage();
});

When("I attempt to apply price filter to the invalid search", () => {
 ProductSearchPage.applyPriceFilter();
});

Then("filter application does not change the no results message", () => {
 ProductSearchPage.verifyNoResultsMessage();
});

When("I attempt to apply rating filter to the invalid search", () => {
 ProductSearchPage.applyRatingFilter();
});

Then("filter application does not change the no results message", () => {
 ProductSearchPage.verifyNoResultsMessage();
});

When("I check the system logs for any errors during the search", () => {
 ProductSearchPage.checkSystemLogs();
});

Then("no errors are logged for the invalid keyword search", () => {
 ProductSearchPage.verifyNoErrorsLogged();
});

When("I attempt to enter a valid keyword in the search bar", () => {
 ProductSearchPage.enterValidKeyword();
});

Then("search bar allows new keyword entry", () => {
 ProductSearchPage.verifyKeywordEntryAllowed();
});

Given("the search bar allows new keyword entry", () => {
 ProductSearchPage.verifyKeywordEntryAllowed();
});

When("I enter a valid keyword and perform the search again", () => {
 ProductSearchPage.enterValidKeyword();
 ProductSearchPage.clickSearchButton();
});

Then("search results are displayed for the valid keyword", () => {
 ProductSearchPage.verifyValidSearchResults();
});

Given("search results are displayed for the valid keyword", () => {
 ProductSearchPage.verifyValidSearchResults();
});

When("I add a product from the valid search results to the cart", () => {
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

Given("cart displays the added product", () => {
 ProductSearchPage.verifyCartDisplaysProduct();
});

When("I log out from the application", () => {
 ProductSearchPage.logout();
});

Then("user is logged out successfully", () => {
 ProductSearchPage.verifyLogoutSuccess();
});

Given("user is logged out successfully", () => {
 ProductSearchPage.verifyLogoutSuccess();
});

When("I perform invalid searches", () => {
 ProductSearchPage.performInvalidSearches();
});

Then("system performance remains stable", () => {
 ProductSearchPage.verifySystemPerformanceStable();
});