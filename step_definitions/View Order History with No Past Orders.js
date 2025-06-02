import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("a user account exists with User ID {int} and no past orders", (userId) => {
 // Setup user account with no past orders
});

When("the user logs in using valid credentials", () => {
 OrderHistoryPage.login();
});

Then("the user successfully logs into the account", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

And("the account status is active", () => {
 OrderHistoryPage.verifyAccountStatusActive();
});

When("the user navigates to the 'Order History' section in the user dashboard", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the user is directed to the 'Order History' page", () => {
 OrderHistoryPage.verifyOnOrderHistoryPage();
});

And("no orders are listed", () => {
 OrderHistoryPage.verifyNoOrdersListed();
});

And("a message indicating no past orders is displayed", () => {
 OrderHistoryPage.verifyNoOrdersMessage();
});

Then("the presence of filters or search options is verified", () => {
 OrderHistoryPage.verifyFiltersSearchOptionsPresent();
});

And("the filters or search options are present but disabled or non-functional due to no data", () => {
 OrderHistoryPage.verifyFiltersSearchOptionsDisabled();
});

Then("any links or buttons suggesting placing a new order are checked", () => {
 OrderHistoryPage.verifyNewOrderLinkOrButton();
});

And("a link or button is available to guide the user to place a new order", () => {
 OrderHistoryPage.verifyNewOrderLinkOrButtonAvailable();
});

When("the user attempts to refresh the page", () => {
 OrderHistoryPage.refreshPage();
});

Then("the page refreshes with the same message indicating no past orders", () => {
 OrderHistoryPage.verifyPageRefreshesWithNoOrdersMessage();
});

Then("the page is inspected for any error messages or system notifications", () => {
 OrderHistoryPage.verifyNoErrorMessagesOrNotifications();
});

And("no error messages or system notifications are present", () => {
 OrderHistoryPage.verifyNoErrorMessagesOrNotifications();
});

Then("the page layout and design are checked for consistency and clarity", () => {
 OrderHistoryPage.verifyPageLayoutAndDesign();
});

And("the page layout is consistent and design is clear with appropriate spacing and alignment", () => {
 OrderHistoryPage.verifyPageLayoutAndDesign();
});

When("the user attempts to navigate back to the main dashboard from the 'Order History' page", () => {
 OrderHistoryPage.navigateToMainDashboard();
});

Then("the user can easily navigate back to the main dashboard", () => {
 OrderHistoryPage.verifyNavigationToMainDashboard();
});

When("the user attempts to access the 'Order History' page directly via URL manipulation", () => {
 OrderHistoryPage.accessOrderHistoryViaURL();
});

Then("the user is redirected to the login page or main dashboard if not authenticated", () => {
 OrderHistoryPage.verifyRedirectionOnURLManipulation();
});

Then("the availability of help or support links on the 'Order History' page is checked", () => {
 OrderHistoryPage.verifyHelpOrSupportLinks();
});

And("help or support links are present and functional", () => {
 OrderHistoryPage.verifyHelpOrSupportLinks();
});

Then("the page is reviewed for any promotional content or offers", () => {
 OrderHistoryPage.verifyPromotionalContentOrOffers();
});

And("relevant promotional content or offers are displayed if applicable", () => {
 OrderHistoryPage.verifyPromotionalContentOrOffers();
});

Then("the responsiveness of the 'Order History' page on different devices is verified", () => {
 OrderHistoryPage.verifyResponsivenessOnDevices();
});

And("the page is responsive and displays correctly on various devices", () => {
 OrderHistoryPage.verifyResponsivenessOnDevices();
});

Then("the browser compatibility of the 'Order History' page is checked", () => {
 OrderHistoryPage.verifyBrowserCompatibility();
});

And("the page functions correctly on all supported browsers", () => {
 OrderHistoryPage.verifyBrowserCompatibility();
});

When("the user logs out of the account", () => {
 OrderHistoryPage.logout();
});

Then("the user is successfully logged out and redirected to the login page", () => {
 OrderHistoryPage.verifyLogoutSuccess();
});