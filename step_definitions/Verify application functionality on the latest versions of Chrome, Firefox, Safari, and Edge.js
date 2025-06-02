import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import WebPlatformPage from "../pages/webPlatformPage";

Given("the latest version of Chrome 90 is installed", () => {
  WebPlatformPage.verifyChromeVersion(90);
});

When("the user opens the web platform on Chrome 90", () => {
  WebPlatformPage.openWebPlatform();
});

Then("the web platform loads correctly without any display issues", () => {
  WebPlatformPage.verifyNoDisplayIssues();
});

Given("the user has valid credentials", () => {
  WebPlatformPage.storeValidCredentials();
});

When("the user logs in on Chrome 90", () => {
  WebPlatformPage.login();
});

Then("the user is successfully logged in", () => {
  WebPlatformPage.verifySuccessfulLogin();
});

Then("the Order ID is ORD54321", () => {
  WebPlatformPage.verifyOrderID('ORD54321');
});

Given("the user is logged in on Chrome 90", () => {
  WebPlatformPage.ensureLoggedIn();
});

When("the user navigates to the 'Order History' section", () => {
  WebPlatformPage.navigateToOrderHistory();
});

Then("the order history page is displayed correctly", () => {
  WebPlatformPage.verifyOrderHistoryPage();
});

Then("the User Account is user_browser@example.com", () => {
  WebPlatformPage.verifyUserAccount('user_browser@example.com');
});

Given("the latest version of {string} is installed", (browser) => {
  WebPlatformPage.verifyBrowserVersion(browser);
});

When("the user repeats steps 1-3 on {string}", (browser) => {
  WebPlatformPage.repeatStepsOnBrowser(browser);
});

Then("the web platform functions correctly on {string}", (browser) => {
  WebPlatformPage.verifyPlatformFunctionality(browser);
});

Given("the user is logged in on any browser", () => {
  WebPlatformPage.ensureLoggedIn();
});

When("the user checks for order status updates", () => {
  WebPlatformPage.checkOrderStatusUpdates();
});

Then("the order status updates are consistent across all browsers", () => {
  WebPlatformPage.verifyOrderStatusConsistency();
});

When("the user checks for display issues or errors", () => {
  WebPlatformPage.checkForDisplayIssues();
});

Then("no display issues or errors are encountered on any browser", () => {
  WebPlatformPage.verifyNoDisplayErrors();
});

When("the user tests responsiveness and performance", () => {
  WebPlatformPage.testResponsivenessPerformance();
});

Then("the web platform is responsive and performs well on each browser", () => {
  WebPlatformPage.verifyResponsivenessPerformance();
});

When("the user checks for notifications of order status updates", () => {
  WebPlatformPage.checkOrderStatusNotifications();
});

Then("users receive notifications for order status updates on each browser", () => {
  WebPlatformPage.verifyOrderStatusNotifications();
});

When("the user checks system logs for errors", () => {
  WebPlatformPage.checkSystemLogs();
});

Then("no browser-specific errors are logged in the system", () => {
  WebPlatformPage.verifyNoSystemErrors();
});

When("the user assesses the user experience", () => {
  WebPlatformPage.assessUserExperience();
});

Then("user experience is consistent and satisfactory on each browser", () => {
  WebPlatformPage.verifyUserExperienceConsistency();
});

When("the user checks compatibility with browser extensions", () => {
  WebPlatformPage.checkBrowserExtensionsCompatibility();
});

Then("the web platform remains compatible with common browser extensions", () => {
  WebPlatformPage.verifyExtensionCompatibility();
});

When("the user tests accessibility features", () => {
  WebPlatformPage.testAccessibilityFeatures();
});

Then("accessibility features function correctly on each browser", () => {
  WebPlatformPage.verifyAccessibilityFeatures();
});

When("the user logs out from the web platform", () => {
  WebPlatformPage.logout();
});

Then("the user is successfully logged out from the web platform on each browser", () => {
  WebPlatformPage.verifySuccessfulLogout();
});