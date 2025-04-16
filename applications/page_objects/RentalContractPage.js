class RentalContractPage {
  enterPropertyAddress(address) {
    cy.get('#property-address').type(address);
  }

  enterContractTerms(terms) {
    cy.get('#contract-terms').type(terms);
  }

  selectTenant(tenant) {
    cy.get('#tenant-select').select(tenant);
  }

  selectLandlord(landlord) {
    cy.get('#landlord-select').select(landlord);
  }

  generateContract() {
    cy.get('#generate-contract').click();
  }

  reviewContractForAccuracy() {
    cy.get('#contract-details').should('contain', '123 Main St, Springfield');
    cy.get('#contract-details').should('contain', '12 months, $1200/month');
  }

  initiateSigningProcess(user) {
    cy.get(`#initiate-signing-${user}`).click();
  }

  signContract(user) {
    cy.get(`#sign-contract-${user}`).click();
  }

  verifySignatures() {
    cy.get('#signatures').should('contain', 'User A: John Doe');
    cy.get('#signatures').should('contain', 'User B: Jane Smith');
  }

  saveSignedContract() {
    cy.get('#save-contract').click();
  }

  sendConfirmationEmail() {
    cy.get('#send-email').click();
  }

  logout() {
    cy.get('#logout').click();
  }
}