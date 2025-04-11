const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const AnalyticsDashboardPage = require('../../pageObjects/AnalyticsDashboardPage');

Given('an admin user is logged into the system', () => {
  cy.loginAsAdmin();
});

When('the admin user navigates to the analytics dashboard', () => {
  AnalyticsDashboardPage.navigateToDashboard();
});

Then('the analytics dashboard should be displayed', () => {
  AnalyticsDashboardPage.verifyDashboardIsDisplayed();
});

Given('the admin user is on the analytics dashboard', () => {
  AnalyticsDashboardPage.verifyDashboardIsDisplayed();
});

When('the admin user views the sales data', () => {
  AnalyticsDashboardPage.viewSalesData();
});

Then('the sales data should be presented in a clear and understandable format', () => {
  AnalyticsDashboardPage.verifySalesDataFormat();
});

And('the sales data should be up-to-date', () => {
  AnalyticsDashboardPage.verifySalesDataIsUpToDate();
});

When('the admin user filters the sales data by a specific date range', () => {
  AnalyticsDashboardPage.filterSalesDataByDateRange();
});

Then('the sales data should be updated to reflect the selected date range', () => {
  AnalyticsDashboardPage.verifyFilteredSalesData();
});

When('the admin user chooses to export the sales data', () => {
  AnalyticsDashboardPage.exportSalesData();
});

Then('the sales data should be exported in the selected format', () => {
  AnalyticsDashboardPage.verifyDataExport();
});

And('a confirmation message should be displayed to the user', () => {
  AnalyticsDashboardPage.verifyExportConfirmationMessage();
});

When('the admin user customizes the dashboard widgets', () => {
  AnalyticsDashboardPage.customizeDashboardWidgets();
});

Then('the changes should be saved', () => {
  AnalyticsDashboardPage.verifyChangesSaved();
});

And('the dashboard should reflect the customizations made by the admin user', () => {
  AnalyticsDashboardPage.verifyDashboardCustomizations();
});

Given('a non-admin user is logged into the system', () => {
  cy.loginAsNonAdmin();
});

When('the non-admin user attempts to access the analytics dashboard', () => {
  AnalyticsDashboardPage.attemptAccessDashboard();
});

Then('access should be denied', () => {
  AnalyticsDashboardPage.verifyAccessDenied();
});

And('an appropriate error message should be displayed', () => {
  AnalyticsDashboardPage.verifyErrorMessage();
});