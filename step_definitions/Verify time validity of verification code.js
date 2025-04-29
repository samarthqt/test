const { Given, When, Then } = require('cypress-cucumber-preprocessor/steps');

Given('the user has received a verification code', () => {
  cy.receiveVerificationCode();
});

When('the user receives the verification code via SMS', () => {
  cy.receiveCodeViaSMS();
});

Then('the verification code {string} is received', (code) => {
  cy.verifyCodeReceived(code);
});

When('the user waits for {int} minutes before entering the code', (minutes) => {
  cy.waitForMinutes(minutes);
});

Then('the code is still valid and accepted by the system', () => {
  cy.verifyCodeValidity(true);
});

Then('the code is expired and not accepted by the system', () => {
  cy.verifyCodeValidity(false);
});

When('the user attempts to enter the code multiple times within {int} minutes', (minutes) => {
  cy.enterCodeMultipleTimes(minutes);
});

Then('the code is accepted each time within the validity period', () => {
  cy.verifyMultipleCodeEntries();
});

When('the code expires', () => {
  cy.codeExpires();
});

Then('the system displays {string} message', (message) => {
  cy.verifyExpiredMessage(message);
});

Then('the system logs show the code expiration timestamp', () => {
  cy.checkSystemLogsForExpiration();
});

When('the user logs out and logs back in within {int} minutes', (minutes) => {
  cy.logoutAndLogin(minutes);
});

When('the system is restarted within {int} minutes', (minutes) => {
  cy.restartSystem(minutes);
});

Then('the user can request a new code', () => {
  cy.requestNewCode();
});

When('the user enters the code incorrectly during the validity period', () => {
  cy.enterCodeIncorrectly();
});

Then('the system prompts for correct code entry without affecting validity', () => {
  cy.promptForCorrectCodeEntry();
});

Then('the expired code cannot be reused', () => {
  cy.preventExpiredCodeReuse();
});

When('the user enters the code with incorrect formatting during the validity period', () => {
  cy.enterCodeWithIncorrectFormatting();
});

Then('the system rejects incorrectly formatted code', () => {
  cy.rejectIncorrectlyFormattedCode();
});

When('the code is entered simultaneously from different devices within the validity period', () => {
  cy.enterCodeSimultaneouslyFromDevices();
});

Then('the code is valid on all devices', () => {
  cy.verifyCodeValidityOnAllDevices();
});

When('there are network delays in code entry', () => {
  cy.handleNetworkDelays();
});

Then('the code remains valid despite network delays', () => {
  cy.verifyCodeValidityDespiteDelays();
});

When('the user makes multiple verification requests within the validity period', () => {
  cy.makeMultipleVerificationRequests();
});

Then('the system issues a new code for each request and maintains validity', () => {
  cy.verifyNewCodeIssuedAndValidityMaintained();
});