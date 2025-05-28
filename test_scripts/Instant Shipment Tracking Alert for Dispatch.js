describe('Instant Shipment Tracking Alert for Dispatch', () => {
  const orderId = '12345';
  const customerEmail = 'customer@example.com';

  before(() => {
    cy.login('validUsername', 'validPassword');
  });

  it('should navigate to Orders module', () => {
    cy.visit('/orders');
    cy.contains('Orders').should('be.visible');
  });

  it('should select the order with ID 12345', () => {
    cy.get(`[data-order-id="${orderId}"]`).click();
    cy.contains(`Order ID: ${orderId}`).should('be.visible');
  });

  it('should update the shipment status to Dispatched', () => {
    cy.get('#shipmentStatus').select('Dispatched');
    cy.contains('Shipment status updated to Dispatched').should('be.visible');
  });

  it('should check the alert system for outgoing alerts', () => {
    cy.get('#alertSystem').click();
    cy.contains(`Alert sent to ${customerEmail}`).should('be.visible');
  });

  it('should verify the alert received by the customer', () => {
    cy.checkEmail(customerEmail).then(email => {
      expect(email).to.include('Your shipment has been dispatched.');
    });
  });
});

Cypress.Commands.add('login', (username, password) => {
  cy.visit('/login');
  cy.get('#username').type(username);
  cy.get('#password').type(password);
  cy.get('#loginButton').click();
  cy.contains('Dashboard').should('be.visible');
});

Cypress.Commands.add('checkEmail', (email) => {
  // Mock function to simulate checking email
  return cy.wrap('Email content: Your shipment has been dispatched.');
});