describe('Account Creation', () => {
  const userC = { name: 'User C', address: '123 Main St', phone: '555-1234', id: 'ID123' };
  const userD = { name: 'User D', address: '456 Elm St', phone: '555-5678', id: 'ID456' };

  beforeEach(() => {
    cy.visit('/account-creation');
  });

  it('should display account creation page', () => {
    cy.get('h1').should('contain', 'Account Creation');
  });

  it('should accept valid personal details for User C', () => {
    AccountCreationPage.enterPersonalDetails(userC);
    cy.get('.success-message').should('contain', 'Details accepted');
  });

  it('should accept valid personal details for User D', () => {
    AccountCreationPage.enterPersonalDetails(userD);
    cy.get('.success-message').should('contain', 'Details accepted');
  });

  it('should proceed with identity verification for User C', () => {
    AccountCreationPage.initiateIdentityVerification(userC);
    cy.get('.verification-message').should('contain', 'Verification in progress');
  });

  it('should proceed with identity verification for User D', () => {
    AccountCreationPage.initiateIdentityVerification(userD);
    cy.get('.verification-message').should('contain', 'Verification in progress');
  });

  it('should create account for User C', () => {
    AccountCreationPage.completeAccountCreation(userC);
    cy.get('.confirmation-message').should('contain', 'Account created successfully');
  });

  it('should create account for User D', () => {
    AccountCreationPage.completeAccountCreation(userD);
    cy.get('.confirmation-message').should('contain', 'Account created successfully');
  });

  it('should reject invalid personal details for User C', () => {
    AccountCreationPage.enterPersonalDetails({ name: '', address: '', phone: '', id: '' });
    cy.get('.error-message').should('contain', 'Invalid details');
  });

  it('should reject invalid personal details for User D', () => {
    AccountCreationPage.enterPersonalDetails({ name: '', address: '', phone: '', id: '' });
    cy.get('.error-message').should('contain', 'Invalid details');
  });

  it('should prevent account creation without identity verification for User C', () => {
    AccountCreationPage.completeAccountCreationWithoutVerification(userC);
    cy.get('.error-message').should('contain', 'Verification required');
  });

  it('should prevent account creation without identity verification for User D', () => {
    AccountCreationPage.completeAccountCreationWithoutVerification(userD);
    cy.get('.error-message').should('contain', 'Verification required');
  });

  it('should remain functional during peak periods', () => {
    AccountCreationPage.simulatePeakLoad();
    cy.get('.status-message').should('contain', 'System operational');
  });

  it('should prevent duplicate account creation for User C', () => {
    AccountCreationPage.attemptDuplicateAccountCreation(userC);
    cy.get('.error-message').should('contain', 'Duplicate account');
  });
});