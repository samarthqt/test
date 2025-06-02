import 'cypress-real-events/support';

class SignupSigninPage {

  static visit() {
    cy.visit('/signup-signin');
  }

  static verifyOptions() {
    cy.get('#emailOption').should('be.visible');
    cy.get('#googleOption').should('be.visible');
    cy.get('#facebookOption').should('be.visible');
  }

  static signupWithEmail(email) {
    cy.get('#emailSignupInput').type(email);
    cy.get('#signupButton').click();
  }

  static verifySignupSuccess() {
    cy.get('#signupSuccessMessage').should('be.visible');
  }

  static logout() {
    cy.get('#logoutButton').click();
  }

  static verifyLogoutSuccess() {
    cy.get('#logoutSuccessMessage').should('be.visible');
  }

  static signinWithEmail(email) {
    cy.get('#emailSigninInput').type(email);
    cy.get('#signinButton').click();
  }

  static verifySigninSuccess() {
    cy.get('#signinSuccessMessage').should('be.visible');
  }

  static signupWithGoogle(email) {
    cy.get('#googleSignupButton').click();
    cy.origin('https://accounts.google.com', () => {
      cy.get('input[type=email]').type(email);
      cy.get('#identifierNext').click();
    });
  }

  static signinWithGoogle(email) {
    cy.get('#googleSigninButton').click();
    cy.origin('https://accounts.google.com', () => {
      cy.get('input[type=email]').type(email);
      cy.get('#identifierNext').click();
    });
  }

  static signupWithFacebook(email) {
    cy.get('#facebookSignupButton').click();
    cy.origin('https://www.facebook.com', () => {
      cy.get('input[name=email]').type(email);
      cy.get('#loginbutton').click();
    });
  }

  static signinWithFacebook(email) {
    cy.get('#facebookSigninButton').click();
    cy.origin('https://www.facebook.com', () => {
      cy.get('input[name=email]').type(email);
      cy.get('#loginbutton').click();
    });
  }

  static navigateToProfile() {
    cy.get('#profileLink').click();
  }

  static verifyProfileDetails() {
    cy.get('#profileName').should('contain', 'testuser');
    cy.get('#profileEmail').should('contain', 'testuser@example.com');
  }

  static checkForWelcomeEmail() {
    cy.get('#emailInbox').click();
  }

  static verifyWelcomeEmail() {
    cy.get('#welcomeEmail').should('be.visible');
  }

  static signinWithIncorrectCredentials() {
    cy.get('#emailSigninInput').type('wronguser@example.com');
    cy.get('#signinButton').click();
  }

  static verifySigninError() {
    cy.get('#signinErrorMessage').should('be.visible');
  }

  static verifySecurityMeasures() {
    cy.get('#captcha').should('be.visible');
  }

  static verifySigningProcess() {
    cy.get('#signupButton, #signinButton').should('be.visible');
  }

  static verifyNoConsoleErrors() {
    cy.window().then((win) => {
      const consoleSpy = cy.spy(win.console, 'error');
      cy.wrap(consoleSpy).should('not.be.called');
    });
  }

  static signupWithRegisteredEmail(email) {
    cy.get('#emailSignupInput').type(email);
    cy.get('#signupButton').click();
  }

  static verifyEmailAlreadyRegisteredError() {
    cy.get('#emailRegisteredError').should('be.visible');
  }

  static checkPasswordResetOptions() {
    cy.get('#forgotPasswordLink').click();
  }

  static verifyPasswordResetOption() {
    cy.get('#passwordResetOption').should('be.visible');
  }
}

export default SignupSigninPage;