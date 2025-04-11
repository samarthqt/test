import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import OrderTrackingPage from '../page_objects/OrderTrackingPage';

const orderTrackingPage = new OrderTrackingPage();

Given('the user is logged into the application', () => {
    // Code to ensure user is logged in
});

Given('the user has placed an order', () => {
    // Code to ensure an order has been placed
});

Given('the user navigates to the {string} section', (section) => {
    orderTrackingPage.navigateToSection(section);
});

When('the user selects an order to track', () => {
    orderTrackingPage.selectOrderToTrack();
});

Then('the system should display the current status of the order', () => {
    orderTrackingPage.verifyOrderStatusDisplayed();
});

Then('the system should display the expected delivery date', () => {
    orderTrackingPage.verifyExpectedDeliveryDateDisplayed();
});

Then('the system should display the current location of the order', () => {
    orderTrackingPage.verifyCurrentLocationDisplayed();
});

Given('the user is viewing the tracking information of an order', () => {
    orderTrackingPage.viewTrackingInformation();
});

When('the order status changes', () => {
    orderTrackingPage.simulateOrderStatusChange();
});

Then('the system should update the order status in real-time', () => {
    orderTrackingPage.verifyOrderStatusUpdated();
});

Then('the user should be notified of the status change', () => {
    orderTrackingPage.verifyUserNotifiedOfStatusChange();
});

When('the tracking information is unavailable', () => {
    orderTrackingPage.simulateTrackingInformationUnavailable();
});

Then('the system should display an error message', () => {
    orderTrackingPage.verifyErrorMessageDisplayed();
});

Then('the system should provide an option to retry', () => {
    orderTrackingPage.verifyRetryOptionDisplayed();
});

Given('the user is not logged into the application', () => {
    // Code to ensure user is not logged in
});

When('the user attempts to access the {string} section', (section) => {
    orderTrackingPage.attemptToAccessSection(section);
});

Then('the system should prompt the user to log in', () => {
    orderTrackingPage.verifyLoginPromptDisplayed();
});