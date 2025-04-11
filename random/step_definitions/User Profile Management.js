import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProfilePage from '../pageObjects/ProfilePage';

const profilePage = new ProfilePage();

Given('the user is logged into their account', () => {
  // Implement login functionality
  cy.login();
});

When('the user navigates to the profile management section', () => {
  profilePage.navigateToProfileManagement();
});

Then('the user should be able to update their name', () => {
  profilePage.updateName('New Name');
});

Then('the user should be able to update their email', () => {
  profilePage.updateEmail('newemail@example.com');
});

Then('the user should be able to update their shipping address', () => {
  profilePage.updateShippingAddress('123 New St, City, Country');
});

Then('the user should be able to update their billing address', () => {
  profilePage.updateBillingAddress('456 Billing Rd, City, Country');
});

Then('the user should be able to update their phone number', () => {
  profilePage.updatePhoneNumber('1234567890');
});

Then('the changes should be saved immediately', () => {
  profilePage.verifyChangesSaved();
});

Then('the changes should reflect in the user profile', () => {
  profilePage.verifyProfileUpdates();
});

Then('a notification should confirm successful updates', () => {
  profilePage.verifyUpdateNotification();
});

When('the user navigates to the password change section', () => {
  profilePage.navigateToPasswordChange();
});

Then('the user should be able to change their password securely', () => {
  profilePage.changePassword('oldPassword', 'newSecurePassword');
});

Then('a notification should confirm successful password change', () => {
  profilePage.verifyPasswordChangeNotification();
});

Given('the user is on the profile management section', () => {
  profilePage.navigateToProfileManagement();
});

When('the user enters incorrect data format in any field', () => {
  profilePage.enterInvalidData();
});

Then('an error message should be displayed for invalid inputs', () => {
  profilePage.verifyInvalidInputError();
});

Given('the user has updated their personal information', () => {
  profilePage.updatePersonalInformation();
});

Then('the user data should be encrypted and stored securely', () => {
  profilePage.verifyDataEncryption();
});

Given('the user has made changes to their profile', () => {
  profilePage.makeProfileChanges();
});

Then('the changes should be tracked in the logs', () => {
  profilePage.verifyProfileChangeLogs();
});