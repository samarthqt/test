const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');
const mfaPage = require('../../support/pageObjects/mfaPage');

Given('a user has a registered phone number in the system', () => {
  mfaPage.verifyRegisteredPhoneNumber();
});

When('the user initiates the MFA process by logging into the system with a registered account', () => {
  mfaPage.loginWithRegisteredAccount();
});

Then('the system prompts for MFA verification', () => {
  mfaPage.verifyMFAPrompt();
});

Given('the system prompts for MFA verification', () => {
  mfaPage.verifyMFAPrompt();
});

When('the user selects the phone number as the verification method', () => {
  mfaPage.selectPhoneNumberVerificationMethod();
});

Then('the system displays the registered phone number for verification', () => {
  mfaPage.displayRegisteredPhoneNumber();
});

Given('the user has selected the phone number for verification', () => {
  mfaPage.verifyPhoneNumberSelected();
});

When('the user confirms the phone number selection', () => {
  mfaPage.confirmPhoneNumberSelection();
});

Then('the system sends a 6-digit verification code to the registered phone number', () => {
  mfaPage.sendVerificationCode();
});

Given('a verification code is sent to the registered phone number', () => {
  mfaPage.verifyCodeSent();
});

When('the user checks the phone for the received verification code', () => {
  mfaPage.checkReceivedCode();
});

Then('verification code '123456' is received via SMS', () => {
  mfaPage.verifyReceivedCode('123456');
});

Given('the verification code is received via SMS', () => {
  mfaPage.verifyCodeReceived();
});

When('the user enters the received verification code into the system', () => {
  mfaPage.enterReceivedCode();
});

Then('the system verifies the code and grants access to the account', () => {
  mfaPage.verifyCodeAndGrantAccess();
});

Given('a verification code is received', () => {
  mfaPage.verifyCodeReceived();
});

When('the user checks the code format', () => {
  mfaPage.checkCodeFormat();
});

Then('the code is exactly 6 digits long', () => {
  mfaPage.verifyCodeLength();
});

Given('a different registered phone number is available', () => {
  mfaPage.verifyDifferentRegisteredNumber();
});

When('the user repeats the MFA process with the different phone number', () => {
  mfaPage.repeatMFAWithDifferentNumber();
});

Then('the verification code is sent successfully to the new number', () => {
  mfaPage.verifyCodeSentToNewNumber();
});

Given('the user initiates the MFA process', () => {
  mfaPage.initiateMFAProcess();
});

When('the user does not select a phone number', () => {
  mfaPage.skipPhoneNumberSelection();
});

Then('the system prompts to select a phone number for verification', () => {
  mfaPage.promptToSelectPhoneNumber();
});

Given('a verification code is sent', () => {
  mfaPage.verifyCodeSent();
});

When('the user checks the delivery time', () => {
  mfaPage.checkDeliveryTime();
});

Then('the code is received within a reasonable time frame (e.g., 30 seconds)', () => {
  mfaPage.verifyCodeReceivedInTime();
});

Given('a verification code is received via SMS', () => {
  mfaPage.verifyCodeReceived();
});

When('the user checks the SMS content', () => {
  mfaPage.checkSMSContent();
});

Then('the SMS contains only the verification code and no sensitive information', () => {
  mfaPage.verifySMSContent();
});

Given('multiple login attempts are made', () => {
  mfaPage.verifyMultipleLoginAttempts();
});

When('the user checks the verification codes for each attempt', () => {
  mfaPage.checkVerificationCodes();
});

Then('a different code is sent for each login attempt', () => {
  mfaPage.verifyUniqueCodes();
});

Given('a login attempt is made', () => {
  mfaPage.verifyLoginAttempt();
});

When('the user checks the number of verification codes sent', () => {
  mfaPage.checkNumberOfCodesSent();
});

Then('no duplicate codes are sent for the same attempt', () => {
  mfaPage.verifyNoDuplicateCodes();
});

Given('a phone number is registered in the system', () => {
  mfaPage.verifyPhoneNumberRegistered();
});

When('the user checks the phone number format in the system settings', () => {
  mfaPage.checkPhoneNumberFormat();
});

Then('the phone number is correctly formatted and matches the registered number', () => {
  mfaPage.verifyPhoneNumberFormat();
});

Given('a verification code is sent to a registered phone number', () => {
  mfaPage.verifyCodeSent();
});

When('the user checks the system logs', () => {
  mfaPage.checkSystemLogs();
});

Then('the system logs show the verification code sent to the registered number', () => {
  mfaPage.verifySystemLogs();
});

Given('an unregistered phone number is used for MFA', () => {
  mfaPage.verifyUnregisteredPhoneNumber();
});

When('the user attempts MFA', () => {
  mfaPage.attemptMFA();
});

Then('the system does not send a verification code and prompts to register the number', () => {
  mfaPage.promptToRegisterNumber();
});