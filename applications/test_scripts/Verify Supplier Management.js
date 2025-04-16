describe('Supplier Management', () => {
  const supplierName = 'ABC Supplies';
  const contactName = 'John Doe';
  const contactEmail = 'john.doe@abc.com';
  const updatedEmail = 'john.doe@newemail.com';
  const paymentTerms = 'Net 30';

  before(() => {
    cy.login();
  });

  it('should add a new supplier', () => {
    cy.visit('/supplier-management');
    cy.get('.menu').contains('Suppliers').click();
    cy.get('.add-supplier-button').click();
    cy.get('#supplier-name').type(supplierName);
    cy.get('#contact-name').type(contactName);
    cy.get('#contact-email').type(contactEmail);
    cy.get('#payment-terms').type(paymentTerms);
    cy.get('.save-button').click();
    cy.contains('Supplier added successfully').should('be.visible');
  });

  it('should verify the added supplier', () => {
    cy.get('.supplier-list').type(supplierName);
    cy.contains(supplierName).should('be.visible');
    cy.contains(supplierName).click();
    cy.get('.details').should('contain', contactEmail);
  });

  it('should edit the supplier email', () => {
    cy.get('.edit-button').click();
    cy.get('#contact-email').clear().type(updatedEmail);
    cy.get('.save-button').click();
    cy.contains('Email updated successfully').should('be.visible');
  });

  it('should verify the updated email', () => {
    cy.get('.details').should('contain', updatedEmail);
  });

  it('should remove the supplier', () => {
    cy.get('.remove-button').click();
    cy.contains('Supplier removed successfully').should('be.visible');
    cy.get('.supplier-list').type(supplierName);
    cy.contains(supplierName).should('not.exist');
  });

  after(() => {
    cy.logout();
  });
});