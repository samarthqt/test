describe('Online Payment via Bank Transfer', () => {
  const tenantPortal = new TenantPortal();

  before(() => {
    cy.visit('/login');
    tenantPortal.login('tenant@example.com', 'password123');
  });

  it('should navigate to Payments section', () => {
    tenantPortal.goToPayments();
    cy.url().should('include', '/payments');
  });

  it('should select Bank Transfer as payment method', () => {
    tenantPortal.selectBankTransfer();
    cy.get('#bank-transfer-form').should('be.visible');
  });

  it('should enter bank account details', () => {
    tenantPortal.enterBankDetails('9876543210', '110000000');
    cy.get('#account-number').should('have.value', '9876543210');
    cy.get('#routing-number').should('have.value', '110000000');
  });

  it('should enter rent amount', () => {
    tenantPortal.enterRentAmount('1000');
    cy.get('#rent-amount').should('have.value', '1000');
  });

  it('should process the payment', () => {
    tenantPortal.payNow();
    cy.get('.confirmation-message').should('contain', 'Payment successful');
  });

  it('should verify transaction in payment history', () => {
    tenantPortal.verifyPaymentHistory();
    cy.get('.payment-history').should('contain', '1000');
  });

  it('should check email for payment confirmation', () => {
    cy.wait(5000); // Wait for email to be received
    tenantPortal.checkEmailConfirmation();
    cy.get('.email-confirmation').should('contain', 'Payment of $1000');
  });
});