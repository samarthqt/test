import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import DashboardPage from '../pageObjects/DashboardPage';

const dashboardPage = new DashboardPage();

Given('the user is on the dashboard page', () => {
  dashboardPage.visit();
});

When('the user selects a widget to add', () => {
  dashboardPage.selectWidgetToAdd();
});

Then('the widget should be added to the dashboard', () => {
  dashboardPage.verifyWidgetAdded();
});

Given('the user has a widget on the dashboard', () => {
  dashboardPage.ensureWidgetPresent();
});

When('the user chooses to remove the widget', () => {
  dashboardPage.removeWidget();
});

Then('the widget should be removed from the dashboard', () => {
  dashboardPage.verifyWidgetRemoved();
});

Given('the user has multiple widgets on the dashboard', () => {
  dashboardPage.ensureMultipleWidgetsPresent();
});

When('the user drags a widget to a new position', () => {
  dashboardPage.dragWidgetToNewPosition();
});

Then('the widget should be rearranged to the new position', () => {
  dashboardPage.verifyWidgetRearranged();
});

Given('the user frequently uses certain widgets', () => {
  dashboardPage.ensureFrequentWidgetsUsage();
});

When('the user accesses the dashboard', () => {
  dashboardPage.accessDashboard();
});

Then('the dashboard should suggest layout changes to optimize user experience', () => {
  dashboardPage.verifyLayoutSuggestions();
});

Given('the user has made changes to the dashboard layout', () => {
  dashboardPage.makeLayoutChanges();
});

When('the user logs out and logs back in', () => {
  dashboardPage.logoutAndLogin();
});

Then('the changes should persist across sessions', () => {
  dashboardPage.verifyChangesPersist();
});

Given('the user is customizing the dashboard', () => {
  dashboardPage.customizeDashboard();
});

When('the user selects widgets to add', () => {
  dashboardPage.selectWidgetsToAdd();
});

Then('the dashboard must include quick transfers and recent transactions widgets', () => {
  dashboardPage.verifyQuickTransfersAndRecentTransactions();
});

Given('the user is viewing the dashboard', () => {
  dashboardPage.viewDashboard();
});

When('there are updates to the account information', () => {
  dashboardPage.updateAccountInformation();
});

Then('the dashboard should update in real-time with the latest account information', () => {
  dashboardPage.verifyRealTimeUpdates();
});