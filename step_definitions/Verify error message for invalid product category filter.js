import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductCatalogPage from "../pages/productCatalogPage";

Given("the user is logged into the retail application", () => {
 ProductCatalogPage.login();
});

When("the user navigates to the product catalog section", () => {
 ProductCatalogPage.navigateToCatalog();
});

When("the user locates the filter option for product categories", () => {
 ProductCatalogPage.locateFilterOption();
});

When("the user selects an invalid category to filter products", () => {
 ProductCatalogPage.selectInvalidCategory();
});

Then("the system displays an error message indicating the category is invalid", () => {
 ProductCatalogPage.verifyInvalidCategoryErrorMessage();
});

Then("UI elements remain intact after the filter attempt", () => {
 ProductCatalogPage.verifyUIElementsIntact();
});

When("the user attempts filtering products with an empty category", () => {
 ProductCatalogPage.filterWithEmptyCategory();
});

Then("the system handles the empty category gracefully and displays an appropriate message", () => {
 ProductCatalogPage.verifyEmptyCategoryMessage();
});

When("the user filters products using special characters in the category", () => {
 ProductCatalogPage.filterWithSpecialCharacters();
});

Then("the system handles special characters gracefully and displays an appropriate message", () => {
 ProductCatalogPage.verifySpecialCharactersMessage();
});

When("the user performs rapid successive filter attempts", () => {
 ProductCatalogPage.performRapidFilterAttempts();
});

Then("the system maintains performance and responsiveness", () => {
 ProductCatalogPage.verifyPerformance();
});

When("the user logs out from the application", () => {
 ProductCatalogPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 ProductCatalogPage.verifyLogout();
});

When("the user performs a filter operation", () => {
 ProductCatalogPage.performFilterOperation();
});

Then("the filter functionality works consistently across different user accounts", () => {
 ProductCatalogPage.verifyFilterConsistencyAcrossAccounts();
});

Then("the filter works consistently on all supported browsers", () => {
 ProductCatalogPage.verifyFilterConsistencyAcrossBrowsers();
});

Then("the filter operations can be performed on mobile devices without any issues", () => {
 ProductCatalogPage.verifyFilterOnMobileDevices();
});

When("the user attempts to filter with an invalid data format", () => {
 ProductCatalogPage.filterWithInvalidDataFormat();
});

Then("the system handles invalid data gracefully and displays an error message", () => {
 ProductCatalogPage.verifyInvalidDataFormatMessage();
});

Then("the system logs do not show any critical errors related to filter operations", () => {
 ProductCatalogPage.verifyNoCriticalErrorsInLogs();
});