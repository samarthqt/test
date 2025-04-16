describe('TC-741 Vehicle Age Notification Failure', () => {
  const vehicleId = 'V12345';

  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  it('should navigate to Vehicle Profiles section', () => {
    cy.get('#vehicleProfiles').click();
    cy.url().should('include', '/vehicle-profiles');
  });

  it(`should select the vehicle with ID ${vehicleId}`, () => {
    cy.get(`#vehicle-${vehicleId}`).click();
    cy.get('.vehicle-details').should('contain', 'Vehicle Age: 5 years');
  });

  it('should ensure notification settings are disabled', () => {
    cy.get('#notificationSettings').should('not.be.checked');
  });

  it('should simulate vehicle reaching 5 years of age', () => {
    cy.simulateVehicleAge(vehicleId, 5);
    cy.get('#notificationCenter').should('not.contain', 'Vehicle Age Alert');
  });

  it('should verify system logs for notification failure', () => {
    cy.checkSystemLogs().should('not.contain', 'Notification Failure');
  });

  after(() => {
    cy.logout();
  });
});