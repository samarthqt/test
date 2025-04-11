import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import InventoryPage from '../pageObjects/InventoryPage';

const inventoryPage = new InventoryPage();

Given('the product inventory module is active', () => {
  inventoryPage.verifyInventoryModuleActive();
});

Given('a product has a defined low inventory threshold', () => {
  inventoryPage.verifyLowInventoryThreshold();
});

When('the inventory level of the product falls below the threshold', () => {
  inventoryPage.setInventoryLevelBelowThreshold();
});

Then('a stock warning notification should be sent to the users', () => {
  inventoryPage.verifyStockWarningNotificationSent();
});

Then('the notification should include the product name and current inventory level', () => {
  inventoryPage.verifyNotificationIncludesProductDetails();
});

When('the inventory level of the product is above the threshold', () => {
  inventoryPage.setInventoryLevelAboveThreshold();
});

Then('no stock warning notification should be sent to the users', () => {
  inventoryPage.verifyNoStockWarningNotificationSent();
});

When('a user configures the notification settings for low inventory', () => {
  inventoryPage.configureNotificationSettings();
});

Then('the settings should be saved', () => {
  inventoryPage.verifySettingsSaved();
});

Then('the system should respect the configured settings when sending notifications', () => {
  inventoryPage.verifySettingsRespected();
});

Given('multiple products have inventory levels below their defined thresholds', () => {
  inventoryPage.verifyMultipleProductsBelowThreshold();
});

When('the system checks the inventory levels', () => {
  inventoryPage.checkInventoryLevels();
});

Then('stock warning notifications should be sent for each product with low inventory', () => {
  inventoryPage.verifyMultipleStockWarningsSent();
});

Given('a stock warning notification is sent', () => {
  inventoryPage.sendStockWarningNotification();
});

When('the user checks their notifications', () => {
  inventoryPage.checkUserNotifications();
});

Then('the user should see the stock warning notification', () => {
  inventoryPage.verifyUserSeesNotification();
});

Then('the notification should contain details about the low inventory product', () => {
  inventoryPage.verifyNotificationDetails();
});