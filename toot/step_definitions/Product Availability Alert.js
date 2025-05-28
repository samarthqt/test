import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductAvailabilityPage from "../pages/ProductAvailabilityPage";

Given("a product is currently out of stock", () => {
 ProductAvailabilityPage.verifyOutOfStock();
});

Given("a user has subscribed to be notified when the product is back in stock", () => {
 ProductAvailabilityPage.subscribeUser();
});

Given("a user has not subscribed to be notified when the product is back in stock", () => {
 ProductAvailabilityPage.verifyNotSubscribed();
});

Given("multiple users have subscribed to be notified when the product is back in stock", () => {
 ProductAvailabilityPage.subscribeMultipleUsers();
});

Given("the user has set their preferred communication channel as email", () => {
 ProductAvailabilityPage.setPreferredChannelEmail();
});

When("the product becomes available in the inventory", () => {
 ProductAvailabilityPage.updateProductAvailability();
});

When("the user unsubscribes from the product availability alert", () => {
 ProductAvailabilityPage.unsubscribeUser();
});

Then("the user should receive a notification about the product availability", () => {
 ProductAvailabilityPage.verifyNotificationReceived();
});

Then("the user should not receive any notification", () => {
 ProductAvailabilityPage.verifyNoNotificationReceived();
});

Then("all subscribed users should receive a notification about the product availability", () => {
 ProductAvailabilityPage.verifyNotificationReceivedByAll();
});

Then("the notification should include details of the product such as name and quantity available", () => {
 ProductAvailabilityPage.verifyNotificationDetails();
});

Then("the user should receive an email notification about the product availability", () => {
 ProductAvailabilityPage.verifyEmailNotificationReceived();
});

Then("the user should not receive any notifications when the product becomes available in the inventory", () => {
 ProductAvailabilityPage.verifyUnsubscribeNoNotification();
});