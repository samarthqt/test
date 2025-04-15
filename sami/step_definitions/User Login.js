Given('the user is on the login page', () => {
  cy.visit('/login');
});

When('the user enters a valid email {string} and password {string}', (email, password) => {
  LoginPage.enterEmail(email);
  LoginPage.enterPassword(password);
});

When('the user enters an invalid email {string} and a valid password {string}', (email, password) => {
  LoginPage.enterEmail(email);
  LoginPage.enterPassword(password);
});

When('the user enters a valid email {string} and an invalid password {string}', (email, password) => {
  LoginPage.enterEmail(email);
  LoginPage.enterPassword(password);
});

When('the user leaves the email and password fields empty', () => {
  LoginPage.enterEmail('');
  LoginPage.enterPassword('');
});

When('the user leaves the email field empty and enters a valid password {string}', (password) => {
  LoginPage.enterEmail('');
  LoginPage.enterPassword(password);
});

When('the user enters a valid email {string} and leaves the password field empty', (email) => {
  LoginPage.enterEmail(email);
  LoginPage.enterPassword('');
});

When('the user enters a password {string}', (password) => {
  LoginPage.enterPassword(password);
});

When('the user clicks the password visibility toggle', () => {
  LoginPage.togglePasswordVisibility();
});

When('the user clicks the password visibility toggle again', () => {
  LoginPage.togglePasswordVisibility();
});

When('the user selects the {string} checkbox', (checkbox) => {
  LoginPage.checkRememberMe();
});

When('the user clicks on the {string} link', (link) => {
  LoginPage.clickForgotPassword();
});

And('clicks the login button', () => {
  LoginPage.submitLogin();
});

Then('the user should be redirected to the account dashboard', () => {
  cy.url().should('include', '/dashboard');
});

Then('an error message should be displayed indicating invalid email or password', () => {
  LoginPage.verifyErrorMessage('Invalid email or password');
});

Then('an error message should be displayed indicating that email and password are required', () => {
  LoginPage.verifyErrorMessage('Email and password are required');
});

Then('an error message should be displayed indicating that email is required', () => {
  LoginPage.verifyErrorMessage('Email is required');
});

Then('an error message should be displayed indicating that password is required', () => {
  LoginPage.verifyErrorMessage('Password is required');
});

Then('the password should be visible in plain text', () => {
  LoginPage.verifyPasswordVisibility(true);
});

Then('the password should be hidden', () => {
  LoginPage.verifyPasswordVisibility(false);
});

Then('the user's email should be remembered on the login page upon logout', () => {
  LoginPage.verifyRememberedEmail('user@example.com');
});

Then('the user should be redirected to the password reset page', () => {
  cy.url().should('include', '/password-reset');
});