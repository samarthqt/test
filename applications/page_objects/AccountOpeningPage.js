class AccountOpeningPage {
  verifyPageDisplayed() {
    cy.get('h1').contains('Account Opening').should('be.visible');
  }

  enterUserDetails(name, email) {
    cy.get('#name').type(name);
    cy.get('#email').type(email);
  }

  selectAccountType(type) {
    cy.get('#account-type').select(type);
  }

  verifyFeeFreeOptionUnavailable() {
    cy.get('#account-type').should('not.have.value', 'Fee-Free');
  }

  submitForm() {
    cy.get('#submit-button').click();
  }

  verifyErrorMessageDisplayed() {
    cy.get('.error-message').contains('Fee-Free option is unavailable').should('be.visible');
  }

  logout() {
    cy.get('#logout-button').click();
  }
}