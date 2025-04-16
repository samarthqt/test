class AccountPage {
  verifyPageDisplayed() {
    cy.url().should('include', '/account-opening');
    cy.get('.account-options').should('be.visible');
  }

  enterUserName(name) {
    cy.get('#username').clear().type(name);
  }

  enterEmail(email) {
    cy.get('#email').clear().type(email);
  }

  verifyInvalidFieldsHighlighted() {
    cy.get('.error').should('be.visible');
  }

  selectFeeFreeAccount() {
    cy.get('#account-type-fee-free').check();
  }

  verifyFormSubmissionBlocked() {
    cy.get('#submit-button').should('be.disabled');
  }

  submitForm() {
    cy.get('#submit-button').click();
  }

  verifyFormSubmitted() {
    cy.get('.confirmation').should('contain', 'Account created successfully');
  }

  verifyAccountTypeInConfirmation(type) {
    cy.get('.confirmation-account-type').should('contain', type);
  }

  logout() {
    cy.get('#logout-button').click();
  }

  verifyLogoutSuccessful() {
    cy.url().should('not.include', '/account-opening');
  }
}