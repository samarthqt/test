class MarketingSignupPage {
  enterEmail(email) {
    cy.get('#email-input').type(email);
  }

  checkOptIn() {
    cy.get('#opt-in-checkbox').check();
  }

  uncheckOptIn() {
    cy.get('#opt-in-checkbox').uncheck();
  }

  submitForm() {
    cy.get('#signup-form').submit();
  }

  verifySuccessMessage() {
    cy.get('#confirmation-message').should('contain', 'successfully signed up');
  }

  verifyInvalidEmailMessage() {
    cy.get('#error-message').should('contain', 'email address is invalid');
  }

  verifyOptInRequiredMessage() {
    cy.get('#optin-required-message').should('contain', 'need to opt-in');
  }

  verifyAlreadySubscribedMessage() {
    cy.get('#already-subscribed-message').should('contain', 'email is already subscribed');
  }

  verifyEmailAddedToList() {
    // Implement verification logic to ensure email is added to the list
  }

  verifyEmailNotAddedToList() {
    // Implement verification logic to ensure email is not added to the list
  }

  verifyNoDuplicateEntry() {
    // Implement verification logic to ensure no duplicate entry
  }
}

export default MarketingSignupPage;