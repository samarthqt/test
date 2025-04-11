class LoginPage {
  visitLoginPage() {
    cy.visit('/login');
  }

  selectSocialMediaLogin(platform) {
    cy.get(`[data-testid="${platform.toLowerCase()}-login-button"]`).click();
  }

  verifyRedirectedToSocialMedia(platform) {
    cy.url().should('include', platform.toLowerCase());
  }

  enterValidCredentials(platform) {
    cy.get('input[name="email"]').type(Cypress.env(`${platform.toUpperCase()}_EMAIL`));
    cy.get('input[name="password"]').type(Cypress.env(`${platform.toUpperCase()}_PASSWORD`));
    cy.get('button[type="submit"]').click();
  }

  enterInvalidCredentials(platform) {
    cy.get('input[name="email"]').type('invalid@example.com');
    cy.get('input[name="password"]').type('invalidpassword');
    cy.get('button[type="submit"]').click();
  }

  authorizeApplication() {
    cy.get('button.authorize').click();
  }

  denyApplicationAuthorization() {
    cy.get('button.deny').click();
  }

  verifyRedirectedToHomePage() {
    cy.url().should('include', '/home');
  }

  verifyUserLoggedIn() {
    cy.get('.user-profile').should('be.visible');
  }

  verifyInvalidCredentialsError() {
    cy.get('.error-message').should('contain', 'Invalid credentials');
  }

  verifyUserNotLoggedIn() {
    cy.get('.login-form').should('be.visible');
  }

  verifyRedirectedToLoginPage() {
    cy.url().should('include', '/login');
  }

  checkSocialMediaOptions() {
    cy.get('.social-login-options').should('be.visible');
  }

  verifySocialMediaOptions() {
    cy.get('.social-login-options').within(() => {
      cy.contains('Facebook').should('be.visible');
      cy.contains('Google').should('be.visible');
      cy.contains('Twitter').should('be.visible');
      cy.contains('LinkedIn').should('be.visible');
    });
  }
}

export default LoginPage;