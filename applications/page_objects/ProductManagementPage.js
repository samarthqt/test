class ProductManagementPage {
  navigateToProductManagement() {
    cy.get('.product-management-menu').click();
  }

  selectBulkUpload() {
    cy.get('.bulk-upload-option').click();
  }

  uploadFile(fileName) {
    cy.get('input[type="file"]').attachFile(fileName);
  }

  validateFile() {
    cy.get('.validate-button').click();
  }

  checkValidationResults() {
    cy.get('.validation-results').should('contain', 'No errors');
  }

  uploadProducts() {
    cy.get('.upload-button').click();
  }

  verifyUploadedProducts() {
    cy.get('.product-catalog').should('contain', 'Test Product');
  }

  checkForErrorMessages() {
    cy.get('.error-messages').should('not.exist');
  }

  checkValidationErrors() {
    cy.get('.validation-results').should('contain', 'Errors found');
  }
}