describe('Peer-to-Peer Lending Platform', () => {
  it('User registration as lender or borrower', () => {
    cy.visit('/registration');
    cy.get('select#role').select('lender');
    cy.get('input[name="username"]').type('validUsername');
    cy.get('input[name="password"]').type('validPassword');
    cy.get('button[type="submit"]').click();
    cy.contains('Registration successful').should('be.visible');
  });

  it('Security measures for user data and transactions', () => {
    cy.login('user', 'password');
    cy.get('button#performTransaction').click();
    cy.contains('Transaction encrypted').should('be.visible');
    cy.contains('User data protected').should('be.visible');
  });

  it('Risk assessment tool for lenders', () => {
    cy.login('lender', 'password');
    cy.visit('/risk-assessment');
    cy.contains('Evaluate potential borrowers').should('be.visible');
    cy.contains('Risk assessment details').should('be.visible');
  });

  it('Compliance with regulatory requirements', () => {
    cy.visit('/');
    cy.get('button#engageActivities').click();
    cy.contains('Comply with regulatory requirements').should('be.visible');
  });

  it('Notification of successful loan transactions and repayments', () => {
    cy.completeTransaction();
    cy.contains('Transaction successful').should('be.visible');
    cy.contains('Notification received').should('be.visible');
  });

  it('Handling loan application errors', () => {
    cy.visit('/loan-application');
    cy.get('button#submitApplication').click();
    cy.contains('Error occurred').should('be.visible');
    cy.contains('Issue informed').should('be.visible');
  });

  it('Secure communication between lenders and borrowers', () => {
    cy.login('lender', 'password');
    cy.visit('/communication');
    cy.get('button#exchangeMessages').click();
    cy.contains('Communication secure').should('be.visible');
    cy.contains('Messages protected').should('be.visible');
  });

  it('Providing detailed loan records and repayment schedules', () => {
    cy.login('user', 'password');
    cy.visit('/loan-details');
    cy.contains('Detailed loan records').should('be.visible');
    cy.contains('Clear repayment schedule').should('be.visible');
  });

  it('User-friendly platform accessibility', () => {
    cy.visit('/');
    cy.contains('User-friendly platform').should('be.visible');
    cy.contains('Accessible on desktop and mobile').should('be.visible');
  });
});