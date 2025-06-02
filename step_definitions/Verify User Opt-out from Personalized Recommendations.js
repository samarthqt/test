import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import DashboardPage from "../pages/dashboardPage";
import AccountSettingsPage from "../pages/accountSettingsPage";

Given("a user account with personalized recommendations enabled", () => {
 // Assuming user account setup is handled
});

When("the user logs in to the account", () => {
 DashboardPage.login();
});

Then("the user is directed to the dashboard", () => {
 DashboardPage.verifyDashboard();
});

Given("the user is on the dashboard", () => {
 DashboardPage.verifyDashboard();
});

When("the user navigates to the account settings page", () => {
 DashboardPage.goToAccountSettings();
});

Then("the user is able to access the account settings page", () => {
 AccountSettingsPage.verifyAccountSettingsPage();
});

Given("the user is on the account settings page", () => {
 AccountSettingsPage.verifyAccountSettingsPage();
});

When("the user locates the personalized recommendation settings", () => {
 AccountSettingsPage.locatePersonalizedRecommendationSettings();
});

Then("settings for personalized recommendations are visible", () => {
 AccountSettingsPage.verifyPersonalizedRecommendationSettingsVisible();
});

And("the user selects the option to opt out of personalized recommendations", () => {
 AccountSettingsPage.selectOptOutOption();
});

Then("the option to opt out is selectable", () => {
 AccountSettingsPage.verifyOptOutOptionSelectable();
});

Given("the user has selected the opt-out option", () => {
 AccountSettingsPage.selectOptOutOption();
});

When("the user saves the changes to the settings", () => {
 AccountSettingsPage.saveChanges();
});

Then("changes are saved successfully with a confirmation message", () => {
 AccountSettingsPage.verifyChangesSaved();
});

Given("the user has saved the opt-out changes", () => {
 AccountSettingsPage.verifyChangesSaved();
});

When("the user logs out and logs back in", () => {
 DashboardPage.logout();
 DashboardPage.login();
});

Then("changes persist after logging back in", () => {
 AccountSettingsPage.verifyChangesPersist();
});

Given("the user has opted out of personalized recommendations", () => {
 AccountSettingsPage.verifyOptOutOptionSelected();
});

When("the user attempts to access personalized recommendations", () => {
 DashboardPage.accessPersonalizedRecommendations();
});

Then("personalized recommendations are no longer displayed", () => {
 DashboardPage.verifyNoPersonalizedRecommendations();
});

When("the user checks for notifications regarding the opt-out", () => {
 DashboardPage.checkNotifications();
});

Then("notification confirms successful opt-out", () => {
 DashboardPage.verifyOptOutNotification();
});

Given("the user wants to understand opt-out procedures", () => {
 // Context setup if needed
});

When("the user reviews the privacy policy for opt-out information", () => {
 DashboardPage.reviewPrivacyPolicy();
});

Then("privacy policy outlines opt-out procedures clearly", () => {
 DashboardPage.verifyPrivacyPolicyDetails();
});

When("the user wants to re-enable personalized recommendations", () => {
 AccountSettingsPage.reEnableRecommendations();
});

Then("the user can re-enable recommendations at any time", () => {
 AccountSettingsPage.verifyReEnableOption();
});

When("the user tests the opt-out feature on different devices", () => {
 // Assume device testing setup
});

Then("the opt-out feature works consistently across devices", () => {
 AccountSettingsPage.verifyOptOutConsistency();
});

When("the user checks the system logs for opt-out actions", () => {
 DashboardPage.checkSystemLogs();
});

Then("logs accurately reflect the opt-out action", () => {
 DashboardPage.verifyLogAccuracy();
});

When("the user checks for residual personalized data post opt-out", () => {
 DashboardPage.checkResidualData();
});

Then("no personalized data is used or displayed", () => {
 DashboardPage.verifyNoResidualData();
});

When("the user experiences the system post opt-out", () => {
 // Assume user experience setup
});

Then("user experience remains unaffected aside from recommendation changes", () => {
 DashboardPage.verifyUserExperience();
});

Given("multiple users have opted out of personalized recommendations", () => {
 // Assume multiple users setup
});

When("the system performance is assessed", () => {
 DashboardPage.assessSystemPerformance();
});

Then("system performance remains stable regardless of opt-out volume", () => {
 DashboardPage.verifySystemPerformance();
});