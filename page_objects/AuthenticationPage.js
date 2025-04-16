class AuthenticationPage {
  loginAsAdmin() {
    cy.get('#admin-login').click();
  }

  visitSettingsPage() {
    cy.get('#settings-link').click();
  }

  verifySettingsPageIsDisplayed() {
    cy.url().should('include', '/settings');
  }

  locateAuthenticationSettings() {
    cy.get('#auth-settings').scrollIntoView();
  }

  verifyAuthenticationSettingsVisible() {
    cy.get('#auth-settings').should('be.visible');
  }

  verifyApplicationIsRunning() {
    cy.get('body').should('exist');
  }

  enableUserAuthentication() {
    cy.get('#enable-auth').check();
  }

  verifyUserAuthenticationEnabled() {
    cy.get('#enable-auth').should('be.checked');
  }

  enterUserCredentials(username, password) {
    cy.get('#username-field').type(username);
    cy.get('#password-field').type(password);
    cy.get('#save-credentials').click();
  }

  verifyCredentialsAcceptedAndSaved() {
    cy.get('#success-message').should('contain', 'Credentials saved');
  }

  verifyAllCredentialsAcceptedAndSaved() {
    cy.get('#success-message').should('contain', 'All credentials saved');
  }

  logoutAdmin() {
    cy.get('#logout-button').click();
  }

  verifyAdminLoggedOut() {
    cy.url().should('include', '/login');
  }

  verifyLoggedOut() {
    cy.url().should('include', '/login');
  }

  login(username, password) {
    cy.get('#username-field').type(username);
    cy.get('#password-field').type(password);
    cy.get('#login-button').click();
  }

  verifyLoginSuccessful(username) {
    cy.get('#welcome-message').should('contain', `Welcome, ${username}`);
  }

  loginWithIncorrectPassword(username) {
    cy.get('#username-field').type(username);
    cy.get('#password-field').type('wrongpassword');
    cy.get('#login-button').click();
  }

  verifyLoginUnsuccessfulWithErrorMessage() {
    cy.get('#error-message').should('contain', 'Login unsuccessful');
  }

  loginWithIncorrectUsername() {
    cy.get('#username-field').type('wrongusername');
    cy.get('#password-field').type('Password123');
    cy.get('#login-button').click();
  }

  checkUnauthorizedAccessLogs() {
    cy.get('#logs').click();
    cy.get('#unauthorized-access').should('exist');
  }

  verifyUnauthorizedAccessLogged() {
    cy.get('#log-message').should('contain', 'Unauthorized access attempt logged');
  }

  verifyPasswordComplexityEnforced() {
    cy.get('#password-complexity').should('be.visible');
  }

  verifyPasswordComplexityValidated() {
    cy.get('#complexity-validation').should('contain', 'Password complexity validated');
  }

  ensureUserAccountsLockedAfterFailedAttempts() {
    cy.get('#failed-attempts-lock').should('exist');
  }

  verifyUserAccountsLocked() {
    cy.get('#account-lock-message').should('contain', 'Account locked after failed attempts');
  }

  verifyPasswordResetFunctionality() {
    cy.get('#password-reset-link').should('exist');
    cy.get('#password-reset-link').click();
    cy.get('#reset-success-message').should('contain', 'Password reset successful');
  }

  verifyPasswordResetWorking() {
    cy.get('#reset-success-message').should('contain', 'Password reset working as expected');
  }
}