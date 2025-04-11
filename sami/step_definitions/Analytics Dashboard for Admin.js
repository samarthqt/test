import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import AnalyticsDashboardPage from '../page_objects/AnalyticsDashboardPage';

const dashboardPage = new AnalyticsDashboardPage();

Given('the admin is logged into the system', () => {
  // Implement login functionality
});

Given('the admin is on the Analytics Dashboard', () => {
  dashboardPage.navigateToDashboard();
});

When('the admin navigates to the Analytics Dashboard', () => {
  dashboardPage.navigateToDashboard();
});

Then('the admin should see the sales data displayed', () => {
  dashboardPage.verifySalesDataDisplayed();
});

Then('the admin should see the performance metrics displayed', () => {
  dashboardPage.verifyPerformanceMetricsDisplayed();
});

When('the admin selects the sales data tab', () => {
  dashboardPage.selectSalesDataTab();
});

Then('the admin should see a graphical representation of sales data', () => {
  dashboardPage.verifyGraphicalSalesData();
});

Then('the admin should see sales data filtered by time period', () => {
  dashboardPage.verifySalesDataFilteredByTime();
});

When('the admin selects the performance metrics tab', () => {
  dashboardPage.selectPerformanceMetricsTab();
});

Then('the admin should see a graphical representation of performance metrics', () => {
  dashboardPage.verifyGraphicalPerformanceMetrics();
});

Then('the admin should see performance metrics filtered by time period', () => {
  dashboardPage.verifyPerformanceMetricsFilteredByTime();
});

When('the admin applies a time period filter', () => {
  dashboardPage.applyTimePeriodFilter();
});

Then('the sales data should be updated to reflect the selected time period', () => {
  dashboardPage.verifySalesDataUpdatedForTimePeriod();
});

Then('the performance metrics should be updated to reflect the selected time period', () => {
  dashboardPage.verifyPerformanceMetricsUpdatedForTimePeriod();
});

When('the admin selects the option to export data', () => {
  dashboardPage.selectExportDataOption();
});

Then('the admin should be able to download the sales data in a CSV format', () => {
  dashboardPage.verifySalesDataDownloadableAsCSV();
});

Then('the admin should be able to download the performance metrics in a CSV format', () => {
  dashboardPage.verifyPerformanceMetricsDownloadableAsCSV();
});

Given('there is no sales data available for the selected time period', () => {
  dashboardPage.setNoSalesDataAvailable();
});

When('the admin views the sales data', () => {
  dashboardPage.viewSalesData();
});

Then('the admin should see a message indicating no data is available', () => {
  dashboardPage.verifyNoDataMessage();
});

Given('there are no performance metrics available for the selected time period', () => {
  dashboardPage.setNoPerformanceMetricsAvailable();
});

When('the admin views the performance metrics', () => {
  dashboardPage.viewPerformanceMetrics();
});