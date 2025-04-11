import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CartPage from '../pageObjects/CartPage';

const cartPage = new CartPage();

Given('the user is logged into the e-commerce platform', () => {
    // Implement login functionality
});

Given('the user has items in their cart', () => {
    // Ensure the cart has items
});

Given('the price threshold is set to {string}', (threshold) => {
    cartPage.setPriceThreshold(threshold);
});

Given('the current total price of items in the cart is {string}', (currentTotal) => {
    cartPage.setCurrentTotalPrice(currentTotal);
});

When('the user adds an item with price {string}', (itemPrice) => {
    cartPage.addItem(itemPrice);
});

When('the user removes an item with price {string}', (itemPrice) => {
    cartPage.removeItem(itemPrice);
});

Then('the user should receive a notification that their cart has exceeded the threshold', () => {
    cartPage.checkNotification('exceeded');
});

Then('the user should not receive a notification', () => {
    cartPage.checkNoNotification();
});

Then('the user should receive only one notification that their cart has exceeded the threshold', () => {
    cartPage.checkSingleNotification();
});

Then('the user should receive a notification that their cart is now below the threshold', () => {
    cartPage.checkNotification('below');
});