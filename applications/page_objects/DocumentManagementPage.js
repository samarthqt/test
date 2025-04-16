class DocumentManagementPage {
  navigate() {
    cy.visit('/document-management');
  }

  selectProperty(propertyAddress) {
    cy.get('.property-listing').contains(propertyAddress).click();
  }

  clickUploadDocuments() {
    cy.get('#upload-documents-btn').click();
  }

  uploadDocument(documentName) {
    cy.get('input[type=file]').attachFile(documentName);
    cy.get('#upload-confirm-btn').click();
  }

  verifyDocumentsListed(documents) {
    documents.forEach(doc => {
      cy.get('.document-list').should('contain', doc);
    });
  }

  checkDocumentSecuritySettings() {
    cy.get('.document-security').should('contain', 'Securely Stored');
  }

  downloadDocument(documentName) {
    cy.get(`.download-link[data-document-name="${documentName}"]`).click();
  }
}