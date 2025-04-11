class ProductCatalogPage {
  navigateToPage(pageName) {
    cy.visit(`/${pageName}`);
  }

  enterProductDetails(details) {
    cy.get('#productName').type(details.name);
    cy.get('#productDescription').type(details.description);
    cy.get('#productPrice').type(details.price);
    cy.get('#productImage').attachFile(details.image);
    cy.get('#productStock').select(details.stock);
    cy.get('#productCategory').select(details.category);
  }

  submitProductDetails() {
    cy.get('#submitProduct').click();
  }

  verifyProductAdded(productName) {
    cy.contains(productName).should('exist');
  }

  verifyNotification(message) {
    cy.get('.notification').should('contain', message);
  }

  verifyChangesSaved() {
    cy.get('.save-status').should('contain', 'Changes saved');
  }

  updateProductDetails(details) {
    cy.get('#productName').clear().type(details.name);
    cy.get('#productDescription').clear().type(details.description);
    cy.get('#productPrice').clear().type(details.price);
    cy.get('#productImage').attachFile(details.image);
    cy.get('#productStock').select(details.stock);
    cy.get('#productCategory').select(details.category);
  }

  verifyProductUpdated(productName) {
    cy.contains(productName).should('exist');
  }

  confirmDeletion() {
    cy.get('#confirmDelete').click();
  }

  verifyProductRemoved(productName) {
    cy.contains(productName).should('not.exist');
  }

  enterInvalidProductDetails() {
    cy.get('#productName').type('');
    cy.get('#productDescription').type('');
    cy.get('#productPrice').type('invalid');
    cy.get('#productImage').attachFile('invalid/path');
    cy.get('#productStock').select('');
    cy.get('#productCategory').select('');
  }

  verifyErrorMessage(message) {
    cy.get('.error-message').should('contain', message);
  }

  verifyProductNotAdded() {
    cy.get('.product-list').should('not.contain', 'Invalid Product');
  }
}

export default ProductCatalogPage;