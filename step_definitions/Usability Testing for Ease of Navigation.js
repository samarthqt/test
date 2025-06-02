import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import NavigationPage from "../pages/navigationPage";

Given("User A is on the login page", () => {
 NavigationPage.visitLoginPage();
});

When("User A logs in", () => {
 NavigationPage.loginAsUserA();
});

Then("User A should see the home page with navigation options", () => {
 NavigationPage.verifyHomePage();
});

Given("User A is on the home page", () => {
 NavigationPage.verifyHomePage();
});

When("User A navigates to the product catalog", () => {
 NavigationPage.navigateToProductCatalog();
});

Then("User A should access the product catalog without any issues", () => {
 NavigationPage.verifyProductCatalogPage();
});

Given("User A is on the product catalog page", () => {
 NavigationPage.verifyProductCatalogPage();
});

When("User A attempts to access account settings", () => {
 NavigationPage.accessAccountSettings();
});

Then("User A should successfully navigate to account settings", () => {
 NavigationPage.verifyAccountSettingsPage();
});

Given("User A is logged in", () => {
 NavigationPage.verifyUserALoggedIn();
});

When("User A logs out and User B logs in", () => {
 NavigationPage.logoutAndLoginAsUserB();
});

Then("User B should log in successfully", () => {
 NavigationPage.verifyUserBLoggedIn();
});

Given("User B is on the home page", () => {
 NavigationPage.verifyHomePage();
});

When("User B accesses the admin dashboard", () => {
 NavigationPage.accessAdminDashboard();
});

Then("User B should access the admin dashboard seamlessly", () => {
 NavigationPage.verifyAdminDashboardPage();
});

Given("User B is on the admin dashboard", () => {
 NavigationPage.verifyAdminDashboardPage();
});

When("User B navigates to user management", () => {
 NavigationPage.navigateToUserManagement();
});

Then("User B should navigate to user management without difficulty", () => {
 NavigationPage.verifyUserManagementPage();
});

Given("User B is logged in", () => {
 NavigationPage.verifyUserBLoggedIn();
});

When("User B logs out and User C logs in", () => {
 NavigationPage.logoutAndLoginAsUserC();
});

Then("User C should log in successfully", () => {
 NavigationPage.verifyUserCLoggedIn();
});

Given("User C is logged in", () => {
 NavigationPage.verifyUserCLoggedIn();
});

When("User C attempts to navigate to the checkout page", () => {
 NavigationPage.navigateToCheckoutPage();
});

Then("User C should be redirected to the login page", () => {
 NavigationPage.verifyRedirectedToLoginPage();
});

When("User C views navigation options", () => {
 NavigationPage.viewNavigationOptions();
});

Then("User C should see limited navigation options appropriate for guest users", () => {
 NavigationPage.verifyLimitedNavigationOptions();
});

Given("User is on any page", () => {
 NavigationPage.verifyUserOnAnyPage();
});

When("User uses keyboard shortcuts for navigation", () => {
 NavigationPage.useKeyboardShortcuts();
});

Then("All keyboard shortcuts should work as intended", () => {
 NavigationPage.verifyKeyboardShortcuts();
});

Given("User is on the mobile interface", () => {
 NavigationPage.verifyMobileInterface();
});

When("User navigates through the application", () => {
 NavigationPage.navigateThroughMobileInterface();
});

Then("Navigation should be smooth and intuitive", () => {
 NavigationPage.verifySmoothNavigation();
});

When("User tries to access a non-existent page", () => {
 NavigationPage.accessNonExistentPage();
});

Then("User should receive an error message indicating the page does not exist", () => {
 NavigationPage.verifyErrorMessageForNonExistentPage();
});

Given("User is logged in with any role", () => {
 NavigationPage.verifyUserLoggedInWithAnyRole();
});

When("User views navigation options", () => {
 NavigationPage.viewNavigationOptions();
});

Then("Navigation options should be consistent and appropriate for each user role", () => {
 NavigationPage.verifyConsistentNavigationOptions();
});

Given("User is navigating through the application", () => {
 NavigationPage.verifyUserNavigatingThroughApplication();
});

When("User follows navigation paths", () => {
 NavigationPage.followNavigationPaths();
});

Then("All navigation paths should align with the expected flow diagrams", () => {
 NavigationPage.verifyNavigationPaths();
});

Given("Server is under high load conditions", () => {
 NavigationPage.verifyServerUnderHighLoad();
});

When("User navigates through the application", () => {
 NavigationPage.navigateThroughApplication();
});

Then("Navigation should remain responsive and functional", () => {
 NavigationPage.verifyResponsiveNavigation();
});