import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("the user is logged into the retail application", () => {
 ProductCatalogPage.login();
});

Given("the product catalog is displayed with a list of available products", () => {
 ProductCatalogPage.verifyCatalogDisplayed();
});

Given("the product catalog is empty", () => {
 ProductCatalogPage.verifyCatalogEmpty();
});

Given("the product catalog contains a large number of products", () => {
 ProductCatalogPage.verifyLargeCatalog();
});

Given("the product catalog contains products with invalid price data", () => {
 ProductCatalogPage.verifyInvalidPriceData();
});

Given("the user logs into the retail application using a different user account", () => {
 ProductCatalogPage.loginDifferentUser();
});

Given("the user is logged into the retail application on different supported browsers", () => {
 ProductCatalogPage.loginOnDifferentBrowsers();
});

Given("the user is logged into the retail application on a mobile device", () => {
 ProductCatalogPage.loginOnMobileDevice();
});

When("the user selects 'Sort by Price' in ascending order", () => {
 ProductCatalogPage.sortByPriceAscending();
});

When("the user selects 'Sort by Price' in descending order", () => {
 ProductCatalogPage.sortByPriceDescending();
});

When("the user attempts to sort products by price", () => {
 ProductCatalogPage.attemptSortByPrice();
});

When("the user selects 'Sort by Price'", () => {
 ProductCatalogPage.sortByPrice();
});

When("the user logs out from the application", () => {
 ProductCatalogPage.logout();
});

Then("the products are sorted from lowest to highest price", () => {
 ProductCatalogPage.verifySortedAscending();
});

Then("each subsequent product has a higher price than the previous one", () => {
 ProductCatalogPage.verifyAscendingOrder();
});

Then("the products are sorted from highest to lowest price", () => {
 ProductCatalogPage.verifySortedDescending();
});

Then("each subsequent product has a lower price than the previous one", () => {
 ProductCatalogPage.verifyDescendingOrder();
});

Then("the system displays a message indicating no products are available to sort", () => {
 ProductCatalogPage.verifyNoProductsMessage();
});

Then("the sorting operation completes within acceptable time limits", () => {
 ProductCatalogPage.verifySortingPerformance();
});

Then("the UI remains responsive and no errors are displayed", () => {
 ProductCatalogPage.verifyUIResponsiveness();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 ProductCatalogPage.verifyLogoutSuccess();
});

Then("the sorting functionality works consistently across different user accounts", () => {
 ProductCatalogPage.verifySortingConsistency();
});

Then("the system handles invalid data gracefully and displays an error message", () => {
 ProductCatalogPage.verifyInvalidDataHandling();
});

Then("the sorting works consistently on all supported browsers", () => {
 ProductCatalogPage.verifyBrowserConsistency();
});

Then("products can be sorted by price on mobile devices without any issues", () => {
 ProductCatalogPage.verifyMobileSorting();
});