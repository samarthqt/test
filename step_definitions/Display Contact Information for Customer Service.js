import { Given, When, Then } from 'cypress-cucumber-preprocessor/steps';
import CustomerServicePage from '../page-objects/CustomerServicePage';

const customerServicePage = new CustomerServicePage();

Given('the user is on the customer service section of the system', () => {
  customerServicePage.visitCustomerServiceSection();
});

When('the user checks the contact information for customer service', () => {
  customerServicePage.checkContactInformation();
});

Then('the system should display the contact information, including phone numbers, email addresses, and chat links', () => {
  customerServicePage.verifyContactInformationDisplayed();
});

When('the user verifies the phone numbers displayed', () => {
  customerServicePage.verifyPhoneNumbers();
});

Then('the phone numbers displayed should be correct and valid for contacting customer service', () => {
  customerServicePage.checkValidPhoneNumbers();
});

When('the user verifies the email addresses displayed', () => {
  customerServicePage.verifyEmailAddresses();
});

Then('the email addresses displayed should be correct and valid for contacting customer service', () => {
  customerServicePage.checkValidEmailAddresses();
});

When('the user verifies the chat links displayed', () => {
  customerServicePage.verifyChatLinks();
});

Then('the chat links displayed should be functional and allow users to initiate a chat with customer service', () => {
  customerServicePage.checkFunctionalChatLinks();
});

When('the user clicks on a phone number', () => {
  customerServicePage.clickPhoneNumber();
});

Then('the system should initiate a call to the selected phone number', () => {
  customerServicePage.verifyCallInitiation();
});

When('the user clicks on an email address', () => {
  customerServicePage.clickEmailAddress();
});

Then('the system should open the default email client with the selected email address pre-filled', () => {
  customerServicePage.verifyEmailClientOpens();
});

When('the user clicks on a chat link', () => {
  customerServicePage.clickChatLink();
});

Then('the system should open a chat window or redirect the user to a chat platform for contacting customer service', () => {
  customerServicePage.verifyChatWindowOpens();
});

When('the user views the contact information', () => {
  customerServicePage.viewContactInformation();
});

Then('the contact information should be presented in a user-friendly format, making it easy for users to read and understand', () => {
  customerServicePage.checkContactInfoFormat();
});

Then('the contact information should be current and accurate, reflecting the latest phone numbers, email addresses, and chat links for customer service', () => {
  customerServicePage.checkContactInfoAccuracy();
});

Given('the user is on any page or section of the system', () => {
  customerServicePage.visitAnyPage();
});

When('the user looks for the contact information', () => {
  customerServicePage.searchContactInformation();
});

Then('the contact information should be prominently displayed and easily accessible, ensuring users can quickly find and contact customer service', () => {
  customerServicePage.checkContactInfoAccessibility();
});

Given('the user accesses the system from different platforms or devices', () => {
  customerServicePage.accessFromDifferentPlatforms();
});

Then('the contact information should be consistent and displayed correctly regardless of the platform or device used to access the system', () => {
  customerServicePage.checkContactInfoConsistency();
});

Then('the contact information should be securely displayed, ensuring that only authorized users can view and access the information', () => {
  customerServicePage.checkContactInfoSecurity();
});

Then('the contact information should be localized and displayed correctly for different regions or languages, ensuring that users can easily understand and use the information', () => {
  customerServicePage.checkContactInfoLocalization();
});

Given('the user is a system administrator or authorized personnel', () => {
  customerServicePage.loginAsAdmin();
});

When('the user updates the contact information', () => {
  customerServicePage.updateContactInformation();
});

Then('the contact information should be easily updatable, allowing changes or updates as needed by system administrators or authorized personnel', () => {
  customerServicePage.verifyContactInfoUpdatability();
});