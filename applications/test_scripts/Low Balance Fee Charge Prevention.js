describe('Low Balance Fee Charge Prevention', () => {
  const userAccount = new UserAccountPage();

  before(() => {
    cy.visit('/login');
    userAccount.login('123456');
  });

  it('should display user dashboard with current balance', () => {
    userAccount.verifyDashboardDisplayed();
    userAccount.verifyCurrentBalance('$15');
  });

  it('should perform a transaction keeping balance above $10', () => {
    userAccount.performTransaction('$5');
    userAccount.verifyBalanceAbove('$10');
  });

  it('should not receive low balance fee notification', () => {
    userAccount.verifyNoLowBalanceFeeNotification();
  });

  it('should verify account balance post-transaction', () => {
    userAccount.verifyBalancePostTransaction('$10');
  });

  after(() => {
    userAccount.logout();
    userAccount.verifyLogoutSuccessful();
  });
});