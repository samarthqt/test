describe('Return Flow for Eligible Achieve Access Code', () => {
  const orderId = '98765';
  const accessCode = 'ACH12345';
  const customerEmail = 'customer@example.com';
  
  beforeEach(() => {
    cy.visit('/login');
    cy.login(customerEmail, 'password'); // Assume a custom command for login
  });

  it('should initiate a return for an Achieve access code', () => {
    cy.get('#order-details').click();
    cy.contains(orderId).click();
    cy.contains('Initiate Return').click();
    cy.get('#return-form').within(() => {
      cy.get('input[name="reason"]').type('No longer needed');
      cy.get('button[type="submit"]').click();
    });
    cy.contains('Return request submitted successfully').should('be.visible');
    cy.verifyRefundProcessedByBraintree(); // Custom command to verify refund
    cy.checkEmailForConfirmation(customerEmail, 'Refund Confirmation');
    cy.verifyOrderDetailsInCXEmail(orderId);
    cy.checkCXSystemForReturnRequest(orderId);
    cy.verifyAccessRevokedIfRedeemed(accessCode);
    cy.verifyAccessCodeZeroedIfNotRedeemed(accessCode);
    cy.ensureAccessCodeCannotBeUsedPostRefund(accessCode);
  });
});