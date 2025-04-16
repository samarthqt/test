describe('Spending Limits Setup and Validation', () => {
  const loginPage = new LoginPage();
  const dashboardPage = new DashboardPage();
  const cardManagementPage = new CardManagementPage();
  const transactionPage = new TransactionPage();

  before(() => {
    cy.visit('/');
  });

  it('should log into the user account', () => {
    loginPage.login('user@example.com', 'password123');
    dashboardPage.verifyLoginSuccess();
  });

  it('should navigate to Card Management section', () => {
    dashboardPage.goToCardManagement();
    cardManagementPage.verifyCardManagementDisplayed();
  });

  it('should select the card and set a daily spending limit', () => {
    cardManagementPage.selectCard('1234567890123456');
    cardManagementPage.clickSetSpendingLimit();
    cardManagementPage.setDailyLimit(500);
    cardManagementPage.confirmSpendingLimit();
  });

  it('should decline transaction exceeding daily limit', () => {
    transactionPage.attemptTransaction(600);
    transactionPage.verifyTransactionDeclined();
  });

  it('should process transaction within daily limit', () => {
    transactionPage.attemptTransaction(300);
    transactionPage.verifyTransactionSuccess();
  });

  after(() => {
    dashboardPage.logout();
  });
});