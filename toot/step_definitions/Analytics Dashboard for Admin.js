import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AnalyticsDashboardPage from "../pages/analyticsDashboardPage";

Given("the admin is logged into the system", () => {
 cy.login();
});

When("the admin navigates to the Analytics Dashboard", () => {
 AnalyticsDashboardPage.visit();
});

Then("the admin should see the sales data displayed", () => {
 AnalyticsDashboardPage.verifySalesDataDisplayed();
});

Then("the admin should see the performance metrics displayed", () => {
 AnalyticsDashboardPage.verifyPerformanceMetricsDisplayed();
});

Given("the admin is on the Analytics Dashboard", () => {
 AnalyticsDashboardPage.visit();
});

When("the admin selects the sales data tab", () => {
 AnalyticsDashboardPage.selectSalesDataTab();
});

Then("the admin should see a graphical representation of sales data", () => {
 AnalyticsDashboardPage.verifySalesDataGraphicalRepresentation();
});

Then("the admin should see sales data filtered by time period", () => {
 AnalyticsDashboardPage.verifySalesDataFilteredByTimePeriod();
});

When("the admin selects the performance metrics tab", () => {
 AnalyticsDashboardPage.selectPerformanceMetricsTab();
});

Then("the admin should see a graphical representation of performance metrics", () => {
 AnalyticsDashboardPage.verifyPerformanceMetricsGraphicalRepresentation();
});

Then("the admin should see performance metrics filtered by time period", () => {
 AnalyticsDashboardPage.verifyPerformanceMetricsFilteredByTimePeriod();
});

When("the admin applies a time period filter", () => {
 AnalyticsDashboardPage.applyTimePeriodFilter();
});

Then("the sales data should be updated to reflect the selected time period", () => {
 AnalyticsDashboardPage.verifySalesDataUpdatedByTimePeriod();
});

Then("the performance metrics should be updated to reflect the selected time period", () => {
 AnalyticsDashboardPage.verifyPerformanceMetricsUpdatedByTimePeriod();
});

When("the admin selects the option to export data", () => {
 AnalyticsDashboardPage.exportData();
});

Then("the admin should be able to download the sales data in a CSV format", () => {
 AnalyticsDashboardPage.verifySalesDataDownloadableCSV();
});

Then("the admin should be able to download the performance metrics in a CSV format", () => {
 AnalyticsDashboardPage.verifyPerformanceMetricsDownloadableCSV();
});

Given("there is no sales data available for the selected time period", () => {
 AnalyticsDashboardPage.setNoSalesDataAvailable();
});

When("the admin views the sales data", () => {
 AnalyticsDashboardPage.viewSalesData();
});

Then("the admin should see a message indicating no data is available", () => {
 AnalyticsDashboardPage.verifyNoSalesDataMessage();
});

Given("there are no performance metrics available for the selected time period", () => {
 AnalyticsDashboardPage.setNoPerformanceMetricsAvailable();
});

When("the admin views the performance metrics", () => {
 AnalyticsDashboardPage.viewPerformanceMetrics();
});

Then("the admin should see a message indicating no data is available", () => {
 AnalyticsDashboardPage.verifyNoPerformanceMetricsMessage();
});