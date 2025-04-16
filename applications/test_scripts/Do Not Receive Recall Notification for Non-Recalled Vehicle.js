describe('Do Not Receive Recall Notification for Non-Recalled Vehicle', () => {
  const vin = '1HGCM82633A004352';
  const email = 'user@example.com';

  before(() => {
    cy.visit('/login');
    cy.login(email);
  });

  it('Ensure vehicle is not marked for recall', () => {
    cy.visit(`/vehicle/${vin}`);
    cy.get('.recall-status').should('contain', 'No Recall');
  });

  it('Trigger recall notification process', () => {
    cy.visit('/admin/trigger-recall');
    cy.triggerRecallNotification(vin);
    cy.get('.notification-status').should('contain', 'Triggered Successfully');
  });

  it('Check user email for recall notification', () => {
    cy.visit('/email/inbox');
    cy.get('.email-list').should('not.contain', 'Recall Notification');
  });

  after(() => {
    cy.logout();
  });
});