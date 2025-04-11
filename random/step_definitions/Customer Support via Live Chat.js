import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CustomerSupportPage from '../pageobjects/CustomerSupportPage';

const customerSupportPage = new CustomerSupportPage();

Given('the application is open', () => {
  cy.visit('/');
});

When('the customer navigates to the customer support section', () => {
  customerSupportPage.navigateToSupportSection();
});

Then('the customer should see the live chat option', () => {
  customerSupportPage.verifyLiveChatOption();
});

Given('the customer is on the application', () => {
  cy.visit('/');
});

When('the customer accesses the live chat feature', () => {
  customerSupportPage.accessLiveChatFeature();
});

Then('the live chat should be integrated within the application', () => {
  customerSupportPage.verifyLiveChatIntegration();
});

Given('the customer wants to use the live chat feature', () => {
  cy.visit('/');
});

When('the customer tries to access live chat at any time', () => {
  customerSupportPage.accessLiveChatAnytime();
});

Then('the live chat should be available 24/7', () => {
  customerSupportPage.verifyLiveChatAvailability();
});

Given('the customer is using the application', () => {
  cy.visit('/');
});

When('the live chat feature becomes available', () => {
  customerSupportPage.liveChatBecomesAvailable();
});

Then('the customer should receive a notification informing them of chat availability', () => {
  customerSupportPage.verifyChatAvailabilityNotification();
});

Given('the customer is trying to connect to live chat', () => {
  cy.visit('/');
});

When('the chat connection fails', () => {
  customerSupportPage.simulateChatConnectionFailure();
});

Then('an error message should be displayed to the customer', () => {
  customerSupportPage.verifyErrorMessageForFailedConnection();
});

Given('the customer is using the live chat feature', () => {
  cy.visit('/');
});

When('the chat interaction occurs', () => {
  customerSupportPage.simulateChatInteraction();
});

Then('the interaction should be logged for tracking purposes', () => {
  customerSupportPage.verifyChatInteractionLogging();
});