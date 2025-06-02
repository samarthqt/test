import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderHistoryPage from "../pages/orderHistoryPage";

Given("a user account exists with User ID: {string} and Account Status: {string}", (userId, accountStatus) => {
 cy.wrap({ userId, accountStatus }).as("userAccount");
});

When("the user logs in using valid credentials", () => {
 OrderHistoryPage.login();
});

Then("the user is successfully logged into the account", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

Given("the user is logged into the account", () => {
 OrderHistoryPage.verifyLoginSuccess();
});

When("the user navigates to the 'Order History' section in the user dashboard", () => {
 OrderHistoryPage.navigateToOrderHistory();
});

Then("the user is directed to the 'Order History' page", () => {
 OrderHistoryPage.verifyOnOrderHistoryPage();
});

Given("the user is on the 'Order History' page with {int} past orders", (orderCount) => {
 OrderHistoryPage.verifyOrderCount(orderCount);
});

When("the user scrolls through the list of past orders", () => {
 OrderHistoryPage.scrollThroughOrders();
});

Then("all past orders are displayed without any truncation or loading issues", () => {
 OrderHistoryPage.verifyOrderDisplay();
});

When("the user uses the search or filter options to locate a specific order", () => {
 OrderHistoryPage.searchOrder();
});

Then("the search or filter functionality works correctly, and the specific order is located", () => {
 OrderHistoryPage.verifyOrderSearch();
});

When("the user checks the order details for a randomly selected order", () => {
 OrderHistoryPage.checkOrderDetails();
});

Then("the order details are accurate and complete", () => {
 OrderHistoryPage.verifyOrderDetails();
});

When("the page loads", () => {
 OrderHistoryPage.verifyPageLoadPerformance();
});

Then("the page loads efficiently, and performance is not degraded", () => {
 OrderHistoryPage.verifyPerformance();
});

When("the user attempts to export the order history to a file format {string}", (format) => {
 OrderHistoryPage.exportOrderHistory(format);
});

Then("the order history is successfully exported in the chosen format", () => {
 OrderHistoryPage.verifyExport();
});

Given("the user is on the 'Order History' page with pagination", () => {
 OrderHistoryPage.verifyPaginationExists();
});

When("the user navigates between pages", () => {
 OrderHistoryPage.navigatePages();
});

Then("the pagination works correctly, and navigation between pages is smooth", () => {
 OrderHistoryPage.verifyPagination();
});

Given("the user is navigating the 'Order History' page", () => {
 OrderHistoryPage.verifyOnOrderHistoryPage();
});

When("the user navigates through the page", () => {
 OrderHistoryPage.navigateThroughPage();
});

Then("no error messages or warnings are displayed", () => {
 OrderHistoryPage.verifyNoErrors();
});

When("the user inspects the page layout and design", () => {
 OrderHistoryPage.inspectLayout();
});

Then("the page layout is consistent, and design is clear with appropriate spacing and alignment", () => {
 OrderHistoryPage.verifyLayoutDesign();
});

When("the user attempts to navigate back to the main dashboard", () => {
 OrderHistoryPage.navigateBackToDashboard();
});

Then("the user can easily navigate back to the main dashboard", () => {
 OrderHistoryPage.verifyNavigationBack();
});

Given("the user is not authenticated", () => {
 cy.clearCookies();
});

When("the user attempts to access the 'Order History' page directly via URL manipulation", () => {
 OrderHistoryPage.accessDirectlyViaURL();
});

Then("the user is redirected to the login page or main dashboard", () => {
 OrderHistoryPage.verifyRedirection();
});

When("the user checks for help or support links", () => {
 OrderHistoryPage.checkHelpLinks();
});

Then("help or support links are present and functional", () => {
 OrderHistoryPage.verifyHelpLinks();
});

When("the user reviews the page for promotional content or offers", () => {
 OrderHistoryPage.reviewPromotions();
});

Then("relevant promotional content or offers are displayed if applicable", () => {
 OrderHistoryPage.verifyPromotions();
});

Given("the user is accessing the 'Order History' page on various devices", () => {
 OrderHistoryPage.verifyResponsiveDesign();
});

When("the user views the page on different devices", () => {
 OrderHistoryPage.viewOnDifferentDevices();
});

Then("the page is responsive and displays correctly on various devices", () => {
 OrderHistoryPage.verifyResponsiveDisplay();
});