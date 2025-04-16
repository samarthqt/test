describe('Request for Property Information Submission', () => {
  const propertyId = '12345';
  const userId = 'user_001';
  const requestDetails = 'Interested in scheduling a visit';
  const invalidPropertyId = '99999';

  beforeEach(() => {
    cy.login(userId);
    cy.visit(`/property/${propertyId}`);
  });

  it('should allow a registered user to request property information', () => {
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.requestTypeSelect).select('Visit');
    cy.get(RequestFormPage.requestDetailsInput).type(requestDetails);
    cy.get(RequestFormPage.submitButton).click();
    cy.get(RequestFormPage.confirmationMessage).should('be.visible');
    cy.checkAdminNotification(propertyId, userId);
    cy.verifyRequestStatus(userId, propertyId, 'Submitted');
    cy.checkEmailConfirmation(userId, propertyId);
  });

  it('should display error for invalid property ID', () => {
    cy.visit(`/property/${invalidPropertyId}`);
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.errorMessage).should('contain', 'Invalid property ID');
  });

  it('should display error for missing request type', () => {
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.submitButton).click();
    cy.get(RequestFormPage.errorMessage).should('contain', 'Request type is required');
  });

  it('should display error for missing request details', () => {
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.requestTypeSelect).select('Visit');
    cy.get(RequestFormPage.submitButton).click();
    cy.get(RequestFormPage.errorMessage).should('contain', 'Request details are required');
  });

  it('should prompt login for unauthenticated users', () => {
    cy.logout();
    cy.visit(`/property/${propertyId}`);
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(LoginPage.loginPrompt).should('be.visible');
  });

  it('should prevent duplicate requests', () => {
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.requestTypeSelect).select('Visit');
    cy.get(RequestFormPage.requestDetailsInput).type(requestDetails);
    cy.get(RequestFormPage.submitButton).click();
    cy.get(RequestFormPage.confirmationMessage).should('be.visible');
    cy.get(PropertyDetailPage.requestInfoButton).click();
    cy.get(RequestFormPage.errorMessage).should('contain', 'Duplicate request');
  });

  it('should verify correct admin notification', () => {
    cy.checkAdminNotification(propertyId, userId);
  });

  it('should verify correct email confirmation', () => {
    cy.checkEmailConfirmation(userId, propertyId);
  });
});