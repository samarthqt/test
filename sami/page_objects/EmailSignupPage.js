class EmailSignupPage {
  visit() {
    cy.visit('/email-signup');
  }

  enterEmail(email) {
    cy.get('#email-input').type(email);
  }

  submitForm() {
    cy.get('#signup-form').submit();
  }

  clickPrivacyPolicyLink() {
    cy.get('#privacy-policy-link').click();
  }

  verifyConfirmationMessage() {
    cy.get('#confirmation-message').should('be.visible');
  }

  verifyInvalidEmailMessage() {
    cy.get('#error-message').should('contain', 'invalid email');
  }

  verifyAlreadyRegisteredMessage() {
    cy.get('#error-message').should('contain', 'already registered');
  }

  verifyEmailRequiredMessage() {
    cy.get('#error-message').should('contain', 'email address is required');
  }

  verifyPrivacyPolicyPage() {
    cy.url().should('include', '/privacy-policy');
  }

  returnToSignupPage() {
    cy.go('back');
    cy.url().should('include', '/email-signup');
  }

  verifyUserAddedToList() {
    // Implement verification logic for user added to list
  }

  verifyUserNotAddedToList() {
    // Implement verification logic for user not added to list
  }
}

export default EmailSignupPage;