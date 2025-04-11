import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import MarketingSignupPage from '../pageObjects/MarketingSignupPage';

const marketingSignupPage = new MarketingSignupPage();

Given('the user is on the marketing signup page', () => {
  cy.visit('/marketing-signup');
});

When('the user enters a valid email address', () => {
  marketingSignupPage.enterEmail('valid@example.com');
});

When('the user enters an invalid email address', () => {
  marketingSignupPage.enterEmail('invalid-email');
});

When('the user enters the same email address', () => {
  marketingSignupPage.enterEmail('already@subscribed.com');
});

When('the user checks the opt-in checkbox for newsletters and promotions', () => {
  marketingSignupPage.checkOptIn();
});

When('the user does not check the opt-in checkbox for newsletters and promotions', () => {
  marketingSignupPage.uncheckOptIn();
});

When('the user submits the signup form', () => {
  marketingSignupPage.submitForm();
});

Then('the user should see a confirmation message stating that they have successfully signed up for email newsletters and promotions', () => {
  marketingSignupPage.verifySuccessMessage();
});

Then('the user should see an error message indicating that the email address is invalid', () => {
  marketingSignupPage.verifyInvalidEmailMessage();
});

Then('the user should see a message indicating that they need to opt-in to receive newsletters and promotions', () => {
  marketingSignupPage.verifyOptInRequiredMessage();
});

Then('the user should see a message indicating that the email is already subscribed', () => {
  marketingSignupPage.verifyAlreadySubscribedMessage();
});

Then('the user's email should be added to the marketing mailing list', () => {
  marketingSignupPage.verifyEmailAddedToList();
});

Then('the user's email should not be added to the marketing mailing list', () => {
  marketingSignupPage.verifyEmailNotAddedToList();
});

Then('no duplicate entry should be created in the marketing mailing list', () => {
  marketingSignupPage.verifyNoDuplicateEntry();
});