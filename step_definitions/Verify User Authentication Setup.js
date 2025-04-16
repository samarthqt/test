Given('I have access to the application as an admin user', () => {
  cy.loginAsAdmin();
});

When('I navigate to the application settings page', () => {
  cy.visitSettingsPage();
});

Then('the application settings page should be displayed', () => {
  cy.verifySettingsPageIsDisplayed();
});

Given('I am on the application settings page', () => {
  cy.verifySettingsPageIsDisplayed();
});

When('I locate the authentication settings section', () => {
  cy.locateAuthenticationSettings();
});

Then('the authentication settings section should be visible', () => {
  cy.verifyAuthenticationSettingsVisible();
});

Given('the application is running and accessible', () => {
  cy.verifyApplicationIsRunning();
});

When('I select the option to enable user authentication', () => {
  cy.enableUserAuthentication();
});

Then('the user authentication option should be enabled', () => {
  cy.verifyUserAuthenticationEnabled();
});

Given('user authentication is enabled', () => {
  cy.verifyUserAuthenticationEnabled();
});

When('I enter the username {string} and password {string} in the authentication setup fields', (username, password) => {
  cy.enterUserCredentials(username, password);
});

Then('the username and password should be accepted and saved', () => {
  cy.verifyCredentialsAcceptedAndSaved();
});

When('I repeat the process for {string} with {string} and {string} with {string}', (username1, password1, username2, password2) => {
  cy.enterUserCredentials(username1, password1);
  cy.enterUserCredentials(username2, password2);
});

Then('all user credentials should be accepted and saved', () => {
  cy.verifyAllCredentialsAcceptedAndSaved();
});

Given('I am logged in as admin', () => {
  cy.loginAsAdmin();
});

When('I log out of the admin account', () => {
  cy.logoutAdmin();
});

Then('the admin should be logged out of the application', () => {
  cy.verifyAdminLoggedOut();
});

Given('I am logged out of the application', () => {
  cy.verifyLoggedOut();
});

When('I attempt to log in as {string} using {string}', (username, password) => {
  cy.login(username, password);
});

Then('{string} should be successfully logged in', (username) => {
  cy.verifyLoginSuccessful(username);
});

When('I attempt to log in with an incorrect password for {string}', (username) => {
  cy.loginWithIncorrectPassword(username);
});

Then('login should be unsuccessful and an error message should be displayed', () => {
  cy.verifyLoginUnsuccessfulWithErrorMessage();
});

When('I attempt to log in with an incorrect username', () => {
  cy.loginWithIncorrectUsername();
});

Then('login should be unsuccessful and an error message should be displayed', () => {
  cy.verifyLoginUnsuccessfulWithErrorMessage();
});

When('I check the application logs for any unauthorized access attempts', () => {
  cy.checkUnauthorizedAccessLogs();
});

Then('unauthorized access attempts should be logged', () => {
  cy.verifyUnauthorizedAccessLogged();
});

When('I verify that password complexity requirements are enforced', () => {
  cy.verifyPasswordComplexityEnforced();
});

Then('password complexity requirements should be enforced and validated', () => {
  cy.verifyPasswordComplexityValidated();
});

When('I ensure that user accounts are locked after multiple failed login attempts', () => {
  cy.ensureUserAccountsLockedAfterFailedAttempts();
});

Then('user accounts should be locked after a predefined number of failed login attempts', () => {
  cy.verifyUserAccountsLocked();
});

When('I verify that password reset functionality is available and working', () => {
  cy.verifyPasswordResetFunctionality();
});

Then('password reset functionality should be available and working as expected', () => {
  cy.verifyPasswordResetWorking();
});