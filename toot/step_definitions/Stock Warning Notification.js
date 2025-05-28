import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import ProductInventoryPage from "../pages/productInventoryPage";

Given("the product inventory module is active", () => {
 ProductInventoryPage.ensureModuleIsActive();
});

Given("a product has a defined low inventory threshold", () => {
 ProductInventoryPage.defineLowInventoryThreshold();
});

When("the inventory level of the product falls below the threshold", () => {
 ProductInventoryPage.setInventoryBelowThreshold();
});

Then("a stock warning notification should be sent to the users", () => {
 ProductInventoryPage.verifyStockWarningNotificationSent();
});

Then("the notification should include the product name and current inventory level", () => {
 ProductInventoryPage.verifyNotificationDetails();
});

When("the inventory level of the product is above the threshold", () => {
 ProductInventoryPage.setInventoryAboveThreshold();
});

Then("no stock warning notification should be sent to the users", () => {
 ProductInventoryPage.verifyNoNotificationSent();
});

When("a user configures the notification settings for low inventory", () => {
 ProductInventoryPage.configureNotificationSettings();
});

Then("the settings should be saved", () => {
 ProductInventoryPage.verifySettingsSaved();
});

Then("the system should respect the configured settings when sending notifications", () => {
 ProductInventoryPage.verifyConfiguredSettingsRespected();
});

Given("multiple products have inventory levels below their defined thresholds", () => {
 ProductInventoryPage.setMultipleProductsBelowThreshold();
});

When("the system checks the inventory levels", () => {
 ProductInventoryPage.checkInventoryLevels();
});

Then("stock warning notifications should be sent for each product with low inventory", () => {
 ProductInventoryPage.verifyMultipleNotificationsSent();
});

Then("each notification should include the respective product name and current inventory level", () => {
 ProductInventoryPage.verifyEachNotificationDetails();
});

Given("a stock warning notification is sent", () => {
 ProductInventoryPage.sendStockWarningNotification();
});

When("the user checks their notifications", () => {
 ProductInventoryPage.checkUserNotifications();
});

Then("the user should see the stock warning notification", () => {
 ProductInventoryPage.verifyUserSeesNotification();
});

Then("the notification should contain details about the low inventory product", () => {
 ProductInventoryPage.verifyNotificationContainsProductDetails();
});