import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import AnalyticsDashboardPage from "../pages/analyticsDashboardPage";

Given("an admin user is logged into the system", () => {
 cy.loginAsAdmin();
});

Given("the admin user is on the analytics dashboard", () => {
 AnalyticsDashboardPage.visit();
});

When("the admin user navigates to the analytics dashboard", () => {
 AnalyticsDashboardPage.navigateToDashboard();
});

Then("the analytics dashboard should be displayed", () => {
 AnalyticsDashboardPage.verifyDashboardDisplayed();
});

When("the admin user views the sales data", () => {
 AnalyticsDashboardPage.viewSalesData();
});

Then("the sales data should be presented in a clear and understandable format", () => {
 AnalyticsDashboardPage.verifySalesDataFormat();
});

Then("the sales data should be up-to-date", () => {
 AnalyticsDashboardPage.verifySalesDataUpToDate();
});

When("the admin user filters the sales data by a specific date range", () => {
 AnalyticsDashboardPage.filterSalesDataByDateRange();
});

Then("the sales data should be updated to reflect the selected date range", () => {
 AnalyticsDashboardPage.verifySalesDataDateRange();
});

When("the admin user chooses to export the sales data", () => {
 AnalyticsDashboardPage.exportSalesData();
});

Then("the sales data should be exported in the selected format", () => {
 AnalyticsDashboardPage.verifySalesDataExported();
});

Then("a confirmation message should be displayed to the user", () => {
 AnalyticsDashboardPage.verifyExportConfirmationMessage();
});

When("the admin user customizes the dashboard widgets", () => {
 AnalyticsDashboardPage.customizeDashboardWidgets();
});

Then("the changes should be saved", () => {
 AnalyticsDashboardPage.verifyWidgetsCustomizationSaved();
});

Then("the dashboard should reflect the customizations made by the admin user", () => {
 AnalyticsDashboardPage.verifyDashboardReflectsCustomizations();
});

Given("a non-admin user is logged into the system", () => {
 cy.loginAsNonAdmin();
});

When("the non-admin user attempts to access the analytics dashboard", () => {
 AnalyticsDashboardPage.attemptAccessByNonAdmin();
});

Then("access should be denied", () => {
 AnalyticsDashboardPage.verifyAccessDenied();
});

Then("an appropriate error message should be displayed", () => {
 AnalyticsDashboardPage.verifyErrorMessageDisplayed();
});