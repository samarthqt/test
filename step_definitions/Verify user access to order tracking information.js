import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("the user has an active account", () => {
 OrderTrackingPage.verifyActiveAccount();
});

Given("the user logs in to the system using valid user credentials", () => {
 OrderTrackingPage.loginWithValidCredentials();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user has placed orders with tracking information available", () => {
 OrderTrackingPage.verifyOrdersWithTracking();
});

Given("the user is on the dashboard", () => {
 OrderTrackingPage.verifyDashboard();
});

When("the user navigates to the 'Order History' section", () => {
 OrderTrackingPage.navigateToOrderHistory();
});

Then("the user is presented with a list of past orders", () => {
 OrderTrackingPage.verifyListOfPastOrders();
});

Given("the user is on the 'Order History' section", () => {
 OrderTrackingPage.verifyOrderHistorySection();
});

When("the user selects an order with ID 54321 to view its details", () => {
 OrderTrackingPage.selectOrderById("54321");
});

Then("the order details are displayed, including tracking information", () => {
 OrderTrackingPage.verifyOrderDetailsWithTracking();
});

Given("the user is viewing the order details", () => {
 OrderTrackingPage.verifyViewingOrderDetails();
});

Then("the tracking number TRACK12345 is visible in the order details", () => {
 OrderTrackingPage.verifyTrackingNumberVisibility("TRACK12345");
});

Given("the tracking number TRACK12345 is visible", () => {
 OrderTrackingPage.verifyTrackingNumberVisibility("TRACK12345");
});

When("the user clicks on the tracking number", () => {
 OrderTrackingPage.clickTrackingNumber();
});

Then("the system redirects to the carrier's website showing detailed tracking information", () => {
 OrderTrackingPage.verifyRedirectToCarrierWebsite();
});

Given("the user is on the carrier's website", () => {
 OrderTrackingPage.verifyCarrierWebsite();
});

Then("the tracking information matches the data provided by the carrier", () => {
 OrderTrackingPage.verifyTrackingInfoAccuracy();
});

Given("the user enters an invalid tracking number", () => {
 OrderTrackingPage.enterInvalidTrackingNumber();
});

Then("the system displays a user-friendly error message for invalid tracking numbers", () => {
 OrderTrackingPage.verifyInvalidTrackingNumberError();
});

Given("the carrier updates tracking information", () => {
 OrderTrackingPage.simulateCarrierTrackingUpdate();
});

Then("the system updates the tracking information in real-time", () => {
 OrderTrackingPage.verifyRealTimeTrackingUpdate();
});

Given("tracking information is temporarily unavailable", () => {
 OrderTrackingPage.simulateTrackingInfoUnavailability();
});

Then("the system informs the user that tracking information is temporarily unavailable", () => {
 OrderTrackingPage.verifyTrackingInfoUnavailabilityMessage();
});

Given("the user accesses the tracking information page on a mobile device", () => {
 OrderTrackingPage.verifyMobileAccess();
});

Then("the tracking information page is fully responsive and displays correctly", () => {
 OrderTrackingPage.verifyResponsiveDesign();
});

Given("the order status changes", () => {
 OrderTrackingPage.simulateOrderStatusChange();
});

Then("tracking information remains visible regardless of order status changes", () => {
 OrderTrackingPage.verifyTrackingInfoVisibilityOnStatusChange();
});

Given("the user's session has expired", () => {
 OrderTrackingPage.simulateExpiredSession();
});

When("the user attempts to access tracking information", () => {
 OrderTrackingPage.attemptAccessWithExpiredSession();
});

Then("the system prompts the user to log in again to access tracking information", () => {
 OrderTrackingPage.verifyLoginPromptForExpiredSession();
});

Given("the user is viewing tracking information", () => {
 OrderTrackingPage.verifyViewingTrackingInfo();
});

Then("a help link is available, directing users to support for tracking issues", () => {
 OrderTrackingPage.verifyHelpLinkAvailability();
});

Given("multiple tracking requests are made simultaneously", () => {
 OrderTrackingPage.simulateMultipleTrackingRequests();
});

Then("the system efficiently handles multiple tracking requests without performance degradation", () => {
 OrderTrackingPage.verifyPerformanceForMultipleRequests();
});

Given("a network failure occurs", () => {
 OrderTrackingPage.simulateNetworkFailure();
});

When("the user attempts to fetch tracking information", () => {
 OrderTrackingPage.attemptFetchDuringNetworkFailure();
});

Then("the system provides an error message and retries fetching tracking information after network restoration", () => {
 OrderTrackingPage.verifyNetworkFailureHandling();
});