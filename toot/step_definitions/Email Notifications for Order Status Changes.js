import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import OrderPage from "../pages/orderPage";

Given("the user is logged into the order management system", () => {
 OrderPage.login();
});

Given("the user has valid email notification settings configured", () => {
 OrderPage.configureEmailSettings();
});

Given("an order with ID {string} is in the system", (orderId) => {
 OrderPage.verifyOrderInSystem(orderId);
});

When("the order status is updated to {string}", (status) => {
 OrderPage.updateOrderStatus(status);
});

Then("an email notification should be sent to the customer's registered email address", () => {
 OrderPage.verifyEmailSent();
});

Then("the email subject should be {string}", (subject) => {
 OrderPage.verifyEmailSubject(subject);
});

Then("the email body should contain the shipping details and tracking information", () => {
 OrderPage.verifyEmailBodyShippingDetails();
});

Then("the email body should contain the delivery confirmation and feedback request", () => {
 OrderPage.verifyEmailBodyDeliveryDetails();
});

Then("no email notification should be sent to the customer", () => {
 OrderPage.verifyNoEmailSent();
});

Then("the email body should contain the cancellation details and refund information", () => {
 OrderPage.verifyEmailBodyCancellationDetails();
});

Given("the email server is down", () => {
 OrderPage.simulateEmailServerDown();
});

Then("the system should log an error indicating the email could not be sent", () => {
 OrderPage.verifyErrorLogged();
});

Then("the user should be notified of the failure to send the email notification", () => {
 OrderPage.verifyUserNotifiedOfFailure();
});

Then("the email should contain the correct order ID, status, and customer details", () => {
 OrderPage.verifyEmailContentForShipped();
});

Then("the email should contain the correct order ID, status, and delivery details", () => {
 OrderPage.verifyEmailContentForDelivered();
});