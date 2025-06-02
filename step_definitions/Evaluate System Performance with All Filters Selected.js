import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductListingPage from "../pages/productListingPage";

Given("the application is open", () => {
 cy.visit("/");
});

When("I navigate to the product listing page", () => {
 ProductListingPage.navigateToProductListing();
});

Then("the product listing page should load successfully with all available filter options: color, size, brand, and price range", () => {
 ProductListingPage.verifyAllFilterOptions();
});

Given("I am on the product listing page", () => {
 ProductListingPage.ensureOnProductListingPage();
});

When("I select all available filter options simultaneously", () => {
 ProductListingPage.applyAllFilters();
});

Then("all selected filters should be applied without error", () => {
 ProductListingPage.verifyFiltersApplied();
});

Given("all filters are applied", () => {
 ProductListingPage.applyAllFilters();
});

When("I monitor system performance metrics", () => {
 ProductListingPage.monitorPerformanceMetrics();
});

Then("the system performance should remain within acceptable limits", () => {
 ProductListingPage.verifyPerformanceLimits();
});

When("I check the UI", () => {
 ProductListingPage.checkUI();
});

Then("there should be no UI glitches or slowdowns", () => {
 ProductListingPage.verifyNoUIGlitches();
});

When("I view the filtered results", () => {
 ProductListingPage.viewFilteredResults();
});

Then("the results should accurately reflect all selected filters", () => {
 ProductListingPage.verifyFilteredResultsAccuracy();
});

When("I test on a mobile device", () => {
 ProductListingPage.testOnMobileDevice();
});

Then("the system performance should remain optimal", () => {
 ProductListingPage.verifyOptimalPerformance();
});

When("I check system resource utilization", () => {
 ProductListingPage.checkResourceUtilization();
});

Then("resource utilization should be efficient and within limits", () => {
 ProductListingPage.verifyResourceUtilization();
});

When("I monitor the system stability", () => {
 ProductListingPage.monitorSystemStability();
});

Then("the system should remain stable", () => {
 ProductListingPage.verifySystemStability();
});

When("I rapidly change filters", () => {
 ProductListingPage.rapidlyChangeFilters();
});

Then("the system should handle rapid filter changes without error", () => {
 ProductListingPage.verifyRapidFilterHandling();
});

When("I reset the filters", () => {
 ProductListingPage.resetFilters();
});

Then("the filters should reset correctly without affecting system performance", () => {
 ProductListingPage.verifyFilterReset();
});

When("I check filtered results across different sessions", () => {
 ProductListingPage.checkFilteredResultsAcrossSessions();
});

Then("filtered results should remain consistent", () => {
 ProductListingPage.verifyResultsConsistency();
});

When("filters are applied during peak traffic", () => {
 ProductListingPage.applyFiltersDuringPeakTraffic();
});

Then("system performance should remain optimal", () => {
 ProductListingPage.verifyPerformanceDuringPeak();
});

When("I check the system logs", () => {
 ProductListingPage.checkSystemLogs();
});

Then("filter application events should be logged accurately", () => {
 ProductListingPage.verifyLoggingAccuracy();
});

When("I use other functionalities", () => {
 ProductListingPage.useOtherFunctionalities();
});

Then("applying all filters should not affect other functionalities", () => {
 ProductListingPage.verifyNoInterference();
});

When("I test the system's recovery mechanism", () => {
 ProductListingPage.testRecoveryMechanism();
});

Then("the system should recover smoothly after filter application", () => {
 ProductListingPage.verifySmoothRecovery();
});