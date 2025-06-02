import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderTrackingPage from "../pages/orderTrackingPage";

Given("a user account with a recent purchase", () => {
 // Assume user account setup with a recent purchase
});

When("the user logs in using valid credentials", () => {
 OrderTrackingPage.login();
});

Then("the user is successfully logged in", () => {
 cy.url().should("include", "/dashboard");
});

Given("the user is logged in", () => {
 OrderTrackingPage.ensureLoggedIn();
});

When("the user navigates to the 'Track Order' section", () => {
 OrderTrackingPage.navigateToTrackOrder();
});

Then("the Track Order page is displayed", () => {
 cy.url().should("include", "/track-order");
});

Given("the Track Order page is displayed", () => {
 OrderTrackingPage.verifyTrackOrderPage();
});

When("the user enters the tracking number {string} in the tracking field", (trackingNumber) => {
 OrderTrackingPage.enterTrackingNumber(trackingNumber);
});

Then("the tracking number is accepted", () => {
 OrderTrackingPage.verifyTrackingNumberAccepted();
});

Given("the tracking number is accepted", () => {
 OrderTrackingPage.verifyTrackingNumberAccepted();
});

When("the user submits the tracking request", () => {
 OrderTrackingPage.submitTrackingRequest();
});

Then("the tracking information is retrieved", () => {
 OrderTrackingPage.verifyTrackingInformationRetrieved();
});

Given("the tracking information is retrieved", () => {
 OrderTrackingPage.verifyTrackingInformationRetrieved();
});

When("the user checks the current status of the order", () => {
 OrderTrackingPage.checkOrderStatus();
});

Then("the current order status is displayed correctly", () => {
 OrderTrackingPage.verifyOrderStatusDisplayedCorrectly();
});

When("the user checks the estimated delivery time", () => {
 OrderTrackingPage.checkEstimatedDeliveryTime();
});

Then("the estimated delivery time is shown", () => {
 OrderTrackingPage.verifyEstimatedDeliveryTimeShown();
});

When("the user checks the carrier information", () => {
 OrderTrackingPage.checkCarrierInformation();
});

Then("the carrier information is displayed correctly", () => {
 OrderTrackingPage.verifyCarrierInformationDisplayedCorrectly();
});

Given("the user is on the Track Order page", () => {
 OrderTrackingPage.verifyTrackOrderPage();
});

When("the user enters an incorrect tracking number", () => {
 OrderTrackingPage.enterIncorrectTrackingNumber();
});

Then("the system displays an error message for invalid tracking number", () => {
 OrderTrackingPage.verifyErrorMessageForInvalidTrackingNumber();
});

When("there are changes in the tracking information", () => {
 OrderTrackingPage.simulateTrackingInfoChanges();
});

Then("the tracking information updates reflect real-time changes", () => {
 OrderTrackingPage.verifyRealTimeTrackingUpdates();
});

When("the user checks the tracking details", () => {
 OrderTrackingPage.checkTrackingDetails();
});

Then("the tracking details are accurate and consistent", () => {
 OrderTrackingPage.verifyTrackingDetailsAccuracy();
});

When("the user accesses the tracking information", () => {
 OrderTrackingPage.accessTrackingInformation();
});

Then("the tracking information is secure and requires authentication", () => {
 OrderTrackingPage.verifyTrackingInformationSecurity();
});

When("the user interacts with the tracking interface", () => {
 OrderTrackingPage.interactWithTrackingInterface();
});

Then("the tracking interface is easy to navigate and understand", () => {
 OrderTrackingPage.verifyTrackingInterfaceUserFriendly();
});

When("the user accesses the tracking page on different devices", () => {
 OrderTrackingPage.accessTrackingPageOnDevices();
});

Then("the tracking page is responsive and loads efficiently on all devices", () => {
 OrderTrackingPage.verifyPageResponsiveness();
});

When("the user submits multiple tracking requests simultaneously", () => {
 OrderTrackingPage.submitMultipleTrackingRequests();
});

Then("the system handles multiple tracking requests without errors", () => {
 OrderTrackingPage.verifyMultipleRequestsHandling();
});

When("the user accesses the tracking history", () => {
 OrderTrackingPage.accessTrackingHistory();
});

Then("the tracking history is accessible and displays past tracking information", () => {
 OrderTrackingPage.verifyTrackingHistoryAccess();
});