describe('Document Upload for Property Listings', () => {
  const documentManagementPage = new DocumentManagementPage();

  before(() => {
    cy.login('john.doe@example.com', 'password'); // Assume login command is defined
  });

  it('Should upload and securely store property documents', () => {
    documentManagementPage.navigate();
    documentManagementPage.selectProperty('123 Main St, Springfield');
    documentManagementPage.clickUploadDocuments();
    documentManagementPage.uploadDocument('Ownership Proof.pdf');
    documentManagementPage.uploadDocument('Legal Document.pdf');
    documentManagementPage.verifyDocumentsListed(['Ownership Proof.pdf', 'Legal Document.pdf']);
    documentManagementPage.checkDocumentSecuritySettings();
    documentManagementPage.downloadDocument('Ownership Proof.pdf');
    documentManagementPage.downloadDocument('Legal Document.pdf');
  });

  after(() => {
    cy.logout(); // Assume logout command is defined
  });
});