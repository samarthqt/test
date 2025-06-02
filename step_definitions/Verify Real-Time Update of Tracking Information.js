import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("a user account with recent purchase", () => {
 // Assume user account setup is done
});

Given("valid credentials", () => {
 // Assume valid credentials setup is done
});

When("the user logs in to the account", () => {
 TrackingPage.login();
});

Then("the user is successfully logged in", () => {
 cy.url().should("include", "/dashboard");
});

Given("User ID: {int}", (userId) => {
 TrackingPage.setUserId(userId);
});

When("the user navigates to the 'Track Order' section", () => {
 TrackingPage.navigateToTrackOrder();
});

Then("the Track Order page is displayed", () => {
 cy.url().should("include", "/track-order");
});

Given("Tracking Number: {string}", (trackingNumber) => {
 TrackingPage.setTrackingNumber(trackingNumber);
});

Given("Order Date: {string}", (orderDate) => {
 TrackingPage.setOrderDate(orderDate);
});

When("the user enters the tracking number in the tracking field", () => {
 TrackingPage.enterTrackingNumber();
});

Then("the tracking number is accepted", () => {
 TrackingPage.verifyTrackingNumberAccepted();
});

When("the user submits the tracking request", () => {
 TrackingPage.submitTrackingRequest();
});

Then("tracking information is retrieved", () => {
 TrackingPage.verifyTrackingInformationRetrieved();
});

When("the user checks the current status of the order", () => {
 TrackingPage.checkCurrentStatus();
});

Then("the current order status is displayed correctly", () => {
 TrackingPage.verifyCurrentStatusDisplayed();
});

When("the user checks the estimated delivery time provided", () => {
 TrackingPage.checkEstimatedDeliveryTime();
});

Then("the estimated delivery time is shown", () => {
 TrackingPage.verifyEstimatedDeliveryTimeShown();
});

When("the user verifies the carrier information associated with the order", () => {
 TrackingPage.verifyCarrierInformation();
});

Then("the carrier information is displayed correctly", () => {
 TrackingPage.verifyCarrierInformationDisplayed();
});

When("the user ensures the tracking information is updated in real-time", () => {
 TrackingPage.ensureRealTimeUpdate();
});

Then("tracking information updates reflect real-time changes", () => {
 TrackingPage.verifyRealTimeUpdates();
});

When("the user checks for any discrepancies in the tracking details provided", () => {
 TrackingPage.checkForDiscrepancies();
});

Then("tracking details are accurate and consistent", () => {
 TrackingPage.verifyTrackingDetailsAccuracy();
});

When("the user validates the accuracy of the tracking details displayed", () => {
 TrackingPage.validateTrackingDetails();
});

Then("tracking details are accurate and consistent", () => {
 TrackingPage.verifyTrackingDetailsAccuracy();
});

When("the user verifies the security of tracking information access", () => {
 TrackingPage.verifySecurityOfAccess();
});

Then("tracking information is secure and requires authentication", () => {
 TrackingPage.verifySecurityAndAuthentication();
});

When("the user ensures the tracking interface is user-friendly and intuitive", () => {
 TrackingPage.ensureUserFriendlyInterface();
});

Then("the tracking interface is easy to navigate and understand", () => {
 TrackingPage.verifyUserFriendlyInterface();
});

When("the user verifies the responsiveness of the tracking page across devices", () => {
 TrackingPage.verifyPageResponsiveness();
});

Then("the tracking page is responsive and loads efficiently on all devices", () => {
 TrackingPage.verifyPageLoadsEfficiently();
});

When("the user attempts to track multiple orders simultaneously", () => {
 TrackingPage.trackMultipleOrders();
});

Then("the system handles multiple tracking requests without errors", () => {
 TrackingPage.verifyMultipleRequestsHandling();
});

When("the user checks if tracking history is available for previous orders", () => {
 TrackingPage.checkTrackingHistoryAvailability();
});

Then("tracking history is accessible and displays past tracking information", () => {
 TrackingPage.verifyTrackingHistoryAccessibility();
});