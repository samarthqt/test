import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import HomePage from "../pages/homePage";
import SearchResultsPage from "../pages/searchResultsPage";

Given("the user is logged into the application", () => {
 // Assume user is logged in
});

Given("the user is on the homepage of the retail application", () => {
 HomePage.visit();
});

When("the user navigates to the homepage of the retail application", () => {
 HomePage.visit();
});

Then("the homepage is displayed with navigation options", () => {
 HomePage.verifyNavigationOptions();
});

Then("product categories are defined", () => {
 HomePage.verifyProductCategories();
});

When("the user clicks on the 'Categories' dropdown menu", () => {
 HomePage.clickCategoriesDropdown();
});

Then("the dropdown menu expands showing available product categories", () => {
 HomePage.verifyCategoriesDropdownExpanded();
});

When("the user selects the 'Electronics' category from the dropdown", () => {
 HomePage.selectCategory('Electronics');
});

Then("the product listing page displays products under the 'Electronics' category", () => {
 HomePage.verifyProductListing('Electronics');
});

When("the user enters {string} in the search bar and presses enter", (keyword) => {
 HomePage.enterSearchKeyword(keyword);
 HomePage.submitSearch();
});

Then("search results display products related to {string}", (keyword) => {
 SearchResultsPage.verifySearchResults(keyword);
});

Then("all displayed products are relevant to the search keyword", () => {
 SearchResultsPage.verifyProductRelevance();
});

Given("the user has searched for a keyword resulting in multiple pages of results", () => {
 // Assume search results are paginated
});

Then("pagination controls allow navigation between pages of search results", () => {
 SearchResultsPage.verifyPaginationControls();
});

Given("the user is on the search results page", () => {
 // Assume user is on search results page
});

Then("filtering options are visible", () => {
 SearchResultsPage.verifyFilteringOptionsVisible();
});

Then("the user can apply filtering options to narrow down search results", () => {
 SearchResultsPage.applyFilteringOptions();
});

Then("sorting options are visible", () => {
 SearchResultsPage.verifySortingOptionsVisible();
});

Then("the user can apply sorting options to reorder search results", () => {
 SearchResultsPage.applySortingOptions();
});

Then("product details such as name, price, and rating are correctly displayed for each item", () => {
 SearchResultsPage.verifyProductDetailsDisplay();
});

When("the user clicks on a product", () => {
 SearchResultsPage.clickOnProduct();
});

Then("the user is redirected to the product detail page with full product information", () => {
 SearchResultsPage.verifyProductDetailPage();
});

Given("the user is on any page within the application", () => {
 // Assume user is on any page
});

Then("the search bar is visible", () => {
 HomePage.verifySearchBarVisible();
});

Then("the search bar can be used from any page within the application", () => {
 HomePage.verifySearchBarAccessibility();
});

When("the user uses the home button or logo", () => {
 SearchResultsPage.clickHomeButtonOrLogo();
});

Then("the user can navigate back to the homepage", () => {
 HomePage.verifyReturnToHomepage();
});