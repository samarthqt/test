class AccountCreationPage {
  static enterPersonalDetails(user) {
    cy.get('#name').type(user.name);
    cy.get('#address').type(user.address);
    cy.get('#phone').type(user.phone);
    cy.get('#id').type(user.id);
    cy.get('#submit-details').click();
  }

  static initiateIdentityVerification(user) {
    this.enterPersonalDetails(user);
    cy.get('#verify-identity').click();
  }

  static completeAccountCreation(user) {
    this.initiateIdentityVerification(user);
    cy.get('#create-account').click();
  }

  static completeAccountCreationWithoutVerification(user) {
    this.enterPersonalDetails(user);
    cy.get('#create-account').click();
  }

  static attemptDuplicateAccountCreation(user) {
    this.completeAccountCreation(user);
    cy.get('#create-account').click();
  }

  static simulatePeakLoad() {
    cy.intercept('POST', '/account-creation', { delay: 1000 }).as('peakLoad');
    cy.wait('@peakLoad');
  }
}