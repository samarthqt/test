import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import ProfilePage from '../pageobjects/ProfilePage';

const profilePage = new ProfilePage();

Given('a user is logged into their account', () => {
  // Implement login functionality
});

Given('the user is on their profile page', () => {
  profilePage.visitProfilePage();
});

When('the user clicks on the {string} button', (button) => {
  profilePage.clickButton(button);
});

When('the user updates their personal information with valid data', () => {
  profilePage.updateProfileWithValidData();
});

When('the user updates their personal information with invalid data', () => {
  profilePage.updateProfileWithInvalidData();
});

When('the user updates their personal information', () => {
  profilePage.updateProfile();
});

When('the user does not change any information', () => {
  profilePage.leaveProfileUnchanged();
});

When('the user navigates to the {string} section', (section) => {
  profilePage.navigateToSection(section);
});

Then('the user's profile should be updated with the new information', () => {
  profilePage.verifyProfileUpdated();
});

Then('a confirmation message should be displayed', () => {
  profilePage.verifyConfirmationMessage();
});

Then('the user's profile should not be updated', () => {
  profilePage.verifyProfileNotUpdated();
});

Then('an error message should be displayed indicating the invalid fields', () => {
  profilePage.verifyErrorMessage();
});

Then('the user should be redirected back to the profile page without changes', () => {
  profilePage.verifyRedirectToProfilePage();
});

Then('the user should see a list of previous changes made to their profile', () => {
  profilePage.verifyEditHistory();
});

Then('each entry should include the date and time of the change', () => {
  profilePage.verifyEditHistoryDetails();
});

Then('the user's profile should remain unchanged', () => {
  profilePage.verifyProfileUnchanged();
});

Then('a message should be displayed indicating no changes were made', () => {
  profilePage.verifyNoChangesMessage();
});