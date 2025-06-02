import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import TrackingPage from "../pages/trackingPage";

Given("the user logs in with valid credentials", () => {
 TrackingPage.login();
});

Then("the user is redirected to the dashboard", () => {
 cy.url().should("include", "/dashboard");
});

Then("39 orders have been placed with tracking information", () => {
 TrackingPage.verifyOrderCount(39);
});

When("the user navigates to the 'Order History' section", () => {
 TrackingPage.navigateToOrderHistory();
});

Then("the user sees a list of past orders", () => {
 TrackingPage.verifyPastOrdersList();
});

Given("the user selects an order with ID 98765", () => {
 TrackingPage.selectOrderById(98765);
});

Then("the order details are displayed with tracking information", () => {
 TrackingPage.verifyOrderDetails();
});

Given("the user manually enters an invalid tracking number \"INVALID123\" for the order", () => {
 TrackingPage.enterInvalidTrackingNumber("INVALID123");
});

When("the system attempts to fetch tracking information", () => {
 TrackingPage.fetchTrackingInformation();
});

Then("the system displays a user-friendly error message indicating the tracking number is invalid", () => {
 TrackingPage.verifyInvalidTrackingNumberMessage();
});

Given("a network failure occurs during tracking information retrieval", () => {
 TrackingPage.simulateNetworkFailure();
});

Then("the system provides an error message indicating a network issue and suggests retrying", () => {
 TrackingPage.verifyNetworkFailureMessage();
});

Given("the carrier's API is down", () => {
 TrackingPage.simulateCarrierApiDown();
});

Then("the system informs the user that the carrier's service is temporarily unavailable", () => {
 TrackingPage.verifyCarrierApiDownMessage();
});

Given("the carrier's API response is delayed", () => {
 TrackingPage.simulateDelayedCarrierApiResponse();
});

Then("the system displays a message indicating a delay in fetching tracking information", () => {
 TrackingPage.verifyDelayedResponseMessage();
});

Given("a 404 error is received from the carrier's API", () => {
 TrackingPage.simulateCarrierApi404Error();
});

Then("the system provides a message indicating the tracking information could not be found", () => {
 TrackingPage.verify404ErrorMessage();
});

Given("a 500 error is received from the carrier's API", () => {
 TrackingPage.simulateCarrierApi500Error();
});

Then("the system informs the user of a server error and suggests trying again later", () => {
 TrackingPage.verify500ErrorMessage();
});

Given("the tracking information is incomplete", () => {
 TrackingPage.simulateIncompleteTrackingInformation();
});

Then("the system displays a message indicating incomplete tracking information and suggests contacting support", () => {
 TrackingPage.verifyIncompleteTrackingInformationMessage();
});

Given("tracking errors occur", () => {
 TrackingPage.simulateTrackingErrors();
});

Then("tracking errors are logged accurately for auditing and troubleshooting purposes", () => {
 TrackingPage.verifyTrackingErrorsLogging();
});

Given("the user switches carriers for tracking an order", () => {
 TrackingPage.switchCarrier();
});

Then("the system updates the carrier information and attempts to fetch new tracking data", () => {
 TrackingPage.verifyCarrierSwitchAndDataFetch();
});

Given("the user attempts to retry fetching tracking information", () => {
 TrackingPage.retryFetchingTrackingInformation();
});

Then("the system allows retry attempts and provides feedback on the status of each attempt", () => {
 TrackingPage.verifyRetryAttemptsFeedback();
});

Given("the user encounters tracking issues", () => {
 TrackingPage.simulateTrackingIssues();
});

Then("a help link is available, directing users to support for tracking issues", () => {
 TrackingPage.verifyHelpLinkAvailability();
});