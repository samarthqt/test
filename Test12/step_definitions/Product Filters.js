import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("the user is on the product listing page", () => {
 ProductListingPage.visit();
});

When("the user applies filters for categories, price range, rating, and other attributes", () => {
 ProductListingPage.applyFilters();
});

Then("the product list should update dynamically to reflect the applied filters", () => {
 ProductListingPage.verifyProductListUpdated();
});

When("the user applies multiple filters at the same time", () => {
 ProductListingPage.applyMultipleFilters();
});

Then("the product list should update dynamically to reflect all applied filters", () => {
 ProductListingPage.verifyProductListUpdated();
});

When("the user attempts to exploit filter functionality", () => {
 ProductListingPage.attemptExploitFilters();
});

Then("security measures should prevent exploitation of filters", () => {
 ProductListingPage.verifySecurityMeasures();
});

When("the user enters invalid filter criteria", () => {
 ProductListingPage.enterInvalidFilters();
});

Then("an error message should be displayed to the user", () => {
 ProductListingPage.verifyErrorMessageDisplayed();
});

When("the user accesses the page from both desktop and mobile platforms", () => {
 ProductListingPage.verifyFilterAvailabilityOnPlatforms();
});

Then("filter options should be available on both platforms", () => {
 ProductListingPage.verifyFilterOptionsAvailable();
});

When("the user applies filters", () => {
 ProductListingPage.applyFilters();
});

Then("the system should log filter usage for analytics purposes", () => {
 ProductListingPage.verifyFilterUsageLogged();
});

Then("the integration with the product database should ensure accurate filtering of products", () => {
 ProductListingPage.verifyDatabaseIntegration();
});

Then("the product list should update within 3 seconds", () => {
 ProductListingPage.verifyPerformance();
});

When("the user applies filters that result in no matching products", () => {
 ProductListingPage.applyNoMatchFilters();
});

Then("a notification should alert the user that no products match the filters", () => {
 ProductListingPage.verifyNoMatchNotification();
});