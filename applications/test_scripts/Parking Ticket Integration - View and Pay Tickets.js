describe('Parking Ticket Integration - View and Pay Tickets', () => {
  beforeEach(() => {
    cy.login();
    cy.visit('/dashboard');
  });

  it('should navigate to the parking ticket section and display outstanding tickets', () => {
    cy.get('.main-menu').contains('Parking Tickets').click();
    cy.url().should('include', '/parking-tickets');
    cy.get('.ticket-list').should('be.visible');
  });

  it('should display details of a selected parking ticket', () => {
    cy.get('.ticket-list .ticket-item').first().click();
    cy.get('.ticket-details').should('be.visible');
  });

  it('should display the total amount due for a selected ticket', () => {
    cy.get('.ticket-details .total-amount').should('contain', '$');
  });

  it('should allow the user to pay a ticket', () => {
    cy.get('.ticket-details .pay-ticket').click();
    cy.get('.payment-options').should('be.visible');
    cy.get('.payment-options .credit-card-option').click();
    cy.get('.payment-form').within(() => {
      cy.get('input[name="cardNumber"]').type('4111111111111111');
      cy.get('input[name="expiryDate"]').type('12/25');
      cy.get('input[name="cvv"]').type('123');
      cy.get('button[type="submit"]').click();
    });
    cy.get('.confirmation-message').should('contain', 'Payment successful');
  });

  it('should update the ticket status to paid', () => {
    cy.get('.ticket-list .ticket-item.paid').should('be.visible');
  });

  it('should display a message for no outstanding tickets', () => {
    cy.get('.no-tickets-message').should('contain', 'No outstanding tickets');
  });

  it('should handle errors for incorrect payment details', () => {
    cy.get('.ticket-details .pay-ticket').click();
    cy.get('.payment-options .credit-card-option').click();
    cy.get('.payment-form').within(() => {
      cy.get('input[name="cardNumber"]').type('1234567890123456');
      cy.get('button[type="submit"]').click();
    });
    cy.get('.error-message').should('contain', 'Invalid card details');
  });

  it('should reject expired payment methods', () => {
    cy.get('.payment-form').within(() => {
      cy.get('input[name="expiryDate"]').type('01/20');
      cy.get('button[type="submit"]').click();
    });
    cy.get('.error-message').should('contain', 'Expired card');
  });

  it('should handle payment failures due to network issues', () => {
    cy.intercept('POST', '/api/payments', {
      forceNetworkError: true
    }).as('paymentRequest');
    cy.get('.payment-form button[type="submit"]').click();
    cy.wait('@paymentRequest');
    cy.get('.failure-notification').should('contain', 'Payment failed');
  });

  it('should send an email confirmation for successful payments', () => {
    cy.get('.email-confirmation').should('contain', 'Payment confirmation sent');
  });

  it('should allow users to download a receipt for paid tickets', () => {
    cy.get('.download-receipt').should('be.visible').click();
    cy.verifyDownload('receipt.pdf');
  });

  it('should maintain functionality across different devices', () => {
    cy.viewport('iphone-6');
    cy.visit('/parking-tickets');
    cy.get('.ticket-list').should('be.visible');
  });

  it('should display a history of paid tickets', () => {
    cy.get('.paid-tickets-history').should('be.visible');
  });

  it('should securely handle sensitive payment information', () => {
    cy.get('.payment-form').within(() => {
      cy.get('input[name="cardNumber"]').should('not.have.value');
    });
  });
});