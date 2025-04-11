import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProductPage from '../page_objects/ProductPage';

const productPage = new ProductPage();

Given('a product is currently out of stock', () => {
  productPage.verifyProductOutOfStock();
});

Given('a user has subscribed to be notified when the product is back in stock', () => {
  productPage.subscribeUserForNotification();
});

Given('a user has not subscribed to be notified when the product is back in stock', () => {
  productPage.verifyUserNotSubscribed();
});

Given('multiple users have subscribed to be notified when the product is back in stock', () => {
  productPage.subscribeMultipleUsers();
});

Given('the user has set their preferred communication channel as email', () => {
  productPage.setPreferredCommunicationChannel('email');
});

When('the product becomes available in the inventory', () => {
  productPage.makeProductAvailable();
});

When('the user unsubscribes from the product availability alert', () => {
  productPage.unsubscribeFromNotification();
});

Then('the user should receive a notification about the product availability', () => {
  productPage.verifyNotificationReceived();
});

Then('the user should not receive any notification', () => {
  productPage.verifyNoNotificationReceived();
});

Then('all subscribed users should receive a notification about the product availability', () => {
  productPage.verifyAllUsersNotificationReceived();
});

Then('the notification should include details of the product such as name and quantity available', () => {
  productPage.verifyNotificationIncludesProductDetails();
});

Then('the user should receive an email notification about the product availability', () => {
  productPage.verifyEmailNotificationReceived();
});

Then('the user should not receive any notifications when the product becomes available in the inventory', () => {
  productPage.verifyNoNotificationAfterUnsubscribe();
});