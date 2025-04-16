describe('TC-531 397 Property Viewing Scheduling', () => {
  const tenantName = 'John Doe';
  const propertyId = '12345';
  const availableSlot = '10:00 AM, 15th Nov 2023';

  before(() => {
    cy.login(tenantName);
  });

  it('should navigate to Property Management module', () => {
    cy.visit('/property-management');
    cy.get('.dashboard').should('be.visible');
  });

  it('should select Viewings from the sub-module menu', () => {
    cy.get('.menu-viewings').click();
    cy.get('.viewing-scheduling-interface').should('be.visible');
  });

  it('should search for Property ID 12345', () => {
    cy.get('.search-input').type(propertyId);
    cy.get('.search-button').click();
    cy.get('.property-details').should('contain', propertyId);
  });

  it('should select the available slot', () => {
    cy.get('.available-slot').contains(availableSlot).click();
    cy.get('.selected-slot').should('contain', availableSlot);
  });

  it('should book the viewing', () => {
    cy.get('.book-viewing-button').click();
    cy.get('.confirmation-message').should('contain', 'Viewing booked successfully');
  });

  it('should navigate to My Viewings', () => {
    cy.get('.menu-my-viewings').click();
    cy.get('.scheduled-viewings').should('contain', availableSlot);
  });

  it('should verify email notification', () => {
    cy.checkEmailNotification('Viewing booked successfully');
  });

  it('should attempt to book the same slot again', () => {
    cy.get('.available-slot').contains(availableSlot).click();
    cy.get('.book-viewing-button').click();
    cy.get('.error-message').should('contain', 'Slot already booked');
  });

  after(() => {
    cy.logout();
  });
});