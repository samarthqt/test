describe('Return Flow for Eligible Achieve Access Code', () => {
  const orderId = '98765';
  const accessCode = 'ACH12345';
  const customerEmail = 'customer@example.com';

  before(() => {
    cy.visit('/login');
    cy.login(customerEmail, 'customerPassword');
  });

  it('should display the customer dashboard after login', () => {
    cy.get('.account-dashboard').should('be.visible');
  });

  it('should navigate to Order Details section', () => {
    cy.get('#order-details-link').click();
    cy.get('.order-list').should('be.visible');
  });

  it('should select the order with ID 98765', () => {
    cy.get(`.order-item[data-order-id="${orderId}"]`).click();
    cy.get('.order-details').should('contain', orderId);
  });

  it('should initiate return for Achieve access code', () => {
    cy.get(`.access-code[data-access-code="${accessCode}"]`).within(() => {
      cy.get('.initiate-return-button').click();
    });
    cy.get('.return-form').should('be.visible');
  });

  it('should complete and submit the return form', () => {
    cy.get('#return-form').within(() => {
      cy.get('input[name="reason"]').type('No longer needed');
      cy.get('button[type="submit"]').click();
    });
    cy.get('.return-confirmation').should('contain', 'Return request submitted successfully');
  });

  it('should verify the refund is processed by Braintree', () => {
    cy.get('.refund-status').should('contain', 'Processed');
  });

  it('should check the customer's email for confirmation', () => {
    cy.checkEmail(customerEmail).should('contain', 'Refund Confirmation');
  });

  it('should verify order details in daily return request email to CX', () => {
    cy.checkCXEmail().should('contain', orderId);
  });

  it('should check the CX system for the return request', () => {
    cy.checkCXSystem(orderId).should('contain', 'Return request received');
  });

  it('should verify access to Achieve course is revoked', () => {
    cy.checkAccessRevoked(accessCode).should('be.true');
  });

  it('should verify the access code is zeroed out if not redeemed', () => {
    cy.checkAccessCodeZeroed(accessCode).should('be.true');
  });

  it('should ensure the access code cannot be used post-refund', () => {
    cy.checkAccessCodeInvalid(accessCode).should('be.true');
  });
});
