describe('Secure Health Record Sharing', () => {
  const patientId = '12345';
  const healthRecordId = 'HR67890';
  const providerEmail = 'provider@example.com';

  before(() => {
    cy.visit('/login');
    cy.login(patientId, 'validPassword');
  });

  it('should navigate to Health Records section', () => {
    cy.get('.nav-health-records').click();
    cy.url().should('include', '/health-records');
    cy.get('.health-records-list').should('be.visible');
  });

  it('should select a health record to share', () => {
    cy.get(`[data-record-id="${healthRecordId}"]`).click();
    cy.get('.record-details').should('be.visible');
  });

  it('should share health record securely', () => {
    cy.get('.btn-share-record').click();
    cy.get('.share-dialog').should('be.visible');
    cy.get('.share-email-input').type(providerEmail);
    cy.get('.share-securely-option').check();
    cy.get('.btn-send').click();
    cy.get('.confirmation-message').should('contain', 'shared securely');
  });

  it('should verify email notification is sent', () => {
    // This step requires integration with email service or mock
    cy.verifyEmailSent(providerEmail, healthRecordId);
  });

  after(() => {
    cy.logout();
  });
});