describe('Card Lock/Unlock Functionality', () => {
  const userAccountId = '12345';
  const cardNumber = '9876543210123456';
  
  before(() => {
    cy.visit('/login');
    cy.get('#username').type('validUsername');
    cy.get('#password').type('validPassword');
    cy.get('#loginButton').click();
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Card Management section', () => {
    cy.get('#cardManagementMenu').click();
    cy.url().should('include', '/card-management');
    cy.contains('Card Management').should('be.visible');
  });

  it('should select the card and lock it', () => {
    cy.get(`#card-${cardNumber}`).click();
    cy.contains('Card Status: Active').should('be.visible');
    cy.get('#lockCardButton').click();
    cy.contains('Are you sure you want to lock this card?').should('be.visible');
    cy.get('#confirmLockButton').click();
    cy.contains('Card Status: Locked').should('be.visible');
  });

  it('should attempt a transaction with locked card and fail', () => {
    cy.visit('/transaction');
    cy.get('#cardNumber').type(cardNumber);
    cy.get('#amount').type('100');
    cy.get('#submitTransaction').click();
    cy.contains('Transaction Declined').should('be.visible');
  });

  it('should unlock the card', () => {
    cy.get('#cardManagementMenu').click();
    cy.get(`#card-${cardNumber}`).click();
    cy.contains('Card Status: Locked').should('be.visible');
    cy.get('#unlockCardButton').click();
    cy.contains('Are you sure you want to unlock this card?').should('be.visible');
    cy.get('#confirmUnlockButton').click();
    cy.contains('Card Status: Active').should('be.visible');
  });

  it('should attempt a transaction with unlocked card and succeed', () => {
    cy.visit('/transaction');
    cy.get('#cardNumber').type(cardNumber);
    cy.get('#amount').type('100');
    cy.get('#submitTransaction').click();
    cy.contains('Transaction Successful').should('be.visible');
  });

  after(() => {
    cy.get('#logoutButton').click();
    cy.url().should('include', '/login');
  });
});