class SupplierManagement {
  navigateTo() {
    cy.visit('/supplier-management');
  }

  selectSuppliersMenu() {
    cy.get('.menu').contains('Suppliers').click();
  }

  clickAddNewSupplier() {
    cy.get('.add-supplier-button').click();
  }

  fillSupplierDetails(name, contact, email, terms) {
    cy.get('#supplier-name').type(name);
    cy.get('#contact-name').type(contact);
    cy.get('#contact-email').type(email);
    cy.get('#payment-terms').type(terms);
  }

  saveSupplier() {
    cy.get('.save-button').click();
  }

  searchSupplier(name) {
    cy.get('.supplier-list').type(name);
  }

  selectSupplier(name) {
    cy.contains(name).click();
  }

  editContactEmail(email) {
    cy.get('.edit-button').click();
    cy.get('#contact-email').clear().type(email);
    cy.get('.save-button').click();
  }

  removeSupplier() {
    cy.get('.remove-button').click();
  }
}

export default SupplierManagement;