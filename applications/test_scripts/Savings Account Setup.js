describe('Savings Account Setup Test', () => {
  const loginPage = new LoginPage();
  const accountManagementPage = new AccountManagementPage();
  const savingsAccountPage = new SavingsAccountPage();
  const automaticTransfersPage = new AutomaticTransfersPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the banking application', () => {
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/dashboard');
  });

  it('should navigate to Savings Account section', () => {
    accountManagementPage.navigateToSavingsAccount();
    cy.contains('Apply for a New Savings Account').should('be.visible');
  });

  it('should apply for a new savings account', () => {
    savingsAccountPage.applyForNewAccount(1000);
    cy.contains('Application Form').should('be.visible');
  });

  it('should submit the application', () => {
    savingsAccountPage.submitApplication();
    cy.contains('Application submitted successfully').should('be.visible');
  });

  it('should receive account approval notification', () => {
    savingsAccountPage.checkApprovalNotification();
    cy.contains('Account Approved').should('be.visible');
  });

  it('should setup automatic transfer', () => {
    automaticTransfersPage.setupTransfer(100, 'Monthly');
    cy.contains('Transfer setup successful').should('be.visible');
  });

  it('should verify scheduled transfer in transaction history', () => {
    automaticTransfersPage.verifyTransferInHistory();
    cy.contains('Scheduled Transfer').should('be.visible');
  });

  it('should log out and verify account status', () => {
    loginPage.logout();
    cy.url().should('include', '/login');
    loginPage.login('validUser', 'validPassword');
    cy.url().should('include', '/dashboard');
    accountManagementPage.verifySavingsAccountStatus();
    cy.contains('Active Savings Account').should('be.visible');
  });

  it('should verify first automatic transfer execution', () => {
    automaticTransfersPage.verifyFirstTransferExecution();
    cy.contains('Transfer executed successfully').should('be.visible');
  });

  it('should verify account balance updates', () => {
    accountManagementPage.verifyAccountBalances();
    cy.contains('Balance updated accurately').should('be.visible');
  });
});