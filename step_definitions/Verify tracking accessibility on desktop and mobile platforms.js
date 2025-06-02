import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user has a valid order with tracking information available", () => {
 // Setup code to ensure the user has a valid order
});

When("the user logs into the application using a desktop browser", () => {
 TrackingPage.login('desktop');
});

Then("the user is successfully logged into the application on a desktop browser", () => {
 TrackingPage.verifyLogin('desktop');
});

When("the user navigates to the 'Order History' section from the dashboard", () => {
 TrackingPage.navigateToOrderHistory('desktop');
});

Then("the Order History section is displayed with a list of past orders", () => {
 TrackingPage.verifyOrderHistoryDisplayed();
});

When("the user selects an order with tracking information available", () => {
 TrackingPage.selectOrderWithTracking();
});

Then("the order details page is displayed with tracking information visible", () => {
 TrackingPage.verifyOrderDetailsPage();
});

When("the user accesses the tracking information link from the order details page", () => {
 TrackingPage.accessTrackingInfoLink();
});

Then("the tracking information is displayed correctly on the desktop browser", () => {
 TrackingPage.verifyTrackingInfoDisplayed('desktop');
});

When("the user logs into the application using a mobile device", () => {
 TrackingPage.login('mobile');
});

Then("the user is successfully logged into the application on a mobile device", () => {
 TrackingPage.verifyLogin('mobile');
});

When("the user navigates to the 'Order History' section from the mobile dashboard", () => {
 TrackingPage.navigateToOrderHistory('mobile');
});

When("the user selects the same order with tracking information available", () => {
 TrackingPage.selectOrderWithTracking();
});

Then("the order details page is displayed with tracking information visible on mobile", () => {
 TrackingPage.verifyOrderDetailsPage();
});

When("the user accesses the tracking information link from the order details page on mobile", () => {
 TrackingPage.accessTrackingInfoLink();
});

Then("the tracking information is displayed correctly on the mobile device", () => {
 TrackingPage.verifyTrackingInfoDisplayed('mobile');
});

Given("the tracking information is displayed correctly on both desktop and mobile platforms", () => {
 TrackingPage.verifyTrackingInfoDisplayed('desktop');
 TrackingPage.verifyTrackingInfoDisplayed('mobile');
});

When("the user switches between desktop and mobile platforms", () => {
 TrackingPage.switchPlatforms();
});

Then("the tracking information remains consistent across both platforms", () => {
 TrackingPage.verifyTrackingInfoConsistency();
});

When("the user views the tracking information on different screen sizes", () => {
 TrackingPage.viewOnDifferentScreenSizes();
});

Then("the tracking information layout adjusts correctly to different screen sizes", () => {
 TrackingPage.verifyResponsiveLayout();
});

When("the user accesses the tracking information", () => {
 TrackingPage.accessTrackingInfo();
});

Then("the tracking information loads within acceptable time limits on both platforms", () => {
 TrackingPage.verifyLoadingTime();
});

When("there are updates to the tracking information", () => {
 TrackingPage.simulateTrackingInfoUpdates();
});

Then("the tracking information updates are reflected in real-time on both platforms", () => {
 TrackingPage.verifyRealTimeUpdates();
});

Then("no errors occur when accessing tracking information on either platform", () => {
 TrackingPage.verifyNoErrors();
});

When("the user interacts with the tracking information interface", () => {
 TrackingPage.interactWithInterface();
});

Then("the user interface for tracking information is intuitive and easy to navigate on both platforms", () => {
 TrackingPage.verifyUserFriendlyInterface();
});

Then("tracking information access is secure and requires valid user authentication on both platforms", () => {
 TrackingPage.verifySecurity();
});