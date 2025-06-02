import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/loginPage";
import DashboardPage from "../pages/dashboardPage";

Given("the user is on the login page", () => {
  LoginPage.visit();
});

When("the user logs in with valid credentials", () => {
  LoginPage.enterUsername('validUsername');
  LoginPage.enterPassword('validPassword');
  LoginPage.submit();
});

Then("the user is successfully logged in and directed to the dashboard", () => {
  DashboardPage.verifyDashboard();
});

Given("the user is logged in", () => {
  LoginPage.visit();
  LoginPage.enterUsername('validUsername');
  LoginPage.enterPassword('validPassword');
  LoginPage.submit();
  DashboardPage.verifyDashboard();
});

When("the user navigates to the dashboard section", () => {
  DashboardPage.navigateToSection();
});

Then("the dashboard is displayed with all components visible", () => {
  DashboardPage.verifyAllComponentsVisible();
});

Given("the user is on the dashboard", () => {
  DashboardPage.verifyDashboard();
});

When("the user selects a component to edit", () => {
  DashboardPage.selectComponentToEdit();
});

Then("the component is selected and options to edit are displayed", () => {
  DashboardPage.verifyEditOptionsDisplayed();
});

Given("the user has selected a component to edit", () => {
  DashboardPage.selectComponentToEdit();
});

When("the user makes changes to the component", () => {
  DashboardPage.makeChangesToComponent();
});

Then("the changes are made successfully with no errors", () => {
  DashboardPage.verifyChangesMade();
});

Given("changes have been made to a dashboard component", () => {
  DashboardPage.makeChangesToComponent();
  DashboardPage.verifyChangesMade();
});

When("the user saves the changes", () => {
  DashboardPage.saveChanges();
});

Then("the changes are saved successfully without any errors", () => {
  DashboardPage.verifyChangesSaved();
});

When("the user observes the dashboard", () => {
  DashboardPage.observeDashboard();
});

Then("the dashboard updates in real-time to reflect the changes made", () => {
  DashboardPage.verifyRealTimeUpdates();
});

When("the user refreshes the dashboard page", () => {
  DashboardPage.refreshPage();
});

Then("the dashboard retains the changes after refresh", () => {
  DashboardPage.verifyChangesRetainedAfterRefresh();
});

When("the user logs out and logs back into the application", () => {
  DashboardPage.logout();
  LoginPage.visit();
  LoginPage.enterUsername('validUsername');
  LoginPage.enterPassword('validPassword');
  LoginPage.submit();
});

Then("the dashboard still reflects the changes after re-login", () => {
  DashboardPage.verifyDashboard();
  DashboardPage.verifyChangesRetainedAfterReLogin();
});

When("the user checks the dashboard on a different device/browser", () => {
  DashboardPage.checkOnDifferentDevice();
});

Then("the changes are visible across different devices/browsers in real-time", () => {
  DashboardPage.verifyChangesAcrossDevices();
});

Given("the user is logged in on two different devices", () => {
  DashboardPage.loginOnMultipleDevices();
});

When("the user makes simultaneous changes on both devices", () => {
  DashboardPage.makeSimultaneousChanges();
});

Then("real-time sync is maintained and changes are reflected accurately", () => {
  DashboardPage.verifyRealTimeSync();
});

When("the user checks for error messages or logs", () => {
  DashboardPage.checkForErrors();
});

Then("no error messages or logs indicate issues with real-time updates", () => {
  DashboardPage.verifyNoErrors();
});

Given("the dashboard is receiving multiple real-time updates", () => {
  DashboardPage.receiveMultipleUpdates();
});

When("the user observes the dashboard performance", () => {
  DashboardPage.observePerformance();
});

Then("the dashboard performance remains optimal", () => {
  DashboardPage.verifyPerformance();
});

Given("the user wants to test different types of changes", () => {
  DashboardPage.prepareForDifferentChanges();
});

When("the user makes various changes", () => {
  DashboardPage.makeVariousChanges();
});

Then("all types of changes are reflected in real-time without issues", () => {
  DashboardPage.verifyAllChanges();
});

Given("the user has a slow internet connection", () => {
  DashboardPage.simulateSlowConnection();
});

When("the user makes changes to the dashboard", () => {
  DashboardPage.makeChangesToComponent();
});

Then("real-time updates are consistent even with a slow internet connection", () => {
  DashboardPage.verifyRealTimeWithSlowConnection();
});

When("the user reverts the changes", () => {
  DashboardPage.revertChanges();
});

Then("reverted changes are reflected in real-time accurately", () => {
  DashboardPage.verifyRevertedChanges();
});