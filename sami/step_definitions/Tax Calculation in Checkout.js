import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CheckoutPage from '../pageObjects/CheckoutPage';

const checkoutPage = new CheckoutPage();

Given('the user is on the checkout page', () => {
  cy.visit('/checkout');
});

When('the user enters their location as {string}', (location) => {
  checkoutPage.enterLocation(location);
});

Then('the system should calculate the tax based on {string}', (location) => {
  checkoutPage.calculateTax(location);
});

Then('the calculated tax should be {string}', (expectedTax) => {
  checkoutPage.verifyCalculatedTax(expectedTax);
});

Given('the user enters their location as {string}', (location) => {
  checkoutPage.enterLocation(location);
});

When('the system calculates the tax', () => {
  checkoutPage.calculateTax();
});

Then('the calculated tax should be {string}', (expectedTax) => {
  checkoutPage.verifyCalculatedTax(expectedTax);
});

Given('the user initially enters their location as {string}', (location) => {
  checkoutPage.enterLocation(location);
});

And('the system calculates the tax as {string}', (expectedTax) => {
  checkoutPage.verifyCalculatedTax(expectedTax);
});

When('the user changes their location to {string}', (newLocation) => {
  checkoutPage.enterLocation(newLocation);
});

Then('the system should recalculate the tax as {string}', (expectedTax) => {
  checkoutPage.verifyCalculatedTax(expectedTax);
});

Given('the user enters their location as {string}', (location) => {
  checkoutPage.enterLocation(location);
});

When('the system calculates the tax', () => {
  checkoutPage.calculateTax();
});

Then('the system should display an error message {string}', (errorMessage) => {
  checkoutPage.verifyErrorMessage(errorMessage);
});

Given('the user does not enter any location', () => {
  checkoutPage.enterLocation('');
});

When('the system attempts to calculate the tax', () => {
  checkoutPage.calculateTax();
});

Then('the system should display an error message {string}', (errorMessage) => {
  checkoutPage.verifyErrorMessage(errorMessage);
});