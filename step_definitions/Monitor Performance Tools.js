import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import LoginPage from '../pageObjects/LoginPage';
import PerformancePage from '../pageObjects/PerformancePage';

const loginPage = new LoginPage();
const performancePage = new PerformancePage();

Given('I am a Customer Service Representative', () => {
  loginPage.visit();
});

When('I login to the system', () => {
  loginPage.loginAsCustomerServiceRepresentative();
});

Then('I should be successfully logged in to the system', () => {
  loginPage.verifySuccessfulLogin();
});

Given('I am on the system', () => {
  loginPage.verifyOnSystem();
});

When('I navigate to the performance monitoring section', () => {
  performancePage.navigateToPerformanceSection();
});

Then('I should see the performance monitoring section displayed', () => {
  performancePage.verifyPerformanceSectionDisplayed();
});

Given('I am on the performance monitoring section', () => {
  performancePage.verifyOnPerformanceSection();
});

When('I check the performance metrics', () => {
  performancePage.checkPerformanceMetrics();
});

Then('I should see all performance metrics displayed accurately', () => {
  performancePage.verifyPerformanceMetricsDisplayedAccurately();
});

When('I check for alerts or notifications', () => {
  performancePage.checkForAlertsOrNotifications();
});

Then('I should see alerts or notifications displayed if there are any performance issues', () => {
  performancePage.verifyAlertsOrNotificationsDisplayed();
});

When('I select a specific performance metric', () => {
  performancePage.selectSpecificPerformanceMetric();
});

Then('I should see additional details about the selected performance metric displayed', () => {
  performancePage.verifyAdditionalDetailsDisplayed();
});

When('I filter the performance metrics based on different criteria', () => {
  performancePage.filterPerformanceMetrics();
});

Then('I should see the performance metrics filtered according to the selected criteria', () => {
  performancePage.verifyMetricsFiltered();
});

When('I export the performance metrics data to a file', () => {
  performancePage.exportMetricsData();
});

Then('the performance metrics data should be successfully exported to a file', () => {
  performancePage.verifyMetricsDataExported();
});

When('I generate a performance report for a specific time period', () => {
  performancePage.generatePerformanceReport();
});

Then('a performance report should be generated with the relevant metrics for the selected time period', () => {
  performancePage.verifyReportGenerated();
});

When('I try to access the performance monitoring tools', () => {
  performancePage.tryAccessingTools();
});

Then('unauthorized users should not be able to access the performance monitoring tools', () => {
  performancePage.verifyUnauthorizedAccess();
});

When('I test the performance monitoring tools on different browsers and devices', () => {
  performancePage.testOnDifferentBrowsersAndDevices();
});

Then('the performance monitoring tools should function correctly on all supported browsers and devices', () => {
  performancePage.verifyFunctionalityOnAllDevices();
});

When('I simulate different performance scenarios', () => {
  performancePage.simulatePerformanceScenarios();
});

Then('the performance metrics should accurately reflect the simulated scenarios', () => {
  performancePage.verifyMetricsForSimulatedScenarios();
});

When('I test the performance monitoring tools with a large volume of data', () => {
  performancePage.testWithLargeVolumeOfData();
});

Then('the performance monitoring tools should perform efficiently with a large volume of data', () => {
  performancePage.verifyEfficiencyWithLargeData();
});

When('I check the performance metrics', () => {
  performancePage.checkPerformanceMetrics();
});

Then('the performance metrics should be updated in real-time without any delay', () => {
  performancePage.verifyRealTimeUpdates();
});

When('I check for performance trends or patterns', () => {
  performancePage.checkForTrendsOrPatterns();
});

Then('performance trends or patterns should be identified and displayed by the system', () => {
  performancePage.verifyTrendsOrPatternsDisplayed();
});

Given('I am logged in to the system', () => {
  loginPage.verifyLoggedIn();
});

When('I logout from the system', () => {
  loginPage.logout();
});

Then('I should be successfully logged out from the system', () => {
  loginPage.verifySuccessfulLogout();
});