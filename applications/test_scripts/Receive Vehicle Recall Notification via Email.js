describe('Vehicle Recall Notification via Email', () => {
  const vin = '1HGCM82633A004352';
  const email = 'user@example.com';

  before(() => {
    cy.visit('/login');
    cy.login('username', 'password');
  });

  it('Marks vehicle for recall', () => {
    cy.visit(`/vehicles/${vin}/recall`);
    cy.get('#markRecall').click();
    cy.contains('Vehicle is marked for recall successfully').should('be.visible');
  });

  it('Triggers recall notification', () => {
    cy.visit('/recall/trigger');
    cy.get('#triggerRecall').click();
    cy.contains('Recall notification process is triggered successfully').should('be.visible');
  });

  it('Checks email for recall notification', () => {
    cy.visit('/email');
    cy.get('#emailSearch').type(email);
    cy.get('#searchButton').click();
    cy.contains('Vehicle recall notification').should('be.visible');
  });

  after(() => {
    cy.logout();
  });
});