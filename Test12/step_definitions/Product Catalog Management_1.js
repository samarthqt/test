import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("the user is on the product catalog page", () => {
  ProductCatalogPage.visit();
});

When("the user searches for a product by keyword {string}", (keyword) => {
  ProductCatalogPage.searchProductByKeyword(keyword);
});

Then("the search results should display products related to {string}", (keyword) => {
  ProductCatalogPage.verifySearchResults(keyword);
});

Then("the search results should be accurate and relevant", () => {
  ProductCatalogPage.verifyRelevance();
});

When("the user filters products by category {string}", (category) => {
  ProductCatalogPage.filterByCategory(category);
});

Then("only products in the {string} category should be displayed", (category) => {
  ProductCatalogPage.verifyCategoryFilter(category);
});

When("the user filters products by price range {string}", (priceRange) => {
  ProductCatalogPage.filterByPriceRange(priceRange);
});

Then("only products within the price range {string} should be displayed", (priceRange) => {
  ProductCatalogPage.verifyPriceRangeFilter(priceRange);
});

When("the user filters products by rating {string}", (rating) => {
  ProductCatalogPage.filterByRating(rating);
});

Then("only products with a rating of {string} should be displayed", (rating) => {
  ProductCatalogPage.verifyRatingFilter(rating);
});

Given("the user has searched for products", () => {
  ProductCatalogPage.searchForProducts();
});

When("the user sorts the products by price", () => {
  ProductCatalogPage.sortByPrice();
});

Then("the products should be displayed in ascending order of price", () => {
  ProductCatalogPage.verifyPriceSortOrder();
});

When("the user sorts the products by popularity", () => {
  ProductCatalogPage.sortByPopularity();
});

Then("the products should be displayed in order of popularity", () => {
  ProductCatalogPage.verifyPopularitySortOrder();
});

When("the user sorts the products by newest arrivals", () => {
  ProductCatalogPage.sortByNewestArrivals();
});

Then("the products should be displayed with the newest arrivals first", () => {
  ProductCatalogPage.verifyNewestArrivalsSortOrder();
});

When("the user selects a product", () => {
  ProductCatalogPage.selectProduct();
});

Then("the user should see detailed information including name, description, price, image, stock, and category", () => {
  ProductCatalogPage.verifyProductDetails();
});

When("the user enters an invalid search query {string}", (query) => {
  ProductCatalogPage.enterInvalidSearchQuery(query);
});

Then("an error message should be displayed indicating no results found", () => {
  ProductCatalogPage.verifyErrorMessage();
});

Then("the interface should be responsive", () => {
  ProductCatalogPage.verifyResponsiveInterface();
});

Then("the user should be able to navigate easily", () => {
  ProductCatalogPage.verifyEasyNavigation();
});

When("the user performs a search", () => {
  ProductCatalogPage.performSearch();
});

Then("the search functionality should be optimized for performance", () => {
  ProductCatalogPage.verifySearchPerformance();
});

Given("the user performs a search on the product catalog page", () => {
  ProductCatalogPage.performSearch();
});

Then("the system should log the search interaction for analytics purposes", () => {
  ProductCatalogPage.verifySearchLogging();
});

When("a change is made to the product catalog", () => {
  ProductCatalogPage.makeCatalogChange();
});

Then("the system should update the catalog dynamically without requiring a page refresh", () => {
  ProductCatalogPage.verifyDynamicUpdate();
});